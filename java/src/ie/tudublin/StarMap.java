package ie.tudublin;

import processing.core.PApplet;

public class StarMap extends PApplet
{
	public void settings()
	{
		size(800, 800);

	}

	public void setup() {
		colorMode(HSB);
		background(0);
		smooth();
		
	}

	public void drawGrid()
	{
		stroke(255);
		int i;

		int gridWidth = 770;
		int gap = gridWidth / 11;

		for(i = 0; i < gridWidth; i+=gap)
		{
			line(gap + i, gap, gap + i, gridWidth);
			line(gap, gap + i, gridWidth, gap + i);
		}
		
	}

	public void draw()
	{	
		strokeWeight(2);	
		
		drawGrid();
	}
}
