package homework2;

import java.util.*;

/********************************************
	
	DATA MODEL:
	
	BipariteGraph represents labeled bipartite graph consisting of nodes and edges.
	BipariteGraph provides access to nodes via public list* and get* methods
	
	- Graph has graphLabel object, which should be generic
	- Graph has 2 types of nodes, black and white:  nodes and edges are stored in HashTable, key is the Label
	- Graph has edges, that connect the nodes			-  
*********************************************/	

// Abstraction Function:
//		BipariteGraph represents labeled bipartite graph consisting of nodes and edges.
//		All graph nodes can be accessed via child-parent relation and graph can be traversed
//			
//

// Representation Invariant:
//		- all graph nodes are labeled with non-null label of type T
//		- if there exists some edge e1 from some node1 to some node2 than node1 and node2 are guaranteed of different types  	 
//		- if there exists some node1 with out-bound edge e1 than guaranteed existance of some node2 with in-bound edge e1 and vice versa
	
public class BipartiteGraph<T> {
		
		private Map<T, Node<T>> nodes;
		
		/**
		 * @effects creates new empty graph driver instance
		 */
		public BipartiteGraph(){
			this.nodes = new HashMap<T, Node<T>>();
			this.checkRep();	
		}
		
		/**
		 * @requires nodeLabel != null && type > = 0
		 * @effects add new node of the type to the graph 
		 * @modifies this
		 * @param nodeLabel
		 * @param type
		 * @throws Exception
		 */
		public void addNode(T nodeLabel, int type) throws Exception{
			if(nodeLabel == null) throw new NullPointerException("nodeLabel is null");
			if(type < 0) throw new IllegalArgumentException("type must be positive integer");
			
			if (this.nodes.containsKey(nodeLabel)) {
				throw new Exception("node labeled: " + nodeLabel + "already exists");
			}
			
			this.nodes.put(nodeLabel, new Node<T>(nodeLabel, type));
			
		}
		
