package project;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.concurrent.CountDownLatch;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class DisplayMenu extends JFrame {
    static int idx = -1;
    CountDownLatch latch = new CountDownLatch(1);
    
    
    DisplayMenu(LinkedList<Node> ptr) {
    	
        setTitle("Select Your Choice");
        JPanel jp = new JPanel();
        int i = 1;
        
        for (Node a : ptr) {
            JButton b = new JButton(i + ") " + a.data);
            b.setPreferredSize(new Dimension(200, 70));
            jp.add(b);
           
            b.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                	JButton clickedButton = (JButton) e.getSource();
                    Character choice = clickedButton.getText().charAt(0);
                    String a = choice.toString();
                    DisplayMenu.idx = Integer.parseInt(a);
                    setVisible(false);
                    latch.countDown();
                }
            });

            i++;
        }

        add(jp);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();

        // Get the screen's resolution
        Dimension screenResolution = new Dimension(toolkit.getScreenSize());

        // Set the frame's size to match the screen resolution
        setSize(screenResolution);
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
