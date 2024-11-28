import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;

public class EnigmaFrame extends JFrame {
    private JComboBox<Integer> innerRotor;
    private JComboBox<Integer> middleRotor;
    private JComboBox<Integer> outerRotor;
    private JTextField rotorStart;
    private JTextArea inputText;
    private JTextArea outputText;

    public EnigmaFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new BorderLayout(10, 10));
        JPanel rotorPanel = new JPanel(new FlowLayout());
        JPanel textPanel = new JPanel(new FlowLayout());
        JPanel buttonPanel = new JPanel(new FlowLayout());
        rotorPanel.setBorder(new TitledBorder("ENIGMA"));
        rotorPanel.add(new JLabel("Inner:"));
        innerRotor = new JComboBox<>(new Integer[]{1, 2, 3, 4, 5});
        rotorPanel.add(innerRotor);
        rotorPanel.add(new JLabel("Middle:"));
        middleRotor = new JComboBox<>(new Integer[]{1, 2, 3, 4, 5});
        rotorPanel.add(middleRotor);
        rotorPanel.add(new JLabel("OuterE:"));
        outerRotor = new JComboBox<>(new Integer[]{1, 2, 3, 4, 5});
        rotorPanel.add(outerRotor);
        rotorPanel.add(new JLabel("Initial Positions:"));
        rotorStart = new JTextField(5);
        rotorPanel.add(rotorStart);
        textPanel.add(new JLabel("Input:"));
        inputText = new JTextArea(10, 30);
        textPanel.add(new JScrollPane(inputText));
        textPanel.add(new JLabel("Output:"));
        outputText = new JTextArea(10, 30);
        outputText.setEditable(false);
        textPanel.add(new JScrollPane(outputText));
        JButton encryptButton = new JButton("Encrypt");
        JButton decryptButton = new JButton("Decrypt");
        buttonPanel.add(encryptButton);
        buttonPanel.add(decryptButton);
        add(rotorPanel, BorderLayout.NORTH);
        add(textPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        encryptButton.addActionListener(e -> handleEncryptDecrypt(true));
        decryptButton.addActionListener(e -> handleEncryptDecrypt(false));
        pack();
    }
    private void handleEncryptDecrypt(boolean encrypt){
        try{
            int inner = (int) innerRotor.getSelectedItem();
            int middle = (int) middleRotor.getSelectedItem();
            int outer = (int) outerRotor.getSelectedItem();
            String start = rotorStart.getText().toUpperCase();
            String input = inputText.getText().toUpperCase();
            Enigma enigma = new Enigma(inner, middle, outer, start);
            String result = null;
            if (encrypt == true){
                result = enigma.encrypt(input);
            } else{
                result = enigma.decrypt(input);
            }
            outputText.setText(result);
        }catch(Exception e){
            System.out.println(e);
        }
}


}