package bsn3g9_cs4050_assignment1; /**
 *
 * @author Ouda
 */

//importing the libraries that will be needed in this program

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//the class with button and main method
public class SortGUI {

	// import javax.swing.JFrame;

	//a variable that holds the amount of time for the selection sort takes to execute
	public static double selectionTime = 0.0;
	//a variable that holds the amount of time for the recursive merge sort takes to execute
	public static double rmergeTime = 0.0;
	//a variable that holds the amount of time for the iterative merge sort takes to execute
	public static double imergeTime = 0.0;
	//a variable that holds the amount of time for the bubble sort takes to execute
	public static double bubbleTime = 0.0;
	//a variable that holds the amount of time for the insertion sort takes to execute
	public static double insertionTime = 0.0;
	//a variable that holds the amount of time for the shell sort takes to execute
	public static double shellTime = 0.0;
	//a variable that holds the amount of time for the quick sort takes to execute
	public static double quickTime = 0.0;
	//a variable that holds the amount of time for the radix sort takes to execute
	public static double radixTime = 0.0;
	//Boolean variable that is made to keep track whether or not the selection sort has already been used
	public boolean Selection_Done = false;
	//Boolean variable that is made to keep track whether or not the recursive merge sort has already been used
	public boolean Recersive_Merge_Done = false;
	//Boolean variable that is made to keep track whether or not the iterative merge sort has already been used
	public boolean Iterative_Merge_Done = false;
	//Boolean variable that is made to keep track whether or not the bubble sort has already been used
	public boolean Bubble_Done = false;
	//Boolean variable that is made to keep track whether or not the insertion sort has already been used
	public boolean Insertion_Done = false;
	//Boolean variable that is made to keep track whether or not the shell sort has already been used
	public boolean Shell_Done = false;
	//Boolean variable that is made to keep track whether or not the quick sort has already been used
	public boolean Quick_Done = false;
	//Boolean variable that is made to keep track whether or not the radix sort has already been used
	public boolean Radix_Done = false;
	//Making a object from the class SortShow
	SortShow sortArea = new SortShow();

	//Default constructor for SortGUI
	public SortGUI() {
		//making a MyScreen object

		// You need to adjust the following values to your Screen dimensions

		MyScreen screen = new MyScreen();
		//Setting a title to the GUI window
		screen.setTitle("Assignment-1 by Brody Nelson; Base of project coded by Ouda");
		//setting the size of the window
		screen.setSize(1400, 800);
		//the operation when the frame is closed
		screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//is set to true to display the frame
		screen.setVisible(true);
	}
	//A public class that extends JFrame
	public class MyScreen extends JFrame {
		//making a scramble button with a text "Scramble Lines" on it
		JButton scramble_button = new JButton("Scramble Lines");
		//making a selection button with a text "Selection" on it
		JRadioButton selection = new JRadioButton("Selection");
		//making a recursive merge button with a text "Scramble Lines" on it
		JRadioButton rmerge = new JRadioButton("Merge Recursive");
		//making a iterative merge button with a text "Selection" on it
		JRadioButton imerge = new JRadioButton("Merge Iterative");
		//making a bubble button with a text "Bubble" on it
		JRadioButton bubble = new JRadioButton("Bubble");
		//making a insertion button with a text "Insertion" on it
		JRadioButton insertion = new JRadioButton("Insertion");
		//making a shell button with a text "Shell" on it
		JRadioButton shell = new JRadioButton("Shell");
		//making a quick button with a text "Quick" on it
		JRadioButton quick = new JRadioButton("Quick");
		//making a radix button with a text "Radix" on it
		JRadioButton radix = new JRadioButton("Radix");
		//making a reset button with a text "Selection" on it
		JRadioButton reset = new JRadioButton("Reset");
		//A label that displays the time it took for the Selection sort took to execute
		JLabel selection_time_label = new JLabel("Selection Time");
		JLabel selection_time_taken = new JLabel("");
		//A label that displays the time it took for the recursive merge sort took to execute
		JLabel rmerge_time_label = new JLabel("Merge-Rec Time");
		JLabel rmerge_time_taken = new JLabel("");
		//A label that displays the time it took for the iterative merge sort took to execute
		JLabel imerge_time_label = new JLabel("Merge-Ita Time");
		JLabel imerge_time_taken = new JLabel("");
		//A label that displays the time it took for the bubble sort took to execute
		JLabel bubble_time_label = new JLabel("Bubble Time");
		JLabel bubble_time_taken = new JLabel("");
		//A label that displays the time it took for the insertion sort took to execute
		JLabel insertion_time_label = new JLabel("Insertion Time");
		JLabel insertion_time_taken = new JLabel("");
		//A label that displays the time it took for the shell sort took to execute
		JLabel shell_time_label = new JLabel("Shell Time");
		JLabel shell_time_taken = new JLabel("");
		//A label that displays the time it took for the quick sort took to execute
		JLabel quick_time_label = new JLabel("Quick Time");
		JLabel quick_time_taken = new JLabel("");
		//A label that displays the time it took for the radix sort took to execute
		JLabel radix_time_label = new JLabel("Radix Time");
		JLabel radix_time_taken = new JLabel("");

