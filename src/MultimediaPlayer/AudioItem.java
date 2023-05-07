package MultimediaPlayer;
import java.util.Scanner;
public class AudioItem extends MediaItem implements Playable {
	protected int volume;
	protected int duration;

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
				System.out.printf("Entered option %s not valid! Please enter y/n, y = yes, n = no%n", resp);
			}
		}

		for (int i = 0; i < duration; i++) {
			System.out.println(title + " " + "!".repeat(volume));
		}
	}

	public int getDuration() {
		return duration;
	}

	public void volUp() {
		this.volume = this.volume  < 10 ? ++volume  : 10;
	}

	public void volDown() {
		this.volume = this.volume > 0 ? --volume : 0;
	}

	@Override
	public String toString() {
		return "Title: " + this.title + " Volume: " + this.volume + " Duration:  " + this.duration;
	}
}
