/* TCSS 305 Spring 2013
 * dlomheim_tetris
 */
package view;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import model.Board;

/**
 * Handles actions for the timer.
 * 
 * @author Doug Lomheim
 * @version 0.1.20310531
 */
@SuppressWarnings("serial")
public class TimerListener extends AbstractAction
{
  /**
   * The board in which the game is played.
   */
  private final Board my_board;
  
  /**
   * Initializes fields.
   * 
   * @param the_board The board in which the game is played.
   */
  public TimerListener(final Board the_board)
  {
    super();
    my_board = the_board;
  }
  
  /**
   * {@inheritDoc}
   */
  @Override
  public void actionPerformed(final ActionEvent the_event)
  {
    my_board.step();
  }

}
