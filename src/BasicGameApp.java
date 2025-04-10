//Basic Game Application
//Version 2
// Basic Object, Image, Movement
// Astronaut moves to the right.
// Threaded

//K. Chun 8/2018

//*******************************************************************************
//Import Section
//Add Java libraries needed for the game
//import java.awt.Canvas;

//Graphics Libraries
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;


//*******************************************************************************
// class definition section
///step 1 add KeyListener to implements
public class BasicGameApp implements Runnable, KeyListener {

	//variable definition section
	//declare the variables used in the program
	//you can set their initial values too

	//Sets the width and height of the program window
	final int WIDTH = 1000;
	final int HEIGHT = 700;

	//Declare the variables needed for the graphics
	public JFrame frame;
	public Canvas canvas;
	public JPanel panel;

	public BufferStrategy bufferStrategy;
	public Image DVDPic;

	//Declare the objects used in the program
	//These are things that are made up of more than one variable type
	private Astronaut astro;

	//Step 1: make astro array
	Astronaut[] space_station = new Astronaut[5];


	// Main method definition
	// This is the code that runs first and automatically
	public static void main(String[] args) {
		BasicGameApp ex = new BasicGameApp();   //creates a new instance of the game
		new Thread(ex).start();                 //creates a threads & starts up the code in the run( ) method  
	}


	// Constructor Method
	// This has the same name as the class
	// This section is the setup portion of the program
	// Initialize your variables and construct your program objects here.
	public BasicGameApp() {


		setUpGraphics();

		//variable and objects
		//create (construct) the objects needed for the game and load up
		DVDPic = Toolkit.getDefaultToolkit().getImage("DVD.png"); //load the picture
		astro = new Astronaut(10, 100);

		for(int x=0; x< space_station.length; x++){
			space_station[x]= new Astronaut((int)(Math.random()*900), (int)(Math.random()*600));

		}
	}// BasicGameApp()


//*******************************************************************************
//user Method Section
//
// put your code to do things here.

	// main thread
	// this is the code that plays the game after you set things up
	public void run() {

		//for the moment we will loop things forever.
		while (true) {

			moveThings();  //move all the game objects
			render();  // paint the graphics
			pause(20); // sleep for 10 ms
		}
	}


	public void moveThings() {
		//calls the move( ) code in the objects
		astro.move();

		//step 3 move astro array
		for(int y=0;y<space_station.length;y++){
			space_station[y].move();

		}

		if (astro.xpos < space_station[0].xpos + space_station[0].width &&
				astro.xpos + astro.width > space_station[0].xpos &&
				astro.ypos < space_station[0].ypos + space_station[0].height &&
				astro.ypos + astro.height > space_station[0].ypos) {
			System.out.println("Collision!");
		}

		if (astro.xpos < space_station[1].xpos + space_station[1].width &&
				astro.xpos + astro.width > space_station[1].xpos &&
				astro.ypos < space_station[1].ypos + space_station[1].height &&
				astro.ypos + astro.height > space_station[1].ypos) {
			System.out.println("Collision!");
		}

// ...and so on

		if (astro.xpos < space_station[2].xpos + space_station[2].width &&
				astro.xpos + astro.width > space_station[2].xpos &&
				astro.ypos < space_station[2].ypos + space_station[2].height &&
				astro.ypos + astro.height > space_station[2].ypos) {
			System.out.println("Collision!");
		}

		if (astro.xpos < space_station[3].xpos + space_station[3].width &&
				astro.xpos + astro.width > space_station[3].xpos &&
				astro.ypos < space_station[3].ypos + space_station[3].height &&
				astro.ypos + astro.height > space_station[3].ypos) {
			System.out.println("Collision!");
		}

		if (astro.xpos < space_station[4].xpos + space_station[4].width &&
				astro.xpos + astro.width > space_station[4].xpos &&
				astro.ypos < space_station[4].ypos + space_station[4].height &&
				astro.ypos + astro.height > space_station[4].ypos) {
			System.out.println("Collision!");
		}

	}

