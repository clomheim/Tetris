/* TCSS 305 Spring 2013
 * dlomheim_tetris
 */
package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Creates the scoring display.
 * 
 * @author Doug Lomheim
 * @version 0.1.20130608
 */
@SuppressWarnings("serial")
public class ScoreLabel extends JPanel implements Observer
{
  /**
   * The scores for the game.
   */
  private final ScoreSheet my_scores;
  
  /**
   * 
   */
  private final Font my_font;
  
  /**
   * The label for the total Score.
   */
  private final JLabel my_score_label;
  
  /**
   * The label for the level.
   */
  private final JLabel my_level_label;
  
  /**The label for the number of lines cleared.
   * 
   */
  private final JLabel my_lines_label;
  
  /**
   * Creates the display for the scoring information.
   * 
   * @param the_sheet The scoring sheet to take the scores form.
   * @param the_font The font to be used.
   */
  public ScoreLabel(final ScoreSheet the_sheet, final Font the_font)
  {
    super();
    my_scores = the_sheet;
    my_font = the_font;
    setOpaque(false);
    setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
    
    my_score_label = new JLabel("Score: 0");
    my_level_label = new JLabel("Level: 1");
    my_lines_label = new JLabel("Lines Cleared: 0");
    addLabels();
  }
  
  /**
   * Adds labels to panel.
   */
  private void addLabels()
  {
    add(my_score_label);
    add(my_level_label);
    add(my_lines_label);
  }
  
  /**
   * {@inheritDoc}
   */
  @Override
  public void paintComponent(final Graphics the_graphics)
  {
    super.paintComponent(the_graphics);

    my_score_label.setForeground(Color.WHITE);
    my_score_label.setFont(my_font);
    my_score_label.setText("Score: " + my_scores.getScore());
    my_level_label.setForeground(Color.WHITE);
    my_level_label.setFont(my_font);
    my_level_label.setText("Level: " + my_scores.getLevel());
    my_lines_label.setForeground(Color.WHITE);
    my_lines_label.setFont(my_font);
    my_lines_label.setText("Lines Cleared: " + my_scores.getLines());
  }
  
  /**
   * {@inheritDoc}
   */
  @Override
  public void update(final Observable the_observanle, final Object the_object)
  {
    repaint();
  }
}
