import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CaesarCipherGUI extends JFrame {

    // Caesar Cipher function to encrypt a message with a given shift key
    public static String caesarCipherEncrypt(String message, int key) {
        String encryptedMessage = "";
        for (char c : message.toCharArray()) {
            if (Character.isLetter(c)) {
                int charCode = (int) c;
                charCode += key;
                if (Character.isUpperCase(c)) {
                    if (charCode > (int) 'Z') {
                        charCode -= 26;
                    } else if (charCode < (int) 'A') {
                        charCode += 26;
                    }
                } else {
                    if (charCode > (int) 'z') {
                        charCode -= 26;
                    } else if (charCode < (int) 'a') {
                        charCode += 26;
                    }
                }
                encryptedMessage += (char) charCode;
            } else {
                encryptedMessage += c;
            }
        }
        return encryptedMessage;
    }

    // Caesar Cipher function to decrypt an encrypted message with a given shift key
    public static String caesarCipherDecrypt(String encryptedMessage, int key) {
        String decryptedMessage = "";
        for (char c : encryptedMessage.toCharArray()) {
            if (Character.isLetter(c)) {
                int charCode = (int) c;
                charCode -= key;
                if (Character.isUpperCase(c)) {
                    if (charCode < (int) 'A') {
                        charCode += 26;
                    } else if (charCode > (int) 'Z') {
                        charCode -= 26;
                    }
                } else {
                    if (charCode < (int) 'a') {
                        charCode += 26;
                    } else if (charCode > (int) 'z') {
                        charCode -= 26;
                    }
                }
                decryptedMessage += (char) charCode;
            } else {
                decryptedMessage += c;
            }
        }
        return decryptedMessage;
    }

    public CaesarCipherGUI() {
        setTitle("Caesar Cipher Encryption and Decryption");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(mainPanel);

        // Title label
        JLabel titleLabel = new JLabel("Caesar Cipher Encryption and Decryption");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setForeground(Color.RED);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(titleLabel);
        mainPanel.add(Box.createVerticalStrut(20));

        // Message input label
        JLabel msgLabel = new JLabel("Enter a message:");
        msgLabel.setForeground(Color.GREEN);
        mainPanel.add(msgLabel);
        mainPanel.add(Box.createVerticalStrut(5));

        // Message input field
        JTextField msgField = new JTextField(30);
        mainPanel.add(msgField);
        mainPanel.add(Box.createVerticalStrut(10));

        // Key selection label
        JLabel keyLabel = new JLabel("Select a shift key (1-9):");
        keyLabel.setBackground(Color.BLUE);
        keyLabel.setOpaque(true);
        mainPanel.add(keyLabel);
        mainPanel.add(Box.createVerticalStrut(5));

        // Key selection dropdown menu
            // Key selection dropdown menu
    String[] keys = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
    JComboBox<String> keyDropdown = new JComboBox<>(keys);
    mainPanel.add(keyDropdown);
    mainPanel.add(Box.createVerticalStrut(20));

    // Encrypt button
    JButton encryptButton = new JButton("Encrypt");
    encryptButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    mainPanel.add(encryptButton);
    mainPanel.add(Box.createVerticalStrut(10));

    // Encrypted message label
    JLabel encryptedLabel = new JLabel("Encrypted Message:");
    encryptedLabel.setForeground(Color.BLUE);
    mainPanel.add(encryptedLabel);
    mainPanel.add(Box.createVerticalStrut(5));

    // Encrypted message display field
    JTextArea encryptedField = new JTextArea(5, 30);
    encryptedField.setEditable(false);
    JScrollPane scrollPane = new JScrollPane(encryptedField);
    mainPanel.add(scrollPane);
    mainPanel.add(Box.createVerticalStrut(20));

    // Decrypt button
    JButton decryptButton = new JButton("Decrypt");
    decryptButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    mainPanel.add(decryptButton);
    mainPanel.add(Box.createVerticalStrut(10));

    // Decrypted message label
    JLabel decryptedLabel = new JLabel("Decrypted Message:");
    decryptedLabel.setForeground(Color.BLUE);
    mainPanel.add(decryptedLabel);
    mainPanel.add(Box.createVerticalStrut(5));

    // Decrypted message display field
    JTextArea decryptedField = new JTextArea(5, 30);
    decryptedField.setEditable(false);
    JScrollPane scrollPane2 = new JScrollPane(decryptedField);
    mainPanel.add(scrollPane2);

    // Action listeners
    encryptButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String message = msgField.getText();
            int key = Integer.parseInt((String) keyDropdown.getSelectedItem());
            String encryptedMessage = caesarCipherEncrypt(message, key);
            encryptedField.setText(encryptedMessage);
        }
    });

    decryptButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String encryptedMessage = encryptedField.getText();
            int key = Integer.parseInt((String) keyDropdown.getSelectedItem());
            String decryptedMessage = caesarCipherDecrypt(encryptedMessage, key);
            decryptedField.setText(decryptedMessage);
        }
    });

    // Display the window
    setVisible(true);
}

public static void main(String[] args) {
    new CaesarCipherGUI();
}

}