	//Pauses or sleeps the computer for the amount specified in milliseconds
	public void pause(int time) {
		//sleep
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {

		}
	}

	//Graphics setup method
	private void setUpGraphics() {
		frame = new JFrame("Application Template");   //Create the program window or frame.  Names it.

		panel = (JPanel) frame.getContentPane();  //sets up a JPanel which is what goes in the frame
		panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));  //sizes the JPanel
		panel.setLayout(null);   //set the layout

		// creates a canvas which is a blank rectangular area of the screen onto which the application can draw
		// and trap input events (Mouse and Keyboard events)
		canvas = new Canvas();
		canvas.setBounds(0, 0, WIDTH, HEIGHT);
		canvas.setIgnoreRepaint(true);

		///step 2: add key listener to canvas as this
		canvas.addKeyListener(this);

		panel.add(canvas);  // adds the canvas to the panel.

		// frame operations
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //makes the frame close and exit nicely
		frame.pack();  //adjusts the frame and its contents so the sizes are at their default or larger
		frame.setResizable(false);   //makes it so the frame cannot be resized
		frame.setVisible(true);      //IMPORTANT!!!  if the frame is not set to visible it will not appear on the screen!

		// sets up things so the screen displays images nicely.
		canvas.createBufferStrategy(2);
		bufferStrategy = canvas.getBufferStrategy();
		canvas.requestFocus();
		System.out.println("DONE graphic setup");

	}


	//paints things on the screen using bufferStrategy
	private void render() {
		Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
		g.clearRect(0, 0, WIDTH, HEIGHT);

		//draw the image of the astronaut
		g.drawImage(DVDPic, astro.xpos, astro.ypos, astro.width, astro.height, null);


		//step 4: render astro array
		for(int z=0; z<space_station.length; z++){
			g.drawImage(DVDPic, space_station[z].xpos, space_station[z].ypos, space_station[z].width, space_station[z].height, null);

		}
		g.dispose();

		bufferStrategy.show();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		//dont use we dont know what it does
	}

	@Override
	public void keyPressed(KeyEvent e) {

		//System.out.println("pressed?");
		//System.out.println(e.getKeyChar());
		System.out.println(e.getKeyCode());
		//up: 38
		if (e.getKeyCode() == 38) {
			System.out.println("Up");
			astro.isUp = true;
		}
		//left: 37
		if (e.getKeyCode() == 37) {
			System.out.println("left");
			astro.isLeft = true;
		}
		//right: 39
		if (e.getKeyCode() == 39) {
			System.out.println("right");
			astro.isRight = true;
		}
		//down: 40
		if (e.getKeyCode() == 40) {
			System.out.println("down");
			astro.isDown = true;


//			//up: W
//			if (e.getKeyCode() == 87) {
//				System.out.println("Up");
//				astro.isUp = true;
//			}
//			//left: 37
//			if (e.getKeyCode() == 65) {
//				System.out.println("left");
//				astro.isLeft = true;
//			}
//			//right: 39
//			if (e.getKeyCode() == 68) {
//				System.out.println("right");
//				astro.isRight = true;
//			}
//			//down: 40
//			if (e.getKeyCode() == 83) {
//				System.out.println("down");
//				astro.isDown = true;
			}
		}


		@Override
		public void keyReleased (KeyEvent e){
			if (e.getKeyCode() == 38) {
				System.out.println("Up");
				astro.isUp = false;

			}
			//left: 37
			if (e.getKeyCode() == 37) {
				System.out.println("left");
				astro.isLeft = false;
			}
			//right: 39
			if (e.getKeyCode() == 39) {
				System.out.println("right");
				astro.isRight = false;
			}
			//down: 40
			if (e.getKeyCode() == 40) {
				System.out.println("down");
				astro.isDown = false;
			}



		}
		///step 3: add method, keyReleased,keyPressed, and keyTyped
	}

