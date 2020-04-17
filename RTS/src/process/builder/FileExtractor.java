package process.builder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class FileExtractor {
	public HashMap<String, String> readFile(String path) {
		HashMap<String, String> contents = new HashMap<String, String>();
		try {
			FileReader fileReader = new FileReader(new File(path));
			BufferedReader buffReader = new BufferedReader(fileReader);
			String content = "";
			while ((content = buffReader.readLine()) != null) {
				String[] infos = content.split(" = ");
				if (infos.length > 1)
					contents.put(infos[0], infos[1]);
			}
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}

		return contents;
	}

}