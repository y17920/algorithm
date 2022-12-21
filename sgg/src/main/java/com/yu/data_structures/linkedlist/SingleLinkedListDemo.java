package com.yu.data_structures.linkedlist;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        Node node1 = new Node(1, "11", "111");
        Node node2 = new Node(2, "22", "222");
        Node node3 = new Node(3, "33", "333");
        Node node4 = new Node(4, "44", "444");
        Node node5 = new Node(3, "443", "4443");
        SingleLinkedList linkedList = new SingleLinkedList();
//        linkedList.add(node1).add(node2).add(node3).add(node4).show();

        linkedList.addByOrder(node3).addByOrder(node4).addByOrder(node1).addByOrder(node2).show();
        System.out.println();
        linkedList.update(node5).show();
        System.out.println();
        linkedList.del(2).show();


    }
}


class SingleLinkedList {
    private Node head = new Node(0, null, null);

    public SingleLinkedList add(Node node) {
        Node tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = node;
        return this;
    }

    public SingleLinkedList addByOrder(Node node) {
        Node tmp = head;
        while (tmp.next != null) {
            if (tmp.next.no > node.no) {
                node.next = tmp.next;
                tmp.next = node;
                return this;
            } else if (tmp.next.no == node.no) {
                System.out.println("已经存在同样的no" + node);
                return this;
            }
            tmp = tmp.next;
        }
        tmp.next = node;
        return this;
    }

    /**
     * 根据节点no更新
     */
    public SingleLinkedList update(Node node) {
        if (isEmpty()) {
            System.out.println("单链表为空");
        }
        Node tmp = head;
        while (tmp.next != null) {
            if (tmp.next.no == node.no){
                //赋值
/*                tmp.next.name = node.name;
                tmp.next.niceName = node.niceName;*/
                node.next = tmp.next.next;
                tmp.next = node;
            }
            tmp = tmp.next;
        }
        return this;
    }

    public SingleLinkedList del(int no) {
        Node tmp = head;
        while (tmp.next != null) {
            if (tmp.next.no == no){
                tmp.next = tmp.next.next;
            }
            tmp = tmp.next;
        }
        return this;
    }

    public void show() {
        if (isEmpty()) {
            System.out.println("单链表为空");
        }
        Node tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
            System.out.println(tmp.toString());
        }
    }

    public boolean isEmpty() {
        return head.next == null;
    }
}

//节点
class Node {
    public int no;
    public String name;
    public String niceName;

    public Node next;

    public Node(int no, String name, String niceName) {
        this.no = no;
        this.name = name;
        this.niceName = niceName;
    }

    @Override
    public String toString() {
        return "Node{" + "no=" + no + ", name='" + name + '\'' + ", niceName='" + niceName + '\'' + '}';
    }
}
