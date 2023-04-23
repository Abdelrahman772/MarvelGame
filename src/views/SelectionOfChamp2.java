package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import model.world.Champion;

import java.awt.event.*;
import java.util.ArrayList;



public class SelectionOfChamp2 extends JFrame implements ActionListener, MouseListener{
	private JLabel start = new JLabel();
	private JPanel ch = new JPanel();
	private JPanel info = new JPanel();
	private ArrayList<Champion>SecondTeam = new ArrayList<>();
	private Champion SecondLeader;
	private String secondname;
	private String Firstname;
	private ArrayList<Champion>FirstTeam = new ArrayList<>();
	private Champion FirstLeader;
	private ArrayList <JButton> FirstSelection = new ArrayList<>();
	private ArrayList <JButton> FirstTeamButtons = new ArrayList<>();
	private ArrayList <JButton> SecondTeamButtons = new ArrayList<>();
	private JButton ready = new JButton("READY");
	
	private ArrayList<Champion> tmp = new ArrayList<>();
	  private JButton b1 ;
	  private JButton b2;
	  private  JButton b3;
	  private  JButton b4 ;
	  private  JButton b5;
	  private  JButton b6;
	  private  JButton b7;
	  private  JButton b8;
	  private  JButton b9;
	  private  JButton b10;
	  private  JButton b11;
	  private  JButton b12;
	  private  JButton b13;
	  private  JButton b14;
	  private  JButton b15;
	  private  JButton s1 = new JButton();
	  private  JButton s2 =  new JButton();
	  private  JButton s3 =  new JButton();
	  private  JButton pic;
	  private  JLabel chinfo;
	  boolean f1=false;
	  boolean f2=false;
	  boolean f3=false;
	  boolean f4=false;
	  boolean f5=false;
	  boolean f6=false;
	  boolean f7=false;
	  boolean f8=false;
	  boolean f9=false;
	  boolean f10=false;
	  boolean f11=false;
	  boolean f12=false;
	  boolean f13=false;
	  boolean f14=false;
	  boolean f15=false;
	  boolean flag=false;
     public ArrayList<Champion> getSecondTeam() {
		return SecondTeam;
	}

	public Champion getSecondLeader() {
		return SecondLeader;
	}

