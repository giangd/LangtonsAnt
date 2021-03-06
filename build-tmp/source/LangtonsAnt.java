import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class LangtonsAnt extends PApplet {

/*
  1
4   2
  3
*/

Rectangle rect2 = new Rectangle(-100, 0);
Ant ant;
ArrayList<Rectangle> rects = new ArrayList<Rectangle>();

public void setup() {
  size(680, 480); //has to be even and divisible by 10 (width/2 and rectangle height)
  noStroke();
  for (int y = 0; y < height; y += rect2.wh) {
    for (int x = 0; x < width; x += rect2.wh) {
      rects.add(new Rectangle(x, y));
    }
  }
  ant = new Ant(width/2, height/2);
  frameRate(800);
}

public void draw() {
  background(0);
  ant.display(); //just for rect to check for ant

  for (int i = 0; i < rects.size(); i ++) {
    Rectangle rectPlaceHolder = rects.get(i);
    rectPlaceHolder.moveAnt();
    rectPlaceHolder.display();
  }
  
  ant.move();
  ant.display();
  println(frameRate);
}

public void keyPressed() {
  for (int i = rects.size()-1; i >= 0; i --) {
    rects.remove(i);
  }
  ant = new Ant(width/2, height/2);
  for (int y = 0; y < height; y += rect2.wh) {
    for (int x = 0; x < width; x += rect2.wh) {
      rects.add(new Rectangle(x, y));
    }
  }
  
}

class Rectangle {
  int x, y;
  int wh = 10; //widthHeight
  int myColor = color(100); //myColor is for filled color
  int defaultColor = myColor; //this is for blank (myColor is initialized blank but changes immediately)
  
  Rectangle(int tempX, int tempY) {
    x = tempX;
    y = tempY;
  }

  public void moveAnt() {
    if (dist(x,y,ant.x,ant.y) == 0) {
      //println(dist(x,y,ant.x,ant.y));
      if (myColor == defaultColor) {
        ant.dir += 1;
        //myColor = color(random(255),random(255),random(255));
        myColor = color(0);
      } else {
        ant.dir -= 1;
        myColor = defaultColor;
      }
      if (ant.dir == 5) {
       ant.dir = 1;
      } else if (ant.dir == 0) {
       ant.dir = 4;
      }
    }
  }

  public void display() {
    fill(myColor);
    rect(x, y, wh, wh);
  }
}

class Ant {
  int x, y, dir;
  int wh = 10;
  int myColor = color(255);

  Ant(int tempX, int tempY) {
    x = tempX;
    y = tempY;
    dir = 1;
  }

  public void move() {
    if (dir == 1) {
      y -= wh;
    } else if (dir == 2) {
      x += wh;
    } else if (dir == 3) {
      y += wh;
    } else if (dir == 4) {
      x -= wh;
    }
  }


  public void display() {
    fill(myColor);
    rect(x, y, wh, wh);
  }
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "LangtonsAnt" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
