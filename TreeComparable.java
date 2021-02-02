
/**
 * TreeComparable interface to help sort Word objects within a Binary Search Tree
 * data structure with compareTo(Object o), dictates what to do for 
 * duplicate Words found while constructing the BST with operate(Object o),
 * and outputs the contents of a Word object with visit().
 * 
 * TreeComparable is implemented in the Word class.
 *
 *
 * @author Joshua Matson
 * @version 5/17/2019
 */
public interface TreeComparable
{
    public int compareTo(Object o);
    public void operate(Object o);
    public void visit();
}
