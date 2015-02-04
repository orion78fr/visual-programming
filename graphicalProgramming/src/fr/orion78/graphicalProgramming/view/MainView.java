package fr.orion78.graphicalProgramming.view;

import java.util.Map;

import javax.swing.JFrame;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.mxConstants;
import com.mxgraph.view.mxGraph;
 
public class MainView extends JFrame {
	private static final long serialVersionUID = -3215409405437457496L;
	private static String version = "0.1";

	public static void main(String[] args) {
        MainView v = new MainView();
        v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		v.setSize(800, 600);
		v.setVisible(true);
    }

    public MainView() {
        super("My graphical programming v" + version);
        
        mxGraph graph = new mxGraph();
        
        updateGraph(graph);
        
        mxGraphComponent c = new mxGraphComponent(graph);
        getContentPane().add(c);
    }
    
    private void updateGraph(mxGraph graph){
    	Object parent = graph.getDefaultParent();

		graph.getModel().beginUpdate();
		try
		{
			Object v1 = graph.insertVertex(parent, null, "Hello", 20, 20, 80,
					30);
			Object v2 = graph.insertVertex(parent, null, "World!", 240, 150,
					80, 30);
			graph.insertEdge(parent, null, "Edge", v1, v2);
			
			graph.insertVertex(parent, null, "TEST", 80, 200, 80, 30);
			
			Map<String, Object> style = graph.getStylesheet().getDefaultEdgeStyle();
		    style.put(mxConstants.STYLE_ROUNDED, false);
		    style.put(mxConstants.STYLE_EDGE, mxConstants.EDGESTYLE_ENTITY_RELATION);

			graph.setAllowDanglingEdges(false);
		}
		finally
		{
			graph.getModel().endUpdate();
		}
    }
}
