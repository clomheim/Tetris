/* TCSS 305 SPring 2013
 * dlomheim_tetris
 */
package view;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.Timer;

/**
 * This class Handles the actions for ending a game.
 * 
 * @author Doug Lomheim
 * @version 0.1.20130608
 */
@SuppressWarnings("serial")
public class EndGameAction extends AbstractAction
{
  /**
   * The timer controlling how fast the pieces fall.
   */
  private final Timer my_timer;
  
  /**
   * The button that pauses the game.
   */
  private final JButton my_pause_button;
  
  /**
   * The Pause state of the game.
   */
  private final PauseState my_pause_state;
  
  /**
   * Constructor initializing fields.
   * 
   * @param the_timer the timer that controls how fast the pieces fall.
   * @param the_pause_button The button that pauses the game.
   * @param the_pause_state The Pause state of the game.
   */
  public EndGameAction(final Timer the_timer, final JButton the_pause_button, 
                       final PauseState the_pause_state)
  {
    super();
    my_timer = the_timer;
    my_pause_button = the_pause_button;
    my_pause_state = the_pause_state;
  }
  
  /**
   * {@inheritDoc}
   */
  @Override
  public void actionPerformed(final ActionEvent the_event)
  {
    my_timer.stop();
    my_pause_state.setPauseState(true);
    my_pause_button.setEnabled(false);
  }
}
