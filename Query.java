import java.io.*;
import java.util.Scanner;
/**
 * Query Class allows users to query the Binary Search tree wordTree at runtime.
 *
 * @author Joshua Matson
 * @version 5/17/2019
 */
public class Query
{
    // instance variables 
    PrintWriter pw;
    ObjectBinaryTree wordTree;
    ObjectTreeNode wordNode;
    Word w;
    
    /**
     * Constructor for Query class objects.
     */
    public Query(ObjectBinaryTree wordTree, PrintWriter pw) {
        this.wordTree = wordTree;
        this.wordNode = new ObjectTreeNode();
        this.w = new Word();
        this.pw = pw;
    }

    /**
     * Allows users to query the binary search tree at runtime.
     */
    public void wordQuery() { 
        System.out.println("\n" + "Enter your cross reference query or enter 'q' to exit: \n");
        pw.printf("%n");
        pw.println("Enter your cross reference query or enter 'q' to exit: \n"); 
        String userIn;
        Scanner in = new Scanner(System.in);
        // terminates when user enters sentinal value "q"
        while(true) {
            userIn = in.nextLine();
            pw.println(userIn);
            w = new Word(userIn);
            if(userIn.equals("q")) {
                break;
                // check if searched word is not on the list or is ommited.
            } else if(wordTree.searchBST(w) == null){
                System.out.println("Word is not on the list or is ommited.");
                pw.println("Word is not on the list or is ommited.");
                continue;
            } else {
                wordNode = wordTree.searchBST(w);
                w = (Word) wordNode.getInfo();
                w.visit();
            }            
        }
    }
}

