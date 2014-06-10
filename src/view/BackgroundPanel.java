/* TCSS 305 Spring 2013
 * dlomheim_tetris
 */
package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * This class creates a Panel to display a background image on.
 * 
 * @author Doug Lomheim
 * @version 0.1.20130607
 */
@SuppressWarnings("serial")
public class BackgroundPanel extends JPanel implements Observer
{
  /**
   * Preferred dimension of the panel.
   */
  private static final Dimension DEFAULT_SIZE = new Dimension(790, 590);
  
  /**
   * The image to be shown.
   */
  private final Image my_image;
  
  /**
   * Constructor initializing fields and preferences.
   */
  public BackgroundPanel()
  {
    super();
    my_image = new ImageIcon("./Background.jpg").getImage();
    setPreferredSize(DEFAULT_SIZE);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void paintComponent(final Graphics the_graphics)
  {
    super.paintComponent(the_graphics);
    the_graphics.drawImage(my_image, 0, 0, this);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void update(final Observable the_arg0, final Object the_arg1)
  {
    repaint();
    
  }
}
