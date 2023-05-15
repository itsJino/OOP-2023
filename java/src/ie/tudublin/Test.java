package ie.tudublin;

public class Test {
    int x;
    int y;
    float radius;
    public int getX() {
        return x;
    }

    public Test(int x, int y, float radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public Test() {
        
    }

    @Override
    public String toString() {
        return "Test []";
    }
    
}
