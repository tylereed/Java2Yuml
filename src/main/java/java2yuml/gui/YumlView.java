package java2yuml.gui;

import java.io.File;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import java2yuml.Declaration;
import java2yuml.listeners.classHierarchy.ClassHierarchyListener;
import java2yuml.services.FolderWalker;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.stage.DirectoryChooser;
import javafx.util.StringConverter;

@Component
public class YumlView implements FxmlView<YumlViewModel> {

	@FXML
	private CheckBox chkClasses, chkInterfaces, chkEnums;

	@FXML
	private ListView<Declaration> lstClasses;

	@FXML
	private CheckBox chkAncestors, chkDescendants;

	@FXML
	private TextArea txtClasses;

	@FXML
	private Node pnlSpinner;

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
		chkDescendants.selectedProperty().bindBidirectional(yuml.showDescendentsProperty());

		txtClasses.textProperty().bindBidirectional(yuml.selectedClassesProperty(), new StringConverter<>() {

			@Override
			public String toString(ObservableList<Declaration> declarations) {
				return declarations.stream().map(d -> d.toYuml()).collect(Collectors.joining("\n"));
			}

			@Override
			public ObservableList<Declaration> fromString(String string) {
				throw new UnsupportedOperationException();
			}
		});

		pnlSpinner.visibleProperty().bind(yuml.loadingProperty());
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
			yuml.setLoading(true);
			System.out.println(pnlSpinner.isVisible());
			loadFolder(selectedFile).thenAccept(d -> yuml.setAllClasses(d))
					.whenComplete((v, e) -> yuml.setLoading(false));
			System.out.println(pnlSpinner.isVisible());
		}

	}

	@Async
	protected CompletableFuture<List<Declaration>> loadFolder(File selectedFile) {
		Path selectedPath = selectedFile.toPath();
		var listener = new ClassHierarchyListener();
		FolderWalker.walkFolder(selectedPath, listener);
		return CompletableFuture.completedFuture(listener.getDeclarations());
	}

}
