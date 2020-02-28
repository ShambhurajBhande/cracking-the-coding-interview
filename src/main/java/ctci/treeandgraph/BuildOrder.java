package ctci.treeandgraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/* @author Shambhuraj created on 2/28/2020*/
/*
Build Order: You are given a list of projects and a list of dependencies (which is a list of pairs of
projects, where the second project is dependent on the first project). All of a project's dependencies
must be built before the project is. Find a build order that will allow the projects to be built. If there
is no valid build order, return an error.
EXAMPLE
Input:
projects: a, b, c, d, e, f
dependencies: (a, d), (f, b), (b, d), (f, a), (d, c)
Output: f, e, a, b, d, c
* */
public class BuildOrder {

    public static void main(String[] args) {
        String[] projects = {"a", "b", "c", "d", "e","f"};
        String[][] dependencies = {
                {"a", "b"},
                {"b", "c"},
                {"a", "c"},
                {"d", "e"},
                {"b", "d"},
                {"e", "f"},
                {"a", "f"},
               };
        BuildOrder buildOrder = new BuildOrder();
        Graph graph = buildOrder.buildGraph(projects, dependencies);
        Stack<Project> projectStack = orderProject(graph.getNodes());
        for (Project project : projectStack){
            System.out.print(project.getName()+"->");
        }
    }

    private static Stack<Project> orderProject(ArrayList<Project> projects) {
        Stack<Project> stack = new Stack<>();
        for (Project project : projects) {
            if (project.getState() == State.BLANK) {
                if (!doGFS(project, stack)) {
                    return null;
                }
            }
        }
        return stack;
    }

    private static boolean doGFS(Project project, Stack<Project> stack) {
        if (project.getState() == State.PARTIAL) {
            return false;
        }
        if (project.getState() == State.BLANK) {
            project.setState(State.PARTIAL);
            ArrayList<Project> children = project.getChildren();
            for (Project child : children) {
                if (!doGFS(child, stack)) {
                    return false;
                }
            }
            project.setState(State.COMPLETE);
            stack.add(project);
        }
        return true;
    }

    Graph buildGraph(String[] projects, String[][] dependencies) {
        Graph graph = new Graph();
        for (String project : projects)
            graph.getOrCreateNode(project);
        for (String[] dependency : dependencies)
            graph.addEdge(dependency[0], dependency[1]);
        return graph;
    }

    public class Graph {
        private ArrayList<Project> nodes = new ArrayList<Project>();
        private HashMap<String, Project> map = new HashMap<String, Project>();

        public Project getOrCreateNode(String name) {
            if (!map.containsKey(name)) {
                Project node = new Project(name);
                nodes.add(node);
                map.put(name, node);
            }
            return map.get(name);
        }

        public void addEdge(String startName, String endName) {
            Project start = getOrCreateNode(startName);
            Project end = getOrCreateNode(endName);
            start.addNeighbor(end);
        }

        public ArrayList<Project> getNodes() {
            return nodes;
        }
    }

    public enum State {COMPLETE, PARTIAL, BLANK}


    public class Project {
        private ArrayList<Project> children = new ArrayList<Project>();
        private HashMap<String, Project> map = new HashMap<String, Project>();
        private String name;
        private int dependencies = 0;

        private State state = State.BLANK;

        public State getState() {
            return state;
        }

        public void setState(State st) {
            state = st;
        }

        public Project(String n) {
            name = n;
        }

        public void addNeighbor(Project node) {
            if (!map.containsKey(node.getName())) {
                children.add(node);
                node.incrementDependencies();
            }
        }

        public void incrementDependencies() {
            ++dependencies;
        }

        public void decrementDependencies() {
            --dependencies;
        }

        public String getName() {
            return name;
        }

        public ArrayList<Project> getChildren() {
            return children;
        }

        public int getNumberDependencies() {
            return dependencies;
        }

    }


}