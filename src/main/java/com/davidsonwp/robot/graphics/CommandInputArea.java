package com.davidsonwp.robot.graphics;

import com.davidsonwp.robot.Starter;
import com.davidsonwp.robot.command.Command;
import com.davidsonwp.robot.command.CommandParser;
import com.davidsonwp.robot.constants.Dimensions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;

public class CommandInputArea {
	
	private final JPanel panel = new JPanel();
	private final JLabel labelCommand = new JLabel("Command");
	private final JTextField textCommand = new JTextField("PLACE 0,0,NORTH");
	private JButton executeBtn = new JButton("Execute");
    
    public CommandInputArea(final Starter starter) {
    	panel.setLayout(new GridLayout(2, 2));
    	executeBtn.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Command command = CommandParser.parseCommand(textCommand.getText());
					starter.getHandler().process(command);
				} catch (final ParseException pe) {
					starter.addText("Invalid command string");
				}
			}
		});
    	panel.add(labelCommand);
    	panel.add(textCommand);
    	panel.add(new JPanel());
    	panel.add(executeBtn);
        configureDimensions();
        panel.revalidate();
    }

    public JPanel getPanel() {
        return panel;
    }

    private void configureDimensions() {
        panel.setMinimumSize(Dimensions.COMMAND_INPUT_SIZE);
        panel.setSize(Dimensions.COMMAND_INPUT_SIZE);
        panel.setMaximumSize(Dimensions.COMMAND_INPUT_SIZE);
        panel.setPreferredSize(Dimensions.COMMAND_INPUT_SIZE);
    }

}
