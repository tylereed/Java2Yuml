package java2yuml.gui;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.saxsys.mvvmfx.FluentViewLoader;
import de.saxsys.mvvmfx.spring.MvvmfxSpringApplication;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * I was getting issues loading javafx 11 without being modular, followed
 * example on this page
 * https://openjfx-dev.openjdk.java.narkive.com/aFiw9uqi/error-javafx-runtime-components-are-missing-and-are-required-to-run-this-application
 * 
 * @author tyler
 */
@SpringBootApplication
public class MainHelper extends MvvmfxSpringApplication {

	private Stage primaryStage;

	public MainHelper() {
	}

	@Override
	public void startMvvmfx(Stage stage) throws Exception {
		Parent root = FluentViewLoader.fxmlView(YumlView.class).load().getView();

		stage.setScene(new Scene(root));
		stage.show();

		primaryStage = stage;
		primaryStage.setTitle("Java2Yuml");
	}

}
