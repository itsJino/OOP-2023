package ie.tudublin;

import processing.core.PApplet;

public class ParticleScene extends PApplet {
    //public void settings() {
    //    size(1024, 800);
//
    //}
//
    //public void setup() {
    //    background(0);
    //    noStroke();
//
    //}
//
    //int numParticles = 400;
//
    //public void createParticles(int x, int y, float radius, int color) {
    //    fill(200);
    //    ellipse(x, y, radius, radius);
    //}
//
    //float angleIncrement = TWO_PI / numParticles;
//
    //float xoff = (float)0.0;
    //float xincrement = (float)0.01; 
//
    //public void draw() {
    //    fill(0, 10);
    //    rect(0,0,width,height);
//
    //    float n = noise(xoff) * width;
//
    //    xoff += xincrement;
//
    //    ellipse(n,height/2, 64, 64);
    //    
    //    
    //    
    //}

    /**
 * Noise1D. 
 * 
 * Using 1D Perlin Noise to assign location. 
 */
 
float xoff = (float)0.0;
float xincrement = (float)0.01; 

public void settings() {
    size(1240, 800);
}

public void setup() {
  background(0);
  noStroke();
}

float m = 0;
    float c = 8;

  

public void star2() {
    c = 8;
    double angle = m * 137.5;
    double radius = c * sqrt(m);
    double x = radius * cos((float)angle) + width/2 + 170;
    double y = radius * sin((float)angle) + height/2 - 150;
    fill(200);
    ellipse((float)x,(float)y,9,6);
    m++;
}

public void draw() {
  // Create an alpha blended background
  fill(0, 10);
  rect(0,0,width,height);
  
  float n = random(0,width);  // Try this line instead of noise
  
  // Get a noise value based on xoff and scale it according to the window's width
  // float n = noise(xoff)*width;
  
  // With each cycle, increment xoff
  xoff += xincrement;
  
  // Draw the ellipse at the value produced by perlin noise

  
  double angle = m * 137.5;
  double radius = c * sqrt(m);
    double x = radius * cos((float)angle) + width/2 ;
    double y = radius * sin((float)angle) + height/2 ;

  fill(255,255,0);
  ellipse((float)x,(float)y, 64, 64);

  m++;
}
    
}
