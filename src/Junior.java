
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Junior extends Application 
{
	//Graphics
	private AnimationTimer timer;						//runs the animation of the Assignments falling
    private Pane root;
    private List<Node> cars = new ArrayList<>();			//stores all the Assignments that are falling
    private List<Boolean> hits= new ArrayList<>();		//stores T/F whether the student caught each assignment
    private Image stuImg;								//stores the Robot image file
    private ImageView displayImg;						//displays the Image
	private boolean flag;								//tells the program when to stop making more assignments
	private static final int KEYBOARD_MOVEMENT_DELTA = 290; //the distance the student moves with each keyboard click
	Image img2 = new Image("file:pixil-frame-0.png");		//stores the background image
	ImageView displayClass =new ImageView(img2);  		//displays the background image

	Scene scene;
	Stage primeStage = new Stage();
	Label totalAssignments;											//stores the total amount of assignments the player can catch
	
	//GameData
	private final int totalHW = 20;									//how many total assignments will fall
	private int hwCaught = 0;										//how many assignments were caught	(counter)	
	private boolean won;												//says whether player won the game
	
	
	
	//start->CreateContent->makeStudent->onUpdate()->makeWork()&checkState()
	private Parent createContent() 
	{
		root = new Pane();
		root.setPrefSize(1500 , 800);

		displayImg = makeStudent();	//stores the robot image that the makeStudent() return
	
		//creates & stores each frame of the animation of the assignments falling
		timer = new AnimationTimer() 
		{
			@Override
			public void handle(long now)
			{
					onUpdate();
				
			}
			
		};timer.start();
		
		root.getChildren().add(displayImg);	//adds the program to the root that will eventually display it
		
		return root;
	}
	
	private void onUpdate()
	{
		//creates the label and sets the locations and styles it
		totalAssignments = new Label("TOTAL HW ASSIGNMENTS: 20");
		totalAssignments.setMinSize(200, 50);	
		totalAssignments.setTranslateX(50);
		totalAssignments.setTranslateY(40);
		totalAssignments.setFont(new Font("Arial",24));
		totalAssignments.setTextFill(Color.BLACK);
		
		//creates the label and sets the locations and styles it
		Label needed = new Label("TOTAL NEEDED TO PASS: 16");	//this label displays how many assignments they must catch in order to win
		needed.setMinSize(200, 50);
		needed.setTranslateX(50);
		needed.setTranslateY(100);
		needed.setFont(new Font("Arial",24));
		needed.setTextFill(Color.BLACK);
		
		root.getChildren().addAll(totalAssignments,needed); //adds the labels to the root 
		
		
		
		if(Math.random()< 0.065)		//how often it generates an assignment to fall- continues because of Animation Timer
		{
			if(cars.size() < totalHW && !flag) 	//checks if the max HW assignments have been hit and if not, makes more assignments
			{
				cars.add(makeWork());		//fills ArrayList of assignments w/ assignments if size is less than 10	
				
			}
			if(cars.size() >= totalHW)			//if it has generated the maximum amount of assignments, then it gives a signal to stop making more
			{
				flag= true;
			}		
		}
		
		for(Node obj: cars)
		{
			obj.setTranslateY(obj.getTranslateY() + 23); //determines the speed it falls by increasing the y position by 3
		}
		
		checkState();	//checks whether any assignment has hit the robot
		
			
	}
	
	private ImageView makeStudent()
	{
		//takes in the Robot image
		FileInputStream inputstream = null;
		try 
		{
			inputstream = new FileInputStream("robot.png");
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		
		stuImg = new Image(inputstream);		//takes the robot image input and it stores it into the Image object
		displayImg = new ImageView(stuImg); 	//displays the robot
		return displayImg;					//puts the image onto screen
	
	}
	
	
	private Node makeWork()
	{
		
		Group image = new Group();
		int col = (100 + ((int)(Math.random() *4))*290);	//generates a random x /column to fall in
		
		//creates the Assignment graphic w/ rectangles and lines 
		Rectangle rect = new Rectangle (col, 50, 60, 80);
		rect.setTranslateX(0);
		rect.setTranslateY(-100);
		rect.setFill(Color.BLUE);
		
	
		rect.setArcHeight(10);
		rect.setArcWidth(10);
		rect.setFill(Color.WHITESMOKE);
		rect.setStroke(Color.BLACK);
		
		Line line4 = new Line(-300, -170,   -250,   -170);
		line4.setTranslateX(305);
		line4.setTranslateY(210);
		
		Line line = new Line(-300, -170,   -250,   -170);
		line.setTranslateX(305);
		line.setTranslateY(200);
		
		Line line2 = new Line(-300, -170,   -250,   -170);
		line2.setTranslateX(305);
		line2.setTranslateY(190);
		
		Line line3 = new Line(-300, -170,   -250,   -170);
		line3.setTranslateX(305);
		line3.setTranslateY(230);
		
		Line line5 = new Line(-300, -170,   -250,   -170);
		line5.setTranslateX(305);
		line5.setTranslateY(220);
		
		//groups lines together and sets their location
		Group groupLine = new Group();
		groupLine.getChildren().addAll(line, line2, line3, line4, line5);
		groupLine.setTranslateX(col);
		groupLine.setTranslateY(-95+50);
		
		//adds a label to the assignment
		Label help = new Label("HW");
		help.setTranslateX(20+col);
		help.setTranslateY(-47);
		
		//consolidates all the elements of the Assignment including the group of Lines, rectangle, and Label  
		Group groupHW = new Group();
		groupHW.getChildren().addAll(rect,groupLine);	
		groupHW.getChildren().add(help);
		groupHW.setTranslateX(40);
		image.getChildren().add(groupHW);
		
		hits.add(false);				//originally sets to false bc assignment has not been caught yet
		root.getChildren().add(image); //adds the Assignment to the root 	
		
		return image;			//returns the assignment graphic
	}
	

	private void checkState()
	{
		for(int i=cars.size()-1;i>=0;i--) //goes through the Assignments and checks their position
		{
			Node car = cars.get(i);
			
			if (car.getBoundsInParent().intersects(displayImg.getBoundsInParent())) //if the Robot catches the assignment
	        {
	            		
				hits.set(i, true);				//hits.get(i) is true b/c assignment is caught
	            	root.getChildren().remove(car);	//stops displaying the Assignment
	             return;
	        }
			
	            
			

		}
	}
        
		


	private void moveStudentOnKeyPress(Scene root, final ImageView displayImg)
	  {
		//
	    root.setOnKeyPressed(new EventHandler<KeyEvent>() 
	    {
	      @Override public void handle(KeyEvent event) {
	        switch (event.getCode()) 	//stores keyboard action
	        {
	         
	          case RIGHT:
		          {
		        	  if(inBoundsRight(displayImg))	//if it is inBounds
		        	  {
		        		  displayImg.setX(displayImg.getX() + KEYBOARD_MOVEMENT_DELTA); //moves student set amount
		        	  		break;
		        	  }
		        	  else
		        	  {
		        		  displayImg.setX(displayImg.getX() + 0);  //stop adding distance if not in bounds
		        		  break;
		        	  }
	        		  
	          }
	         
	          case LEFT:  
	          {
	        	  if(inBoundsLeft(displayImg)) //if it is inBounds
	        	  {
	        		  displayImg.setX(displayImg.getX() - KEYBOARD_MOVEMENT_DELTA); //moves student set amount
	        	  		break;
	        	  }
	        	  else
	        	  {
	        		  displayImg.setX(displayImg.getX() + 0); //stop adding distance if not in bounds
	  	  				break;
	        	  }
	        		  
	          }
	         
	        }
	      }
	    });
	  }
	
	//checks if X position of student will be off the screen in the right direction
	private boolean inBoundsRight(ImageView displayImg)		
	  {
		  
		  if(displayImg.getX() + KEYBOARD_MOVEMENT_DELTA > 1260) 
			  return false;
		  else
			  return true;
		  
		  
	  }
	 
	//checks if X position of student will be off the screen
	 private boolean inBoundsLeft(ImageView displayImg)
	  {
		  if(displayImg.getX() - KEYBOARD_MOVEMENT_DELTA < 50)
			  return false;
		  else
			  return true;
	  }
	  

	public static void main(String[] args) 
	{
		launch(args);
	}
	public void start(Stage stage) throws Exception 
	{
		//stores the music file and creates an object that plays the music
		/*File file = new File("IFallApartTrim.mp3");
		FreshmanMusic music = new FreshmanMusic(file.toURI().toString());
		music.mediaplayer.play();
		*/		
		
		try
		{
			//makeStudent();	//creates and displays the Robot image

			Group node = new Group();				
			node.getChildren().addAll(displayClass); //node stores the background image to put in the Scene
			
			Button finish = new Button("Finish Game");		//player hits this once the Assignments stop falling
			finish.setTranslateX(930); finish.setTranslateY(50);	//sets the locations and the size
			finish.setMinSize(200, 100);
			//tells program what to do when Finish button is pressed
			finish.setOnAction(new EventHandler<ActionEvent> ()
			{
				public void handle(ActionEvent arg0)
				{
					
					//determines whether the player won or lost 
					for(int i =0;i<hits.size();i++)
					{
						if(hits.get(i) == true)	//counts how many assignments intersected with the robot(caught) and set to true
							hwCaught++;
					}
					if(hwCaught >= (totalHW*0.8) && cars.size() >= 10)	//checks if 80% of the assignments were caught
					{
						won =true;
					}
					
					music.mediaplayer.stop();
					//removes the game window from screen
					timer.stop();		//stop updating the animation
					root.getChildren().clear();	//clears all the assignments, robot, buttons, etc 
					stage.setScene(null);		//gets a blank window
					stage.hide();				//stops old stage window(game) from being displayed
					
					GameOver over = new GameOver(won,"Junior"); //creates a GameOver object and tells whether the player won
        				try 
        				{
						over.start(primeStage);
        				} catch (Exception e) 
        				{
        					e.printStackTrace();
        				}
				}
			});
			final Group group = new Group(node,createContent(),finish);		//stores all the elements of the game
		    final Scene scene = new Scene(group, 1500, 800, Color.LIGHTPINK);	//stores it into the scene
		    scene.getStylesheets().add("game.css");							//styles the elements on the scene(buttons)
		    moveStudentOnKeyPress(scene, displayImg);						//moves the student
		    
		    displayImg.setX(70);												//sets student position
			displayImg.setY(590);						
			
			stage.setScene(scene);
			
			stage.show();
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
			
	}
		
	
	

		
		
	}
	
	

	
