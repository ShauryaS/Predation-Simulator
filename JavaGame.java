package JavaGameProject;

import java.awt.*; //import awt
import javax.swing.*; //import swing

import java.awt.event.*; //import awt event
import java.awt.Image;
import java.awt.CardLayout;
import java.util.ArrayList;

import javax.imageio.*;

import java.awt.image.*;
import java.io.*;

public class JavaGame extends JFrame{ //class header JavaGame extend JFrame; contains all panels and classes that are nested

	private Container container;//container class instance

	public static void main(String[] args) {

		JavaGame jg = new JavaGame();//call constructor
	}

	public JavaGame(){//constructor; set name; resize false; instansiate container; add it; set visible true

		super("Predation Simulation");
		setSize(1500, 800);
		setResizable(true);
		container = new Container();
		add(container);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

	}


	class Container extends JPanel{//class container with panel

		private CardLayout cards;//card layout instance

		private TitleScreen ts; //titlescreen instance panel
		private Predatation pd;//predatation instance panel
		private Instructions is;

		public Container(){//constructor; set layout card; instansiate cardlayout and the two panels; add them

			cards = new CardLayout();
			setLayout(cards);

			ts = new TitleScreen();
			add(ts, "ts");
			pd = new Predatation();
			add(pd, "pd");
			is = new Instructions();
			add(is, "is");

		}

		class TitleScreen extends JPanel{//class titlescreen w/ panel

			private Instructions ins;//Instructions panel instance
			private ButtonCont bc;//ButtonCont panel
			private Image img = Toolkit.getDefaultToolkit().getImage("/Users/ShauryaS/Desktop/Shaurya Srivastava/Java Programming/eclipseWS/Student/JavaGameProject/Title.jpg");

			public TitleScreen(){//constructor; set layout border; instansiate panels; add them

				setLayout(new BorderLayout());
				setBackground(Color.WHITE);

				bc = new ButtonCont();
				add(bc, BorderLayout.SOUTH);

			}

			public void paintComponent(Graphics g){//paintCOmponent method; draw image in this method

				g.drawImage(img, 0, 0, 1500, 800, this);
				g.setColor(Color.CYAN);
				g.setFont(new Font("Utopia",Font.PLAIN, 70));
				g.drawString("The Predation Life", 20, 150);
				g.setFont(new Font("Utopia",Font.PLAIN, 25));
				g.drawString("by Shaurya Srivastava and Adithya Embar", 50, 200);
			}

			class ButtonCont extends JPanel implements ActionListener{//class buttoncont with panel and action

				public JButton sg;//start game button
				public JButton np;//next button

				public ButtonCont(){//constructor; set layout grid; instansiate and add buttons; give them action; set color to them and set foreground color

					setLayout(new GridLayout(1, 2));

					sg = new JButton("Start Game");
					np = new JButton("Instructions");

					add(np);
					np.addActionListener(this);
					np.setBackground(new Color(0, 153, 0));
					np.setForeground(Color.WHITE);

					add(sg);
					sg.addActionListener(this);
					sg.setBackground(new Color(153, 0, 0));
					sg.setForeground(Color.WHITE);

				}

				public void actionPerformed(ActionEvent e){//action event method

					if(e.getSource()==sg){//if start game button pressed, show card that has predatation panel

						cards.show(container, "pd");

					}

					if(e.getSource()==np){//if next button pressed, show next card of instructions

						cards.show(container, "is");

					}

				}

			}

		}

		class GoHome extends JPanel implements ActionListener{//go home class w/ action

			private JButton goHome;//button to go home
			private JButton instructions;//button for instructions

			public GoHome(){//sets layout grid; adds buttons with a font and bg color and w/ action listener; 

				setLayout(new GridLayout(1,2));
				goHome = new JButton("Return to Main Screen");
				instructions = new JButton("Instructions");
				add(goHome);
				add(instructions);
				goHome.addActionListener(this);
				goHome.setBackground(Color.ORANGE);
				goHome.setForeground(Color.WHITE);
				instructions.addActionListener(this);
				instructions.setBackground(new Color(0, 153, 0));
				instructions.setForeground(Color.WHITE);

			}

			public void actionPerformed(ActionEvent e){//action performed method

				if(e.getSource() == goHome){//goes to first card if go home pressed

					cards.show(container, "ts");

				}

				if(e.getSource()==instructions){//if next button pressed, show next card of instructions

					cards.show(container, "is");

				}

			}

		}

		class Instructions extends JPanel implements ActionListener{//class instructions with panel

			private BufferedImage arrow;//image for arrow keys
			private BufferedImage eagles;//image for instructions bg
			private JButton home;//home button
			private JButton play;//play button


