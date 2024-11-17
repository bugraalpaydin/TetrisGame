package tetrisblocks;

import tetris.TetrisBlock;

public class LShape extends TetrisBlock {
    public LShape() {
        super(new int[][] {
            {1, 1},
            {0, 1},
            {0, 1}
        });
    }

    @Override
    public void rotate() {
        super.rotate(); 

        if (this.getWidth() == 2 && this.getHeight() == 3) {
            this.setX(this.getX());
        } 
        else if (this.getWidth() == 3 && this.getHeight() == 2) {
            this.setY(this.getY());
        } 
        else if (this.getWidth() == 2 && this.getHeight() == 3) {
            this.setX(this.getX());
        } 
        else {
            this.setY(this.getY());
        }
    }
}