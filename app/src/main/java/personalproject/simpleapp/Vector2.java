package personalproject.simpleapp;

/**
 * Created by Jesse on 8/4/2016.
 * Basic vector functionality
 */
public class Vector2 {
    public double x;
    public double y;

    /*
    * default zero vector
     */
    public Vector2()
    {
        x = 0; y = 0;
    }
    /*
    * vector constructed from float params
     */
    public Vector2(double x, double y)
    {
        set(x,y);
    }


    /*
    * vector constructed from float params
     */
    public Vector2( Vector2 vec)
    {
        set(vec);
    }

    public Vector2 cpy()
    {
        return new Vector2(this);
    }
    /*
    * Operator overloading
     */
    public Vector2 set(double x, double y) {
        this.x = x;
        this.y = y;
        return this;
    }
    public Vector2 set(Vector2 vec) {
        this.x = vec.x;
        this.y = vec.y;
        return this;
    }
    public double length()
    {
        return Math.sqrt(lengthSqd());
    }

    public double lengthSqd() {
        return x*x+y*y;
    }

    public Vector2 sub(Vector2 rhs)
    {
        x -= rhs.x;
        y -= rhs.y;
        return this;
    }
    public Vector2 add(Vector2 rhs)
    {
        x += rhs.x;
        y += rhs.y;
        return this;
    }
    public Vector2 multi(double rhs)
    {
        x *= rhs;
        y *= rhs;
        return this;
    }
    public Vector2 div(double rhs)
    {
        x /= rhs;
        y /= rhs;
        return this;
    }
    public Vector2 norm()
    {
        double length = length();
        if(length != 0)
        {
            x /= length;
            y /= length;
        }
        return this;
    }
    public double dot(Vector2 rhs)
    {
        return x*rhs.x + y*rhs.y;
    }

    public double dist(Vector2 rhs)
    {
        double dx = this.x - rhs.x;
        double dy = this.y - rhs.y;
        return Math.sqrt(dx*dx+dy*dy);
    }
    public double distSqr(Vector2 rhs)
    {
        double dx = this.x - rhs.x;
        double dy = this.y - rhs.y;
        return dx*dx+dy*dy;
    }
    public double distWrap(Vector2 rhs, double height, double width)
    {
        double dx = this.x - rhs.x;
        double dy = this.y - rhs.y;
        if(dx > (width/2))
            dx = width - dx;
        else if(dx < (-width/2))
        {
            dx = dx + width;
        }
        if(dy > (height/2))
            dy = height - dx;
        else if(dy < (-height/2))
        {
            dy = dy + height;
        }

        return Math.sqrt(dx*dx+dy*dy);
    }

    public double angle()
    {
        return Math.atan2(y,x);
    }
    public double angleDeg()
    {
        return Math.toDegrees(angle());
    }
}
