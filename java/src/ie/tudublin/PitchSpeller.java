package ie.tudublin;

import processing.core.PApplet;
import java.util.*;
import java.lang.Math;

public class PitchSpeller extends PApplet 
{
    public String spell(float frequency)
    {
        float difference = 1000;
        float closest = 0;

        float[] frequencies = { 293.66f, 329.63f, 369.99f, 392.00f, 440.00f, 493.88f, 554.37f, 587.33f, 659.25f, 739.99f, 783.99f, 880.00f, 987.77f, 1108.73f, 1174.66f };
        String[] spellings = { "D,", "E,", "F,", "G,", "A,", "B,", "C", "D", "E", "F", "G", "A", "B", "c", "d", "e", "f", "g", "a", "b", "c'", "d'", "e'", "f'", "g'", "a'", "b'", "c''", "d''" };

        Dictionary<Float, String> dict = new Hashtable<Float, String>();

        for(int i = 0; i < frequencies.length; i++)
        {
            dict.put(abs(frequencies[i]), spellings[i]);
        }


        for(int j = 0; j < frequencies.length; j++)
        {
            if(abs(frequency - frequencies[j]) < difference)
            {
                difference = frequency - frequencies[j];
                closest = frequencies[j];
            }
        }

        return dict.get(closest);
    
    }
}
