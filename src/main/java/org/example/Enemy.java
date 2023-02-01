package org.example;

import java.util.ArrayList;

public class Enemy {
    int col;
    int row;
    char look;

    public char getLook() {
        return look;
    }

    public void setLook(char look) {
        this.look = look;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public Enemy(int col, int row) {
        this.col = col;
        this.row = row;
        look = '☻';
    }
}
