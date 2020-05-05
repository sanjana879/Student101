import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Directions extends Application {
	
	public static void main(String[] args)
	{
		launch(args);
	}
	
	Label line1;
	Label line2;
	Label line3;
	Label line4;
	Label line5;
	Label line6;
	Label line7;
	Label line8;
	Label line9;
	Label line10;
	Label line11;
	Label line12;
	public void start(Stage stage) throws Exception 
	{
		
		stage.setTitle("Directions");
		
		
		line1 = new Label("Choose a level that corresponds to each grade in high school.");
		line1.setTranslateX(40); 
		
		line2 = new Label("(Freshman is the easiest, while Senior is the hardest).");
		line2.setTranslateX(40); line2.setTranslateY(-35);
		
		line3 = new Label("Use the right and left arrows keys to direct the robot avatar to catch");
		line3.setTranslateX(40); line3.setTranslateY(-70);
		
		line4 = new Label("the falling assignments.");
		line4.setTranslateX(40); line4.setTranslateY(-105);
	
		line5 = new Label("The goal is to complete each assignment by catching them before they");
		line5.setTranslateX(40); line5.setTranslateY(-140);
		
		line6 = new Label("slip away.");
		line6.setTranslateX(40); line6.setTranslateY(-175);
		
		line7 = new Label("You must catch 80% of the assignments in order to win the level.");
		line7.setTranslateX(40); line7.setTranslateY(-210);
		
		line8 = new Label("(it will say how many you must catch per level)");
		line8.setTranslateX(40); line8.setTranslateY(-245);
		
		line9 = new Label("Once you have \"caught\" all of the necessary assignments, click the");
		line9.setTranslateX(40); line9.setTranslateY(-280);
		
		line10 = new Label("\"Finish Game\" button in order to receive your results.");
		line10.setTranslateX(40); line10.setTranslateY(-315);
		
		line11 = new Label("Try to make it past the four years of high school without dying!!");
		line11.setTranslateX(40); line11.setTranslateY(-350);
		
		line12 = new Label(" Good luck!");
		line12.setTranslateX(40); line12.setTranslateY(-385);
		
	
		VBox root = new VBox();
		root.getChildren().addAll(line1, line2, line3, line4, line5, line6, line7, line8, line9, line10, line11, line12);
		
		Scene scene = new Scene(root, 1500,800);
		stage.setScene(scene);
		scene.getStylesheets().add("direction.css");
		
		stage.show();
	
	}
		

}

