package MultimediaPlayer;

import java.util.Arrays;
import java.util.Scanner;

public class Player {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		MediaItem[] tracks = new MediaItem[5];
		Boolean auto = true; //set tru for auto creation

		if (!auto){
		String type, title;
		int volume, duration, brightness, i = 0;
		while (i < 5) {
			System.out.println("Enter track type (1=audio,2=video,3=image)");
			type = scanner.nextLine();

			switch (type) {
			case "1":
			System.out.println("Enter track title");
			title = scanner.nextLine();
				System.out.println("Enter track duration");
				duration = Math.abs(Integer.parseInt(scanner.nextLine()));
				System.out.println("Enter track volume");
				volume = checkValue(0,10);
				tracks[i] = new AudioItem(title, volume, duration);
				i++;
				break;
			case "2":
			System.out.println("Enter track title");
			title = scanner.nextLine();
				System.out.println("Enter video volume");
				volume = checkValue(0,10);
				System.out.println("Enter video duration");
				duration = Math.abs(Integer.parseInt(scanner.nextLine()));
				System.out.println("Enter video brightness");
				brightness = checkValue(0,10);
				tracks[i] = new VideoItem(title, volume, duration, brightness);
				i++;
				break;
			case "3":
			System.out.println("Enter track title");
			title = scanner.nextLine();
				System.out.println("Enter image brightness");
				brightness = checkValue(0,10);
				tracks[i] = new ImageItem(title, brightness);
				i++;
				break;

			default:
				System.out.println("The entered type " + type
						+ " is wrong! Please select one of the following: 1=audio, 2=video or 3=image.");
				break;

			}
		}
		} else {

		tracks[0] = new AudioItem("canzone_1", 1, 2);
		tracks[1] = new ImageItem("image_1", 3);
		tracks[2] = new VideoItem("video_1", 2, 3, 4);
		tracks[3] = new AudioItem("canzone_2", 3, 5);
		tracks[4] = new VideoItem("video_2", 5, 7, 1);
}
		System.out.println(Arrays.asList(tracks));

		playloop: while (true) {
			System.out.println("Enter a number from 1 to 5 to select a track or 0 to quit");
			int track = Math.abs(Integer.parseInt(scanner.nextLine()));
			int trackIdx = track - 1;
			switch (track) {
			case 0:
				scanner.close();
				break playloop;
			case 1, 2, 3, 4, 5:

//				boolean isPlayable = Playable.class.isAssignableFrom(tracks[trackIdx].getClass()); faccio il check se la classe è riproducibile.
//  			 Ma se la classe implementa l'interfaccia Playablbe (riproduciblie) è utile rifare il check in esecuzione????
 
				if (tracks[trackIdx] instanceof AudioItem) {
					((AudioItem) tracks[trackIdx]).play();
				} else if (tracks[trackIdx] instanceof VideoItem) {
					((VideoItem) tracks[trackIdx]).play();
				} else {
					((ImageItem) tracks[trackIdx]).show();
				}
				break;
			default:
				System.out.println("Entered number " + track + " is not in range 1 to 5 or 0!");
				break;
			}
		}
	}
	private static int checkValue(int min, int max){
		Scanner input = new Scanner(System.in);
		while(true){
			int val = Math.abs(Integer.parseInt(input.nextLine()));
			if( val >= min && val <= max) { 
				return val;
			}else{
				System.out.printf("Entered value out off range, min = %d, max = %d, Please input a in range value%n", min, max);
			}
		}
	}
}