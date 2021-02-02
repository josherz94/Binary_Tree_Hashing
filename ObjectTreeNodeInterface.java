
/**
 * Write a description of interface ObjectTreeNodeInterface here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface ObjectTreeNodeInterface
{
    public void setInfo(Object o);
    
    public Object getInfo();
    
    public void setLeft(ObjectTreeNode p);
    
    public ObjectTreeNode getLeft();
    
    public void setRight(ObjectTreeNode p);
    
    public ObjectTreeNode getRight();
}
