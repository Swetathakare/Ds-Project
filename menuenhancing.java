package project;
import javax.swing.border.LineBorder;
import javax.swing.*;
import java.awt.*;
import javax.swing.*;
import java.awt.*;

import javax.swing.*;
import java.awt.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class menuenhancing extends JFrame {
	
    public static void main(String[] args) {
    	JFrame frame = new JFrame("Button Centered Example");
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    Toolkit toolkit = Toolkit.getDefaultToolkit();
	    Dimension screenResolution = new Dimension(toolkit.getScreenSize());
	    frame.setSize(screenResolution);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8); // Add some padding

        JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");
        JButton button3 = new JButton("Button 3");
        JButton button4 = new JButton("Button 4");

        // Increase the button size
        Dimension buttonSize = new Dimension(200, 50);
        button1.setPreferredSize(buttonSize);
        button2.setPreferredSize(buttonSize);
        button3.setPreferredSize(buttonSize);
        button4.setPreferredSize(buttonSize);

        // Add buttons to the panel with GridBagLayout to center them
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(button1, gbc);

        gbc.gridy = 1 ;
        panel.add(button2, gbc);

        gbc.gridy = 2;
        panel.add(button3, gbc);

        gbc.gridy = 3;
        panel.add(button4, gbc);
        LineBorder lb = new LineBorder(new Color(15, 8, 61),6);
        panel.setBorder(lb);
        panel.setBackground();
        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
        
    }
}

