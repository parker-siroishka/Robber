import java.util.Arrays;

/**
 * Houses 2D Array responsible for creating Element Array
 */
public class Map
{
	private char[][] elements ={
					 {'G','G','G','B','B','B','B','G','G','G'},
					 {'S','G','G','G','S','S','G','S','G','G'},
					 {'G','G','G','S','S','S','G','G','G','S'},
					 {'W','L','W','W','W','W','W','L','W','W'},
					 {'W','L','W','W','W','W','W','L','W','W'},
					 {'W','L','W','W','W','W','W','L','W','W'},
					 {'R','R','R','R','R','R','R','R','R','R'},
					 {'R','R','R','R','R','R','R','R','R','R'},
					 {'R','R','R','R','R','R','R','R','R','R'},
					 {'G','G','G','H','H','H','H','G','G','G'},
		};
	private ElementArray elementArray = new ElementArray(elements);

/**
 * @return elementArray Array of created elements in map locations
 */
	public ElementArray getElement()
	{
		return elementArray;
	}
}