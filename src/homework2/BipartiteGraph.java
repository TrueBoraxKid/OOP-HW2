package homework2;

import java.util.*;

//import static org.junit.Assert.*;
//import org.junit.Test;

/********************************************
	
	DATA MODEL:
	- Graph has graphLabel object, which should be generic
	- Graph has 2 types of nodes, black and white:  nodes and edges are stored in HashTable, key is the Label
		- NODES: 
			- Node has nodeLabel, generic
			- Node has list of inEdges and outEdges, by generic labels
			- Node has type: black or white
			- Labels are unique
	- Graph has edges, that connect the nodes:
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
			- getNodeType
			- getNodeInEdges  	by nodeLabel, returns list of labels
			- getNodeOutEdges 	by nodeLabel, returns list of labels
			- getNodeChildNodes by nodeLabel, returns list of labels
			- getNodeParentNodes by nodeLabel, returns list of labels
			- getEdgeChildNodes	 by edgeLabel, returns label	
			- 
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

public class BipartiteGraph<T> {
		
		private Map<T, Node<T>> nodes;
		private T graphLabel;
		
		/**
		 * 
		 * @param graphLabel
		 */
		public BipartiteGraph(T graphLabel){
			nodes = new HashMap<T, Node<T>>();
			edges = new HashMap<T, Edge<T>>();
			this.graphLabel = graphLabel; // TODO clone? copy constructor?
			
			
			//TODO checkRep();
			
		}
		
		
		/**
		 * 
		 * @param nodeLabel
		 * @param type
		 */
		public void addNode(T nodeLabel, int type){
			if (this.nodes.containsKey(nodeLabel)) {
				//TODO Throw exception
				System.out.println("node labeled: " + nodeLabel + "already exists");
			}
			
			this.nodes.put(nodeLabel, new Node<T>(nodeLabel, type));
			
		}
		
		/**
		 * 
		 * @param edgeLabel
		 * @param childLabel
		 * @param parentLabel
		 */	
		public void addEdge(T edgeLabel, T childLabel, T parentLabel){		
		}
		
		
		public List<T> getNodes(){
			Set<T> keySet 	= this.nodes.keySet();
			List<T> keyList = new ArrayList<T>(keySet);
			return keyList;
		}
		
		
		/**
		 * 
		 * @param nodeLabel
		 * @return
		 * @throws Exception
		 */
		public int getNodeType(T nodeLabel) throws Exception {
			
			Node<T> node = this.getNodeByLabel(nodeLabel);
			return node.getType();
		}
		
		
		/**
		 * 
		 * @param nodeLabel
		 * @return
		 */
		public List<T> getNodeInEdges		(T nodeLabel){
			Node<T> node = this.getNodeByLabel(nodeLabel);
			List<T> inEdges = node.getInEdgesList();		
			return inEdges;
		}
		
		/**
		 * 
		 * @param nodeLabel
		 * @return
		 */
		public List<T> getNodeOutEdges		(T nodeLabel){
			Node<T> node = this.getNodeByLabel(nodeLabel);
			List<T> outEdges = node.getOutEdgesList();		
			return outEdges;
		}	 
		
		/**
		 * 
		 * @param nodeLabel
		 * @return
		 */
		public List<T> getNodeChildNodes	(T nodeLabel){
			return null;
		}  
		
		/**
		 * 
		 * @param nodeLabel
		 * @return
		 */
		public List<T> getNodeParentNodes	(T nodeLabel){
			return null;
		} 
		
		/**
		 * 
		 * @param edgeLabel
		 * @return
		 */
		public T getEdgeChildNode	(T parentLabel, T edgeLabel){
			Node<T> node = this.getNodeByLabel(parentLabel);
			Edge<T> edge = node.getOutEdge(edgeLabel);
			T child = edge.getChildNode();
			return child;
		}	 
		
		//Not needed since edge access is through parentNode or childNode only
		////**
		/// * 
		/// * @param edgeLabel
		/// * @return
		/// */
		///public List<T> getEdgeParentNode	(T edgeLabel){
		///	return null;
		///}
		
		//TODO Override toString
		
		private Node<T> getNodeByLabel(T nodeLabel) {
			if (!this.nodes.containsKey(nodeLabel)) {
				//TODO custom Exceptions?
				throw new Exception("No such label: "+ nodeLabel );
			}
			
			Node<T> node = this.nodes.get(nodeLabel);
			return node;
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	
}
