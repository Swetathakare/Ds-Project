package project;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.CountDownLatch;

class LoginScreen extends JFrame {
	
	static String username ;
	static String password;
	static boolean isValid;
	
	CountDownLatch latch = new CountDownLatch(1);
	
    public LoginScreen() {
    	latch = new CountDownLatch(1);
    	username=null;
    	password=null;
    	isValid=false;
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Occupies the whole screen

        final JPanel panel = new JPanel();
        panel.setBackground(new Color(173, 216, 230)); // Set blue color

        Font font = new Font("Serif", Font.PLAIN, 30);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setFont(font);
        final JTextField userText = new JTextField(20);
        userText.setFont(font);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(font);
        final JPasswordField passwordText = new JPasswordField(20);
        passwordText.setFont(font);

        JButton loginButton = new JButton("Submit");
        loginButton.setFont(font);
        loginButton.setBackground(new Color(0, 0, 139)); // Dark blue color
        loginButton.setForeground(Color.WHITE); // Blue text color
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText();
                String password = new String(passwordText.getPassword());
                if (username.equals("admin") && password.equals("admin")) {
                    JOptionPane.showMessageDialog(panel, "Login Successful");
                    latch.countDown();
                    LoginScreen.isValid=true;
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(panel, "Incorrect username or password");
                }
            }
        });

        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);
        panel.add(userLabel, gbc);

        gbc.gridx = 1;
        panel.add(userText, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(passwordLabel, gbc);

        gbc.gridx = 1;
        panel.add(passwordText, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(loginButton, gbc);

        add(panel);
        setVisible(true);
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LoginScreen();
            }
        });
    }
  
}
