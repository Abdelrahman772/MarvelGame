package views;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.tools.Tool;
import javax.swing.colorchooser.*;
import engine.Game;
import engine.Player;
import engine.PriorityQueue;
import exceptions.AbilityUseException;
import exceptions.ChampionDisarmedException;
import exceptions.InvalidTargetException;
import exceptions.LeaderAbilityAlreadyUsedException;
import exceptions.LeaderNotCurrentException;
import exceptions.NotEnoughResourcesException;
import exceptions.UnallowedMovementException;

import java.awt.event.*;

import model.abilities.Ability;
import model.abilities.AreaOfEffect;
import model.abilities.CrowdControlAbility;
import model.abilities.DamagingAbility;
import model.abilities.HealingAbility;
import model.world.AntiHero;
import model.world.Champion;
import model.world.Cover;
import model.world.Direction;
import model.world.Hero;
import model.world.Villain;

public class Control extends JFrame implements ActionListener , MouseListener{
	private JLabel board1 = new JLabel();
	private ArrayList<Champion> champs =  Game.getAvailableChampions();
	private String firstname;
	private String secondname;
	private Champion firstleader;
	private Champion secondleader;
	private ArrayList<Champion>firstTeam;
	private ArrayList<Champion>secondTeam;
	private ArrayList <JButton> FirstTeamButtons = new ArrayList<>();
	private ArrayList <JButton> SecondTeamButtons = new ArrayList<>();
	
	private JLabel[][] cells; //3ashan nemshi fel board4
	private Object[][] Thisgame;
	private JLabel north=new JLabel();
	private JLabel northc=new JLabel();
	private JLabel northr=new JLabel();
	private JLabel northl=new JLabel();
	private JLabel northcup=new JLabel();
	private JLabel northcdown=new JLabel();
	private JLabel northcdownl=new JLabel();
	private JLabel northcdownc=new JLabel();
	private JLabel northcdownr=new JLabel();
	private JLabel northr1 =new JLabel();
	private JLabel northr2 =new JLabel();
	private JLabel EffectInfo =new JLabel();
	private JLabel CoverHp =new JLabel();
	private JLabel AbilityInfo =new JLabel();
	private JLabel south=new JLabel();
	private JLabel southc=new JLabel();
	private JPanel southr=new JPanel();
	private JPanel southl=new JPanel();
	private JLabel southcup=new JLabel();
	private JLabel southcdown=new JLabel();
	private JLabel southcdownl=new JLabel();
	private JLabel southcdownc=new JLabel();
	private JLabel southcdownr=new JLabel();
	private JLabel southrdown=new JLabel();
	private JLabel southldown=new JLabel();
	private JLabel southlup=new JLabel();
	private JLabel east=new JLabel();
	private JLabel west=new JLabel();
	
	
	Player firstPlayer = new Player(this.getFirstname());
	Player secondPlayer = new Player(this.getSecondname());
	
	private Game game;
	private JButton move = new JButton("Move");private boolean moveClicked;
	private JButton up = new JButton("up"); 
	private JButton down =new JButton("down");
	private JButton left= new JButton("left");
	private JButton right =  new JButton("right");
	private Ability ability;
	private JButton n1 =  new JButton();
	private JButton n2 =  new JButton();
	private JButton n3 =  new JButton();
	
	private JButton attack = new JButton("Attack");private boolean attackClicked;
	private JButton ability1=new JButton();private boolean singleTarget;
	private JButton ability2=new JButton();private boolean directional;
	private JButton ability3=new JButton();private boolean teamTarget;
	private JButton endTurn=new JButton("End Turn");
	private JButton LeaderAbility1=new JButton("LeaderAbility player 1");
	private JButton LeaderAbility2=new JButton("LeaderAbility player 2");
	
	private PriorityQueue Turn;
	private ArrayList<Champion>next = new ArrayList<>();
	private  String txt ="";
	private ArrayList<ImageIcon>ChampsIcons = new ArrayList<>();  //size 200x97
	private ArrayList<ImageIcon>champsIcon = new ArrayList<>();  ///size 200x200
	private ArrayList<ImageIcon>Icon150x170 = new ArrayList<>();  ///size 150x170
	private String isLeader;

	public String getFirstname() {
		return firstname;
	}

	public String getSecondname() {
		return secondname;
	}

	public Champion getFirstleader() {
		return firstleader;
	}

	public Champion getSecondleader() {
		return secondleader;
	}

	public ArrayList<Champion> getFirstTeam() {
		return firstTeam;
	}

	public ArrayList<Champion> getSecondTeam() {
		return secondTeam;
	}

	public Game getGame() {
		return game;
	}

