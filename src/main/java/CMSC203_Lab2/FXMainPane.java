package CMSC203_Lab2;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
	private DataManager dm;

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
		b1.setOnAction(new ButtonHandler());
		b2 = new Button("Howdy");
		b2.setOnAction(new ButtonHandler());
		b3 = new Button("Chinese");
		b3.setOnAction(new ButtonHandler());
		b4 = new Button("Clear");
		b4.setOnAction(new ButtonHandler());
		b5 = new Button("Exit");
		b5.setOnAction(new ButtonHandler());

		l1 = new Label("Feedback:");
		textField = new TextField("");

		//  instantiate the HBoxes
		hbox1 = new HBox();
		hbox2 = new HBox();

		//student Task #4:
		//  instantiate the DataManager instance
		dm = new DataManager();
		//  set margins and set alignment of the components
		Insets margins = new Insets(10,10,10,10);
		HBox.setMargin(b1, margins);
		HBox.setMargin(b2, margins);
		HBox.setMargin(b3, margins);
		HBox.setMargin(b4, margins);
		HBox.setMargin(b5, margins);
		HBox.setMargin(l1, margins);
		HBox.setMargin(textField, margins);
		// align
		hbox1.setAlignment(Pos.CENTER);
		hbox2.setAlignment(Pos.CENTER);

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
	public class ButtonHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			if(b1.equals(event.getTarget())) {
				textField.setText(dm.getHello());
			}
			else if(b2.equals(event.getTarget())) {
				textField.setText(dm.getHowdy());
			}
			else if(b3.equals(event.getTarget())) {
				textField.setText(dm.getChinese());
			}
			else if(b4.equals(event.getTarget())) {
				textField.setText("");
			}
			else if(b5.equals(event.getTarget())) {
				Platform.exit();
				System.exit(0);
			}
		}
	}
}
	