	public SelectionOfChamp2(ArrayList<Champion> c ,String firstname ,Champion FirstLea, ArrayList<Champion>FirstT , ArrayList<JButton>FirstB,ArrayList<JButton> FirstSelec) {
		 tmp = c;
		Firstname = firstname;
		FirstLeader = FirstLea;
		FirstTeam = FirstT;
		FirstTeamButtons = FirstB;
    	
		
		 
      setTitle("Marvel");
      setBounds(150,40, 1240,800);
   	  setDefaultCloseOperation(EXIT_ON_CLOSE);
   	   this.setResizable(false);
   	   this.setLayout(new BorderLayout());
   	   this.add(start, BorderLayout.CENTER); //adding the label on the frame
   	   setVisible(true);
   	   start.setLayout(new GridLayout(3,0,0,0));
   	   ch.setLayout(new GridLayout(1,3,0,0)); //selected champions
   	   ch.setPreferredSize(new Dimension(0,190));
   	   
   	   
   	   info.setLayout(new GridLayout(2,1,10,10));
	   info.setPreferredSize(new Dimension(250,200));
   	   
   	  ImageIcon image = new ImageIcon("IMAGES/logo.png");
	  setIconImage(image.getImage()); //setting the logo of the app
	  
	  
	  ImageIcon image2 = new ImageIcon("IMAGES/background.png");
	  start.setIcon(image2);  //setting the background image
	  
	  secondname = JOptionPane.showInputDialog("Enter the Second Player name " , "Player 2");
	  
	    pic=new JButton(); // gif of the selected champ
	   	chinfo= new JLabel(); // all the infos of the champion
	    info.add(pic);
	    info.add(chinfo);
	    chinfo.setFont(new Font("AR BONNIE", Font.BOLD, 16));

		  this.add(info, BorderLayout.WEST);
		  this.add(ch, BorderLayout.SOUTH);
	//  JOptionPane.showMessageDialog(null, "exception","error", JOptionPane.WARNING_MESSAGE);
	   b1 = new JButton(new ImageIcon("IMAGES/ca.png")); start.add(b1); b1.addMouseListener(this);
	   b2 = new JButton(new ImageIcon("IMAGES/deadpool.jpg"));start.add(b2);b2.addMouseListener(this);
	   b3 = new JButton(new ImageIcon("IMAGES/dr_strange.jpg"));start.add(b3);b3.addMouseListener(this);
	   b4 = new JButton(new ImageIcon("IMAGES/elec.jpg"));start.add(b4);b4.addMouseListener(this);
	   b5 = new JButton(new ImageIcon("IMAGES/ghost.jpg"));start.add(b5);b5.addMouseListener(this);
	   b6 =new JButton(new ImageIcon("IMAGES/hela.jpg"));start.add(b6);b6.addMouseListener(this);
	   b7 = new JButton(new ImageIcon("IMAGES/hulk.png"));start.add(b7);b7.addMouseListener(this);
	   b8 = new JButton(new ImageIcon("IMAGES/im.png"));start.add(b8);b8.addMouseListener(this);
	   b9 = new JButton(new ImageIcon("IMAGES/ironman.png"));start.add(b9);b9.addMouseListener(this);
	   b10 = new JButton(new ImageIcon("IMAGES/loki.jpg"));start.add(b10);b10.addMouseListener(this);
	   b11 = new JButton(new ImageIcon("IMAGES/quicksilver.jpeg"));start.add(b11);b11.addMouseListener(this);
	   b12 = new JButton(new ImageIcon("IMAGES/spider.jpg"));start.add(b12);b12.addMouseListener(this);
	   b13 = new JButton(new ImageIcon("IMAGES/thor.jpg"));start.add(b13);b13.addMouseListener(this);
	   b14 = new JButton(new ImageIcon("IMAGES/ven.jpeg"));start.add(b14);b14.addMouseListener(this);
	   b15 = new JButton(new ImageIcon("IMAGES/yj.jpg"));start.add(b15);b15.addMouseListener(this);
	   s1 = new JButton();ch.add(s1); s1.addMouseListener(this);
	   s2 = new JButton(); ch.add(s2); s2.addMouseListener(this);
	   s3 = new JButton();ch.add(s3); s3.addMouseListener(this);
	  
	  ready.setForeground(Color.white); // set the color of the text 
	  ready.setBackground(Color.green); //set the color of the background
	  ready.setFont(new Font("AR BONNIE", Font.BOLD, 40));
	  ready.setFocusable(false); // removing the focus on the button
	  ready.setEnabled(false);
	   ch.add(ready);
	   ready.addActionListener(this);
	   ready.addMouseListener(this);


//		  x.setForeground(Color.blue); // set the color of the text
//		   x.setBackground(Color.lightGray); //set the color of the background
//		   x.setFocusable(false); // removing the focus on the button
//		  start.add(x);
	  
	   this.revalidate();
		this.repaint();
		
     }

	public String getSecondname() {
		return secondname;
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==ready) {
			this.dispose();
			new Control(tmp , Firstname ,FirstLeader,FirstTeam,this.getSecondname(),SecondLeader,SecondTeam ,FirstTeamButtons ,SecondTeamButtons );
			
		}
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
//		buttons.add(b1);buttons.add(b2);buttons.add(b3);buttons.add(b4);buttons.add(b5);buttons.add(b6);buttons.add(b7);buttons.add(b8);buttons.add(b9);
//		buttons.add(b10);buttons.add(b11);buttons.add(b12);buttons.add(b13);buttons.add(b14);buttons.add(b15);
//			for(int k=0;k<15;k++) {
//				if(e.getSource()==buttons.get(k)){
//				if(s1.getIcon()== null) {
//					s1.setIcon(buttons.get(k).getIcon());
//					SecondTeam.add(tmp.get(k));
//					buttons.get(k).setEnabled(false);
//					buttons.remove(k);
//					
//					break;
//					
//				}
//				else if(s2.getIcon()==null) {
//					s2.setIcon(buttons.get(k).getIcon());
//					SecondTeam.add(tmp.get(k));
//					buttons.get(k).setEnabled(false);
//					buttons.remove(k);
//					break;
//				}
//				else if(s3.getIcon()== null) {
//					s3.setIcon(buttons.get(k).getIcon());
//					SecondTeam.add(tmp.get(k));
//					buttons.get(k).setEnabled(false);
//					buttons.remove(k);
//					break;
//			}
//			}
//			}

