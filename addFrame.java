package project;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.concurrent.CountDownLatch;

class addFrame extends JFrame {
	
static int userChoice=-1 ;
static int idx=-1;
static int count;
static boolean isAdded = false;
CountDownLatch latch = new CountDownLatch(1);

    public addFrame(Node ptr) {
    	latch = new CountDownLatch(1);
    	isAdded=false;
    	 userChoice=-1 ;
    	 isAdded=false;
    	if(ptr.child==null) {

            JPanel panel = new JPanel();
            JTextField usernameField = new JTextField(15);
            JPasswordField passwordField = new JPasswordField(15);

            panel.add(new JLabel("Topic :"));
            panel.add(usernameField);
            panel.add(new JLabel("Link  :"));
            panel.add(passwordField);

            int result = JOptionPane.showConfirmDialog(null, panel, "Login",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

            if (result == JOptionPane.OK_OPTION) {
                String topic = usernameField.getText();
                String path = new String(passwordField.getPassword());

                if (!topic.isEmpty() && !path.isEmpty()) {
                	Tree.path.put(topic,path);
                	JOptionPane.showMessageDialog(panel, "Successfully Added");
                	isAdded=true;
                	ptr.child=new LinkedList<>();
                	ptr.child.add(new Node(topic));
                    latch.countDown();
                    setVisible(false);
                    } else {
                    JOptionPane.showMessageDialog(panel, "Login failed!");
                }
            }
            latch.countDown();
    	}
        setTitle("Main Frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        getContentPane().setBackground(new Color(135, 206, 250)); // Set blue color

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        int i=0;
        count=0;
        for (Node a: ptr.child) {
        	JButton b=new JButton(i+") "+a.data);
            b.setPreferredSize(new Dimension(330, 40));
            b.setBackground(Color.BLUE);
            b.setForeground(Color.WHITE);
            b.setFont(new Font("Arial", Font.PLAIN, 18));
            b.setFocusPainted(false);
            b.setBorder(BorderFactory.createLineBorder(Color.BLACK));
           
            b.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    b.setBackground(new Color(0,0,0)); // Purple
                    JButton clickedButton = (JButton) e.getSource();
					Character choice = clickedButton.getText().charAt(0);
					String a = choice.toString();
					int w = Integer.parseInt(a);
					userChoice=w;
                }
            });
            gbc.gridx = 5;
            gbc.gridy = i++;
            gbc.gridwidth = 2;
            gbc.anchor = GridBagConstraints.CENTER;
            panel.add(b, gbc);
            count++;
        }

        JButton addHereButton = new JButton("Add Here");
        addHereButton.setPreferredSize(new Dimension(150, 40));
        addHereButton.setBackground(new Color(173, 216, 230));
        addHereButton.setForeground(Color.BLACK);
        addHereButton.setFont(new Font("Arial", Font.PLAIN, 18));
        addHereButton.setFocusPainted(false);
        addHereButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        addHereButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
                JPanel panel = new JPanel();
                JTextField usernameField = new JTextField(15);
                JPasswordField passwordField = new JPasswordField(15);

                panel.add(new JLabel("Topic :"));
                panel.add(usernameField);
                panel.add(new JLabel("Link  :"));
                panel.add(passwordField);

                int result = JOptionPane.showConfirmDialog(null, panel, "Login",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                if (result == JOptionPane.OK_OPTION) {
                    String topic = usernameField.getText();
                    String path = new String(passwordField.getPassword());

                    if (!topic.isEmpty() && !path.isEmpty()) {
                    	Tree.path.put(topic,path);
                    	JOptionPane.showMessageDialog(panel, "Successfully Added");
                    	isAdded=true;
                    	ptr.child.add(new Node(topic));
                        latch.countDown();
                        setVisible(false);
                        } else {
                        JOptionPane.showMessageDialog(panel, "Login failed!");
                    }
                }
                	
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 10;
        panel.add(addHereButton, gbc);

        JButton subtopicButton = new JButton("Subtopic");
        subtopicButton.setPreferredSize(new Dimension(150, 40));
        subtopicButton.setBackground(new Color(173, 216, 230));
        subtopicButton.setForeground(Color.BLACK);
        subtopicButton.setFont(new Font("Arial", Font.PLAIN, 18));
        subtopicButton.setFocusPainted(false);
        subtopicButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        subtopicButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(userChoice ==-1) {
                	JOptionPane.showMessageDialog(panel, "Select The Topic First");
                }else {
                	
                     setVisible(false);
                     latch.countDown();
                }
            }
        });

        gbc.gridx = 7;
        gbc.gridy = 10;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(subtopicButton, gbc);

        add(panel, BorderLayout.CENTER);
        setVisible(true);
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

   
}