			public Instructions(){//instansiate images; constructor; instansiate jlabel ins; set layout border; instatnsiate class instances; adds buttons sets color and font color w/ action; add them

				setLayout(new BorderLayout());
				setBackground(Color.WHITE);

				home = new JButton("Back To Main Screen");
				home.addActionListener(this);
				home.setBackground(Color.ORANGE);
				home.setForeground(Color.WHITE);

				play = new JButton("Play the Game");
				play.addActionListener(this);
				play.setBackground(new Color(153, 0, 0));
				play.setForeground(Color.WHITE);

				try{
					arrow = ImageIO.read(new File("/Users/ShauryaS/Desktop/Shaurya Srivastava/Java Programming/eclipseWS/Student/JavaGameProject/ArrowKeys.png")); //C:/Java Programming/eclipseWS/Student/JavaGameProject/
				}catch (IOException e){
					System.out.println("unable to load image");
				}

				try{
					eagles = ImageIO.read(new File("/Users/ShauryaS/Desktop/Shaurya Srivastava/Java Programming/eclipseWS/Student/JavaGameProject/EagleInstructions.png")); 
				}catch (IOException e){
					System.out.println("unable to load image");
				}

				ImageIcon arrowIcon = new ImageIcon(arrow);
				JLabel arrowimg = new JLabel();
				arrowimg.setIcon(arrowIcon);

				ImageIcon eaglesIcon = new ImageIcon(eagles);
				JLabel eagleimg = new JLabel();
				eagleimg.setIcon(eaglesIcon);

				JPanel ins1 = new JPanel(new GridLayout(3,1));
				JPanel ins11 = new JPanel();
				JPanel ins12 = new JPanel();
				JPanel buttons = new JPanel(new GridLayout(1,2));

				ins1.setOpaque(false);
				ins11.setOpaque(false);
				ins12.setOpaque(false);

				ins11.setLayout(null);
				JLabel instructions = new JLabel("Welcome to our new Predation Simulator.");
				JLabel instructions2 = new JLabel("This game was designed to teach students taking biology about natural selection and  prey vs predator.");
				JLabel instructions3 = new JLabel("To start press the button down below that says Start Game.");
				JLabel instructions4 = new JLabel("Then select one of three choices for a predator." );
				JLabel instructions5 = new JLabel("Your prey is already predetermined based on you predator.");
				JLabel instructions6 = new JLabel("Then chase around your prey(circles) until the time runs out. Good Luck.");

				JLabel iarrow = new JLabel("Use the arrow keys to move the predator of"); 
				JLabel iarrow2 = new JLabel("your choice around to catch it's prey");

				instructions.setFont(new Font("Courier",Font.BOLD,20));
				instructions.setForeground(Color.ORANGE);

				instructions2.setFont(new Font("Courier",Font.BOLD,20));
				instructions2.setForeground(Color.ORANGE);

				instructions3.setFont(new Font("Courier",Font.BOLD,20));
				instructions3.setForeground(Color.ORANGE);

				instructions4.setFont(new Font("Courier",Font.BOLD,20));
				instructions4.setForeground(Color.ORANGE);

				instructions5.setFont(new Font("Courier",Font.BOLD,20));
				instructions5.setForeground(Color.ORANGE);

				instructions6.setFont(new Font("Courier",Font.BOLD,20));
				instructions6.setForeground(Color.ORANGE);

				iarrow.setFont(new Font ("Papyrus",Font.BOLD,25));
				iarrow.setForeground(Color.ORANGE);

				iarrow2.setFont(new Font ("Papyrus",Font.BOLD,25));
				iarrow2.setForeground(Color.ORANGE);

				ins11.setPreferredSize(new Dimension(280,180));
				ins11.add(instructions);
				ins11.add(instructions2);
				ins11.add(instructions3);
				ins11.add(instructions4);
				ins11.add(instructions5);
				ins11.add(instructions6);

				buttons.add(home);
				buttons.add(play);

				ins12.add(iarrow);
				ins12.add(iarrow2);

				instructions.setBounds(10,10,1300,150);
				instructions2.setBounds(10,50,1300,150);
				instructions3.setBounds(10,90,1300,150);
				instructions4.setBounds(10,130,1300,150);
				instructions5.setBounds(10,170,1300,150);
				instructions6.setBounds(10,210,1300,150);
				ins11.setBackground(new Color(103,1,255));
				ins12.setBackground(new Color(103,1,255));

				iarrow.setBounds(500,50,800,150);
				iarrow2.setBounds(500,70,800,150);

				ins12.setLayout(null);
				ins12.setPreferredSize(new Dimension(360,360));
				ins12.add(arrowimg);

				arrowimg.setBounds(0, 0, 420, 420);
				eagleimg.setBounds(0,0,1500,800);


				ins1.add(ins11);
				ins1.add(ins12);
				add(ins1, BorderLayout.NORTH);

				add(buttons,BorderLayout.SOUTH);

			}

			public void actionPerformed(ActionEvent e){//action performed method

				if(e.getSource() == home){//if home, go to titlescreen

					cards.show(container, "ts");

				}

				if(e.getSource()==play){//if start game button pressed, show card that has predatation panel

					cards.show(container, "pd");

				}
			}

			public void paintComponent(Graphics g){//set bg image

				super.paintComponent(g);
				g.drawImage(eagles, 0, 0, this);

			}

		}

		class Predatation extends JPanel{//class predatatin w/ panel

