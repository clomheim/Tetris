/* TCSS 305 Spring 2013
 * dlomheim_tetris
 */
package view;

import java.awt.Font;

import javax.swing.JFrame;

/**
 * This class creates the initial frame for the game.
 * 
 * @author Doug Lomheim
 * @version 0.1.20130530
 */
public class WelcomeFrame
{
  
  /**
   * The regular font size.
   */
  private static final int REGULAR_FONT = 24;
  
  /**
   * The frame everything is displayed in.
   */
  private final JFrame my_frame;
  
  /**
   * The font to be used in all components.
   */
  private final Font my_font;
  
  /**
   * Initializes fields.
   */
  public WelcomeFrame()
  {
    my_frame = new JFrame();
    my_font = new Font("Times New Roman", Font.BOLD, REGULAR_FONT);
  }
  
  /**
   * Sets the JFrame up to be displayed.
   */
  public void start()
  { 
    my_frame.add(new WelcomePanel(my_frame, my_font));
    my_frame.setLocationRelativeTo(null);
    my_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    my_frame.setResizable(false);
    my_frame.pack();
    my_frame.setVisible(true);
  }
}
