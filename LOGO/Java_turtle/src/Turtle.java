import java.awt.Color;

import annexe.StdDraw;

public class Turtle {
    private double x, y; 
    private double angle; 
    
    public Turtle(double coordx, double coordy, double agl) {
        x = coordx;
        y = coordy;
        angle = agl;
    }

    public void rotateLeft(double agl) {
        angle += agl;
    }

    public void goForward(double step) {
        double oldx = x;
        double oldy = y;
        x += step * Math.cos(Math.toRadians(angle));
        y += step * Math.sin(Math.toRadians(angle));
        StdDraw.line(oldx, oldy, x, y);
    }

    public void pause(int t) {
        StdDraw.show(t);
    }


    public void setPenColor(Color color) {
        StdDraw.setPenColor(color);
    }

    public void setPenRadius(double radius) {
        StdDraw.setPenRadius(radius);
    }

    public void setCanvasSize(int width, int height) {
        StdDraw.setCanvasSize(width, height);
    }

    public void setXscale(double min, double max) {
        StdDraw.setXscale(min, max);
    }

    public void setYscale(double min, double max) {
        StdDraw.setYscale(min, max);
    }


    // sample client for testing
    public static void main(String[] args) {
        double x0 = 0.2;
        double y0 = 0.01;
        double a0 = 0.0;
        double step = 0.6;
        Turtle turtle  = new Turtle(x0, y0, a0);
        turtle.goForward(step);
        turtle.rotateLeft(90.0);
        turtle.goForward(step);
        turtle.rotateLeft(90.0);
        turtle.goForward(step);
        turtle.rotateLeft(90.0);
        turtle.goForward(step);
        turtle.rotateLeft(135.0);
        turtle.goForward(Math.sqrt(0.72));
        turtle.rotateLeft(135.0);
        turtle.goForward(step);
        turtle.rotateLeft(135.0);
        turtle.goForward(Math.sqrt(0.72));
    }
}