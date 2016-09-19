import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class GumballMachine here.
 * 
 * @author (Qianwen Xie) 
 * @version (09-12-2016)
 */
public class GumballMachine extends Actor
{
    Message message= new Message();   
    Coin inCoin = null;
        public GumballMachine()
    {
        GreenfootImage image = getImage() ; //set image
        image.scale( 350, 400 ) ; 
    }
    
       public void checkCoin(Coin coin){
        
        moveInspector(540,291);//ispector move back
        if(coin.isReal()){
            if(coin.getValue() == 25){
                outputMessage("real quarter");
                Greenfoot.delay(50);
                selectPicker();
            }else if(coin.getValue() != 25){
                outputMessage("Sorry, not enough");
                Greenfoot.delay(100);
                World world = getWorld();
                world.removeObject(message);
            }
        }else{

                outputMessage("fake quarter");
                Greenfoot.delay(100);
                World world = getWorld();
                world.removeObject(message);
            }
        inCoin = null;
    }
    
    
    public void selectPicker(){
        int pickerN = Greenfoot.getRandomNumber(2);
        World world = getWorld();
        List<GreenPicker> greenPk = world.getObjects(GreenPicker.class);
        List<RandomPicker> randomPk = world.getObjects(RandomPicker.class);
        if(pickerN == 0){
            // select the green picker
            Picker picker = greenPk.remove(0); 
            Greenfoot.delay(60);
            outputMessage("Green Picker");
            picker.moveTo(669-200,456-60);
            Greenfoot.delay(60);
            picker.pick();
            Greenfoot.delay(60);
            picker.moveTo(669,456);
        }else{
            //select the random picker
            Picker picker = randomPk.remove(0);
            Greenfoot.delay(60);
            outputMessage("Random Picker");
            picker.moveTo(655-200,94+60);
            Greenfoot.delay(60);
            picker.pick();
            Greenfoot.delay(60);
            picker.moveTo(655,94);
        }
        world.removeObject(message);
        List<Gumball> gball = world.getObjects(Gumball.class);
        for(Gumball a: gball){
            world.removeObject(a);   //remove gumball
        }
        
    }
    
    public void outputMessage(String msg)
    {
        int mouseX, mouseY;
        MouseInfo mouse = Greenfoot.getMouseInfo();
        mouseX = mouse.getX();
        mouseY = mouse.getY();
        World world = getWorld();
        if(message.getWorld() != null){
            world.removeObject(message);
        }
        world.addObject(message,mouseX,mouseY);
        message.setText(msg);
    }
    
    public void act() 
    {
        Actor coin = getOneObjectAtOffset(+10,+10,Coin.class);
        if ( coin != null )
        {
            if(inCoin != null){
                World world = getWorld();
                world.removeObject(coin);
            }
            else{
              inCoin = (Coin)coin;
              outputMessage("Have Coin!Turn Crank!");
              insertCoin(coin); 
            }
        }
        
        if(Greenfoot.mousePressed(this)){
            if(inCoin == null)
                 outputMessage("No Coin in Slot!");
            else{
                 outputMessage("Crank Turned!");
                 Greenfoot.delay(100);
                 moveInspector(533-80,300-50);
                 outputMessage("Check Coin!");
                 Greenfoot.delay(100);
                 checkCoin(inCoin);
               }
        }
    }
    public void insertCoin(Actor coin){                                        
        World world = getWorld();
        world.removeObject(coin);           
    }
    public void moveInspector(int x, int y){
       Inspector inspector = new Inspector();
       inspector = (Inspector)this.getOneIntersectingObject(Inspector.class);
       inspector.moveTo(x,y); 
    }
 
}

