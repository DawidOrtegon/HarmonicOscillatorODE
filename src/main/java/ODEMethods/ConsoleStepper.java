package ODEMethods;

import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.ode.sampling.StepHandler;
import org.apache.commons.math3.ode.sampling.StepInterpolator;

import java.util.ArrayList;

public class ConsoleStepper implements StepHandler
{
    private ArrayList<Double> Time =  new ArrayList<>();
    private ArrayList<Double> xValues = new ArrayList<>();
    private ArrayList<Double> vValues = new ArrayList<>();

    // Methods Getter to then have the access to the values correctly.


    public ArrayList<Double> getTime()
    {
        return Time;
    }

    public ArrayList<Double> getxValues()
    {
        return xValues;
    }

    public ArrayList<Double> getvValues()
    {
        return vValues;
    }

    @Override
    public void init(double t0, double[] x0, double t)
    {
        Time.add(t0);
        xValues.add(x0[0]);
        vValues.add(x0[1]);
    }

    @Override
    public void handleStep(StepInterpolator interpolator, boolean isLast) throws MaxCountExceededException
    {
        double t = interpolator.getCurrentTime(); // tell me where are you now.
        double [] x = interpolator.getInterpolatedState();
        Time.add(t);
        xValues.add(x[0]);
        vValues.add(x[1]);
    }
}
