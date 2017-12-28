package homework2;

import java.util.*;

//import static org.junit.Assert.*;
//import org.junit.Test;

/********************************************
	
	- NODES: 
			- Node has nodeLabel, generic
			- Node has list of inEdges and outEdges, by generic labels
			- Node has type: black or white
			- Labels are unique
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

public class Node<T> {
		private T nodeLabel;
		private int type;
		private Map <T, Edge<T>> inEdges;
		private Map <T, Edge<T>> outEdges;
		
		/**
		 * 
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
		
		/**
		 * 
		 * @return
		 */
		public int getType() {
			return this.type;
		}
		
		public T getLabel() {
			return this.nodeLabel;
		}
		/**
		 * 
		 * @param edgeLabel
		 * @param edge
		 */
		public void addInEdge(T edgeLabel, Edge<T> edge) {
			this.inEdges.put(edgeLabel, edge);
		}
		
		/**
		 * 
		 * @param edgeLabel
		 * @param edge
		 */
		public void addOutEdge(T edgeLabel, Edge<T> edge) {
			this.outEdges.put(edgeLabel, edge);
		}
		
		/**
		 * 
		 * @return
		 */
		public List<Edge<T>> getInEdgesList(){
			List<Edge<T>> edges = new ArrayList<Edge<T>>(this.inEdges.values());
			return edges;
		}
		
		/**
		 * 
		 * @return
		 */
		public List<Edge<T>> getOutEdgesList(){
			List<Edge<T>> edges = new ArrayList<Edge<T>>(this.outEdges.values());
			return edges;
		}
		
		/**
		 * 
		 * @param edgeLabel
		 * @return
		 * @throws Exception
		 */
		public Edge<T> getOutEdge(T edgeLabel) throws Exception{
			if (!this.outEdges.containsKey(edgeLabel)) {
				//TODO custom Exceptions?
				throw new Exception(this.nodeLabel + "has no such edge labeled: "+ edgeLabel );
			}
			Edge<T> edge = this.outEdges.get(edgeLabel);
			return edge;
		}
		
		/**
		 * 
		 * @param edgeLabel
		 * @return
		 * @throws Exception
		 */
		public Edge<T> getInEdge(T edgeLabel) throws Exception{
			if (!this.inEdges.containsKey(edgeLabel)) {
				//TODO custom Exceptions?
				throw new Exception(this.nodeLabel + " has no edge labeled: "+ edgeLabel );
			}
			Edge<T> edge = this.inEdges.get(edgeLabel);
			return edge;
		}
		
		/**
		 * 
		 * @param edgeLabel
		 * @return
		 */
		public boolean hasInEdge(T edgeLabel) {
			return this.inEdges.containsKey(edgeLabel);
		}
		
		/**
		 * 
		 * @param edgeLabel
		 * @return
		 */
		public boolean hasOutEdge(T edgeLabel) {
			return this.outEdges.containsKey(edgeLabel);
		}
		
		private void checkRep() {
			//TODO implement checkRep
		}
		
		public void removeInEdge(T edgeLabel) throws Exception {
			if(this.hasInEdge(edgeLabel)) {
				this.inEdges.remove(edgeLabel);
			}
			else throw new Exception(this.nodeLabel + " has no edge labeled: "+ edgeLabel );
		}
		
		public void removeOutEdge(T edgeLabel) throws Exception {
			if(this.hasOutEdge(edgeLabel)) {
				this.outEdges.remove(edgeLabel);
			}
			else throw new Exception(this.nodeLabel + " has no edge labeled: "+ edgeLabel );
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	
}
