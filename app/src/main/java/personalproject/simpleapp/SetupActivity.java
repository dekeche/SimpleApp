package personalproject.simpleapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SetupActivity extends AppCompatActivity {

    private Button StartButton;
    private SeekBar ARangeSlider;
    private SeekBar AWeightSlider;
    private SeekBar SRangeSlider;
    private SeekBar SWeightSlider;
    private SeekBar CRangeSlider;
    private SeekBar CWeightSlider;

    private TextView ARangeText;
    private TextView AWeightText;
    private TextView SRangeText;
    private TextView SWeightText;
    private TextView CRangeText;
    private TextView CWeightText;

    FlockData data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);
        initializeVariables();

        ARangeSlider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                data.setARange(setTextRange(ARangeText,progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar){
            }
        });

        AWeightSlider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                data.setAWeight(setTextWeight(AWeightText,progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        SRangeSlider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                data.setSRange(setTextRange(SRangeText,progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        SWeightSlider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                data.setSWeight(setTextWeight(SWeightText,progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        CRangeSlider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                data.setCRange(setTextRange(CRangeText,progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        CWeightSlider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                data.setCWeight(setTextWeight(CWeightText,progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        StartButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent intent = new Intent(SetupActivity.this,FlockActivity.class);
                intent.putExtra("DATA",SetupActivity.this.data);
                SetupActivity.this.startActivity(intent);
            }
        });
    }

    //connect up the slider and text values
    private void initializeVariables()
    {
        data = new FlockData();

        StartButton = (Button) findViewById(R.id.StartButton);
        ARangeSlider = (SeekBar) findViewById(R.id.ARangeSlider);
        AWeightSlider = (SeekBar) findViewById(R.id.AWeightSlider);
        SRangeSlider = (SeekBar) findViewById(R.id.SRangeSlider);
        SWeightSlider = (SeekBar) findViewById(R.id.SWeightSlider);
        CRangeSlider = (SeekBar) findViewById(R.id.CRangeSlider);
        CWeightSlider = (SeekBar) findViewById(R.id.CWeightSlider);

        ARangeText = (TextView) findViewById(R.id.AlignmentRange);
        AWeightText = (TextView) findViewById(R.id.AlignmentWeight);
        SRangeText = (TextView) findViewById(R.id.SeperationRange);
        SWeightText = (TextView) findViewById(R.id.SeperationWeight);
        CRangeText = (TextView) findViewById(R.id.CohesionRange);
        CWeightText = (TextView) findViewById(R.id.CohesionWeight);


        ARangeSlider.setProgress((int)data.getARange());
        setTextRange(ARangeText,(int)data.getARange());

        SRangeSlider.setProgress((int)data.getSRange());
        setTextRange(SRangeText,(int)data.getSRange());

        CRangeSlider.setProgress((int)data.getCRange());
        setTextRange(CRangeText,(int)data.getCRange());

        int progress;
        progress = (int)(data.getAWeight()*50.0f);
        AWeightSlider.setProgress(progress);
        setTextWeight(AWeightText,progress);

        progress = (int)(data.getSWeight()*50.0f);
        SWeightSlider.setProgress(progress);
        setTextWeight(SWeightText,progress);

        progress = (int)(data.getCWeight()*50.0f);
        CWeightSlider.setProgress(progress);
        setTextWeight(CWeightText,progress);


    }

    private float setTextRange(TextView view,int progress)
    {
        view.setText("Range: " + progress);
        return progress;
    }
    private float setTextWeight(TextView view,int progress)
    {
        float precent = (float)progress / 50.0f;
        view.setText("Weight: " + precent);
        return precent;
    }
}
