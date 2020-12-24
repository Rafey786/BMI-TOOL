package bmiTool;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class bmi extends JFrame {

	private JPanel contentPane;
	private JTextField feetTextField;
	private JTextField inchTextField;
	private JTextField weightTextField;
	private JTextField bmiTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bmi frame = new bmi();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public bmi() {
		setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 18));
		setForeground(new Color(0, 128, 0));
		setResizable(false);
		setTitle("BMI Calculation Tool");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel hightLabel = new JLabel("Your Height :");
		hightLabel.setForeground(new Color(153, 102, 0));
		hightLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		feetTextField = new JTextField();
		feetTextField.setFont(new Font("Tahoma", Font.BOLD, 16));
		feetTextField.setForeground(new Color(240, 255, 240));
		feetTextField.setHorizontalAlignment(SwingConstants.CENTER);
		feetTextField.setBackground(new Color(153, 204, 204));
		feetTextField.setColumns(10);
		
		inchTextField = new JTextField();
		inchTextField.setForeground(new Color(240, 255, 240));
		inchTextField.setFont(new Font("Tahoma", Font.BOLD, 16));
		inchTextField.setHorizontalAlignment(SwingConstants.CENTER);
		inchTextField.setBackground(new Color(153, 204, 204));
		inchTextField.setColumns(10);
		
		JLabel commentLabel = new JLabel("");
		commentLabel.setForeground(new Color(255, 0, 0));
		commentLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton bmiButton = new JButton("Calculate Your BMI");
		bmiButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double feet,inch,kilogram;
				double height,bmi;
				
				try {
					feet = Double.parseDouble(feetTextField.getText());
					inch = Double.parseDouble(inchTextField.getText());
					kilogram = Double.parseDouble(weightTextField.getText());
					
					height = (feet * 12) + inch;
					height = (height * 2.5) / 100;
					bmi = kilogram / (height * height);
					
					bmiTextField.setText(new DecimalFormat("##.##").format(bmi));
					
					if(bmi < 18.5) {
						commentLabel.setText("You are UnderWeight");
					}else if(bmi >= 18.5 && bmi <= 24.9) {
						commentLabel.setText("You are Normal");
					}else if(bmi > 24.9 && bmi <= 29.9) {
						commentLabel.setText("You are OverWeight");
					}else {
						commentLabel.setText("You are Obese");
					}
				}catch(Exception ex){
					commentLabel.setText("Please check Required TextFields");
				}
			}
		});
		bmiButton.setForeground(new Color(153, 102, 0));
		bmiButton.setBackground(new Color(255, 255, 153));
		bmiButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		
		JButton clearButton = new JButton("Clear");
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				feetTextField.setText("");
				inchTextField.setText("");
				weightTextField.setText("");
				bmiTextField.setText("");
				commentLabel.setText("");
			}
		});
		clearButton.setForeground(new Color(230, 230, 250));
		clearButton.setBackground(new Color(204, 0, 153));
		clearButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		JButton exitButton = new JButton("Exit");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exitButton.setForeground(new Color(230, 230, 250));
		exitButton.setBackground(new Color(255, 0, 0));
		exitButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		JLabel weightLabel = new JLabel("Your Weight :");
		weightLabel.setForeground(new Color(153, 102, 0));
		weightLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		JLabel inchLabel = new JLabel("inch");
		inchLabel.setForeground(new Color(153, 102, 0));
		inchLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		
		JLabel feetLabel = new JLabel("feet");
		feetLabel.setForeground(new Color(153, 102, 0));
		feetLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		
		weightTextField = new JTextField();
		weightTextField.setFont(new Font("Tahoma", Font.BOLD, 16));
		weightTextField.setForeground(new Color(240, 255, 240));
		weightTextField.setHorizontalAlignment(SwingConstants.CENTER);
		weightTextField.setBackground(new Color(153, 204, 204));
		weightTextField.setColumns(10);
		
		JLabel bmiLabel = new JLabel("Your BMI :");
		bmiLabel.setForeground(new Color(153, 102, 0));
		bmiLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		
		bmiTextField = new JTextField();
		bmiTextField.setFont(new Font("Tahoma", Font.BOLD, 16));
		bmiTextField.setForeground(new Color(240, 255, 240));
		bmiTextField.setHorizontalAlignment(SwingConstants.CENTER);
		bmiTextField.setBackground(new Color(153, 204, 204));
		bmiTextField.setColumns(10);
		
		JLabel kgLabel = new JLabel("kg");
		kgLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		kgLabel.setForeground(new Color(153, 102, 0));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(bmiLabel, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(bmiTextField, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(weightLabel)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(weightTextField, 0, 0, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(hightLabel)
									.addGap(18)
									.addComponent(feetTextField, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(kgLabel, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
								.addComponent(inchTextField, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))))
					.addGap(69))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(commentLabel, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE)
							.addGap(13))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(35)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addComponent(feetLabel)
									.addGap(117)
									.addComponent(inchLabel)
									.addGap(34))
								.addComponent(bmiButton, GroupLayout.PREFERRED_SIZE, 354, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(60)
									.addComponent(clearButton, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
									.addComponent(exitButton, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)))))
					.addGap(110))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(hightLabel, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(feetTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(inchTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(inchLabel)
						.addComponent(feetLabel, GroupLayout.PREFERRED_SIZE, 11, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(weightLabel, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(weightTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(kgLabel, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addComponent(bmiButton)
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(bmiLabel, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(bmiTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addComponent(commentLabel)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(exitButton, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(clearButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
