package com.davidsonwp.robot;

import com.davidsonwp.robot.command.CardinalDirection;
import com.davidsonwp.robot.command.CommandHandler;
import com.davidsonwp.robot.graphics.MainPanel;
import com.davidsonwp.robot.graphics.Menu;
import com.davidsonwp.robot.state.GridState;

import javax.swing.*;
import java.awt.*;

public class Starter {

	private MainPanel mainPanel;

	private JFrame frame = new JFrame();

	private Menu menu;

	private CommandHandler handler;

	private GridState gridState = new GridState();

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Starter starter = new Starter();
				starter.getFrame().setVisible(true);
			}
		});
	}

	public GridState getGridState() {
		return gridState;
	}

	public CommandHandler getHandler() {
		return handler;
	}

	public JFrame getFrame() {
		return frame;
	}

	public Starter() {
		getGridState().setX(1);
		getGridState().setY(1);
		getGridState().setDirection(CardinalDirection.NORTH);
		initGUIComponents();
		getFrame().pack();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = getFrame().getSize();
		getFrame().setLocation(new Point((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.width) / 2));
		handler = new CommandHandler(this);
	}

	private void initGUIComponents() {
		getFrame().setTitle("Toy Robot");
		getFrame().addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent evt) {
				System.exit(0);
			}
		});
		this.mainPanel = new MainPanel(this);
		mainPanel.setGridVisible(false);
		getFrame().getContentPane().add(mainPanel.getPanel(), java.awt.BorderLayout.CENTER);
		menu = new Menu(this);
		menu.setJoinsEnabled(false);
		getFrame().setJMenuBar(menu);
		mainPanel.setGridVisible(true);
		menu.setJoinsEnabled(true);
		addText("Place the robot");
		this.frame.repaint();
	}

	public void addText(final String msg) {
		mainPanel.getFeedbackLabel().addText(msg);
	}

}
