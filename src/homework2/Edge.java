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

public class Edge<T> {
		
		private T edgeLabel;
		private T childNodeLabel;
		private T parentNodeLabel;
		
		public Edge(T edgeLable, T childLabel, T parentLabel){
			
		}
		
		public T getLabel(){
			return this.edgeLabel;
		}
		
		public T getChildNode(){
				return this.childNodeLabel;
		}
		
		public T getParentNode(){
			return this.parentNodeLabel;
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	
}
