import java.util.function.Function;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.stage.Stage;

/* As per the exam booklet, this class is based on FunctionGraph class (Manfred
 * Kerber, 2018-08-28). All methods and variables are adaptations of Manfred
 * Kerber's original code in order to produce the display indicators.
 */
public class Indicators extends Application {
	
	/* final variables X_SIZE and Y_SIZE have been adjusted to scale down the
	 * two display indicators too a more appropriate size.
	 */
    public static final int X_SIZE   = 600 / 2;
    public static final int Y_SIZE   = 600 / 2;
    public static final int D_Y_SIZE = 50     ;
    
	private static int      n;
	private static double   a;
	private static double   b;
	private static double min;
	private static double max;    

    public static double max(Function<Double,Double> f, int n,
                             double a, double b) {
        double x, y;
        double max = f.apply(a);
        double delta = (b - a)/n;

        for (int i = 0; i <= n ; i++){
            x = a + delta * i;
            y = f.apply(x);
            if (y > max) {
                max = y;
            }
        }
        
        return max;
    }

    public static double min(Function<Double,Double> f, int n,
                             double a, double b) {
        double x, y;
        double min = f.apply(a);
        double delta = (b - a)/n;
        for (int i = 0; i <= n ; i++){
            x = a + delta * i;
            y = f.apply(x);
            if (y < min) {
                min = y;
            }
        }
        
        return min;
    }

    /* This method has been adapted to include a modifier. The modifier is
     * used to position the circle segment along the x-axis of the scene graph.
     */
    public static Polyline functionToPolyline(Function<Double,Double> f,
                                    int n, double a, double b, int modifier) {
        if (a >= b) {
            throw new IllegalArgumentException();
        } else {
            double[] points = new double[2*(n+1)];
            double x, y;
            double max = max(f,n,a,b);
            double min = min(f,n,a,b);

            for (int i = 0; i <= n ; i++){
                x = a + (b - a) * i / n;
                y = f.apply(x);
                
                /* Here, the modifier has been added in order to correctly
                 * position the circle segments in relation to each other.
                 */
                points[2*i]   = ((x-a) * X_SIZE/(b-a) + modifier);
                points[2*i+1] = (max - y)* Y_SIZE/(max-min);
            }

            return new Polyline(points);
        }
    }

    /* This method has been adapted to draw the line segment at the specific
     * angle passed to it.
     */
    public static void drawXAxis(Group root, double angle, int modifier){
        if (min <= 0 && max >=0 && min != max) {
            Line line = new Line(0, max * Y_SIZE/(max-min),
                                 X_SIZE + modifier, max * Y_SIZE/(max-min));
            
            /* The x-axis is not displayed as per the visual example in the
             * exam booklet. However, it's position is useful and so although is
             * not display it is still calculated.
             */
            //root.getChildren().add(line);
            
            // We find the point of which our line segment should start.
            double x1 = line.getEndX();
            double y1 = line.getEndY();
            
            /* Citation: 
             * https://stackoverflow.com/questions/3536428/draw-a-line-at-a-specific-angle-in-java
             */
            double x2 = x1 + (-Y_SIZE * Math.cos(angle * Math.PI / 180));
    		double y2 = y1 + (-Y_SIZE * Math.sin(angle * Math.PI / 180));
            
            Line angleLine = new Line(x1,y1, x2, y2);
            root.getChildren().add(angleLine);
        }
    }

    public static void drawYAxis(Group root) {
        if (a <= 0 && b >= 0 && a != b){
            Line line = new Line(b * X_SIZE/(b-a), 0,
                                 b * X_SIZE/(b-a), Y_SIZE);
            root.getChildren().add(line);
            
        }
        
    }
    
    /* This method has been modified to return a Polyline instance. This has
     * been done as we require two polyline's: one for each display indicator.
     * Therefore, the Polyline static variable was removed.
     */
	public static Polyline setValues(Function<Double, Double> f, int numberOfValues,
								 double left, double right, int modifier) {
		a = left;
		b = right;
		n = numberOfValues;
		min = min(f, n, a, b);
		max = max(f, n, a, b);
		
		return functionToPolyline(f, numberOfValues, left, right, modifier);
	}

    @Override
    public void start(Stage stage) throws Exception {
    	
    	// The function for a a circle segment, provided via the exam booklet.
    	Function<Double, Double> circleSegment = x -> Math.sqrt(1-x*x);
        Polyline displayOneArc = setValues(circleSegment, 200, -1.0, 0.0, 0);
        Polyline displayTwoArc = setValues(circleSegment,
        								   200, -1.0, 0.0, 
        								   X_SIZE + 200);
        
    	// User chooses an angle from 0 to 90 degrees.
    	double angleOne = 10.0;
    	double angleTwo = 45.0;
    	
        Group root = new Group(displayOneArc, displayTwoArc);
        
        // This method has been modified to draw the line segment.
        drawXAxis(root, angleOne, 0);
        drawXAxis(root, angleTwo, X_SIZE + 200);
        drawYAxis(root);

        // The scene consists of just one group.
        Scene scene = new Scene(root);

        // Give the stage (window) a title and add the scene.
        stage.setTitle("Function Graph");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
    	
        launch(args);
    }
}
