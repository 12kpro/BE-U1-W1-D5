package MultimediaPlayer;

import java.util.Scanner;

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
	public int getBrightness() {
		return brightness;
	}

	public void brightnessUp() {
		brightness = brightness < 10 ? ++brightness : 10;
	}

	public void brightnessDown() {
		brightness = brightness > 0 ? --brightness  : 0;
	}

	public void show() {
		Scanner input = new Scanner(System.in);
		


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
		System.out.println(title + " " + "*".repeat(brightness));
	}

	@Override
	public String toString() {
		return "Title: " + this.title + " Brightness: " + this.brightness;
	}
}
