package project;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.CountDownLatch;

 class ExpMore extends JFrame{
	 JFrame frame;
	static CountDownLatch latch = new CountDownLatch(1);
	 static int choice =1;
   ExpMore() {
    	choice=1;
    	latch = new CountDownLatch(1);
        JFrame frame = new JFrame("Explore More");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Get the size of the screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // Set the size of the frame to the size of the screen
        frame.setSize(screenSize);

        frame.getContentPane().setBackground(new Color(173, 216, 230)); // Setting light blue color

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(173, 216, 230));

        JLabel label = new JLabel("Do you want to explore more?");
        label.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 40)); // Increasing the font size

        JButton forSureButton = new JButton("For sure");
        forSureButton.setBackground(new Color(25, 25, 112)); // Setting aesthetic dark blue color
        forSureButton.setForeground(Color.WHITE);
        forSureButton.setPreferredSize(new Dimension(150, 40)); // Setting preferred button size
        
        forSureButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
               frame.setVisible(false);
                latch.countDown();
            }
        });
        
        JButton notNowButton = new JButton("Not Now");
        notNowButton.setBackground(new Color(25, 25, 112)); // Setting aesthetic dark blue color
        notNowButton.setForeground(Color.WHITE);
        notNowButton.setPreferredSize(new Dimension(150, 40)); // Setting preferred button size

        

        forSureButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                choice =0;
                frame.setVisible(false);
                latch.countDown();
            }
        });
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(label, gbc);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(forSureButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(20, 0))); // Adding some space between buttons
        buttonPanel.add(notNowButton);
        gbc.gridy = 1;
        panel.add(buttonPanel, gbc);

        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
