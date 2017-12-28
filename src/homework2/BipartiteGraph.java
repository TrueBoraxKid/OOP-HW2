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
		- All interfacing by labels only
		- 
		- user can: 
			- create Graph by Label, init it empty 
			- add nodes: label ------------------------------------------------ 
			- add edges: label, childNode, parentNode ------------------------- 
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
	*********************************************/	

public class BipartiteGraph<T> {
		
		private Map<T, Node<T>> nodes;
		//private T graphLabel;
		
		/**
		 * 
		 * @param graphLabel
		 */
		public BipartiteGraph(){
			this.nodes = new HashMap<T, Node<T>>();

			this.checkRep();
			
		}
		
		public BipartiteGraph(T graphLabel){
			this.nodes = new HashMap<T, Node<T>>();			
		}
		
		
		/**
		 * 
		 * @param nodeLabel
		 * @param type
		 * @throws Exception 
		 */
		public void addNode(T nodeLabel, int type) throws Exception{
			if (this.nodes.containsKey(nodeLabel)) {
				throw new Exception("node labeled: " + nodeLabel + "already exists");
			}
			
			this.nodes.put(nodeLabel, new Node<T>(nodeLabel, type));
			
		}
		
		/**
		 * 
		 * @param edgeLabel
		 * @param childLabel
		 * @param parentLabel
		 * @throws Exception 
		 */	
		public void addEdge(T edgeLabel, T childLabel, T parentLabel) throws Exception{
			Node<T> parent	= this.getNodeByLabel(parentLabel);
			Node<T> child 	= this.getNodeByLabel(childLabel);
			
			if(parent.hasOutEdge(edgeLabel)) 	throw new Exception("Parent " + parentLabel + " already has outgoing edge " + edgeLabel);
			if(child.hasInEdge(edgeLabel)) 		throw new Exception("Child " + childLabel + " already has ingoing edge " + edgeLabel);
			if(parent.getType() == child.getType()) throw new Exception(parent + " and " + child + " have same type"); 
			Edge<T> edge = new Edge<T>(edgeLabel, childLabel, parentLabel);
			
			parent.addOutEdge(edgeLabel, edge);
			child.addInEdge(edgeLabel, edge);
		}
		
		
		
		/**
		 * 
		 * @param nodeLabel
		 * @throws Exception
		 */
		public void removeNode(T nodeLabel) throws Exception {
			Node<T> node = this.getNodeByLabel(nodeLabel);
			List<Edge<T>> inEdges = node.getInEdgesList();
			List<Edge<T>> outEdges = node.getOutEdgesList();
			
			for(Edge<T> edge: inEdges)  node.removeInEdge(edge.getLabel());
			for(Edge<T> edge: outEdges) node.removeOutEdge(edge.getLabel());
			
			this.nodes.remove(nodeLabel);
		}
		
		
		/**
		 * 
		 * @param parentLabel
		 * @param edgeLabel
		 * @throws Exception
		 */
		public void removeEdge(T parentLabel, T edgeLabel) throws Exception {
			Node<T> parentNode = this.getNodeByLabel(parentLabel);
			Edge<T> edge  = parentNode.getOutEdge(edgeLabel);
			Node<T> childNode = this.getNodeByLabel(edge.getChildNode());
	
			childNode.removeInEdge(edgeLabel);
			parentNode.removeOutEdge(edgeLabel);
		}
		 /**
		  * 
		  * @return List<T> of labels for all nodes in the graph
		  */
		public List<T> getNodes(){
			Set<T> keySet 	= this.nodes.keySet();
			List<T> keyList = new ArrayList<T>(keySet);
			return keyList;
		}
		
		
		/**
		 * 
		 * @param type
		 * @return List of labels of nodes filtered by type
		 */
		public List<T> getNodesByType(int type){
			Set<T> keySet 	= this.nodes.keySet();
			List<T> keyList = new ArrayList<T>(keySet);
			
			for (Iterator<T> i = keyList.iterator(); i.hasNext();) {
				T key = i.next();
				Node<T> node = this.nodes.get(key);
				if(node.getType() != type) i.remove(); 
			}
			
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
		 * @throws Exception 
		 */
		public List<T> getNodeInEdges		(T nodeLabel) throws Exception{
			Node<T> node = this.getNodeByLabel(nodeLabel);
			List<Edge<T>> inEdges = node.getInEdgesList();
			List<T> edges = new ArrayList<T>();
			for(Edge<T> edge: inEdges) {
				edges.add(edge.getLabel());
			}
			return edges;
		}
		
		/**
		 * 
		 * @param nodeLabel
		 * @return
		 * @throws Exception 
		 */
		public List<T> getNodeOutEdges		(T nodeLabel) throws Exception{
			Node<T> node = this.getNodeByLabel(nodeLabel);
			List<Edge<T>> outEdges = node.getOutEdgesList();
			List<T> edges = new ArrayList<T>();
			for(Edge<T> edge: outEdges) {
				edges.add(edge.getLabel());
			}
			return edges;
		}	 
		
		/**
		 * 
		 * @param nodeLabel
		 * @return List of all immediate children for nodeLabel.
		 */
		public List<T> getNodeChildren	(T nodeLabel){
			Node<T> node = this.nodes.get(nodeLabel);
			List<T> children = new ArrayList<T>();
			for ( Edge<T> edge: node.getOutEdgesList()) {				
				children.add(edge.getChildNode());
			}
			return children;
		}  
		
		/**
		 * 
		 * @param nodeLabel
		 * @return List of all immediate parents for nodeLabel
		 */
		public List<T> getNodeParents	(T nodeLabel){
			Node<T> node = this.nodes.get(nodeLabel);
			List<T> parents = new ArrayList<T>();
			for ( Edge<T> edge: node.getInEdgesList()) {				
				parents.add(edge.getParentNode());
			}
			return parents;
		} 
		
		/**
		 * 
		 * @param edgeLabel
		 * @return
		 * @throws Exception 
		 */
		public T getEdgeChildNode	(T parentLabel, T edgeLabel) throws Exception{
			Node<T> node = this.getNodeByLabel(parentLabel);
			Edge<T> edge = node.getOutEdge(edgeLabel);
			T child = edge.getChildNode();
			return child;
		}	 
		
		/**
		 * 
		 * @param edgeLabel
		 * @return
		 * @throws Exception 
		*/
		public T getEdgeParentNode	(T childLabel, T edgeLabel) throws Exception{
			Node<T> node = this.getNodeByLabel(childLabel);
			Edge<T> edge = node.getInEdge(edgeLabel);
			T parent = edge.getParentNode();
			return parent;
		}
		
		
		private Node<T> getNodeByLabel(T nodeLabel) throws Exception {
			if (!this.nodes.containsKey(nodeLabel)) {
				//TODO custom Exceptions?
				throw new Exception("No such label: "+ nodeLabel );
			}
			
			Node<T> node = this.nodes.get(nodeLabel);
			return node;
		}
		
		private void checkRep() {
			//TODO implement checkRep
		}
		
	
}
