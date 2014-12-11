package fr.orion78.graphicalProgramming.view;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
 
public class MainView extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    Point2D delta = null;
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("My graphical programming");
        
        Group gr3 = new Group();
        
        Rectangle rect = new Rectangle(0,0,0,0);
        rect.setFill(Color.BLACK);
        Label coords = new Label("0,0");
        Rectangle fond = new Rectangle(800,600);
        
        fond.setFill(Color.CYAN);
        fond.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if(event.getButton() == MouseButton.PRIMARY){
					delta = new Point2D(event.getSceneX(), event.getSceneY());
					fond.setCursor(Cursor.MOVE);
					event.consume();
				}
			}
		});
        fond.setOnMouseDragged(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if(event.getButton() == MouseButton.PRIMARY){
					delta = delta.subtract(event.getSceneX(), event.getSceneY());
					for(Node n : fond.getParent().getChildrenUnmodifiable()){
						if(!n.equals(fond)){
							n.setLayoutX(n.getLayoutX() - delta.getX());
						    n.setLayoutY(n.getLayoutY() - delta.getY());
						    if(n.equals(rect)){
						    	coords.setText(-n.getLayoutX() + "," + -n.getLayoutY());
						    }
						}
					}
					delta = new Point2D(event.getSceneX(), event.getSceneY());
				    event.consume();
				}
			}
		});
        fond.setOnMouseReleased(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if(event.getButton() == MouseButton.PRIMARY){
					fond.setCursor(Cursor.HAND);
					event.consume();
				}
			}
		});
        fond.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				fond.setCursor(Cursor.HAND);
			}
		});
        fond.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				fond.setCursor(Cursor.DEFAULT);
			}
		});
        
        gr3.getChildren().add(rect);
        gr3.getChildren().add(fond);
        gr3.getChildren().add(new MovableBlock(10,20,50,50,Color.ALICEBLUE, Color.DARKGREEN).getNode());
        gr3.getChildren().add(new MovableBlock(100,200,50,50,Color.ORANGE, Color.YELLOW).getNode());
        
        Group gr = new Group();
        gr.getChildren().add(gr3);
        gr.getChildren().add(coords);
        
        primaryStage.setScene(new Scene(gr, 800, 600));
        primaryStage.show();
    }
}
