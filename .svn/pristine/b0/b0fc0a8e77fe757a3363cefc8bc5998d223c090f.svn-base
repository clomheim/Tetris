/* TCSS 305 Spring 2013
 * dlomheim_tetris
 */
package view;

import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;

/**
 * This class handles events for the Start Game Buttons.
 * 
 * @author Doug Lomheim
 * @version 0.1.20130608
 */
@SuppressWarnings("serial")
public class GameStartListener extends AbstractAction
{
  /**
   * The frame on which everything is Displayed.
   */
  private final JFrame my_frame;
  
  /**
   * The font to be used.
   */
  private final Font my_font;
  
  /**
   * Initializes fields.
   * 
   * @param the_frame The frame on which everything is displayed.
   * @param the_font The font to be used.
   */
  public GameStartListener(final JFrame the_frame, final Font the_font)
  {
    super();
    my_frame = the_frame;
    my_font = the_font;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void actionPerformed(final ActionEvent the_event)
  {
    new GameFrame().start(my_frame, my_font);
    my_frame.dispose();
  }

}
