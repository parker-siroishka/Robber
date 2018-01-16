/**
 * Parent class for all interactable map objects
 */
public abstract class Element
{

	private int row;
	private int col;

	/**
	 * Creates a new Element object at location i,j on array
	 * @param  i XCoord
	 * @param  j YCoord
	 */
	public Element(int i, int j)
	{
		row = i;
		col = j;
	}

/**
 * @return row  Integer row location
 */
	public int getRow()
	{
		return row;
	}

	/**
	 * @return col  Integer column location
	 */
	public int getCol()
	{
		return col;
	}

	/**
	 * The collision action for when the character collides with an
	 * element object location, however this is overridden within the subclasses of element
	 *
	 * @param player Character object of type Character
	 */
	public void doCollision(Character player)
	{
		//blank, overridden
	}


}