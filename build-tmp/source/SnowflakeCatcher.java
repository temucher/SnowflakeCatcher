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

public class SnowflakeCatcher extends PApplet {

Snowflake [] fall;
public void setup()
{
  size(500,500);
  background(0);
  fall = new Snowflake[200];
  for(int i = 0; i<fall.length;i++)
  {
    fall[i]=new Snowflake();
  }
}
public void draw()
{
  // background(0);
  for(int i = 0; i<fall.length;i++)
  {   
    fall[i].touchingCatcher();
    fall[i].erase();
    fall[i].show();
    fall[i].move();
    fall[i].wrap();
  }
}
public void mouseDragged()
{ 
  if(mouseButton==LEFT)
  {
    fill(255,0,0);
    noStroke();
    ellipse(mouseX,mouseY,20,20);
  }
  if(mouseButton==RIGHT)
  {
    fill(0);
    noStroke();
    ellipse(mouseX,mouseY,30,30);
  }
}
class Snowflake
{//class member variable declarations
  boolean isMoving;
  int x, y, z, snowflakeSize;
  Snowflake()
  { //class member variable initializations
    y=(int)(Math.random()*500-500);
    x=(int)(Math.random()*500);
    z=(int)(Math.random()*4);
    if(z<=2)
    {
      snowflakeSize=6;
    }
    else 
    {
      snowflakeSize=10;
    }
    isMoving = true;
  } 
  public void touchingCatcher()
  {
    if(get(x+12,y)==color(255,0,0))
    {
      stroke(0);
      fill(0); 
      ellipse(x,y-z,snowflakeSize+1,snowflakeSize+1);
      x-=5;
    }
    if(get(x-12,y)==color(255,0,0))
    {
      stroke(0);
      fill(0); 
      ellipse(x,y-z,snowflakeSize+1,snowflakeSize+1);
      x+=10;
    }
    if ((get(x, y+12)==color(255,0,0)))
    {
      isMoving=false;
    }
    else
    {
      isMoving=true;
    }
  }
  public void show()
  {//draws the snowflake 
    noStroke();
    fill(255);
    ellipse(x,y,snowflakeSize,snowflakeSize);
  }
  public void erase()
  { //covers up the snowflake
    stroke(0);
    fill(0); 
    ellipse(x,y-z,snowflakeSize+1,snowflakeSize+1);
  }
  public void move()
  {//moves the snowflake
    if(isMoving==true)
    {
      y+=z;
    }
  }
  public void wrap()
  {//resets the snowflake if it moves off the screen
    if(y>515)
    {
      y=(int)(Math.random()*500-500);
      x=(int)(Math.random()*500);
      isMoving=true; 
    }
  }
}


  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "SnowflakeCatcher" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
