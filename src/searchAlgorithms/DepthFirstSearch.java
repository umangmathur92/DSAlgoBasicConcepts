package searchAlgorithms;

import java.util.Iterator;
import java.util.LinkedList;

// This class represents a directed graph using adjacency list representation
class Graph {

    private int V; // No. of vertices
    private LinkedList<Integer> adj[]; // Array  of lists for Adjacency List Representation

    Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList();
        }
    }

    public static void main(String args[]) {
        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);
        System.out.println("Following is Depth First Traversal (starting from vertex 2)");
        graph.DFS(2);
    }

    void addEdge(int v, int w) {
        adj[v].add(w); // Add w to v's list.
    }

    void DFS(int v) {
        boolean visited[] = new boolean[V]; // Mark all the vertices as not visited(set as false by default in java)
        DFSUtil(v, visited); // Call the recursive helper function to print DFS traversal
    }

    void DFSUtil(int v, boolean visited[]) {
        visited[v] = true; // Mark the current node as visited and print it
        System.out.print(v + " ");
        Iterator<Integer> i = adj[v].listIterator(); // Recur for all the vertices adjacent to this vertex
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n]) {
                DFSUtil(n, visited);
            }
        }
    }


}
