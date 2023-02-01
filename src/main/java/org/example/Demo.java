package org.example;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;
import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) throws IOException, InterruptedException {
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory();
        Terminal terminal = terminalFactory.createTerminal();
        int oldX = 10;
        int oldY = 10;
        int x = 10;
        int y = 10;

        ArrayList<Enemy> enemiesTopDown = new ArrayList<>();
        enemiesTopDown.add(new Enemy(4,1));
        enemiesTopDown.add(new Enemy(5,1));
        enemiesTopDown.add(new Enemy(6,1));
        enemiesTopDown.add(new Enemy(7,1));
        enemiesTopDown.add(new Enemy(8,1));
        enemiesTopDown.add(new Enemy(9,1));
        enemiesTopDown.add(new Enemy(10,1));
        enemiesTopDown.add(new Enemy(11,1));
        enemiesTopDown.add(new Enemy(20,6));
        enemiesTopDown.add(new Enemy(21,6));
        enemiesTopDown.add(new Enemy(22,6));
        enemiesTopDown.add(new Enemy(23,6));

        ArrayList<Enemy> enemiesRightLeft = new ArrayList<>();
        enemiesRightLeft.add(new Enemy(70,10));
        enemiesRightLeft.add(new Enemy(70,11));
        enemiesRightLeft.add(new Enemy(70,12));
        enemiesRightLeft.add(new Enemy(55,20));
        enemiesRightLeft.add(new Enemy(55,21));

        ArrayList<Enemy> enemiesDownToTop = new ArrayList<>();
        enemiesDownToTop.add(new Enemy(30,20));
        enemiesDownToTop.add(new Enemy(31,20));
        enemiesDownToTop.add(new Enemy(32,20));
        enemiesDownToTop.add(new Enemy(33,20));
        enemiesDownToTop.add(new Enemy(45,15));
        enemiesDownToTop.add(new Enemy(46,15));
        enemiesDownToTop.add(new Enemy(47,15));
        enemiesDownToTop.add(new Enemy(48,15));
        enemiesDownToTop.add(new Enemy(49,16));
        enemiesDownToTop.add(new Enemy(50,17));
        enemiesDownToTop.add(new Enemy(51,18));


        while (true) {
            KeyType type;
            terminal.setCursorVisible(false);
            x = 10;
            y = 10;
            final char player = 'X';
            terminal.setCursorPosition(x, y);
            terminal.putCharacter(player);

            long tick = 0;
            // Task 9
            boolean continueReadingInput = true;
            while (continueReadingInput) {

                KeyStroke keyStroke = null;
                do {
                    tick++;
                    if (tick % 150 == 0) {
                        moveEnemiesTopToDown(terminal, enemiesTopDown);
                        moveEnemiesRightToLeft(terminal, enemiesRightLeft);
                        moveEnemiesDownToTop(terminal, enemiesDownToTop);
                        areYouStillAlive(enemiesTopDown, x, y);
                        areYouStillAlive(enemiesDownToTop, x, y);
                        areYouStillAlive(enemiesRightLeft, x, y);
                    }
                    Thread.sleep(5); // might throw InterruptedException
                    keyStroke = terminal.pollInput();
                } while (keyStroke == null);


                type = keyStroke.getKeyType();
                Character c = keyStroke.getCharacter(); // used Character instead of char because it might be null

                System.out.println("keyStroke.getKeyType(): " + type
                        + " keyStroke.getCharacter(): " + c);

                if (c == Character.valueOf('q')) {
                    continueReadingInput = false;
                    terminal.close();
                    System.out.println("quit");
                }


                switch (keyStroke.getKeyType()) {
                    case ArrowDown:
                        y += 1;
                        oldY = y - 1;
                        oldX = x;
                        break;
                    case ArrowUp:
                        y -= 1;
                        oldY = y + 1;
                        oldX = x;
                        break;
                    case ArrowRight:
                        x += 1;
                        oldX = x - 1;
                        oldY = y;
                        break;
                    case ArrowLeft:
                        x -= 1;
                        oldX = x + 1;
                        oldY = y;
                        break;
                }
                terminal.setCursorPosition(oldX, oldY);
                terminal.putCharacter(' ');
                terminal.setCursorPosition(x, y);
                terminal.putCharacter(player);

                terminal.flush();


            }
        }
    }
    static int row = 1;
    private static void moveEnemiesTopToDown(Terminal terminal, ArrayList<Enemy> enemies) throws IOException, InterruptedException {
        for (int i = 0; i < enemies.size(); i++) {
                terminal.setCursorPosition(enemies.get(i).getCol(), enemies.get(i).getRow());
                terminal.putCharacter(enemies.get(i).getLook());
                terminal.setCursorPosition(enemies.get(i).getCol(), enemies.get(i).getRow()-1);
                terminal.putCharacter(' ');
                enemies.get(i).setRow(enemies.get(i).getRow() + 1);
                terminal.flush();
            if (enemies.get(i).getRow() == 20) {
                terminal.setCursorPosition(enemies.get(i).getCol(), enemies.get(i).getRow()-1);
                terminal.putCharacter(' ');
                terminal.flush();
                enemies.get(i).setRow(4);
            }
        }
    }
    private static void moveEnemiesRightToLeft(Terminal terminal, ArrayList<Enemy> enemies) throws IOException, InterruptedException {
        for (int i = 0; i < enemies.size(); i++) {
            terminal.setCursorPosition(enemies.get(i).getCol(), enemies.get(i).getRow());
            terminal.putCharacter(enemies.get(i).getLook());
            terminal.setCursorPosition(enemies.get(i).getCol()+1, enemies.get(i).getRow());
            terminal.putCharacter(' ');
            enemies.get(i).setCol(enemies.get(i).getCol() - 1);
            terminal.flush();
            if (enemies.get(i).getCol() == 45){
                terminal.setCursorPosition(enemies.get(i).getCol()+1, enemies.get(i).getRow());
                terminal.putCharacter(' ');
                terminal.flush();
                enemies.get(i).setCol(70);


            }
        }
    }

    private static void moveEnemiesDownToTop(Terminal terminal, ArrayList<Enemy> enemies) throws IOException, InterruptedException {
        for (int i = 0; i < enemies.size(); i++) {
            terminal.setCursorPosition(enemies.get(i).getCol(), enemies.get(i).getRow());
            terminal.putCharacter(enemies.get(i).getLook());
            terminal.setCursorPosition(enemies.get(i).getCol(), enemies.get(i).getRow()+1);
            terminal.putCharacter(' ');
            enemies.get(i).setRow(enemies.get(i).getRow() - 1);
            terminal.flush();
            if (enemies.get(i).getRow() == 3) {
                terminal.setCursorPosition(enemies.get(i).getCol(), enemies.get(i).getRow()+1);
                terminal.putCharacter(' ');
                terminal.flush();
                enemies.get(i).setRow(20);
            }
        }
    }
    private static void areYouStillAlive(ArrayList<Enemy> enemies, int x, int y) {
        for (Enemy enemy : enemies) {
            if (enemy.getRow() == y && enemy.getCol() == x) {
                System.out.println("Game Over");
            }
        }
    }

}