  public Control(ArrayList<Champion>c, String first, Champion FirstL, ArrayList<Champion>FirstT, 
		   String second, Champion SecondL, ArrayList<Champion>SecondT , ArrayList <JButton> FirstB, ArrayList <JButton> SecondB) {
	  //  champs =c;
	    firstname = first;
	    firstleader = FirstL;
	    firstTeam = FirstT;
	    secondname = second;
	    secondleader = SecondL;
	    secondTeam = SecondT;
	    FirstTeamButtons = FirstB;
	    SecondTeamButtons = SecondB; 
	   
	      for(int i=0;i<firstTeam.size();i++) {
	 		   firstPlayer.getTeam().add(firstTeam.get(i));  // adding the first Player team
	 	   }
	 	  for(int i=0;i<secondTeam.size();i++) {
	 		   secondPlayer.getTeam().add(secondTeam.get(i));  // adding the second Player team
	 	   }
	 	  
	 	  firstPlayer.setLeader(firstleader); // the leader of first
	 	  secondPlayer.setLeader(secondleader); // the leader of second
	 	  
	       game = new Game(firstPlayer,secondPlayer); //creating a game with 2 players 
	      
	       Thisgame= game.getBoard();
	       Turn = game.getTurnOrder();
	       
	       setTitle("Marvel");
	       setBounds(125,30, 1350,800);
	 	   setDefaultCloseOperation(EXIT_ON_CLOSE);
	 	   this.setResizable(false);
	 	   this.setLayout(new BorderLayout());
	 	   this.add(board1, BorderLayout.CENTER); //adding the label on the frame
	 	   ImageIcon image = new ImageIcon("IMAGES/logo.png");
		   setIconImage(image.getImage()); //setting the logo of the app
		   board1.setLayout(new GridLayout(5,5));
	 	   
	 	   
	 	                                 ///// Creating the design of the game ////////
		   endTurn.setFocusable(false);
		   move.setFocusable(false);
		   attack.setFocusable(false);
		   up.setFocusable(false);
		   left.setFocusable(false);
		   right.setFocusable(false);
		   down.setFocusable(false);
		   ability1.setFocusable(false);
		   ability2.setFocusable(false);
		   ability3.setFocusable(false);
		   LeaderAbility1.setFocusable(false);
		   LeaderAbility2.setFocusable(false);
		   move.addMouseListener(this);
		   attack.addMouseListener(this);	   
		   up.addMouseListener(this);
		   down.addMouseListener(this);
		   left.addMouseListener(this);
		   right.addMouseListener(this);
		   LeaderAbility1.addMouseListener(this);
		   LeaderAbility2.addMouseListener(this);
		   endTurn.addMouseListener(this);
		   ability1.addMouseListener(this);
		   ability2.addMouseListener(this);
		   ability3.addMouseListener(this);
		   
		   
	 	  //north
	 	  add(north,BorderLayout.NORTH);
	 	  north.setPreferredSize(new Dimension(0,180));
	 	  north.setLayout(new GridLayout(1,3));
	 	  north.add(northl ,BorderLayout.WEST);
	 	  north.add(northc , BorderLayout.CENTER);
	 	  north.add(northr , BorderLayout.EAST);
	 	  
	 	//northLeft
	 	  northl.setBorder(new LineBorder(Color.yellow)); 
//	 	  northl.setLayout(new GridLayout(1,6));

	 	  //north center
	 	  northc.setBorder(new LineBorder(Color.blue));
	 	  northc.setLayout(new GridLayout(2,1));
	 	  northc.setPreferredSize(new Dimension(0,180));
//	 	  northc.add(northcup ,BorderLayout.NORTH); 
//	 	  northc.add(northcdown ,BorderLayout.CENTER);
	 	  northc.setLayout(new BorderLayout());
	 	  northc.add(northcup,BorderLayout.NORTH);
	 	  northc.add(northcdown,BorderLayout.CENTER);
	 	  
	 	  //north center up
	 	 northcup.setBorder(new LineBorder(Color.CYAN));
	 	 northcup.setPreferredSize(new Dimension(0,40));
	 	 northcup.setBackground(Color.yellow);
	 	
	 	 
	 	 //north center down
	 	 northcdown.setBorder(new LineBorder(Color.magenta));
	 	 northcdown.setLayout(new GridLayout(1,3));
	 	 northcdown.setPreferredSize(new Dimension(0,180));
	 	 northcdown.add(northcdownl);
	 	 northcdown.add(northcdownc);
	 	 northcdown.add(northcdownr);
	 	 northcdownl.setPreferredSize(new Dimension(30,110));
	 	 northcdownc.setPreferredSize(new Dimension(30,110));
	 	 northcdownr.setPreferredSize(new Dimension(30,110));
		 northcdownl.setBorder(new LineBorder(Color.blue));
		 northcdownr.setBorder(new LineBorder(Color.blue));
		 northcdownc.setBorder(new LineBorder(Color.red));
		 northcdown.setBackground(Color.blue);
		 northcdownl.addMouseListener(this);
		 northcdownc.addMouseListener(this);
		 northcdownr.addMouseListener(this);
		 
	 	 //north right
	 	 northr.setBorder(new LineBorder(Color.RED));
	 	 northr.setLayout(new GridLayout(1,2));
	 	 northr.setPreferredSize(new Dimension(0,180));
	 	 northr.add(northr1);
	 	 northr.add(northr2);
	 	 northr.setBackground(Color.lightGray);
	 	 northr1.setBorder(new LineBorder(Color.blue));northr1.addMouseListener(this);
	   	 northr2.setBorder(new LineBorder(Color.blue));northr2.addMouseListener(this);
	 	 northr1.setPreferredSize(new Dimension(0,180));
	 	 northr2.setPreferredSize(new Dimension(0,180));
	 	 northr1.setText("   "	+ "     Playing now :");
	 	 northr1.setFont(new Font("AR BONNIE", Font.BOLD, 18));
	 	 
	 	 
	 	 //south
	 	  add(south,BorderLayout.SOUTH);
	 	  south.setPreferredSize(new Dimension(0,180));
	 	  south.setLayout(new GridLayout(1,3));
	 	  south.add(southl ,BorderLayout.WEST);
	 	  south.add(southc , BorderLayout.CENTER);
	 	  south.add(southr , BorderLayout.EAST);
	 	  
	 	 
	 	  //south center
	 	  southc.setBorder(new LineBorder(Color.blue));
	 	  southc.setLayout(new GridLayout(2,1));
	 	  southc.setPreferredSize(new Dimension(0,180));
	 	  southc.add(southcup ,BorderLayout.SOUTH); 
	 	  southc.add(southcdown ,BorderLayout.CENTER);
	 	  southc.setLayout(new BorderLayout());
	 	  southc.add(southcup,BorderLayout.SOUTH);
	 	  southc.add(southcdown,BorderLayout.CENTER);
	 	  
	 	  //south center up
	 	 southcup.setBorder(new LineBorder(Color.CYAN));
	 	 southcup.setPreferredSize(new Dimension(0,40));
	 	 southcup.setBackground(Color.yellow);
	 	 
	 	 //south center down
	 	 southcdown.setBorder(new LineBorder(Color.magenta));
	 	 southcdown.setLayout(new GridLayout(1,3));
	 	 southcdown.setPreferredSize(new Dimension(0,180));
	 	 southcdown.add( southcdownl);
	 	 southcdown.add( southcdownc);
	 	 southcdown.add( southcdownr);
	 	 southcdownl.setPreferredSize(new Dimension(30,110));
	 	 southcdownc.setPreferredSize(new Dimension(30,110));
	 	 southcdownr.setPreferredSize(new Dimension(30,110));
		 southcdownl.setBorder(new LineBorder(Color.blue));
		 southcdownr.setBorder(new LineBorder(Color.blue));
		 southcdownc.setBorder(new LineBorder(Color.red));
		 southcdown.setBackground(Color.blue);
		 southcdownl.addMouseListener(this);
		 southcdownc.addMouseListener(this);
		 southcdownr.addMouseListener(this);
	 	 //south right
	 	 southr.setBorder(new LineBorder(Color.RED));
	 	 southr.setLayout(new BorderLayout());
	 	 southr.add(endTurn,BorderLayout.NORTH);
	     southr.add(southrdown,BorderLayout.CENTER);
	 	 southr.setPreferredSize(new Dimension(0,180));
	 	 southr.setBackground(Color.lightGray);
	 	 southr.setBorder(new LineBorder(Color.blue));
	 	 southrdown.setLayout(new GridLayout(3,3));
	 	 southrdown.add(move);  southrdown.add(up); southrdown.add(attack);
	 	 southrdown.add(left);southrdown.add(n1);southrdown.add(right);
	 	 southrdown.add(n2); southrdown.add(down);southrdown.add(n3);
	 	 //south left 
	 	 southl.setBorder(new LineBorder(Color.RED));
	 	 southl.setLayout(new BorderLayout());
	 	 southl.add(southlup,BorderLayout.NORTH);
	     southl.add(southldown,BorderLayout.CENTER);
	     southlup.setLayout(new GridLayout(0,3));southlup.add(ability1);southlup.add(ability2);southlup.add(ability3);
	     southlup.setPreferredSize(new Dimension(100,50));
	     southldown.setLayout(new GridLayout(0,2));southldown.add(LeaderAbility1);southldown.add(LeaderAbility2);
	     ability1.setText(""+((Champion)Turn.peekMin()).getAbilities().get(0).getName());
	     ability2.setText(""+((Champion)Turn.peekMin()).getAbilities().get(1).getName());
	     ability3.setText(""+((Champion)Turn.peekMin()).getAbilities().get(2).getName());
	     
	     //east
	     add(east,BorderLayout.EAST);
	     east.setBorder(new LineBorder(Color.RED));
	     east.setPreferredSize(new Dimension(200,200));
	     east.setFont(new Font("AR BONNIE", Font.BOLD, 13));	
	 	 
	     //west
	     add(west,BorderLayout.WEST);
	     west.setPreferredSize(new Dimension(200,200));
	     west.setFont(new Font("AR BONNIE", Font.BOLD, 16));
	     west.setBorder(new LineBorder(Color.RED));
	     west.setLayout(new BorderLayout());
	     EffectInfo.setPreferredSize(new Dimension (150,150));
	     CoverHp.setPreferredSize(new Dimension(20,20));
	     AbilityInfo.setPreferredSize(new Dimension (150,150));
	     CoverHp.setBorder(new LineBorder(Color.RED));
	     west.add(EffectInfo,BorderLayout.NORTH);
	     west.add(CoverHp,BorderLayout.CENTER);
	     west.add(AbilityInfo,BorderLayout.SOUTH); 
	     
	     
	                                         ///// Creating the design of the game ////////
//	     for(int i =0;i< firstTeam.size();i++) {
//	    	 System.out.println(firstTeam.get(i).getName() + "  fgb ");
//	    	
//	     }
//	     
//	     for(int i =0;i< secondTeam.size();i++) {
//	    	 System.out.println(secondTeam.get(i).getName());
//	    	
//	     }
	    
    	 ///north left 3ashan turnorder
	     while(game.getTurnOrder().size()!=1) {
	    	 txt = txt+ ((Champion)game.getTurnOrder().peekMin()).getName() + " -->";
	    	 next.add((Champion)game.getTurnOrder().remove());
	     }
	     txt = txt+ ((Champion)game.getTurnOrder().peekMin()).getName();
	     //neraga3o tani fel turnorder
	     for(int i =0;i<next.size();i++) {
	    	 game.getTurnOrder().insert(next.get(i));
	     }
	     
	     northl.setText(txt);
	     
	     //////adding all the resized icons  200x97  dol ely hyb2o 3ala el board
	     ChampsIcons.add(new ImageIcon("IMAGES/ca_resized.png")); 
    	 ChampsIcons.add(new ImageIcon("IMAGES/deadpool_resized.jpg"));ChampsIcons.add(new ImageIcon("IMAGES/dr_strange_resized.jpg"));
    	 ChampsIcons.add(new ImageIcon("IMAGES/elec_resized.jpg"));ChampsIcons.add(new ImageIcon("IMAGES/ghost_resized.jpg"));
    	 ChampsIcons.add(new ImageIcon("IMAGES/hela_resized.jpg"));ChampsIcons.add(new ImageIcon("IMAGES/hulk_resized.png"));
    	 ChampsIcons.add(new ImageIcon("IMAGES/im_resized.png"));ChampsIcons.add(new ImageIcon("IMAGES/ironman_resized.png"));
    	 ChampsIcons.add(new ImageIcon("IMAGES/loki_resized.jpg"));ChampsIcons.add(new ImageIcon("IMAGES/quicksilver_resized.jpeg"));
    	 ChampsIcons.add(new ImageIcon("IMAGES/spider_resized.jpg")); ChampsIcons.add(new ImageIcon("IMAGES/thor_resized.jpg"));
    	 ChampsIcons.add(new ImageIcon("IMAGES/ven_resized.jpeg"));ChampsIcons.add(new ImageIcon("IMAGES/yj_resized.jpg"));

	    
	                                     /////////////////////  Starting el game ///////////////
	    ////creating 5x5 cells
	 	   cells = new JLabel[5][5];
	 	   int countert1=0;
	 	   int countert2=0;
	 	  for (int i = 0; i < 5; i++){
	 	        for (int j = 0; j < 5; j++){
	 	            cells[i][j] = new JLabel();
	 	            cells[i][j].setBorder(new LineBorder(getForeground()));
	 	            cells[i][j].setBackground(getBackground());
	 	            cells[i][j].setOpaque(true);
	 	            cells[i][j].addMouseListener(this);
		 	           }
	 	        }

	 	    
	 	
	 	 for (int i = 4; i >=0; i--){
	 	        for (int j = 0; j < 5; j++){
	 	        	if(Thisgame [i][j] instanceof Cover ) 
		 	        	   cells[i][j].setIcon(new ImageIcon("IMAGES/cov.jpg"));
		 	         
		 	            if(Thisgame [i][j] instanceof Champion) {  
			 	        	  if(firstTeam.contains(Thisgame[i][j])  ) {
			 	        		  for(int k =0;k<ChampsIcons.size();k++) {
			 	        			  if(firstTeam.get(countert1)==champs.get(k)) {
					 	        		  cells[i][j].setIcon(ChampsIcons.get(k));
					 	        		 countert1++;
					 	        		 break;
			 	        			  }
			 	        		  }
			 	        	  }
			 	        	  if(secondTeam.contains(Thisgame[i][j])) {
			 	        		 for(int k =0;k<ChampsIcons.size();k++) {
			 	        			  if(secondTeam.get(countert2)==champs.get(k)) {
					 	        		  cells[i][j].setIcon(ChampsIcons.get(k));
					 	        		 countert2++;
					 	        		 break;
			 	        			  }
			 	        		  }
			 	        	  }
	 	        }
	 	 }
	 	 }
	 	 for (int i = 4; i >=0; i--){
	 	        for (int j = 0; j < 5; j++){
	 	        		board1.add(cells[i][j]);
	 	        }
	 	 }
    	 //////adding all the resized icons  150x170  dol ely hyb2o fe north w south
	 	 northcup.setText(secondname);
    	 northcup.setBorder(new EmptyBorder(0,200,0,0));
    	 
    	 southcup.setText(firstname);
    	 southcup.setBorder(new EmptyBorder(0,200,0,0));

    	 Icon150x170.add(new ImageIcon("IMAGES/ca_150x170.png")); 
    	 Icon150x170.add(new ImageIcon("IMAGES/deadpool_150x170.jpg"));Icon150x170.add(new ImageIcon("IMAGES/dr_strange_150x170.jpg"));
    	 Icon150x170.add(new ImageIcon("IMAGES/elec_150x170.jpg"));Icon150x170.add(new ImageIcon("IMAGES/ghost_150x170.jpg"));
    	 Icon150x170.add(new ImageIcon("IMAGES/hela_150x170.jpg"));Icon150x170.add(new ImageIcon("IMAGES/hulk_150x170.png"));
    	 Icon150x170.add(new ImageIcon("IMAGES/im_150x170.png"));Icon150x170.add(new ImageIcon("IMAGES/ironman_150x170.png"));
    	 Icon150x170.add(new ImageIcon("IMAGES/loki_150x170.jpg"));Icon150x170.add(new ImageIcon("IMAGES/quicksilver_150x170.jpeg"));
    	 Icon150x170.add(new ImageIcon("IMAGES/spider_150x170.jpg")); Icon150x170.add(new ImageIcon("IMAGES/thor_150x170.jpg"));
    	 Icon150x170.add(new ImageIcon("IMAGES/ven_150x170.jpeg"));Icon150x170.add(new ImageIcon("IMAGES/yj_150x170.jpg"));
    	 
 
	 	 for(int i =0;i<Icon150x170.size();i++) {
	 		 if(secondTeam.get(0)==champs.get(i))
	 	         northcdownl.setIcon(Icon150x170.get(i));
	 		 
	 		 if(secondTeam.get(1)==champs.get(i))
	 	        northcdownc.setIcon(Icon150x170.get(i));
	 		
	 		 if(secondTeam.get(2)==champs.get(i))
	 	       northcdownr.setIcon(Icon150x170.get(i));
	    	
	 		 if(firstTeam.get(0)==champs.get(i))
	    	   southcdownl.setIcon(Icon150x170.get(i));
	 		 
	 		 if(firstTeam.get(1)==champs.get(i))
	    	 southcdownc.setIcon(Icon150x170.get(i));
	 		 
	 		 if(firstTeam.get(2)==champs.get(i))
	    	 southcdownr.setIcon(Icon150x170.get(i)); 
	 	 }
	 	 
	 	 
		     ////adding the normal icons in the arrayList to display it in northr2
	    	 champsIcon.add(new ImageIcon("IMAGES/ca.png")); 
	    	 champsIcon.add(new ImageIcon("IMAGES/deadpool.jpg"));champsIcon.add(new ImageIcon("IMAGES/dr_strange.jpg"));
	    	 champsIcon.add(new ImageIcon("IMAGES/elec.jpg"));champsIcon.add(new ImageIcon("IMAGES/ghost.jpg"));
	    	 champsIcon.add(new ImageIcon("IMAGES/hela.jpg"));champsIcon.add(new ImageIcon("IMAGES/hulk.png"));
	    	 champsIcon.add(new ImageIcon("IMAGES/im.png"));champsIcon.add(new ImageIcon("IMAGES/ironman.png"));
	    	 champsIcon.add(new ImageIcon("IMAGES/loki.jpg"));champsIcon.add(new ImageIcon("IMAGES/quicksilver.jpeg"));
	    	 champsIcon.add(new ImageIcon("IMAGES/spider.jpg")); champsIcon.add(new ImageIcon("IMAGES/thor.jpg"));
	    	 champsIcon.add(new ImageIcon("IMAGES/ven.jpeg"));champsIcon.add(new ImageIcon("IMAGES/yj.jpg"));
	    	
	    	 for(int champindex=0;champindex < champs.size();champindex++) {
	    		 if(champs.get(champindex)== Turn.peekMin()) 
	    			 northr2.setIcon(champsIcon.get(champindex));
	    	 }
	 
	    	 // setting the infos of the  1st turnorder champion
	    	 if(((Champion)Turn.peekMin()) instanceof Hero) {
	    		 east.setText("<html> Type: Hero <br>  Name " + ((Champion)Turn.peekMin()).getName() +" <br> Current HP : "+ ((Champion)Turn.peekMin()).getCurrentHP() +
	    		 			" <br> Mana cost : " + ((Champion)Turn.peekMin()).getMana() + " <br> Actions: " + ((Champion)Turn.peekMin()).getCurrentActionPoints() +" <br> Speed : " +
	    	 				((Champion)Turn.peekMin()).getSpeed() + " <br> Attack range : " + ((Champion)Turn.peekMin()).getAttackRange() +" <br> attack damage: " +
	    	 					((Champion)Turn.peekMin()).getAttackDamage() + "  <br> Ability 1 :"+ ((Champion)Turn.peekMin()).getAbilities().get(0).getName() 
	    	 					+ "  <br> Ability 2 :"+ ((Champion)Turn.peekMin()).getAbilities().get(1).getName()+ " <br> Ability 3 :"+ ((Champion)Turn.peekMin()).getAbilities().get(2).getName() + "<html>"); 
	    	 }
	    	 else if(((Champion)Turn.peekMin()) instanceof AntiHero) {
	     		east.setText("<html> Type: AntiHero <br>  Name " + ((Champion)Turn.peekMin()).getName() +" <br> Current HP : "+ ((Champion)Turn.peekMin()).getCurrentHP() +
    		 			" <br> Mana cost : " + ((Champion)Turn.peekMin()).getMana() + "  <br> Actions: " + ((Champion)Turn.peekMin()).getCurrentActionPoints() +" <br> Speed : " +
    	 				((Champion)Turn.peekMin()).getSpeed() + " <br> Attack range : " + ((Champion)Turn.peekMin()).getAttackRange() +" <br> attack damage: " +
    	 					((Champion)Turn.peekMin()).getAttackDamage()  + "  <br> Ability 1 :"+ ((Champion)Turn.peekMin()).getAbilities().get(0).getName() 
    	 					+ "  <br> Ability 2 :"+ ((Champion)Turn.peekMin()).getAbilities().get(1).getName()+ " <br> Ability 3 :"+ ((Champion)Turn.peekMin()).getAbilities().get(2).getName()+ "<html>"); 
	     	}
		  
	    	 else if(((Champion)Turn.peekMin()) instanceof Villain) {
		  		east.setText("<html> Type: Villain <br>  Name " + ((Champion)Turn.peekMin()).getName() +" <br> Current HP : "+ ((Champion)Turn.peekMin()).getCurrentHP() +
    		 			" <br> Mana cost : " + ((Champion)Turn.peekMin()).getMana() + " <br> Actions: " + ((Champion)Turn.peekMin()).getCurrentActionPoints() +" <br> Speed : " +
    	 				((Champion)Turn.peekMin()).getSpeed() + " <br> Attack range : " + ((Champion)Turn.peekMin()).getAttackRange() +" <br> attack damage: " +
    	 					((Champion)Turn.peekMin()).getAttackDamage() + "  <br> Ability 1 :"+ ((Champion)Turn.peekMin()).getAbilities().get(0).getName() 
    	 					+ "  <br> Ability 2 :"+ ((Champion)Turn.peekMin()).getAbilities().get(1).getName()+ " <br> Ability 3 :"+ ((Champion)Turn.peekMin()).getAbilities().get(2).getName()+"<html>");
		  		
		  	}
		  	
  
	 	    setVisible(true);
		   
   }
		@Override
		public void mouseClicked(MouseEvent e) {
			 if(e.getSource()==move) {
				 moveClicked = true;
				 attackClicked = false;
				 singleTarget = false;
				 directional = false;
				 teamTarget = false;
			 }
			 if(moveClicked==true) {
				 int x= game.getCurrentChampion().getLocation().x;
				 int y= game.getCurrentChampion().getLocation().y;
				
                  if(e.getSource()==up) {
                	  try{
     					 game.move(Direction.UP);
     					 cells[game.getCurrentChampion().getLocation().x][game.getCurrentChampion().getLocation().y].setIcon(cells[x][y].getIcon());
      					 cells[x][y].setIcon(null);
      					moveClicked=false;
     				 }catch(UnallowedMovementException e1) {
     					moveClicked=false;
    					 JOptionPane.showMessageDialog(null, e1.getMessage());
    				 }catch(NotEnoughResourcesException e1) {
    					 moveClicked=false;
    					 JOptionPane.showMessageDialog(null, e1.getMessage());
    				 }
				 }
				
				
			if(e.getSource()==down) {
				try{
					 game.move(Direction.DOWN);
					 cells[game.getCurrentChampion().getLocation().x][game.getCurrentChampion().getLocation().y].setIcon(cells[x][y].getIcon());
 					 cells[x][y].setIcon(null);
 					moveClicked=false;
				 }catch(UnallowedMovementException e1) {
					moveClicked=false;
					 JOptionPane.showMessageDialog(null, e1.getMessage());
				 }catch(NotEnoughResourcesException e1) {
					 moveClicked=false;
					 JOptionPane.showMessageDialog(null, e1.getMessage());
				 }					 
			 }
			if(e.getSource()==left) {
				try{
					 game.move(Direction.LEFT);
					 cells[game.getCurrentChampion().getLocation().x][game.getCurrentChampion().getLocation().y].setIcon(cells[x][y].getIcon());
 					 cells[x][y].setIcon(null);
 					moveClicked=false;
				 }catch(UnallowedMovementException e1) {
					moveClicked=false;
					 JOptionPane.showMessageDialog(null, e1.getMessage());
				 }catch(NotEnoughResourcesException e1) {
					 moveClicked=false;
					 JOptionPane.showMessageDialog(null, e1.getMessage());
				 }	 
					}
			if(e.getSource()==right) {
				try{
					 game.move(Direction.RIGHT);
					 cells[game.getCurrentChampion().getLocation().x][game.getCurrentChampion().getLocation().y].setIcon(cells[x][y].getIcon());
 					 cells[x][y].setIcon(null);
 					moveClicked=false;
				 }catch(UnallowedMovementException e1) {
					moveClicked=false;
					 JOptionPane.showMessageDialog(null, e1.getMessage());
				 }catch(NotEnoughResourcesException e1) {
					 moveClicked=false;
					 JOptionPane.showMessageDialog(null, e1.getMessage());
				 } 
					}
			 }
			 if(e.getSource()==attack) {
				 moveClicked = false;
				 attackClicked = true;
				 singleTarget = false;
				 directional = false;
				 teamTarget = false;
			 }
			 if(attackClicked==true) {
				 if(e.getSource()==up) {
					 try {
						 game.attack(Direction.UP);

						 attackClicked = false;
					 }catch(ChampionDisarmedException e1) {
							attackClicked=false;
							 JOptionPane.showMessageDialog(null, e1.getMessage());
					 }catch(NotEnoughResourcesException e1) {
							 attackClicked=false;
							 JOptionPane.showMessageDialog(null, e1.getMessage());
						 } catch (InvalidTargetException e1) {
							 attackClicked=false;
							 JOptionPane.showMessageDialog(null, e1.getMessage());
					} 
				 }
				 if(e.getSource()==down) {
					 try {
						 game.attack(Direction.DOWN);
						 attackClicked = false;
					 }catch(ChampionDisarmedException e1) {
							attackClicked=false;
							 JOptionPane.showMessageDialog(null, e1.getMessage());
					 }catch(NotEnoughResourcesException e1) {
							 attackClicked=false;
							 JOptionPane.showMessageDialog(null, e1.getMessage());
						 } catch (InvalidTargetException e1) {
							 attackClicked=false;
							 JOptionPane.showMessageDialog(null, e1.getMessage());
					} 
				 }
				 if(e.getSource()==left) {
					 try {
						 game.attack(Direction.LEFT);

						 attackClicked = false;
					 }catch(ChampionDisarmedException e1) {
							attackClicked=false;
							 JOptionPane.showMessageDialog(null, e1.getMessage());
					 }catch(NotEnoughResourcesException e1) {
							 attackClicked=false;
							 JOptionPane.showMessageDialog(null, e1.getMessage());
						 } catch (InvalidTargetException e1) {
							 attackClicked=false;
							 JOptionPane.showMessageDialog(null, e1.getMessage());
					} 
				 }
				 if(e.getSource()==right) {
					 try {
						 game.attack(Direction.RIGHT);
						 attackClicked = false;
					 }catch(ChampionDisarmedException e1) {
							attackClicked=false;
							 JOptionPane.showMessageDialog(null, e1.getMessage());
					 }catch(NotEnoughResourcesException e1) {
							 attackClicked=false;
							 JOptionPane.showMessageDialog(null, e1.getMessage());
						 } catch (InvalidTargetException e1) {
							 attackClicked=false;
							 JOptionPane.showMessageDialog(null, e1.getMessage());
					} 
				 }
				
			 }
			
			 
			 if(e.getSource()==LeaderAbility1) {
				 if(game.getFirstPlayer().getTeam().contains(game.getCurrentChampion())) {
					 try {
						 game.useLeaderAbility();
						 LeaderAbility1.setEnabled(false);
						 LeaderAbility1.setText("LeaderAbility for Player1 is used");
						 
					 }catch(LeaderNotCurrentException e1) {
						 JOptionPane.showMessageDialog(null, e1.getMessage());
					 }catch(LeaderAbilityAlreadyUsedException e1) {
						 JOptionPane.showMessageDialog(null, e1.getMessage());
					 }
					 
				 }
				 
			 }
			 if(e.getSource()==LeaderAbility2) {
				 if(game.getSecondPlayer().getTeam().contains(game.getCurrentChampion())) {
					 try {
						 game.useLeaderAbility();
						 LeaderAbility2.setEnabled(false);
						 LeaderAbility2.setText("LeaderAbility for Player2 is used");
					 }catch(LeaderNotCurrentException e1) {
						 JOptionPane.showMessageDialog(null, e1.getMessage());
					 }catch(LeaderAbilityAlreadyUsedException e1) {
						 JOptionPane.showMessageDialog(null, e1.getMessage());
					 }
				 }
			 }
			 
			
			 if(e.getSource()==ability1) {
				 if(game.getCurrentChampion().getAbilities().get(0).getCastArea()==AreaOfEffect.SINGLETARGET) {
					 singleTarget = true;
					 directional =false;
					 teamTarget =false;
					 attackClicked = false;
					 moveClicked = false;
					 ability = game.getCurrentChampion().getAbilities().get(0); 
				 }
				 else if(game.getCurrentChampion().getAbilities().get(0).getCastArea()==AreaOfEffect.DIRECTIONAL) {
					 singleTarget = false;
					 directional =true;
					 teamTarget =false;
					 attackClicked = false;
					 moveClicked = false;
					 ability = game.getCurrentChampion().getAbilities().get(0); 
				 }
				 else if(game.getCurrentChampion().getAbilities().get(0).getCastArea()==AreaOfEffect.TEAMTARGET) {
					 singleTarget = false;
					 directional =false;
					 teamTarget =true;
					 attackClicked = false;
					 moveClicked = false;
					 ability = game.getCurrentChampion().getAbilities().get(0); 
				 }
				 else {
					 try {
						 game.castAbility(game.getCurrentChampion().getAbilities().get(0));
					 }catch(AbilityUseException e1) {
						 JOptionPane.showMessageDialog(null, e1.getMessage());
					 } catch (NotEnoughResourcesException e1) {
						 JOptionPane.showMessageDialog(null, e1.getMessage());
					} catch (CloneNotSupportedException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
				 }
				 
			 }
			 if(e.getSource()==ability2) {
				 if(game.getCurrentChampion().getAbilities().get(1).getCastArea()==AreaOfEffect.SINGLETARGET) {
					 singleTarget = true;
					 directional =false;
					 teamTarget =false;
					 attackClicked = false;
					 moveClicked = false;
					 ability = game.getCurrentChampion().getAbilities().get(1); 
				 }
				 else if(game.getCurrentChampion().getAbilities().get(1).getCastArea()==AreaOfEffect.DIRECTIONAL) {
					 singleTarget = false;
					 directional =true;
					 teamTarget =false;
					 attackClicked = false;
					 moveClicked = false;
					 ability = game.getCurrentChampion().getAbilities().get(1); 
				 }
				 else if(game.getCurrentChampion().getAbilities().get(1).getCastArea()==AreaOfEffect.TEAMTARGET) {
					 singleTarget = false;
					 directional =false;
					 teamTarget =true;
					 attackClicked = false;
					 moveClicked = false;
					 ability = game.getCurrentChampion().getAbilities().get(1); 
				 }
				 else {
					 try {
						 game.castAbility(game.getCurrentChampion().getAbilities().get(1));
					 }catch(AbilityUseException e1) {
						 JOptionPane.showMessageDialog(null, e1.getMessage());
					 } catch (NotEnoughResourcesException e1) {
						 JOptionPane.showMessageDialog(null, e1.getMessage());
					} catch (CloneNotSupportedException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
				 }
				 
			 }
			 if(e.getSource()==ability3) {
				 if(game.getCurrentChampion().getAbilities().get(2).getCastArea()==AreaOfEffect.SINGLETARGET) {
					 singleTarget = true;
					 directional =false;
					 teamTarget =false;
					 attackClicked = false;
					 moveClicked = false;
					 ability = game.getCurrentChampion().getAbilities().get(2); 
				 }
				 else if(game.getCurrentChampion().getAbilities().get(2).getCastArea()==AreaOfEffect.DIRECTIONAL) {
					 singleTarget = false;
					 directional =true;
					 teamTarget =false;
					 attackClicked = false;
					 moveClicked = false;
					 ability = game.getCurrentChampion().getAbilities().get(2); 
				 }
				 else if(game.getCurrentChampion().getAbilities().get(2).getCastArea()==AreaOfEffect.TEAMTARGET) {
					 singleTarget = false;
					 directional =false;
					 teamTarget =true;
					 attackClicked = false;
					 moveClicked = false;
					 ability = game.getCurrentChampion().getAbilities().get(2); 
				 }
				 else {
					 try {
						 game.castAbility(game.getCurrentChampion().getAbilities().get(2));
					 }catch(AbilityUseException e1) {
						 JOptionPane.showMessageDialog(null, e1.getMessage());
					 } catch (NotEnoughResourcesException e1) {
						 JOptionPane.showMessageDialog(null, e1.getMessage());
					} catch (CloneNotSupportedException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
				 }
				 
			 }
			 if(teamTarget==true) {
				 try {
					 game.castAbility(ability);
					 teamTarget=false;
				 }catch(AbilityUseException e1) {
					 teamTarget=false;
					 JOptionPane.showMessageDialog(null, e1.getMessage());
				 } catch (NotEnoughResourcesException e1) {
					 teamTarget=false;
					 JOptionPane.showMessageDialog(null, e1.getMessage());
				} catch (CloneNotSupportedException e1) {
					teamTarget=false;
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			 }
			 if(directional==true) {
				 if(e.getSource()==up) {
					 try {
						 
						game.castAbility(ability, Direction.UP);
						directional=false;
					} catch (NotEnoughResourcesException | AbilityUseException | CloneNotSupportedException e1) {
						directional=false;
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
				 }
				 if(e.getSource()==down) {
					 try {
						 
						game.castAbility(ability, Direction.DOWN);
						directional=false;
					} catch (NotEnoughResourcesException | AbilityUseException | CloneNotSupportedException e1) {
						directional=false;
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
				 }
				 if(e.getSource()==left) {
					 try {
						 
						game.castAbility(ability, Direction.LEFT);
						directional=false;
					} catch (NotEnoughResourcesException | AbilityUseException | CloneNotSupportedException e1) {
						directional=false;
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
				 }
				 if(e.getSource()==right) {
					 try {
						
						game.castAbility(ability, Direction.RIGHT);
						 directional=false;
					} catch (NotEnoughResourcesException | AbilityUseException | CloneNotSupportedException e1) {
						directional=false;
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
				 }
				 
			 }
			 if(singleTarget==true) {
				 for (int i=0;i<5;i++) {
					 for(int j=0;j<5;j++) {
						 if(e.getSource()==cells[i][j]) {
							 try {							 
								 game.castAbility(ability, i, j);
								    singleTarget=false;
							 }catch (NotEnoughResourcesException | AbilityUseException | CloneNotSupportedException | InvalidTargetException e1) {
									singleTarget=false;
									JOptionPane.showMessageDialog(null, e1.getMessage());
								}
						 }
					 }
			 }
			 }

			 if(e.getSource()==endTurn) {
				 game.endTurn();
				 ability1.setText(""+((Champion)Turn.peekMin()).getAbilities().get(0).getName());
			     ability2.setText(""+((Champion)Turn.peekMin()).getAbilities().get(1).getName());
			     ability3.setText(""+((Champion)Turn.peekMin()).getAbilities().get(2).getName());
			     for(int champindex=0;champindex < champs.size();champindex++) {
		    		 if(champs.get(champindex)== Turn.peekMin()) 
		    			 northr2.setIcon(champsIcon.get(champindex));
		    	 }
			 }
			 if(game.checkGameOver()!=null) {
			if(firstPlayer.getTeam().size()==0 && secondPlayer.getTeam().size()!=0 ) {
				JOptionPane.showMessageDialog(null,"The Winner is " + this.getSecondname() + " !!");
			}
			if(secondPlayer.getTeam().size()==0  && firstPlayer.getTeam().size()!=0  ) {
				JOptionPane.showMessageDialog(null,"The Winner is " + this.getFirstname()+ " !!");
			}
				move.setEnabled(false);
				up.setEnabled(false);
				down.setEnabled(false);
				left.setEnabled(false);
				n1.setEnabled(false);
				n2.setEnabled(false);
				n3.setEnabled(false);
				right.setEnabled(false);
				attack.setEnabled(false);
				endTurn.setEnabled(false);
				LeaderAbility1.setEnabled(false);
				LeaderAbility2.setEnabled(false);
				ability1.setEnabled(false);
				ability2.setEnabled(false);
				ability3.setEnabled(false);
			 }	
			
			 		 
			 ///removing all the icons of all the damageables things on the board
			 for (int i=0;i<5;i++) {
				 for(int j=0;j<5;j++) {
					 if(Thisgame[i][j] instanceof Champion) {
						 if(((Champion)Thisgame[i][j]).getCurrentHP()==0) {
							 cells[i][j].setIcon(null);
						 }
					 }
					 if(Thisgame[i][j] instanceof Cover) {
						 if(((Cover)Thisgame[i][j]).getCurrentHP()==0) {
							 cells[i][j].setIcon(null);
						 }
					 }
					 if(Thisgame[i][j]==null) {			
						cells[i][j].setIcon(null);
					 }
					 
				 }
		 }
			 
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
			// setting the infos of the champions and the covers on the board ////
			 for (int i = 0; i < 5; i++){
		 	        for (int j = 0; j < 5; j++){
		 	        	
		 	        	if(Thisgame[i][j]==firstleader||Thisgame[i][j]==secondleader)
		 	        		isLeader="a leader";
		 	        	else 
		 	        		isLeader="not a leader";
		 	        	
		 	        	if( Thisgame [i][j] instanceof Cover ) {
		 	        		 if(e.getSource()==cells[i][j]) 
		 	        			CoverHp.setText("This Cover's Current HP = "+ ((Cover)Thisgame [i][j]).getCurrentHP());
		 	        	 } 
		 	        	
		 	        	 else if( Thisgame [i][j] instanceof Champion ) {
		 	        		 
		 	        		 if(e.getSource()==cells[i][j]) {
		 	        				if(((Champion)Thisgame[i][j]).getAppliedEffects().size()==0)
		 	        					EffectInfo.setText("<html>"+((Champion)Thisgame[i][j]).getName()+"<br> does not have any applied effects "+"<html>");
		 	        				else {
		 	        					for(int t=0;t<((Champion)Thisgame[i][j]).getAppliedEffects().size();t++){
						 	   			  	EffectInfo.setText("<html> The AppliedEffects  on  " + ((Champion)Thisgame[i][j]).getName()
						 	   			  			+  " are : " +"<br>"+((Champion)Thisgame[i][j]).getAppliedEffects().get(t).getName() + "  <br> Duration :" +
					 	   		    				((Champion)Thisgame[i][j]).getAppliedEffects().get(t).getDuration() + "<html>");
		 	        				}
			 	   		    		 }
		 	        			
		 	        			
		 	   		    	 if(((Champion)Thisgame[i][j]) instanceof Hero) {
		 	   		    		 east.setText("<html> Type: Hero <br>  Name " + ((Champion)Thisgame[i][j]).getName() +" <br> Current HP : "+ ((Champion)Thisgame[i][j]).getCurrentHP() +
		 	   		    		 			" <br> Mana cost : " + ((Champion)Thisgame[i][j]).getMana() + " <br> Actions: " + ((Champion)Thisgame[i][j]).getCurrentActionPoints() +" <br> Speed : " +
		 	   		    	 				((Champion)Thisgame[i][j]).getSpeed() + " <br> Attack range : " + ((Champion)Thisgame[i][j]).getAttackRange() +" <br> attack damage: " +
		 	   		    	 					((Champion)Thisgame[i][j]).getAttackDamage() + "  <br> Ability 1 :"+ ((Champion)Thisgame[i][j]).getAbilities().get(0).getName() 
		 	   		    	 					+ "  <br> Ability 2 :"+ ((Champion)Thisgame[i][j]).getAbilities().get(1).getName()+ " <br> Ability 3 :"+ ((Champion)Thisgame[i][j]).getAbilities().get(2).getName() + "<br>"+"This Champion is "+isLeader+"<html>"); 
		 	   		    		 
		 	   		    		 break;
		 	   		    	 }
		 	   		     	if(((Champion)Thisgame[i][j]) instanceof AntiHero) {
		 	   		     		east.setText("<html> Type: AntiHero <br>  Name " + ((Champion)Thisgame[i][j]).getName() +" <br> Current HP : "+ ((Champion)Thisgame[i][j]).getCurrentHP() +
		 	   	    		 			" <br> Mana cost : " + ((Champion)Thisgame[i][j]).getMana() + "  <br> Actions: " + ((Champion)Thisgame[i][j]).getCurrentActionPoints() +" <br> Speed : " +
		 	   	    	 				((Champion)Thisgame[i][j]).getSpeed() + " <br> Attack range : " + ((Champion)Thisgame[i][j]).getAttackRange() +" <br> attack damage: " +
		 	   	    	 					((Champion)Thisgame[i][j]).getAttackDamage()  + "  <br> Ability 1 :"+ ((Champion)Thisgame[i][j]).getAbilities().get(0).getName() 
		 	   	    	 					+ "  <br> Ability 2 :"+ ((Champion)Thisgame[i][j]).getAbilities().get(1).getName()+ " <br> Ability 3 :"+ ((Champion)Thisgame[i][j]).getAbilities().get(2).getName()+"<br>"+"This Champion is "+isLeader+ "<html>");
		 	   		     	
		 	   		     		break;
		 	   		     	}
		 	   			  
		 	   			  	if(((Champion)Thisgame[i][j]) instanceof Villain) {
		 	   			  		east.setText("<html> Type: Villain <br>  Name " + ((Champion)Thisgame[i][j]).getName() +" <br> Current HP : "+ ((Champion)Thisgame[i][j]).getCurrentHP() +
		 	   	    		 			" <br> Mana cost : " + ((Champion)Thisgame[i][j]).getMana() + " <br> Actions: " + ((Champion)Thisgame[i][j]).getCurrentActionPoints() +" <br> Speed : " +
		 	   	    	 				((Champion)Thisgame[i][j]).getSpeed() + " <br> Attack range : " + ((Champion)Thisgame[i][j]).getAttackRange() +" <br> attack damage: " +
		 	   	    	 					((Champion)Thisgame[i][j]).getAttackDamage() + "  <br> Ability 1 :"+ ((Champion)Thisgame[i][j]).getAbilities().get(0).getName() 
		 	   	    	 					+ "  <br> Ability 2 :"+ ((Champion)Thisgame[i][j]).getAbilities().get(1).getName()+ " <br> Ability 3 :"+ ((Champion)Thisgame[i][j]).getAbilities().get(2).getName()+"<br>"+"This Champion is "+isLeader+ "<html>");
		 	   			  	
		 	   			  		break;
		 	   			  	}
		 
		 	        		
		 	        	 }
		 	        }
			 }
			 }
			 if(e.getSource()==ability1) {
				 if(game.getCurrentChampion().getAbilities().get(0) instanceof DamagingAbility){
				 AbilityInfo.setText( "<html> Name : " + ((Champion)(Turn.peekMin())).getAbilities().get(0).getName() + "<br> Type: Damaging-Ability" + "<br> Area Of Effect: " + 
						 ((Champion)(Turn.peekMin())).getAbilities().get(0).getCastArea() + " <br> Mana Cost " +((Champion)(Turn.peekMin())).getAbilities().get(0).getManaCost()+" <br> Required Action points" + 
						 ((Champion)(Turn.peekMin())).getAbilities().get(0).getRequiredActionPoints()+ " <br> Current CoolDown "+ ((Champion)(Turn.peekMin())).getAbilities().get(0).getCurrentCooldown() + 
						 	" <br> Base CoolDown "+ ((Champion)(Turn.peekMin())).getAbilities().get(0).getBaseCooldown() + " <br> Damage Amount: "+ ((DamagingAbility)((Champion)(Turn.peekMin())).getAbilities().get(0)).getDamageAmount() + "<html>");
			 }
				 if(game.getCurrentChampion().getAbilities().get(0) instanceof HealingAbility){
					 AbilityInfo.setText( "<html> Name : " + ((Champion)(Turn.peekMin())).getAbilities().get(0).getName() + "<br> Type: Healing-Ability" + "<br> Area Of Effect: " + 
							 ((Champion)(Turn.peekMin())).getAbilities().get(0).getCastArea() + " <br> Mana Cost " +((Champion)(Turn.peekMin())).getAbilities().get(0).getManaCost()+" <br> Required Action points" + 
							 ((Champion)(Turn.peekMin())).getAbilities().get(0).getRequiredActionPoints()+ " <br> Current CoolDown "+ ((Champion)(Turn.peekMin())).getAbilities().get(0).getCurrentCooldown() + 
							 	" <br> Base CoolDown "+ ((Champion)(Turn.peekMin())).getAbilities().get(0).getBaseCooldown() + " <br> Heal Amount: "+ ((HealingAbility)((Champion)(Turn.peekMin())).getAbilities().get(0)).getHealAmount() + "<html>");
				 }
				 if(game.getCurrentChampion().getAbilities().get(0) instanceof CrowdControlAbility){
					 AbilityInfo.setText( "<html> Name : " + ((Champion)(Turn.peekMin())).getAbilities().get(0).getName() + "<br> Type: Crowd-Control-Ability" + "<br> Area Of Effect: " + 
							 ((Champion)(Turn.peekMin())).getAbilities().get(0).getCastArea() + " <br> Mana Cost " +((Champion)(Turn.peekMin())).getAbilities().get(0).getManaCost()+" <br> Required Action points" + 
							 ((Champion)(Turn.peekMin())).getAbilities().get(0).getRequiredActionPoints()+ " <br> Current CoolDown "+ ((Champion)(Turn.peekMin())).getAbilities().get(0).getCurrentCooldown() + 
							 	" <br> Base CoolDown "+ ((Champion)(Turn.peekMin())).getAbilities().get(0).getBaseCooldown() + " <br> Effect Name : "+ ((CrowdControlAbility)((Champion)(Turn.peekMin())).getAbilities().get(0)).getEffect().getName() + 
							 	" <br> Duration "+((CrowdControlAbility)((Champion)(Turn.peekMin())).getAbilities().get(0)).getEffect().getDuration()+"<html>");
				 }
				 
			 }
			 if(e.getSource()==ability2) {

				 if(game.getCurrentChampion().getAbilities().get(1) instanceof DamagingAbility){
				 AbilityInfo.setText( "<html> Name : " + ((Champion)(Turn.peekMin())).getAbilities().get(1).getName() + "<br> Type: Damaging-Ability" + "<br> Area Of Effect: " + 
						 ((Champion)(Turn.peekMin())).getAbilities().get(1).getCastArea() + " <br> Mana Cost " +((Champion)(Turn.peekMin())).getAbilities().get(1).getManaCost()+" <br> Required Action points" + 
						 ((Champion)(Turn.peekMin())).getAbilities().get(1).getRequiredActionPoints()+ " <br> Current CoolDown "+ ((Champion)(Turn.peekMin())).getAbilities().get(1).getCurrentCooldown() + 
						 	" <br> Base CoolDown "+ ((Champion)(Turn.peekMin())).getAbilities().get(1).getBaseCooldown() + " <br> Damage Amount: "+ ((DamagingAbility)((Champion)(Turn.peekMin())).getAbilities().get(1)).getDamageAmount() + "<html>");
			 }
				 if(game.getCurrentChampion().getAbilities().get(1) instanceof HealingAbility){
					 AbilityInfo.setText( "<html> Name : " + ((Champion)(Turn.peekMin())).getAbilities().get(1).getName() + "<br> Type: Healing-Ability" + "<br> Area Of Effect: " + 
							 ((Champion)(Turn.peekMin())).getAbilities().get(1).getCastArea() + " <br> Mana Cost " +((Champion)(Turn.peekMin())).getAbilities().get(1).getManaCost()+" <br> Required Action points" + 
							 ((Champion)(Turn.peekMin())).getAbilities().get(1).getRequiredActionPoints()+ " <br> Current CoolDown "+ ((Champion)(Turn.peekMin())).getAbilities().get(1).getCurrentCooldown() + 
							 	" <br> Base CoolDown "+ ((Champion)(Turn.peekMin())).getAbilities().get(1).getBaseCooldown() + " <br> Heal Amount: "+ ((HealingAbility)((Champion)(Turn.peekMin())).getAbilities().get(1)).getHealAmount() + "<html>");
				 }
				 if(game.getCurrentChampion().getAbilities().get(1) instanceof CrowdControlAbility){
					 AbilityInfo.setText( "<html> Name : " + ((Champion)(Turn.peekMin())).getAbilities().get(1).getName() + "<br> Type: Crowd-Control-Ability" + "<br> Area Of Effect: " + 
							 ((Champion)(Turn.peekMin())).getAbilities().get(1).getCastArea() + " <br> Mana Cost " +((Champion)(Turn.peekMin())).getAbilities().get(1).getManaCost()+" <br> Required Action points" + 
							 ((Champion)(Turn.peekMin())).getAbilities().get(1).getRequiredActionPoints()+ " <br> Current CoolDown "+ ((Champion)(Turn.peekMin())).getAbilities().get(1).getCurrentCooldown() + 
							 	" <br> Base CoolDown "+ ((Champion)(Turn.peekMin())).getAbilities().get(1).getBaseCooldown() + " <br> Effect Name : "+ ((CrowdControlAbility)((Champion)(Turn.peekMin())).getAbilities().get(1)).getEffect().getName() + 
							 	" <br> Duration "+((CrowdControlAbility)((Champion)(Turn.peekMin())).getAbilities().get(1)).getEffect().getDuration()+"<html>");
				 }
				}
			 if(e.getSource()==ability3) {
				 if(game.getCurrentChampion().getAbilities().get(2) instanceof DamagingAbility){
				 AbilityInfo.setText( "<html> Name : " + ((Champion)(Turn.peekMin())).getAbilities().get(2).getName() + "<br> Type: Damaging-Ability" + "<br> Area Of Effect: " + 
						 ((Champion)(Turn.peekMin())).getAbilities().get(2).getCastArea() + " <br> Mana Cost " +((Champion)(Turn.peekMin())).getAbilities().get(2).getManaCost()+" <br> Required Action points" + 
						 ((Champion)(Turn.peekMin())).getAbilities().get(2).getRequiredActionPoints()+ " <br> Current CoolDown "+ ((Champion)(Turn.peekMin())).getAbilities().get(2).getCurrentCooldown() + 
						 	" <br> Base CoolDown "+ ((Champion)(Turn.peekMin())).getAbilities().get(2).getBaseCooldown() + " <br> Damage Amount: "+ ((DamagingAbility)((Champion)(Turn.peekMin())).getAbilities().get(2)).getDamageAmount() + "<html>");
			 }
				 if(game.getCurrentChampion().getAbilities().get(2) instanceof HealingAbility){
					 AbilityInfo.setText( "<html> Name : " + ((Champion)(Turn.peekMin())).getAbilities().get(2).getName() + "<br> Type: Healing-Ability" + "<br> Area Of Effect: " + 
							 ((Champion)(Turn.peekMin())).getAbilities().get(2).getCastArea() + " <br> Mana Cost " +((Champion)(Turn.peekMin())).getAbilities().get(2).getManaCost()+" <br> Required Action points" + 
							 ((Champion)(Turn.peekMin())).getAbilities().get(2).getRequiredActionPoints()+ " <br> Current CoolDown "+ ((Champion)(Turn.peekMin())).getAbilities().get(2).getCurrentCooldown() + 
							 	" <br> Base CoolDown "+ ((Champion)(Turn.peekMin())).getAbilities().get(2).getBaseCooldown() + " <br> Heal Amount: "+ ((HealingAbility)((Champion)(Turn.peekMin())).getAbilities().get(2)).getHealAmount() + "<html>");
				 }
				 if(game.getCurrentChampion().getAbilities().get(2) instanceof CrowdControlAbility){
					 AbilityInfo.setText( "<html> Name : " + ((Champion)(Turn.peekMin())).getAbilities().get(2).getName() + "<br> Type: Crowd-Control-Ability" + "<br> Area Of Effect: " + 
							 ((Champion)(Turn.peekMin())).getAbilities().get(2).getCastArea() + " <br> Mana Cost " +((Champion)(Turn.peekMin())).getAbilities().get(2).getManaCost()+" <br> Required Action points" + 
							 ((Champion)(Turn.peekMin())).getAbilities().get(2).getRequiredActionPoints()+ " <br> Current CoolDown "+ ((Champion)(Turn.peekMin())).getAbilities().get(2).getCurrentCooldown() + 
							 	" <br> Base CoolDown "+ ((Champion)(Turn.peekMin())).getAbilities().get(2).getBaseCooldown() + " <br> Effect Name : "+ ((CrowdControlAbility)((Champion)(Turn.peekMin())).getAbilities().get(2)).getEffect().getName() + 
							 	" <br> Duration: "+((CrowdControlAbility)((Champion)(Turn.peekMin())).getAbilities().get(2)).getEffect().getDuration()+"<html>");
				 }
			 }
    	   	 
    	 // setting the infos of the  turnorder champions
			 if(e.getSource()==northr2) {
		    	 if(((Champion)Turn.peekMin()) instanceof Hero) {
		    		 east.setText("<html> Type: Hero <br>  Name " + ((Champion)Turn.peekMin()).getName() +" <br> Current HP : "+ ((Champion)Turn.peekMin()).getCurrentHP() +
		    		 			" <br> Mana cost : " + ((Champion)Turn.peekMin()).getMana() + " <br> Actions: " + ((Champion)Turn.peekMin()).getCurrentActionPoints() +" <br> Speed : " +
		    	 				((Champion)Turn.peekMin()).getSpeed() + " <br> Attack range : " + ((Champion)Turn.peekMin()).getAttackRange() +" <br> attack damage: " +
		    	 					((Champion)Turn.peekMin()).getAttackDamage() + "  <br> Ability 1 :"+ ((Champion)Turn.peekMin()).getAbilities().get(0).getName() 
		    	 					+ "  <br> Ability 2 :"+ ((Champion)Turn.peekMin()).getAbilities().get(1).getName()+ " <br> Ability 3 :"+ ((Champion)Turn.peekMin()).getAbilities().get(2).getName() + "<html>"); 
		    	 }
		    	 else if(((Champion)Turn.peekMin()) instanceof AntiHero) {
		     		east.setText("<html> Type: AntiHero <br>  Name " + ((Champion)Turn.peekMin()).getName() +" <br> Current HP : "+ ((Champion)Turn.peekMin()).getCurrentHP() +
				 			" <br> Mana cost : " + ((Champion)Turn.peekMin()).getMana() + "  <br> Actions: " + ((Champion)Turn.peekMin()).getCurrentActionPoints() +" <br> Speed : " +
			 				((Champion)Turn.peekMin()).getSpeed() + " <br> Attack range : " + ((Champion)Turn.peekMin()).getAttackRange() +" <br> attack damage: " +
			 					((Champion)Turn.peekMin()).getAttackDamage()  + "  <br> Ability 1 :"+ ((Champion)Turn.peekMin()).getAbilities().get(0).getName() 
			 					+ "  <br> Ability 2 :"+ ((Champion)Turn.peekMin()).getAbilities().get(1).getName()+ " <br> Ability 3 :"+ ((Champion)Turn.peekMin()).getAbilities().get(2).getName()+ "<html>"); 
		     	}
			  
		    	 else if(((Champion)Turn.peekMin()) instanceof Villain) {
			  		east.setText("<html> Type: Villain <br>  Name " + ((Champion)Turn.peekMin()).getName() +" <br> Current HP : "+ ((Champion)Turn.peekMin()).getCurrentHP() +
				 			" <br> Mana cost : " + ((Champion)Turn.peekMin()).getMana() + " <br> Actions: " + ((Champion)Turn.peekMin()).getCurrentActionPoints() +" <br> Speed : " +
			 				((Champion)Turn.peekMin()).getSpeed() + " <br> Attack range : " + ((Champion)Turn.peekMin()).getAttackRange() +" <br> attack damage: " +
			 					((Champion)Turn.peekMin()).getAttackDamage() + "  <br> Ability 1 :"+ ((Champion)Turn.peekMin()).getAbilities().get(0).getName() 
			 					+ "  <br> Ability 2 :"+ ((Champion)Turn.peekMin()).getAbilities().get(1).getName()+ " <br> Ability 3 :"+ ((Champion)Turn.peekMin()).getAbilities().get(2).getName()+"<html>");
			  		
			  	}
					 }

				}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		}
