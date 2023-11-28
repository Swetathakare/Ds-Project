package project;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.io.File;
import java.util.*;
import javax.swing.*;
import java.util.concurrent.CountDownLatch;

 class Explore extends JFrame{
	JButton b1;
	int exp = 0;
	static CountDownLatch latch = new CountDownLatch(1);
	JFrame frame;
    Explore() {
    	exp = 0;
        new JFrame();
        latch = new CountDownLatch(1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    Toolkit toolkit = Toolkit.getDefaultToolkit();
	    Dimension screenResolution = new Dimension(toolkit.getScreenSize());
	    setSize(screenResolution);
        JPanel headerPanel = new JPanel();
        setTitle ("LEARNING PROJECT");
        headerPanel.setBackground(new Color(115, 167, 201)); // Light blue header background color
        JLabel titleLabel = new JLabel(" Welcome to Learning Journey !");
        titleLabel.setForeground(new Color(40, 62, 88)); // Dark blue title text color
        titleLabel.setFont(new Font("Serif",Font.BOLD, 30)); // Title font
        headerPanel.add(titleLabel);
        
        // Create a content panel with GridBagLayout
        JPanel contentPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10,10,10,10);

        // Create a label with educational content
        JLabel label = new JLabel("Learn, Explore, and Grow!");
        label.setForeground(new Color(40, 62, 88)); // Dark blue text color
        label.setFont(new Font("Arial", Font.ITALIC, 35)); // Font
        constraints.gridx = 0;
        constraints.gridy = 0;
        contentPanel.add(label, constraints);

        // Create an "Explore Courses" button
        b1 = new JButton("Explore Courses");
        b1.setBackground(new Color(75, 127, 159)); // Light blue button background color
        b1.setForeground(Color.WHITE); // Button text color
        b1.setFocusPainted(false);
        b1.setFont(new Font("Arial", Font.PLAIN, 30)); // Button font
        constraints.gridx = 0;
        constraints.gridy = 1;
        contentPanel.add(b1, constraints);

        // Add the panels to the frame
        getContentPane().setLayout(new BorderLayout());
       getContentPane().add(headerPanel, BorderLayout.NORTH);
       getContentPane().add(contentPanel, BorderLayout.CENTER);

        // Center the frame on the screen
       setLocationRelativeTo(null);

       setVisible(true);
    
		ActionListener button1Listener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latch.countDown();
				setVisible(false);
			}
		};
		b1.addActionListener(button1Listener);
		try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

	}
}
