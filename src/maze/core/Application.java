package maze.core;

import maze.algorith.Astar;
import maze.gui.Gui;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        int[][] mz = initMaze();
        Maze maze = new Maze(mz);
        long startTime = System.currentTimeMillis();
        Astar astar = new Astar(maze);
        long endTime = System.currentTimeMillis();
        System.out.println("A* algorithm: " + (endTime - startTime) + "ms");

        JFrame f = new JFrame("Maze");
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.getContentPane().add( new Gui(mz, astar.getPath()));
        f.setSize((mz.length + 4) * 10, (mz.length + 6) * 10);
        f.setVisible(true);
        System.out.println("PathLength: " + astar.getPath().size());
    }

    private static int[][] initMaze() {
        int[][] maze = null;
        try {
            Scanner scanner = new Scanner(new File("maze.txt"));
            int r = 0;
            while (scanner.hasNextLine()) {
                String[] numbers = scanner.nextLine().split(" ");
                int size = numbers.length;
                if (maze == null) {
                    maze = new int[size][size];
                }
                int c = 0;
                for (String s : numbers) {
                    if (!s.trim().isEmpty()) {
                        maze[r][c++] = Integer.parseInt(s);
                    }
                }
                r++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return maze;
    }
}
