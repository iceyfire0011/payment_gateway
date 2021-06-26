package view;

import iRepository.IUserRepo;
import model.User;
import repository.UserRepo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class RegistrationForm extends JFrame {
    JPanel panel, formHeaderPanel, formPanel;
    JLabel formHeader, user_label, password_label, full_name_label, message;
    JTextField userName_text, full_name_text;
    JPasswordField password_text;
    JButton btnSubmit, btnCancel, btnLogin;
    GridLayout loginFormLayout;
    IUserRepo iUserRepo;

    RegistrationForm() {
        //form header
        formHeader = new JLabel();
        formHeader.setText("Registration Form");
        formHeader.setSize(120, 50);
        formHeaderPanel = new JPanel(new FlowLayout());
        formHeaderPanel.add(formHeader);
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
        // Full name Label
        full_name_label = new JLabel();
        full_name_label.setText("Full Name :");
        full_name_text = new JTextField();
        full_name_text.setSize(120, 40);
        // Submit
        btnSubmit = new JButton("Submit");
        btnCancel = new JButton("Cancel");
        btnLogin = new JButton("Login");
        loginFormLayout = new GridLayout();
        loginFormLayout.setHgap(20);
        loginFormLayout.setVgap(20);
        loginFormLayout.setRows(5);
        loginFormLayout.setColumns(2);
        formPanel = new JPanel(loginFormLayout);
        panel = new JPanel(new BorderLayout());
//        panel.setLayout(null);
        panel.add(formHeaderPanel, BorderLayout.NORTH);
        panel.add(formPanel, BorderLayout.SOUTH);

        formPanel.add(user_label);
        formPanel.add(userName_text);
        formPanel.add(password_label);
        formPanel.add(password_text);
        formPanel.add(full_name_label);
        formPanel.add(full_name_text);
        formPanel.add(btnSubmit);
        formPanel.add(btnCancel);
        formPanel.add(btnLogin);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Adding the listeners to components..
        btnSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                User user = new User();
                user.setUsername(userName_text.getText());
                user.setPassword(new String(password_text.getPassword()));
                user.setFullName(full_name_text.getText());
                List<User> users = new LinkedList<>();
                try {
                    iUserRepo = new UserRepo();
                    users = iUserRepo.userList();
                    for (var existingUser : users) {
                        if (existingUser.equals(user.getUsername())){
                            return;
                        }
                    }
                    iUserRepo.create(user);
                } catch (Exception throwables) {
                    throwables.printStackTrace();
                }

            }
        });
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new LoginForm();
                RegistrationForm.this.dispose();
            }
        });
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                RegistrationForm.this.dispose();
            }
        });
        add(panel, BorderLayout.CENTER);
        setTitle("Please Login Here !");
        setSize(450, 300);
        setVisible(true);
    }


}
