
import java.io.*;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/**
 * In charge of player scores and names. Stores scores and name in text file, scores are sorted based
 * on highest score value. 
 */
public class ScoringManager
{ 
	private ArrayList<String> scores = new ArrayList<String>();
	private String highScoreFile = "scores.txt";
	private String line;
	Gui gui = new Gui();

	/**
	 * Default constructor, call readScores method
	 *
	 */
	public ScoringManager() 
	{
		readScores();
	}
	/**
	 * Reads the file belonging to file name, adds strings to String ArrayList
	 */
	public void readScores()
	{
		BufferedReader reader = null;
		try
		{
			File file = new File(highScoreFile);
			reader = new BufferedReader(new FileReader(file));
		}
		catch(FileNotFoundException fnfe)
		{
			//fnfe.printStackTrace();
			gui.setGameBreaking(true);
			gui.displayErrorMessage("Error file" + highScoreFile + " not found", "IOException");
		}
		finally
		{
			try
			{
				while ((line = reader.readLine()) != null)
				{
					if (!line.equals(""))
					{
						String aScore = line;
						String segments[] = aScore.split("\\) ");
						aScore = segments[segments.length - 1];
						scores.add(aScore);
					}
				}
				reader.close();
			}
			catch(IOException ioe)
			{
				ioe.printStackTrace();
				gui.displayErrorMessage("Error while attempting to read file" + highScoreFile, "IOException");
			}
		}
	}
	/**
	 * Sorts String ArrayList based on highest score value, writes sorted array to provided text file
	 * writing each element of the array on a new line
	 */
	public void updateScores()
	{
		Collections.sort(scores, new Comparator<String>()
		{
			@Override
			public int compare(String o1, String o2)
			{
				return Integer.valueOf(o2.split(" ")[0]).compareTo(Integer.valueOf(o1.split(" ")[0]));
			}
		});
		BufferedWriter writer = null;
		try
		{	
			File file = new File(highScoreFile);
			FileWriter fw = new FileWriter(file);
			writer = new BufferedWriter(fw);
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
			gui.setGameBreaking(true);
			gui.displayErrorMessage("Error while attempting to write to file" + highScoreFile, "IOException");
		}
		finally
		{
			try
			{
				for (int i = 0; i < scores.size(); i++)
				{
					writer.write((i + 1) + ") ");
					writer.write(scores.get(i) + "\n");
				}
				writer.close();
			}
			catch(IOException ioe)
			{
				ioe.printStackTrace();
				gui.setGameBreaking(true);
				gui.displayErrorMessage("Error while attempting to write to file" + highScoreFile, "IOException");
			}
		}
	}
	/**
	 * Adds player score and name to String arrayList
	 * @param newScore int Player score
	 * @param newName  String Player name
	 */
	public void addScores(int newScore, String newName)
	{
		scores.add(newScore + " - " + newName);
	}
	
	/**
	 * Gets the specified high score and name from the array list
	 * @param  numOfScore int of which score you want in array list
	 * @return            String of score and name
	 */
	public String getHighScores(int numOfScore)
	{
		return scores.get(numOfScore);
	}
}