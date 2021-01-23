package edu.ib;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import ODEMethods.ConsoleStepper;
import ODEMethods.SecondGradeODE;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import org.apache.commons.math3.ode.FirstOrderIntegrator;
import org.apache.commons.math3.ode.nonstiff.ClassicalRungeKuttaIntegrator;

public class ControllerODEGraph {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text HarmonicOscillatorTitleID;

    @FXML
    private VBox VboxID;

    @FXML
    private Button graphX;

    @FXML
    private Button graphV;

    @FXML
    private Button graphXV;

    @FXML
    private TextField giveMi;

    @FXML
    private Text ByMeID;

    @FXML
    private ScatterChart<?, ?> GraphID;

    @FXML
    private NumberAxis xValues;

    @FXML
    private NumberAxis yValues;

    @FXML
    void makeGraphV(ActionEvent event)
    {
        double mi = Double.parseDouble(giveMi.getText());
        SecondGradeODE harmonicOscillator = new SecondGradeODE(mi);
        FirstOrderIntegrator RK4 = new ClassicalRungeKuttaIntegrator(0.01);
        ConsoleStepper realConsoleDisplay = new ConsoleStepper();
        ArrayList<Double> Time = realConsoleDisplay.getTime();
        ArrayList<Double> xValues = realConsoleDisplay.getxValues();
        ArrayList<Double> vValues = realConsoleDisplay.getvValues();

        double [] x0 = {1,0}; // initial conditions.
        double [] x = new double[2]; // Vector for the solutions
        RK4.addStepHandler(realConsoleDisplay);
        RK4.integrate(harmonicOscillator,0,x0,2*Math.PI,x); // From 0 to PI

        GraphID.getData().clear();
        ScatterChart.Series series = new ScatterChart.Series();// Object that handle the graph inside.
        for(int i = 0; i < Time.size(); i ++)
        {
            series.getData().add(new ScatterChart.Data(Time.get(i),vValues.get(i)));
            GraphID.getData().add(series);
        }
    }

    @FXML
    void makeGraphX(ActionEvent event)
    {
        double mi = Double.parseDouble(giveMi.getText());
        SecondGradeODE harmonicOscillator = new SecondGradeODE(mi);
        FirstOrderIntegrator RK4 = new ClassicalRungeKuttaIntegrator(0.01);
        ConsoleStepper realConsoleDisplay = new ConsoleStepper();
        ArrayList<Double> Time = realConsoleDisplay.getTime();
        ArrayList<Double> xValues = realConsoleDisplay.getxValues();
        ArrayList<Double> vValues = realConsoleDisplay.getvValues();

        double [] x0 = {1,0}; // initial conditions.
        double [] x = new double[2]; // Vector for the solutions
        RK4.addStepHandler(realConsoleDisplay);
        RK4.integrate(harmonicOscillator,0,x0,2*Math.PI,x); // From 0 to PI

        GraphID.getData().clear();
        ScatterChart.Series series = new ScatterChart.Series();// Object that handle the graph inside.
        for(int i = 0; i < Time.size(); i ++)
        {
            series.getData().add(new ScatterChart.Data(Time.get(i),xValues.get(i)));
            GraphID.getData().add(series);
        }

    }

    @FXML
    void makeGraphXV(ActionEvent event)
    {
        double mi = Double.parseDouble(giveMi.getText());
        SecondGradeODE harmonicOscillator = new SecondGradeODE(mi);
        FirstOrderIntegrator RK4 = new ClassicalRungeKuttaIntegrator(0.01);
        ConsoleStepper realConsoleDisplay = new ConsoleStepper();
        ArrayList<Double> Time = realConsoleDisplay.getTime();
        ArrayList<Double> xValues = realConsoleDisplay.getxValues();
        ArrayList<Double> vValues = realConsoleDisplay.getvValues();

        double [] x0 = {1,0}; // initial conditions.
        double [] x = new double[2]; // Vector for the solutions
        RK4.addStepHandler(realConsoleDisplay);
        RK4.integrate(harmonicOscillator,0,x0,2*Math.PI,x); // From 0 to PI

        GraphID.getData().clear();
        ScatterChart.Series series = new ScatterChart.Series();// Object that handle the graph inside.
        for(int i = 0; i < Time.size(); i ++)
        {
            series.getData().add(new ScatterChart.Data(xValues.get(i),vValues.get(i)));
            GraphID.getData().add(series);
        }

    }

    @FXML
    void initialize() {
        assert HarmonicOscillatorTitleID != null : "fx:id=\"HarmonicOscillatorTitleID\" was not injected: check your FXML file 'ODEGraph.fxml'.";
        assert VboxID != null : "fx:id=\"VboxID\" was not injected: check your FXML file 'ODEGraph.fxml'.";
        assert graphX != null : "fx:id=\"graphX\" was not injected: check your FXML file 'ODEGraph.fxml'.";
        assert graphV != null : "fx:id=\"graphV\" was not injected: check your FXML file 'ODEGraph.fxml'.";
        assert graphXV != null : "fx:id=\"graphXV\" was not injected: check your FXML file 'ODEGraph.fxml'.";
        assert giveMi != null : "fx:id=\"giveMi\" was not injected: check your FXML file 'ODEGraph.fxml'.";
        assert ByMeID != null : "fx:id=\"ByMeID\" was not injected: check your FXML file 'ODEGraph.fxml'.";
        assert GraphID != null : "fx:id=\"GraphID\" was not injected: check your FXML file 'ODEGraph.fxml'.";
        assert xValues != null : "fx:id=\"xValues\" was not injected: check your FXML file 'ODEGraph.fxml'.";
        assert yValues != null : "fx:id=\"yValues\" was not injected: check your FXML file 'ODEGraph.fxml'.";

    }
}
