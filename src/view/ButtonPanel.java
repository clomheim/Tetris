/* TCSS 305 Spring 2013
 * dlomheim_tetris
 */
package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import model.Board;

/**
 * This class creates a board with all the function buttons.
 * 
 * @author Doug Lomheim
 * @version 0.1.20130608
 */
@SuppressWarnings("serial")
public class ButtonPanel extends JPanel
{
  /**
   * Rows in GridLayout.
   */
  private static final int ROWS = 5;
  
  /**
   * The font to be used.
   */
  private final Font my_font;
  
  /**
   * The pause button.
   */
  private final JButton my_pause;
  
  /**
   * The end game button.
   */
  private JButton my_end_game;
  
  /**
   * The new game button.
   */
  private JButton my_new_game;
  
  /**
   * The exit button.
   */
  private JButton my_exit;
  
  /**
   * The instructions button.
   */
  private JButton my_instructions;
  
  /**
   * The frame in which everything is displayed.
   */
  private final JFrame my_frame;
  
  /**
   * The timer controlling how fast the pieces fall.
   */
  private final Timer my_timer;
  
  /**
   * The pause state of the game.
   */
  private final PauseState my_pause_state;
  
  /**
   * The board in which the game is played.
   */
  private final Board my_board;
  
  /**
   * The score sheet for the game.
   */
  private final ScoreSheet my_sheet;
  
  /**
   * THe music player.
   */
  private final MusicPlayer my_player;
  
  /**
   * The board in which the game is visually displayed.
   */
  private final GameBoard my_game_board;
  
  /**
   * Constructor initializing board.
   * 
   * @param the_pause The Pause button.
   * @param the_font The font to be used.
   * @param the_frame The frame in which everything is displayed.
   * @param the_timer The timer controlling how fast pieces fall.
   * @param the_paused The pause state of the game.
   * @param the_board The board in which the game is played.
   * @param the_sheet The scoring sheet.
   * @param the_player The music player.
   * @param the_game_board The board on which the main game is displayed.
   */
  public ButtonPanel(final JButton the_pause, final Font the_font, final JFrame the_frame, 
                     final Timer the_timer, final PauseState the_paused, final Board the_board,
                     final ScoreSheet the_sheet, final MusicPlayer the_player, 
                     final GameBoard the_game_board)
  {
    super();
    my_font = the_font;
    my_frame = the_frame;
    my_timer = the_timer;
    my_pause_state = the_paused;
    my_board = the_board;
    my_sheet = the_sheet;
    my_player = the_player;
    my_game_board = the_game_board;
    my_pause = the_pause;
    addComponents();
  }
  
  /**
   * Adds the buttons to the panel.
   */
  private void addComponents()
  {
    my_pause.setText("Pause");
    my_end_game = new JButton("End Game");
    my_new_game = new JButton("New Game");
    my_exit = new JButton("Exit");
    my_instructions = new JButton("Instructions");
    
    setLayout(new GridLayout(ROWS, 1));
    setAlignmentX(Component.CENTER_ALIGNMENT);
    setOpaque(false);
    
    setUpButtons();
    
    add(my_pause);
    add(my_instructions);
    add(my_new_game);
    add(my_end_game);
    add(my_exit);
  }
  
  /**
   * Sets up the buttons to have no border or fill.
   */
  private void setUpButtons()
  {
    my_pause.setForeground(Color.WHITE);
    my_pause.setFont(my_font);
    my_pause.setBorderPainted(false);
    my_pause.setContentAreaFilled(false);
    my_pause.setFocusPainted(false);
    my_pause.setFocusable(false);
    my_pause.addActionListener(new PauseAction(my_timer, my_pause_state, my_player, 
                                               my_game_board));
    
    my_instructions.setForeground(Color.WHITE);
    my_instructions.setFont(my_font);
    my_instructions.setBorderPainted(false);
    my_instructions.setContentAreaFilled(false);
    my_instructions.setFocusPainted(false);
    my_instructions.setFocusable(false);
    my_instructions.addActionListener(new InstructionListener(my_frame));
    
    my_new_game.setForeground(Color.WHITE);
    my_new_game.setFont(my_font);
    my_new_game.setBorderPainted(false);
    my_new_game.setContentAreaFilled(false);
    my_new_game.setFocusPainted(false);
    my_new_game.setFocusable(false);
    my_new_game.addActionListener(new NewGameAction(my_board, my_sheet, my_timer, my_pause, 
                                                    my_pause_state, my_player));
    
    my_end_game.setForeground(Color.WHITE);
    my_end_game.setFont(my_font);
    my_end_game.setBorderPainted(false);
    my_end_game.setContentAreaFilled(false);
    my_end_game.setFocusPainted(false);
    my_end_game.setFocusable(false);
    my_end_game.addActionListener(new EndGameAction(my_timer, my_pause, my_pause_state));
    
    my_exit.setForeground(Color.WHITE);
    my_exit.setFont(my_font);
    my_exit.setBorderPainted(false);
    my_exit.setContentAreaFilled(false);
    my_exit.setFocusPainted(false);
    my_exit.setFocusable(false);
    my_exit.addActionListener(new AbstractAction() {
      @Override
      public void actionPerformed(final ActionEvent the_arg)
      {
        my_frame.dispose();
        my_timer.stop();
        my_player.stopPlay();
      }
    });
  }
}