//public class menuenhancing {
//	public static void main(String[] args) {
//        // Create a JFrame
//        JFrame frame = new JFrame("Blue Frame");
//
//        // Set the size of the frame to match the screen size
//        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//        frame.setSize(screenSize);
//
//        // Create a panel with a blue gradient background
//        JPanel panel = new JPanel() {
//            @Override
//            protected void paintComponent(Graphics g) {
//                super.paintComponent(g);
//                GradientPaint gradientPaint = new GradientPaint(0, 0, new Color(173, 216, 230), 0, getHeight(), new Color(135, 206, 235));
//                Graphics2D g2d = (Graphics2D) g;
//                g2d.setPaint(gradientPaint);
//                g2d.fillRect(0, 0, getWidth(), getHeight());
//            }
//        };
//        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
//        // Create a constraint for centering the buttons and labels
//        GridBagConstraints gbc = new GridBagConstraints();
//        gbc.insets = new Insets(10, 10, 10, 10); // Add padding around buttons
//
//        panel.setLayout(new GridBagLayout());
//
//        // Create "User" label
//        JLabel userLabel = new JLabel("User");
//        
//        userLabel.setForeground(Color.BLACK);
//        gbc.gridx = 0;
//        gbc.gridy = 0;
//        panel.add(userLabel, gbc);
//
//        // Create "User" button
//        JButton userButton = new JButton("User");
//        
//        userButton.setPreferredSize(new Dimension(150, 50)); // Set button size
//        userButton.setBackground(new Color(0, 51, 102)); // Dark blue
//        userButton.setForeground(Color.WHITE);
//        userButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // Action to be performed when the "User" button is clicked
//                System.out.println("User button clicked.");
//                userButton.setForeground(Color.BLACK); // Change font color to black
//            }
//        });
//        gbc.gridy = 2;
//        panel.add(userButton, gbc);
//
//        // Create "Admin" label
//        JLabel adminLabel = new JLabel("Admin");
//        adminLabel.setForeground(Color.BLACK);
//        gbc.gridy = 1;
//        panel.add(adminLabel, gbc);
//
//        // Create "Admin" button
//        JButton adminButton = new JButton("Admin");
//        adminButton.setPreferredSize(new Dimension(150, 50)); // Set button size
//        adminButton.setBackground(new Color(0, 76, 153)); // Lighter blue
//        adminButton.setForeground(Color.WHITE);
//        adminButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // Action to be performed when the "Admin" button is clicked
//                System.out.println("Admin button clicked.");
//                adminButton.setForeground(Color.BLACK); // Change font color to black
//            }
//        });
//
//        // Add the labels and buttons to the panel with constraints for centering
//        gbc.gridy = 2;
//        panel.add(userButton, gbc);
//
//        gbc.gridy = 3;
//        panel.add(adminButton, gbc);
//
//        // Add the panel to the frame
//        frame.add(panel);
//
//        // Set the default close operation
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        // Make the frame visible
//        frame.setVisible(true);
//    }
//}
//public class menuenhancing {
//    public static void main(String[] args) {
//        JFrame frame = new JFrame("Learning Project");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(600, 400);
//        frame.getContentPane().setBackground(Color.YELLOW); // Yellow background color
//
//        // Create a header panel with a title
//        JPanel headerPanel = new JPanel();
//        headerPanel.setBackground(new Color(135, 206, 235)); // Light blue header background color
//        JLabel titleLabel = new JLabel("Welcome to Learning Project");
//        titleLabel.setForeground(new Color(70, 130, 180)); // Dark blue title text color
//        titleLabel.setFont(new Font("Arial", Font.BOLD, 24)); // Title font
//        headerPanel.add(titleLabel);
//
//        // Create a content panel with GridBagLayout
//        JPanel contentPanel = new JPanel(new GridBagLayout());
//        GridBagConstraints constraints = new GridBagConstraints();
//        constraints.insets = new Insets(10, 10, 10, 10);
//
//        // Create a label with educational content
//        JLabel label = new JLabel("Learn, Explore, and Grow!");
//        label.setForeground(new Color(70, 130, 180)); // Dark blue text color
//        label.setFont(new Font("Arial", Font.PLAIN, 18)); // Font
//        constraints.gridx = 0;
//        constraints.gridy = 0;
//        contentPanel.add(label, constraints);
//
//        // Create an "Explore Courses" button
//        JButton exploreButton = new JButton("Explore Courses");
//        exploreButton.setBackground(new Color(135, 206, 235)); // Light blue button background color
//        exploreButton.setForeground(Color.WHITE); // Button text color
//        exploreButton.setFocusPainted(false);
//        exploreButton.setFont(new Font("Arial", Font.PLAIN, 16)); // Button font
//        constraints.gridx = 0;
//        constraints.gridy = 1;
//        contentPanel.add(exploreButton, constraints);
//
//        // Add the panels to the frame
//        frame.getContentPane().setLayout(new BorderLayout());
//        frame.getContentPane().add(headerPanel, BorderLayout.NORTH);
//        frame.getContentPane().add(contentPanel, BorderLayout.CENTER);
//
//        // Center the frame on the screen
//        frame.setLocationRelativeTo(null);
//
//        frame.setVisible(true);
//    }
////}
//import javax.swing.*;
//import java.awt.*;
//import java.awt.Font;
//
//public class menuenhancing {
//    public static void main(String[] args) {
//        JFrame frame = new JFrame("Learning Project");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(600, 400);
//
//        // Set the background color of the content pane to yellow
//        Container contentPane = frame.getContentPane();
//        contentPane.setBackground(Color.YELLOW);
//
//        // Create a header panel with a title
//        JPanel headerPanel = new JPanel();
//        headerPanel.setBackground(new Color(135, 206, 235)); // Light blue header background color
//        JLabel titleLabel = new JLabel("Welcome to Learning Project");
//        titleLabel.setForeground(new Color(70, 130, 180)); // Dark blue title text color
//        titleLabel.setFont(new Font("Arial", Font.BOLD, 24)); // Title font
//        headerPanel.add(titleLabel);
//
//        // Create a content panel with GridBagLayout
//        JPanel contentPanel = new JPanel(new GridBagLayout());
//        GridBagConstraints constraints = new GridBagConstraints();
//        constraints.insets = new Insets(10, 10, 10, 10);
//
//        // Create a label with educational content
//        JLabel label = new JLabel("Learn, Explore, and Grow!");
//        label.setForeground(new Color(70, 130, 180)); // Dark blue text color
//        label.setFont(new Font("Arial", Font.PLAIN, 18)); // Font
//        constraints.gridx = 0;
//        constraints.gridy = 0;
//        contentPanel.add(label, constraints);
//
//        // Create an "Explore Courses" button
//        JButton exploreButton = new JButton("Explore Courses");
//        exploreButton.setBackground(new Color(135, 206, 235)); // Light blue button background color
//        exploreButton.setForeground(Color.WHITE); // Button text color
//        exploreButton.setFocusPainted(false);
//        exploreButton.setFont(new Font("Arial", Font.PLAIN, 16)); // Button font
//        constraints.gridx = 0;
//        constraints.gridy = 1;
//        contentPanel.add(exploreButton, constraints);
//
//        // Add the panels to the frame
//        frame.getContentPane().setLayout(new BorderLayout());
//        frame.getContentPane().add(headerPanel, BorderLayout.NORTH);
//        frame.getContentPane().add(contentPanel, BorderLayout.CENTER);
//
//        // Center the frame on the screen
//        frame.setLocationRelativeTo(null);
//
//        frame.setVisible(true);
//    }
//}


