package ie.tudublin;

public class Main
{

	public static void helloProcessing()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new HelloProcessing());
    }
	
	public static void main(String[] args)
	{
		System.out.println("Hello world");
		
		Cat penny = new Cat();
		penny.setName("Penny");
		penny.setnumLives(9);
		penny.speak();

		helloProcessing();

		while(penny.getnumLives() > 0)
		{
			penny.kill();
		}
	}
}