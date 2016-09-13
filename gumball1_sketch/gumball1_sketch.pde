 Button button;
 Button button1;
 GumballMachine gumballMachine = new GumballMachine(5);
 boolean InsertBeenClicked = false;
 boolean CrankBeenTurned = false;
 String s;
 
void setup() {
  size(800, 800);
  background(255);
  smooth() ;
  strokeWeight(3);
  strokeCap(ROUND);
  
  // load font
  PFont font;
  font = loadFont("BookAntiqua-48.vlw");
  textFont(font, 32);

  // Only draw once
  noLoop();
  
  //load button
  textFont(font, 20);
  button = new Button(50, 100, "Insert Quarter");
  button1 = new Button(50, 200, "Turn Crank");
}



void draw() {
  fill(0);  
  text("The Gumball Machine", 250, 60);
  PImage image = loadImage("gumball.jpg");
  image(image, (width-image.width)/2, (height-image.height)/2);  
  //runTest();
  
  //
  s = gumballMachine.toString();
  text(s,550,530);
  if(InsertBeenClicked){
    text("22222", 250, 230);
  }
  
  if(CrankBeenTurned){
    text("11111", 250, 230);
  }
  
  //button
  button.draw();
  button1.draw();
  

}


void mousePressed(){
  if(button.over()){
    InsertBeenClicked = ! InsertBeenClicked;
    gumballMachine.insertQuarter();
  }
   if(button1.over()){
    gumballMachine.turnCrank();
    System.out.println(gumballMachine);
    CrankBeenTurned = ! CrankBeenTurned;
    
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
  void draw(){
    fill(255);
    if(over()){
    fill(100);
    }
    rect(x, y, textWidth(label), 30);
    fill(0);
    text(label, x, y + 20);
  }
  boolean over(){
    if(mouseX >= x && mouseY >= y && mouseX <= x + textWidth(label) && mouseY <= y + 22){
    return true;
    }
    return false;
  }
  
}


/*public void runTest() {
  GumballMachine gumballMachine = new GumballMachine(5);
  System.out.println(gumballMachine);
  
  /*gumballMachine.insertQuarter();
  gumballMachine.turnCrank();
  System.out.println(gumballMachine);
  gumballMachine.insertQuarter();
  gumballMachine.turnCrank();
  gumballMachine.insertQuarter();
  gumballMachine.turnCrank();
  System.out.println(gumballMachine);
}*/