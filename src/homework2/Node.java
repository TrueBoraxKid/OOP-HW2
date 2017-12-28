package homework2;

import java.util.*;

/********************************************
	
	- NODES: 
		Node represent graph node that can be (or can be not) connected to other nodes. Node can be one of two types (0 or 1)  
			- Node has nodeLabel, generic
			- Node has list of inEdges and outEdges, by generic labels
			- Node has type: black or white
*********************************************/	

public class Node<T> {
		private T nodeLabel;
		private int type;
		private Map <T, Edge<T>> inEdges;
		private Map <T, Edge<T>> outEdges;
		
		/**
		 * @effects creates new node of the type
		 * @param nodeLabel
		 * @param type
		 */
		public Node(T nodeLabel, int type){
			this.nodeLabel = nodeLabel;
			this.type = (type == 0) ? 0:1;
			
			this.inEdges = new HashMap <T, Edge<T>>();
			this.outEdges = new HashMap <T, Edge<T>>(); 
			
			this.checkRep();
		}
		
	    private void checkRep() {
	    	assert nodeLabel != null : "label cannot be null";
			assert type >= 0 : "type should be >= 0";
		}
		
		/**
		 * 
		 * @return type of this
		 */
		public int getType() {
			return this.type;
		}
		
		
		/**
		 * 
		 * @return label of this
		 */
		public T getLabel() {
			return this.nodeLabel;
		}
		
		
		/**
		 * 
		 * @param edgeLabel
		 * @param edge
		 * @effects adds in-bound edge to this
		 * @requires edgeLabel != null && edge != null
		 */
		public void addInEdge(T edgeLabel, Edge<T> edge) {
			this.inEdges.put(edgeLabel, edge);
		}
		
		/**
		 * 
		 * @param edgeLabel
		 * @param edge
		 * @effects adds out-bound edge to this
		 * @requires edgeLabel != null && edge != null
		 */
		public void addOutEdge(T edgeLabel, Edge<T> edge) {
			this.outEdges.put(edgeLabel, edge);
		}
		
		/**
		 * @return list of all in-bound edges
		 */
		public List<Edge<T>> getInEdgesList(){
			List<Edge<T>> edges = new ArrayList<Edge<T>>(this.inEdges.values());
			return edges;
		}
		
		/**
		 * 
		 * @return  list of all in-bound edges
		 */
		public List<Edge<T>> getOutEdgesList(){
			List<Edge<T>> edges = new ArrayList<Edge<T>>(this.outEdges.values());
			return edges;
		}
		
		/**
		 * 
		 * @param edgeLabel
		 * @return out-bound edge labeled with edgeLabel
		 * @requires edgeLabel != null
		 * @throws Exception
		 */
		public Edge<T> getOutEdge(T edgeLabel) throws Exception{
			if (!this.outEdges.containsKey(edgeLabel)) {
				throw new Exception(this.nodeLabel + "has no such edge labeled: "+ edgeLabel );
			}
			Edge<T> edge = this.outEdges.get(edgeLabel);
			return edge;
		}
		
		/**
		 * 
		 * @param edgeLabel
		 * @return out-bound edge labeled with edgeLabel
		 * @requires edgeLabel != null
		 * @throws Exception
		 */
		public Edge<T> getInEdge(T edgeLabel) throws Exception{
			if (!this.inEdges.containsKey(edgeLabel)) {
				throw new Exception(this.nodeLabel + " has no edge labeled: "+ edgeLabel );
			}
			Edge<T> edge = this.inEdges.get(edgeLabel);
			return edge;
		}
		
		/**
		 * 
		 * @param edgeLabel
		 * @return boolean indicating if this has in-bound edge labeled edgeLabel
		 */
		public boolean hasInEdge(T edgeLabel) {
			return this.inEdges.containsKey(edgeLabel);
		}
		
		/**
		 * 
		 * @param edgeLabel
		 * @return boolean indicating if this has out-bound edge labeled edgeLabel
		 */
		public boolean hasOutEdge(T edgeLabel) {
			return this.outEdges.containsKey(edgeLabel);
		}
		
		/**
		 * 
		 * @param edgeLabel
		 * @throws Exception
		 */
		public void removeInEdge(T edgeLabel) throws Exception {
			if(this.hasInEdge(edgeLabel)) {
				this.inEdges.remove(edgeLabel);
			}
			else throw new Exception(this.nodeLabel + " has no edge labeled: "+ edgeLabel );
		}
		
		/**
		 * 
		 * @param edgeLabel
		 * @throws Exception
		 */
		public void removeOutEdge(T edgeLabel) throws Exception {
			if(this.hasOutEdge(edgeLabel)) {
				this.outEdges.remove(edgeLabel);
			}
			else throw new Exception(this.nodeLabel + " has no edge labeled: "+ edgeLabel );
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	
}
