package ie.tudublin;

public class Main
{

	public static void helloProcessing()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new HelloProcessing());
    }

	public static void loops()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new Loops());
    }

	public static void bugZap()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new BugZap());
    }

	public static void starMap()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new StarMap());
    }

	public static void audio1()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new Audio1());
    }

	public static void audio2()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new Audio2());
    }

	public static void audio3()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new Audio3());
    }

	public static void life()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new Life());
    }

	public static void scene1()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new Scene1());
    }

	public static void scene3()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new Scene3());
    }

	public static void particle()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new Particle());
    }

	public static void particlescene()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new ParticleScene());
    }

	public static void cubes()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new Cubes());
    }

	public static void spirals()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new Spirals());
    }

	public static void sunslit()
	{
		String[] a = {"MAIN"};
		processing.core.PApplet.runSketch( a, new SunSlit());
	}

	public static void main(String[] args)
	{
		System.out.println("Hello world");
		
		Dog penny = new Dog();
		penny.setName("Penny");
		penny.speak();

		sunslit();
	}
	
}