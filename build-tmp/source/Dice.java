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

public class Dice extends PApplet {

int total;

Die bob = new Die();

public void setup() {
  size(500, 500);
  noStroke();
  textAlign(CENTER,CENTER);
  ellipseMode(CORNERS); //helps out with copying from gimp
  noLoop();
}

public void draw() {
  background(random(255), random(255), random(255));
  
  for (int x=bob.wh/2; x<width; x+=50) {
    for (int y=bob.wh/2; y<height-bob.wh*2; y+=50) {
      bob = new Die(x, y);
      bob.show();
      total += bob.value;
    }
  }
  
  textSize(50);
  text("Total: " + total, 250, 464);
  //total = 0;
}

public void mousePressed() {
  redraw();
  total = 0;
}

class Die {
  int x, y, value;

  int wh = 25;
  int r = 6;

  Die() {
  }

  Die(int x, int y) {
    this.x = x;
    this.y = y;
    value = (int)(Math.random()*6)+1;
  }

  public void show() {
    fill(random(255), random(255), random(255));
    rect(x, y, wh, wh, r);

    fill(255, 255, 255);
    if (value == 1) {
      ellipse(x+10, y+10, x+15, y+15);
    } else if (value == 2) {
      ellipse(x+5, y+5, x+10, y+10);
      ellipse(x+15, y+15, x+20, y+20);
    } else if (value == 3) {
      ellipse(x+10, y+10, x+15, y+15);
      ellipse(x+5, y+5, x+10, y+10);
      ellipse(x+15, y+15, x+20, y+20);
    } else if (value == 4) {
      ellipse(x+10, y+10, x+15, y+15);
      ellipse(x+5, y+5, x+10, y+10);
      ellipse(x+15, y+5, x+20, y+10);
      ellipse(x+15, y+15, x+20, y+20);
      ellipse(x+5, y+15, x+10, y+20);
    } else if (value == 5) {
      ellipse(x+10, y+10, x+15, y+15);
      ellipse(x+5, y+5, x+10, y+10);
      ellipse(x+15, y+5, x+20, y+10);
      ellipse(x+15, y+15, x+20, y+20);
      ellipse(x+5, y+15, x+10, y+20);
    } else if (value == 6) {
      ellipse(x+5, y+5, x+10, y+10);
      ellipse(x+15, y+5, x+20, y+10);
      ellipse(x+15, y+15, x+20, y+20);
      ellipse(x+5, y+15, x+10, y+20);
      ellipse(x+5, y+10, x+10, y+15);
      ellipse(x+15, y+10, x+20, y+15);
    }
  }
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Dice" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
