package com.vthakkar;
/*
Zero Matrix: Write an algorithm such that if an element in an MxN matrix is 0,
its entire row and column are set to 0.
ctci pg. 215. Check out for other solutions
 */
public class ZeroMatrix {
    public static void setZero(int[][] matrix) {
        boolean[] row = new boolean[matrix.length];
        boolean[] column = new boolean[matrix[0].length];

        /* Find the [row][column] with zero and flag that row and column */
        for(int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = Boolean.TRUE;
                    column[j] = Boolean.TRUE;
                }
            }
        }

        /* iterate through above flagged row and set the row to zero */
        for(int i = 0; i < row.length; i++) {
            if (row[i]) {
                for(int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        /* iterate through above flagged column and set the row to zero */
        for(int j = 0; j < column.length; j++) {
            if (column[j]) {
                for(int i = 0; i < matrix.length; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }


    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%d \t", matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static int[][] buildMatrix(int size) {
        int count = 0;
        int[][] newMatrix = new int[size][size];
        for(int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                newMatrix[i][j] = count++;
            }
        }
        return newMatrix;
    }
}
