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
public class Project {
    public enum ProjectState {
        VISITING,
        COMPLETED,
        BLANK
    }
    private String name;
    private ProjectState state = ProjectState.BLANK;
    private ArrayList<Project> childrens = new ArrayList<>();
    private HashMap<String, Project> map = new HashMap<>();


    public Project(String name) { this.name = name; }
    public String getName() { return name; }

    public void addNeighbor(Project node) {
        if (!map.containsKey(node.name)) {
            childrens.add(node);
            map.put(node.name, node);
        }
    }

    public ProjectState getState() { return state; }
    public void setState(ProjectState state) { this.state = state; }

    public ArrayList<Project> getChildrens() { return childrens; }
}
