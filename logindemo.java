package project;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

class LoginDemo extends JFrame implements ActionListener {
	   JPanel panel;
	   JLabel user_label, password_label, message;
	   JTextField userName_text;
	   JPasswordField password_text;
	   JButton submit, cancel;
	   LoginDemo() {
	      // Username Label
	      user_label = new JLabel();
	      user_label.setText("User Name :");
	      userName_text = new JTextField();
	      // Password Label
	      password_label = new JLabel();
	      password_label.setText("Password :");
	      password_text = new JPasswordField();
	      // Submit
	      submit = new JButton("SUBMIT");
	      panel = new JPanel(new GridLayout(3, 1));
	      panel.add(user_label);
	      panel.add(userName_text);
	      panel.add(password_label);
	      panel.add(password_text);
	      message = new JLabel();
	      panel.add(message);
	      panel.add(submit);
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      // Adding the listeners to components..
	      submit.addActionListener(this);
	      add(panel, BorderLayout.CENTER);
	      setTitle("Please Login Here !");
	      Toolkit toolkit = Toolkit.getDefaultToolkit();

	        // Get the screen's resolution
	        Dimension screenResolution = new Dimension(toolkit.getScreenSize());

	        // Set the frame's size to match the screen resolution
	        setSize(screenResolution);
	      setVisible(true);
	   }
	   
	   @Override
	  public void actionPerformed(ActionEvent ae){
	      String userName = userName_text.getText();
	      String password = password_text.getText();
	      if (userName.trim().equals("admin") && password.trim().equals("admin")) {
	         message.setText(" Hello " + userName + "");
	      } else {
	         message.setText(" Invalid user.. ");
	      }
	   }
	}
