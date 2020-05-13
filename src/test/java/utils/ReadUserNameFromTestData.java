package utils;

import java.io.*;

public class ReadUserNameFromTestData {

	public String verifyUserName() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/users.json"));
		StringBuilder stringBuilder = new StringBuilder();

		String line;
		while ((line = reader.readLine()) != null) {
			stringBuilder.append(line);
		}
		return stringBuilder.toString();
	}
}
