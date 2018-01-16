import java.awt.*;
import java.awt.event.WindowEvent;

/**
 * The Character class houses all methods relating to character information
 */
public class Character
{
	private static final String R_WITH_MONEY = "characterRobberWithMoney.png";
	private static final String R_WITHOUT_MONEY = "characterRobberWithoutMoney.png";


	private boolean alive = true;
	private boolean hasMoney = false;
	private int xCoord = 450;
	private int yCoord = 810;
	private int score = 0;
	private Gui gui;
	private boolean isRobber = false;

	private String appearance = R_WITHOUT_MONEY;
	private Point playerPoint = new Point(xCoord+45,yCoord+45);

	/**
	 * Creates a new Character object by  assigning default XCoord and YCoord values
	 */
	public Character()
	{
		this(450,810);
	}

	/**
	 * Creates a new Character object by assigning default XCoord and YCoord values 
	 * and Creating an Gui instance 
	 * @param  agui Gui instance
	 */
	public Character(Gui aGui)
	{
		this(450,810);
		gui = aGui;
	}

	/**
	 * Creates a new Character object by assigning XCoord and YCoord values
	 * and assigning a character appearance default of R_WITHOUT_MONEY
	 * @param  x XCoord
	 * @param  y YCoord
	 */
	public Character(int x,int y)
	{
		this(x,y,R_WITHOUT_MONEY);
	}

	/**
	 * Creates a new Character object by assigning XCoord and YCoord values 
	 * and a character appearance
	 * @param  x XCoord
	 * @param  y YCoord
	 * @param  s Character appearance
	 */
	public Character(int x, int y, String s)
	{
		xCoord = x;
		yCoord = y;
		appearance = s;
	}
	
	/**
	 * @param bool State of what character appearance is
	 */
	public void setIsRobber(boolean bool)
	{
		isRobber = bool;
	}

	/**
	 * @return isRobber Boolean of whether the character is the robber or not
	 */
	public boolean getIsRobber()
	{
		return isRobber;
	}

	/**
	 * @return xCoord  Character xCoordinate on 2D array reletive to array of obstacles
	 */
	public int getXCoord()
	{
		return xCoord;
	}

	/**
	 * @return yCoord  Character yCoordinate on 2D array reletive to array of obstacles
	 */
	public int getYCoord()
	{
		return yCoord;
	}

	/**
	 * @return appearance  String identifying what your charcter is appearing as 
	 */
	public String getAppearance()
	{
		return appearance;
	}

	/**
	 * @return alive  Boolean state of alive or dead in game 
	 */
	public boolean getAlive()
	{
		return alive;
	}

	/**
	 * @return playerPoint  Returns the playerpoint object of type 
	 */
	public Point getPlayerPoint()
	{
		return playerPoint;
	}

	/**
	 * @return hasMoney  Boolean state of player having money
	 */
	public boolean getHasMoney()
	{
		return hasMoney;
	}

	/**
	 * @param amount  Integer amount of scores increases by
	 */
	public void incrementScore(int amount)
	{
		score += amount;
	}

	/**
	 * @return Returns integer that is player score
	 */
	public int getScore()
	{
		return score;
	}

	/**
	 * @param bool Boolean state of setting if player has money
	 */
	public void setHasMoney(boolean bool)
	{
		hasMoney = bool;
	}

	/**
	 * Sets alive boolean to false
	 */
	public void die()
	{
		alive = false;
	}

	/**
	 * Takes in String of player appearance Image location 
	 * @param s String to assign to appearance
	 */
	public void setAppearance(String s)
	{
		appearance = s;
	}

	/**
	 * Moves player direction upwards or downwards
	 * @param dir value of 1 or -1 determining which direction to travel (up/down)
	 */
	public void moveVertical(int dir)
	{
		yCoord += 90*dir;
		playerPoint.setLocation(xCoord+45,yCoord+45);
	}

	/**
	 * Moves player direction upwards or downwards
	 * @param dir value of 1 or -1 determining which direction to travel (left/right)
	 */
	public void moveHorizontal(int dir)
	{
		xCoord += 90*dir;
		playerPoint.setLocation(xCoord+45,yCoord+45);
	}
}
