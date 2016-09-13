import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Picker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Picker extends Alien
{
    /**
     * Act - do whatever the Picker wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    Message m = new Message();
    //GumballMachine gm = new GumballMachine();
    //gm.selectPicker(); 
    
    
    public void moveTo(int x, int y)
    {//move the picker  to  location
        setLocation(x,y);
    }
    
    public void pick(){
    }
    
    
}