		/**
		 * @requires 	parentLabel !=null && edgeLabel !=null && childLabel != null
		 * 				&& parent node, child node and edge were added to the graph prior to this call
		 * @effects		add new edge from parentLabel to childLabel 
		 * @modifies this	
		 * @param edgeLabel
		 * @param childLabel
		 * @param parentLabel
		 * @throws Exception
		 */
		public void addEdge(T edgeLabel, T childLabel, T parentLabel) throws Exception{
			if(parentLabel == null) throw new NullPointerException("parentLabel is null");
			if(childLabel == null) throw new NullPointerException("childLabel is null");
			if(edgeLabel == null) throw new NullPointerException("edgeLabel is null");
			
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
		 * @requires nodeLabel !=null && edgeLabel !=null and node was added to the graph prior to this call
		 * @effects remove given node from the graph
		 * @param nodeLabel
		 * @throws Exception
		 */
		public void removeNode(T nodeLabel) throws Exception {
			if(nodeLabel == null) throw new NullPointerException("nodeLabel is null");
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
		 * @requires parentLabel !=null && edgeLabel !=null and both parent node and edge were added to the graph prior to this call
		 * @effects remove given edge from the graph
		 * @throws Exception
		 */
		public void removeEdge(T parentLabel, T edgeLabel) throws Exception {
			if(parentLabel == null) throw new NullPointerException("parentLabel is null");
			if(edgeLabel == null) throw new NullPointerException("edgeLabel is null");
			Node<T> parentNode = this.getNodeByLabel(parentLabel);
			Edge<T> edge  = parentNode.getOutEdge(edgeLabel);
			Node<T> childNode = this.getNodeByLabel(edge.getChildNode());
	
			childNode.removeInEdge(edgeLabel);
			parentNode.removeOutEdge(edgeLabel);
		}
		
		 /**
		  * 
		  * @return list of all nodes in the graph
		  */
		public List<T> getNodes(){
			Set<T> keySet 	= this.nodes.keySet();
			List<T> keyList = new ArrayList<T>(keySet);
			return keyList;
		}
		
		
		/**
		 * 
		 * @param type
		 * @requires type !=null && type >= 0
		 * @return list of all nodes of the type that exist in the graph
		 */
		public List<T> getNodesByType(int type){
			if(type < 0) throw new IllegalArgumentException("type must be positive integer");
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
		 * @requires nodeLabel !=null && node was added to the graph prior to this call
		 * @return integer type of the requested node
		 * @throws Exception
		 */
			public int getNodetype(T nodeLabel) throws Exception {
			if(nodeLabel == null) throw new NullPointerException("nodeLabel is null");
			Node<T> node = this.getNodeByLabel(nodeLabel);
			return node.getType();
		}
		
		
		/**
		 * 
		 * @param nodeLabel
		 * @requires nodeLabel !=null && node was added to the graph prior to this call
		 * @return list of all in-bound edges for given node
		 * @throws Exception
		 */
		public List<T> getNodeInEdges		(T nodeLabel) throws Exception{
			if(nodeLabel == null) throw new NullPointerException("nodeLabel is null");
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
		 * @requires nodeLabel !=null && node was added to the graph prior to this call
		 * @return list of all out-bound edges for given node
		 * @throws Exception
		 */
		public List<T> getNodeOutEdges		(T nodeLabel) throws Exception{
			if(nodeLabel == null) throw new NullPointerException("nodeLabel is null");
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
		 * @requires nodeLabel != null && node was added to the graph prior to this call
		 * @return list of all child nodes for given node
		 */
		public List<T> getNodeChildren	(T nodeLabel){
			if(nodeLabel == null) throw new NullPointerException("nodeLabel is null");
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
		 * @requires nodeLabel !=null && node was added to the graph prior to this call
		 * @return list of all parent nodes for given node
		 */
		public List<T> getNodeParents	(T nodeLabel){
			if(nodeLabel == null) throw new NullPointerException("nodeLabel is null");
			Node<T> node = this.nodes.get(nodeLabel);
			List<T> parents = new ArrayList<T>();
			for ( Edge<T> edge: node.getInEdgesList()) {				
				parents.add(edge.getParentNode());
			}
			return parents;
		} 
		
		/**
		 * 
		 * @param parentLabel
		 * @param edgeLabel
		 * @requires parentLabel !=null && edgeLabel !=null and both parent node and edge were added to the graph prior to this call
		 * @return label of the child node for given edge
		 * @throws Exception
		 */
		public T getEdgeChildNode	(T parentLabel, T edgeLabel) throws Exception{
			if(parentLabel == null) throw new NullPointerException("parentLabel is null");
			if(edgeLabel == null) throw new NullPointerException("edgeLabel is null");
			Node<T> node = this.getNodeByLabel(parentLabel);
			Edge<T> edge = node.getOutEdge(edgeLabel);
			T child = edge.getChildNode();
			return child;
		}	 
		
		/**
		 * 
		 * @param childLabel
		 * @param edgeLabel
		 * @requires childLabel !=null && edgeLabel !=null and both child node and edge were added to the graph prior to this call
		 * @return label of the parent node for given edge
		 * @throws Exception
		 */
		public T getEdgeParentNode	(T childLabel, T edgeLabel) throws Exception{
			if(childLabel == null) throw new NullPointerException("childLabel is null");
			if(edgeLabel == null) throw new NullPointerException("edgeLabel is null");
			Node<T> node = this.getNodeByLabel(childLabel);
			Edge<T> edge = node.getInEdge(edgeLabel);
			T parent = edge.getParentNode();
			return parent;
		}
		
		
		private Node<T> getNodeByLabel(T nodeLabel) throws Exception {
			if(nodeLabel == null) throw new NullPointerException("nodeLabel is null");
			if (!this.nodes.containsKey(nodeLabel)) {
				throw new Exception("No such label: "+ nodeLabel );
			}
			
			Node<T> node = this.nodes.get(nodeLabel);
			return node;
		}
		
		private void checkRep() {
			assert nodes != null : "nodes hash table is not initialized. should never happen";
		}
		
	
}
