
/*
 * This  program prompt the user to choose the file, 
 * and read value and sort it, from 
 * largest to smallest.  
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class RecursiveJavaFX extends Application {

	ArrayList<Integer> lines = new ArrayList<Integer>();
	StringBuilder stringBuffer = new StringBuilder();
	FileChooser fileChooser = new FileChooser();

	Scanner scannerReader = null;
	BufferedReader bufferedReader = null;

	@Override
	public void start(Stage primaryStage) throws Exception {
		Button load, sort;
		HBox hbload, hbsort;
		Label outPutarea;
		TextArea textArea;
		/*
		 * set a Title at the Window
		 */
		primaryStage.setTitle("Recursive Reverse Sorting");
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));

		outPutarea = new Label("OutPut:");
		grid.add(outPutarea, 2, 5);
		textArea = new TextArea();
		textArea.setEditable(false);
		textArea.setPrefWidth(600);
		textArea.setPrefHeight(200);
		grid.add(textArea, 2, 6);

		load = new Button("Load");
		hbload = new HBox(10);
		hbload.getChildren().add(load);
		grid.add(hbload, 1, 1);

		sort = new Button("sort");
		hbsort = new HBox(30);
		hbsort.getChildren().add(sort);
		grid.add(hbsort, 2, 1);

		load.setOnAction(new EventHandler<ActionEvent>() {

			@Override

			public void handle(ActionEvent arg0) {

				// Set extension filter
				FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
				fileChooser.getExtensionFilters().add(extFilter);

				// Show save file dialog

				File file = fileChooser.showOpenDialog(primaryStage);

				if (file != null) {
					textArea.setText(readFile1(file));
				}
			}

			private String readFile1(File file) {

				try {

					bufferedReader = new BufferedReader(new FileReader(file));
					String text;

					while ((text = bufferedReader.readLine()) != null) {
						stringBuffer.append(text);
					}

				} catch (FileNotFoundException ex) {

					Logger.getLogger(RecursiveJavaFX.class.getName()).log(Level.SEVERE, null, ex);

				} catch (IOException ex) {

					Logger.getLogger(RecursiveJavaFX.class.getName()).log(Level.SEVERE, null, ex);

				} finally {

					try {
						bufferedReader.close();
					} catch (IOException ex) {
						Logger.getLogger(RecursiveJavaFX.class.getName()).log(Level.SEVERE, null, ex);
					}

				}

				return stringBuffer.toString();

			}

		});

		sort.setOnAction(new EventHandler<ActionEvent>() {

			@Override

			public void handle(ActionEvent arg0) {

				// Set extension filter
				FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
				fileChooser.getExtensionFilters().add(extFilter);

				// Show save file dialog

				File file = fileChooser.showOpenDialog(primaryStage);

				if (file != null) {

					textArea.setText(readFile2(file));

				}

			}

			private String readFile2(File file) {
				try {

					scannerReader = new Scanner(new FileReader(file));

					ArrayList<Integer> text = new ArrayList<Integer>();

					while (scannerReader.hasNext()) {

						text.add(scannerReader.nextInt());

						Recursive.bubbleSortList(text);

					}
					stringBuffer.append(text);

				} catch (FileNotFoundException ex) {

					Logger.getLogger(RecursiveJavaFX.class.getName()).log(Level.SEVERE, null, ex);

				} catch (IOException ex) {

					Logger.getLogger(RecursiveJavaFX.class.getName()).log(Level.SEVERE, null, ex);

				} finally {

					scannerReader.close();

				}
				return stringBuffer.toString();

			}

		});

		/*
		 * setting up the stage
		 */
		Scene scene = new Scene(grid, 800, 300);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
