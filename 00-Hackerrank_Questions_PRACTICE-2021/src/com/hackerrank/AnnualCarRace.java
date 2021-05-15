package com.hackerrank;
import java.io.*;
import java.util.*;

public class AnnualCarRace {

	    public static HashMap<Integer, ArrayList<Edge1>> adjList;
	    public static ArrayList<ArrayList<Integer>> parents;
	    public static int[] costs;
	   
	    public static Comparator<EdgeDijkstra> costComparator = new Comparator<EdgeDijkstra>() {
	        public int compare(EdgeDijkstra ed1, EdgeDijkstra ed2) {
	            return ed1.cost-ed2.cost;
	        }
	    };
	 
	    public static void removeEdges(int end) {
	        Queue<Integer> curr = new ArrayDeque<Integer>();
	        curr.add(end);
	     
	        HashSet<Integer> visited = new HashSet<Integer>();
	        while (curr.size() > 0) {
	            int currPoint = curr.poll();
	            visited.add(currPoint);
	            ArrayList<Integer> list = parents.get(currPoint);
	            for (int i = 0; i < list.size(); i++) {
	                int point = list.get(i);
	                if (!visited.contains(point)) {
	                    curr.add(point);
	                }
	                ArrayList<Edge1> list2 = adjList.get(point);
	                for (int j = 0; j < list2.size(); j++) {
	                    if (list2.get(j).node == currPoint) {
	                        list2.remove(j);
	                    }
	                }
	                list2 = adjList.get(currPoint);
	                for (int j = 0; j < list2.size(); j++) {
	                    if (list2.get(j).node == point) {
	                        list2.remove(j);
	                    }
	                }
	            }
	        }
	    }
	 
	    public static int dijkstra2(int start, int end, int numPoints) {
	        Queue<EdgeDijkstra> queue = new PriorityQueue<EdgeDijkstra>(numPoints, costComparator);
	        queue.add(new EdgeDijkstra(start, 0, start));
	     
	        HashSet<Integer> visited = new HashSet<Integer>();
	     
	        while (queue.size() > 0) {
	            EdgeDijkstra curr = queue.poll();
	            int currNode = curr.node;
	            int currCost = curr.cost;
	            int currParent = curr.parent;
	         
	            if (visited.contains(currNode)) {
	                continue;
	            }
	            visited.add(currNode);
	         
	            if (currNode == end) {
	                return currCost;
	            }
	         
	            ArrayList<Edge1> reachNodes = adjList.get(currNode);
	            for (int i = 0; i < reachNodes.size(); i++) {
	                queue.add(new EdgeDijkstra(reachNodes.get(i).node, reachNodes.get(i).cost+currCost, currNode));
	            }
	        }
	     
	        return -1;
	    }
	 
	    public static void dijkstra(int start, int end, int numPoints) {
	        Queue<EdgeDijkstra> queue = new PriorityQueue<EdgeDijkstra>(numPoints, costComparator);
	        queue.add(new EdgeDijkstra(start, 0, start));
	     
	        HashSet<Integer> visited = new HashSet<Integer>();
	     
	        boolean firstAnswer = true;
	        int shortestPathCost = 0;
	        while (queue.size() > 0) {
	            EdgeDijkstra curr = queue.poll();
	            int currNode = curr.node;
	            int currCost = curr.cost;
	            int currParent = curr.parent;

	            if (currNode != start && costs[currNode] > currCost) {
	                costs[currNode] = currCost;
	                for (int i = 0; i < parents.get(currNode).size(); i++) {
	                    parents.get(currNode).remove(i);
	                }
	                parents.get(currNode).add(currParent);
	            }
	            else if (currNode != start && costs[currNode] == currCost) {
	                parents.get(currNode).add(currParent);
	            }
	         
	            if (visited.contains(currNode)) {
	                continue;
	            }
	            visited.add(currNode);
	         
	            ArrayList<Edge1> reachNodes = adjList.get(currNode);
	            for (int i = 0; i < reachNodes.size(); i++) {
	                queue.add(new EdgeDijkstra(reachNodes.get(i).node, reachNodes.get(i).cost+currCost, currNode));
	            }
	        }

	        removeEdges(end);
	        return;
	    }
	   
	    public static int reader(BufferedReader br) throws NumberFormatException, IOException {   
	        int n;
	        int resp = 0;   
	    
	        while (true) {       
	            n = br.read();       
	            if (n >= '0' && n <= '9') {
	                break;
	            }
	        }
	         
	        while (true) {       
	            resp = resp*10 + n-'0';       
	            n = br.read();       
	            if (n < '0' || n > '9') {
	                break;   
	            }
	        }
	    
	        return resp;   
	    }
	   
	    public static void main(String[] args) throws NumberFormatException, IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	       
	        int numTests = reader(br);
	        for (int i = 0; i < numTests; i++) {
	            int numStops = reader(br);
	            int numRoads = reader(br);
	            int start = reader(br);
	            int dest = reader(br);
	           
	            adjList = new HashMap<Integer, ArrayList<Edge1>>();
	            for (int j = 0; j < numStops; j++) {
	                adjList.put(j, new ArrayList<Edge1>());   
	            }
	           
	            for (int j = 0; j < numRoads; j++) {
	                int n1 = reader(br);
	                int n2 = reader(br);
	                int cost = reader(br);
	               
	                adjList.get(n1).add(new Edge1(n2, cost));
	                adjList.get(n2).add(new Edge1(n1, cost));
	            }
	           
	            parents = new ArrayList<ArrayList<Integer>>();
	            for (int j = 0; j < numStops; j++) {
	                parents.add(new ArrayList<Integer>());
	            }
	            costs = new int[numStops];
	            for (int j = 0; j < numStops; j++) {
	                costs[j] = 2000000000;
	            }
	            dijkstra(start, dest, numStops);
	           
	            parents = new ArrayList<ArrayList<Integer>>();
	            for (int j = 0; j < numStops; j++) {
	                parents.add(new ArrayList<Integer>());
	            }
	            costs = new int[numStops];
	            for (int j = 0; j < numStops; j++) {
	                costs[j] = 2000000000;
	            }
	            dijkstra(start, dest, numStops);
	         
	            System.out.println(dijkstra2(start, dest, numStops));
	        }
	    }
	}

  class Edge1 {
	    int node;
	    int cost;
	   
	    public Edge1(int n, int c) {
	        node = n;
	        cost = c;
	    }
	}

	class EdgeDijkstra {
	    int node;
	    int cost;
	    int parent;
	   
	    public EdgeDijkstra(int n, int c, int p) {
	        node = n;
	        cost = c;
	        parent = p;
	    }
	}