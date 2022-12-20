package com.yu.data_structures.sparsearray;

/**
 * 稀疏数组
 * 二维数组 转 稀疏数组的思路
 * 1. 遍历  原始的二维数组，得到有效数据的个数 sum
 * 2. 根据sum 就可以创建 稀疏数组 sparseArr   int[sum + 1] [3]
 * 3. 将二维数组的有效数据数据存入到 稀疏数组
 *
 * 稀疏数组转原始的二维数组的思路
 *
 * 1. 先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组，比如上面的  chessArr2 = int [11][11]
 * 2. 在读取稀疏数组后几行的数据，并赋给 原始的二维数组 即可.
 */
public class SparseArray {
    public static void main(String[] args) {
        int[][] array = new int[11][10];
        array[1][2] = 1;
        array[2][3] = 2;

        System.out.println("原始二维数组");
        for (int[] ints : array) {
            for (int anInt : ints) {
                System.out.printf("%d\t",anInt);
            }
            System.out.println();
        }
        /*遍历  原始的二维数组，得到有效数据的个数 sum*/
        int sum = 0;
        for (int[] ints : array) {
            for (int anInt : ints) {
                if (anInt != 0){
                    sum++;
                }
            }
        }
        /*创建数组*/
        int[][] sparseArr = new int[sum + 1][3];
        //保存数据
        sparseArr[0][0] = array.length;
        sparseArr[0][1] = array[0].length;
        sparseArr[0][2] = sum;
        int cont = 1;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] !=0){
                    sparseArr[cont][0] = i;
                    sparseArr[cont][1] = j;
                    sparseArr[cont][2] = array[i][j];
                    cont++;
                }
            }
        }

        System.out.println("稀疏数组");
        for (int[] ints : sparseArr) {
            for (int anInt : ints) {
                System.out.printf("%d\t",anInt);
            }
            System.out.println();
        }


        int[][] arr = new int[sparseArr[0][0]][sparseArr[0][1]];

        for (int i = 1; i < sparseArr.length; i++) {
            int[] ints = sparseArr[i];
            arr[ints[0]][ints[1]] = ints[2];

        }

        System.out.println("稀疏数组转");
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.printf("%d\t",anInt);
            }
            System.out.println();
        }
    }

}
