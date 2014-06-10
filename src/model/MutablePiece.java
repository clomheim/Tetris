/*
 * TCSS 305 - Spring 2013 Project Tetris
 */

package model;

import java.awt.Color;

/**
 * This interface defines the required operations of mutable Tetris pieces.
 * 
 * @author Alan Fowler
 * @version Spring 2013
 */
public interface MutablePiece
{

  /** Default Color used for I-Pieces. */
  Color I = new Color(11, 243, 11); //Custom color for I pieces

  /** Default Color used for J-Pieces. */
  Color J = Color.WHITE; //Custom color for J pieces

  /** Default Color used for L-Pieces. */
  Color L = new Color(132, 57, 172); //Custom color for L pieces

  /** Default Color used for S-Pieces. */
  Color S = new Color(247, 80, 23); //Custom color for S pieces

  /** Default Color used for Z-Pieces. */
  Color Z = new Color(220, 10, 15); //Custom color for Z pieces

  /** Default Color used for O-Pieces. */
  Color O = new Color(49, 160, 221); //Custom color for O pieces

  /** Default Color used for T-Pieces. */
  Color T = new Color(34, 34, 68); //Custom color for T pieces

  /** Shifts the piece one space to the left. */
  void moveLeft();

  /** Shifts the piece one space to the right. */
  void moveRight();

  /** Shifts the piece one space down. */
  void moveDown();

  /** Rotates the piece one quarter turn clockwise. */
  void rotate();

  /** @return the x coordinate of this Piece. */
  int getX();

  /** @return the y coordinate of this Piece. */
  int getY();
}
