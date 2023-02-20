package ie.tudublin;

import processing.core.PApplet;

public class Loops extends PApplet {

	int mode = 0;

	public void settings() {
		size(1000, 1000);
		//fullScreen(SPAN);
	}

	public void setup() {
		colorMode(HSB);
	}

	public void keyPressed() {

		mode = key - '0';
		println(mode);
	}

	float off = 0;

	public void draw() {
		background(0);
		noStroke();

		switch (mode) {
			case 0:
				int numCircles = (int) max(1, mouseX / 50.0f);
				float d = width / numCircles;
				for (int j = 0; j < numCircles; j++) {
					for (int i = 0; i < numCircles; i++) {
						float x = (d * 0.5f) + (d * i);
						float y = (d * 0.5f) + (d * j);
						float c = ((i + j) / ((numCircles - 1) * 2.0f)) * 255.0f;
						fill((c + off) % 256, 255, 255);
						circle(x, y, d);
					}
				}
				off += (mouseY / 50.0f);
				break;
			case 1:
				float sectionWidth = width / 4;
				float sectionHeight = height / 4;
				if(mouseX < sectionWidth & mouseY < sectionHeight)
				{
					fill(255);
					rect(0, 0, sectionWidth, sectionHeight);
				}
				else if(mouseX > sectionWidth & mouseX < (sectionWidth * 2) & mouseY < sectionHeight)
				{
					fill(255);
					rect(sectionWidth, 0, sectionWidth, sectionHeight);
				}
				else if(mouseX > (sectionWidth * 2) & mouseX < (sectionWidth * 3) & mouseY < sectionHeight)
				{
					fill(255);
					rect(sectionWidth * 2, 0, sectionWidth, sectionHeight);
				}
				else if(mouseX > (sectionWidth * 3) & mouseX < (sectionWidth * 4))
				{
					fill(255);
					rect(sectionWidth * 3, 0, sectionWidth, sectionHeight);
				}
				break;
			case 2:
				int numSections = 10;
				int sectionW = width / numSections;
				float c = 0; 

				for(int i = 0; i < numSections; i++)
				{
					fill(c, 255, 255);
					c = (c + 18f) % 255;
					rect((sectionW * i), 0, sectionW, height);
				}
			default:
				break;
		}

	}
}
