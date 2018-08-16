package com.vthakkar;

import org.junit.jupiter.api.Test;

import static com.vthakkar.ZeroMatrix.buildMatrix;
import static com.vthakkar.ZeroMatrix.printMatrix;
import static com.vthakkar.ZeroMatrix.setZero;
import static org.junit.jupiter.api.Assertions.*;

class ZeroMatrixTest {

    @Test
    void setZeroTest() {

        int[][] matrix = {{0,1,2,0},
                          {3,4,5,2},
                          {1,3,1,5}};
        System.out.println("Before Zero");
        printMatrix(matrix);
        System.out.println("After Zero");
        setZero(matrix);
        printMatrix(matrix);

        int[][] matrix1 = {{0}};
        System.out.println("Before Zero");
        printMatrix(matrix1);
        System.out.println("After Zero");
        setZero(matrix1);
        printMatrix(matrix1);

        int[][] matrix3 = buildMatrix(3);
        System.out.println("Before Zero");
        printMatrix(matrix3);
        System.out.println("After Zero");
        setZero(matrix3);
        printMatrix(matrix3);

        int[][] matrix4 = buildMatrix(3);
        matrix4[0][2] = 0;
        System.out.println("Before Zero");
        printMatrix(matrix4);
        System.out.println("After Zero");
        setZero(matrix4);
        printMatrix(matrix4);

        int[][] matrix5 = buildMatrix(3);
        matrix5[0][0] = 44;
        matrix5[1][1] = 0;
        System.out.println("Before Zero");
        printMatrix(matrix5);
        System.out.println("After Zero");
        setZero(matrix5);
        printMatrix(matrix5);
    }
}