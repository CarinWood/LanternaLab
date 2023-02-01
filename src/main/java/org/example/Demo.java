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
        while (true) {

            for (int column = 0; column < 20; column++) {
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
                terminal.setCursorPosition(20, column);
                terminal.putCharacter('\u263B');
                terminal.setCursorPosition(21, column);
                terminal.putCharacter('\u263B');
                terminal.setCursorPosition(22, column);
                terminal.putCharacter('\u263B');
                terminal.setCursorPosition(23, column);
                terminal.putCharacter('\u263B');
                terminal.setCursorPosition(4, column+5);
                terminal.putCharacter('\u263B');
                terminal.setCursorPosition(5, column+5);
                terminal.putCharacter('\u263B');
                terminal.setCursorPosition(6, column+5);
                terminal.putCharacter('\u263B');
                terminal.setCursorPosition(7, column+5);
                terminal.putCharacter('\u263B');
                terminal.setCursorPosition(8, column+5);
                terminal.putCharacter('\u263B');
                terminal.setCursorPosition(9, column+5);
                terminal.putCharacter('\u263B');
                terminal.setCursorPosition(10, column+5);
                terminal.putCharacter('☻');
                terminal.setCursorPosition(11, column+5);
                terminal.putCharacter('☻');
                terminal.setCursorPosition(20, column+5);
                terminal.putCharacter('☻');
                terminal.setCursorPosition(21, column+5);
                terminal.putCharacter('\u263B');
                terminal.setCursorPosition(22, column+5);
                terminal.putCharacter('\u263B');
                terminal.setCursorPosition(23, column+5);
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
                terminal.setCursorPosition(20, column);
                terminal.putCharacter(' ');
                terminal.setCursorPosition(21, column);
                terminal.putCharacter(' ');
                terminal.setCursorPosition(22, column);
                terminal.putCharacter(' ');
                terminal.setCursorPosition(23, column);
                terminal.putCharacter(' ');
                Thread.sleep(500);
                terminal.flush();
                terminal.setCursorPosition(4, column+5);
                terminal.putCharacter(' ');
                terminal.setCursorPosition(5, column+5);
                terminal.putCharacter(' ');
                terminal.setCursorPosition(6, column+5);
                terminal.putCharacter(' ');
                terminal.setCursorPosition(7, column+5);
                terminal.putCharacter(' ');
                terminal.setCursorPosition(8, column+5);
                terminal.putCharacter(' ');
                terminal.setCursorPosition(9, column+5);
                terminal.putCharacter(' ');
                terminal.setCursorPosition(10, column+5);
                terminal.putCharacter(' ');
                terminal.setCursorPosition(11, column+5);
                terminal.putCharacter(' ');
                terminal.setCursorPosition(20, column+5);
                terminal.putCharacter(' ');
                terminal.setCursorPosition(21, column+5);
                terminal.putCharacter(' ');
                terminal.setCursorPosition(22, column+5);
                terminal.putCharacter(' ');
                terminal.setCursorPosition(23, column+5);
                terminal.putCharacter(' ');
            }
        }
    }
}
