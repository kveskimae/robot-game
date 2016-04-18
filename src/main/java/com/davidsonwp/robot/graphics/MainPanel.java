package com.davidsonwp.robot.graphics;

import com.davidsonwp.robot.Starter;
import com.davidsonwp.robot.constants.Dimensions;

import javax.swing.*;
import java.awt.*;

import static com.davidsonwp.robot.constants.Colors.MAIN_PANEL;

public class MainPanel {

    private final Feedback feedbackLabel;
    private final JPanel panel;
    private final GameGrid grid;
    private CommandInputArea serverStarter;

    public MainPanel(final Starter game) {
        panel = new JPanel();
        // panel.setLayout(new GridLayout(3, 1));
        panel.setLayout(new GridBagLayout());
        configureDimensions();
        panel.setBackground(MAIN_PANEL);
        grid = new GameGrid(game);
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        // gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        panel.add(grid.getPanel(), gridBagConstraints);


        GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
        // gridBagConstraints2.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints2.gridx = 0;
        gridBagConstraints2.gridy = 1;

        feedbackLabel = new Feedback(new JTextArea());
        panel.add(feedbackLabel.getPanel(), gridBagConstraints2); //, feedbackLabel.getGridBagConstraints());

        // TODO



        GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
        // gridBagConstraints2.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints3.gridx = 0;
        gridBagConstraints3.gridy = 2;

        serverStarter = new CommandInputArea(game);
        panel.add(serverStarter.getPanel(), gridBagConstraints3);
    }

    private void configureDimensions() {
        panel.setMinimumSize(Dimensions.MAIN_PANEL_SIZE);
        panel.setSize(Dimensions.MAIN_PANEL_SIZE);
        panel.setMaximumSize(Dimensions.MAIN_PANEL_SIZE);
        panel.setPreferredSize(Dimensions.MAIN_PANEL_SIZE);
    }

    public Feedback getFeedbackLabel() {
        return feedbackLabel;
    }

    public JPanel getPanel() {
        return panel;
    }

	public void setGridVisible(final boolean visible) {
		getPanel().add(grid.getPanel());
		// getPanel().add(connectionParameters.getPanel());
		getPanel().revalidate();
	}
    
}
