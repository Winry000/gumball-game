import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class Inspector here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Inspector extends Alien
{
    /**
     * Act - do whatever the Inspector wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    Message m = new Message();
    Coin haveCoin = null;
    
    public void moveTo(int x,int y)
	{//move	the	picker	to	location
		setLocation(x,y);
	}
    
	private ArrayList<Picker> pickers = new ArrayList<Picker>();
	
	public void addPicker(Picker obj){
	    pickers.add(obj);
	}
	public void removePicker(Picker obj){
	    pickers.remove(obj);
	}

}
