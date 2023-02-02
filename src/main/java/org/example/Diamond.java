package org.example;

public class Diamond {
    int x;
    int y;
    char look;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public char getLook() {
        return look;
    }

    public void setLook(char look) {
        this.look = look;
    }

    public Diamond(int x, int y) {
        this.x = x;
        this.y = y;
        look = '\u2666';
    }
}
