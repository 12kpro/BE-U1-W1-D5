package MultimediaPlayer;
import java.util.Arrays;

public class AudioItem extends MediaItem {
	int volume;
	int duration;

	public AudioItem(String title) {
		super(title);
		this.volume = 0;
		this.duration = 0;
	}
	public AudioItem(String title, int volume) {
		super(title);
		this.volume = volume;
		this.duration = 0;
	}
	public AudioItem(String title, int volume, int duration) {
		super(title);
		this.volume = volume;
		this.duration = duration;
	}

	public void play() {
		char [] volumeString = new char [volume];
		Arrays.fill(volumeString, '!');

		for (int i = 0; i < duration; i++) {
			System.out.println(title + " " + String.valueOf(volumeString));
		}		
	}

	public void volUp() {
		volume++;
	}

	public void volDown() {
		volume--;
	}

	@Override
	public String toString() {
		return "Title: " + this.title + " Volume: " + this.volume + " Duration:  " + this.duration;
	}
}
