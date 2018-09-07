package com.vthakkar.BuildOrderDFS;

import java.util.ArrayList;
import java.util.Stack;

/*
CTCI4.7 pg 261
Build Order: You are given a list of projects and a list of dependencies (which is a list of pairs of projects,wherethesecondprojectisdependentonthe rstproject).Allofaproject'sdependencies must be built before the project is. Find a build order that will allow the projects to be built. If there is no valid build order, return an error.
EXAMPLE
Input:
projects: a, b, c, d, e, f
dependencies: (a, d), (f, b), (b, d), (f, a), (d, c) Output:f, e, a, b, d, c
 */
public class DFSSolution {

    public static Graph buildGraph(String[] projects, String[][] dependencies) {
        Graph graph = new Graph();

        for(String project : projects) {
            graph.getOrCreateNode(project);
        }

        for(String[] dependency: dependencies) {
            String from = dependency[0];
            String to = dependency[1];
            graph.addEdge(from, to);
        }
        return graph;
    }


    public static boolean doDFS(Project project, Stack<Project> stack) {
        if (project.getState() == Project.ProjectState.VISITING) {
            return false;
        }

        if (project.getState() == Project.ProjectState.BLANK) {
            project.setState(Project.ProjectState.VISITING);
            ArrayList<Project> childrens = project.getChildrens();
            for(Project child : childrens) {
                if (!doDFS(child, stack)) {
                    return false;
                }
            }
            project.setState(Project.ProjectState.COMPLETED);
            stack.push(project);
        }
        return true;
    }

    public static Stack<Project> findOrder(ArrayList<Project> projects) {
        Stack<Project> stack = new Stack<>();
        for(Project project : projects) {
            if (!doDFS(project, stack)) {
                return null;
            }
        }
        return stack;
    }

    public static String[] buildOrderWrapper(String[] projects, String[][] dependencies) {
        Graph graph = buildGraph(projects, dependencies);
        final Stack<Project> order = findOrder(graph.getNodes());
        String[] orderName = new String[order.size()];
        for(int i = 0; i < orderName.length; i++) {
            orderName[i] = order.pop().getName();
        }
        return orderName;
    }

    public static void main(String[] args) {
        String[] projects = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
        String[][] dependencies = {
                {"a", "b"},
                {"b", "c"},
                {"a", "c"},
                {"d", "e"},
                {"b", "d"},
                {"e", "f"},
                {"a", "f"},
                {"h", "i"},
                {"h", "j"},
                {"i", "j"},
                {"g", "j"}};

        String[] buildOrder = buildOrderWrapper(projects, dependencies);
        if (buildOrder == null) {
            System.out.println("Circular Dependency.");
        } else {
            for (String s : buildOrder) {
                System.out.println(s);
            }
        }
    }
}
