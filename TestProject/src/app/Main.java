package app;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private CardLayout card = new CardLayout();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(10, 68, 464, 382);
		contentPane.add(panel);
		panel.setLayout(card);
		
		Home homePanel = new Home();
		panel.add(homePanel, "homePanel");
		
		Sample samplePanel = new Sample();
		panel.add(samplePanel, "samplePanel");
		
		JLabel HomeLbl = new JLabel("Home");
		HomeLbl.setBounds(131, 22, 46, 14);
		contentPane.add(HomeLbl);
		
		JLabel Samplelbl = new JLabel("Sample");
		Samplelbl.setBounds(259, 22, 46, 14);
		contentPane.add(Samplelbl);
		
		JPanel panel_1 = new JPanel();
		panel_1.setVisible(true);
		panel_1.setBounds(131, 22, 33, 14);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setVisible(false);
		panel_2.setBounds(259, 22, 46, 14);
		contentPane.add(panel_2);
		
		HomeLbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_1.setVisible(true);
				panel_2.setVisible(false);
				card.show(panel, "homePanel");
			}
		});
		
		Samplelbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_1.setVisible(false);
				panel_2.setVisible(true);
				card.show(panel, "samplePanel");
			}
		});
	}
}
