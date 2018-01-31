package dsa;

import dsa.adt.*;
import dsa.strategy.DefaultStrategy;

public class Test {
    public static void main(String[] args) {
        new Test().testListArray();
    }

    private void test1() {
        ListSLinked listSLinked = new ListSLinked(new DefaultStrategy());
        listSLinked.insertFirst("a");
        listSLinked.insertFirst("b");
        listSLinked.insertFirst("c");
        listSLinked.insertFirst("d");
        listSLinked.insertFirst("e");
        listSLinked.insertFirst(1);
        listSLinked.insertFirst(2);
        listSLinked.insertFirst(3);
        System.out.println(listSLinked.toString());
        System.out.println(listSLinked.indexOf("d"));
        listSLinked.remove(3);
        System.out.println(listSLinked.toString());
    }

    /**
     * 测试{@link LinkedListDLNode},重现其含有bug
     */
    public void testLinkedListDLNode1() {
        LinkedListDLNode nodes = new LinkedListDLNode();
        nodes.insertLast("A");
        nodes.insertLast("B");
        nodes.insertLast("C");
        System.out.println(nodes);
        Node firstNode = nodes.first();
        DLNode firstDLNode = (DLNode) firstNode;

        //这里第二个节点已经被移除了,但是size依然是3，显然是错误的。
        DLNode thirdNode = firstDLNode.getNext().getNext();
        firstDLNode.setNext(thirdNode);
        thirdNode.setPre(firstDLNode);
        System.out.println(nodes.getSize());
        System.out.println(nodes);
    }

    public void testListArray(){
        ListArray list = new ListArray();
        list.insertLast("A");
        list.insertLast("B");
        list.insertLast("C");
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.getSize());
    }
}
