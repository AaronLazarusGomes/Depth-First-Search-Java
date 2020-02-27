/*
Implementation of the Depth First Search Algorithm in java
we create 2 different classes 
class Node 
class DepthFirstSearch

The Node class will have the value of the node, an array/list of all it's neighbours and a boolean 
for each of the nodes so that after visiting the node we don't visit it again

The DepthFirstSearch class will have the implementation of the DFS algorithm
*/

import java.util.*;

class Node {
    int value;
    List<Node> neighbours; //if you are uncomfortable writing this then even "ArrayList<Node> neighbours;" will work
    boolean visited;

    public Node(int value) {
        this.value = value;
        this.neighbours = new ArrayList<Node>(); //initializing an array to store the neighbours of the particular nodes
    }

    public void putNeighbours(Node neighbour) {
        this.neighbours.add(neighbour); //adding the nodes
    }

    public List<Node> getNeighbours() {
        return neighbours; //returning a list of all the nodes
    }
}

class DepthFirstSearch {

    public void DFS(Node node) {
        System.out.print(node.value + " ");
        List<Node> adjacent = node.getNeighbours();  //getting the neightbours of the particular node
        node.visited = true; //marking that node as seen/true

        for (int i = 0; i < adjacent.size(); i++) {
            Node unvisited = adjacent.get(i);  //getting each node from the list returned at line 38
            if (unvisited != null && !unvisited.visited) {
                DFS(unvisited);
            }
        }
    }

    public static void main(String[] args) {
        Node node2 = new Node(2);
        Node node0 = new Node(0);
        Node node1 = new Node(1);
        Node node3 = new Node(3);

        node2.putNeighbours(node0);
        node2.putNeighbours(node1);
        node2.putNeighbours(node3);
        node0.putNeighbours(node2);
        node0.putNeighbours(node1);
        node1.putNeighbours(node0);
        node1.putNeighbours(node2);
        node3.putNeighbours(node3);
        node3.putNeighbours(node2);

        node0.visited = false;
        node1.visited = false;
        node2.visited = false;
        node3.visited = false;

        DepthFirstSearch df = new DepthFirstSearch();

        df.DFS(node2);

    }
}
