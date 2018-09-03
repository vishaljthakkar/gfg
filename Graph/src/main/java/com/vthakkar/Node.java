package com.vthakkar;

public class Node {
    public static enum State {
      UNVISITED,  VISITED, VISITING;
    }
    private Node[] adjacent;
    private String vertex;
    private State state;
    public int adjacentCount;

    public Node(String vertex, int adjacentLength) {
        this.vertex = vertex;
        adjacentCount = 0;
        adjacent = new Node[adjacentLength];
    }

    public void addAdjacent(Node x) {
        if (adjacentCount < adjacent.length) {
            this.adjacent[adjacentCount] = x;
            adjacentCount++;
        } else {
            System.out.println("Cannot add more neighbors");
        }
    }

    public Node[] getAdjacent() {return adjacent;}
    public String getVertex() {return vertex;}

    public void setState(State state) { this.state = state; }
    public State getState() { return this.state; }
}