			private Time t;//time panel class instance
			private Select s;//select panel class instance
			private Display d;//display class panel instance
			private GoHome gh;//go home class panel instance 

			public Predatation(){//constructor Predatation; set layout border; instansiate class panels; add them to specific border/part of screen

				setLayout(new BorderLayout());
				t = new Time();
				add(t, BorderLayout.NORTH);
				s = new Select();
				add(s, BorderLayout.WEST);
				gh = new GoHome();
				add(gh, BorderLayout.SOUTH);
				d = new Display();
				add(d, BorderLayout.CENTER);

			}

			class Time extends JPanel{//class header Time extend JPanel implement ActionListener

				private JLabel label;//label

				public Time(){//constructor Time; instansiate and add all components; set layout grid

					setLayout(new GridLayout(1, 1));

					label = new JLabel("Select a Predator and press the button continue. Click Reset to choose a different predator");

					add(label);

				}

				public void paintComponent(Graphics g){//paint component method set Background and paint bg

					setBackground(Color.ORANGE);
					super.paintComponent(g);

				}

			}

			class Display extends JPanel implements KeyListener, ActionListener{//class Display extend JPanel implements MouseListener and KeyListener

				private Color c;//color var
				private boolean stareffect;//boolean var

				private boolean skyeffect;

				private Image animal;//predator selected
				private Image animalprey;//prey selected

				private boolean drawAnimal;
				private boolean drawPrey;

				private int xa = 700;
				private int ya = 600;

				private int speed = 50;
				private int pspeed = 50;

				private boolean grasseffect;
				private boolean oceaneffect;

				private boolean cheetah;
				private boolean shark;
				private boolean eagle;

				private boolean earthquake;
				private boolean tsunami;
				private boolean eruption;

				private ArrayList<circle> rcircle = new ArrayList<circle>();
				private AutoPred [] autopreds;

				private int preyEaten;
				private int genCount;
				private boolean genCheck;
				private int rabsize;
				private int antlsize;

				private int seconds;
				private int milliseconds;
				private boolean timenot0;
				private boolean gameOver;

				private boolean rect = false;

				private boolean udraw;
				private boolean ddraw;
				private boolean rdraw;
				private boolean ldraw;
				private boolean hide;

				private Image eagleBg;
				private Image cheetahBg;
				private Image sharkBg;

				private int preysAdded;

				public void actionPerformed(ActionEvent e) {

					int olddx, olddy;

					for(circle c1: rcircle){
						if(cheetah) pspeed = c1.getspeed();

						for(circle c2: rcircle){

							if(c1==c2)
								continue;
							else if(c1.overlap(c2) ){

								olddx = c1.getdx();
								olddy = c1.getdy();
								c1.setmovement(c2.getdx(),c2.getdy());
								c2.setmovement(olddx,olddy);
							}
							c1.move();
							repaint();
						}

					}

					for(int i = 0; i<autopreds.length; i++){

						autopreds[i].HMC();
						repaint();

					}

				}

				private int randint(int min, int max) 
				{ return (int) (Math.random() * (max-min+1) + min); }

				public Display(){//constructor; set color and boolean var

					Timer timer;
					timer = new Timer(175, this);
					timer.setInitialDelay(500);
					timer.start();

					c = Color.WHITE;
					grasseffect = false;
					oceaneffect = false;

					drawAnimal = false;
					drawPrey = false;

					cheetah = false;
					shark = false;
					eagle = false;

					earthquake = false;
					tsunami = false;
					eruption = false;
					seconds = 30;
					milliseconds = 0;
					timenot0 = false;

					autopreds = new AutoPred[1];
					preysAdded = 8;

					for(int i = 0; i<20; i++){
						circle c = new circle((int)(Math.random()*1300)+100,(int)(Math.random()*1300)+100,5,Color.RED);
						c.setmovement(randint(-9,9),randint(-9,9));
						c.Visible = true;
						rcircle.add(c);

					}

					for(int i = 0; i<autopreds.length; i++){

						autopreds[i] = new AutoPred((int)(Math.random()*1310), (int)(Math.random()*680), (int)(Math.random()*7+1), (int)(Math.random()*7+1));

					}

					rabsize = 15;
					antlsize = 25;

					for(circle c: rcircle){

						c.setX( (int)(Math.random()*600));
						c.setY( (int)(Math.random()*600));

						c.setspeed( (int)(Math.random()*75+20));
						c.setsize( (int)(Math.random()*40+10));
						c.setcolor( (new Color((int)(Math.random()*256), (int)(Math.random()*256), (int)(Math.random()*256))));

					}

					udraw = true;
					ddraw = false;
					ldraw = false;
					rdraw = false;

					cheetahBg = Toolkit.getDefaultToolkit().getImage("/Users/ShauryaS/Desktop/Shaurya Srivastava/Java Programming/eclipseWS/Student/JavaGameProject/Cheetahbackground.png");
					eagleBg = Toolkit.getDefaultToolkit().getImage("/Users/ShauryaS/Desktop/Shaurya Srivastava/Java Programming/eclipseWS/Student/JavaGameProject/Eaglebackground.png");
					sharkBg = Toolkit.getDefaultToolkit().getImage("/Users/ShauryaS/Desktop/Shaurya Srivastava/Java Programming/eclipseWS/Student/JavaGameProject/Sharkbackground.png");

					addKeyListener(this);                     

				}	

