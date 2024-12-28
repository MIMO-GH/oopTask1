package cs.vsu.oop1;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class StringLibraryApp {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("String Library GUI");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 400);

            JPanel panel = new JPanel(new GridLayout(6, 2, 10, 10));

            JLabel inputLabel = new JLabel("Input String:");
            JTextField inputField = new JTextField();

            JLabel resultLabel = new JLabel("Result:");
            JTextArea resultArea = new JTextArea();
            resultArea.setEditable(false);

            JButton splitButton = new JButton("Split");
            JButton joinButton = new JButton("Join");
            JButton replaceButton = new JButton("Replace");
            JButton equalsButton = new JButton("Equals Ignore Case");
            JButton indexOfButton = new JButton("Index Of");
            JButton formatButton = new JButton("Format");

            panel.add(inputLabel);
            panel.add(inputField);
            panel.add(splitButton);
            panel.add(joinButton);
            panel.add(replaceButton);
            panel.add(equalsButton);
            panel.add(indexOfButton);
            panel.add(formatButton);
            panel.add(resultLabel);
            panel.add(new JScrollPane(resultArea));

            frame.add(panel);
            frame.setVisible(true);

            splitButton.addActionListener(e -> {
                String input = inputField.getText();
                String delimiter = JOptionPane.showInputDialog("Enter delimiter:");
                if (delimiter != null) {
                    StringLibrary lib = new StringLibrary(input);
                    List<String> parts = lib.split(delimiter);
                    resultArea.setText(String.join("\n", parts));
                }
            });

            joinButton.addActionListener(e -> {
                String elements = JOptionPane.showInputDialog("Enter elements separated by commas:");
                String delimiter = JOptionPane.showInputDialog("Enter delimiter:");
                if (elements != null && delimiter != null) {
                    List<String> list = List.of(elements.split(","));
                    resultArea.setText(StringLibrary.join(list, delimiter));
                }
            });

            replaceButton.addActionListener(e -> {
                String input = inputField.getText();
                String target = JOptionPane.showInputDialog("Enter target string:");
                String replacement = JOptionPane.showInputDialog("Enter replacement string:");
                if (target != null && replacement != null) {
                    StringLibrary lib = new StringLibrary(input);
                    resultArea.setText(lib.replace(target, replacement));
                }
            });

            equalsButton.addActionListener(e -> {
                String input = inputField.getText();
                String other = JOptionPane.showInputDialog("Enter string to compare:");
                if (other != null) {
                    StringLibrary lib = new StringLibrary(input);
                    resultArea.setText(String.valueOf(lib.equalsIgnoreCase(other)));
                }
            });

            indexOfButton.addActionListener(e -> {
                String input = inputField.getText();
                String substring = JOptionPane.showInputDialog("Enter substring:");
                if (substring != null) {
                    StringLibrary lib = new StringLibrary(input);
                    resultArea.setText(String.valueOf(lib.indexOf(substring)));
                }
            });

            formatButton.addActionListener(e -> {
                String format = JOptionPane.showInputDialog("Enter format string:");
                String argsInput = JOptionPane.showInputDialog("Enter arguments separated by commas:");
                if (format != null && argsInput != null) {
                    String[] argsArray = argsInput.split(",");
                    resultArea.setText(StringLibrary.format(format, (Object[]) argsArray));
                }
            });
        });
    }
}

