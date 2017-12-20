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
			- add nodes: label ------------------------------------------------ TODO: Are nodes generic? how to diff between white and black nodes
			- add edges: label, childNode, parentNode ------------------------- TODO: Throw Exception when childNode and parentNode are same type
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
		
		
		public Node(T nodeLabel, int type){
			this.nodeLabel = nodeLabel; // TODO clone?
			if( type == 0) {
				this.type = 0;
			}else {
				this.type = 1;
			}
			
			this.inEdges = new HashMap <T, Edge<T>>();
			this.outEdges = new HashMap <T, Edge<T>>(); 
			//TODO checkRep
		}
		
		public int getType() {
			return this.type;
		}
		
		public void addInEdge(T edgeLabel, Edge<T> edge) {
			this.inEdges.put(edgeLabel, edge);
		}
		
		public void addOutEdge(T edgeLabel, Edge<T> edge) {
			this.outEdges.put(edgeLabel, edge);
		}
		
		public List<Edge<T>> getInEdgesList(){
			List<Edge<T>> edges = new ArrayList<Edge<T>>(this.inEdges.values());
			return edges;
		}
		
		public List<Edge<T>> getOutEdgesList(){
			List<Edge<T>> edges = new ArrayList<Edge<T>>(this.outEdges.values());
			return edges;
		}
		
		public Edge<T> getOutEdge(T edgeLabel) throws Exception{
			if (!this.outEdges.containsKey(edgeLabel)) {
				//TODO custom Exceptions?
				throw new Exception("No such label: "+ nodeLabel );
			}
			Edge<T> edge = this.outEdges.get(edgeLabel);
			return edge;
		}
		
		public Edge<T> getInEdge(T edgeLabel) throws Exception{
			if (!this.inEdges.containsKey(edgeLabel)) {
				//TODO custom Exceptions?
				throw new Exception("No such label: "+ nodeLabel );
			}
			Edge<T> edge = this.inEdges.get(edgeLabel);
			return edge;
		}
		
		public boolean hasInEdge(T edgeLabel) {
			return this.inEdges.containsKey(edgeLabel);
		}
		
		public boolean hasOutEdge(T edgeLabel) {
			return this.outEdges.containsKey(edgeLabel);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	
}
