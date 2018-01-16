import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
/**
 *The Gui class creates all elements in menu frames. And is responsible 
 *for menu navigation.
 *
 * @author  Team 47
 */
public class Gui extends JPanel
{

	private JFrame mainFrame = new JFrame("Robber - Main menu");
	private JFrame gameFrame = new JFrame("Robber - Game");
	private final int WINDOW_SIZE_WIDTH = 905;
	private final int WINDOW_SIZE_HEIGHT = 940;
	private Image player;
	private Image obstacle = null;
	private Image mapBG = loadMapImage("gameMap.jpg");
	private Character character = null;
	private String name;
	private boolean gameBreaking = false;


	/**
	 * Default constructor
	 */
	public Gui()
	{

	}	
	/**
	 * Creates a new Gui object that represents the Menus of the game.
	 * @param  aCharacter Character Object
	 */
	public Gui(Character aCharacter)
	{
		character = aCharacter;
		this.mainMenu();
	}

	/**
	 * Returns gameFrame
	 * @return gameFrame object of type JFrame
	 */
	public JFrame getGameFrame()
	{
		return gameFrame;
	}

	/**
	 * Returns mainFrame
	 * @return mainFrame object of type JFrame 
	 */
	public JFrame getMainFrame()
	{
		return mainFrame;
	}
	/**
	 * Sets whether error encountered is gamebreaking or non vital
	 * @param value boolean
	 */
	public void setGameBreaking(boolean value)
	{
		gameBreaking = value;
	}
	/**
	 * Changes the current player
	 * @param aCharacter Character object
	 */
	public void setCharacter(Character aCharacter)
	{
		character = aCharacter;
	}

	/**
	 * Returns the current player
	 * @return character Current Character object
	 */
	public Character getCharacter(){
		return character;
	}
	/**
	 * Gets the player's name
	 * @return String of player's name
	 */
	public String getPlayerName()
	{
		return name;
	}

	/**
	 * Initializes the menu frame
	 */
	public  void setMainFrame()
	{
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		mainFrame.setSize(900,900);

		mainFrame.setResizable(false);
	}

	/**
	 * Initializes the game frame
	 */
	public void setGameFrame()
	{
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		gameFrame.setSize(WINDOW_SIZE_WIDTH, WINDOW_SIZE_HEIGHT);

		gameFrame.setResizable(false);
	}

	/**
	 * Gets the filepath of the image and loads it as an
	 * object of the Image class
	 * @param  filePath location
	 * @return player   Player object of type Image
	 */
	public  Image loadPlayerImage(String filePath)
	{
		try
		{
			File file = new File(filePath);
			player = ImageIO.read(file);
		}
		catch (IOException e)
		{
			e.printStackTrace();
			gameBreaking = true;
			displayErrorMessage("Error while attempting to read file" + filePath, "IOException");
		}

		player = player.getScaledInstance(90,90,Image.SCALE_DEFAULT);
		return player;
	}

	/**
	 * Gets the filepath of the image and loads it as an
	 * object of the Image class
	 * @param  filePath location
	 * @return obstacle Obstacle object of type Image
	 */
	public Image loadObstacleImage(String filePath)
	{

		try
		{
			File file = new File(filePath);
			obstacle = ImageIO.read(file);
		}
		catch (IOException e)
		{
			e.printStackTrace();
			gameBreaking = true;
			displayErrorMessage("Error while attempting to read file" + filePath, "IOException");
		}
		obstacle = obstacle.getScaledInstance(90,90,Image.SCALE_DEFAULT);
		return obstacle;
	}

