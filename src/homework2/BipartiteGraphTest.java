package homework2;

import static org.junit.Assert.*;
import org.junit.Test;


/**
 * BipartiteGraphTest contains JUnit block-box unit tests for BipartiteGraph.
 */
public class BipartiteGraphTest {

	@Test
    public void testExample() throws Exception {
        BipartiteGraphTestDriver driver = new BipartiteGraphTestDriver();
        
        //create a graph
        driver.createGraph("graph1");
        
        //add a pair of nodes
        driver.addBlackNode("graph1", "n1");
        driver.addWhiteNode("graph1", "n2");
        
        //add an edge
		driver.addEdge("graph1", "n1", "n2", "edge");
        
        //check neighbors
        assertEquals("wrong black nodes", "n1", driver.listBlackNodes("graph1"));
        assertEquals("wrong white nodes", "n2", driver.listWhiteNodes("graph1"));
        assertEquals("wrong children", "n2", driver.listChildren ("graph1", "n1"));
        assertEquals("wrong children", "", driver.listChildren ("graph1", "n2"));
        assertEquals("wrong parents", "", driver.listParents ("graph1", "n1"));
        assertEquals("wrong parents", "n1", driver.listParents ("graph1", "n2"));
    }
    
    
    
	@Test
	public void test_simpleAddRemove() throws Exception {
		BipartiteGraphTestDriver driver = new BipartiteGraphTestDriver();
		
		final String graphName = "graph1";
		driver.createGraph("graph1");        
		
		driver.addBlackNode("graph1", "b1");
		driver.addBlackNode("graph1", "b2");
        
        driver.addWhiteNode("graph1", "w1");
        driver.addWhiteNode("graph1", "w2");
        
        driver.addEdge(graphName, "b1", "w1", "e_b1w1");
        driver.addEdge(graphName, "b2", "w2", "e_b2w2");
        
       
        assertEquals("wrong black nodes", "b1 b2", driver.listBlackNodes(graphName));
        assertEquals("wrong white nodes", "w1 w2", driver.listWhiteNodes(graphName));

        assertEquals("wrong children for b1", "w1", driver.listChildren(graphName, "b1"));
        assertEquals("wrong children for b2", "w2", driver.listChildren(graphName, "b2"));
        
        assertEquals("wrong children by edge for b1", "w1", driver.getChildByEdgeLabel(graphName, "b1", "e_b1w1"));
        assertEquals("wrong children by edge for b2", "w2", driver.getChildByEdgeLabel(graphName, "b2", "e_b2w2"));

        assertEquals("wrong parent for w1", "b1", driver.listParents(graphName, "w1"));
        assertEquals("wrong parent for w2", "b2", driver.listParents(graphName, "w2"));
        
        assertEquals("wrong parent by edge for w1","b1", driver.getParentByEdgeLabel(graphName, "w1", "e_b1w1"));
        assertEquals("wrong parent by edge for w2","b2", driver.getParentByEdgeLabel(graphName, "w2", "e_b2w2"));
     
	}
	
	@Test(expected = Exception.class)
	public void test_AddSameNode() throws Exception {
		BipartiteGraphTestDriver driver = new BipartiteGraphTestDriver();		
		driver.createGraph("graph1");      
		driver.addBlackNode("graph1", "b1");
		driver.addBlackNode("graph1", "b1");
		
	}
	
	@Test(expected = Exception.class)
	public void test_AddSameEdge() throws Exception {
		BipartiteGraphTestDriver driver = new BipartiteGraphTestDriver();		
		final String graphName = "graph1";
		driver.createGraph("graph1");      
		driver.addBlackNode("graph1", "b1");
		driver.addWhiteNode("graph1", "w1");
		driver.addWhiteNode("graph1", "w2");
		driver.addEdge(graphName, "b1", "w1", "e_b1w1");
		driver.addEdge(graphName, "b1", "w2", "e_b1w1");
	}
	
	@Test(expected = Exception.class)
	public void test_connectSameType() throws Exception {
		BipartiteGraphTestDriver driver = new BipartiteGraphTestDriver();
		final String graphName = "graph1";
		driver.createGraph(graphName);
		driver.addWhiteNode(graphName, "w2");
		driver.addWhiteNode(graphName, "w1");
		driver.addEdge(graphName, "w2", "w1", "e_w1w2");
	}
	
	@Test(expected = Exception.class)
	public void test_SearchNonexistentNode() throws Exception {
		BipartiteGraphTestDriver driver = new BipartiteGraphTestDriver();		
		final String graphName = "graph1";
		driver.createGraph(graphName);
		driver.addEdge(graphName, "b1", "w1", "e_b1w1");
	}
	
	@Test(expected = Exception.class)
	public void test_SearchNonexistentEdge() throws Exception {
		BipartiteGraphTestDriver driver = new BipartiteGraphTestDriver();		
		final String graphName = "graph1";
		driver.createGraph(graphName);
		driver.addWhiteNode(graphName, "w2");
		driver.getParentByEdgeLabel(graphName, "w2", "e_b2w2");
	}
}
