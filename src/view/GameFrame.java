/* TCSS 305 Spring 2013
 * dlomheim_tetris
 */
package view;

import java.awt.Component;
import java.awt.Font;
import java.io.File;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import model.Board;

/**
 * This class creates the frame that the game is played in.
 * 
 * @author Doug Lomheim
 * @version 0.1.20130608
 */
public class GameFrame
{
  /**
   * Represents one second in milliseconds.
   */
  private static final int ONE_SECOND = 1000;
  
  /**
   * The frame in which game components are displayed.
   */
  private final JFrame my_game_frame;
  
  /**
   * The board in which the game is played.
   */
  private final Board my_board;
  
  /**
   * The time for how fast the pieces fall.
   */
  private final Timer my_timer;
  
  /**
   * The pause state of the game.
   */
  private final PauseState my_paused;
  
  /**
   * The music player.
   */
  private final MusicPlayer my_player;
  
  /**
   * Initializes the fields.
   */
  public GameFrame()
  {
    my_game_frame = new JFrame();
    my_board = new Board();
    my_timer = new Timer(ONE_SECOND, new TimerListener(my_board));
    my_paused = new PauseState();
    my_player = new MusicPlayer();
  }
  
  /**
   * Constructs the frame and game components.
   * 
   * @param the_frame The previous frame from which to set the new frame relative to.
   * @param the_font The font to be used.
   */
  public void start(final JFrame the_frame, final Font the_font)
  {
    //Songs for the MusicPlayer
    final File[] songs = new File[4];
    songs[0] = new File("10 Cruel Angel Thesis.wav");
    songs[1] = new File("10 EM08_B17_Edit#070705.wav");
    songs[2] = new File("24 2EM28_EM13.wav");
    songs[3] = new File("25 2EM29_E5.wav");
    
    //Create the MusicPlayer track list.
    my_player.newList(songs);
    
    //Create the Common pause button used across several components
    final JButton pause = new JButton();
    
    //Create the Panel with the background image
    final BackgroundPanel background = new BackgroundPanel();
    my_board.addObserver(background);
    
    //Create the GameBoard
    final GameBoard game_board = new GameBoard(my_board, my_timer, my_paused, my_player, 
                                               the_font, pause);
    my_board.addObserver(game_board);
    
    //Create the second Panel that the remaining panels will be displayed on.
    final JPanel panel = new JPanel();
    panel.setOpaque(false);
    panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
    
    //Create the NextPeice panel.
    final NextBoard next_board = new NextBoard(my_board);
    my_board.addObserver(next_board);
    next_board.setAlignmentX(Component.CENTER_ALIGNMENT);
    
    //Create the ScoreSheet.
    final ScoreSheet score_sheet = new ScoreSheet(my_timer);
    my_board.addObserver(score_sheet);
    
    //Create the ScoreLabel Panel.
    final ScoreLabel score = new ScoreLabel(score_sheet, the_font);
    my_board.addObserver(score);
    score.setAlignmentX(Component.CENTER_ALIGNMENT);
    
    //Add components to the second Panel
    panel.add(next_board);
    panel.add(score);
    panel.add(new ButtonPanel(pause, the_font, my_game_frame, my_timer, my_paused, my_board,
                              score_sheet, my_player, game_board));
    
    //Add Panels to Background.
    background.add(game_board);
    background.add(panel);
    
    //Set up the frame for display.
    my_game_frame.add(background);
    my_game_frame.setTitle("Tetris TSCC 305 Spring 2013");
    my_game_frame.setLocationRelativeTo(the_frame);
    my_game_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    my_game_frame.pack();
    my_game_frame.setResizable(false);
    my_game_frame.setVisible(true);
    
    my_timer.start();
  }
}
