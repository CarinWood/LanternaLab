package org.example;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Demo {
    public static void main(String[] args) throws IOException, InterruptedException {
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory();
        Terminal terminal = terminalFactory.createTerminal();

        KeyType type;
        terminal.setCursorVisible(false);
        for (int i = 0; i < 5; i++) {
            for (int column = 0; column < 10; column++) {
                terminal.setCursorPosition(4, column);
                terminal.putCharacter('\u263B');
                terminal.setCursorPosition(5, column);
                terminal.putCharacter('\u263B');
                terminal.setCursorPosition(6, column);
                terminal.putCharacter('\u263B');
                terminal.setCursorPosition(7, column);
                terminal.putCharacter('\u263B');
                terminal.setCursorPosition(8, column);
                terminal.putCharacter('\u263B');
                terminal.setCursorPosition(9, column);
                terminal.putCharacter('\u263B');
                terminal.setCursorPosition(10, column);
                terminal.putCharacter('\u263B');
                terminal.setCursorPosition(11, column);
                terminal.putCharacter('\u263B');
                Thread.sleep(500);
                terminal.flush();
                terminal.setCursorPosition(4, column);
                terminal.putCharacter(' ');
                terminal.setCursorPosition(5, column);
                terminal.putCharacter(' ');
                terminal.setCursorPosition(6, column);
                terminal.putCharacter(' ');
                terminal.setCursorPosition(7, column);
                terminal.putCharacter(' ');
                terminal.setCursorPosition(8, column);
                terminal.putCharacter(' ');
                terminal.setCursorPosition(9, column);
                terminal.putCharacter(' ');
                terminal.setCursorPosition(10, column);
                terminal.putCharacter(' ');
                terminal.setCursorPosition(11, column);
                terminal.putCharacter(' ');
            }
        }


        String s = "Find your way to the coins";
        String s1 = "and watch out for the enemies.";
        for (int i = 0; i <= s.length() - 1; i++) {
            terminal.flush();
            terminal.setCursorPosition(i, 1);
            terminal.putCharacter(s.charAt(i));
            Thread.sleep(200);
            terminal.flush();
            for (i = 0; i <= s1.length() - 1; i++) {
                terminal.flush();
                terminal.setCursorPosition(i, 1);
                terminal.putCharacter(s.charAt(i));
                Thread.sleep(200);
            }
            terminal.flush();
        }
    }
}
