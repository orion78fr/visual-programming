package fr.orion78.graphicalProgramming.view;

import javafx.scene.Node;

public class CurrentDraggingContext {
	public static Node from = null;
	public static boolean isDragging(){
		return from == null;
	}
}
