package maze.gui;

import maze.core.Node;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.util.List;

public class Gui extends JPanel {

    private int[][] maze;
    private List<Node> path;

    public Gui(int[][] maze, List<Node> path) {
        this.maze = maze;
        this.path = path;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(0, 0, (maze.length + 2) * 10, (maze.length + 2) * 10);
        for (int row = 0; row < maze[0].length; row++) {
            for (int column = 0; column < maze.length; column++) {
                if (maze[row][column] == 1) {
                    g.setColor(Color.WHITE);
                    g.fillRect(column * 10 + 10, row * 10 + 10, 10, 10);
                } else {
                    g.setColor(Color.BLACK);
                    g.fillRect(column * 10 + 10, row * 10 + 10, 10, 10);
                }
            }
        }

        g.setColor(Color.RED);
        for (Node node : path) {
            int[] position = node.getPosition();
            g.fillRect(position[1] * 10 + 10, position[0] * 10 + 10, 10, 10);
        }
    }
}
