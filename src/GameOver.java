import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class GameOver extends Application
{

	boolean won;		//stores whether the player won
	String currLevel;
	
	public GameOver(boolean w,String c) 
	{
		won  =w;
		currLevel =c;
	}
	public static void main(String[] args) 
	{
		launch(args);
	}
	public void start(Stage stage) throws Exception 
	{
		// TODO Auto-generated method stub
		VBox overRoot = new VBox();

		//creates button that returns to Home page
		Button returnHome = new Button("Return to Home");
		returnHome.setTranslateX(340); returnHome.setTranslateY(200);
		returnHome.setMinSize(200, 100);
		returnHome.setOnAction(new EventHandler<ActionEvent> ()
		{
			public void handle(ActionEvent arg0)
			{
				
				Home game = new Home();
				try {
					game.start(stage);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		//creates button that replays the current level
		Button replay = new Button("Replay Level");
		replay.setTranslateX(945); replay.setTranslateY(302);
		replay.setMinSize(200, 100);
		replay.setOnAction(new EventHandler<ActionEvent> ()
		{
			public void handle(ActionEvent arg0)
			{
				
				if(currLevel.equals("Freshman"))
				{
					Freshman2 game = new Freshman2();
					try {
						game.start(stage);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else if(currLevel.equals("Sophomore"))
				{
					Sophomore game = new Sophomore();
					try {
						game.start(stage);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else if(currLevel.equals("Junior"))
				{
					Junior game = new Junior();
					try {
						game.start(stage);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else
				{
					Senior game = new Senior();
					try {
						game.start(stage);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		
		//creates button that goes to the 
/*		Button nextLevel = new Button("Next Level");
		nextLevel.setTranslateX(860); nextLevel.setTranslateY(410);
		nextLevel.setMinSize(200, 100);
		nextLevel.setOnAction(new EventHandler<ActionEvent> ()
		{
			public void handle(ActionEvent arg0)
			{
				
				Freshman2 game = new Freshman2();
				try {
					game.start(stage);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}); */
		
		overRoot.getChildren().addAll(replay,returnHome);
		Scene over = new Scene(overRoot,1500,800);
		over.setFill(Color.TOMATO);
		if(!won)
			over.getStylesheets().add("gameOver.css");
		else
			over.getStylesheets().add("gameWon.css");
		stage.setScene(over);
		stage.show();
	}

}
