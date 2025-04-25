import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SortedListApp extends JFrame {
    private SortedList sortedList;
    private JTextArea displayArea;
    private JTextField inputField;
    private JButton addButton, searchButton, quitButton;

    public SortedListApp() {
        super("SortedList Binary Search");

        sortedList = new SortedList();
        displayArea = new JTextArea(15, 30);
        displayArea.setEditable(false);

        inputField = new JTextField(15);
        addButton = new JButton("Add");
        searchButton = new JButton("Search");
        quitButton = new JButton("Quit");

        // Button logic
        addButton.addActionListener(e -> addElement());
        searchButton.addActionListener(e -> searchElement());
        quitButton.addActionListener(e -> System.exit(0));

        // Layout
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Enter String:"));
        inputPanel.add(inputField);
        inputPanel.add(addButton);
        inputPanel.add(searchButton);
        inputPanel.add(quitButton);

        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(displayArea), BorderLayout.CENTER);

        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void addElement() {
        String text = inputField.getText().trim();
        if (!text.isEmpty()) {
            sortedList.add(text);
            displayArea.setText("Current List:\n" + sortedList.toString());
            inputField.setText("");
        }
    }

    private void searchElement() {
        String text = inputField.getText().trim();
        if (!text.isEmpty()) {
            String result = sortedList.search(text);
            displayArea.setText(result + "\n\nCurrent List:\n" + sortedList.toString());
        }
    }

    public static void main(String[] args) {
        new SortedListApp();
    }
}
