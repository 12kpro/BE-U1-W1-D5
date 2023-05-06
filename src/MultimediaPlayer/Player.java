package MultimediaPlayer;

import java.util.Arrays;
import java.util.Scanner;

public class Player {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		MediaItem[] tracks = new MediaItem[5];
		Boolean auto = true;

		if (!auto){
		String type, title;
		int volume, duration, brightness, i = 0;
		while (i < 5) {
			System.out.println("Enter track type (audio,video,image)");
			type = scanner.nextLine();
			System.out.println("Enter track title");
			title = scanner.nextLine();

			switch (type) {
			case "audio":
				System.out.println("Enter track duration");
				duration = Math.abs(Integer.parseInt(scanner.nextLine()));
				System.out.println("Enter track volume");
				volume = Math.abs(Integer.parseInt(scanner.nextLine()));
				tracks[i] = new AudioItem(title, volume, duration);
				i++;
				break;
			case "video":
				System.out.println("Enter track volume");
				volume = Math.abs(Integer.parseInt(scanner.nextLine()));
				System.out.println("Enter track duration");
				duration = Math.abs(Integer.parseInt(scanner.nextLine()));
				System.out.println("Enter track brightness");
				brightness = Math.abs(Integer.parseInt(scanner.nextLine()));
				tracks[i] = new VideoItem(title, volume, duration, brightness);
				i++;
				break;
			case "image":
				System.out.println("Enter track brightness");
				brightness = Math.abs(Integer.parseInt(scanner.nextLine()));
				tracks[i] = new ImageItem(title, brightness);
				i++;
				break;

			default:
				System.out.println("The entered type " + type
						+ " is wrong! Please select one of the following: audio, video or image.");
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
}