package CMSC203_Lab2;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {

	//student Task #2:
	//  declare five buttons, a label, and a textfield
	private Button b1;
	private Button b2;
	private Button b3;
	private Button b4;
	private Button b5;
	private Label l1;
	private TextField textField;

	//  declare two HBoxes
	private HBox hbox1;
	private HBox hbox2;

	//student Task #4:
	//  declare an instance of DataManager

	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	FXMainPane() {
		//student Task #2:
		//  instantiate the buttons, label, and textfield
		b1 = new Button("Hello");
		b2 = new Button("Howdy");
		b3 = new Button("Chinese");
		b4 = new Button("Clear");
		b5 = new Button("Exit");
		l1 = new Label("Feedback:");
		textField = new TextField("");

		//  instantiate the HBoxes
		hbox1 = new HBox();
		hbox2 = new HBox();

		//student Task #4:
		//  instantiate the DataManager instance
		//  set margins and set alignment of the components
		
		//student Task #3:
		//  add the label and textfield to one of the HBoxes
		hbox2.getChildren().addAll(l1, textField);
		//  add the buttons to the other HBox
		hbox1.getChildren().addAll(b1,b2,b3,b4,b5);
		//  add the HBoxes to this FXMainPanel (a VBox)
		getChildren().addAll(hbox1, hbox2);
	}
	
	//Task #4:
	//  create a private inner class to handle the button clicks
}
	
