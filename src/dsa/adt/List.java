package dsa.adt;

import dsa.exception.OutOfBoundaryException;

public interface List {
    //�������Ա�Ĵ�С��������Ԫ�صĸ�����
    int getSize();

    //������Ա�Ϊ�շ���true�����򷵻�false��
    boolean isEmpty();

    //�ж����Ա��Ƿ��������Ԫ��e
    boolean contains(Object e);

    //��������Ԫ��e�����Ա��е����
    int indexOf(Object e);

    //������Ԫ��e���뵽���Ա���i��λ��
    void insert(int i, Object e) throws OutOfBoundaryException;

    //������Ԫ��e���뵽Ԫ��obj֮ǰ
    boolean insertBefore(Object obj, Object e);

    //������Ԫ��e���뵽Ԫ��obj֮��
    boolean insertAfter(Object obj, Object e);

    //ɾ�����Ա������Ϊi��Ԫ��,������֮
    Object remove(int i) throws OutOfBoundaryException;

    //ɾ�����Ա��е�һ����e��ͬ��Ԫ��
    boolean remove(Object e);

    //�滻���Ա������Ϊi������Ԫ��Ϊe������ԭ����Ԫ��
    Object replace(int i, Object e) throws OutOfBoundaryException;

    //�������Ա������Ϊi������Ԫ��
    Object get(int i) throws OutOfBoundaryException;
}
