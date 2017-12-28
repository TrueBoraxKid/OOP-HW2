package homework2;

/************************************
 * 
 * 		- EDGES:
 * 			Edge represents graph edge between two nodes. 
 *  
 *			- Edge has edgeLabel, generic
 *			- Edge stores 2 labels, nodes it connects: childNode and parentNode
 */

public class Edge<T> {
		
		private T edgeLabel;
		private T childNodeLabel;
		private T parentNodeLabel;
		
		
		/**
		 * 
		 * @param edgeLabel
		 * @param childLabel
		 * @param parentLabel
		 * @effects creates new edge from parentLabel to childLabel
		 */
		public Edge (T edgeLabel, T childLabel, T parentLabel) {
			this.childNodeLabel = childLabel;
			this.parentNodeLabel = parentLabel;
			this.edgeLabel = edgeLabel;
			
			this.checkRep();
		}
		
		 private void checkRep() {
			assert edgeLabel != null : "label cannot be null";
			assert childNodeLabel != null : "label cannot be null";
		    assert parentNodeLabel != null : "label cannot be null";
		}
		/**
		 * 
		 * @return label of this
		 */
		public T getLabel(){
			return this.edgeLabel;
		}
		
		/**
		 * 
		 * @return label of the child node for this
		 */
		public T getChildNode(){
				return this.childNodeLabel;
		}
		
		/**
		 * 
		 * @return label of the parent node for this
		 */
		public T getParentNode(){
			return this.parentNodeLabel;
		}
}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	

