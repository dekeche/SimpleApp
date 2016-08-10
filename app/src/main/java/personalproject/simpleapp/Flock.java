package personalproject.simpleapp;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import java.util.ArrayList;

/**
 * Created by Jesse on 8/6/2016.
 */
public class Flock {

    private ArrayList<Boid> boids;
    private double height;
    private double width;
    private double v;
    FlockData data;
    Flock()
    {
        boids = new ArrayList<>();
    }
    public void setBorder(double height, double width, FlockData data)
    {
        this.height = height;
        this.width = width;
        this.data = data;
    }
    public void update()
    {
        for(Boid b : boids)
        {
            b.update(boids);
        }
    }
    public void render(Canvas c)
    {
        for(Boid b : boids)
        {
            b.render(c);
        }
    }
    public void addBoid()
    {
        boids.add(new Boid(width,height,data));
    }
}
