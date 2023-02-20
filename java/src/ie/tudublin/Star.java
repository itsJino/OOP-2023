package ie.tudublin;

import java.util.ArrayList;
import java.util.List;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class Star extends PApplet
{
    public boolean hab;
    public String displayName;
    public float distance;
    public float xG;
    public float yG;
    public float zG;
    public float absMag;
    List<Star> stars = new ArrayList<Star>();

    public void settings()
	{
		size(500, 500);
        loadStars();
	}

	public void setup() {
		colorMode(HSB);
		background(0);

		smooth();
		
	}

	public void drawGrid()
	{
		stroke(100, 200, 255, 255);
		int i;

		int gridWidth = 440;
		int gap = gridWidth / 11;

		for(i = 0; i < gridWidth; i+=gap)
		{
			line(gap + i, gap, gap + i, gridWidth);
			line(gap, gap + i, gridWidth, gap + i);
		}
		
	}

    public void drawStars()
    {
        stroke(12312);
    }

		
	public void draw()
	{	
		strokeWeight(2);	
		
		drawGrid();
        drawStars();
	}

    void loadStars()
 	{
 		Table table = loadTable("HabHYG15ly.csv", "header");
 		for(TableRow r:table.rows())
 		{
            Star s = new Star(r);
 			stars.add(s);
 		}
 	}

    public Star()
    {

    }

    public Star(TableRow tr)
 	{
 		this(
 			tr.getInt("Hab?") == 1, 
 			tr.getString("Display Name"), 
 			tr.getFloat("Distance"),
 			tr.getFloat("Xg"),
 			tr.getFloat("Yg"),
 			tr.getFloat("Zg"),
 			tr.getFloat("AbsMag")
 		);
 	}
 	
 	public Star(boolean hab, String displayName, float distance, float xG, float yG, float zG, float absMag) 
    {
 		this.hab = hab;
 		this.displayName = displayName;
 		this.distance = distance;
 		this.xG = xG;
 		this.yG = yG;
 		this.zG = zG;
 		this.absMag = absMag;
 	}

} 