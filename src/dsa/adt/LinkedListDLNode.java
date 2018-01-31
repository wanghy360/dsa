package dsa.adt;

import dsa.exception.InvalidNodeException;
import dsa.exception.OutOfBoundaryException;

/**
 * <strong>双向链表</strong>
 * <p>这里的问题是，作者强调只暴露{@code Node}给外界，由于{@code Node}没有提供{@code setPre}和{@code setNext}方法，无法修改内部链表结构，所以是安全的。<br/>
 * 但实际上，只要将{@code Node}强转为{@code DLNode},就可以修改节点的前驱和后驱，所以这个实现在本质上依然是不安全的。<br/>
 * 如果想要安全地封装内部实现，最好不好暴露{@code Node}，只暴露结点数据域。<br/>
 * 参照Java官方实现{@link java.util.LinkedList}，Node是私有静态内部类，不对外开放。</p>
 */
public class LinkedListDLNode implements LinkedList {
    private int size;    //规模
    private DLNode head;//头结点,哑元结点
    private DLNode tail;//尾结点,哑元结点

    public LinkedListDLNode() {
        size = 0;
        head = new DLNode();//构建只有头尾结点的链表
        tail = new DLNode();
        head.setNext(tail);
        tail.setPre(head);
    }

    //辅助方法，判断结点p是否合法，如合法转换为DLNode
    private DLNode checkPosition(Node p) throws InvalidNodeException {
        if (p == null)
            throw new InvalidNodeException("错误：p为空。");
        if (p == head)
            throw new InvalidNodeException("错误：p指向头节点，非法。");
        if (p == tail)
            throw new InvalidNodeException("错误：p指向尾结点，非法。");
        DLNode node = (DLNode) p;
        return node;
    }

    //查询链接表当前的规模
    @Override
    public int getSize() {
        return size;
    }

    //判断链接表是否为空
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    //返回第一个结点
    @Override
    public Node first() throws OutOfBoundaryException {
        if (isEmpty())
            throw new OutOfBoundaryException("错误：链接表为空。");
        return head.getNext();
    }

    //返回最后一结点
    @Override
    public Node last() throws OutOfBoundaryException {
        if (isEmpty())
            throw new OutOfBoundaryException("错误：链接表为空。");
        return tail.getPre();
    }

    //返回p之后的结点
    @Override
    public Node getNext(Node p) throws InvalidNodeException, OutOfBoundaryException {
        DLNode node = checkPosition(p);
        node = node.getNext();
        if (node == tail)
            throw new OutOfBoundaryException("错误：已经是链接表尾端。");
        return node;
    }

    //返回p之前的结点
    @Override
    public Node getPre(Node p) throws InvalidNodeException, OutOfBoundaryException {
        DLNode node = checkPosition(p);
        node = node.getPre();
        if (node == head)
            throw new OutOfBoundaryException("错误：已经是链接表前端。");
        return node;
    }

    //将e作为第一个元素插入链接表
    @Override
    public Node insertFirst(Object e) {
        DLNode node = new DLNode(e, head, head.getNext());
        head.getNext().setPre(node);
        head.setNext(node);
        size++;
        return node;
    }

    //将e作为最后一个元素插入列表,并返回e所在结点
    @Override
    public Node insertLast(Object e) {
        DLNode node = new DLNode(e, tail.getPre(), tail);
        tail.getPre().setNext(node);
        tail.setPre(node);
        size++;
        return node;
    }

    //将e插入至p之后的位置,并返回e所在结点
    @Override
    public Node insertAfter(Node p, Object e) throws InvalidNodeException {
        DLNode node = checkPosition(p);
        DLNode newNode = new DLNode(e, node, node.getNext());
        node.getNext().setPre(newNode);
        node.setNext(newNode);
        size++;
        return newNode;
    }

    //将e插入至p之前的位置,并返回e所在结点
    @Override
    public Node insertBefore(Node p, Object e) throws InvalidNodeException {
        DLNode node = checkPosition(p);
        DLNode newNode = new DLNode(e, node.getPre(), node);
        node.getPre().setNext(newNode);
        node.setPre(newNode);
        size++;
        return newNode;
    }

    //删除给定位置处的元素，并返回之
    @Override
    public Object remove(Node p) throws InvalidNodeException {
        DLNode node = checkPosition(p);
        Object obj = node.getData();
        node.getPre().setNext(node.getNext());
        node.getNext().setPre(node.getPre());
        size--;
        return obj;
    }

    //删除首元素，并返回之
    @Override
    public Object removeFirst() throws OutOfBoundaryException {
        return remove(head.getNext());
    }

    //删除末元素，并返回之
    @Override
    public Object removeLast() throws OutOfBoundaryException {
        return remove(tail.getPre());
    }

    //将处于给定位置的元素替换为新元素，并返回被替换的元素
    @Override
    public Object replace(Node p, Object e) throws InvalidNodeException {
        DLNode node = checkPosition(p);
        Object obj = node.getData();
        node.setData(e);
        return obj;
    }

    //元素迭代器
    @Override
    public Iterator elements() {
        return new LinkedListIterator(this);
    }

    @Override
    public String toString() {
        DLNode p = head.getNext();
        Iterator iterator = elements();
        if (iterator.isDone()) {
            return "empty";
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (p != tail) {
            stringBuilder.append(p.getData());
            if (p.getNext() != tail) {
                stringBuilder.append(" -> ");
            }
            p = p.getNext();
        }
        return stringBuilder.toString();
    }
}
