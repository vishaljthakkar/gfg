package com.vthakkar.BuildOrderDFS;

import java.util.ArrayList;
import java.util.HashMap;

/*
CTCI4.7 pg 261
Build Order: You are given a list of projects and a list of dependencies (which is a list of pairs of projects,wherethesecondprojectisdependentonthe rstproject).Allofaproject'sdependencies must be built before the project is. Find a build order that will allow the projects to be built. If there is no valid build order, return an error.
EXAMPLE
Input:
projects: a, b, c, d, e, f
dependencies: (a, d), (f, b), (b, d), (f, a), (d, c) Output:f, e, a, b, d, c
 */
public class Graph {
    private ArrayList<Project> nodes = new ArrayList<>();
    private HashMap<String, Project> map = new HashMap<>();

    public Project getOrCreateNode(String name) {
        if (!map.containsKey(name)) {
            Project node = new Project(name);
            map.put(name, node);
            nodes.add(node);
        }
        return map.get(name);
    }

    public void addEdge(String start, String end) {
        Project from = getOrCreateNode(start);
        Project to = getOrCreateNode(end);
        from.addNeighbor(to);
    }

    public ArrayList<Project> getNodes() { return nodes; }
}
