package com.alexandrovskiy;

import java.awt.Dimension;
import java.util.Map;
import java.util.Set;

import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class EnvironmentVariables {
	
    public static void main(String[] args) {

    	StringBuffer paramBuffer = new StringBuffer();
        StringBuffer valueBuffer = new StringBuffer();
        JTextArea params = new JTextArea();
        params.setBounds(0, 0, 98, 598);
        JTextArea info = new JTextArea();
        info.setBounds(100, 0, 990, 598);
        JPanel panel = new JPanel();
        
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.add(params);
        panel.add(info);
        Map<String, String> environment = System.getenv();
        Set<String> keys = environment.keySet();
        for (String key : keys) {
            paramBuffer.append(String.format("%-25s%n", key));
            if (key.contentEquals("Path")) {
            	int appendEmptyStrings = environment.get(key).length()/180;
            	// line length for environment variable value is approximately 180
            	for (int j=0; j<=appendEmptyStrings;j++) {
            		paramBuffer.append("\r\n");
            	}
            	paramBuffer.append("\r\n");
            }
            valueBuffer.append(String.format("%s%n", environment.get(key)));
        }
        params.setText(paramBuffer.toString());
        info.setText(valueBuffer.toString());
        JScrollPane scroll = new JScrollPane(panel);
        scroll.setPreferredSize(new Dimension(1200,600));
        info.setLineWrap(true);
        info.setWrapStyleWord(true);
        JOptionPane.showMessageDialog(null, scroll, "Environment Variables", JOptionPane.PLAIN_MESSAGE);
    }
}