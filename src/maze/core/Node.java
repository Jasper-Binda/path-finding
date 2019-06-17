package maze.core;

import java.util.HashSet;
import java.util.Set;

public class Node {

    private final int step = 1;

    private Node parent;
    private Set<Node> neighbors = new HashSet<>();
    private int heuristic = Short.MAX_VALUE;
    private int cost = heuristic + step;
    private int x;
    private int y;

    public Node (int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getHeuristic() {
        return heuristic;
    }

    public void setHeuristic(int heuristic) {
        this.heuristic = heuristic;
    }

    public Set<Node> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(Set<Node> neighbors) {
        this.neighbors = neighbors;
    }

    public int getCost() {
        return cost;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node current) {
        this.parent = current;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
