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
    Message m = new Message();   
    Coin haveCoin = null;
    
    public GumballMachine()
    {
        GreenfootImage image = getImage() ; //set image
        image.scale( 350, 400 ) ; 
    }
    
    public void selectPicker(){
        int pickerN = Greenfoot.getRandomNumber(2);
        World world = getWorld();
        List<GreenPicker> gPk = world.getObjects(GreenPicker.class);
        List<RandomPicker> rPk = world.getObjects(RandomPicker.class);
        if(pickerN == 1){
            Picker picker = gPk.remove(0);
            Greenfoot.delay(100);
            setMessage("Green Picker");
            picker.moveTo(669-200,456-60);
            Greenfoot.delay(100);
            picker.pick();
            Greenfoot.delay(100);
            picker.moveTo(669,456);
        }else{
            //random picker
            Picker picker = rPk.remove(0);
            Greenfoot.delay(100);
            setMessage("Random Picker");
            picker.moveTo(655-200,94+60);
            Greenfoot.delay(100);
            picker.pick();//random select the gumball
            Greenfoot.delay(100);
            picker.moveTo(655,94);
        }
        
        //what to do afterward
        cleanUp();
        
    }
    
    public void cleanUp(){
        World world = getWorld();
        if(m.getWorld() != null){ 
            world.removeObject(m);
        }
        List<Gumball> gb = world.getObjects(Gumball.class);
        for(Gumball a: gb){
            world.removeObject(a);   //remove gumball
        }
    }
    
    public void setMessage(String msg)
    {
        int mouseX, mouseY;
        MouseInfo mouse = Greenfoot.getMouseInfo();
        mouseX = mouse.getX();
        mouseY = mouse.getY();
        World world = getWorld();
        if(m.getWorld() != null){
            world.removeObject(m);
        }
        world.addObject(m,mouseX,mouseY);
        m.setText(msg);
    }
    
    public void act() 
    {

        Actor coin = getOneObjectAtOffset(+10,+10,Coin.class); //get the coin offset
        if ( coin != null )
        {
            if(haveCoin != null){
                coin.move(-300);
            }
            else
            {
              haveCoin = (Coin)coin;
              setMessage("Have Coin!Turn Crank!");
              insertCoin(coin); 
            }
        }
        
        if(Greenfoot.mousePressed(this)){
            if(haveCoin == null)
            setMessage("No Coin in Slot!");
            else{
                 setMessage("Crank Turned!");
                 Greenfoot.delay(100);
                 moveInspector(533-80,300-50);
                 setMessage("Check Coin!");
                 Greenfoot.delay(100);
                 checkCoin(haveCoin);
            }
            // what to do next?
        }
    }
    private void insertCoin(Actor coin){                                        
        World world = getWorld();
        world.removeObject(coin);           
    }
    public void moveInspector(int x, int y){
       Inspector inspector; 
       inspector = (Inspector)this.getOneIntersectingObject(Inspector.class);
       inspector.moveTo(x,y);
    }
    public void checkCoin(Coin coin){
        moveInspector(533,291);//ispector move back
        if(coin.isReal()){
            if(coin.getValue() == 25){
                setMessage("real quarter");
                selectPicker();
            }else if(coin.getValue() == 1){
                setMessage("Sorry, not enough");
                Greenfoot.delay(300);
                cleanUp();
            }
        }else{
                //System.out.println("fake coin loop");
                setMessage("fake quarter");
                Greenfoot.delay(300);
                cleanUp();
        }
        
        haveCoin = null;
    }
    
}

