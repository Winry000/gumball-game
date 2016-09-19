
 Button button1;
 Button button2;
 GumballMachine gumballMachine = new GumballMachine(5);
 boolean InsertBeenClicked = false;
 boolean CrankBeenTurned = false;
 String s;
 color button1color = 255;
 
void setup() {
  size(800, 800);
  smooth() ;
  strokeWeight(3);
  strokeCap(ROUND);
  
  // load font
  PFont font;
  font = loadFont("BookAntiqua-48.vlw");
  textFont(font, 32);

  // Only draw once
  //noLoop();
  
  //load button
  textFont(font, 20);
  button1 = new Button(50, 100, "Insert Quarter");
  button2 = new Button(50, 200, "Turn Crank");
}



void draw() {
  background(255);
  fill(0);  
  text("The Gumball Machine", 250, 60);
  PImage image = loadImage("gumball.jpg");
  image(image, (width-image.width)/2, (height-image.height)/2);  
  //runTest();
  
  //test change
  s = gumballMachine.toString();
  text(s,25,530);
  if(InsertBeenClicked){
    text(s,25,530);
  }
  
  if(CrankBeenTurned){
    text(s,25,530);
  }
  

  //button
  button1.clickdraw();
  button2.clickdraw();
}



 void mousePressed(){
  if(button1.over()){
    button1color = 0;
    InsertBeenClicked = ! InsertBeenClicked;
    gumballMachine.insertQuarter();
  }
   if(button2.over()){
    button1color = 0;
    CrankBeenTurned = ! CrankBeenTurned;
    gumballMachine.turnCrank();
    System.out.println(gumballMachine);
   }
 }


class Button{
  int x,y;
  String label;
  
  Button(int x, int y, String label){
    this.x = x;
    this.y = y;
    this.label = label;
  }
   
  void clickdraw(){
    if (over()&&mousePressed) {
      button1color = 0;//black
      fill(0);
    } else {
      button1color = 255;
      fill(button1color); 
        if(over()){
          fill(200);
      }
      rect(x, y, textWidth(label), 25);
      fill(0);
      text(label, x, y + 20);
    }
  }

  
  boolean over(){
    if(mouseX >= x && mouseY >= y && mouseX <= x + textWidth(label) && mouseY <= y + 22){
    return true;
    }
    return false;
  }
  
}


  