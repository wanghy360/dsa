package dsa.adt;


public interface Iterator {
    //�ƶ�����һ��Ԫ��
    void first();

    //�ƶ�����һ��Ԫ��
    void next();

    //�����������Ƿ���ʣ���Ԫ��
    boolean isDone();

    //���ص�ǰԪ��
    Object currentItem();
}
