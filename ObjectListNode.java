// ObjectListNode.java
/**
 * ObjectListNode Class creates nodes containing an info field and a next field. 
 * Provides methods to set info, get info, set next, and get next.
 */
public class ObjectListNode implements ObjectListNodeInterface {
    private Object info;
    private ObjectListNode next;

    /**
     * Default constructor
     */    
    public ObjectListNode() {
        info = null;
        next = null;
    }

    /**
     * One-arg constructor
     */
    public ObjectListNode (Object o) {
        info = o;
        next = null;
    }    

    /**
     * Two-arg constructor
     */
    public ObjectListNode (Object o, ObjectListNode p) {
        info = o;
        next = p;
    }       

    /**
     * Sets info field
     * 
     * @param   Object for info field to be set to
     */
    public void setInfo(Object o) {
        info = o;
    }    

    /**
     * Returns object in info field
     * 
     * @return  info field
     */
    public Object getInfo() {
        return info;
    }

    /**
     * Sets next field
     * 
     * @param   node to set the next field to
     */
    public void setNext(ObjectListNode p) {
        next = p;
    }

    /**
     * Returns object in info field
     * 
     * return   next field's node
     */
    public ObjectListNode getNext() {
        return next;
    }
}