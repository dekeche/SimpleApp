package personalproject.simpleapp;

/**
 * Created by Jesse on 8/5/2016.
 */
public class FlockData {

    private float AWeight;
    private float CWeight;
    private float SWeight;

    private float ARange;
    private float CRange;
    private float SRange;

    FlockData()
    {
        AWeight = 1.0f;
        ARange = 50;
        CWeight = 1.0f;
        CRange = 100;
        SWeight = 1.5f;
        SRange = 50;
    }
    FlockData(float aw,float ar,float cw,float cr,float sw,float sr)
    {
        AWeight = aw;
        ARange = ar;
        CWeight = cw;
        CRange = cr;
        SWeight = sw;
        SRange = sr;
    }
    public float getAWeight() {
        return AWeight;
    }

    public void setAWeight(float AWeight) {
        this.AWeight = AWeight;
    }

    public float getCWeight() {
        return CWeight;
    }

    public void setCWeight(float CWeight) {
        this.CWeight = CWeight;
    }

    public float getSWeight() {
        return SWeight;
    }

    public void setSWeight(float SWeight) {
        this.SWeight = SWeight;
    }

    public float getARange() {
        return ARange;
    }

    public void setARange(float ARange) {
        this.ARange = ARange;
    }

    public float getCRange() {
        return CRange;
    }

    public void setCRange(float CRange) {
        this.CRange = CRange;
    }

    public float getSRange() {
        return SRange;
    }

    public void setSRange(float SRange) {
        this.SRange = SRange;
    }
}
