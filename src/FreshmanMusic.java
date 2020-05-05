import javafx.scene.media.Media;
import javafx.scene.layout.BorderPane; 
import javafx.scene.media.MediaPlayer;



public class FreshmanMusic extends BorderPane
{
	Media media; //stores the song
	MediaPlayer mediaplayer; //plays the song

	 
	public FreshmanMusic(String name)
	{
		media = new Media(name);	//takes in the file name of the music
		mediaplayer = new MediaPlayer(media);	//passes file name to mediaplayer
		mediaplayer.setVolume(0.1);	//sets volume to 10% of max volume

		 
	}
	
	
	
	
}