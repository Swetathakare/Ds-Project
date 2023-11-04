package project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.concurrent.CountDownLatch;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
 class displayMenu extends JFrame {
    static int idx = -1;
    CountDownLatch latch = new CountDownLatch(1);
    JFrame f;
    
    displayMenu(LinkedList<Node> ptr) {
    	new JFrame("Button Centered Example");
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    Toolkit toolkit = Toolkit.getDefaultToolkit();
	    Dimension screenResolution = new Dimension(toolkit.getScreenSize());
	    setSize(screenResolution);
        setTitle("Select Your Choice");
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15,15,15,15);
        
        int i = 1;
        
        gbc.gridx=0;
        gbc.gridy=0;
        
        JPanel jp = new JPanel(new GridBagLayout());
        for (Node a : ptr) {
        	
            JButton b = new JButton(i + ") " + a.data);
            b.setPreferredSize(new Dimension(350, 70));
            b.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                	JButton clickedButton = (JButton) e.getSource();
                    Character choice = clickedButton.getText().charAt(0);
                    String a = choice.toString();
                    displayMenu.idx = Integer.parseInt(a);
                    setVisible(false);
                    latch.countDown();
                }
            });
            b.setBackground(new Color(44, 59, 87));
            b.setForeground(new Color(197, 221, 232));
            jp.add(b,gbc);
            
            gbc.gridy=i++;
            
        }
        LineBorder lb = new LineBorder(new Color(15, 8, 61),6);
        jp.setBorder(lb);
        jp.setBackground(new Color(197, 221, 235));
        add(jp, BorderLayout.CENTER);
       setVisible(true);
        
        try {
            // Wait for the user to click the button
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    int getIndex() {
        return idx;
    }
}
