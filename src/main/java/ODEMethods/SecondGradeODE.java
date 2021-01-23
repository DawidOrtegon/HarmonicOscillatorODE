package ODEMethods;

import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.ode.FirstOrderDifferentialEquations;

public class SecondGradeODE implements FirstOrderDifferentialEquations
{
    private double mi;

    public SecondGradeODE(double mi)
    {
        this.mi = mi;
    }

    @Override
    public int getDimension()
    {
        return 2;
    }

    @Override
    public void computeDerivatives(double t, double[] x, double[] xDot) throws MaxCountExceededException, DimensionMismatchException
    {
        // 0 for the coordinates and 1 for the speed.
        xDot[0] = x[1];
        xDot[1] = mi*(1-Math.pow(x[0],2))*x[1]-x[0];
    }

}
