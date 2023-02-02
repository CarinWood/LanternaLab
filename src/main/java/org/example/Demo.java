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
        int points = 0;

        ArrayList<Enemy> enemiesTopToDown = new ArrayList<>();
        enemiesTopToDown.add(new Enemy(4,1));
        enemiesTopToDown.add(new Enemy(5,1));
        enemiesTopToDown.add(new Enemy(6,1));
        enemiesTopToDown.add(new Enemy(7,1));
        enemiesTopToDown.add(new Enemy(8,1));
        enemiesTopToDown.add(new Enemy(9,1));
        enemiesTopToDown.add(new Enemy(10,1));
        enemiesTopToDown.add(new Enemy(11,1));
        enemiesTopToDown.add(new Enemy(20,6));
        enemiesTopToDown.add(new Enemy(21,6));
        enemiesTopToDown.add(new Enemy(22,6));
        enemiesTopToDown.add(new Enemy(23,6));

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

        ArrayList<Diamond> diamonds = new ArrayList<>();
        diamonds.add(new Diamond(40,15));
        diamonds.add(new Diamond(20,10));
        diamonds.add(new Diamond(25,20));
        diamonds.add(new Diamond(40,18));
        diamonds.add(new Diamond(30,5));
        diamonds.add(new Diamond(45,20));
        diamonds.add(new Diamond(55,18));
        diamonds.add(new Diamond(60,10));
        diamonds.add(new Diamond(70,5));

        //startScreen(terminal);



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
                        moveEnemiesTopToDown(terminal, enemiesTopToDown, diamonds);
                        moveEnemiesRightToLeft(terminal, enemiesRightLeft, diamonds);
                        moveEnemiesDownToTop(terminal, enemiesDownToTop, diamonds);
                        grabDiamonds(diamonds, terminal, x, y, points);
                        areYouStillAlive(enemiesTopToDown, x, y, terminal, continueReadingInput, points);
                        areYouStillAlive(enemiesDownToTop, x, y, terminal, continueReadingInput, points);
                        areYouStillAlive(enemiesRightLeft, x, y, terminal, continueReadingInput, points);
                        //enemyGrabDiamonds(diamonds, enemiesDownToTop, terminal);
                        //enemyGrabDiamonds(diamonds, enemiesRightLeft, terminal);
                        //enemyGrabDiamonds(diamonds, enemiesTopToDown, terminal);
                        generateDiamonds(diamonds, terminal);
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
    private static void moveEnemiesTopToDown(Terminal terminal, ArrayList<Enemy> enemies, ArrayList<Diamond> diamonds) throws IOException, InterruptedException {
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
    private static void moveEnemiesRightToLeft(Terminal terminal, ArrayList<Enemy> enemies, ArrayList<Diamond> diamonds) throws IOException, InterruptedException {
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

    private static void moveEnemiesDownToTop(Terminal terminal, ArrayList<Enemy> enemies, ArrayList<Diamond> diamonds) throws IOException, InterruptedException {
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
    private static void generateDiamonds(ArrayList<Diamond> diamonds, Terminal terminal) throws IOException {
        for (int i = 0; i < diamonds.size(); i++) {
            terminal.setCursorPosition(diamonds.get(i).getX(), diamonds.get(i).getY());
            terminal.putCharacter(diamonds.get(i).getLook());
            terminal.flush();
        }
    }
    private static void grabDiamonds(ArrayList<Diamond> diamonds, Terminal terminal, int x, int y, int points) throws IOException, InterruptedException {
        for (Diamond diamond : diamonds) {
            if (diamond.getX() == x && diamond.getY() == y) {
                terminal.setCursorPosition(diamond.getX(), diamond.getY());
                terminal.putCharacter('X');
                diamond.setX(-200);
                diamond.setY(-200);
                diamond.setLook(' ');
                terminal.flush();
                Diamond.takenDiamonds();
                System.out.println(Diamond.points);
            }
        }
        if(Diamond.points == diamonds.size()) {

            String s = "YOU WON!";
            for (int i = 0; i < s.length(); i++) {
                terminal.setCursorPosition(i+35,10);
                terminal.putCharacter(s.charAt(i));
            }
            terminal.flush();
            Thread.sleep(3000);
            terminal.close();
        }

    }

    private static void enemyGrabDiamonds(ArrayList<Diamond> diamonds, ArrayList<Enemy> enemies, Terminal terminal) throws IOException {
        for (Diamond diamond : diamonds) {
            for (Enemy enemy : enemies) {
                if (diamond.getX() == enemy.getCol() && diamond.getY() == enemy.getRow()) {
                    terminal.setCursorPosition(diamond.getX(), diamond.getY()-1);
                    terminal.putCharacter(diamond.getLook());
                    terminal.flush();
                }
            }
        }
    }
    private static void areYouStillAlive(ArrayList<Enemy> enemies, int x, int y,Terminal terminal, Boolean continueReadingInput, int points) throws IOException, InterruptedException {
        for (Enemy enemy : enemies) {
            if (enemy.getRow() == y && enemy.getCol() == x) {
              //  eraseScreen(terminal, diamonds);
                System.out.println("Game Over");
                System.out.println(points);
                terminal.bell();
                String gameOver = "Game Over";
                for (int i = 0; i < gameOver.length(); i++) {
                    terminal.setCursorPosition(i+35,10);
                    terminal.putCharacter(gameOver.charAt(i));


            }
                terminal.flush();
                Thread.sleep(3000);
                terminal.close();


        }

        }
    }

    private static void startScreen(Terminal terminal) throws IOException, InterruptedException {
        String str = "Try to grab all the diamonds and avoid the mean smileys!";
        String str2 = "Control the character (X) with the arrow keys!";
        terminal.setCursorVisible(false);
        for (int i = 0; i < str.length(); i++) {
            terminal.setCursorPosition(10+i, 8);
            terminal.putCharacter(str.charAt(i));
            terminal.flush();
            Thread.sleep(100);
        }

        for (int i = 0; i < str2.length(); i++) {
            terminal.setCursorPosition(10+i, 10);
            terminal.putCharacter(str2.charAt(i));
            terminal.flush();
            Thread.sleep(100);
        }
        Thread.sleep(1000);
        for (int i = 0; i < str.length(); i++) {
            terminal.setCursorPosition(10+i, 8);
            terminal.putCharacter(' ');
            terminal.flush();
        }

        for (int i = 0; i < str2.length(); i++) {
            terminal.setCursorPosition(10+i, 10);
            terminal.putCharacter(' ');
            terminal.flush();
        }




    }

    private static void eraseScreen(Terminal terminal, ArrayList<Diamond> diamonds, ArrayList<Enemy> enemies, ArrayList<Enemy> enemies2, ArrayList<Enemy> enemies3, int x, int y) throws IOException {

        terminal.setCursorPosition(x, y);
        terminal.putCharacter(' ');
        terminal.flush();

        for(Diamond diamond: diamonds) {
            terminal.setCursorPosition(diamond.getX(), diamond.getY());
            terminal.putCharacter(' ');
            terminal.flush();
        }
        for(Enemy enemy: enemies) {
            terminal.setCursorPosition(enemy.getCol(), enemy.getRow());
            terminal.putCharacter(' ');
            terminal.flush();
        }

        for(Enemy enemy: enemies2) {
            terminal.setCursorPosition(enemy.getCol(), enemy.getRow());
            terminal.putCharacter(' ');
            terminal.flush();
        }

        for(Enemy enemy: enemies3) {
            terminal.setCursorPosition(enemy.getCol(), enemy.getRow());
            terminal.putCharacter(' ');
            terminal.flush();
        }
    }

}
