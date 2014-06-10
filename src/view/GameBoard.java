/* TCSS 305 Spring 2013
 * dlomheim_tetris
 */
package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

import model.Block;
import model.Board;
import model.IPiece;
import model.JPiece;
import model.LPiece;
import model.MutablePiece;
import model.OPiece;
import model.SPiece;
import model.TPiece;
import model.ZPiece;

/**
 * This class constructs the board on which the game is displayed.
 * 
 * @author Doug Lomheim
 * @version 0.1.20130608
 */
@SuppressWarnings("serial")
public class GameBoard extends JPanel implements Observer
{
  /**
   * The size of the blocks in pixels.
   */
  private static final int BLOCK_SIZE = 29;
  
  /**
   * The number of the last index of the array containing the coordinates of the blocks.
   */
  private static final int INDEX_SIZE = 3;
  
  /**
   * The alpha value for the board.
   */
  private static final int ALPHA = 150;
  
  /**
   * The x location of where the String should start.
   */
  private static final int STRING_X = 10;
  
  /**
   * The y location of where the String should start.
   */
  private static final int STRING_Y = 300;
  
  /**
   * Color for text.
   */
  private static final Color NERV_RED = new Color(217, 11, 11);
  
  /**
   * Index of the Danger SOng.
   */
  private static final int DANGER_SONG = 3;
  
  /**
   * Height from the top, before the danger song plays.
   */
  private static final int DANGER_HEIGHT = 4;
  
  /**
   * The board in which the game is played.
   */
  private final Board my_board;
  
  /**
   * The timer that controls the speed at which pieces fall.
   */
  private final Timer my_timer;
  
  /**
   * The height of the displayed board.
   */
  private final int my_height;
  
  /**
   * The pause state of the game.
   */
  private final PauseState my_paused;
  
  /**
   * The music player.
   */
  private final MusicPlayer my_player;
  
  /**
   * The font to be used.
   */
  private final Font my_font;
  
  /**
   * The pause button.
   */
  private final JButton my_pause_button;
  
  /**
   * Initializes the fields.
   * 
   * @param the_board The board in which the game is played.
   * @param the_timer The timer controlling how fast the pieces fall.
   * @param the_paused The Pause state of the game.
   * @param the_player The music player.
   * @param the_font The font to be used.
   * @param the_pause The pause button.
   */
  public GameBoard(final Board the_board, final Timer the_timer, final PauseState the_paused,
                   final MusicPlayer the_player, final Font the_font, final JButton the_pause)
  {
    super();
    my_board = the_board;
    my_timer = the_timer;
    my_height = my_board.getHeight() * BLOCK_SIZE;
    my_paused = the_paused;
    my_player = the_player;
    my_font = the_font;
    my_pause_button = the_pause;
    setUpPanel();
  }
  
  /**
   * Sets up the Panel for use.
   */
  private void setUpPanel()
  {
    final int width = my_board.getWidth() * BLOCK_SIZE;
    setBackground(new Color(0, 0, 0, ALPHA));
    setPreferredSize(new Dimension(width, my_height));
    addKeyListener(new KeyboardListener());
    setFocusable(true);
    requestFocusInWindow();
  }
  
