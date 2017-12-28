package homework2;

import java.util.*;

/**
 * This class implements a testing driver for BipartiteGraph. The driver
 * manages BipartiteGraphs whose nodes and edges are Strings.
 */
public class BipartiteGraphTestDriver {

    private Map<String, BipartiteGraph<String>> graphs;

    /**
     * @modifies this
     * @effects Constructs a new test driver.
     */
    public BipartiteGraphTestDriver () {
    	this.graphs = new HashMap<String, BipartiteGraph<String>>();   	
    }

    
    /**
     * @requires graphName != null
     * @modifies this
     * @effects Creates a new graph named graphName. The graph is initially
     * 			empty.
     */
    public void createGraph(String graphName) {
        this.graphs.put(graphName, new BipartiteGraph<String>());   	
    }

    
    /**
     * @throws Exception 
     * @requires createGraph(graphName)
     *           && nodeName != null
     *           && neither addBlackNode(graphName,nodeName) 
     *                  nor addWhiteNode(graphName,nodeName)
     *                      has already been called on this
     * @modifies graph named graphName
     * @effects Adds a black node represented by the String nodeName to the
     * 			graph named graphName.
     */
    public void addBlackNode(String graphName, String nodeName) throws Exception {
    	BipartiteGraph<String> graph = this.graphs.get(graphName);
    	graph.addNode(nodeName, 0);    	

    }

    
    /**
     * @throws Exception 
     * @requires createGraph(graphName)
     *           && nodeName != null
     *           && neither addBlackNode(graphName,nodeName) 
     *                  nor addWhiteNode(graphName,nodeName)
     *                      has already been called on this
     * @modifies graph named graphName
     * @effects Adds a white node represented by the String nodeName to the
     * 			graph named graphName.
     */
    public void addWhiteNode(String graphName, String nodeName) throws Exception {
    	BipartiteGraph<String> graph = this.graphs.get(graphName);
    	graph.addNode(nodeName, 1);
    }

    
    /**
     * @throws Exception 
     * @requires createGraph(graphName)
     *           && ((addBlackNode(parentName) && addWhiteNode(childName))
     *              || (addWhiteNode(parentName) && addBlackNode(childName)))
     *           && edgeLabel != null
     *           && node named parentName has no other outgoing edge labeled
     * 				edgeLabel
     *           && node named childName has no other incoming edge labeled
     * 				edgeLabel
     * @modifies graph named graphName
     * @effects Adds an edge from the node parentName to the node childName
     * 			in the graph graphName. The new edge's label is the String
     * 			edgeLabel.
     */
    public void addEdge(String graphName,
    					String parentName, String childName, 
                        String edgeLabel) throws Exception{
    	BipartiteGraph<String> graph = this.graphs.get(graphName);
    	graph.addEdge(edgeLabel, childName, parentName);
    }
	
    
    /**
     * @requires createGraph(graphName)
     * @return a space-separated list of the names of all the black nodes
     * 		   in the graph graphName, in alphabetical order.
     */
    public String listBlackNodes(String graphName) {
    	BipartiteGraph<String> graph = this.graphs.get(graphName);
    	List<String> nodes = graph.getNodesByType(0);
    	Collections.sort(nodes);
    	return this.listToString(nodes);
    }

    
    /**
     * @requires createGraph(graphName)
     * @return a space-separated list of the names of all the white nodes
     * 		   in the graph graphName, in alphabetical order.
     */
    public String listWhiteNodes(String graphName) {
    	BipartiteGraph<String> graph = this.graphs.get(graphName);
    	List<String> nodes = graph.getNodesByType(1);
    	Collections.sort(nodes);
    	return this.listToString(nodes);	
    }

    
    /**
     * @requires createGraph(graphName) && createNode(parentName)
     * @return a space-separated list of the names of the children of
     * 		   parentName in the graph graphName, in alphabetical order.
     */
    public String listChildren(String graphName, String parentName) {
    	BipartiteGraph<String> graph = this.graphs.get(graphName);
    	List<String> child = new ArrayList<String>(); 
    	child = graph.getNodeChildren(parentName);
    	Collections.sort(child);
    	return this.listToString(child);
    }

    
    /**
     * @requires createGraph(graphName) && createNode(childName)
     * @return a space-separated list of the names of the parents of
     * 		   childName in the graph graphName, in alphabetical order.
     */
    public String listParents(String graphName, String childName) {
    	BipartiteGraph<String> graph = this.graphs.get(graphName);
    	List<String> parent = new ArrayList<String>(); 
    	parent = graph.getNodeParents(childName);
    	Collections.sort(parent);
    	return this.listToString(parent);
    	
    }

    
    /**
     * @requires addEdge(graphName, parentName, str, edgeLabel) for some
     * 			 string str
     * @return the name of the child of parentName that is connected by the
     * 		   edge labeled edgeLabel, in the graph graphName.
     * @throws Exception 
     */
    public String getChildByEdgeLabel(String graphName, String parentName,
    								   String edgeLabel) throws Exception{
    	BipartiteGraph<String> graph = this.graphs.get(graphName);
    	String child = null;
    	child = graph.getEdgeChildNode(parentName, edgeLabel);
    	return child;
    }

    
    /**
     * @requires addEdge(graphName, str, childName, edgeLabel) for some
     * 			 string str
     * @return the name of the parent of childName that is connected by the 
     * 		   edge labeled edgeLabel, in the graph graphName.
     * @throws Exception 
     */
    public String getParentByEdgeLabel(String graphName, String childName,
    									String edgeLabel) throws Exception{
    	BipartiteGraph<String> graph = this.graphs.get(graphName);
    	String parent = null;
		parent = graph.getEdgeParentNode(childName, edgeLabel);
    	return parent;
    }
    
    private String listToString(List<String> list) {
    	StringJoiner joiner = new StringJoiner(" ");
    	for (String value : list) {
    	    joiner.add(value);
    	}
    	return joiner.toString();
    }
//    
//    public static void main(String[] args) {
//    	BipartiteGraphTestDriver driver = new BipartiteGraphTestDriver();
//    	
//    	String graph1 = "graph1";
//    	
//    	driver.createGraph(graph1);
//    	driver.addWhiteNode(graph1, "w1");
//    	driver.addBlackNode(graph1, "b1");
//    	System.out.println(driver.listBlackNodes(graph1));
//    	System.out.println(driver.listWhiteNodes(graph1));
//    	
//    	try {
//    		driver.addEdge(graph1, "b1", "w1" , "e1");
//    		driver.addEdge(graph1, "w1", "b1" , "e2");
//		} catch (Exception e) {
//			
//			e.printStackTrace();
//		}
//    	
//    	System.out.println(driver.listChildren(graph1, "b1"));
//    	System.out.println(driver.listChildren(graph1, "w1"));
//    	System.out.println(driver.listParents(graph1, "b1"));
//    	System.out.println(driver.listParents(graph1, "w1"));
//    	
//    	try {
//    		System.out.println(driver.getChildByEdgeLabel(graph1, "b1", "e1"));
//    		System.out.println(driver.getChildByEdgeLabel(graph1, "w1", "e2"));
//    		
//    		System.out.println(driver.getParentByEdgeLabel(graph1, "b1", "e2"));
//    		System.out.println(driver.getParentByEdgeLabel(graph1, "w1", "e1"));
//		} catch (Exception e) {
//			
//			e.printStackTrace();
//		}
//    } 
}
