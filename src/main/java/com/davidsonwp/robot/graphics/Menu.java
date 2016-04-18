package com.davidsonwp.robot.graphics;

import com.davidsonwp.robot.Starter;

import javax.swing.*;

public class Menu extends JMenuBar {

    private JMenu fileMenu = new JMenu();
    private JMenuItem aboutMenuItem = new JMenuItem();
    private JMenuItem exitMenuItem = new JMenuItem();
    private final Starter game;

    public Menu(final Starter game) {
        this.game = game;
        initialize();
    }

    private void initialize() {
        fileMenu.setMnemonic('F');
        fileMenu.setText("File");
        
        aboutMenuItem.setMnemonic('A');
        aboutMenuItem.setText("About");
        aboutMenuItem.setToolTipText("About");
        aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                new About(game.getFrame()).setVisible(true);
            }
        });
        fileMenu.add(aboutMenuItem);
        
        exitMenuItem.setMnemonic('E');
        exitMenuItem.setText("Exit");
        exitMenuItem.setToolTipText("Quit Team, Quit!");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.exit(0);
            }
        });
        fileMenu.add(exitMenuItem);
        
        this.add(fileMenu);
    }

}