		if(s1.getIcon()==null) {
			if(e.getSource().equals(b1) && f1 !=true && !FirstTeam.contains(tmp.get(0))) {
				f1=true;
				s1.setIcon(b1.getIcon());
				SecondTeam.add(tmp.get(0));
				b1.setEnabled(false);
			}
			else if(e.getSource().equals(b2) && f2!=true&& !FirstTeam.contains(tmp.get(1))) {
				f2=true;
				s1.setIcon(b2.getIcon());
				SecondTeam.add(tmp.get(1));
				b2.setEnabled(false);
			}
			else if(e.getSource().equals(b3) && f3!=true && !FirstTeam.contains(tmp.get(2))) {
				f3=true;
				s1.setIcon(b3.getIcon());
				SecondTeam.add(tmp.get(2));
				b3.setEnabled(false);
			}
			else if(e.getSource().equals(b4) && f4!=true && !FirstTeam.contains(tmp.get(3))) {
				f4=true;
				s1.setIcon(b4.getIcon());
				SecondTeam.add(tmp.get(3));
				b4.setEnabled(false);
			}
			else if(e.getSource().equals(b5)&& f5!=true && !FirstTeam.contains(tmp.get(4))) {
				f5=true;
				s1.setIcon(b5.getIcon());
				SecondTeam.add(tmp.get(4));
				b5.setEnabled(false);
			}
			else if(e.getSource().equals(b6) &&f6!=true && !FirstTeam.contains(tmp.get(5))) {
				f6=true;
				s1.setIcon(b6.getIcon());
				SecondTeam.add(tmp.get(5));
				b6.setEnabled(false);
			}
			else if(e.getSource().equals(b7)&& f7!=true && !FirstTeam.contains(tmp.get(6))) {
				f7=true;
				s1.setIcon(b7.getIcon());
				SecondTeam.add(tmp.get(6));
				b7.setEnabled(false);
			}
			else if(e.getSource().equals(b8)&& f8!=true&& !FirstTeam.contains(tmp.get(7))) {
				f8=true;
				s1.setIcon(b8.getIcon());
				SecondTeam.add(tmp.get(7));
				b8.setEnabled(false);
			}
			else if(e.getSource().equals(b9)&& f9!=true&& !FirstTeam.contains(tmp.get(8))) {
				f9=true;
				s1.setIcon(b9.getIcon());
				SecondTeam.add(tmp.get(8));
				b9.setEnabled(false);
			}
			else if(e.getSource().equals(b10)&& f10!=true && !FirstTeam.contains(tmp.get(9))) {
				f10=true;
				s1.setIcon(b10.getIcon());
				SecondTeam.add(tmp.get(9));
				b10.setEnabled(false);
			}
			else if(e.getSource().equals(b11) && f11!=true && !FirstTeam.contains(tmp.get(10))) {
				f11=true;
				s1.setIcon(b11.getIcon());
				SecondTeam.add(tmp.get(10));
				b11.setEnabled(false);
			}
			else if(e.getSource().equals(b12)&& f12!=true && !FirstTeam.contains(tmp.get(11))) {
				f12=true;
				s1.setIcon(b12.getIcon());
				SecondTeam.add(tmp.get(11));
				b12.setEnabled(false);
			}
			else if(e.getSource().equals(b13)&& f13!=true&& !FirstTeam.contains(tmp.get(12))) {
				f13=true;
				s1.setIcon(b13.getIcon());
				SecondTeam.add(tmp.get(12));
				b13.setEnabled(false);
			}
			else if(e.getSource().equals(b14)&& f14!=true&& !FirstTeam.contains(tmp.get(13))) {
				f14=true;
				s1.setIcon(b14.getIcon());
				SecondTeam.add(tmp.get(13));
				b14.setEnabled(false);
			}
			else if(e.getSource().equals(b15)&& f15!=true && !FirstTeam.contains(tmp.get(14))) {
				f15=true;
				s1.setIcon(b15.getIcon());
				SecondTeam.add(tmp.get(14));
				b15.setEnabled(false);
			}
		}

