/**
 * Creates an node for an Object Tree. Contains methods to set info, get info,
 * set left child, set right child, get left child, and get right child.
 */
public class ObjectTreeNode implements ObjectTreeNodeInterface {
    private Object info;
    private ObjectTreeNode left;
    private ObjectTreeNode right;
    
    /**
     * No arg Constructor of class ObjectTreeNode.
     * Sets all class variables to null.
     */
    public ObjectTreeNode() {
        info = null;
        left = null;
        right = null;
    }
    
    /**
     * 1 arg Constructor of class ObjectTreeNode.
     * Sets the info field to the object passed in, and the left and right
     * child to null.
     * 
     * @param   Object to set the info field to
     */
    public ObjectTreeNode (Object o) {
        info = o;
        left = null;
        right = null;
    }
    
    /**
     * 1 arg Constructor of class ObjectTreeNode.
     * Only sets the info field to the Object passed in.
     * 
     * @param   Object to set the info field to
     */
    public void setInfo(Object o) {
        info = o;
    }
    
    /**
     * Gets the info field of the node.
     * 
     * @return  the info field.
     */
    public Object getInfo() {
        return info;
    }
    
    /**
     * Sets the left child of the node to the node passed in.
     * 
     * @param       Node to set the left child to.
     */
    public void setLeft(ObjectTreeNode p) {
        left = p;
    }
    
    /**
     * gets the left child of the node to the node passed in.
     * 
     * @return       ObjectTreeNode of the left child.
     */
    public ObjectTreeNode getLeft() {
        return left;
    }
    
    /**
     * Sets the right child of the node to the node passed in.
     * 
     * @param       Node to set the right child to.
     */
    public void setRight(ObjectTreeNode p) {
        right = p;
    }
    
    /**
     * gets the right child of the node to the node passed in.
     * 
     * @return       ObjectTreeNode of the right child.
     */
    public ObjectTreeNode getRight() {
        return right;
    }
}