	/**
	 * Gets the filepath of the image and loads it as an
	 * object of the Image class
	 * @param  filePath location
	 * @return map    Map object of type Image
	 */
	public  Image loadMapImage(String filePath)
	{

		try
		{
			File file = new File(filePath);
			mapBG = ImageIO.read(file);
		}
		catch (IOException e)
		{
			e.printStackTrace();
			gameBreaking = true;
			displayErrorMessage("Error while attempting to read file" + filePath, "IOException");
		}

		return mapBG;
	}
	/**
	 * Displays JOptionPane with text input when game ends, displays user score, takes user's name
	 * @param score int of the player score
	 */
	public void endGame(int score)
	{
		JOptionPane pane = new JOptionPane("Your score is: " + score +"\nPlease enter your name", JOptionPane.PLAIN_MESSAGE, JOptionPane.DEFAULT_OPTION, null, null, "Please enter your name here");
		pane.setWantsInput(true);
		JDialog dialog = pane.createDialog(null, "GAME OVER");
		dialog.setLocation(327,407);
		dialog.setVisible(true);
		name = (String)pane.getInputValue();
	}
	/**
	 * Displays error message and provides short description of what happened, may close game if 
	 * game breaking error
	 * @param error     String of error message
	 * @param errorType String of error type
	 */
	public void displayErrorMessage(String error, String errorType)
	{
		JOptionPane.showMessageDialog(mainFrame,error,errorType,JOptionPane.ERROR_MESSAGE);
		if (gameBreaking)
		{
			System.exit(-1);
		}
	}
	/**
	 * All gui based assembly for main menu. Contains ActionListeners
	 * and ActionEvents for all set main menu buttons. When calling another menu,
	 * the mainFrame is cleared and has buttons added according to which other outline
	 * is called.
	 */
	public  void mainMenu()
	{
		setMainFrame();
		//Create main menu buttons
		//START
		JButton start = new JButton("START");
		start.setFont(new Font("Britannic Bold", Font.PLAIN, 35));
		start.setBounds(350,400,200,100);
		start.setVisible(true);
		start.setFocusPainted(false);
		start.setBackground(new Color(165,42,42));
		start.setForeground(new Color(230,180,14));
		mainFrame.add(start);
		//SETTINGS
		JButton settings = new JButton("SETTINGS");
		settings.setFont(new Font("Britannic Bold", Font.PLAIN, 32));
		settings.setBounds(350,500,200,100);
		settings.setVisible(true);
		settings.setFocusPainted(false);
		settings.setBackground(new Color(165,42,42));
		settings.setForeground(new Color(230,180,14));
		mainFrame.add(settings);
		//HIGHSCORES
		JButton highScores = new JButton("HIGHSCORES");
		highScores.setFont(new Font("Britannic Bold", Font.PLAIN, 28));
		highScores.setBounds(350,600,200,100);
		highScores.setVisible(true);
		highScores.setFocusPainted(false);
		highScores.setBackground(new Color(165,42,42));
		highScores.setForeground(new Color(230,180,14));
		mainFrame.add(highScores);

		//QUIT
		JButton quit = new JButton("QUIT");
		quit.setFont(new Font("Britannic Bold", Font.PLAIN, 35));
		quit.setBounds(350,700,200,100);
		quit.setVisible(true);
		quit.setFocusPainted(false);
		quit.setBackground(new Color(165,42,42));
		quit.setForeground(new Color(230,180,14));
		mainFrame.add(quit);
		//Set main menu background image
		JLabel mainMenuBackground = new JLabel(new ImageIcon("mainMenuBackground.jpg"));

		mainMenuBackground.setLocation(0,0);

		mainFrame.add(mainMenuBackground);

		mainFrame.setVisible(true);

		//Add actionlisteners and actionEvents
		//START
		start.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				mainFrame.getContentPane().removeAll();
				setGameFrame();

				Game gameScreen = new Game();
				gameFrame.add(gameScreen);
				mainFrame.dispose();

				gameScreen.getGui().getMainFrame().dispose();
				gameFrame.setVisible(true);

			}
		});
		//SETTINGS
		settings.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				mainFrame.getContentPane().removeAll();
				settingsMenu();
			}
		});
		//HIGHSCORES
		highScores.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				mainFrame.getContentPane().removeAll();
				highScoresMenu();
			}
		});
		//QUIT
		quit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		});

	}

	/**
	 * All gui based assembly for settings menu. Contains ActionListeners
	 * and ActionEvents for all set settings menu buttons.
	 */
	public void highScoresMenu()
	{
		ScoringManager scoresList = new ScoringManager();
		JLabel scores = new JLabel();
		JLabel highScoresMenuTitle = new JLabel("<html><center><U>HIGHSCORES</U><br /><center></html>");
		highScoresMenuTitle.setFont(new Font("Britannic Bold", Font.PLAIN, 32));
		highScoresMenuTitle.setForeground(new Color(0,0,0));
		highScoresMenuTitle.setBounds(350,300,205,100);
		highScoresMenuTitle.setVisible(true);
		mainFrame.add(highScoresMenuTitle);
		String score1 = "1) " + scoresList.getHighScores(0);
		String score2 = "2) " + scoresList.getHighScores(1);
		String score3 = "3) " + scoresList.getHighScores(2);
		String score4 = "4) " + scoresList.getHighScores(3);
		String score5 = "5) " + scoresList.getHighScores(4);
		scores.setText("<html><center>"+score1+"<br /><center>"+score2+"<br /><center>"+score3+"<br /><center>"+score4+"<br /><center>"+score5+"</html>");
		scores.setFont(new Font("Britannic Bold", Font.PLAIN, 25));
		scores.setBounds(350,410,200,150);
		scores.setVisible(true);
		scores.setBackground(new Color(165,42,42));
		scores.setForeground(new Color(230,180,14));
		mainFrame.add(scores);

		JButton highScoresBack = new JButton("BACK");
		highScoresBack.setFont(new Font("Britannic Bold", Font.PLAIN, 25));
		highScoresBack.setBounds(350,600,200,100);
		highScoresBack.setVisible(true);
		highScoresBack.setFocusPainted(false);
		highScoresBack.setBackground(new Color(165,42,42));
		highScoresBack.setForeground(new Color(230,180,14));
		mainFrame.add(highScoresBack);

		//BACK - from settings menu
		highScoresBack.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				mainFrame.getContentPane().removeAll();
				mainMenu();
			}
		});

		JLabel highScoresMenuBackground = new JLabel(new ImageIcon("settingsMenuBackground.jpg"));

		highScoresMenuBackground.setLocation(0,0);

		mainFrame.add(highScoresMenuBackground);

		mainFrame.setVisible(true);
	}

	/**
	 * /**
	 * All gui based assembly for settings menu. Contains ActionListeners
	 * and ActionEvents for all set settings menu buttons. When calling another menu,
	 * the mainFrame is cleared and has buttons added according to which other outline
	 * is called.
	 */
	public  void settingsMenu()
	{

		//CHANGE
		JButton change = new JButton();
		change.setText("<html><center>CHANGE<br /><center>APPEARANCE</html>");
		change.setFont(new Font("Britannic Bold", Font.PLAIN, 18));
		change.setBounds(350,300,200,100);
		change.setVisible(true);
		change.setFocusPainted(false);
		change.setBackground(new Color(165,42,42));
		change.setForeground(new Color(230,180,14));
		mainFrame.add(change);
		//HELP
		JButton help = new JButton("HELP");
		help.setFont(new Font("Britannic Bold", Font.PLAIN, 25));
		help.setBounds(350,410,200,100);
		help.setVisible(true);
		help.setFocusPainted(false);
		help.setBackground(new Color(165,42,42));
		help.setForeground(new Color(230,180,14));
		mainFrame.add(help);
		//BACK - from settings menu
		JButton settingsBack = new JButton("BACK");
		settingsBack.setFont(new Font("Britannic Bold", Font.PLAIN, 25));
		settingsBack.setBounds(350,600,200,100);
		settingsBack.setVisible(true);
		settingsBack.setFocusPainted(false);
		settingsBack.setBackground(new Color(165,42,42));
		settingsBack.setForeground(new Color(230,180,14));
		mainFrame.add(settingsBack);

		//Add ActionListeners and ActionEvents
		//CHANGE
		change.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				mainFrame.getContentPane().removeAll();
				characterMenu();
			}
		});
		//HELP
		help.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				mainFrame.getContentPane().removeAll();
				helpMenu();
			}
		});
		//BACK - from settings menu
		settingsBack.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				mainFrame.getContentPane().removeAll();
				mainMenu();
			}
		});

		JLabel settingsMenuBackground = new JLabel(new ImageIcon("settingsMenuBackground.jpg"));

		settingsMenuBackground.setLocation(0,0);

		mainFrame.add(settingsMenuBackground);

		mainFrame.setVisible(true);
	}
	/**
	 * All gui based assembly for character menu. Contains ActionListeners
	 * and ActionEvents for all set character menu buttons.
	 */
	public  void characterMenu()
	{
		//create character menu buttons
		//PEPE
		JLabel pepe = new JLabel("COMING SOON!");
		pepe.setLayout(null);
		pepe.setFont(new Font("Britannic Bold", Font.PLAIN, 33));
		pepe.setBounds(new Rectangle(new Point(120,520),pepe.getPreferredSize()));
		pepe.setVisible(true);
		pepe.setForeground(Color.RED);
		mainFrame.add(pepe);
		//ROBBER
		JButton robber = new JButton("ROBBER");
		robber.setFont(new Font("Britannic Bold", Font.PLAIN, 33));
		robber.setBounds(550,500,200,100);
		robber.setVisible(true);
		robber.setFocusPainted(false);
		robber.setBackground(new Color(165,42,42));
		robber.setForeground(new Color(230,180,14));
		mainFrame.add(robber);
		//BACK - From character menu
		 JButton characterBack = new JButton("BACK");
		 characterBack.setFont(new Font("Britannic Bold", Font.PLAIN, 33));
		 characterBack.setBounds(320,700,200,100);
		 characterBack.setVisible(true);
		 characterBack.setFocusPainted(false);
		 characterBack.setBackground(new Color(165,42,42));
		 characterBack.setForeground(new Color(230,180,14));
		 mainFrame.add(characterBack);


		//ROBBER
		robber.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				character.setAppearance("characterRobberWithoutMoney.png");
				character.setIsRobber(true);
			}
		});
		//BACK - From character menu to settings menu
		characterBack.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				mainFrame.getContentPane().removeAll();
				settingsMenu();
			}
		});


		JLabel characterMenuBackground = new JLabel(new ImageIcon("characterMenuBackground.jpg"));

		characterMenuBackground.setLocation(0,0);

		mainFrame.add(characterMenuBackground);

		mainFrame.setVisible(true);

	}

	/**
	 * All gui based assembly for help menu. Contains ActionListeners
	 * and ActionEvents for all set help menu buttons.
	 */
	public  void helpMenu()
	{
		//Create help menu button
		JButton helpBack = new JButton("BACK");
		helpBack.setFont(new Font("Britannic Bold", Font.PLAIN, 33));
		helpBack.setBounds(320,700,200,100);
		helpBack.setVisible(true);
		helpBack.setFocusPainted(false);
		helpBack.setBackground(new Color(165,42,42));
		helpBack.setForeground(new Color(230,180,14));
		mainFrame.add(helpBack);

		//Add actionlisteners and actionevents
		helpBack.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				mainFrame.getContentPane().removeAll();
				settingsMenu();
			}
		});

		JLabel helpMenuBackground = new JLabel(new ImageIcon("helpMenuBackground.jpg"));

		helpMenuBackground.setLocation(0,0);

		mainFrame.add(helpMenuBackground);

		mainFrame.setVisible(true);
	}
}
