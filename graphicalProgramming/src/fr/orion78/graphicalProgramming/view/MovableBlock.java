package fr.orion78.graphicalProgramming.view;

import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

public class MovableBlock implements MyNode {
	private Group node = new Group();
	private Point2D delta = null;
	private Line l = new Line();
	
	public MovableBlock(double x, double y, double width, double height, Paint color1, Paint color2) {
		l.setVisible(false);
		node.getChildren().add(l);
		
		Polygon polygon = new Polygon();
		polygon.getPoints().addAll(new Double[]{
		    x + width + 2, 					y + height / 2 - 5,
		    x + width + 2, 					y + height / 2 + 5,
		    x + width + 2 + Math.sqrt(75), 	y + height / 2		});
		polygon.setFill(Color.VIOLET);
		
		polygon.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if(event.getButton() == MouseButton.PRIMARY){
					l.setStartX(x + width + 2 + Math.sqrt(75));
					l.setStartY(y + height / 2);
					l.setEndX(event.getSceneX() - node.getLayoutX());
					l.setEndY(event.getSceneY() - node.getLayoutY());
					l.setVisible(true);
					polygon.setStroke(Color.RED);
					node.setCursor(Cursor.CLOSED_HAND);
					
					CurrentDraggingContext.from = polygon;
					
					event.consume();
				}
			}
		});
		polygon.setOnMouseDragged(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if(event.getButton() == MouseButton.PRIMARY){
					l.setEndX(event.getSceneX() - node.getLayoutX());
					l.setEndY(event.getSceneY() - node.getLayoutY());
				    event.consume();
				}
			}
		});
		polygon.setOnMouseReleased(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if(event.getButton() == MouseButton.PRIMARY){
					node.setCursor(Cursor.HAND);
					polygon.setStroke(Color.TRANSPARENT);
					l.setVisible(false);
					event.consume();
				}
			}
		});
		
		node.getChildren().add(polygon);

        
        Rectangle rect = new Rectangle(x, y, width, height);
        node.getChildren().add(rect);
        
        rect = new Rectangle(x+5,y+5,width-10, 10);
        rect.setFill(color1);
        node.getChildren().add(rect);
        
        rect = new Rectangle(x+5,y+20,width-10, 10);
        rect.setFill(color2);
        node.getChildren().add(rect);
        
        node.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if(event.getButton() == MouseButton.PRIMARY){
					delta = new Point2D(node.getLayoutX() - event.getSceneX(), node.getLayoutY() - event.getSceneY());
					node.setCursor(Cursor.MOVE);
					event.consume();
				}
			}
		});
        node.setOnMouseDragged(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if(event.getButton() == MouseButton.PRIMARY){
					node.setLayoutX(event.getSceneX() + delta.getX());
				    node.setLayoutY(event.getSceneY() + delta.getY());
				    event.consume();
				}
			}
		});
        node.setOnMouseReleased(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if(event.getButton() == MouseButton.PRIMARY){
					node.setCursor(Cursor.HAND);
					event.consume();
				}
			}
		});
        node.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				node.setCursor(Cursor.HAND);
			}
		});
        node.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				node.setCursor(Cursor.DEFAULT);
			}
		});
	}

	@Override
	public Node getNode() {
		return node;
	}
}
