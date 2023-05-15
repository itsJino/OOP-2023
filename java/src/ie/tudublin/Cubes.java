package ie.tudublin;

import processing.core.PApplet;
import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;

public class Cubes extends PApplet {
    Minim minim;
    AudioPlayer ap;
    AudioInput ai;
    AudioBuffer ab;

    float ellipseWidth = 0;
    float smoothedWidth = 0;

    public void settings() {
        size(1024, 800, P3D);
    }

    public void setup() {
        background(0);

        minim = new Minim(this);
        ap = minim.loadFile("verse2.mp3", 1024);
        ap.play();
        ab = ap.mix;
        colorMode(HSB);

        for (int i = 0; i < numCircles; i++) {
            circleX[i] = random(-100, 1000);
            circleY[i] = random(-800, 800);
            circleZ[i] = random(-1000, 1000);
        }
    }

    float smoothedAmplitude = 0;

    float lerpedBuffer[] = new float[1024];
    float average = 0;
    float sum;

    int numCircles = 30;
    float[] circleX = new float[numCircles];
    float[] circleY = new float[numCircles];
    float[] circleZ = new float[numCircles];

    public void draw() {
        background(0);
        stroke(255);
        for (int i = 0; i < ab.size(); i++) {
            sum += abs(ab.get(i));

            lerpedBuffer[i] = lerp(lerpedBuffer[i], ab.get(i), 0.1f);
        }
        average = sum / (float) ab.size();

        smoothedAmplitude = lerp(smoothedAmplitude, average, 0.1f);

        ellipseWidth = map(smoothedAmplitude, 0, 1, 0, 100);

        beginShape();
        noFill();
        for (int i = 0; i < ab.size(); i++) {
            float c = map(i, 0, ab.size(), 0, 255);

            stroke(c, 255, 255);

            float f = lerpedBuffer[i] * 200 * 2;

            float angle = map(i, 0, ab.size(), 0, TWO_PI);

            float x = width / 2 + cos(angle) * (200 + f);

            float y = height / 2 + sin(angle) * (200 + f);

            vertex(x, y);
        }
        endShape();

        // draw a semi circle instead
        beginShape();
        noFill();
        for (int i = 0; i < ab.size(); i++) {
            float c = map(i, 0, ab.size(), 0, 255);

            stroke(c, 255, 255);

            float f = lerpedBuffer[i] * 200 * 2;

            float angle = map(i, 0, ab.size(), 0, PI);

            float x = width / 2 + cos(angle) * (200 + f);

            float y = height / 2 + sin(angle) * (200 + f);

            vertex(x, y);
        }

        translate(width / 2, height / 2);
        rotateY(frameCount * 0.01f);

        for (int i = 0; i < numCircles; i++) {
            pushMatrix();
            translate(circleX[i], circleY[i], circleZ[i]);
            rotateY(frameCount * 0.01f);
            rotateX(frameCount * 0.01f);
            sphere(200);
            popMatrix();
        }

    }
}
