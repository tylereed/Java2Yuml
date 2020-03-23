package java2yuml.gui;

import java.util.Collection;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import de.saxsys.mvvmfx.ViewModel;
import java2yuml.Declaration;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;

@Component
public class YumlViewModel implements ViewModel {

	private BooleanProperty showClasses, showInterfaces, showEnums;

	private ObservableList<Declaration> allClassesList;

	private FilteredList<Declaration> filteredClassesList;

	private ListProperty<Declaration> selectedClassesList;

	private BooleanProperty showAncestors, showDescendents;

	public YumlViewModel() {
		showClasses = new SimpleBooleanProperty(true);
		showInterfaces = new SimpleBooleanProperty(true);
		showEnums = new SimpleBooleanProperty(true);

		allClassesList = FXCollections.observableArrayList();
		filteredClassesList = new FilteredList<Declaration>(allClassesList);
		selectedClassesList = new SimpleListProperty<>(FXCollections.observableArrayList());

		showAncestors = new SimpleBooleanProperty();
		showDescendents = new SimpleBooleanProperty();
		initBindings();
	}

	private void initBindings() {
		ChangeListener<Boolean> listener = this::updateFilter;

		showClasses.addListener(listener);
		showInterfaces.addListener(listener);
		showEnums.addListener(listener);
	}

	private void updateFilter(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
		Predicate<Declaration> filter = d -> {
			switch (d.getType()) {
			case CLASS:
				return showClasses.get();
			case INTERFACE:
				return showInterfaces.get();
			case ENUM:
				return showEnums.get();
			}
			return true;
		};

		filteredClassesList.setPredicate(filter);
	}

	public BooleanProperty showClassesProperty() {
		return showClasses;
	}

	public BooleanProperty showInterfacesProperty() {
		return showInterfaces;
	}

	public BooleanProperty showEnumsProperty() {
		return showEnums;
	}

	public void setAllClasses(Collection<? extends Declaration> values) {
		allClassesList.setAll(values);
	}

	public ObservableList<Declaration> getFilteredClasses() {
		return filteredClassesList;
	}

	public ObservableList<Declaration> getSelectedClasses() {
		return selectedClassesList;
	}

	public ListProperty<Declaration> selectedClassesProperty() {
		return selectedClassesList;
	}

	public BooleanProperty showAncestorsProperty() {
		return showAncestors;
	}

	public BooleanProperty showDescendentsProperty() {
		return showDescendents;
	}

}
