package com.davidsonwp.robot.graphics;

import com.davidsonwp.robot.constants.Dimensions;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class Feedback {
    
    private JScrollPane panel;
    
    private final JTextArea text;
    
    private final GridBagConstraints gridBagConstraints = new GridBagConstraints();

    Feedback(final JTextArea text) {
        panel = new JScrollPane(text, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        this.text = text;
        configureTextArea();
        configureDimensions();
        configureGridBagConstraints();
    }

    public JScrollPane getPanel() {
        return panel;
    }
    
    private void configureTextArea() {
        Font textAreaFont = new Font(Font.SERIF, Font.BOLD, 12);
        text.setFont(textAreaFont);
        text.setEditable(false);
        text.setWrapStyleWord(true);
        text.setWrapStyleWord(true);
        text.setLineWrap(true);
        text.setEditable(false);
        text.setFocusable(false);
        text.setOpaque(false);
        // text.setText("SA JLK FDJL;ADSFK J LA;KJADFS ;LKJADF S;LKJA DFS;LKDF AJS;LKDFASJ; LDFSKJ; DFLS");
    }
    
    public void addText(final String s) {
        text.setText( text.getText() + "\n" + s);
        panel.scrollRectToVisible(new Rectangle(new Point(0, 0)));
    }

    GridBagConstraints getGridBagConstraints() {
        return gridBagConstraints;
    }

    private void configureDimensions() {
        panel.setMinimumSize(Dimensions.FEEDBACK_SIZE);
        panel.setSize(Dimensions.FEEDBACK_SIZE);
        panel.setMaximumSize(Dimensions.FEEDBACK_SIZE);
        panel.setPreferredSize(Dimensions.FEEDBACK_SIZE);
    }

    private void configureGridBagConstraints() {
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(Dimensions.FEEDBACK_PANEL_INSET_TOP, 0, 0, 0);
    }

	public void repaint() {
		panel.repaint();
	}
    
}
