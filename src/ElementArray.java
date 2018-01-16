public class ElementArray
{
	private Element[][] elementArray = new Element[10][10];

	/**
	 * Creates a new ElementArray object 
	 * @param  map Character Array of decided game world layout of all 
	 * interactable elements
	 */
	public ElementArray(char[][] map)
	{
		for(int i = 0; i < map.length; i++)
		{
			for(int j = 0; j < map.length; j++)
			{
				if(map[i][j] == 'S' || map[i][j] == 'W')
				{
					Deadly deadly = new Deadly(i,j);
					elementArray[i][j] = deadly;
				}
				else if(map[i][j] == 'L' || map[i][j] == 'R' || map[i][j] == 'G')
				{
					Path path = new Path(i, j);
					elementArray[i][j] = path;
				}
				else if(map[i][j] == 'H')
				{
					Home home = new Home(i,j);
					elementArray[i][j] = home;
				}
				else if(map[i][j] == 'B')
				{
					Bank bank = new Bank(i,j);
					elementArray[i][j] = bank;
				}
			}
		}
	}

	/**
	 * @return elementArray  Element[][] of newly made interactable objects (game map) 
	 */
	public Element[][] getElementArray()
	{
		return elementArray;
	}
}