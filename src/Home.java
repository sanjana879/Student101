import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Home extends Application
{
	
	Button pressPlay;	//creates button that begins the game
	Button directions;	//creates button that shows the directions

	
	public static void main(String[] args) 
	{
		launch(args);	//runs the start method
	}
	public void start(Stage stage) throws Exception 
	{
		//stage - displays all of the visible elements of the game
		
		//creates title, location, and size of the play button
		pressPlay = new Button("Play");	
		pressPlay.setTranslateX(200); pressPlay.setTranslateY(500);
		pressPlay.setMinSize(400, 100);
		
		//creates title, location, and size of the directions button
		directions = new Button("Directions");
		directions.setTranslateX(800); directions.setTranslateY(370);
		directions.setMinSize(400, 100);
		
		//creates title and location of game title label 
		
		
		//executes the handle method when the button is pressed 
		pressPlay.setOnAction(new EventHandler<ActionEvent> ()
		{
			public void handle(ActionEvent arg0)
			{
				//creates Play object that allows them to select a level
				//Home->Play start method->Freshman start method
				Play game = new Play();
				try 
				{
					game.start(stage);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
		
		//executes the handle method when the button is pressed 
		directions.setOnAction(new EventHandler<ActionEvent> ()
		{
			public void handle(ActionEvent arg0)
			{
				//makes window for directions
				Directions game = new Directions();
				try 
				{
					game.start(stage);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
		
		//root stores all the elements that need to be displayed & buttons and labels
		VBox root = new VBox();
		root.getChildren().addAll(pressPlay,directions);	
		
		//scene stores root elements & creates a window of the specified size
		Scene scene = new Scene(root, 1500,800);
		stage.setScene(scene);
		scene.getStylesheets().add("application.css");	//styles all of the elements in the root(font, color, etc) 
		
		//displays the scene
		stage.show();
		
		
		
	}
}
