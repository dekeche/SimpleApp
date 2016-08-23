package personalproject.simpleapp;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;

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
    Bitmap image;
    Flock(Bitmap drawable)
    {
        image = drawable;
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
        boids.add(new Boid(width,height,data,image));
    }
}
