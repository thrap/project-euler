import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class SudokuGUI extends JFrame{
	
	private static final Color COLOR_BACKGROUND = Color.WHITE;
	
	public SudokuGUI() {
		getContentPane().setBackground(COLOR_BACKGROUND);
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton solveButton = new JButton("Solve!");
		solveButton.setSize(300,30);
		solveButton.setLocation(0, 33*9);
		add(solveButton);
		
		final JTextField[][] field = new JTextField[9][9];
		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field.length; j++) {
				field[i][j] = new JTextField("");
//				field[i][j].setBorder(null);
				field[i][j].setSize(30, 30);
				field[i][j].setLocation(32*i, 32*j);
				add(field[i][j]);
			}
		}
		
		
		solveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < field.length; i++) {
					for (int j = 0; j < field.length; j++) {
						System.out.print(field[i][j].getText());
					}
					System.out.println();
				}
			}
		});
		
	}
	
	public static void main(String[] args) {
		new SudokuGUI().setVisible(true);
	}
}
