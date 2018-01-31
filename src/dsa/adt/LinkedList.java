package dsa.adt;

import dsa.exception.InvalidNodeException;
import dsa.exception.OutOfBoundaryException;

public interface LinkedList {
    //��ѯ���ӱ�ǰ�Ĺ�ģ
    int getSize();

    //�ж����ӱ��Ƿ�Ϊ��
    boolean isEmpty();

    //���ص�һ�����
    Node first() throws OutOfBoundaryException;

    //�������һ���
    Node last() throws OutOfBoundaryException;

    //����p֮��Ľ��
    Node getNext(Node p) throws InvalidNodeException, OutOfBoundaryException;

    //����p֮ǰ�Ľ��
    Node getPre(Node p) throws InvalidNodeException, OutOfBoundaryException;

    //��e��Ϊ��һ��Ԫ�ز������ӱ�,������e���ڽ��
    Node insertFirst(Object e);

    //��e��Ϊ���һ��Ԫ�ز����б�,������e���ڽ��
    Node insertLast(Object e);

    //��e������p֮���λ��,������e���ڽ��
    Node insertAfter(Node p, Object e) throws InvalidNodeException;

    //��e������p֮ǰ��λ��,������e���ڽ��
    Node insertBefore(Node p, Object e) throws InvalidNodeException;

    //ɾ������λ�ô���Ԫ�أ�������֮
    Object remove(Node p) throws InvalidNodeException;

    //ɾ����Ԫ�أ�������֮
    Object removeFirst() throws OutOfBoundaryException;

    //ɾ��ĩԪ�أ�������֮
    Object removeLast() throws OutOfBoundaryException;

    //�����ڸ���λ�õ�Ԫ���滻Ϊ��Ԫ�أ������ر��滻��Ԫ��
    Object replace(Node p, Object e) throws InvalidNodeException;

    //Ԫ�ص�����
    Iterator elements();
}