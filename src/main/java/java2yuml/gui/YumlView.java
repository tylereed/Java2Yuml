package java2yuml.gui;

import java.io.File;
import java.nio.file.Path;

import org.springframework.stereotype.Component;

import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import java2yuml.Declaration;
import java2yuml.listeners.classHierarchy.ClassHierarchyListener;
import java2yuml.services.FolderWalker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.stage.DirectoryChooser;

@Component
public class YumlView implements FxmlView<YumlViewModel> {

	@FXML
	private CheckBox chkClasses, chkInterfaces, chkEnums;

	@FXML
	private ListView<Declaration> lstClasses;

	@FXML
	private CheckBox chkAncestors, chkDescendents;

	@FXML
	private TextArea txtClasses;

	@InjectViewModel
	private YumlViewModel yuml;

	@FXML
	private void initialize() {
		initBindings(yuml);
	}

	private void initBindings(YumlViewModel yuml) {
		chkClasses.selectedProperty().bindBidirectional(yuml.showClassesProperty());
		chkInterfaces.selectedProperty().bindBidirectional(yuml.showInterfacesProperty());
		chkEnums.selectedProperty().bindBidirectional(yuml.showEnumsProperty());

		lstClasses.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		lstClasses.setCellFactory(param -> createCell());
		lstClasses.setItems(yuml.getFilteredClasses());
		yuml.selectedClassesProperty().bindContentBidirectional(lstClasses.getSelectionModel().getSelectedItems());

		chkAncestors.selectedProperty().bindBidirectional(yuml.showAncestorsProperty());
		chkDescendents.selectedProperty().bindBidirectional(yuml.showDescendentsProperty());
	}

	private static ListCell<Declaration> createCell() {
		return new ListCell<>() {
			@Override
			protected void updateItem(Declaration item, boolean empty) {
				super.updateItem(item, empty);
				if (empty || item == null) {
					setText(null);
				} else {
					setText(item.getClassName());
				}
			}
		};
	}

	@FXML
	private void loadFolder(ActionEvent event) {
		DirectoryChooser chooser = new DirectoryChooser();

		File selectedFile = chooser.showDialog(null);
		if (selectedFile != null) {
			Path selectedPath = selectedFile.toPath();
			var listener = new ClassHierarchyListener();
			FolderWalker.walkFolder(selectedPath, listener);

			yuml.setAllClasses(listener.getDeclarations());
		}

	}

}