				public void timeCountdown(){

					if(milliseconds == 0){

						seconds--;
						milliseconds = 99;

					}

					else{

						milliseconds--;

					}

					if(seconds <= 0 && milliseconds <= 0){

						timenot0 = false;
						gameOver = true;

						repaint();

					}

				}

				public void naturalDisaster(){//call this from generationcheck method thaqt will be created later

					int numCheck = (int)(Math.random()*1000);
					int randNumEarthQuake = (int)(Math.random()*1000);
					int randNumTsunami = (int)(Math.random()*1000);
					int randNumEruption = (int)(Math.random()*1000);

					if(numCheck == randNumEarthQuake){

						earthquake = true;
						tsunami = false;
						eruption = false;

						c = Color.DARK_GRAY;

					}

					else if(numCheck == randNumTsunami){

						tsunami = true;
						earthquake = false;
						eruption = false;

						c = Color.BLUE;

					}

					else if(numCheck == randNumEruption){

						eruption = true;
						earthquake = false;
						tsunami = false;

						c = Color.RED;

					}

				}

				public void keyPressed(KeyEvent e){//keypressed to simulate hunting, moving directions, and zooming in vision

					rect = true;

					if(e.getKeyCode()== KeyEvent.VK_RIGHT){

						xa += speed;
						udraw = false;
						ddraw = false;
						ldraw = false;
						rdraw = true;
						check();
						repaint();

					}

					if(e.getKeyCode()== KeyEvent.VK_LEFT){

						xa -= speed;
						udraw = false;
						ddraw = false;
						ldraw = true;
						rdraw = false;
						check();
						repaint();

					}

					if(e.getKeyCode()== KeyEvent.VK_UP){

						ya -= speed;
						udraw = true;
						ddraw = false;
						ldraw = false;
						rdraw = false;
						check();
						repaint();

					}

					if(e.getKeyCode()== KeyEvent.VK_DOWN){

						ya += speed;
						udraw = false;
						ddraw = true;
						ldraw = false;
						rdraw = false;
						check();
						repaint();

					}

				}

				//all keyevent methods

				public void keyTyped(KeyEvent e){}

				public void keyReleased(KeyEvent e){}

				public void check(){

					if(xa<0) xa = 0;
					if(xa>1310) xa = 1310;
					if(ya<0) ya = 0;
					if(ya>680) ya = 680;

					for(circle c: rcircle){

						if(soverlap(c) && cheetah && (c.Visible == true)){

							preyEaten++;
							c.Visible = false;
							genCheck = true;

						}

						if(soverlap(c) && eagle && (c.Visible == true)){

							preyEaten++;
							genCheck = true;
							c.Visible = false;

						}

						if(soverlap(c) && shark && (c.Visible == true)){

							preyEaten++;
							genCheck = true;
							c.Visible = false;

						}

					}

				}

				public void genChecker(){

					if(preyEaten%5==0 && preyEaten!=0 && genCheck){

						genCount += 10;
						seconds = 30 - ((genCount/10)*2);
						milliseconds = 0;

						for(int i = 0; i<autopreds.length; i++){

							autopreds[i].dx += 2;
							autopreds[i].dy += 2;

						}

						for(int i = 0; i<=preysAdded; i++){

							circle c = new circle(10,10,5,Color.RED);
							c.setmovement(randint(-9,9),randint(-9,9));

							c.setX( (int)(Math.random()*600));
							c.setY( (int)(Math.random()*600));

							c.setspeed( (int)(Math.random()*75+20));
							c.setsize( (int)(Math.random()*40+10));
							c.setcolor((new Color((int)(Math.random()*256), (int)(Math.random()*256), (int)(Math.random()*256))));

							c.Visible = true;
							rcircle.add(c);

						}

						if(preyEaten%10==0){
							
							speed+=4;
							
						}

						preysAdded--;
						genCheck = false;

					}

				}

				public boolean soverlap(circle other)
				{
					double dist;
					dist = sdistance(xa,ya,other.getx(),other.gety());
					return dist <= 25 + other.getr();
				}

				private double sdistance(int x0, int y0, int x1, int y1)  // note private 
				{ int x = (xa-x1)*(xa-x1);
				int y = (ya-y1)*(ya-y1);
				return Math.sqrt(x+y);
				}

