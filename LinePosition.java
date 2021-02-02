import java.util.Scanner;
import java.io.*;
/**
 * LinePosition class defines a LinePosition object. Creates a LinePosition object
 * given an int line number and word position. LinePosition is stored within a Linear Linked
 * List in a Word Object.
 *
 * @author Joshua Matson
 * @version 5/17/2019
 */
public class LinePosition
{
    // instance variables 
    int lineNumber;
    int wordPosition;
    
    /**
     * Constructor for LinePosition class.
     * Creates a LinePosition object given two integers.
     */
    public LinePosition(int lineNumber, int wordPosition) {
        this.wordPosition = wordPosition;
        this.lineNumber = lineNumber;
    }

    /**
     * Returns the line number.
     * 
     * @return   Line number.
     */
    public int getLineNumber() {
        return lineNumber; 
    }

    /**
     * sets the position of a Word on a line.
     */
    public void setWordPosition() {
        this.wordPosition = wordPosition;
    }

    /**
     * Returns the position of a Word on a line.
     * 
     *  @return      position of a Word on a line
     */
    public int getWordPosition() {
        return wordPosition;
    }
}
