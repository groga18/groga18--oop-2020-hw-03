import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.*;

import java.awt.*;
import java.awt.event.*;


 public class SudokuFrame extends JFrame {

	 JTextArea puzzleText;
	 JTextArea solutionText;
	 JButton check;
	 JCheckBox checkBox;
	 public SudokuFrame() {
		super("Sudoku Solver");
		setLayout(new BorderLayout(4, 4));
		puzzleText = new JTextArea(15, 20);
		solutionText = new JTextArea(15, 20);
		solutionText.setEditable(false);
		puzzleText.setBorder(new TitledBorder("Puzzele"));
		puzzleText.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				if(checkBox.isSelected())
					check();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				if(checkBox.isSelected())
					check();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				if(checkBox.isSelected())
					check();
			}
		});

		solutionText.setBorder(new TitledBorder("Solution"));
		add(puzzleText, BorderLayout.CENTER);
		add(solutionText, BorderLayout.EAST);


		Box controls = Box.createHorizontalBox();
		check = new JButton("Check");
		check.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				check();
			}
		});
		controls.add(check);
		checkBox = new JCheckBox("Auto Check");
		checkBox.setSelected(true);
		controls.add(checkBox);
		add(controls, BorderLayout.SOUTH);
		// Could do this:
		// setLocationByPlatform(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}

	private void check(){
	 	Sudoku sudoku;
		try {
			sudoku = new Sudoku(Sudoku.textToGrid(puzzleText.getText()));
			int ans = sudoku.solve();

			solutionText.setText(sudoku.getSolutionText() + "Solutions: "
					+ ans + "\nElapsed: " + sudoku.getElapsed() + "ms\n");
		} catch (Exception ParseError) {
			solutionText.setText("Parsing problem");
		}
	}




	 public static void main(String[] args) {
		// GUI Look And Feel
		// Do this incantation at the start of main() to tell Swing
		// to use the GUI LookAndFeel of the native platform. It's ok
		// to ignore the exception.
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception ignored) { }
		
		SudokuFrame frame = new SudokuFrame();
	}

}
