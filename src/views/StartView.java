package views;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import model.world.Champion;

import java.awt.*;

public class StartView extends JFrame implements ActionListener{
	private JLabel start = new JLabel();
	private JButton click = new JButton();
	private ArrayList<Champion> tmp = new ArrayList<>();
	
	public StartView(ArrayList<Champion> c) {
		tmp = c;

	   setTitle("Marvel");
	   setBounds(470,240, 1300,731);
	   
	   setLayout(new BorderLayout());
	   setDefaultCloseOperation(EXIT_ON_CLOSE);
	   setVisible(true);
	   this.setResizable(false);
	   this.add(start); //adding the label on the frame
	  
	   ImageIcon image = new ImageIcon("IMAGES/logo.png");
	   setIconImage(image.getImage()); //setting the logo of the app

	   
	   ImageIcon image2 = new ImageIcon("IMAGES/m2.png");
	   start.setIcon(image2);  //setting the start image
       start.setVerticalAlignment(JLabel.CENTER);
	   start.setHorizontalAlignment(JLabel.CENTER);
	   
	   click.setBounds(250,220,100,30); // set the size and the loc of the button
	   click.setText("PLAY"); //set the title of the button
	   click.setFont(new Font("AR BONNIE", Font.BOLD, 15));
	   click.setForeground(Color.blue); // set the color of the text
	   click.setBackground(Color.lightGray); //set the color of the background
	   click.setFocusable(false); // removing the focus on the button
	   start.add(click); //add the button on the frame
	   click.addActionListener(this);
	   
	  this.pack();

   }

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==click) {
			this.dispose();
			new SelectionOfChamp(tmp);
			JOptionPane.showMessageDialog(null,"FirstPlayer please choose 3 Champions !", "Friendly Notice ",JOptionPane.PLAIN_MESSAGE );
		
			
		}
		
	}
	
	

}


