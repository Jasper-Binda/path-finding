package maze.algorith;

import maze.core.Maze;
import maze.core.Node;

import java.util.*;

public class Astar {

    private Set<Node> closedNodes = new HashSet<>();
    private PriorityQueue<Node> queue;
    private List<Node> path = new ArrayList<>();

    public Astar(Maze maze) {
        Comparator<Node> priority = Comparator.comparingInt(Node::getCost);
        this.queue = new PriorityQueue<>(maze.getStart().getCost(), priority );
        queue.add(maze.getStart());
        setHeuristics(maze.getNodes(), maze.getEnd());
        findPath();
    }

    public List<Node> getPath() {
        return path;
    }

    private void findPath() {
        while (true) {
            Node current = queue.poll();
            for (Node neighbor : current.getNeighbors()) {
                if (closedNodes.contains(neighbor)) {
                    continue;
                }
                neighbor.setCost(current, calculatePath(current, neighbor));
                queue.add(neighbor);
            }
            closedNodes.add(current);
            if (current.getHeuristic() == 0) {
                setPath(current);
                break;
            }
        }
    }

    private void setPath(Node end) {
        Node pathNode = end;
        while (true) {
            path.add(pathNode);
            if (pathNode.getParent() == null) {
                break;
            }
            pathNode = pathNode.getParent();
        }
    }

    private void setHeuristics(Set<Node> nodes, Node end) {
        for(Node node : nodes) {
            node.setHeuristic(calculatePath(node, end));
        }
    }

    private int calculatePath(Node node, Node end) {
        int x = Math.abs(node.getPosition()[0] - end.getPosition()[0]);
        int y = Math.abs(node.getPosition()[1] - end.getPosition()[1]);
        return x + y;
    }
}
