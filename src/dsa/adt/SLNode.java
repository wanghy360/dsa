package dsa.adt;

public class SLNode implements Node {

    private Object element;
    private SLNode next;

    public SLNode() {
        this(null, null);
    }

    public SLNode(Object ele, SLNode next) {
        this.element = ele;
        this.next = next;
    }

    public SLNode getNext() {
        return next;
    }

    public void setNext(SLNode next) {
        this.next = next;
    }

    /****************Node Interface Method**************/
    @Override
    public Object getData() {
        return element;
    }

    @Override
    public void setData(Object obj) {
        element = obj;
    }

    @Override
    public String toString() {
        return "{" +
                "element=" + element +
                ", next=" + next +
                '}';
    }
}
