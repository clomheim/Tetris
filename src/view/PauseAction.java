/* TCSS 305 Spring 2013
 * dlomheim_tetris
 */
package view;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Timer;

/**
 * This class handles the actions for when the Pause Button is pressed.
 * 
 * @author Doug Lomheim
 * @version 0.1.20130608
 */
@SuppressWarnings("serial")
public class PauseAction extends AbstractAction
{
  /**
   * The timer that controls how fast the pieces fall.
   */
  private final Timer my_timer;
  
  /**
   * Whether the game is paused or not.
   */
  private final PauseState my_paused;
  
  /**
   * The music player.
   */
  private final MusicPlayer my_player;
  
  /**
   * The board in which the game is visually displayed.
   */
  private final GameBoard my_board;
  
  /**
   * Constructor initializing fields.
   * 
   * @param the_timer The timer controlling how fast the pieces fall.
   * @param the_paused The pause state of the game.
   * @param the_player The music player.
   * @param the_board The board in which the game is visually displayed.
   */
  public PauseAction(final Timer the_timer, final PauseState the_paused, 
                     final MusicPlayer the_player, final GameBoard the_board)
  {
    super();
    my_timer = the_timer;
    my_paused = the_paused;
    my_player = the_player;
    my_board = the_board;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void actionPerformed(final ActionEvent the_event)
  {
    if (my_paused.isPaused())
    {
      my_timer.restart();
      my_paused.setPauseState(false);
      my_player.stopPlay();
      my_player.change(0);
      my_board.repaint();
    }
    else
    {
      my_timer.stop();
      my_paused.setPauseState(true);
      my_player.stopPlay();
      my_player.change(1);
      my_board.repaint();
    }
  }

}
