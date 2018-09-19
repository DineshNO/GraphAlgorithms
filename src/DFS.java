import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class DFS {

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

    private static DFS visit(DFS graph, Node nodeA){
        visit(nodeA);
        return graph;
    }

    private static void visit(Node root){
        if(root == null) return ;
        root.setState(Node.State.Visited);
        for (Node e:
             root.getAdjacentNodes().keySet()) {
            if(e.getState() == Node.State.Unvisited){
                visit(e);
            }
        }
    }
    @Override
    public String toString() {
        return "DFS{" +
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

        DFS graph = new DFS();

        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);
        graph.addNode(nodeF);

        graph = DFS.visit(graph, nodeA);
        System.out.println(graph);
    }
}
