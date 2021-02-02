import java.io.*;
import java.util.Scanner;
/**
 * The Hash class takes in a file hashWords.txt and hashes each string into a integer value that
 * is input into the String[] hashTable via the hash function. The Class uses linear probing to 
 * correct for collisions.
 *
 * @author Joshua Matson
 * @version 5/17/2019
 */
public class Hash
{
    // instance variables 
    private PrintWriter pw;
    final private int TABLESIZE = 37;
    private String[] hashTable;
    private String tokens;
    private int hashCollision = 0;
    private int resCollision = 0;
    
    /**
     * 1 Arg Constructor of Class Hash.
     * Constructs a PrintWriter object.
     */
    public Hash(PrintWriter pw) {
        this.pw = pw;
    }
    
    /**
     * Creates the hash table using hashWords.txt as the input.
     * 
     * @param   file scanner to read in string input from hashWords.txt
     */    
    public void createHashTable(Scanner fileScan) throws IOException {
        // creates the hash table size 37
        hashTable = new String [TABLESIZE];
        // read file line by line until eof
        while(fileScan.hasNext()) {
            String line = fileScan.nextLine();
            linearProbe(line);
        }
        // close file Scanner
        fileScan.close(); 
    }
    
    /**
     * Puts the ommitted Strings into the hash table.
     * Resolves collisions using linear probing.
     * 
     * @param   String line read in from hashWords.txt
     */
    private void linearProbe(String line) throws IOException {
        // count helps differentiate between hash collisions and resolution collisions
        int count = 1;
        // get the hashed string and input it into its correct location
        for(int i = getHash(line); i < TABLESIZE; i++) {
            // input into the table if it contains no value
            if(hashTable[i] == null) {
                hashTable[i] = line;
                break;
                // loops back to first index of the hash table if i reaches the last index
            } else if(i == TABLESIZE - 1) {
                // differentiates hash collisions and resolution collisions
                if(hashTable[i] != null && count == 1) {
                    hashCollision++;
                    count++;
                } else {
                    resCollision++;
                }
                // i will get 0 when the for loop starts again if collision occurs
                i = -1;
                // differentiates hash collisions and resolution collisions
            }   else if (hashTable[i] != null && count == 1) {
                hashCollision++;
                count++;
            } else {
                resCollision++;
            }
        }
    }

    /**
     * Checks if a string is part of the ommited list in the hash table.
     * 
     * @param   String to be checked
     * 
     * @return      true or false if string is ommited or not, respectively.      
     */
    public boolean isOmmited(String s) {
        if(hashTable[getHash(s)] == null) {
            return false;
        } else if (hashTable[getHash(s)].equals(s)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Hash function to calculate hash values to input into the hash table.
     * Uses prime numbers to try and differentiate summed int values.
     * 
     * @param   String to be hashed
     * 
     * @return      Hash value
     * 
     */
    private int getHash(String s) {
        int k = 7;
        int sum = 31;
        // mathematical function to calculate the hash value.
        for (int i = 0; i< s.length(); i++) {
            sum += (k*sum + (int)s.charAt(i)) % 37;
        }
        // further hash value by multiplying sum by 3 modulus TABLESIZE to keep it in range 0-36
        return (sum*3) % TABLESIZE;
    }
    
    /**
     * Outputs the formatted hash table to console and csis.txt
     */
    public void outputTable() {
        System.out.println("The custom hash function used looks like: sum = sum + k*sum+c(i+n), where:");
        System.out.println("k is a constant initialized to 7, sum is initialized to 31, \nc is a character parsed integer value, i is the index of c initialized to 0, and n is the index number.");
        System.out.println("The modulus of each sum is taken to make it fit into the hash table, \nand the final sum is then multiplied by a prime number 3. The final hash is the modulus of the table size.");
        System.out.println("The constants set were obtained by trying out different prime numbers \nto see what makes the hash values more unique; resulting in less collisions. \n");
        
        pw.println("The hash function used is a summation using prime numbers to try and make unique hashes.");
        pw.println("The mathematical function looks like: sum = sum + k*sum+c(i+n), where:");
        pw.println("k is a constant initialized to 7, sum is initialized to 31, \nc is a character parsed integer value, i is the index of c initialized to 0, and n is the index number.");
        pw.println("The modulus of each sum is taken to make it fit into the hash table, \nand the final sum is then multiplied by a prime number 3. The final hash is the modulus of the table size.");
        pw.println("The constants set were obtained by trying out different prime numbers \nto see what makes the hash values more unique; resulting in less collisions. \n");

        System.out.printf("%n %5s %8s %n","KEYS", "VALUES");
        pw.printf("%n %5s %8s %n","KEYS", "VALUES");
        String x = "| ";
        String y = "------------------";
        System.out.println(y);
        pw.println(y);
        for(int i = 0; i < TABLESIZE; i++) {
            if(!(hashTable[i] == null)) {
                if(i >= 10) {
                    System.out.printf("%s %d %-1s %-7s %s %n", x, i, x, hashTable[i], x);
                    System.out.println(y);
                    pw.printf("%s %d %-1s %-7s %s %n", x, i, x, hashTable[i], x);
                    pw.println(y);
                } else {
                    System.out.printf("%s %-2d %-2s %-7s %s %n", x, i, x, hashTable[i], x);
                    System.out.println(y);
                    pw.printf("%s %-2d %-2s %-7s %s %n", x, i, x, hashTable[i], x);
                    pw.println(y);
                }
            } else {
                if(i >= 10) {
                    System.out.printf("%s %d %-10s %s %n", x, i, x, x);
                    System.out.println(y);
                    pw.printf("%s %d %-10s %s %n", x, i, x, x);
                    pw.println(y);
                } else {
                    System.out.printf("%s %-2d %-10s %s %n", x, i, x, x);
                    System.out.println(y);
                    pw.printf("%s %-2d %-10s %s %n", x, i, x, x);
                    pw.println(y);
                }
            }
        }
    }

    /**
     * Outputs the load factor for the hash table.
     */
    public void getLoadFactor(){
        int keyCount = 0;
        for(int i = 0; i < TABLESIZE; i++) {
            if(hashTable[i] != null) {
                keyCount++;
            }
        }
        System.out.printf("Load factor is: %.2f%% %n %n", ((double) keyCount / TABLESIZE) * 100);
        pw.printf("Load factor is: %.2f%% %n %n", ((double) keyCount / TABLESIZE) * 100);
    }

    /**
     * Outputs the hash collisions, resolution collisions, and total collisions.
     */
    public void getCollisions() {
        System.out.println("\n" + "Hash function collisions: " + hashCollision);
        System.out.println("Resolution collisions: " + resCollision);
        System.out.println("Total linear probing collisions: " + (hashCollision + resCollision) + "\n");  
        
        pw.printf("%n");
        pw.println("Hash function collisions: " + hashCollision);
        pw.println("Resolution collisions: " + resCollision);
        pw.println("Total linear probing collisions: " + (hashCollision + resCollision));
    }
}