package com.davidsonwp.robot.graphics;

import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.davidsonwp.robot.Starter;
import com.davidsonwp.robot.constants.Dimensions;
import com.davidsonwp.robot.command.Command;

public class CommandInputArea {
	
	private final JPanel panel = new JPanel();
	private final JLabel rmiRegistryLocationLabel = new JLabel("Command");
	private final JTextField rmiRegistryLocation = new JTextField("PLACE 0,0,NORTH");
	private JButton launchBtn = new JButton("Execute");
    
    public CommandInputArea(final Starter starter) {
    	panel.setLayout(new GridLayout(2, 2));
    	launchBtn.addMouseListener(new MouseListener() {
			
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
					Command command = Command.parseCommand(rmiRegistryLocation.getText());
					starter.getHandler().process(command);
				} catch (final ParseException pe) {
					starter.addText("Invalid command string");
				}
			}
		});
    	panel.add(rmiRegistryLocationLabel);
    	panel.add(rmiRegistryLocation);
    	panel.add(new JPanel());
    	panel.add(launchBtn);
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

	public void disable() {
		rmiRegistryLocation.setEnabled(false);
		rmiRegistryLocation.setFocusable(false);
		launchBtn.setEnabled(false);
		launchBtn.setFocusable(false);
	}

}
