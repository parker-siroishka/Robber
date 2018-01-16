import java.awt.Rectangle;

/**
 * The CarMove class contains everything needed to move the car objects 
 * along the game map.
 */
public class CarMove 
{	
	// Creating contants and instance variables 
	public static final int NUM_OF_CARS = 9;
	private Rectangle[] carOb = new Rectangle[9];
	private Car[] carList = new Car[9];
	private int[] speed = new int[9];
	Car car = new Car();
	/**
	 * Creates the cars objects and puts them into a carlist array
	 */
	public CarMove()
	{
	
		for (int counter = 0; counter < NUM_OF_CARS; counter++)
		{
			Car car = new Car(counter);
			carList[counter] = car;

		}

		
		setCars();
		setSpeed();

	}
	
	/**
	 * Puts the rectangle of the cars into an array called carOb
	 */
	public void setCars()
	{
		for (int counter = 0; counter < NUM_OF_CARS;counter++)
		{
			carOb[counter] = carList[counter].getRectangle();
		}
		
	}

	/**
	 * Puts all the cars speeds into a array
	 */
	public void setSpeed()
	{
		for (int counter = 0;counter < NUM_OF_CARS;counter++)
		{
			speed[counter] = carList[counter].getSpeed();
		}
		
	}

	/**
	 * @param  index which is an int of which index you want
	 * @return carOb[index] which is a rectangle of the desired car
	 */
	public Rectangle getCarOb(int index)
	{
		return carOb[index];
	}

	/**
	 * @return the length of the carOb array
	 */
	public int getCarObSize()
	{
		return carOb.length;
	}
	
	/**
	 * This method moves all the cars which are in the carOb array
	 */
	public void moveCars()
	{
		for(int i = 0; i < 9; i++)
		{

		 	if(i<3){
		 		carOb[i].setLocation((int)carOb[i].getX()+speed[i],(int)carOb[i].getY());
		 		if((int)carOb[i].getX() >= 900){
		 			carOb[i].setLocation(-90,(int)carOb[i].getY());
		 		}
		 	}
		 	else if(i<6){
		 		carOb[i].setLocation((int)carOb[i].getX()+speed[i],(int)carOb[i].getY());
		 		if((int)carOb[i].getX() <= -90){
		 			carOb[i].setLocation(900,(int)carOb[i].getY());
		 		}
		 	}
		 	else if(i<9){
		 		carOb[i].setLocation((int)carOb[i].getX()+speed[i],(int)carOb[i].getY());
		 		if(carOb[i].getX() >= 900){
		 			carOb[i].setLocation(-90,(int)carOb[i].getY());
		 		}
		 	}
		 }
	}



}