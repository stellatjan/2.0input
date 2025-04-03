import java.awt.*;

/**
 * Created by chales on 11/6/2017.
 */
public class Astronaut {

    //VARIABLE DECLARATION SECTION
    //here's where you state which variables you are going to use.
    public String name;                //holds the name of the hero
    public int xpos;                //the x position
    public int ypos;                //the y position
    public int dx;                    //the speed of the hero in the x direction
    public int dy;                    //the speed of the hero in the y direction
    public int width;
    public int height;
    public boolean isAlive;//a boolean to denote if the hero is alive or dead.
    public boolean isUp;
    public boolean isDown;
    public boolean isLeft;
    public boolean isRight;


    // METHOD DEFINITION SECTION

    // Constructor Definition
    // A constructor builds the object when called and sets variable values.


    //This is a SECOND constructor that takes 3 parameters.  This allows us to specify the hero's name and position when we build it.
    // if you put in a String, an int and an int the program will use this constructor instead of the one above.
    public Astronaut(int pXpos, int pYpos) {
        xpos = pXpos;
        ypos = pYpos;
        dx =1;
        dy =0;
        width = 60;
        height = 60;
        isAlive = true;
        isUp=false;
        isDown=false;
        isLeft=false;
        isRight=false;
 
    } // constructor

    //The move method.  Everytime this is run (or "called") the hero's x position and y position change by dx and dy
    public void move() {
            int speed = 5;
            dx = 0;
            dy = 0;

            if (isUp) dy -= speed;
            if (isDown) dy += speed;
            if (isLeft) dx -= speed;
            if (isRight) dx += speed;

            xpos += dx;
            ypos += dy;
        if(isUp==true){
            dy=-5;
            dx=0;
        }
        if(isDown==true){
            dy=5;
            dx=0;
        }
        if(isLeft==true){
            dy=0;
            dx=-5;
        }
        if(isRight==true){
            dy=0;
            dx=5;
        }
        xpos = xpos + dx;
        ypos = ypos + dy;

 
    }
}






