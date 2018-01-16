/**
 * Subclass of Element for Home map object
 */
public class Home extends Element
{

	/**
	 * Creates a new Home object and calls the Element parent class
	 * @param  i Row location
	 * @param  j Column location
	 */
	public Home(int i, int j)
	{
		super(i,j);
	}

	/**
	 * The collision action for when the character collides with the 
	 * Home object location
	 * @param character Character object of type character
	 */
	public void doCollision(Character character )
	{
		if (character.getIsRobber() && character.getHasMoney()) 
			{
				character.setAppearance("characterRobberWithoutMoney.png");	
			}
		else if(!character.getIsRobber() && character.getHasMoney())
		{
			character.setAppearance("characterRobberWithoutMoney.png");	
		}
		if (character.getHasMoney())
		{
			character.incrementScore(100);
		}
		character.setHasMoney(false);
		//scoring
	}
}