package java2yuml.gui;

import javafx.application.Application;

/**
 * Main class, doesn't extend Application due to javafx11 issues with not being
 * modular
 * 
 * @author tyler
 */
public class Main {

	public static void main(String[] args) {
		Application.launch(MainHelper.class, args);
	}
}
