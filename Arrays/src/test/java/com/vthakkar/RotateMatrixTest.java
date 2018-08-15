package com.vthakkar;

import org.junit.jupiter.api.Test;

import static com.vthakkar.RotateMatrix.buildMatrix;
import static com.vthakkar.RotateMatrix.printMatrix;
import static com.vthakkar.RotateMatrix.rotateMatrix;

class RotateMatrixTest {

    @Test
    void rotateMatrixTest() {
        int[][] matrix2 = buildMatrix(2);
        System.out.println("Original Matrix");
        printMatrix(matrix2);
        rotateMatrix(matrix2);
        System.out.println("90 Degree Rotated Matrix");
        printMatrix(matrix2);

        int[][] matrix3 = buildMatrix(3);
        System.out.println("Original Matrix");
        printMatrix(matrix3);
        rotateMatrix(matrix3);
        System.out.println("90 Degree Rotated Matrix");
        printMatrix(matrix3);

        int[][] matrix4 = buildMatrix(4);
        System.out.println("Original Matrix");
        printMatrix(matrix4);
        rotateMatrix(matrix4);
        System.out.println("90 Degree Rotated Matrix");
        printMatrix(matrix4);

        int[][] matrix5 = buildMatrix(5);
        System.out.println("Original Matrix");
        printMatrix(matrix5);
        rotateMatrix(matrix5);
        System.out.println("90 Degree Rotated Matrix");
        printMatrix(matrix5);

        int[][] matrix10 = buildMatrix(10);
        System.out.println("Original Matrix");
        printMatrix(matrix10);
        rotateMatrix(matrix10);
        System.out.println("90 Degree Rotated Matrix");
        printMatrix(matrix10);

    }
}