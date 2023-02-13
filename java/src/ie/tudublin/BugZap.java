package ie.tudublin;

import processing.core.PApplet;

public class BugZap extends PApplet
{
	float playerX, playerY, playerWidth;
	float bugX1, bugY1, bugX2, bugY2, bugX3, bugY3, bugWidth;

	float halfPlayer, halfBug;

	public void settings()
	{
		size(1920, 1080);
	}

	public void setup() {
		colorMode(HSB);
		background(0);
		smooth();

		playerX = width * 0.5f;
		playerY = height - 100;
		playerWidth = 50;
		halfPlayer = playerWidth * 0.5f;

		resetBug();
	}

	void resetBug()
	{
		bugX1 = random(width);
		bugY1 = 50;

		bugX2 = bugX1 - 20;
		bugY2 = 30;

		bugX3 = bugX1 + 20;
		bugY3 = 30;

	}

	void drawPlayer(float x, float y, float w) 
	{
		noFill();
		stroke(255);
		rectMode(CENTER);
		rect(x, y, w, w);
		line(x, y - halfPlayer, x, y - halfPlayer * 2);
	}

	void drawBug(float x1, float y1, float x2, float y2, float x3, float y3) 
	{
		noFill();
		stroke(255);
		
		triangle(x1,y1,x2,y2,x3,y3);
		
	}

	void moveBug(float x1, float y1, float y2, float y3)
	{
		float randDirection = random(1, 10);

		if(randDirection > 5)
		{
			bugX1 = x1 + random(10,20);
			bugY1 = y1 + 20;

			bugX2 = bugX1 - 20;
			bugY2 = y2 + 20;

			bugX3 = bugX1 + 20;
			bugY3 = y3 + 20;
		}
		else if(randDirection < 5)
		{
			bugX1 = x1 - random(10, 20);
			bugY1 = y1 + 20;

			bugX2 = bugX1 - 20;
			bugY2 = y2 + 20;

			bugX3 = bugX1 + 20;
			bugY3 = y3 + 20;
		}
	
	}

	public void keyPressed() // polymorphism: the type is of the superclass but the instance is of the subclass
	{
		if(keyCode == LEFT)
		{
			playerX -=10;
		}

		if(keyCode == RIGHT)
		{
			playerX +=10;
		}

		if(key == ' ')
		{
			line(playerX, playerY - halfPlayer, playerX, 0);
		}

	}
	
	public void draw()
	{	
		background(0);
		drawPlayer(playerX, playerY, playerWidth);
		drawBug(bugX1, bugY1, bugX2, bugY2, bugX3, bugY3);


		if ((frameCount % 60) == 0)
		{
			moveBug(bugX1, bugY1, bugY2, bugY3);
		}
		
	}
}
