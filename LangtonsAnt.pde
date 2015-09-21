/*
  1
4   2
  3
*/

Rectangle rect2 = new Rectangle(-100, 0);
Ant ant2;
ArrayList<Rectangle> rects = new ArrayList<Rectangle>();

void setup() {
  size(800, 800);
  noStroke();
  for (int y = 0; y < height; y += rect2.wh) {
    for (int x = 0; x < width; x += rect2.wh) {
      rects.add(new Rectangle(x, y));
    }
  }
  ant2 = new Ant(width/2, height/2);
}

void draw() {
  ant2.display(); //just for rect to check for ant

  for (int i = 0; i < rects.size(); i ++) {
    Rectangle rectPlaceHolder = rects.get(i);
    rectPlaceHolder.moveAnt();
    rectPlaceHolder.display();
  }
  
  ant2.move();
  ant2.display();
}

class Rectangle {
  int x, y;
  int wh = 10; //widthHeight
  color myColor = color(100); //myColor is for filled color
  color defaultColor = myColor; //this is for blank (myColor is initialized blank but changes immediately)
  
  Rectangle(int tempX, int tempY) {
    x = tempX;
    y = tempY;
  }

  void moveAnt() {
    if (get(x+wh/2, y+wh/2) == ant.myColor) {
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

  void test() {
    if (get(x+wh/2, y+wh/2) == ant.myColor) {
    }
  }
  void display() {
    fill(myColor);
    rect(x, y, wh, wh);
  }
}

class Ant {
  int x, y, dir;
  int wh = 10;
  color myColor = color(255, 0, 0);

  Ant(int tempX, int tempY) {
    x = tempX;
    y = tempY;
    dir = 1;
  }

  void move() {
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


  void display() {
    fill(myColor);
    rect(x, y, wh, wh);
  }
}
