package maze.core;

import java.util.*;
import java.util.stream.Collectors;

public class Maze {

    public static final int PATH_TILE = 1;
    private Node start;
    private Node end;
    private Set<Node> nodes;
    private Map<String, Node> positionMap = new HashMap<>();
    private int[][] maze;

    Maze(int[][] maze) {
        this.maze = maze;
        long startTime = System.currentTimeMillis();
        this.nodes = createNodes();
        linkNeighbors();
        long endTime = System.currentTimeMillis();
        System.out.println("Initializing maze: " + (endTime - startTime) + "ms");
    }

    private Set<Node> createNodes() {
        Set<Node> nodes = new HashSet<>();
        for (int row = 0; row < maze[0].length; row++) {
            for (int column = 0; column < maze.length; column++) {
                if(maze[row][column] == PATH_TILE) {
                    Node node = createNode(row, column);
                    nodes.add(node);
                }
            }
        }
        return nodes;
    }

    private Node createNode(int row, int column) {
        Node node = new Node(row, column);
        positionMap.put("" + row + "-" + column, node);
        if (row == 0 && column == 0) {
            this.start = node;
        } else if (row == maze.length - 1 && column == maze.length -1) {
            this.end = node;
        }
        return node;
    }

    private void linkNeighbors() {
        for (Node node : this.nodes) {
            setNeighbors(node);
        }
    }

    private void setNeighbors(Node node) {
        node.setNeighbors(Direction.stream()
            .map(dir -> positionMap.get(dir.getPosition(node.getX(), node.getY())))
            .filter(Objects::nonNull)
            .collect(Collectors.toSet()));
    }

    public Set<Node> getNodes() {
        return nodes;
    }

    public Node getStart() {
        return start;
    }

    public Node getEnd() {
        return end;
    }
}
