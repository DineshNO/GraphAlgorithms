import java.util.*;

public class BFS {

    private Set<Node> nodes = new HashSet<>();

    public Set<Node> getNodes() {
        return nodes;
    }

    public void setNodes(Set<Node> nodes) {
        this.nodes = nodes;
    }

    public void addNode(Node nodeA) {
        nodes.add(nodeA);
    }
    
    private static BFS visit(BFS graph, Node nodeA){
        LinkedList<Node> unvisitedNodes = new LinkedList<>();
        unvisitedNodes.add(nodeA);
        nodeA.setState(Node.State.Visited);
        Node current;
        while(!unvisitedNodes.isEmpty()){
            current = unvisitedNodes.removeFirst();
            for (Node e:current.getAdjacentNodes().keySet()) {
                if(e.getState() == Node.State.Unvisited){
                    e.setState(Node.State.Visited);
                    unvisitedNodes.add(e);
                }
            }
        }
        return graph;
    }

    @Override
    public String toString() {
        return "BFS{" +
                "nodes=" + nodes +
                '}';
    }

    public static void main(String[] args) {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");

        nodeA.addDestination(nodeB, 10);
        nodeA.addDestination(nodeC, 15);

        nodeB.addDestination(nodeD, 12);
        nodeB.addDestination(nodeF, 15);

        nodeC.addDestination(nodeE, 10);

        nodeD.addDestination(nodeE, 2);
        nodeD.addDestination(nodeF, 1);

        nodeF.addDestination(nodeE, 5);

        BFS graph = new BFS();

        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);
        graph.addNode(nodeF);

        graph = BFS.visit(graph, nodeA);
        System.out.println(graph);
    }
}
