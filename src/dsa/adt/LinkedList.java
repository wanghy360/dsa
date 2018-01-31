package dsa.adt;

import dsa.exception.InvalidNodeException;
import dsa.exception.OutOfBoundaryException;

public interface LinkedList {
    //查询链接表当前的规模
    int getSize();

    //判断链接表是否为空
    boolean isEmpty();

    //返回第一个结点
    Node first() throws OutOfBoundaryException;

    //返回最后一结点
    Node last() throws OutOfBoundaryException;

    //返回p之后的结点
    Node getNext(Node p) throws InvalidNodeException, OutOfBoundaryException;

    //返回p之前的结点
    Node getPre(Node p) throws InvalidNodeException, OutOfBoundaryException;

    //将e作为第一个元素插入链接表,并返回e所在结点
    Node insertFirst(Object e);

    //将e作为最后一个元素插入列表,并返回e所在结点
    Node insertLast(Object e);

    //将e插入至p之后的位置,并返回e所在结点
    Node insertAfter(Node p, Object e) throws InvalidNodeException;

    //将e插入至p之前的位置,并返回e所在结点
    Node insertBefore(Node p, Object e) throws InvalidNodeException;

    //删除给定位置处的元素，并返回之
    Object remove(Node p) throws InvalidNodeException;

    //删除首元素，并返回之
    Object removeFirst() throws OutOfBoundaryException;

    //删除末元素，并返回之
    Object removeLast() throws OutOfBoundaryException;

    //将处于给定位置的元素替换为新元素，并返回被替换的元素
    Object replace(Node p, Object e) throws InvalidNodeException;

    //元素迭代器
    Iterator elements();
}