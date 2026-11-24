package Lab8;

import java.util.*;

public class Graph {
    private final int n;
    private final boolean directed;
    private final int[][] matrix;
    private final List<List<Integer>> adjList;

    public Graph(int n, boolean directed) {
        this.n = n;
        this.directed = directed;
        matrix = new int[n][n];
        adjList = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adjList.add(new ArrayList<>());
    }

    public int size() {
        return n;
    }

    public void addEdge(int u, int v) {
        if (matrix[u][v] == 1) return;
        matrix[u][v] = 1;
        adjList.get(u).add(v);
        if (!directed && u != v) {
            matrix[v][u] = 1;
            adjList.get(v).add(u);
        }
    }

    public boolean hasEdge(int u, int v) {
        return matrix[u][v] == 1;
    }

    public List<Integer> dfs(int start) {
        List<Integer> order = new ArrayList<>();
        boolean[] vis = new boolean[n];
        dfsRec(start, vis, order);
        return order;
    }

    private void dfsRec(int u, boolean[] vis, List<Integer> order) {
        vis[u] = true;
        order.add(u);
        for (int v : adjList.get(u))
            if (!vis[v]) dfsRec(v, vis, order);
    }

    public List<Integer> bfs(int start) {
        List<Integer> order = new ArrayList<>();
        boolean[] vis = new boolean[n];
        Queue<Integer> q = new ArrayDeque<>();
        vis[start] = true;
        q.add(start);
        while (!q.isEmpty()) {
            int u = q.poll();
            order.add(u);
            for (int v : adjList.get(u))
                if (!vis[v]) {
                    vis[v] = true;
                    q.add(v);
                }
        }
        return order;
    }

    public void printMatrix() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }
    }

    public void printList() {
        for (int i = 0; i < n; i++) {
            System.out.print(i + ": ");
            for (int v : adjList.get(i))
                System.out.print(v + " ");
            System.out.println();
        }
    }
}
