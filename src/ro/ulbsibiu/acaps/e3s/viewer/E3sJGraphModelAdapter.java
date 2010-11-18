package ro.ulbsibiu.acaps.e3s.viewer;

import java.awt.Color;
import java.awt.geom.Rectangle2D;

import org.jgraph.graph.AttributeMap;
import org.jgraph.graph.GraphConstants;
import org.jgrapht.Graph;
import org.jgrapht.ext.JGraphModelAdapter;

import com.jgraph.components.labels.CellConstants;
import com.jgraph.components.labels.MultiLineVertexRenderer;

/**
 * {@link JGraphModelAdapter} for the task graphs from E3S benchmarks
 * 
 * @author Ciprian Radu
 *
 */
public class E3sJGraphModelAdapter extends JGraphModelAdapter<Object, Object> {

	public E3sJGraphModelAdapter(Graph<Object, Object> jGraphTGraph) {
		super(jGraphTGraph);
	}

	@Override
	public AttributeMap getDefaultEdgeAttributes() {
        AttributeMap map = new AttributeMap();

		GraphConstants.setLineEnd(map, GraphConstants.ARROW_TECHNICAL);
        GraphConstants.setEndFill(map, true);
        GraphConstants.setLabelAlongEdge(map, true);

        GraphConstants.setForeground(map, Color.decode("#25507C"));
//        GraphConstants.setFont(map, GraphConstants.DEFAULTFONT.deriveFont(Font.BOLD, 12));
        GraphConstants.setLineColor(map, Color.decode("#7AA1E6"));

        return map;
	}

	@Override
	public AttributeMap getDefaultVertexAttributes() {
        AttributeMap map = new AttributeMap();

		// we set the bounds only to force the layout manager to use minimum size shapes
		// this way the auto sizing mechanism will immediately generate the optimum sized shapes
        // TODO I am not sure how exactly setBounds(...) works with setAutoSize(...)
		GraphConstants.setBounds(map, new Rectangle2D.Double(0, 0, 100, 100));
		GraphConstants.setAutoSize(map, true);
		GraphConstants.setBackground(map, Color.LIGHT_GRAY);
		GraphConstants.setForeground(map, Color.BLACK);
		GraphConstants.setOpaque(map, true);
//		GraphConstants.setFont(map, GraphConstants.DEFAULTFONT.deriveFont(Font.BOLD, 12));
		GraphConstants.setBorderColor(map, Color.black);

		// we want to have the nodes represented as circles
		// but, the auto size property overrides this and
		// ellipses are created
		CellConstants.setVertexShape(map, MultiLineVertexRenderer.SHAPE_CIRCLE);
        
        return map;
	}

}