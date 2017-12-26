package homework2;

//import static org.junit.Assert.*;
//import org.junit.Test;

/********************************************
	

		- EDGES: 
			- Edge has edgeLabel, generic
			- Edge stores 2 labels, nodes it connects: childNode and parentNode
			- 
			- 
			- 
			- 
	- USER CAN: 
		- User has no access to data structures
		- All interfacing by lables only
		- 
		- user can: 
			- create Graph by Label, init it empty 
			- add nodes: label ------------------------------------------------ 
			- add edges: label, childNode, parentNode ------------------------- 
			- getNodeInEdges  	by nodeLabel, returns list of labels
			- getNodeOutEdges 	by nodeLabel, returns list of labels
			- getNodeChildNodes by nodeLabel, returns list of labels
			- getNodeParentNodes by nodeLabel, returns list of labels
			- getEdgeChildNodes	 by edgeLabel, returns list of labels	
			- getEdgeParentNodes by edgeLabel, returns list of labels
			- 
			- resetGraph
			- 
			- 
			
	- 
	- 
	- 
	- 
	- 
	*********************************************/	

public class Edge<T> {
		
		private T edgeLabel;
		private T childNodeLabel;
		private T parentNodeLabel;
		
		
		/**
		 * 
		 * @param edgeLabel
		 * @param childLabel
		 * @param parentLabel
		 */
		public Edge (T edgeLabel, T childLabel, T parentLabel) {
			this.childNodeLabel = childLabel;
			this.parentNodeLabel = parentLabel;
			this.edgeLabel = edgeLabel;
			
			this.checkRep();
		}
		
		/**
		 * 
		 * @return
		 */
		public T getLabel(){
			return this.edgeLabel;
		}
		
		/**
		 * 
		 * @return
		 */
		public T getChildNode(){
				return this.childNodeLabel;
		}
		
		/**
		 * 
		 * @return
		 */
		public T getParentNode(){
			return this.parentNodeLabel;
		}
		
		
		private void checkRep() {
			//TODO implement checkRep
		}
		
		//TODO override toString
}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	

