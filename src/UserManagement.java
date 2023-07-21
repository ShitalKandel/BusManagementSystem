
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.util.HashMap;

public class UserManagement implements ActionListener {

    private HashMap<String, String> idAndPassword;

    // Login Frame components
    private JFrame loginFrame;
    private JLabel userLabel;
    private JTextField userText;
    private JLabel passwordLabel;
    private JPasswordField passwordText;
    private JButton loginButton;
    private JLabel loginSuccessLabel;
    private JButton createAccountButton;

    // Create Account Frame components
    private JFrame createAccountFrame;
    private JLabel firstNameLabel;
    private JTextField firstNameText;
    private JLabel lastNameLabel;
    private JTextField lastNameText;
    private JTextField numberText;
    private JTextField dateText;
    private JCheckBox maleCheckBox;
    private JLabel maleLabel;
    private JCheckBox femaleCheckBox;
    private JLabel femaleLabel;
    private JCheckBox customCheckBox;
    private JLabel customLabel;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private JButton signUpButton;
    private JLabel signupSucessLabel;

    public UserManagement() {
        idAndPassword = new HashMap<>();
        idAndPassword.put("Shital Kandel", "@123");
        idAndPassword.put("Lewis Lewis", "lewis@123");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            UserManagement userManagement = new UserManagement();
            userManagement.createLoginFrame();
        });
    }

    private void createLoginFrame() {
        loginFrame = new JFrame("Login");
        loginFrame.setSize(350, 300);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setLayout(null);

        userLabel = new JLabel("User");
        userLabel.setBounds(20, 20, 160, 25);
        loginFrame.add(userLabel);

        userText = new JTextField();
        userText.setBounds(120, 20, 165, 25);
        loginFrame.add(userText);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(20, 80, 160, 25);
        loginFrame.add(passwordLabel);

        passwordText = new JPasswordField();
        passwordText.setBounds(120, 80, 165, 25);
        loginFrame.add(passwordText);

        loginButton = new JButton("Login");
        loginButton.setBounds(120, 140, 80, 20);
        loginButton.setBackground(Color.BLUE);
        loginButton.addActionListener(this);
        loginFrame.add(loginButton);

        createAccountButton = new JButton("Create New Account");
        createAccountButton.setBounds(90, 180, 150, 25);
        createAccountButton.setBackground(Color.GREEN);
        createAccountButton.addActionListener(this);
        loginFrame.add(createAccountButton);

        loginSuccessLabel = new JLabel("");
        loginSuccessLabel.setBounds(20, 160, 300, 25);
        loginFrame.add(loginSuccessLabel);

        loginFrame.setVisible(true);
    }

    private void createCreateAccountFrame() {
        createAccountFrame = new JFrame("Create Account");
        createAccountFrame.setSize(300, 500);
        createAccountFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createAccountFrame.setLayout(null);

        firstNameLabel = new JLabel("First Name");
        firstNameLabel.setBounds(20, 50, 100, 25);
        createAccountFrame.add(firstNameLabel);

        firstNameText = new JTextField();
        firstNameText.setBounds(120, 50, 150, 25);
        createAccountFrame.add(firstNameText);

        lastNameLabel = new JLabel("Last Name");
        lastNameLabel.setBounds(20, 90, 100, 25);
        createAccountFrame.add(lastNameLabel);

        lastNameText = new JTextField();
        lastNameText.setBounds(120, 90, 150, 25);
        createAccountFrame.add(lastNameText);

        numberText = new JTextField("Mobile Number / Email");
        numberText.setBounds(20, 130, 250, 25);
        createAccountFrame.add(numberText);

        dateText = new JTextField("Date of Birth");
        dateText.setBounds(20, 170, 250, 25);
        createAccountFrame.add(dateText);

        maleCheckBox = new JCheckBox();
        maleCheckBox.setBounds(20, 210, 20, 20);
        createAccountFrame.add(maleCheckBox);

        maleLabel = new JLabel("Male");
        maleLabel.setBounds(50, 210, 100, 25);
        createAccountFrame.add(maleLabel);

        femaleCheckBox = new JCheckBox();
        femaleCheckBox.setBounds(90, 210, 20, 20);
        createAccountFrame.add(femaleCheckBox);

        femaleLabel = new JLabel("Female");
        femaleLabel.setBounds(120, 210, 100, 25);
        createAccountFrame.add(femaleLabel);

        customCheckBox = new JCheckBox();
        customCheckBox.setBounds(170, 210, 20, 20);
        createAccountFrame.add(customCheckBox);

        customLabel = new JLabel("Custom");
        customLabel.setBounds(200, 210, 100, 25);
        createAccountFrame.add(customLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(20, 250, 250, 25);
        createAccountFrame.add(passwordField);

        confirmPasswordField = new JPasswordField();
        confirmPasswordField.setBounds(20, 290, 250, 25);
        createAccountFrame.add(confirmPasswordField);

        signUpButton = new JButton("Sign Up");
        signUpButton.setBounds(20, 330, 250, 25);
        signUpButton.setBackground(Color.GREEN);
        signUpButton.addActionListener(this);
        createAccountFrame.add(signUpButton);

        signupSucessLabel = new JLabel("Account Singup Successfull");
        signupSucessLabel.setBounds(20,370,250,25);
        createAccountFrame.add(signupSucessLabel);


        createAccountFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String user = userText.getText();
            String password = new String(passwordText.getPassword());

            if (idAndPassword.containsKey(user) && idAndPassword.get(user).equals(password)) {
                loginSuccessLabel.setText("Login Successful!");
            } else {
                loginSuccessLabel.setText("Invalid User ID or Password");
            }
        } else if (e.getSource() == createAccountButton) {
            loginFrame.setVisible(false);
            createCreateAccountFrame();
        } else if (e.getSource() == signUpButton) {
            try {
                FileWriter fw = new FileWriter("login.txt");
                fw.write(firstNameText.getText() + "\t" + lastNameText.getText() +
                        "\t" + numberText.getText() + "\t" + dateText.getText());
                if (maleCheckBox.isSelected()) {
                    System.out.println("Checkbox 1 selected: true");
                } else if (femaleCheckBox.isSelected()) {
                    System.out.println("Checkbox 2 selected: true");
                } else if (customCheckBox.isSelected()) {
                    System.out.println("Checkbox 3 selected: true");
                }
                fw.write("\t" + passwordField.getText());
                if (!passwordField.getText().equals(confirmPasswordField.getText())) {
                    System.out.println("Passwords do not match!");
                }
                fw.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
