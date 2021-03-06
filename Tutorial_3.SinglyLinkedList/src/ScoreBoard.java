/* ScoreBoard Class
 * @author Er Lin
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScoreBoard {
	
	public static void main(String[] args) 
	{
		// create a new scoreboard
		SinglyLinkedList<GameEntry> scoreboard = new SinglyLinkedList<GameEntry>();

		File file = new File("scores.txt");
		try {
			Scanner scanner = new Scanner(file);
			while (scanner.hasNext()) {
				String line = scanner.nextLine();
				@SuppressWarnings("resource")
				Scanner lineReader = new Scanner(line).useDelimiter(",\\s?+"); // comma followed by any number of spaces

				// read the name and score
				String name = lineReader.next();
				int score = lineReader.nextInt();
				
				// create the GameEntry object
				GameEntry e = new GameEntry(name, score);
				
				// add to scoreboard
				if(scoreboard.isEmpty())
				{
					scoreboard.addFirst(e);
				}
				else if(score > scoreboard.last().getScore() || scoreboard.size() < 10)
				{
					int i = 0;
					while(score < scoreboard.get(i).getScore() && i < scoreboard.size())
					{
						i++;
					}
					scoreboard.add(i, e);
					if(scoreboard.size() > 10) 
						scoreboard.removeLast();
				}
				lineReader.close();
			}
			scanner.close();
			System.out.println(scoreboard.toString());
		}
		 catch (FileNotFoundException e) {
			System.out.println("File Not Found!");
		}
	}
}

		
		
	

	

