//Teagan Mucher, Block 4 AP CS, "Snowflake Catcher"

Snowflake [] fall;
void setup()
{
  size(500,500);
  background(0);
  fall = new Snowflake[200];
  for(int i = 0; i<fall.length;i++)
  {
    fall[i]=new Snowflake();
  }
}
void draw()
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
void mouseDragged()
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
  void touchingCatcher()
  {
    //bounces the snowflake off the side of the catcher
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
    //catches the snowflake
    if ((get(x, y+12)==color(255,0,0)))
    {
      isMoving=false;
    }
    else
    {
      isMoving=true;
    }
  }
  void show()
  {//draws the snowflake 
    noStroke();
    fill(255);
    ellipse(x,y,snowflakeSize,snowflakeSize);
  }
  void erase()
  { //covers up the snowflake
    stroke(0);
    fill(0); 
    ellipse(x,y-z,snowflakeSize+1,snowflakeSize+1);
  }
  void move()
  {//moves the snowflake
    if(isMoving==true)
    {
      y+=z;
    }
  }
  void wrap()
  {//resets the snowflake if it moves off the screen
    if(y>515)
    {
      y=(int)(Math.random()*500-500);
      x=(int)(Math.random()*500);
      isMoving=true; 
    }
  }
}


