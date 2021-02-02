import java.util.Scanner;
import java.io.*;
/**
 * Xref is the main driver of the cross reference program. Xref is responsible for creating
 * the binary search tree, adding Word objects as nodes on the tree and iterating through them.
 * Xref's main job is to make cross reference listing for text documents.
 * 
 * @author Joshua Matson id# 012024010   
 * @version 5/17/2019
 */
public class Xref
{
    /**
     * Makes calls to create the hash table, outputs the table, collisions and load factor.
     * Also creates the binary search tree given getty.txt, ommiting the words within the 
     * hash table. Main also does an inorder traversal of the tree, outputing each node and
     * it's contents and allows the user to input runtime querys.
     */
    public static void main(String[] args) throws IOException{
        //opens hashwords.txt and creates the hashTable, and hashes the ommited words.
        Scanner hashFile = new Scanner(new File("hashwords.txt"));
        PrintWriter pw = new PrintWriter(new FileWriter("csis.txt"));
        Hash hash = new Hash(pw);
        hash.createHashTable(hashFile);
        hashFile.close();
        // Outputs the hash table
        hash.outputTable();
        hash.getCollisions();
        hash.getLoadFactor();
        // Creates the binary search tree and fills it with words from getty.txt
        ObjectBinaryTree wordTree = new ObjectBinaryTree();
        // line counter to count the lines in the text document
        int lineCounter = 0;
        
        System.out.println("Gettysburgh Address: " + "\n");
        pw.println("Gettysburgh Address: ");
        pw.printf("%n");
        
        Scanner fileScan = new Scanner(new File("getty.txt"));
        while(fileScan.hasNext()) {  
            int wordCount = 0;
            ++lineCounter;
            String line = fileScan.nextLine();
            String numLine = lineCounter + ":" + " " + line;
            System.out.println(numLine);
            pw.println(numLine);
            String delims = "[ ]+";
            String[] tokens = line.split(delims);
            // iterates through the String array of words
            int i = 0;
            while(i < tokens.length) {
                // a Word does not contain hyphens.
                if (!tokens[i].equals("-")) {
                    // ommits any special characters (punctuation) that fall before char values < 'a' 
                    if(tokens[i].charAt(tokens[i].length() - 1) < 'a') 
                        tokens[i] = tokens[i].substring(0, tokens[i].length() - 1); 
                    // ommits any strings that are listed in the hash table    
                    if(!hash.isOmmited(tokens[i])) {   
                        LinePosition lp = new LinePosition(lineCounter, i + 1);
                        Word word = new Word(tokens[i].toLowerCase(), lp, pw);
                        word.operate(word);
                        wordTree.insertBSTDup(word);
                    }
                }
                i++;
            }
        }
        fileScan.close();
        System.out.println();
        pw.printf("%n");
        
        System.out.println("Cross reference Listing: " + "\n");
        pw.println("Cross reference Listing: ");
        pw.printf("%n");
        
        System.out.printf("%1s %14s %29s %n %n", "Word", "Word Count", "Line Number-Line Position");
        pw.printf("%1s %14s %29s %n %n", "Word", "Word Count", "Line Number-Line Position");
        // performs an in order traversal of the BST
        ObjectTreeNode rootNode = new ObjectTreeNode();
        rootNode = wordTree.getRoot();
        wordTree.inTrav(rootNode);
       
        // Starts the runtime query
        Query userQuery = new Query(wordTree, pw);
        userQuery.wordQuery();
        pw.close();
    }
}
