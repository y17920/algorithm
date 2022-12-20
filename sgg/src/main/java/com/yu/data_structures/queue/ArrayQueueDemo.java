package com.yu.data_structures.queue;

import java.util.Scanner;

public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);
        char key = ' ';
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
                    queue.show();
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

class ArrayQueue {
    private int maxSize;//队列最大容量
    private int front;//队列头
    private int rear;//队列尾
    private int[] array;


    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        array = new int[maxSize];
        front = -1;//队列头 数据的前一个位置
        rear = -1;//队列尾  数据的最后一个数据
    }

    public boolean isFull() {
        return rear == maxSize - 1;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void addItem(int n) {
        if (isFull()) {
            System.out.println("队列已满.不能添加");
            throw new RuntimeException("");
        }
        rear++;
        array[rear] = n;
    }

    public int removeItem() {
        if (isEmpty()) {
            System.out.println("队列已空.不能获取");
            throw new RuntimeException("");
        }
        front++;
        return array[front];
    }

    public int head() {
        if (isEmpty()) {
            System.out.println("队列已空.不能获取");
            throw new RuntimeException("");
        }
        return array[front + 1];
    }

    public void show() {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("array[%d]=%d\n", i, array[i]);
        }
    }
}
