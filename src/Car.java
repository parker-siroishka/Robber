import java.io.*;
import java.awt.*;
import java.util.Arrays;
import java.util.ArrayList;
import java.awt.Rectangle;

/**
 * Reads carinfo from txt file and assigns values to car objects
 */
public class Car 
{
	private String lineNeeded;
	private int[] carParameters;
	private int speed;
	private Rectangle rectangle;
	
	public Car()
	{}

	/**
	 * Car constructor, creates rectangle with parameters, sets speed
	 * @param  carNum int car being generated
	 */
	public Car(int carNum)
	{
		generateParameters(carNum);
		Rectangle boundingBox = new Rectangle(carParameters[0],carParameters[1],carParameters[2],carParameters[3]);
		speed = carParameters[4];
		rectangle  = boundingBox;
		//speedArray = speed;
	}
	public Rectangle getRectangle()
	{
		return rectangle;
	}


	/**
	 * Fills carParameters array with values being passed through
	 * @param anX     int of x-coord
	 * @param aY      int of y-coord
	 * @param aWidth  int of width
	 * @param aHeight int of height
	 * @param aSpeed  int of speed
	 */
	public void setCarParameters(int anX, int aY, int aWidth, int aHeight, int aSpeed)
	{
		int[] newCarParameters = {anX,aY,aWidth,aHeight,aSpeed};
		carParameters = newCarParameters;
	}
	/**
	 * Getter to retrieve speed instance variable
	 * @return int of speed
	 */
	public int getSpeed()
	{
		return speed;
	}
	/**
	 * Opens text file for reading, reads specified line in 
	 * file, sets line to a string
	 * @param  carNum int car being generated
	 * @return lineNeeded String of specified line from text file
	 */
	public String readCarFile(int carNum)
	{
		BufferedReader reader = null;
		try
		{
			File file = new File("CarInfo.txt");
			reader = new BufferedReader(new FileReader(file));
		}
		catch (FileNotFoundException fnfe)
		{
			//Have GUI error pop up
			System.out.println("Error, cannot find car car info file");
		}
		finally
		{
			try
			{
				//Reads all lines before line needed, does nothing
				for (int i = 0; i < carNum; i++)
				{
					reader.readLine();
				}
				lineNeeded = reader.readLine(); //Reads line needed
				reader.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		return lineNeeded; //Return to createCar
	}
	/**
	 * Splits line from text file into individual strings, 
	 * creates string array with parameters, converts string 
	 * array to int array
	 * @param carNum int car being generated
	 */
	public void generateParameters(int carNum)
	{
		String[] info = new String[5];
		lineNeeded = readCarFile(carNum);
		
		//Splits line from text file, replaces empty array with new strings of parameters
		info = lineNeeded.split(" ");
		for (int counter = 0; counter < 5;counter++)
		{
			info[counter] = info[counter].replaceAll("[^\\d-]", "");
		}
		int x = Integer.parseInt(info[0]);
		int y = Integer.parseInt(info[1]);
		int width = Integer.parseInt(info[2]);
		int height = Integer.parseInt(info[3]);
		int speed = Integer.parseInt(info[4]);
		setCarParameters(x,y,width,height,speed);
	}
}