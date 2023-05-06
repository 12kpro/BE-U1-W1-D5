package MultimediaPlayer;

import java.util.Arrays;

public class ImageItem extends MediaItem implements Brightness {
	int brightness;

	public ImageItem(String title) {
		super(title);
		this.brightness = 0;
	}

	public ImageItem(String title, int brightness) {
		super(title);
		this.brightness = brightness;
	}

	public void brightnessUp() {
		brightness++;
	}

	public void brightnessDown() {
		brightness--;
	}

	public void show() {
		char [] brightnessString = new char [brightness];
		Arrays.fill(brightnessString, '*');
		System.out.println(title + " " + String.valueOf(brightnessString));
	}

	@Override
	public String toString() {
		return "Title: " + this.title + " Brightness: " + this.brightness;
	}
}
