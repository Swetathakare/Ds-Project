package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.util.concurrent.CountDownLatch;

class adddelete extends JFrame {

	CountDownLatch latch = new CountDownLatch(1);
	static String userchoice;

	public adddelete() {
		latch = new CountDownLatch(1);
		userchoice =null;
		setTitle("Main Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		getContentPane().setBackground(new Color(173, 216, 230));

		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);

		JButton addTopicButton = new JButton("Add a topic");
		addTopicButton.setPreferredSize(new Dimension(200, 50));
		addTopicButton.setBackground(new Color(173, 216, 230));
		addTopicButton.setForeground(Color.BLACK);
		addTopicButton.setFont(new Font("Arial", Font.PLAIN, 20));
		addTopicButton.setFocusPainted(false);
		addTopicButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		addTopicButton.setOpaque(true);
		addTopicButton.setBorderPainted(false);
		addTopicButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				userchoice = "add";
				latch.countDown();
				setVisible(false);
			}
		});
		addTopicButton.setUI(new RoundedButtonUI());

		
		
	
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(addTopicButton, gbc);

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
				new adddelete();
			}
		});
	}

	static class RoundedButtonUI extends javax.swing.plaf.basic.BasicButtonUI {
		@Override
		protected void installDefaults(AbstractButton b) {
			super.installDefaults(b);
			b.setContentAreaFilled(false);
			b.setOpaque(true);
		}

		@Override
		protected void paintText(Graphics g, JComponent c, Rectangle textRect, String text) {
			AbstractButton b = (AbstractButton) c;
			ButtonModel model = b.getModel();
			if (model.isPressed()) {
				textRect.translate(1, 1);
			}
			super.paintText(g, c, textRect, text);
		}

		@Override
		public void paint(Graphics g, JComponent c) {
			Graphics2D g2 = (Graphics2D) g.create();
			AbstractButton b = (AbstractButton) c;
			if (b.getModel().isRollover()) {
				g2.setColor(new Color(100, 149, 237));
			} else {
				g2.setColor(c.getBackground());
			}
			g2.fill(new RoundRectangle2D.Double(0, 0, c.getWidth() - 1, c.getHeight() - 1, 20, 20));
			g2.dispose();
			super.paint(g, c);
		}
	}
}
