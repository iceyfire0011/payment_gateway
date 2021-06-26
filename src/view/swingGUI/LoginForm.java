package view.swingGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame {
    JPanel panel, formHeaderPanel, formPanel;
    JLabel formHeader, user_label, password_label, message_label;
    JTextField userName_text;
    JPasswordField password_text;
    JButton btnSubmit, btnCancel,btnRegistration;
    GridLayout loginFormLayout;

    public LoginForm() {
        //form header
        formHeader = new JLabel();
        formHeader.setText("Login Form");
        formHeader.setSize(120, 50);
        formHeaderPanel = new JPanel(new FlowLayout());
        formHeaderPanel.add(formHeader);
        // Message Label
        user_label = new JLabel();
        user_label.setText("User Name :");
        // Username Label
        user_label = new JLabel();
        user_label.setText("User Name :");
        userName_text = new JTextField();
        userName_text.setSize(120, 40);
        // Password Label
        password_label = new JLabel();
        password_label.setText("Password :");
        password_text = new JPasswordField();
        password_text.setSize(120, 40);
        // Submit
        btnSubmit = new JButton("Submit");
        btnCancel = new JButton("Cancel");
        btnRegistration = new JButton("Register");
        loginFormLayout = new GridLayout();
        loginFormLayout.setHgap(20);
        loginFormLayout.setVgap(20);
        loginFormLayout.setRows(4);
        loginFormLayout.setColumns(2);
        formPanel = new JPanel(loginFormLayout);
        panel = new JPanel(new BorderLayout());
//        panel.setLayout(null);
        panel.add(formHeaderPanel, BorderLayout.NORTH);
        panel.add(formPanel, BorderLayout.SOUTH);

        //formPanel.add(formHeaderPanel);
        formPanel.add(user_label);
        formPanel.add(userName_text);
        formPanel.add(password_label);
        formPanel.add(password_text);
        formPanel.add(btnSubmit);
        formPanel.add(btnCancel);
        formPanel.add(btnRegistration);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Adding the listeners to components..
        btnSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnRegistration.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new RegistrationForm();
                LoginForm.this.dispose();
            }
        });
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LoginForm.this.dispose();
            }
        });
        add(panel, BorderLayout.CENTER);
        setTitle("Please Login Here !");
        setSize(450, 250);
        setVisible(true);
    }


}
