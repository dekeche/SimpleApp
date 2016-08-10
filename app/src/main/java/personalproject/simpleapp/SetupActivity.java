package personalproject.simpleapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SetupActivity extends AppCompatActivity {

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

    int AWeight;
    int CWeight;
    int SWeight;

    int ARange;
    int CRange;
    int SRange;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);
        initializeVariables();

        ARangeSlider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                setTextRange(ARangeText,progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                ARange = seekBar.getProgress();
            }
        });

        AWeightSlider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                setTextWeight(AWeightText,progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                AWeight = seekBar.getProgress();
            }
        });
        SRangeSlider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                setTextRange(SRangeText,progress);
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

                setTextWeight(SWeightText,progress);
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
                setTextRange(CRangeText,progress);
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
                setTextWeight(CWeightText,progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        Intent intent = new Intent(this,FlockActivity.class);
        startActivity(intent);
    }

    //connect up the slider and text values
    private void initializeVariables()
    {
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
    }

    private void setTextRange(TextView view,int progress)
    {
        view.setText("Range: " + progress);
    }
    private void setTextWeight(TextView view,int progress)
    {
        float precent = (float)progress / 50.0f;
        view.setText("Weight: " + precent);
    }
}
