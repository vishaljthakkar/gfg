package com.vthakkar.EdgeRemoval;

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
public class Project {
    ArrayList<Project> children = new ArrayList<>();
    HashMap<String, Project> map = new HashMap<>();
    private String name;
    private int dependencies = 0;

    public Project(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addNeighbor(Project node) {
        if (!map.containsKey(node.name)) {
            children.add(node);
            map.put(node.name, node);
            node.incrementDependency();
        }
    }

    public void incrementDependency() { dependencies++; }

    public void decrementDependencies() { dependencies--; }

    public ArrayList<Project> getChildren() { return children; }

    public int getNumberDependencies() { return dependencies; }
}
