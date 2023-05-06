package MultimediaPlayer;
import java.util.Arrays;

public class VideoItem extends AudioItem implements Brightness {
	int brightness;

	public VideoItem(String title) {
		super(title);
		this.brightness = 0;
	}
	public VideoItem(String title, int volume) {
		super(title, volume);
		this.brightness = 0;
	}
	public VideoItem(String title, int volume, int duration) {
		super(title, volume, duration);
		this.brightness = 0;
	}	
	public VideoItem(String title, int volume, int duration, int brightness) {
		super(title, volume, duration);
		this.brightness = brightness;
	}

	@Override
	public void play() {
		char [] volumeString = new char [volume];
		char [] brightnessString = new char [brightness];
		Arrays.fill(volumeString, '!');
		Arrays.fill(brightnessString, '*');

		for (int i = 0; i < duration; i++) {
			System.out.println(title + " " + String.valueOf(volumeString) + " " + String.valueOf(brightnessString));
		}		
	}

	public void brightnessUp() {
		brightness++;
	}

	public void brightnessDown() {
		brightness--;
	}

	@Override
	public String toString() {
		return "Title: " + this.title + " Volume: " + this.volume + " Duration: " + this.duration + " Brightness: " + this.brightness;
	}
}
