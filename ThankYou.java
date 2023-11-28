package project;
import javax.swing.*;
import java.awt.*;

 class ThankYou extends JFrame {
	 JFrame frame ;
	 ThankYou(){
		 
         frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Get the size of the screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // Set the size of the frame to the size of the screen
        frame.setSize(screenSize);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximize the frame

        // Create a panel with custom styling
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setColor(new Color(135, 206, 250)); // Setting background color
                g2d.fillRect(0, 0, getWidth(), getHeight());
                g2d.dispose();
            }
        };
        panel.setLayout(new GridBagLayout());

        JLabel label = new JLabel("<html><div style='text-align: center; color: #191970; font-size: 45pt; font-family: Times New Roman;'><b>Thank You For Visiting Our Platform !</b></div></html>");
        panel.add(label);

        frame.add(panel);
        frame.setVisible(true);
    }
}
