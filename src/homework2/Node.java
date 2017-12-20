package homework2;

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
			
			//TODO checkRep
		}
		
		public int getType() {
			return this.type;
		}
		
		public List<T> getInEdgesList(){
			Set<T> keySey = this.inEdges.keySet();
			List<T> keyList = new ArrayList<T>(keySet);
			return keyList;
		}
		
		public List<T> getOutEdgesList(){
			Set<T> keySey = this.outEdges.keySet();
			List<T> keyList = new ArrayList<T>(keySet);
			return keyList;
		}
		
		public Edge<T> getOutEdge(T edgeLabel){
			if (!this.outEdges.containsKey(edgeLabel)) {
				//TODO custom Exceptions?
				throw new Exception("No such label: "+ nodeLabel );
			}
			Edge<T> edge = this.outEdges.get(edgeLabel);
			return edge;
		}
		
		public Edge<T> getInEdge(T edgeLabel){
			if (!this.inEdges.containsKey(edgeLabel)) {
				//TODO custom Exceptions?
				throw new Exception("No such label: "+ nodeLabel );
			}
			Edge<T> edge = this.inEdges.get(edgeLabel);
			return edge;
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	
}
