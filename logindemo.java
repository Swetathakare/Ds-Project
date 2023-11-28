package project;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.CountDownLatch;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;



 class Myframe extends JFrame{
    static boolean admn = false;
	JFrame frame;
	static CountDownLatch latch = new CountDownLatch(1); 
    Myframe(){
	   admn=false;
        // Create a JFrame
    	new JFrame();
    	latch = new CountDownLatch(1);
        setTitle("User and Admin Frame");
        getContentPane().setBackground(new Color(173, 216, 230));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize);
        Color g = new Color(255,0,0);
        
     
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(20, 20, 20, 20); // Add padding

        // Create the User label
        JLabel userLabel = new JLabel("I Am Here To Learn!");
        userLabel.setForeground(Color.BLACK); // Set label text color to black
        userLabel.setFont(new Font("Serif", Font.ITALIC, 35)); // Increase font size

        // Create the User button
        JButton userButton = new JButton("User");
        userButton.setBackground(new Color(0, 51, 102)); // Dark blue background
        userButton.setForeground(Color.WHITE); // Set button text color to white
        userButton.setFont(new Font("Arial", Font.PLAIN, 24)); // Increase font size

        // Add action listener to the User button
       
        // Create the Admin label
        JLabel adminLabel = new JLabel("I Am Here To Contribute !");
        adminLabel.setForeground(Color.BLACK); // Set label text color to black
        adminLabel.setFont(new Font("Serif", Font.ITALIC, 35)); // Increase font size

        // Create the Admin button
        JButton adminButton = new JButton("Admin");
        adminButton.setBackground(new Color(0, 51, 102)); // Dark blue background
        adminButton.setForeground(Color.WHITE); // Set button text color to white
        adminButton.setFont(new Font("Arial", Font.PLAIN, 24)); // Increase font size

        

        // Add the User label and button to the main panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(userLabel, gbc);

        gbc.gridy = 1;
        mainPanel.add(userButton, gbc);

        // Add the Admin label and button to the main panel
        gbc.gridy = 2;
        mainPanel.add(adminLabel, gbc);

        gbc.gridy = 3;
        mainPanel.add(adminButton, gbc);
        LineBorder lb = new LineBorder(new Color(15, 8, 61),5);
        mainPanel.setBorder(lb);
        mainPanel.setBackground(new Color(202, 206, 217));
        // Add the main panel to the frame
        add(mainPanel);
        
        // Center the frame on the screen
        setLocationRelativeTo(null);

      ActionListener button1Listener = new ActionListener() {
      public void actionPerformed(ActionEvent e) {
      	admn=true;
        
          latch.countDown();
          setVisible(false);
          
      }
  };
  ActionListener button2Listener = new ActionListener() {          
      public void actionPerformed(ActionEvent e) {
          latch.countDown();
          setVisible(false);
      }
  };
  adminButton.addActionListener(button1Listener);
  userButton.addActionListener(button2Listener);   
        setVisible(true);
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }}
