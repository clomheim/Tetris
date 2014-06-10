/* TCSS 305 Spring 2013
 * dlomheim_tetris
 */
package view;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * This class handles Instructions button clicks.
 * 
 * @author Doug Lomheim
 * @version 0.1.201300608
 */
@SuppressWarnings("serial")
public class InstructionListener extends AbstractAction
{
  /**
   * The frame on which everything is displayed.
   */
  private final JFrame my_frame;
  
  /**
   * Initializes fields.
   * 
   * @param the_frame The frame on which everything is displayed.
   */
  public InstructionListener(final JFrame the_frame)
  {
    super();
    my_frame = the_frame;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void actionPerformed(final ActionEvent the_event)
  {
    final StringBuilder sb = new StringBuilder();
    sb.append("Move Left: A\n");
    sb.append("Move Right: D\n");
    sb.append("Move Down: S\n");
    sb.append("Rotate Right: W\n");
    sb.append("Drop: SpaceBar\n");
    
    JOptionPane.showMessageDialog(my_frame, sb.toString());
  }

}
