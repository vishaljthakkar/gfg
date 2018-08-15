package com.vthakkar;

/* Rotate Matrix: Given an image represented by an NxN matrix,
 where each pixel in the image is 4 bytes, write a method to rotate the image by 90 degrees.
  Can you do this in place?

  ctci pg. 214
 */

/*
    For 2 * 2 and 3 * 3 following sequence of swaps works

    top left <-> top right
    top left <-> bottom right
    top left <-> bottom left

    for matrix above size that we need to do it layer by layer

    https://www.youtube.com/watch?v=Jtu6dJ0Cb94
 */
public class RotateMatrix {


    public static void rotateMatrix(int[][] inputMatrix) {
        int last = inputMatrix.length - 1;
        int totalLevels = inputMatrix.length / 2;
        int level = 0;

        while (level < totalLevels) {
            for (int i = level; i < last; i++) {
                swap(inputMatrix, level, i, i, last);
                swap(inputMatrix, level, i, last, last - i + level);
                swap(inputMatrix, level, i, last - i + level, level);
            }
            level++;
            last--;
        }

    }

    private static void swap(int[][] matrix, int srcI, int srcJ, int destI, int destJ) {
        int temp = matrix[srcI][srcJ];
        matrix[srcI][srcJ] = matrix[destI][destJ];
        matrix[destI][destJ] = temp;
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
    public static void main(String[] args) {


    }
}
