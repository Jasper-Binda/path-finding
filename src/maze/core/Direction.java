package maze.core;

import java.util.stream.Stream;

public enum Direction {

    UP(-1, 0),
    RIGHT(0, 1),
    DOWN(1, 0),
    LEFT(0, -1);

    private final int x;
    private final int y;

    Direction(int x, int y) {
        this.x = x;
        this.y = y;
    }

    String getPosition(int x, int y) {
        int newX = this.x + x;
        int newY = this.y + y;
        return newX + "-" + newY;
    }

    static Stream<Direction> stream() {
        return Stream.of(Direction.values());
    }
}