	else {
		if(s2.getIcon()==null ) {
			if(e.getSource().equals(b1) && f1 !=true && !FirstTeam.contains(tmp.get(0))) {
				f1=true;
				s2.setIcon(b1.getIcon());
				SecondTeam.add(tmp.get(0));
				b1.setEnabled(false);
			}
			else if(e.getSource().equals(b2) && f2!=true&& !FirstTeam.contains(tmp.get(1))) {
				f2=true;
				s2.setIcon(b2.getIcon());
				SecondTeam.add(tmp.get(1));
				b2.setEnabled(false);
			}
			else if(e.getSource().equals(b3) && f3!=true && !FirstTeam.contains(tmp.get(2))) {
				f3=true;
				s2.setIcon(b3.getIcon());
				SecondTeam.add(tmp.get(2));
				b3.setEnabled(false);
			}
			else if(e.getSource().equals(b4) && f4!=true && !FirstTeam.contains(tmp.get(3))) {
				f4=true;
				s2.setIcon(b4.getIcon());
				SecondTeam.add(tmp.get(3));
				b4.setEnabled(false);
			}
			else if(e.getSource().equals(b5)&& f5!=true && !FirstTeam.contains(tmp.get(4))) {
				f5=true;
				s2.setIcon(b5.getIcon());
				SecondTeam.add(tmp.get(4));
				b5.setEnabled(false);
			}
			else if(e.getSource().equals(b6) &&f6!=true && !FirstTeam.contains(tmp.get(5))) {
				f6=true;
				s2.setIcon(b6.getIcon());
				SecondTeam.add(tmp.get(5));
				b6.setEnabled(false);
			}
			else if(e.getSource().equals(b7)&& f7!=true && !FirstTeam.contains(tmp.get(6))) {
				f7=true;
				s2.setIcon(b7.getIcon());
				SecondTeam.add(tmp.get(6));
				b7.setEnabled(false);
			}
			else if(e.getSource().equals(b8)&& f8!=true && !FirstTeam.contains(tmp.get(7))) {
				f8=true;
				s2.setIcon(b8.getIcon());
				SecondTeam.add(tmp.get(7));
				b8.setEnabled(false);
			}
			else if(e.getSource().equals(b9)&& f9!=true && !FirstTeam.contains(tmp.get(8))) {
				f9=true;
				s2.setIcon(b9.getIcon());
				SecondTeam.add(tmp.get(8));
				b9.setEnabled(false);
			}
			else if(e.getSource().equals(b10)&& f10!=true && !FirstTeam.contains(tmp.get(9))) {
				f10=true;
				s2.setIcon(b10.getIcon());
				SecondTeam.add(tmp.get(9));
				b10.setEnabled(false);
			}
			else if(e.getSource().equals(b11) && f11!=true && !FirstTeam.contains(tmp.get(10))) {
				f11=true;
				s2.setIcon(b11.getIcon());
				SecondTeam.add(tmp.get(10));
				b11.setEnabled(false);
			}
			else if(e.getSource().equals(b12)&& f12!=true && !FirstTeam.contains(tmp.get(11))) {
				f12=true;
				s2.setIcon(b12.getIcon());
				SecondTeam.add(tmp.get(11));
				b12.setEnabled(false);
			}
			else if(e.getSource().equals(b13)&& f13!=true && !FirstTeam.contains(tmp.get(12))) {
				f13=true;
				s2.setIcon(b13.getIcon());
				SecondTeam.add(tmp.get(12));
				b13.setEnabled(false);
			}
			else if(e.getSource().equals(b14)&& f14!=true && !FirstTeam.contains(tmp.get(13))) {
				f14=true;
				s2.setIcon(b14.getIcon());
				SecondTeam.add(tmp.get(13));
				b14.setEnabled(false);
			}
			else if(e.getSource().equals(b15)&& f15!=true && !FirstTeam.contains(tmp.get(14))) {
				f15=true;
				s2.setIcon(b15.getIcon());
				SecondTeam.add(tmp.get(14));
				b15.setEnabled(false);
			}	
		}
		else {
			if(s3.getIcon()==null){
				if(e.getSource().equals(b1) && f1 !=true && !FirstTeam.contains(tmp.get(0))) {
					f1=true;
					s3.setIcon(b1.getIcon());
					SecondTeam.add(tmp.get(0));
					b1.setEnabled(false);
				}
				else if(e.getSource().equals(b2) && f2!=true && !FirstTeam.contains(tmp.get(1))) {
					f2=true;
					s3.setIcon(b2.getIcon());
					SecondTeam.add(tmp.get(1));
					b2.setEnabled(false);
				}
				else if(e.getSource().equals(b3) && f3!=true && !FirstTeam.contains(tmp.get(2))) {
					f3=true;
					s3.setIcon(b3.getIcon());
					SecondTeam.add(tmp.get(2));
					b3.setEnabled(false);
				}
				else if(e.getSource().equals(b4) && f4!=true && !FirstTeam.contains(tmp.get(3))) {
					f4=true;
					s3.setIcon(b4.getIcon());
					SecondTeam.add(tmp.get(3));
					b4.setEnabled(false);
				}
				else if(e.getSource().equals(b5)&& f5!=true && !FirstTeam.contains(tmp.get(4))) {
					f5=true;
					s3.setIcon(b5.getIcon());
					SecondTeam.add(tmp.get(4));
					b5.setEnabled(false);
				}
				else if(e.getSource().equals(b6) &&f6!=true && !FirstTeam.contains(tmp.get(5))) {
					f6=true;
					s3.setIcon(b6.getIcon());
					SecondTeam.add(tmp.get(5));
					b6.setEnabled(false);
				}
				else if(e.getSource().equals(b7)&& f7!=true && !FirstTeam.contains(tmp.get(6))) {
					f7=true;
					s3.setIcon(b7.getIcon());
					SecondTeam.add(tmp.get(6));
					b7.setEnabled(false);
				}
				else if(e.getSource().equals(b8)&& f8!=true && !FirstTeam.contains(tmp.get(7))) {
					f8=true;
					s3.setIcon(b8.getIcon());
					SecondTeam.add(tmp.get(7));
					b8.setEnabled(false);
				}
				else if(e.getSource().equals(b9)&& f9!=true && !FirstTeam.contains(tmp.get(8))) {
					f9=true;
					s3.setIcon(b9.getIcon());
					SecondTeam.add(tmp.get(8));
					b9.setEnabled(false);
				}
				else if(e.getSource().equals(b10)&& f10!=true && !FirstTeam.contains(tmp.get(9))) {
					f10=true;
					s3.setIcon(b10.getIcon());
					SecondTeam.add(tmp.get(9));
					b10.setEnabled(false);
				}
				else if(e.getSource().equals(b11) && f11!=true && !FirstTeam.contains(tmp.get(10))) {
					f11=true;
					s3.setIcon(b11.getIcon());
					SecondTeam.add(tmp.get(10));
					b11.setEnabled(false);
				}
				else if(e.getSource().equals(b12)&& f12!=true && !FirstTeam.contains(tmp.get(11))) {
					f12=true;
					s3.setIcon(b12.getIcon());
					SecondTeam.add(tmp.get(11));
					b12.setEnabled(false);
				}
				else if(e.getSource().equals(b13)&& f13!=true && !FirstTeam.contains(tmp.get(12))) {
					f13=true;
					s3.setIcon(b13.getIcon());
					SecondTeam.add(tmp.get(12));
					b13.setEnabled(false);
				}
				else if(e.getSource().equals(b14)&& f14!=true && !FirstTeam.contains(tmp.get(13))) {
					f14=true;
					s3.setIcon(b14.getIcon());
					SecondTeam.add(tmp.get(13));
					b14.setEnabled(false);
				}
				else if(e.getSource().equals(b15)&& f15!=true && !FirstTeam.contains(tmp.get(14))) {
					f15=true;
					s3.setIcon(b15.getIcon());
					SecondTeam.add(tmp.get(14));
					b15.setEnabled(false);
				}	
			}
		}
	}
			
			
			boolean f = false;
			if(f==false && s3.getIcon()!=null) {
				if(e.getSource().equals(s1) && flag==false) {
					flag=true;
					ready.setEnabled(true);
					s1.setBorder(new LineBorder(Color.RED,7));
					SecondLeader = SecondTeam.get(0);
					f = true;
					
				}
				if(e.getSource().equals(s2)&& flag==false) {
					flag=true;
					ready.setEnabled(true);
					s2.setBorder(new LineBorder(Color.RED,7));
					SecondLeader = SecondTeam.get(1);
					f = true;
				}
				if(e.getSource().equals(s3)&& flag==false) {
					flag=true;
					ready.setEnabled(true);
					s3.setBorder(new LineBorder(Color.RED,7));
					SecondLeader = SecondTeam.get(2);
					f = true;
				}
				}
			SecondTeamButtons.add(s1);
			SecondTeamButtons.add(s2);
			SecondTeamButtons.add(s3);
			if(f==false && s3.getIcon()!=null && e.getSource()!=s1 && e.getSource()!=s2 && e.getSource()!=s3) 
				JOptionPane.showMessageDialog(null,"Please Choose a leader from your team ! ", "Friendly Notice ",JOptionPane.PLAIN_MESSAGE );
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource().equals(b1)) {
			pic.setIcon(new ImageIcon("IMAGES/ca_gif.gif"));
			chinfo.setText("<html> Type: Hero   <br>  Name : Captain America  <br> Max HP : 1500 <br> Mana cost :1000 <br> Actions: 6 <br> Speed : 80 <br> Attack range : 1 <br> attack damage: 100 <br>  Ability 1: Shield Throw <br> Ability 2: I can do this all day <br> Ability 3 : Shield Up  <html>");
	}
		else if(e.getSource().equals(b2) ) {
			pic.setIcon(new ImageIcon("IMAGES/dp.gif"));
			chinfo.setText("<html> Type: AntiHero  <br>  Name : Deadpool  <br> Max HP : 1350 <br> Mana cost :700 <br> Actions : 6 <br> Speed : 80 <br> Attack range: 3 <br> attack damage: 90 <br>  Ability 1: Try Harder <br> Ability 2: 8 bullets left <br> Ability 3 : Can't catch me  <html>");
		}
		else if(e.getSource().equals(b3)) {
			pic.setIcon(new ImageIcon("IMAGES/strange.gif"));
			chinfo.setText("<html> Type: Hero   <br>  Name : Dr Strange  <br> Max HP : 1100 <br> Mana cost :1500 <br> Actions : 6 <br> Speed : 60<br> Attack range: 2 <br> attack damage: 60 <br>  Ability 1: The eye of Agamotto <br> Ability 2: Thousands Hand <br> Ability 3 : Mirror dimension  <html>");
		}
		else if(e.getSource().equals(b4) ) {
			pic.setIcon(new ImageIcon("IMAGES/electro.gif"));
			chinfo.setText("<html> Type: Villain   <br>  Name : Electro  <br> Max HP: 1200 <br> Mana cost :1200 <br> Actions: 5 <br> Speed:75 <br> Attack range:3 <br> attack damage:110 <br>  Ability 1:Fully Charged <br> Ability 2:EMP  <br> Ability 3 :Lightning Strike   <html>");
		}
		else if(e.getSource().equals(b5)) {
			pic.setIcon(new ImageIcon("IMAGES/gr.gif"));
			chinfo.setText("<html> Type: Anti hero   <br>  Name : Ghost rider  <br> Max HP:1800 <br> Mana cost :600 <br> Actions:6 <br> Speed :85 <br> Attack range:1 <br> attack damage:140 <br>  Ability 1:Death stare <br> Ability 2:Fire breathe  <br> Ability 3 :Chain whip   <html>");
		}
		else if(e.getSource().equals(b6) ) {
			pic.setIcon(new ImageIcon("IMAGES/hel.gif"));
			chinfo.setText("<html> Type: Villain   <br>  Name : Hela  <br> Max HP:1500 <br> Mana cost :750 <br> Actions:5 <br> Speed :75 <br> Attack range:1 <br> attack damage:150 <br>  Ability 1: Godess of death <br> Ability 2:thorn shield  <br> Ability 3 :thorn shower   <html>");
		}
		else if(e.getSource().equals(b7)) {
			pic.setIcon(new ImageIcon("IMAGES/hu.gif"));
			chinfo.setText("<html> Type: Hero   <br>  Name : Hulk  <br> Max HP: 2250 <br> Mana cost :550 <br> Actions: 5 <br> Speed :55 <br> Attack range: 1 <br> attack damage: 200 <br>  Ability 1:Rage <br> Ability 2:Hulk smash  <br> Ability 3 :Sun is getting real low   <html>");
		}
		else if(e.getSource().equals(b8)) {
			pic.setIcon(new ImageIcon("IMAGES/ice.gif"));
			chinfo.setText("<html> Type: Hero   <br>  Name : Ice man  <br> Max HP:1000 <br> Mana cost :900 <br> Actions: 5 <br> Speed :65 <br> Attack range:2 <br> attack damage:120 <br>  Ability 1:Frost bite <br> Ability 2: SubZero  <br> Ability 3 : Hail Storm   <html>");
		}
		else if(e.getSource().equals(b9)) {
			pic.setIcon(new ImageIcon("IMAGES/iron.gif"));
			chinfo.setText("<html> Type: Hero   <br>  Name : Iron man  <br> Max HP:1200 <br> Mana cost :800 <br> Actions:7 <br> Speed :85 <br> Attack range:3 <br> attack damage:90 <br>  Ability 1:I am Iron man <br> Ability 2: UniBeam  <br> Ability 3 : 3000   <html>");
		}
		else if(e.getSource().equals(b10)) {
			pic.setIcon(new ImageIcon("IMAGES/loki.gif"));
			chinfo.setText("<html> Type: Villain   <br>  Name : Loki  <br> Max HP:1150 <br> Mana cost :900 <br> Actions: 5 <br> Speed: 70 <br> Attack range: 1 <br> attack damage: 150 <br>  Ability 1:God of Mischief <br> Ability 2:The Hidden Dagger  <br> Ability 3 : Fake Death  <html>");
		}
		else if(e.getSource().equals(b11)) {
			pic.setIcon(new ImageIcon("IMAGES/qs.gif"));
			chinfo.setText("<html> Type: Villain   <br>  Name : QuickSilver  <br> Max HP: 1200 <br> Mana cost: 650 <br> Actions: 8 <br> Speed: 99 <br> Attack range: 1 <br> attack damage: 70 <br>  Ability 1: Time In A Bottle <br> Ability 2: Good As New  <br> Ability 3 : 1 Second 100 Punch   <html>");
		}
		else if(e.getSource().equals(b12)) {
			pic.setIcon(new ImageIcon("IMAGES/spidey.gif"));
			chinfo.setText("<html> Type: Hero   <br>  Name : Spiderman  <br> Max HP: 1400 <br> Mana cost: 750 <br> Actions: 7 <br> Speed: 85 <br> Attack range: 1 <br> attack damage: 120 <br>  Ability 1: Give Me That <br> Ability 2: Web Trap  <br> Ability 3: Spider-Verse    <html>");
		}
		else if(e.getSource().equals(b13)) {
			pic.setIcon(new ImageIcon("IMAGES/thor.gif"));
			chinfo.setText("<html> Type: Hero   <br>  Name : Thor  <br> Max HP: 1800 <br> Mana cost: 800 <br> Actions: 7 <br> Speed: 90 <br> Attack range: 1 <br> attack damage: 130 <br>  Ability 1: God Of Thunder <br> Ability 2: Mjollnir Throw  <br> Ability 3: Bring Me Thanos <html>");
		}
		else if(e.getSource().equals(b14)) {
			pic.setIcon(new ImageIcon("IMAGES/venom_gif.gif"));
			chinfo.setText("<html> Type: AntiHero   <br>  Name : Venom  <br> Max HP: 1650 <br> Mana cost: 700 <br> Actions: 5 <br> Speed: 70 <br> Attack range: 1 <br> attack damage: 140 <br>  Ability 1: Head Bite <br> Ability 2: We Are Venom  <br> Ability 3 : Symbiosis   <html>");
		}
		else if(e.getSource().equals(b15)) {
			pic.setIcon(new ImageIcon("IMAGES/yej.gif"));
			chinfo.setText("<html> Type: Villain   <br>  Name : Yellow Jacket  <br> Max HP: 1050 <br> Mana cost: 800 <br> Actions: 6 <br> Speed: 60 <br> Attack range: 2 <br> attack damage: 80 <br>  Ability 1: Laser Sting <br> Ability 2: QuANTaMANia  <br> Ability 3 :Pym Particle Upsize   <html>");
		}
}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}