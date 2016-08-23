package personalproject.simpleapp;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.ArcShape;
import android.graphics.drawable.shapes.OvalShape;

import java.util.ArrayList;
import java.util.Vector;

public class Boid {
    Vector2 location;
    Vector2 velocity;
    Vector2 acceleration;
    double angle;
    double borderH;
    double borderW;
    double maxForce;
    double maxSpeed;
    FlockData data;
    Paint color;
    Bitmap image;
    Matrix position;

    Boid(double x, double y, FlockData data, Bitmap image)
    {
        borderH = y;
        borderW = x;
        angle = 2*Math.PI * Math.random();
        velocity = new Vector2(Math.cos(angle),Math.sin(angle));
        location = new Vector2(x/2,y/2);
        acceleration = new Vector2();
        maxSpeed = 2.0f;
        maxForce = 0.03f;
        this.data = data;
        this.image = image;

        color = new Paint();
        color.setColor(Color.GREEN);
        color.setStyle(Paint.Style.STROKE);

        color.setStrokeWidth(3);
    }

    private void flock(ArrayList<Boid> boids) {
        Vector2 sep = seperate(boids);
        Vector2 ali = align(boids);
        Vector2 coh = cohesion(boids);
        sep.multi(data.getSWeight());
        ali.multi(data.getAWeight());
        coh.multi(data.getCWeight());

        applyForce(sep);
        applyForce(ali);
        applyForce(coh);
    }


    public void update(ArrayList<Boid> boids) {
        flock(boids);

        Vector2 prev = new Vector2(location);
        velocity.add(acceleration);
        if(velocity.length() > maxSpeed) {
            velocity.norm();
            velocity.multi(maxSpeed);
        }
        location.add(velocity);
        acceleration.set(0,0);

        borders();

        prev.sub(location);
        angle = prev.angleDeg();

        createMatrix();
    }

    private void createMatrix() {
        position = new Matrix();

        position.setRotate((float)angle,image.getWidth()/2,image.getHeight()/2);
        position.postScale(0.2f,0.2f,image.getWidth()/2,image.getHeight()/2);
        position.postTranslate((float)location.x,(float)location.y);
    }

    public void render(Canvas can) {

        can.drawBitmap(image,position,color);
        //Drawable d;
        //can.drawCircle((float)location.x, (float)location.y,20, color);
        //can.drawBitmap(image,(float)location.x, (float)location.y, color);
    }
    private void borders(){
        if(location.x < 0)
            location.x += borderW;
        if(location.y < 0)
            location.y += borderH;

        if(location.x > borderW)
            location.x -= borderW;
        if(location.y > borderH)
            location.y -= borderH;

    }
    private void applyForce(Vector2 force) {
        acceleration.add(force);
    }
    private Vector2 align(ArrayList<Boid> boids) {
        Vector2 direct = new Vector2();

        int count = 0;
        for(Boid other : boids)
        {
            double d = location.distWrap(other.location,borderH,borderW);
            if(d > 0 && d < data.getARange())
            {
                direct.add(other.velocity);
                count++;
            }
        }
        if(count > 0)
        {
            direct.div(count);
            direct.norm();
        }
        return direct;
    }

    private Vector2 cohesion(ArrayList<Boid> boids) {

        Vector2 direct = new Vector2();

        int count = 0;
        for(Boid other : boids)
        {
            double d = location.distWrap(other.location,borderH,borderW);
            if(d > 0 && d < data.getCRange())
            {
                if(d != location.dist(other.location))
                {
                    double dx = location.x - other.location.x;
                    double dy = location.y - other.location.y;
                    Vector2 temp = new Vector2(other.location);
                    if(dx > borderW/2)
                    {
                        temp.x += borderW;
                    }
                    else if(dx < -borderW/2)
                    {
                        temp.x -= borderW;
                    }
                    if(dy > borderH/2)
                    {
                        temp.y += borderH;
                    }
                    else if(dy < -borderH/2)
                    {
                        temp.y -= borderH;
                    }
                    direct.add(temp);
                }
                else
                {
                    direct.add(other.location);
                }
                count++;
            }
        }
        if(count > 0)
        {
            direct.div(count);
            direct.sub(location);
            direct.norm();
        }
        return direct;
    }

    private Vector2 seperate(ArrayList<Boid> boids) {

        Vector2 direct = new Vector2();

        int count = 0;
        for(Boid other : boids)
        {
            //does this cal
            if(this != other)
            {
                double d = location.distWrap(other.location,borderH,borderW);
                if(d > 0 && d < data.getSRange())
                {
                    //x = 27, ox = 1
                    double dx = location.x - other.location.x;
                    double dy = location.y - other.location.y;

                    if(dx > borderW/2)
                    {
                        dx -= borderW;
                    }
                    else if(dx < -borderW/2)
                    {
                        dx += borderW;
                    }

                    if(dy > borderH/2)
                    {
                        dy -= borderH;
                    }
                    else if(dy < -borderH/2)
                    {
                        dy += borderH;
                    }
                    Vector2 dir = new Vector2(dx,dy);
                    dir.norm();
                    dir.multi(1-(d/data.getSRange()));
                    direct.add(dir);
                    count++;
                }
            }
        }
        if(count > 0)
        {
            direct.div(count);
            direct.norm();
        }
        return direct;
    }

}
