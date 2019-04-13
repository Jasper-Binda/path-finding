package maze.core;

import java.util.HashSet;
import java.util.Set;

public class Node {

    private int[] position;
    private int cost = 999;
    private int path = cost;
    private int heuristic = cost;
    private Set<Node> neighbors = new HashSet<>();
    private Node parent;

    public Node (int x, int y) {
        this.position = new int[]{x, y};
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

    public void setCost(Node current, int path) {
        if (this.path > path) {
            this.path = path;
            this.parent = current;
        }
        this.cost = this.path + this.heuristic;
    }

    public Node getParent() {
        return parent;
    }

    public int[] getPosition() {
        return position;
    }

}
