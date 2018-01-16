/**
 * Subclass of Element for bank map object
 */
public class Bank extends Element
{
	/**
	 * Creates a new Bank object and calls the Element parent class
	 * @param  i Row location
	 * @param  j Column location
	 */
	public Bank(int i, int j)
	{
		super(i,j);
	}
	/**
	 * The collision action for when the character collides with the 
	 * bank location
	 * @param character Character object of type character
	 */
	public void doCollision(Character character)
	{
		if (character.getIsRobber() && !character.getHasMoney()) 
			{
				character.setAppearance("characterRobberWithMoney.png");	
			}
		else if(!character.getIsRobber() && !character.getHasMoney())
		{
			character.setAppearance("characterRobberWithMoney.png");	
		}
		character.setHasMoney(true);
	}
}