				public void paintComponent(Graphics g){//paintComponent; set bg and paint it; draw stars using for loop

					if(gameOver){

						setBackground(Color.BLACK);
						super.paintComponent(g);

						g.setColor(Color.RED);
						g.setFont(new Font("Utopia",Font.PLAIN, 70));
						g.drawString("Game Over", 500, 350);

					}

					else{

						requestFocus();

						genChecker();

						if((int)(Math.random()*500)%250 == 0){

							naturalDisaster();

						}

						setBackground(c);
						super.paintComponent(g);

						if(grasseffect && drawAnimal && eagle){

							setBackground(new Color(101, 67, 33));
							super.paintComponent(g);

							for(int i = 0; i<=1400; i+=6){

								for(int j = 0; j<=700; j+=43){

									g.setColor(Color.GREEN);
									g.drawLine(i+3, j, i, j+40);

								}

							}

						}

						if(grasseffect && drawAnimal && cheetah){

							setBackground(new Color(71, 71, 47));
							super.paintComponent(g);

							for(int i = 0; i<=1400; i+=6){

								for(int j = 0; j<=700; j+=43){

									g.setColor(Color.YELLOW);
									g.drawLine(i+3, j, i, j+40);

								}

							}

						}

						if(oceaneffect && drawAnimal){

							setBackground(new Color(10, 105, 148));
							super.paintComponent(g);

							for(int i = 0; i<=1400; i+=30){

								g.setColor(Color.BLUE);

								for(int j = 0; j<=700; j+=43){

									g.drawOval(i,j, 10,10);

								}

							}

						}

						if(cheetah && drawAnimal){//make arrays for size speed and color and randomly generate. then adjust accordingly

							g.drawImage(cheetahBg, 0, 0, 1380, 730, this);

							if(udraw){
								g.setColor(Color.YELLOW);
								g.fillRect(xa,ya,50,50 );
								for(int i = xa; i<xa+50; i+=4){

									for(int j = ya; j<ya+50; j+=4){

										g.setColor(Color.BLACK);
										g.fillOval(i, j, 2, 2);

									}

								}
								g.setColor(Color.WHITE);
								g.fillOval(xa+2,ya+2,15,15);
								g.fillOval(xa+30,ya+2,15,15);
								g.setColor(Color.BLACK);
								g.fillOval(xa+7,ya+5,5,5);
								g.fillOval(xa+35,ya+5,5,5);
							}

							if(ddraw){
								g.setColor(Color.YELLOW);
								g.fillRect(xa,ya,50,50 );
								for(int i = xa; i<xa+50; i+=4){

									for(int j = ya; j<ya+50; j+=4){

										g.setColor(Color.BLACK);
										g.fillOval(i, j, 2, 2);

									}

								} 
								g.setColor(Color.WHITE); 
								g.fillOval(xa+2,ya+28,15,15); 
								g.fillOval(xa+30,ya+28,15,15);
								g.setColor(Color.BLACK);
								g.fillOval(xa+7,ya+33,5,5);
								g.fillOval(xa+34,ya+33,5,5);

							}

							if(rdraw){
								g.setColor(Color.YELLOW);
								g.fillRect(xa,ya,50,50 );
								for(int i = xa; i<xa+50; i+=4){

									for(int j = ya; j<ya+50; j+=4){

										g.setColor(Color.BLACK);
										g.fillOval(i, j, 2, 2);

									}

								}
								g.setColor(Color.WHITE);
								g.fillOval(xa+28,ya+2,15,15);
								g.fillOval(xa+28,ya+32,15,15);
								g.setColor(Color.BLACK);
								g.fillOval(xa+32,ya+7,5,5);
								g.fillOval(xa+32,ya+37,5,5);
							}

							if(ldraw){
								g.setColor(Color.YELLOW);
								g.fillRect(xa,ya,50,50 );
								for(int i = xa; i<xa+50; i+=4){

									for(int j = ya; j<ya+50; j+=4){

										g.setColor(Color.BLACK);
										g.fillOval(i, j, 2, 2);

									}

								}
								g.setColor(Color.WHITE);
								g.fillOval(xa,ya,15,15);
								g.fillOval(xa,ya+30,15,15);
								g.setColor(Color.BLACK);
								g.fillOval(xa+5,ya+5,5,5);
								g.fillOval(xa+5,ya+35,5,5);
							}

							for(circle c: rcircle){

								g.setColor(Color.ORANGE);

								if(c.Visible == true)
									g.fillOval(c.x, c.y, 25, 25);                                                                                                                                                 

							}

							for(int j = 0; j<1; j++){

								g.setColor(Color.YELLOW);
								g.fillRect(autopreds[j].x, autopreds[j].y,50,50);
								for(int i = autopreds[j].x; i<autopreds[j].x+50; i+=4){

									for(int k = autopreds[j].y; k<autopreds[j].y+50; k+=4){

										g.setColor(Color.BLACK);
										g.fillOval(i, k, 2, 2);

									}

								}

							}

							s.b.options.f.setVisible(false);
							s.b.options.r.setVisible(false);

							s.a.options.ea.setVisible(false);
							s.a.options.s.setVisible(false);

						}

						else if(shark && drawAnimal){	

							g.drawImage(sharkBg, 0, 0, 1380, 730, this);

							if(udraw){
								g.setColor(Color.DARK_GRAY);
								g.fillRect(xa, ya, 50, 50);
								g.setColor(Color.WHITE);
								g.fillOval(xa+2,ya+2,15,15);
								g.fillOval(xa+30,ya+2,15,15);
								g.setColor(Color.BLACK);
								g.fillOval(xa+7,ya+5,5,5);
								g.fillOval(xa+35,ya+5,5,5);
							}

							if(ddraw){
								g.setColor(Color.DARK_GRAY); 
								g.fillRect(xa,ya, 50, 50); 
								g.setColor(Color.WHITE); 
								g.fillOval(xa+2,ya+28,15,15); 
								g.fillOval(xa+30,ya+28,15,15);
								g.setColor(Color.BLACK);
								g.fillOval(xa+7,ya+33,5,5);
								g.fillOval(xa+34,ya+33,5,5);

							}

							if(rdraw){
								g.setColor(Color.DARK_GRAY);
								g.fillRect(xa, ya, 50, 50);
								g.setColor(Color.WHITE);
								g.fillOval(xa+28,ya+2,15,15);
								g.fillOval(xa+28,ya+32,15,15);
								g.setColor(Color.BLACK);
								g.fillOval(xa+32,ya+7,5,5);
								g.fillOval(xa+32,ya+37,5,5);
							}

							if(ldraw){
								g.setColor(Color.DARK_GRAY);
								g.fillRect(xa, ya, 50, 50);
								g.setColor(Color.WHITE);
								g.fillOval(xa,ya,15,15);
								g.fillOval(xa,ya+30,15,15);
								g.setColor(Color.BLACK);
								g.fillOval(xa+5,ya+5,5,5);
								g.fillOval(xa+5,ya+35,5,5);
							}

							s.b.options.a.setVisible(false);
							s.b.options.r.setVisible(false);

							s.a.options.ea.setVisible(false);
							s.a.options.c.setVisible(false);

							for(circle c: rcircle){

								g.setColor(Color.GRAY);

								if(c.Visible == true)
									g.fillOval(c.x, c.y, c.getsize(), c.getsize());

							}



							for(int i = 0; i<autopreds.length; i++){

								g.setColor(Color.DARK_GRAY);
								g.fillRect(autopreds[i].x, autopreds[i].y, 50, 50);

							}

						}

						else if(eagle && drawAnimal){

							g.drawImage(eagleBg, 0, 0, 1380, 730, this);

							if(udraw){

								g.setColor(Color.GRAY);
								g.fillRect(xa, ya, 50, 25);
								g.setColor(Color.WHITE);
								g.fillOval(xa+2,ya+2,15,15);
								g.fillOval(xa+30,ya+2,15,15);
								g.setColor(Color.BLACK);
								g.fillOval(xa+7,ya+5,5,5);
								g.fillOval(xa+35,ya+5,5,5);
								g.setColor(Color.BLACK); 
								g.fillRect(xa, ya+25, 50, 25);

							}

							if(ddraw){

								g.setColor(Color.BLACK);
								g.fillRect(xa, ya, 50, 25);
								g.setColor(Color.GRAY); 
								g.fillRect(xa, ya+25, 50, 25);
								g.setColor(Color.WHITE);
								g.fillOval(xa+2,ya+28,15,15);
								g.fillOval(xa+30,ya+28,15,15);
								g.setColor(Color.BLACK);
								g.fillOval(xa+7,ya+33,5,5);
								g.fillOval(xa+34,ya+33,5,5);

							}

							if(rdraw){

								g.setColor(Color.BLACK);
								g.fillRect(xa, ya, 25, 50);
								g.setColor(Color.GRAY); 
								g.fillRect(xa+25, ya, 25, 50);
								g.setColor(Color.WHITE);
								g.fillOval(xa+28,ya+2,15,15);
								g.fillOval(xa+28,ya+32,15,15);
								g.setColor(Color.BLACK);
								g.fillOval(xa+32,ya+7,5,5);
								g.fillOval(xa+32,ya+37,5,5);

							}

							if(ldraw){

								g.setColor(Color.GRAY);
								g.fillRect(xa, ya, 25, 50);
								g.setColor(Color.WHITE);
								g.fillOval(xa,ya,15,15);
								g.fillOval(xa,ya+30,15,15);
								g.setColor(Color.BLACK); 
								g.fillRect(xa+25, ya, 25, 50);
								g.setColor(Color.BLACK);
								g.fillOval(xa+5,ya+5,5,5);
								g.fillOval(xa+5,ya+35,5,5);

							}

							s.b.options.f.setVisible(false);
							s.b.options.a.setVisible(false);

							s.a.options.s.setVisible(false);
							s.a.options.c.setVisible(false);

							for(circle c: rcircle){

								g.setColor(c.getcolor());

								if(c.Visible == true)
									g.fillOval(c.x, c.y,15,15);

							}

							for(int i = 0; i<autopreds.length; i++){

								g.setColor(Color.BLACK);
								g.fillRect(autopreds[i].x, autopreds[i].y, 50, 50);

							}

						}

						if(hide){
							g.setFont(new Font("Utopia",Font.PLAIN, 40));
							g.setColor(Color.GREEN);
							g.drawString("Prey Eaten: ", 10, 50);
							String a = ""+preyEaten;
							g.drawString(a, 230, 50);
							g.drawString("Generation: ", 1000, 50);
							String b = ""+genCount;
							g.drawString(b, 1230, 50);

							String c = "Time: " + seconds + "." + milliseconds;
							g.setFont(new Font("Utopia",Font.PLAIN, 40));
							g.setColor(Color.GREEN);
							g.drawString(c ,500, 50);

							if(rect == false){					
								if(timenot0){

									timeCountdown();

									if(cheetah || eagle){

										try {
											Thread.sleep(3);
										} catch (InterruptedException e) {
											e.printStackTrace();
										}

									}

									if(shark){

										try {
											Thread.sleep(6);
										} catch (InterruptedException e) {
											e.printStackTrace();
										}

									}

								}
							}
							else { 

								rect = false; 

							}
						}
					}
				}