  /**
   * {@inheritDoc}
   */
  @Override
  public void paintComponent(final Graphics the_graphics)
  {
    super.paintComponent(the_graphics);
    
    final Color clear = new Color(0, 0, 0, 0);
    final Graphics2D g2d = (Graphics2D) the_graphics;
    if (my_board.gameIsOver())
    {
      setBackground(Color.BLACK);
      g2d.setPaint(NERV_RED);
      final Font newfont = my_font.deriveFont(50f);
      g2d.setFont(newfont);
      
      g2d.drawString("Game Over", STRING_X, STRING_Y);
    }
    else if (my_paused.isPaused())
    {
      setBackground(Color.BLACK);
      g2d.setPaint(NERV_RED);
      final Font newfont = my_font.deriveFont(50f);
      g2d.setFont(newfont);
      
      g2d.drawString("Paused", STRING_X, STRING_Y);
    }
    else
    {
      setBackground(new Color(0, 0, 0, ALPHA));
      paintFrozenBlocks(g2d, clear);
    
    
      final MutablePiece piece = my_board.getCurrentPiece();
      int[][] loc;
      if (piece instanceof IPiece)
      {
        final IPiece ipiece = (IPiece) piece;
        loc = ipiece.getBoardCoordinates();
        g2d.setPaint(ipiece.getBlock().getColor());
      }
      else if (piece instanceof JPiece)
      {
        final JPiece jpiece = (JPiece) piece;
        loc = jpiece.getBoardCoordinates();
        g2d.setPaint(jpiece.getBlock().getColor());
      }
      else if (piece instanceof LPiece)
      {
        final LPiece lpiece = (LPiece) piece;
        loc = lpiece.getBoardCoordinates();
        g2d.setPaint(lpiece.getBlock().getColor());
      }
      else if (piece instanceof OPiece)
      {
        final OPiece opiece = (OPiece) piece;
        loc = opiece.getBoardCoordinates();
        g2d.setPaint(opiece.getBlock().getColor());
      }
      else if (piece instanceof SPiece)
      {
        final SPiece spiece = (SPiece) piece;
        loc = spiece.getBoardCoordinates();
        g2d.setPaint(spiece.getBlock().getColor());
      }
      else if (piece instanceof TPiece)
      {
        final TPiece tpiece = (TPiece) piece;
        loc = tpiece.getBoardCoordinates();
        g2d.setPaint(tpiece.getBlock().getColor());
      }
      else
      {
        final ZPiece zpiece = (ZPiece) piece;
        loc = zpiece.getBoardCoordinates();
        g2d.setPaint(zpiece.getBlock().getColor());
      }
    
      g2d.fill(new Rectangle2D.Double(loc[0][0] * BLOCK_SIZE, my_height - BLOCK_SIZE 
                                      - (loc[0][1] * BLOCK_SIZE), BLOCK_SIZE, BLOCK_SIZE));
      g2d.fill(new Rectangle2D.Double(loc[1][0] * BLOCK_SIZE, my_height - BLOCK_SIZE 
                                      - (loc[1][1] * BLOCK_SIZE), BLOCK_SIZE, BLOCK_SIZE));
      g2d.fill(new Rectangle2D.Double(loc[2][0] * BLOCK_SIZE, my_height - BLOCK_SIZE 
                                      - (loc[2][1] * BLOCK_SIZE), BLOCK_SIZE, BLOCK_SIZE));
      g2d.fill(new Rectangle2D.Double(loc[INDEX_SIZE][0] * BLOCK_SIZE, my_height - BLOCK_SIZE 
                                      - (loc[INDEX_SIZE][1] * BLOCK_SIZE), BLOCK_SIZE,
                                      BLOCK_SIZE));
      g2d.setPaint(Color.BLACK);
      g2d.draw(new Rectangle2D.Double(loc[0][0] * BLOCK_SIZE, my_height - BLOCK_SIZE 
                                      - (loc[0][1] * BLOCK_SIZE), BLOCK_SIZE, BLOCK_SIZE));
      g2d.draw(new Rectangle2D.Double(loc[1][0] * BLOCK_SIZE, my_height  - BLOCK_SIZE 
                                      - (loc[1][1] * BLOCK_SIZE), BLOCK_SIZE, BLOCK_SIZE));
      g2d.draw(new Rectangle2D.Double(loc[2][0] * BLOCK_SIZE, my_height - BLOCK_SIZE 
                                      - (loc[2][1] * BLOCK_SIZE), BLOCK_SIZE, BLOCK_SIZE));
      g2d.draw(new Rectangle2D.Double(loc[INDEX_SIZE][0] * BLOCK_SIZE, my_height - BLOCK_SIZE 
                                      - (loc[INDEX_SIZE][1] * BLOCK_SIZE), BLOCK_SIZE, 
                                      BLOCK_SIZE));
    }
  }
  
  /**
   * Paints the frozen blocks.
   * 
   * @param the_graphics The graphics tool to paint with.
   * @param the_clear The color to color with.
   */
  private void paintFrozenBlocks(final Graphics2D the_graphics, final Color the_clear)
  {
    final List<Block[]> blocks = my_board.getFrozenBlocks();
    if ((blocks.size() >= my_board.getHeight() - DANGER_HEIGHT) 
        && (my_player.getIndex() != DANGER_SONG)
        && (!my_board.gameIsOver()))
    {
      my_player.stopPlay();
      my_player.change(DANGER_SONG);
      
    }
    else if ((blocks.size() < my_board.getHeight() - DANGER_HEIGHT) 
        && (my_player.getIndex() != 0))
    {
      my_player.stopPlay();
      my_player.change(0);
    }
    int height = my_height - BLOCK_SIZE;
    for (Block[] b : blocks)
    {
      for (int i = 0; i < b.length; i++)
      {
        the_graphics.setPaint(b[i].getColor());
        the_graphics.fill(new Rectangle2D.Double(i * BLOCK_SIZE, height, BLOCK_SIZE, 
                                                 BLOCK_SIZE));
        if (b[i].getColor().equals(the_clear))
        {
          the_graphics.setPaint(the_clear);
          the_graphics.draw(new Rectangle2D.Double(i * BLOCK_SIZE, height, BLOCK_SIZE, 
                                                   BLOCK_SIZE));
        }
        else
        {
          the_graphics.setPaint(Color.BLACK);
          the_graphics.draw(new Rectangle2D.Double(i * BLOCK_SIZE, height, BLOCK_SIZE, 
                                                   BLOCK_SIZE));
        }
      }
      height -= BLOCK_SIZE;
    }
  }

 /**
  * {@inheritDoc}
  */
  @Override
  public void update(final Observable the_observable, final Object the_object)
  {
    if (my_board.gameIsOver()) 
    {
      my_timer.stop();
      my_player.stopPlay();
      my_player.change(2);
      my_pause_button.setEnabled(false);
    }
    else
    {
      repaint();
    }
  }
  
  /**
   * Handles what to do when certain keys are pressed.
   * 
   * @author Doug Lomheim
   * @version 0.1.20130531
   */
  private class KeyboardListener extends KeyAdapter
  {

    /**
     * {@inheritDoc}
     */
    @Override
    public void keyPressed(final KeyEvent the_event)
    {
      if (!my_board.gameIsOver() && !my_paused.isPaused()) 
      {
        final String key = KeyEvent.getKeyText(the_event.getKeyCode());
      
        if ("A".equals(key))
        {
          my_board.moveLeft();
        }
        else if ("D".equals(key))
        {
          my_board.moveRight();
        }
        else if ("S".equals(key))
        {
          my_board.moveDown();
        }
        else if ("Space".equals(key))
        {
          my_board.hardDrop();
        }
        else if ("W".equals(key))
        {
          my_board.rotate();
        }
      }
    }
  }
}
