import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import javax.xml.bind.Marshaller.Listener;
import javax.swing.JSlider;


public class View extends JFrame implements ActionListener {
	static String [] ar;
	private JPanel contentPane;
	
	 JTextArea textField = new JTextArea();
		JButton btnConvert = new JButton("Convert");
		JButton btnNextCycle = new JButton("Next Cycle");

		JTextArea lblNewLabel;
	JLabel lblEnterYourMips;
	JTextArea label;
	private JSlider slider;
	private JSlider slider_1;
	private JTextArea txtrAndss;
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		ar=args;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View frame = new View();
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
	public View() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 50, 900, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField.setBounds(27, 47, 206, 147);
		contentPane.add(textField);
		textField.setColumns(10);
		
		 lblNewLabel = new JTextArea("");
		 lblNewLabel.setEditable(false);
		lblNewLabel.setBounds(341, 26, 504, 416);
		contentPane.add(lblNewLabel);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(828, 26, 17, 416);
		contentPane.add(scrollBar);
		
		btnNextCycle.setBounds(173, 587, 141, 23);
		contentPane.add(btnNextCycle);
		btnNextCycle.addActionListener((ActionListener)this);

		 lblEnterYourMips = new JLabel("Enter One by One instruc in small letters format is limited like this  add $s0, $t7, $s1 any unExpected spaces will lead to an error");
		lblEnterYourMips.setBounds(27, 11, 805, 14);
		contentPane.add(lblEnterYourMips);
		
		JLabel lblCorrespondingBinaryInst = new JLabel("Corresponding binary inst for the correct syntax only ");
		lblCorrespondingBinaryInst.setBounds(20, 205, 294, 14);
		contentPane.add(lblCorrespondingBinaryInst);
		
		 label = new JTextArea("");
		 label.setEditable(false);
		label.setBounds(27, 242, 287, 334);
		contentPane.add(label);
		
		btnConvert.setBounds(27, 587, 121, 23);
		contentPane.add(btnConvert);
		
		slider = new JSlider();
		slider.setBounds(37, 550, 277, 26);
		contentPane.add(slider);
		
		slider_1 = new JSlider();
		slider_1.setBounds(424, 416, 394, 26);
		contentPane.add(slider_1);
		
		txtrAndss = new JTextArea();
		txtrAndss.setText("Sample inputs : \r\n\r\nand $s4, $s2, $t8\r\nadd $s4, $s2, $t8\r\nsub $s4, $s2, $t7\r\n\r\nfor more Manual testing use class Main and delete the comments and\r\n comment the remaing parts instead");
		txtrAndss.setBounds(341, 479, 504, 156);
		contentPane.add(txtrAndss);
		btnConvert.addActionListener((ActionListener) this);

	}
    public void actionPerformed(ActionEvent e) {
        if ((JButton)e.getSource()==btnConvert){
        	label.setText(label.getText()+"\n"+check(textField.getText()));
        	
        }
        else  if ((JButton)e.getSource()==btnNextCycle){
        	
        	Main.IM = Main.Inputs.toArray(new String[Main.Inputs.size()]);
        	//Main.IM=  (String[]) Main.Inputs.toArray();
        	Main.main(ar);
        	lblNewLabel.setText(Main.res);
        }
}
	
	public static String check (String inst){
		String r = "";
		if(inst.equals(inst.toLowerCase())){
			
		Converter.split_input_function(inst);
			
		}else {
		r="invalid input";
		}
		if (Converter.r.equals("invalid input")|| Converter.r.length()<15)
			return "";
		else {r= Converter.r.replaceAll("\\s+","");
			Main.Inputs.add(r); 
			return r ; 
		
		}
		
	}
}
