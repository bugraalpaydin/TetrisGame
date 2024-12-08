package tetris;

import java.awt.Color;
import java.util.Random;

public class TetrisBlock {
    private int[][] shape;
    private Color color;
    private int x, y;
    private int[][][] shapes;
    private int currentRotation;

    private Color[] availableColors = { Color.GREEN, Color.RED, Color.BLUE };

    public TetrisBlock(int[][] shape) {
        this.shape = shape;

        initShapes();
    }

    private void initShapes() {
        shapes = new int[4][][];

        for (int i = 0; i < 4; i++) {
            int r = shape[0].length;
            int c = shape.length;

            shapes[i] = new int[r][c];

            for (int y = 0; y < r; y++) {
                for (int x = 0; x < c; x++) {
                    shapes[i][y][x] = shape[c - x - 1][y];
                }
            }

            shape = shapes[i];
        }
    }

    public void spawn(int gridWidth) {
        Random r = new Random();

        currentRotation = r.nextInt(shapes.length);
        shape = shapes[currentRotation];

        y = -getHeight();
        x = r.nextInt(gridWidth - getWidth());

        color = availableColors[r.nextInt(availableColors.length)];
    }

    public int[][] getShape() {
        return shape;
    }

    public Color getColor() {
        return color;
    }

    public int getHeight() {
        return shape.length;
    }

    public int getWidth() {
        return shape[0].length;
    }

    public int getX() {
        return x;
    }

    public void setX(int newX) {
        x = newX;
    }

    public int getY() {
        return y;
    }

    public void setY(int newY) {
        y = newY;
    }

    public void moveDown() {
        y++;
    }

    public void moveLeft() {
        x--;
    }

    public void moveRight() {
        x++;
    }

    public void rotate() {
        int[][] shape = this.getShape(); // Retrieve the current shape
        int rows = shape.length;
        int cols = shape[0].length;
        int[][] rotatedShape = new int[cols][rows];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                rotatedShape[col][rows - 1 - row] = shape[row][col];
            }
        }
        this.shape = rotatedShape;
    }

    public int getBottomEdge() {
        return y + getHeight();
    }

    public int getLeftEdge() {
        return x;
    }

    public int getRightEdge() {
        return x + getWidth();
    }

    public int[][] getCoordinates() {

        // Trim the array to actual occupied cells
        return shape;
    }
}
