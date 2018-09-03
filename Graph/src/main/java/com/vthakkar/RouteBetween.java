package com.vthakkar;

import java.util.LinkedList;

/* CTCI 4.1 pg. 252 */
public class RouteBetween {

    public static Boolean routeBetweenNodes(Graph g, Node start, Node end) {
        return search(g, start, end);

    }

    private static Boolean search(Graph g, Node start, Node end) {
        if (start == end) {
            return Boolean.TRUE;
        }

        LinkedList<Node> queue = new LinkedList<>();


        for(Node node: g.getVertices()) {
            node.setState(Node.State.UNVISITED);
        }
        start.setState(Node.State.VISITING);
        queue.offer(start);
        Node removed;

        while(!queue.isEmpty()) {
            removed = queue.poll();
            if (removed != null) {
                for(Node n : removed.getAdjacent()) {
                    if (n.getState() == Node.State.UNVISITED) {
                        if (n == end) {
                            return Boolean.TRUE;
                        } else {
                            n.setState(Node.State.VISITING);
                            queue.offer(n);
                        }

                    }
                }
                removed.setState(Node.State.VISITED);
            }
        }
        return Boolean.FALSE;
    }
}
