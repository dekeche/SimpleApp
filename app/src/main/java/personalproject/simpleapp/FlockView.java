package personalproject.simpleapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import java.util.Random;

/**
 * Created by Jesse on 8/6/2016.
 */
public class FlockView extends SurfaceView implements Runnable{

    boolean running;
    Flock flock;
    Thread thread;
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Random random;
    SurfaceHolder surfaceHolder;

    public FlockView(Context context) {
        super(context);
        setup();
    }

    public FlockView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setup();
    }

    public FlockView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setup();
    }
    private void setup()
    {
        surfaceHolder = getHolder();
        setFocusable(true);
        random = new Random();
        flock = new Flock();
        DisplayMetrics displaymetrics = getResources().getDisplayMetrics();
        int height = displaymetrics.heightPixels;
        int width = displaymetrics.widthPixels;
        FlockData data = new FlockData();
        flock.setBorder(height,width,data);
        for(int i = 0; i < 50; i++)
        {
            flock.addBoid();
        }

    }
    public void onResumeMySurfaceView(){
        running = true;
        thread = new Thread(this);
        thread.start();
    }
    @Override
    public void run() {

        // TODO Auto-generated method stub
        while(running){
            if(surfaceHolder.getSurface().isValid()){
                Canvas canvas = surfaceHolder.lockCanvas();

                flock.update();
                canvas.drawColor(Color.BLACK);
                flock.render(canvas);
                //... actual drawing on canvas
/*
                paint.setStrokeWidth(3);
 paint.setStyle(Paint.Style.STROKE);
     int w = canvas.getWidth();
     int h = canvas.getHeight();
     int x = random.nextInt(w-1);
     int y = random.nextInt(h-1);
     int r = random.nextInt(255);
     int g = random.nextInt(255);
     int b = random.nextInt(255);
     paint.setColor(0xff000000 + (r << 16) + (g << 8) + b);
     canvas.drawCircle(x, y,10, paint);

                */
                surfaceHolder.unlockCanvasAndPost(canvas);
            }
        }
    }
}
