/*
 * Members: Bipon Roy
 * Project Name: Substitution and Caesar Cipher
 * Project Description: App which generates a random key which can then be uses to encrypt/decrypt simple messages through either the substitution cipher or caesar cipher
 * Teacher: M. Lal
 * ICS4UI
 * Date: 18/11/19
 */



//Main Package
package cipherProject;

//JAVA Imports
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

//Java file "cipherWindow" class
public class cipherWindow {

	//PUBLIC VARIABLES
	public int shift;
	public List<String> newKeyList;
	public List<String> shiftKeyList;
	public char[] keyArray;
	public char[] shiftKeyArray;
	public char[] encryptArray1;
	public char[] decryptArray1;
	public char[] encryptArray2;
	public char[] decryptArray2;
	public String shiftKey; 
	public String output1;
	public String output2;
	public JLabel label_key;
	public JLabel label_subOutput;
	public JLabel label_caeOutput;
	public JFrame frame;
	public JTextField text_one;
	public JTextField text_two;
	public JTextField text_shift;

	//MAIN METHOD
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cipherWindow window = new cipherWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//CREATES APPLICATION WINDOW
	public cipherWindow() {
		initialize();
	}

	
	public void initialize() {
		
		//INITIALIZES FRAME
		frame = new JFrame();
		frame.setBounds(100, 100, 400, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//GENERATE KEY BUTTON
		JButton button_generateKey = new JButton("GENERATE KEY");
		button_generateKey.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				keyGen();
			}
		});
		button_generateKey.setBounds(141, 8, 117, 29);
		frame.getContentPane().add(button_generateKey);
		
		//LABEL FOR SUB. CIPHER
		JLabel label_subCipher = new JLabel("SUBSTITUTION CIPHER");
		label_subCipher.setHorizontalAlignment(SwingConstants.CENTER);
		label_subCipher.setBounds(118, 84, 164, 16);
		frame.getContentPane().add(label_subCipher);
		
		//LABEL FOR CAESAR CIPHER
		JLabel label_caeCipher = new JLabel("CAESAR CIPHER");
		label_caeCipher.setHorizontalAlignment(SwingConstants.CENTER);
		label_caeCipher.setBounds(141, 270, 117, 16);
		frame.getContentPane().add(label_caeCipher);
		
		//LABEL FOR KEY
		label_key = new JLabel("KEY:");
		label_key.setFont(new Font("Iowan Old Style", Font.PLAIN, 18));
		label_key.setHorizontalAlignment(SwingConstants.CENTER);
		label_key.setBounds(0, 39, 400, 16);
		frame.getContentPane().add(label_key);
		
		//TEXT FIELD FOR SUB CIPHER
		text_one = new JTextField();
		text_one.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				text_one.setText("");
			}
		});
		text_one.setHorizontalAlignment(SwingConstants.CENTER);
		text_one.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		text_one.setText("*ENTER WORD/MESSAGE HERE*");
		text_one.setBounds(58, 105, 283, 26);
		frame.getContentPane().add(text_one);
		text_one.setColumns(10);
		
		//ENCRYPT BUTTON FOR SUB CIPHER
		JButton button_subEncrypt = new JButton("ENCRYPT");
		button_subEncrypt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				encryptOne();
			}
		});
		button_subEncrypt.setBounds(141, 134, 117, 29);
		frame.getContentPane().add(button_subEncrypt);
		
		//DECRYPT BUTTON FOR SUB CIPHER
		JButton button_subDecrypt = new JButton("DECRYPT");
		button_subDecrypt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				decryptOne();
			}
		});
		button_subDecrypt.setBounds(141, 163, 117, 29);
		frame.getContentPane().add(button_subDecrypt);
		
		//LABEL FOR SUB CIPHER OUTPUT
		label_subOutput = new JLabel("Output Here:");
		label_subOutput.setFont(new Font("Iowan Old Style", Font.PLAIN, 16));
		label_subOutput.setHorizontalAlignment(SwingConstants.CENTER);
		label_subOutput.setBounds(0, 203, 400, 16);
		frame.getContentPane().add(label_subOutput);
		
		//TEXT FIELD FOR CAESAR CIPHER
		text_two = new JTextField();
		text_two.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				text_two.setText("");
			}
		});
		text_two.setHorizontalAlignment(SwingConstants.CENTER);
		text_two.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		text_two.setText("*ENTER WORD/MESSAGE HERE*");
		text_two.setBounds(58, 319, 283, 26);
		frame.getContentPane().add(text_two);
		text_two.setColumns(10);
		
		//ENCRYPT BUTTON FOR CAESAR CIPHER
		JButton button_caeEncrypt = new JButton("ENCRYPT");
		button_caeEncrypt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				encryptTwo();
			}
		});
		button_caeEncrypt.setBounds(141, 346, 117, 29);
		frame.getContentPane().add(button_caeEncrypt);
		
		//DECRYPT BUTTON FOR CAESAR CIPHER
		JButton button_caeDecrypt = new JButton("DECRYPT");
		button_caeDecrypt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				decryptTwo();
			}
		});
		button_caeDecrypt.setBounds(141, 373, 117, 29);
		frame.getContentPane().add(button_caeDecrypt);
		
		//LABEL FOR CAESAR CIPHER OUTPUT
		label_caeOutput = new JLabel("Output Here:");
		label_caeOutput.setFont(new Font("Iowan Old Style", Font.PLAIN, 16));
		label_caeOutput.setHorizontalAlignment(SwingConstants.CENTER);
		label_caeOutput.setBounds(0, 419, 400, 16);
		frame.getContentPane().add(label_caeOutput);
		
		//BREAK BETWEEN
		JLabel label_breakOne = new JLabel("_________________________________________________________");
		label_breakOne.setBounds(0, 55, 400, 16);
		frame.getContentPane().add(label_breakOne);
		
		//BREAK BETWEEN
		JLabel label_breakTwo = new JLabel("_________________________________________________________");
		label_breakTwo.setBounds(0, 231, 400, 16);
		frame.getContentPane().add(label_breakTwo);
		
		//SHIFT INPUT 
		text_shift = new JTextField();
		text_shift.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				text_shift.setText("");
			}
		});
		text_shift.setHorizontalAlignment(SwingConstants.CENTER);
		text_shift.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		text_shift.setText("*ENTER SHIFT NUM HERE*");
		text_shift.setBounds(58, 292, 186, 26);
		frame.getContentPane().add(text_shift);
		text_shift.setColumns(10);
		
		//BUTTON TO SET SHIFT
		JButton btnSetShift = new JButton("SET SHIFT");
		btnSetShift.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//RETRIEVES + STORES SHIFT
				shift = Integer.parseInt(text_shift.getText());
				
				//ROTATES LIST BY SHIFT VALUE
				Collections.rotate(newKeyList, shift);
			}
		});
		btnSetShift.setBounds(243, 292, 97, 26);
		frame.getContentPane().add(btnSetShift);
		
	}
	
		//KEY GENERATION METHOD
		public void keyGen() {
			
			//CREATES A STRING FOR EACH LETTER	
			String [] oldKey = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
			
			//CONVERTS TO LIST
			List<String> oldKeyList = Arrays.asList(oldKey);
			
			//SHUFFLES LIST
			Collections.shuffle(oldKeyList);
			
			//LIST HOLDING SHUFFLED LIST
			newKeyList = oldKeyList;
			
			//STRING FOR GENERATED KEY, REMOVED "[", "]","," CHARACTERS
			String newKey = newKeyList.toString() 
                    .substring(1, 3 * newKeyList.size() - 1) 
                    .replaceAll(", ", "");
			
			//STORE KEY (STRING) AS CHAR ARRAY
			keyArray = new char [26];
			
			for (int i = 0; i<26; i++) {
				keyArray[i] = newKey.charAt(i);
			}
			
			//SET LABEL AS GENERATED KEY
			label_key.setText(newKey);
			
		}
		
		
		//ENCRYPT ONE METHOD
		public void encryptOne() {
			
			//GET TEXT FROM INPUT, STORE AS UPPERCASE STRING
			String inputOne = text_one.getText();
			inputOne = inputOne.toUpperCase();
			
			
			//SPLIT INPUT INTO CHAR ARRAY
			char [] inputArray1 = new char[inputOne.length()];
			
			for (int a = 0; a<inputOne.length(); a++){
				inputArray1[a] = inputOne.charAt(a);
			}
			
			//ALPHABET ARRAY FOR REFERENCE
			char [] alphabetArray = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
			
			//NEW ARRAY FOR ENCRYPTED WORD
			encryptArray1 = new char [inputOne.length()];
			
			//BEGINS SETTINGS EACH INDEX AS ENCRYPTED CHAR
			for (int b = 0; b<inputArray1.length; b++) {
				for (int c = 0; c<26; c++) {
					if (inputArray1[b] == alphabetArray[c]) {
						encryptArray1[b] = keyArray[c];
					}
					else if(inputArray1[b] == ' ') {
						encryptArray1[b] = ' ';
					}
				}
			}
			
			//CONVERTING ENCRYPTED ARRAY TO STRING
			output1 = new String(encryptArray1);
			
			//SET LABEL AS OUTPUT
			label_subOutput.setText(output1);
		}
		
		//DECRYPT ONE METHOD
		public void decryptOne() {
			

			//GET TEXT FROM INPUT, STORE AS UPPERCASE STRING
			String inputOne = text_one.getText();
			inputOne = inputOne.toUpperCase();
			
			//SPLIT INPUT INTO CHAR ARRAY
			char [] inputArray1 = new char[inputOne.length()];
			
			for (int a = 0; a<inputOne.length(); a++){
				inputArray1[a] = inputOne.charAt(a);
			}
			
			//ALPHABET ARRAY FOR REFERENCE
			char [] alphabetArray = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
			
			//NEW ARRAY FOR ENCRYPTED WORD
			decryptArray1 = new char [inputOne.length()];
			
			//BEGINS SETTINGS EACH INDEX AS DECRYPTED CHAR
			for (int b = 0; b<inputArray1.length; b++) {
				for (int c = 0; c<26; c++) {
					if (inputArray1[b] == keyArray[c]) {
						decryptArray1[b] = alphabetArray[c];
					}
					else if(inputArray1[b] == ' ') {
						decryptArray1[b] = ' ';
					}
				}
			}
			
			//CONVERTING DECRYPTED ARRAY TO STRING
			output1 = new String(decryptArray1);
			
			//SET LABEL AS OUTPUT
			label_subOutput.setText(output1);
		}
		
		
		//ENCRYPT TWO METHOD
		public void encryptTwo() {
			
			//RETRIEVES DATA FROM TEXT FIELD
			String inputTwo = text_two.getText();
			inputTwo = inputTwo.toUpperCase();
			
			//ARRAY FOR INPUT
			char inputArray2 [] = new char [inputTwo.length()];
			
			for (int a = 0; a<inputTwo.length(); a++){
				inputArray2[a] = inputTwo.charAt(a);
			}
			
			//ALPHABET ARRAY FOR REFERENCE
			char [] alphabetArray = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
			
			 
				//LIST FOR SHIFTED KEY
				shiftKeyList = newKeyList;
				
				/*
				//ROTATION
				Collections.rotate(shiftKeyList, shift);
				*/
				
				//STRING FOR SHIFTED KEY
				shiftKey = shiftKeyList.toString() 
	                    .substring(1, 3 * shiftKeyList.size() - 1) 
	                    .replaceAll(", ", "");
				
				//ARRAY FOR SHIFTED KEY
				shiftKeyArray = new char [26];
				
				for (int d = 0; d < 26; d++) {
					shiftKeyArray[d] = shiftKey.charAt(d);
				}
			
			//NEW ARRAY FOR ENCRYPTED WORD
			encryptArray2 = new char [inputTwo.length()];
			
			//BEGINS SETTINGS EACH INDEX AS ENCRYPTED CHAR
			for (int b = 0; b<inputArray2.length; b++) {
				for (int c = 0; c<26; c++) {
					if (inputArray2[b] == alphabetArray[c]) {
						encryptArray2[b] = shiftKeyArray[c];
					}
					else if(inputArray2[b] == ' ') {
						encryptArray2[b] = ' ';
					}
				}
			}
			
			//CONVERTING ENCRYPTED ARRAY TO STRING
			output2 = new String(encryptArray2);
			
			//SET LABEL AS OUTPUT
			label_caeOutput.setText(output2);
		}
		
		//DECRYPT TWO METHOD
		public void decryptTwo() {
			
			//RETRIEVES DATA FROM TEXT FIELD
			String inputTwo = text_two.getText();
			inputTwo = inputTwo.toUpperCase();
			
			//RETRIEVES SHIFT NUM
			shift = Integer.parseInt(text_shift.getText());
			
			//ARRAY FOR INPUT
			char inputArray2 [] = new char [inputTwo.length()];
			
			for (int a = 0; a<inputTwo.length(); a++){
				inputArray2[a] = inputTwo.charAt(a);
			}
			
			//ALPHABET ARRAY FOR REFERENCE
			char [] alphabetArray = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
			
				//LIST FOR SHIFTED KEY
				shiftKeyList = newKeyList;
				
				//STRING FOR SHIFTED KEY
				shiftKey = shiftKeyList.toString() 
	                    .substring(1, 3 * shiftKeyList.size() - 1) 
	                    .replaceAll(", ", "");
				
				//ARRAY FOR SHIFTED KEY
				shiftKeyArray = new char [26];
				
				for (int d = 0; d < 26; d++) {
					shiftKeyArray[d] = shiftKey.charAt(d);
				}
			
			
			//NEW ARRAY FOR ENCRYPTED WORD
			decryptArray2 = new char [inputTwo.length()];
			
			//BEGINS SETTINGS EACH INDEX AS DECRYPTED CHAR
			for (int b = 0; b<inputArray2.length; b++) {
				for (int c = 0; c<26; c++) {
					if (inputArray2[b] == shiftKeyArray[c]) {
						decryptArray2[b] = alphabetArray[c];
					}
					else if(inputArray2[b] == ' ') {
						decryptArray2[b] = ' ';
					}
				}
			}

			//CONVERTING DECRYPTED ARRAY TO STRING
			output2 = new String(decryptArray2);
			
			//SET LABEL AS OUTPUT
			label_caeOutput.setText(output2);
		}
}