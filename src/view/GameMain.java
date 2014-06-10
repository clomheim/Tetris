/* TCSS 305 Spring 2013
 * dlomheim_tetris
 */
package view;

import com.sun.media.codec.audio.mp3.JavaDecoder;
import javax.media.Codec;
import javax.media.PlugInManager;

/**
 * This class begins the Tetris game.
 * 
 * @author Doug Lomheim
 * @version 0.1.20130608
 */
public final class GameMain
{
  /**
   * Private constructor to prevent instantiation.
   */
  private GameMain()
  {
    //Unused.
  }

  /**
   * Starting point for the program.
   * 
   * @param the_args Unused in this class.
   */
  public static void main(final String[] the_args)
  {
    final Codec c = new JavaDecoder();
    PlugInManager.addPlugIn("com.sun.media.codec.audio.mp3.javaDecoder",
                            c.getSupportedInputFormats(),
                            c.getSupportedOutputFormats(null),
                            PlugInManager.CODEC);
    
    new WelcomeFrame().start();

  }

}
