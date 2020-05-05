import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Play extends Application
{
	//creates the buttons that will direct the player to each level
	Button freshmanLev;
	Button sophLev;
	Button juniorLev;
	Button seniorLev;
	
	public static void main(String[] args) 
	{
		launch(args);
	}
	public void start(Stage stage) throws Exception 
	{
		
		//creates title, location, and size of the freshman button
		freshmanLev = new Button("Freshman");
		freshmanLev.setTranslateX(200); freshmanLev.setTranslateY(500); 	
		freshmanLev.setMinSize(200, 100);
		
		//tells program what to run when Freshman button is pressed
		freshmanLev.setOnAction(new EventHandler<ActionEvent> ()
		{
			public void handle(ActionEvent arg0)
			{
				//creates Freshman2 object that plays the Freshman start method and runs the game
				Freshman2 game = new Freshman2();
				try 
				{
					game.start(stage);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
		
		//creates title, location, and size of the sophomore button
		sophLev = new Button("Sophomore");
		sophLev.setTranslateX(500); 	sophLev.setTranslateY(371);
		sophLev.setMinSize(200, 100);
		
		//tells program what to run when Freshman button is pressed
		sophLev.setOnAction(new EventHandler<ActionEvent> ()
		{
			public void handle(ActionEvent arg0)
			{
				//creates Sophomore object that plays the Sophomore start method and runs the game
				Sophomore game = new Sophomore();
				try 
				{
					game.start(stage);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
		
		//creates title, location, and size of the junior button
		juniorLev = new Button("Junior");
		juniorLev.setTranslateX(800); 	juniorLev.setTranslateY(243);
		juniorLev.setMinSize(200, 100);
		
		//tells program what to run when Junior button is pressed
		juniorLev.setOnAction(new EventHandler<ActionEvent> ()
		{
			public void handle(ActionEvent arg0)
			{
				//creates Junior object that plays the Junior start method and runs the game
				Junior game = new Junior();
				try 
				{
					game.start(stage);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
		
		//creates title, location, and size of the Senior button
		seniorLev = new Button("Senior");
		seniorLev.setTranslateX(1100); 	seniorLev.setTranslateY(115);
		seniorLev.setMinSize(200, 100);
		
		//tells program what to run when Senior button is pressed
		seniorLev.setOnAction(new EventHandler<ActionEvent> ()
		{
			public void handle(ActionEvent arg0)
			{
				//creates Senior object that plays the Senior start method and runs the game
				Senior game = new Senior();
				try 
				{
					game.start(stage);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
		
		VBox root = new VBox();
		root.getChildren().addAll(freshmanLev, sophLev, juniorLev, seniorLev);
		
		Scene scene = new Scene(root, 1500,800);
		stage.setScene(scene);
		scene.getStylesheets().add("application.css");
		
		stage.show();
	}
}
