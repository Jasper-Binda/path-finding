package maze.core;

import java.util.*;
import java.util.stream.Collectors;

public class Maze {

    private Node start;
    private Node end;
    private Set<Node> nodes;
    private Map<String, Node> positionNodeMap = new HashMap<>();
    private int[][] maze;

    public Maze(int[][] maze) {
        this.maze = maze;
        long startTime = System.currentTimeMillis();
        this.nodes = createNodes();
        setNeighbors();
        long endTime = System.currentTimeMillis();
        System.out.println("Initializing maze: " + (endTime - startTime) + "ms");
    }

    private Set<Node> createNodes() {
        Set<Node> nodes = new HashSet<>();
        for (int row = 0; row < maze[0].length; row++) {
            for (int column = 0; column < maze.length; column++) {
                if(maze[row][column] == 1) {
                    Node node = new Node(row, column);
                    nodes.add(node);
                    positionNodeMap.put("" + row + "-" + column, node);
                    if (row == 0) {
                        this.start = node;
                    } else if (row == maze.length - 1) {
                        this.end = node;
                    }
                }
            }
        }
        return nodes;
    }

    private void setNeighbors() {
        for (Node node : this.nodes) {
            List<Node> neighbors = new ArrayList<>();
            int x = node.getPosition()[0];
            int y = node.getPosition()[1];

            neighbors.add(positionNodeMap.get("" + (x - 1) + "-" + y));
            neighbors.add(positionNodeMap.get("" + (x + 1) + "-" + y));
            neighbors.add(positionNodeMap.get("" + x + "-" +(y - 1)));
            neighbors.add(positionNodeMap.get("" + x + "-" +(y + 1)));
            node.setNeighbors(neighbors.stream()
                    .filter(Objects::nonNull)
                    .collect(Collectors.toSet()));
        }
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
