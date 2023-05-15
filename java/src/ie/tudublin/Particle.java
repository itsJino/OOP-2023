package ie.tudublin;

import processing.core.PApplet;

public class Particle extends PApplet {
    int x;
    int y;
    float radius;
    int color;

    public Particle(int x, int y, float radius, int color)
    {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
    }

    public Particle() {

    }

    public void drawParticle() {
        
    }
}
