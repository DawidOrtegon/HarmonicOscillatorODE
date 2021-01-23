package ODEMethods;

import org.apache.commons.math3.ode.FirstOrderIntegrator;
import org.apache.commons.math3.ode.nonstiff.ClassicalRungeKuttaIntegrator;
import org.apache.commons.math3.ode.nonstiff.EulerIntegrator;

import java.io.*;
import java.util.ArrayList;

public class MainClass
{
    public static void main(String[] args) throws IOException {
        // Creation for the equation and the integrator method to find the solution.
        SecondGradeODE harmonicOscillator = new SecondGradeODE(0.2);
        FirstOrderIntegrator RK4 = new ClassicalRungeKuttaIntegrator(0.01);

        // For the saving and displaying the information.
        ConsoleStepper consoleDisplay = new ConsoleStepper();
        ArrayList<Double> Time = consoleDisplay.getTime();
        ArrayList<Double> xValues = consoleDisplay.getxValues();
        ArrayList<Double> vValues = consoleDisplay.getvValues();

        double [] x0 = {1,0}; // initial conditions.
        double [] x = new double[2]; // Vector for the solutions
        RK4.addStepHandler(consoleDisplay);
        RK4.integrate(harmonicOscillator,0,x0,Math.PI,x); // From 0 to PI
        System.out.printf("%15s %15s %15s%n", "Time","x(t)", "v(t)");
        for(int i = 0; i < Time.size(); i++)
        {
            System.out.printf("%15g %15g %15g%n", Time.get(i), xValues.get(i), vValues.get(i));
        }

        File saveData = new File("/Users/davidortegon/Temporales/ResultsHarmonicOscillator.txt");
        try (PrintWriter pw = new PrintWriter(saveData))
        {
            pw.printf("%15s %15s %15s%n", "Time","x(t)", "v(t)");
            for (int i =  0; i < Time.size(); i++)
            {
                pw.printf("%15g %15g %15g%n", Time.get(i), xValues.get(i), vValues.get(i));
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}
