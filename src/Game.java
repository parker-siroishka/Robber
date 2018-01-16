
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;
import java.awt.Rectangle;

/**
 * Main application driver
 */
public class Game extends JPanel implements KeyListener
{
	Character character = new Character();
	Gui gui = new Gui(character);

	Map map = new Map();
	CarMove carMove = new CarMove();

	/**
	 * Creates a new object of type Game which initializes the timer
	 */
	public Game()
	{
		addKeyListener(this);
		setFocusable(true);
		Timer timer = new Timer(16,new ActionListener()
		{
            public void actionPerformed(ActionEvent e)
            {

            	carMove.moveCars();
            	repaint();
            	for (int counter = 0;counter < 9;counter++)
            	{
            		if (carMove.getCarOb(counter).contains(character.getPlayerPoint()))
            		{
            			character.die();
            			System.out.println("dead by car");

            		}
            	}

                repaint();
                //End game scenarios
                if (!character.getAlive())
                {
           			((Timer)e.getSource()).stop();
           			gui.endGame(character.getScore());
           			ScoringManager score = new ScoringManager();
           			if (gui.getPlayerName() != "uninitializedValue")
           			{
           				score.addScores(character.getScore(),gui.getPlayerName());
           				score.updateScores();
           			}

      		    }

            }
        });
        timer.start();
	}

	/**
	 * Takes user input and moves onscreen character
	 * @param e Keyevent 
	 */
	public void keyPressed(KeyEvent e)
	{
		int code = e.getKeyCode();
		if (character.getAlive())
		{
			if (code == KeyEvent.VK_S && character.getYCoord() < 800)
			{
				character.moveVertical(1);
				
			}
			else if (code == KeyEvent.VK_W && character.getYCoord() > 0)
			{
				character.moveVertical(-1);
			}
			else if (code == KeyEvent.VK_A && character.getXCoord() > 0)
			{
				character.moveHorizontal(-1);
			}
			else if (code == KeyEvent.VK_D && character.getXCoord() < 800)
			{
				character.moveHorizontal(1);
			}
			map.getElement().getElementArray()[character.getYCoord()/90][character.getXCoord()/90].doCollision(character);
			repaint();
		}
	}

	/**
	 * @return gui Gui object that represents the menus of the game
	 */
	public Gui getGui(){
		return gui;
	}

	/**
	 * Paints all components in the game map
	 * @param g Graphics object 
	 */
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(gui.loadMapImage("gameMap.jpg"), 0, 0, 900, 900, null);
		g.drawImage(gui.loadPlayerImage(character.getAppearance()),character.getXCoord(),character.getYCoord(),null);
		if (carMove.getCarOb(0) != null)
		{
			for(int counter = 0; counter < carMove.getCarObSize(); counter ++)
			{
				g.drawImage(gui.loadObstacleImage("car.png"),(int)carMove.getCarOb(counter).getX(),(int)carMove.getCarOb(counter).getY(),null);
			}
		}
		g.setColor(Color.YELLOW);
		g.setFont(new Font("Arial Black",Font.PLAIN, 25));
		g.drawString("Score: " + character.getScore(),3, 28);
		if (!character.getAlive()) {
			g.drawImage(gui.loadMapImage("endGame.png"),0,0,null);
		}

	}

	@Override
	public void keyTyped(KeyEvent e){}
	@Override
	public void keyReleased(KeyEvent e){}



	/**
	 * Creates an instance of game
	 */
	public static void main(String[] args) {
		Game frogger = new Game();

	}
}
