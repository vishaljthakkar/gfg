package com.vthakkar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RouteBetweenTest {
    Graph g = new Graph();

    @BeforeEach
    void setup() {
        Node[] temp = new Node[6];
        temp[0] = new Node("a", 3);
        temp[1] = new Node("b", 0);
        temp[2] = new Node("c", 0);
        temp[3] = new Node("d", 1);
        temp[4] = new Node("e", 1);
        temp[5] = new Node("f", 0);
        temp[0].addAdjacent(temp[1]);
        temp[0].addAdjacent(temp[2]);
        temp[0].addAdjacent(temp[3]);
        temp[3].addAdjacent(temp[4]);
        temp[4].addAdjacent(temp[5]);

        for(int i = 0; i < 6; i++) {
            g.addNode(temp[i]);
        }
    }

    @Test
    void routeBetweenNodes() {
        Node[] vertices = g.getVertices();
        Node start = vertices[1];
        Node end = vertices[5];
        assertFalse(RouteBetween.routeBetweenNodes(g, start, end));
    }

    @Test
    void routeBetweenNodes2() {
        Node[] vertices = g.getVertices();
        Node start = vertices[0];
        Node end = vertices[5];
        assertTrue(RouteBetween.routeBetweenNodes(g, start, end));
    }
}