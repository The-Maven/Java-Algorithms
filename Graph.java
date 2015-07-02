
// Anthony K. Kwawu
// undirected weighted graph.

import java.util.*;
import java.io.*;

public class Graph {

  private int size; // Number of vertices
  private ArrayList<LinkedList<Edge>> adjacentNodes; // Adjacency lists
  private ArrayList<String> nodeLabels; // Node Labels

  // Inner class that represents the edges
  public static class Edge {
    private int v1;
    private int v2;
    private double weight;

    public Edge(int v1, int v2, double weight) {
      this.v1 = v1;
      this.v2 = v2;
      this.weight = weight;
    }
  }

  // Constructs graph with vertices of defined size
  public Graph(int size) {
    adjacentNodes = new ArrayList<LinkedList<Edge>>(size);
    for (int i=0; i<size; i++)
      adjacentNodes.add(new LinkedList<Edge>());
    
    nodeLabels = new ArrayList<String>(size);
    for (int i=0; i<size; i++)
      nodeLabels.add(Integer.toString(i));
  }

  // Creates a graph from a file
  public Graph(String filename) {
    try {
      Scanner scanner = new Scanner(new File(filename));

      // Take care of Nodes
      size = scanner.nextInt();
      adjacentNodes = new ArrayList<LinkedList<Edge>>(size);
      for (int i=0; i<size; i++)
        adjacentNodes.add(new LinkedList<Edge>());
      
      // Get Node nodeLabels
      nodeLabels = new ArrayList<String>(size);
      for (int i=0; i<size; i++) {
        String label = scanner.next();
        nodeLabels.add(label);
      }

      // Get Edges.
      while (scanner.hasNextInt()) {
        int v1 = scanner.nextInt();
        int v2 = scanner.nextInt();
        double weight = scanner.nextDouble();
        addEdge(v1, v2, weight);
      }
      
      scanner.close();
      
    } catch (FileNotFoundException e) {
      System.out.println("Error: could not find file "+filename);
      System.exit(0);
    } catch (InputMismatchException e) {
      System.out.println("Error: incorrect format in "+filename);
      System.exit(0);
    }
  }

    // Saves the graph to a file
  public void save(String filename) {
    try {
      FileWriter writer = new FileWriter(new File(filename));
      writer.write(size+"\n");
      for (String label : nodeLabels)
        writer.write(label+"\n");
      for (int i=0; i<size; i++)
        for (Edge edge : adjacentNodes(i))
          writer.write(edge.v1+" "+edge.v2+" "+edge.weight+"\n");
    } catch (IOException e) {
      System.out.println("Error: could not save graph.");
      System.exit(0);
    }
  }
  
    // Gets the  list of neighbours a Node has.
  public LinkedList<Edge> adjacentNodes(int v) {
    return adjacentNodes.get(v);
  }
  
    // Returns the size of the graph
  public int size() {
    return size;
  }

  // Adds an edge to the graph (undirected)
  public void addEdge(int v1, int v2, double weight) {
    Edge edge1 = new Edge(v1, v2, weight);
    adjacentNodes(v1).add(edge1);
    Edge edge2 = new Edge(v2, v1, weight);
    adjacentNodes(v2).add(edge2);
  }
  
  // Sets the label of a Node
  public void setLabel(int v, String label) {
    nodeLabels.set(v, label);
  }

    // Gets the label associated with a node
  public String getLabel(int v) {
    return nodeLabels.get(v);
  }
  
  // Get the index that goes with a label
  public int getNodeNumber(String label) {
    for (int i=0; i<size; i++)
      if (nodeLabels.get(i).equals(label))
        return i;
    return -1;
  }


  // Breadth-first search - fills in the provided arrays
  public void bfs_Algorithm(int s, int[] length, int[] parent) {

    for (int i=0; i<size; i++) {
      length[i] = Integer.MAX_VALUE;
      parent[i] = -1;
    }

    length[s] = 0;
    parent[s] = s;

    LinkedList<Integer> queue = new LinkedList<Integer>();
    queue.addLast(s);

    while (!queue.isEmpty()) {
      s = queue.pollFirst();
      
      for (Edge edge : adjacentNodes(s)) {
        if (parent[edge.v2] == -1) {
          
          length[edge.v2] = length[s] + 1;
          parent[edge.v2] = s;
          queue.addLast(edge.v2);
        }
      }
    }
  }

  // Dijkstra's algorithm  - populates given array
  public void dijkstra_Algorithm(int s, double[] distance, int[] parent) {

    for (int i=0; i<size; i++) {
      distance[i] = Double.MAX_VALUE;
      parent[i] = -1;
    }

    distance[s] = 0;
    parent[s] = s;

    PriorityQueue<Node> queue = new PriorityQueue<Node>();
    for (int i=0; i<size; i++) {
      queue.offer(new Node(i, distance[i]));
    }

    while (!queue.isEmpty()) {
      Node v1 = queue.poll();
      
      for (Edge edge : adjacentNodes(v1.v)) {
        if (distance[edge.v2] > distance[edge.v1]+edge.weight) {
          
          Node neighbouringNode = new Node(edge.v2, distance[edge.v2]);
          queue.remove(neighbouringNode);
          
          distance[edge.v2] = distance[edge.v1]+edge.weight;
          parent[edge.v2] = edge.v1;
          
          neighbouringNode.priority = distance[edge.v2];
          queue.offer(neighbouringNode);
        }
      }
    }
  }
  
  //use in priority queue
  private class Node implements Comparable {
    int v;
    double priority;
    
    public Node(int v, double p) {
      this.v = v;
      priority = p;
    }

    // Defines the order in the priority queue
    public int compareTo(Object obj) {
      assert(obj instanceof Node);
      
      Node other = (Node)obj;
      if (this.priority < other.priority)
        return -1;
      else if (this.priority > other.priority)
        return 1;
      else
        return 0;
    }
  }
  
  // Gets the weight of an edge
  public double getEdgeWeight(int v1, int v2) {
    for (Edge edge : adjacentNodes(v1)) {
      if (edge.v2 == v2)
        return edge.weight;
    }
    return Double.MAX_VALUE;
  }
  
  

  // Supply a parent and print the path between two nodes
  public void printPath(int s, int d, int[] parent) {

    if (parent[d] == -1)
      System.out.println("no path from "+nodeLabels.get(s)+" to "+nodeLabels.get(d));

    else {
      String path = "->"+nodeLabels.get(d);
      while (parent[d] != s) {
        d = parent[d];
        path = "->"+nodeLabels.get(d)+path;
      }

      path = nodeLabels.get(s)+path;
      System.out.println(path);
    }
  }
    // Displays graph
  public void print() {
    for (int i=0; i<size; i++) {
      System.out.print(nodeLabels.get(i)+" --->>> ");
      for (Edge edge : adjacentNodes(i))
        System.out.print(nodeLabels.get(edge.v2)+"("+edge.weight+") ");
          System.out.println();
    }
  }

}