				class AutoPred{

					private int x, y;
					private int dx, dy;

					public AutoPred(int _x, int _y, int _dx, int _dy){

						x = _x;
						y = _y;
						dx = _dx;
						dy = _dy;

					}

					public void HMC(){//hunt move and check

						x = x + dx;
						y = y + dy; 

						if(x<0 || x>1310){

							dx = -dx;

						}

						if(y<0 || y>680){ 

							dy = -dy;

						}

						for(circle c: rcircle){

							if(x+50>c.x && x<c.x+c.rsize && y+50>c.y && y<c.y+c.rsize){

								c.Visible = false;

							}

						}

					}

				}

			}

			class Select extends JPanel{//class select

				private Pred a;//pred class instance
				private Prey b;//prey class instance

				public Select(){//constructor; set layout; instansiate and add 2 classes

					setLayout(new GridLayout(2,1));

					a = new Pred();
					add(a);

					b = new Prey();
					add(b);

				}

				class Pred extends JPanel{//class pred

					private Title title;//class title instance
					private Options options;//options class instance
					private Buttons button;//buttons class instance

					public Pred(){//constructor; set border layout; instansiate and add panels

						setLayout(new BorderLayout());

						title = new Title();
						add(title, BorderLayout.NORTH);

						button = new Buttons();
						add(button, BorderLayout.SOUTH);

						options = new Options();
						add(options, BorderLayout.CENTER);

					}

