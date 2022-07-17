import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WordHandler {

	private List<String> words;
	private File[] files;
	private BufferedReader br;
	private Random rng;

	public WordHandler() {
		words = new ArrayList<>();
		files = new File[] { new File("res/difficult.txt"), new File("res/easy.txt"), new File("res/medium.txt"),
				new File("res/hard.txt") };
		rng = new Random();
		for (int i = 0; i < files.length; i++) {
			try {
				br = new BufferedReader(new FileReader(files[i]));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			String line;
			try {
				while ((line = br.readLine()) != null) {
					String[] currWords = line.split(",");
					for (int j = 0; j < currWords.length; j++) {
						words.add(currWords[i]);
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public String[] getWordSelection() {
		return new String[] { words.get(rng.nextInt(words.size())), words.get(rng.nextInt(words.size())),
				words.get(rng.nextInt(words.size())) };
	}
}
