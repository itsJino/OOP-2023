package ie.tudublin;

import ddf.minim.AudioBuffer;
// import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import ddf.minim.analysis.FFT;
import processing.core.PApplet;

public class Spirals extends PApplet
{

    Minim minim;
    AudioInput ai;
    AudioPlayer ap;
    AudioBuffer ab;

    FFT fft;

    int numSphere = 20;
    float[] sphereX = new float[numSphere];
    float[] sphereY = new float[numSphere];

    public void settings()
    {
        size(1920, 1080, P3D);
    }

    public void setup()
    {
        colorMode(RGB);
        background(0);
        minim = new Minim(this);
        ap = minim.loadFile("bridge.mp3", 1024);
        ap.play();
        ab = ap.mix;
    }

    float lerpedBuffer[] = new float[1024];

    float smoothedAmplitude = 0;
    float halfWidth = width / 2;
    float halfHeight = height / 2;
    float flying;
    public void draw()
    {
        background(0);
        colorMode(HSB);
        stroke(255);
        float average = 0;
        float sum = 0;;
        for (int i = 0; i < ab.size(); i++) {
            sum += abs(ab.get(i));
            lerpedBuffer[i] = lerp(lerpedBuffer[i], ab.get(i), 0.1f);
        }
        average = sum / (float) ab.size();
        smoothedAmplitude = lerp(smoothedAmplitude, average, 0.1f);
    
        flying -= 0.5f;

        float zoff = flying;
        beginShape();
        noFill();
        stroke(255);

        // draw a circle using sin and cos using a loop
        for (int i = 0; i < 50000; i++) {
            float angle = map(i, 0, 30, 0, TWO_PI);
            float r = 90;
            float x = 960 +  r * cos(angle);
            float y = 540 + r * sin(angle);
            vertex(x,y, i);
        }
        endShape();

        camera(width/2.0f, height/2.0f, zoff, width/2.0f, height/2.0f, 0f, 0f, 1f, 1f);    
        // camera(width/2.0f, height/2.0f, (height/2.0f) / tan(PI*30.0f / 180.0f), width/2.0f, height/2.0f, 0f, 0f, 1f, 1f);    
    }
}

// (height/2.0f) / tan(PI*30.0 / 180.0f)