					class Title extends JPanel{//class title extend panel

						private JLabel label;//label

						public Title(){//constructor; instansiate and add label

							label = new JLabel("Predator:");
							add(label);

						}

						public void paintComponent(Graphics g){//paint component; set and paint bg

							setBackground(Color.BLUE);
							super.paintComponent(g);

						}

					}

					class Options extends JPanel implements ActionListener{//class options w/ action

						private ButtonGroup p;

						private JRadioButton ea;
						private JRadioButton c;
						private JRadioButton s;

						public Options(){

							setLayout(new GridLayout(3, 1));
							setBackground(new Color(204,0,0));

							p = new ButtonGroup();

							ea = new JRadioButton("Eagle");
							s = new JRadioButton("Shark");
							c = new JRadioButton("Cheetah");


							p.add(c);
							add(c);
							c.setBackground(new Color(204,0,0));
							c.setForeground(Color.WHITE);
							c.addActionListener(this);

							p.add(ea);
							add(ea);
							ea.setBackground(new Color(204,0,0));
							ea.setForeground(Color.WHITE);
							ea.addActionListener(this);

							p.add(s);
							add(s);
							s.setBackground(new Color(204,0,0));
							s.setForeground(Color.WHITE);
							s.addActionListener(this);

						}

						public void actionPerformed(ActionEvent e){

							if(e.getSource() == c){

								d.cheetah = true;	
								d.shark = false;
								d.eagle = false;
								d.speed = 20;
								d.grasseffect = true;
								d.oceaneffect = false;

							}

							else if(e.getSource() == s){

								d.shark = true;
								d.eagle = false;
								d.cheetah = false;
								d.speed = 10;	
								d.oceaneffect = true;
								d.grasseffect = false;

							}

							else if(e.getSource() == ea){

								d.eagle = true;
								d.shark = false;
								d.cheetah = false;	
								d.speed = 10;
								d.grasseffect = true;
								d.oceaneffect = false;

							}

						}

					}

					class Buttons extends JPanel implements ActionListener{//class buttons w/ action listener

						private JButton reset;//reset button
						private JButton cont;//cont button

						public Buttons(){//constructor; set layout; instansiate buttons; add buttons, add action; set color; 

							setLayout(new GridLayout(1, 2));

							reset = new JButton("Reset");
							cont = new JButton("Cont");

							add(reset);
							add(cont);

							reset.addActionListener(this);
							cont.addActionListener(this);

							reset.setBackground(new Color(0, 153, 153));
							cont.setBackground(new Color(153, 0, 76));

						}

