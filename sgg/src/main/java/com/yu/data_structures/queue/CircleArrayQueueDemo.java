package com.yu.data_structures.queue;

import java.util.Scanner;

public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        CircleArrayQueue queue = new CircleArrayQueue(4);
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s(show)显示队列");
            System.out.println("e(exit)退出程序");
            System.out.println("a(add)添加");
            System.out.println("g(get)获取");
            System.out.println("h(head)头部");
            char c = scanner.next().charAt(0);
            switch (c) {
                case 's':
                    try {
                        queue.show();
                    } catch (Exception e) {
                    }
                    break;
                case 'e':
                    loop = false;
                    break;
                case 'a':
                    int nextInt = scanner.nextInt();
                    try {
                        queue.addItem(nextInt);
                    } catch (Exception e) {
                    }
                    break;
                case 'g':
                    try {
                        System.out.println(queue.removeItem());
                    } catch (Exception e) {
                    }
                    break;
                case 'h':
                    System.out.println(queue.head());
                    break;
            }

        }
    }
}

class CircleArrayQueue {
    private int maxSize;//队列最大容量
    private int front;//队列头 当前队列头索引
    private int rear;//队列尾后的一个索引  默认空一个
    private int[] array;//默认空一个数据


    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        array = new int[maxSize];
        front = 0;//队列头 数据的当前位置
        rear = 0;//队列尾  数据的最后一个位置后一个
    }

    public boolean isFull() {
        //+1 是因为保留一个空位
        return (rear + 1) % maxSize == front;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void addItem(int n) {
        if (isFull()) {
            System.out.println("队列已满.不能添加");
            throw new RuntimeException("");
        }
        array[rear] = n;
        rear = (rear + 1) % maxSize;
    }

    public int removeItem() {
        if (isEmpty()) {
            System.out.println("队列已空.不能获取");
            throw new RuntimeException("");
        }
        int i = array[front];
        front = (front + 1) % maxSize;
        return i;
    }

    public int head() {
        if (isEmpty()) {
            System.out.println("队列已空.不能获取");
            throw new RuntimeException("");
        }
        return array[front];
    }

    public void show() {
        if (isEmpty()) {
            System.out.println("队列为空.");
            throw new RuntimeException("");
        }
        for (int i = front; i < front + queueSize(); i++) {
            int index = i % maxSize;
            System.out.printf("array[%d]=%d\n", index, array[index]);
        }
    }

    public int queueSize() {
        return (rear + maxSize - front) % maxSize;
    }
}