		//the default constructor for the class MyScreen
		public MyScreen() {
			// Panel where sorted lines_lengths will displayed
			//The time displayed for selection sort will be the colour red
			selection_time_taken.setForeground(Color.RED);
			//The time displayed for recursive merge sort will be the colour red
			rmerge_time_taken.setForeground(Color.RED);
			//The time displayed for iterative merge sort will be the colour red
			imerge_time_taken.setForeground(Color.RED);
			//The time displayed for bubble sort will be the colour red
			bubble_time_taken.setForeground(Color.RED);
			//The time displayed for insertion sort will be the colour red
			insertion_time_taken.setForeground(Color.RED);
			//The time displayed for shell sort will be the colour red
			shell_time_taken.setForeground(Color.RED);
			//The time displayed for quick sort will be the colour red
			quick_time_taken.setForeground(Color.RED);
			//The time displayed for radix sort will be the colour red
			radix_time_taken.setForeground(Color.RED);
			//The selection button text will be the colour blue
			selection.setForeground(Color.BLUE);
			//The recursive merge button text will be the colour blue
			rmerge.setForeground(Color.BLUE);
			//The iterative merge button text will be the colour blue
			imerge.setForeground(Color.BLUE);
			//The bubble button text will be the colour blue
			bubble.setForeground(Color.BLUE);
			//The insertion button text will be the colour blue
			insertion.setForeground(Color.BLUE);
			//The shell button text will be the colour blue
			shell.setForeground(Color.BLUE);
			//The quick button text will be the colour blue
			quick.setForeground(Color.BLUE);
			//The radix button text will be the colour blue
			radix.setForeground(Color.BLUE);
			//The scramble button's text will be blue
			scramble_button.setForeground(Color.BLUE);
			//setting the font of scramble button
			scramble_button.setFont(new Font("Arial", Font.BOLD, 15));
			//A Panel to hold the radio_button_selection and set the GridLayout
			JPanel radio_button_selection_Panel = new JPanel(new GridLayout(9, 1, 1, 1));

			//Adding the selection button to the radio_button_selection_Panel
			radio_button_selection_Panel.add(selection);
			//Adding the recursive merge button to the radio_button_selection_Panel
			radio_button_selection_Panel.add(rmerge);
			//Adding the iterative merge button to the radio_button_selection_Panel
			radio_button_selection_Panel.add(imerge);
			//Adding the bubble button to the radio_button_selection_Panel
			radio_button_selection_Panel.add(bubble);
			//Adding the insertion button to the radio_button_selection_Panel
			radio_button_selection_Panel.add(insertion);
			//Adding the shell button to the radio_button_selection_Panel
			radio_button_selection_Panel.add(shell);
			//Adding the quick button to the radio_button_selection_Panel
			radio_button_selection_Panel.add(quick);
			//Adding the radix button to the radio_button_selection_Panel
			radio_button_selection_Panel.add(radix);
			//Adding the reset button to the radio_button_selection_Panel
			radio_button_selection_Panel.add(reset);
			//giving the radio_button_selection_Panel a border with a title
			radio_button_selection_Panel.setBorder(new javax.swing.border.TitledBorder("Sort Algorithms"));

			//A Panel to hold the time_Panel and set the GridLayout
			JPanel time_Panel = new JPanel(new GridLayout(16, 1, 1, 1));
			//Adding the selection_time_label to the time_Panel
			time_Panel.add(selection_time_label);
			//Adding the selection_time_taken to the time_Panel
			time_Panel.add(selection_time_taken);
			//Adding the rmerge_time_label to the time_Panel
			time_Panel.add(rmerge_time_label);
			//Adding the rmerge_time_taken to the time_Panel
			time_Panel.add(rmerge_time_taken);
			//Adding the imerge_time_label to the time_Panel
			time_Panel.add(imerge_time_label);
			//Adding the imerge_time_taken to the time_Panel
			time_Panel.add(imerge_time_taken);
			//Adding the bubble_time_label to the time_Panel
			time_Panel.add(bubble_time_label);
			//Adding the bubble_time_taken to the time_Panel
			time_Panel.add(bubble_time_taken);
			//Adding the insertion_time_label to the time_Panel
			time_Panel.add(insertion_time_label);
			//Adding the insertion_time_taken to the time_Panel
			time_Panel.add(insertion_time_taken);
			//Adding the shell_time_label to the time_Panel
			time_Panel.add(shell_time_label);
			//Adding the shell_time_taken to the time_Panel
			time_Panel.add(shell_time_taken);
			//Adding the quick_time_label to the time_Panel
			time_Panel.add(quick_time_label);
			//Adding the quick_time_taken to the time_Panel
			time_Panel.add(quick_time_taken);
			//Adding the radix_time_label to the time_Panel
			time_Panel.add(radix_time_label);
			//Adding the radix_time_taken to the time_Panel
			time_Panel.add(radix_time_taken);

			//A Panel to hold the buttons_area_Panel and set the GridLayout
			//This buttons_area_Panel will hold scrambleButton, radio_button_selection and the time_Panel
			JPanel buttons_area_Panel = new JPanel(new GridLayout(3, 1, 2, 2));
			//adding scramble_button to the buttons_area_Panel
			buttons_area_Panel.add(scramble_button);
			//adding radio_button_selection_Panel to the buttons_area_Panel
			buttons_area_Panel.add(radio_button_selection_Panel);
			//adding time_Panel to the buttons_area_Panel
			buttons_area_Panel.add(time_Panel);

			//placing the buttons_area_Panel to the east side of the window
			add(buttons_area_Panel, BorderLayout.EAST);
			//placing the sortArea object in the center of the window
			add(sortArea, BorderLayout.CENTER);
			//setting all booleans to false
			Set_Available_Chooses(false, false, false, false, false, false, false, false, false);

			//The following code is for creating a listener for each GUI element

			//Creating an action listener for scramble button
			//This button will be used to scramble the lines in a random way
			//this same scrambled lines will be used for all threes sort methods used in this program
			scramble_button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// Scrambling the lines_lengths array
					sortArea.scramble_the_lines();
					//Since it has already been clicked, it will no longer be enabled
					scramble_button.setEnabled(false);
					//setting all booleans true except for reset
					Set_Available_Chooses(true, true, true, true, true, true, true, true, false);
				}
			});

			//Creating an action listener for selection button
			selection.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//Sorting the array in the selection sort method
					sortArea.SelectionSort();
					//Selection sort has finished/been clicked
					Selection_Done = true;
					//The amount of time taken for selection sort took
					selection_time_taken.setText(selectionTime / 1000 + " Seconds");
					//setting all booleans false except for reset
					Set_Available_Chooses(false, false, false, false, false, false, false, false, true);
				}
			});

			//Creating an action listener for recursive merge button
			rmerge.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//Sorting the array in the recursive merge sort method
					sortArea.R_MergeSort();
					//The amount of time taken for recursive merge sort took
					rmerge_time_taken.setText((rmergeTime / 1000) + " Seconds");
					//recursive merge sort has finished/been clicked
					Recersive_Merge_Done = true;
					//setting all booleans false except for reset
					Set_Available_Chooses(false, false, false, false, false, false, false, false, true);
				}
			});

			//Creating an action listener for iterative merge button
			imerge.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//Sorting the array in the iterative merge sort method
					sortArea.I_MergeSort();
					//The amount of time taken for iterative merge sort took
					imerge_time_taken.setText((imergeTime / 1000) + " Seconds");
					//iterative merge sort has finished/been clicked
					Iterative_Merge_Done = true;
					//setting all booleans false except for reset
					Set_Available_Chooses(false, false, false, false, false, false, false, false, true);
				}
			});

			//Creating an action listener for bubble button
			bubble.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//Sorting the array in the bubble sort method
					sortArea.BubbleSort();
					//The amount of time taken for bubble sort took
					bubble_time_taken.setText((bubbleTime / 1000) + " Seconds");
					//bubble sort has finished/been clicked
					Bubble_Done = true;
					//setting all booleans false except for reset
					Set_Available_Chooses(false, false, false, false, false, false, false, false, true);
				}
			});

			//Creating an action listener for insertion button
			insertion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//Sorting the array in the insertion sort method
					sortArea.InsertionSort();
					//The amount of time taken for insertion sort took
					insertion_time_taken.setText((insertionTime / 1000) + " Seconds");
					//insertion sort has finished/been clicked
					Insertion_Done = true;
					//setting all booleans false except for reset
					Set_Available_Chooses(false, false, false, false, false, false, false, false, true);
				}
			});

			//Creating an action listener for shell button
			shell.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//Sorting the array in the shell sort method
					sortArea.ShellSort();
					//The amount of time taken for shell sort took
					shell_time_taken.setText((shellTime / 1000) + " Seconds");
					//shell sort has finished/been clicked
					Shell_Done = true;
					//setting all booleans false except for reset
					Set_Available_Chooses(false, false, false, false, false, false, false, false, true);
				}
			});

			//Creating an action listener for quick button
			quick.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//Sorting the array in the quick sort method
					sortArea.QuickSort();
					//The amount of time taken for quick sort took
					quick_time_taken.setText((quickTime / 1000) + " Seconds");
					//quick sort has finished/been clicked
					Quick_Done = true;
					//setting all booleans false except for reset
					Set_Available_Chooses(false, false, false, false, false, false, false, false, true);
				}
			});

			//Creating an action listener for radix button
			radix.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//Sorting the array in the radix sort method
					sortArea.RadixSort();
					//The amount of time taken for radix sort took
					radix_time_taken.setText((radixTime / 1000) + " Seconds");
					//radix sort has finished/been clicked
					Radix_Done = true;
					//setting all booleans false except for reset
					Set_Available_Chooses(false, false, false, false, false, false, false, false, true);
				}
			});

			//Creating an action listener for reset button
			reset.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//disabling reset since it was clicked
					reset.setEnabled(false);
					//reseting the lines_lengths to its scrambled lines
					sortArea.reset();

					//Check if all algorithms are done
					if (Selection_Done && Recersive_Merge_Done && Iterative_Merge_Done && Bubble_Done && Insertion_Done && Shell_Done && Quick_Done && Radix_Done) {
						//All algorithms completed, enable scramble button and reset everything
						scramble_button.setEnabled(true);
						Selection_Done = false;
						Recersive_Merge_Done = false;
						Iterative_Merge_Done = false;
						Bubble_Done = false;
						Insertion_Done = false;
						Shell_Done = false;
						Quick_Done = false;
						Radix_Done = false;
						Set_Available_Chooses(false, false, false, false, false, false, false, false, false);
						selection_time_taken.setText("");
						rmerge_time_taken.setText("");
						imerge_time_taken.setText("");
						bubble_time_taken.setText("");
						insertion_time_taken.setText("");
						shell_time_taken.setText("");
						quick_time_taken.setText("");
						radix_time_taken.setText("");
					} else {
						//Enable buttons for algorithms that haven't been done yet
						Set_Available_Chooses(!Selection_Done, !Recersive_Merge_Done, !Iterative_Merge_Done, !Bubble_Done, !Insertion_Done, !Shell_Done, !Quick_Done, !Radix_Done, false);
					}
				}
			});

		}

		//A method that sets if the button are enabled or disabled
		public void Set_Available_Chooses(boolean selection_state, boolean rmerge_state, boolean imerge_state,
				boolean bubble_state, boolean insertion_state, boolean shell_state, boolean quick_state, boolean radix_state, boolean reset_state) {
			this.selection.setEnabled(selection_state);
			this.rmerge.setEnabled(rmerge_state);
			this.imerge.setEnabled(imerge_state);
			this.bubble.setEnabled(bubble_state);
			this.insertion.setEnabled(insertion_state);
			this.shell.setEnabled(shell_state);
			this.quick.setEnabled(quick_state);
			this.radix.setEnabled(radix_state);
			this.reset.setEnabled(reset_state);
		}
	}

	//The main method
	public static void main(String[] args) {
		//initialize the class
		SortGUI sort_GUI = new SortGUI();

	}

}