						public void actionPerformed(ActionEvent e){ //action event method; if reset pressed, make animal on Display panel disappear;

							if(e.getSource() == reset){

								d.drawAnimal = false;
								d.drawPrey = false;

								s.a.options.ea.setVisible(true);
								s.a.options.c.setVisible(true);
								s.a.options.s.setVisible(true);

								s.a.options.ea.setSelected(false);
								s.a.options.c.setSelected(false);
								s.a.options.s.setSelected(false);

								s.b.options.f.setVisible(true);
								s.b.options.a.setVisible(true);
								s.b.options.r.setVisible(true);

								for(circle c: d.rcircle){

									c.x = (int)(Math.random()*1200);
									c.y = (int)(Math.random()*1200);

									c.setspeed( (int)(Math.random()*75+1) );
									c.setsize( (int)(Math.random()*40+10));
									c.setsize( (int)(Math.random()*40+10));
									c.setcolor( new Color((int)(Math.random()*256), (int)(Math.random()*256), (int)(Math.random()*256)) );
									c.Visible = true;

								}

								for(int i = 0; i<d.autopreds.length; i++){

									d.autopreds[i].x = (int)(Math.random()*1310);
									d.autopreds[i].y = (int)(Math.random()*680);

								}

								d.preyEaten = 0;
								d.genCount = 0;
								d.grasseffect = false;
								d.oceaneffect = false;

								d.seconds = 30;
								d.gameOver = false;
								d.milliseconds = 0;
								d.timenot0 = false;

								d.udraw = true;
								d.ddraw = false;
								d.rdraw = false;
								d.ldraw = false;
								d.hide = false;

								d.repaint();

							}

							if(e.getSource() == cont){

								d.seconds = 30;
								d.milliseconds = 0;
								d.hide = true;

								d.drawAnimal = true;
								d.timenot0 = true;
								d.drawPrey = true;
								d.repaint();

							}

						}

					}

				}

				class Prey extends JPanel{ //class prey; same as pred except diff animals

					private Title title;
					private Options options;

					public Prey(){

						setLayout(new BorderLayout());

						title = new Title();
						add(title, BorderLayout.NORTH);

						options = new Options();
						add(options, BorderLayout.CENTER);

					}

					class Title extends JPanel{

						private JLabel label;

						public Title(){

							label = new JLabel("Prey:");
							add(label);

						}

						public void paintComponent(Graphics g){

							setBackground(Color.green);
							super.paintComponent(g);

						}

					}

					class Options extends JPanel{

						private ButtonGroup p;

						private JLabel a, r, f;

						private Image an, ra, fi;

						public Options(){

							setLayout(new GridLayout(3, 1));

							p = new ButtonGroup();

							a = new JLabel("Antelope");
							r = new JLabel("Rabbits");
							f = new JLabel("Fish");

							add(a);
							a.setForeground(Color.WHITE);

							add(r);
							r.setForeground(Color.WHITE);

							add(f);
							f.setForeground(Color.WHITE);

						}

						public void paintComponent(Graphics g){

							setBackground(new Color(204, 0, 204));
							super.paintComponent(g);

						}

					}

				}

			}

		}

	}

}

class circle
{
	public int x;   // coordinate of center of circle
	public int y; 
	public boolean Visible = true;
	private int radius; // radius of circle
	private int dx;  // movement vector:
	private int dy;
	Color thecolor; 
	public int rspeed;
	int rsize;     
	private Graphics brush;
	private final int XBOUND = 1310;
	private final int YBOUND = 680;

	public circle(int x0, int y0, int r, Color c) // constructor
	{ x = x0;  y = y0;
	radius = r;  thecolor = c;
	dx = 0;   dy = 0;
	//brush = b;
	}

	public int getx() { return x; }
	public int gety() { return y; }
	public int getr() { return radius; }
	public int getdx() { return dx; }
	public int getdy() { return dy; }
	public int getradius() { return radius; }
	public int getsize() { return rsize; }
	public int getspeed() { return rspeed; }
	public Color getcolor() { return thecolor; }

	private double distance(int x0, int y0, int x1, int y1)  // note private 
	{ int x = (x0-x1)*(x0-x1);
	int y = (y0-y1)*(y0-y1);
	return Math.sqrt(x+y);
	}

	public void setmovement(int newdx, int newdy)
	{
		dx = newdx;  dy = newdy;
	}

	public void move() // move, bouncing off edges
	{
		if ( (x >= (XBOUND-radius)) || (x < radius) )
			dx = -1 * dx;  // reverse x direction
		if ( (y >= YBOUND-radius) || (y < radius+30) )
			dy = -1 * dy;  // reverse y direction
		x = x+dx;  y = y+dy;

	}

	public boolean overlap(circle other)
	{
		double dist;
		dist = distance(x,y,other.getx(),other.gety());
		return dist <= radius + other.getr();
	}


	public void setY(int y_value)
	{
		y = y_value;
	}

	public void setX(int x_value)
	{
		x = x_value;
	}

	public void setcolor(Color newcolor)
	{
		thecolor = newcolor;
	}

	public void setspeed(int speed)
	{
		rspeed = speed;
	}

	public void setsize(int size)
	{
		rsize = size;
	}

}  // class circle