//public class menuenhancing{
//    public static void main(String[] args) {
//        JFrame frame = new JFrame("Learning Project");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(600, 400);
//
//        // Create a JPanel for the content pane and set the background color to yellow
//        JPanel contentPane = new JPanel();
//        frame.getContentPane().setBackground(Color.YELLOW);
//
//        // Create a header panel with a title
//        JPanel headerPanel = new JPanel();
//        headerPanel.setBackground(new Color(135, 206, 235)); // Light blue header background color
//        JLabel titleLabel = new JLabel("Welcome to Learning Project");
//        titleLabel.setForeground(new Color(70, 130, 180)); // Dark blue title text color
//        titleLabel.setFont(new Font("Arial", Font.BOLD, 24)); // Title font
//        headerPanel.add(titleLabel);
//
//        // Create a content panel with GridBagLayout
//        JPanel contentPanel = new JPanel(new GridBagLayout());
//        GridBagConstraints constraints = new GridBagConstraints();
//        constraints.insets = new Insets(10, 10, 10, 10);
//
//        // Create a label with educational content
//        JLabel label = new JLabel("Learn, Explore, and Grow!");
//        label.setForeground(new Color(70, 130, 180)); // Dark blue text color
//        label.setFont(new Font("Arial", Font.PLAIN, 18)); // Font
//        constraints.gridx = 0;
//        constraints.gridy = 0;
//        contentPanel.add(label, constraints);
//
//        // Create an "Explore Courses" button
//        JButton exploreButton = new JButton("Explore Courses");
//        exploreButton.setBackground(new Color(135, 206, 235)); // Light blue button background color
//        exploreButton.setForeground(Color.WHITE); // Button text color
//        exploreButton.setFocusPainted(false);
//        exploreButton.setFont(new Font("Arial", Font.PLAIN, 16)); // Button font
//        constraints.gridx = 0;
//        constraints.gridy = 1;
//        contentPanel.add(exploreButton, constraints);
//
//        // Add the panels to the frame
//        contentPane.setLayout(new BorderLayout());
//        contentPane.add(headerPanel, BorderLayout.NORTH);
//        contentPane.add(contentPanel, BorderLayout.CENTER);
//
//        // Center the frame on the screen
//        frame.setLocationRelativeTo(null);
//
//        frame.setVisible(true);
//    }
//}
//import javax.swing.*;
//import java.awt.*;
//
//public class menuenhancing {
//	public static void main(String[] args) {
//	JFrame frame = new JFrame("Blue Frame");
//
//    // Set the size of the frame
//    frame.setSize(600, 400); // Larger frame
//
//    // Set the background color to blue
//    frame.getContentPane().setBackground(Color.BLUE);
//
//    // Create the first panel with text and a button
//    JPanel panel1 = new JPanel();
//    panel1.setBackground(Color.CYAN); // Change the background color
//
//    JLabel label1 = new JLabel("Welcome to the journey");
//    panel1.add(label1);
//    // Create the second panel with a label and a button
//    JPanel panel2 = new JPanel();
//    panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
//
//    JLabel label2 = new JLabel("AS Learn, explore and grow");
//    panel2.add(label2);
//
//    JButton exploreButton = new JButton("Explore");
//    exploreButton.setForeground(Color.RED);
//    panel2.add(exploreButton);
//
//    // Add both panels to the frame
//    frame.setLayout(new GridLayout(2, 1)); // Two rows, one column
//    frame.add(panel1);
//    frame.add(panel2);
//
//    // Set the default close operation
//    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//    // Make the frame visible
//    frame.setVisible(true);
//}}
