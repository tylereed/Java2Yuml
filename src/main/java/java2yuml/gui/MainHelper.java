package java2yuml.gui;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
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
public class MainHelper extends Application {

	private Stage primaryStage;
	private Parent rootLayout;

	public MainHelper() {
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Java2Yuml");

		initRootLayout();
	}

	public void initRootLayout() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainHelper.class.getResource("/app.fxml"));
			rootLayout = loader.load();

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			throw new RuntimeException("Unable to load app.fxml", e);
		}
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

}
