package MultimediaPlayer;

import java.util.Scanner;

public class VideoItem extends AudioItem implements Playable, Brightness {
	private int brightness;

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

		Scanner input = new Scanner(System.in);
		

		while(true){
			System.out.println("Do you want to change the volume? (y/n y=yes n=no)");
			char resp = input.next().charAt(0);
			if ( resp == 'y'){
				System.out.println("Turn Up or turn down? (u/d u=up d=down)");
				char direction = input.next().charAt(0);
				if( direction == 'u'){
					volUp();
					System.out.printf("New volume level is %s%n", volume);
				}else if(direction == 'd'){
					volDown();
					System.out.printf("New volume level is %s%n", volume);
				}else{
					System.out.printf("Entered option %s not valid! Please enter u/d, u = Up, d = Down%n", direction);	
				}
			}else if( resp == 'n'){
				break;
			}else{
				System.out.printf("Entered option %s not valid! Please enter y/n, y = yes, n = no", resp);
			}
		}
		while(true){
			System.out.println("Do you want to change the brightness? (y/n y=yes n=no)");
			char resp = input.next().charAt(0);
			if ( resp == 'y'){
				System.out.println("Turn Up or turn down? (u/d u=up d=down)");
				char direction = input.next().charAt(0);
				if( direction == 'u'){
					brightnessUp();
					System.out.printf("New brightness level is %s%n", brightness);
				}else if(direction == 'd'){
					brightnessDown();
					System.out.printf("New brightness level is %s%n", brightness);
				}else{
					System.out.printf("Entered option %s not valid! Please enter u/d, u = Up, d = Down%n", direction);	
				}
			}else if( resp == 'n'){
				break;
			}else{
				System.out.printf("Entered option %s not valid! Please enter y/n, y = yes, n = no%n", resp);
			}
		}		

		for (int i = 0; i < duration; i++) {
			System.out.println(title + " " + "!".repeat(volume) + " " + "*".repeat(volume));
		}
	}

	public int getBrightness() {
		return brightness;
	}

	public void brightnessUp() {
		brightness = brightness < 10 ? ++brightness : 10;
	}

	public void brightnessDown() {
		brightness = brightness > 0 ? --brightness  : 0;
	}

	@Override
	public String toString() {
		return "Title: " + title + " Volume: " + volume + " Duration: " + duration + " Brightness: " + brightness;
	}


}
