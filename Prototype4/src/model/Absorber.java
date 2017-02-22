package model;
import model.Ball;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.awt.Color;
import physics.Circle;
import physics.LineSegment;
import physics.Vect;


public class Absorber implements IAbsorber {   
    // 1- Absorber class Demonstrate a working absorber, ball motion, gravity, and friction.
	//2 - In running mode, with no bumpers or flippers on the screen and the ball sitting still in the absorber, 
	//3 - you should be able to press a key, observe the ball shoot up out of the absorber, slow down as it rises, 
	//fall back to the absorber, and return to its original position. Also, 
	//demonstrate that you can shoot it out a second time. (Note that you do not yet need to support configurable gravity or friction constants.)
	// (Ball shoots straight up at standard initial ball velocity 50L/s being slowed down by standard gravity and friction. 
	//Does it collide with the top wall? If so, at what velocity?)
	
	private double x1, y1, x2, y2;
	private Color colour;
	private static final double L = 20;
	private int rotation;
	private boolean absorbed;
	private Ball ball;

	private String gizmoName;
	

	
	public Absorber(String gizmoName, double x1, double y1, double x2, double y2, Color c){
		this.gizmoName = gizmoName;
		this.x1 = x1*L;
		this.y1 = y1*L;
		this.colour = Color.MAGENTA;
		this.x2 = x2*L;		
		this.y2 = y2*L;
	}
	
	public List<LineSegment> getLineSegments() {
		List<LineSegment> lineSegments = new ArrayList<LineSegment>();
		lineSegments.add(new LineSegment(x1,				y1,			x1+this.x2,		y1));
		lineSegments.add(new LineSegment(x1,				y1,			x1,				y1+this.y2));
		lineSegments.add(new LineSegment(x1,				y1+this.y2,	x1+this.x2,		y1+this.y2));
		lineSegments.add(new LineSegment(x1+this.x2,		y1,			x1+this.x2,		y1+this.y2));
		return lineSegments;
	}
	
	public List<Circle> getCircles() {
		List<Circle> circles = new ArrayList<Circle>();
		circles.add(new Circle(x1,	y1,		0));
		circles.add(new Circle(x1,	y1+this.y2,	0));
		circles.add(new Circle(x1+this.x2,	y1,		0));
		circles.add(new Circle(x1+this.x2,	y1+this.y2,	0));
		return circles;
	}

	
	public void setX(double x){
		this.x1 =x;
	}
	
	public void setY(double y){
		this.y1=y;
	}
	
	public void setWidth(double width){
		this.x2 = width;

	}

	
	public double getX1() {
		return x1;
	}


	public double getY1() {
		return y1;
	}


	public double getX2() {
		return x2;
	}

	
	public double getY2() {
		return y2;
}
	
	public Color getColour() {
		return colour;
	}

	public void setColour(Color colour) {
		this.colour = colour;
	}
	
	public void trigger(){
		if (ball == null) {
			ball.move(this.x1 + this.x2 - 0.25, this.y1 + this.y2 - 0.25);
			ball.isAbsorbed();
		}
	}
	
	public void absorb(Ball ball) {
		ball.isAbsorbed();
		ball.setX(ball.getX()+0.75);
		ball.setY(ball.getY()+0.75);
		
		ball.move(this.x1 + this.x2 - 0.25, this.y1 - 0.25);
		
	}

	@Override
	public void addBall(Ball ball) {
		// TODO Auto-generated method stub
		
	}
	
//	
}