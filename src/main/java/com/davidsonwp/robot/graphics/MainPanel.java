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
    private CommandInputArea commandInputArea;

    public MainPanel(final Starter game) {
        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        configureDimensions();
        panel.setBackground(MAIN_PANEL);

        grid = new GameGrid(game);

        GridBagConstraints gameGridConstraints = new GridBagConstraints();
        gameGridConstraints.gridx = 0;
        gameGridConstraints.gridy = 0;
        panel.add(grid.getPanel(), gameGridConstraints);

        GridBagConstraints feedbackConstraints = new GridBagConstraints();
        feedbackConstraints.gridx = 0;
        feedbackConstraints.gridy = 1;
        feedbackLabel = new Feedback(new JTextArea());
        panel.add(feedbackLabel.getPanel(), feedbackConstraints);

        GridBagConstraints commandInputAreaConstraints = new GridBagConstraints();
        commandInputAreaConstraints.gridx = 0;
        commandInputAreaConstraints.gridy = 2;
        commandInputArea = new CommandInputArea(game);
        panel.add(commandInputArea.getPanel(), commandInputAreaConstraints);
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

    public GameGrid getGrid() {
        return grid;
    }

}
