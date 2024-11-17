package tetrisblocks;

import tetris.TetrisBlock;

public class SShape extends TetrisBlock {
    public SShape() {
        super(new int[][] {
            {1, 0},
            {1, 1},
            {0, 1}
        });
    }

    @Override
    public void rotate() {
        super.rotate();
    }
}

