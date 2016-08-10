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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = new FlockView(this);
        setContentView(view);
        //setContentView(R.layout.activity_flock);
        //view = (FlockView)findViewById(R.id.view);
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        view.onResumeMySurfaceView();
    }
    @Override
    protected void onPause()
    {
        super.onPause();
    }
}
