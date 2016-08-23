package personalproject.simpleapp;

import android.app.Activity;
import android.graphics.Canvas;
import android.content.Context;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.os.Handler;

public class FlockActivity extends Activity {

    private FlockView view;
    private boolean running;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FlockData data = (FlockData)getIntent().getSerializableExtra("DATA");
        view = new FlockView(this);
        view.setup(data);
        setContentView(view);
        //setContentView(R.layout.activity_flock);
        //view = (FlockView)findViewById(R.id.view);
        running = false;
    }
    @Override
    protected void onStart()
    {
        super.onStart();
        running = true;
        view.onStart();
    }
    @Override
    protected void onResume()
    {
        super.onResume();
        if(!running)
        {
            running = true;
            view.onResumeMySurfaceView();
        }
    }
    @Override
    protected void onPause()
    {
        super.onPause();
        running = false;
        view.onPause();
    }
}
