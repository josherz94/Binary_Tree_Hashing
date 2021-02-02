import java.io.*;
/**
 * The Word class defines a Word object. A Word object may be constructed given a String and 
 * LinePosition, a String word, or no parameters. 
 *
 * @author Joshua Matson
 * @version 5/17/2019
 */
public class Word implements TreeComparable
{
    // instance variables 
    private PrintWriter pw;
    private String word;
    private int wordCount;
    private ObjectList wordList;
    private LinePosition linePosition;
    /**
     * 3 arg constructor for objects of class Word.
     * Creates a Word object given a String, a LinePosition object and a PrintWriter Object.
     */
    public Word(String word, LinePosition linePosition, PrintWriter pw)
    {
        // initialise instance variables
        this.word = word;
        this.linePosition = linePosition;
        this.wordList = new ObjectList();
        this.pw = pw;
    }

    /**
     * 1 arg constructor for objects of class Word.
     * Creates a word given only a String.
     */
    public Word(String word) {
        this.word = word;
    }
    
    /**
     * no arg constructor for objects of class Word.
     */
    public Word() {}

    /**
     * Compares Word objects with objects of Java's Object Class.
     * 
     * @param   Object to be compared to Word objects
     * @return  compared java Object with an object of Class Word.
     */
    public int compareTo(Object o) {
        Word w = (Word) o;
        // compare last name to use in Payroll's sort method
        return word.compareTo(w.getWord());
    }

    /**
     * Operate dictates what to do for duplicates
     * if duplicate found, increase counter
     * and attach a node to the end of the linear linked list
     * which indicates the line number in which the word appeared
     * and the position on the line in which the word appeared.
     */
    public void operate(Object o) {
        Word w = (Word) o;
        wordCount++;
        ObjectListNode wordNode = new ObjectListNode(w.getLinePosition());
        wordList.addLast(wordNode);
    }
   
    /**
     * visit method will print out:
     * the word, the number of times the word appears,
     * and the line number and position on the line for each
     * for each time the word appears.
     */
    public void visit() {
        System.out.printf("%-12s %-12s", word, wordCount);
        pw.printf("%-12s %-12s", word, wordCount);
        ObjectListNode wPtr = new ObjectListNode();
        LinePosition lp;
        wPtr = wordList.getFirstNode();
        int count = 0;
        while(wPtr != null) {
            lp = (LinePosition) wPtr.getInfo();
            System.out.printf("%-8S", lp.getLineNumber() + "-" + lp.getWordPosition());
            pw.printf("%-8S", lp.getLineNumber() + "-" + lp.getWordPosition());
            wPtr = wPtr.getNext();
        }
        System.out.println();
        pw.println();
    }

    /**
     * Returns reference to a LinePosition object that a Word object contains.
     * 
     * @return  LinePosition object
     */
    public LinePosition getLinePosition() {
        return linePosition;
    }

    /**
     * Returns a String of a Word object.
     * 
     * @return  String word contained by a Word object.
     */
    public String getWord() {
        return this.word;
    }

    /**
     * Increases word counter by 1.
     */
    private void tickCounter() {
        wordCount++;
    }
}
