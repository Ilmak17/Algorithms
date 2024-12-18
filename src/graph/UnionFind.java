package graph;

class UnionFind {
    private final int[] parent;
    private final int[] rank;
    private int components;

    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        components = n;

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void union(int x, int y) {
        int xSet = find(x);
        int ySet = find(y);

        if (xSet == ySet) {
            return;
        }

        if (rank[xSet] > rank[ySet]) {
            parent[ySet] = xSet;
        } else if (rank[xSet] < rank[ySet]) {
            parent[xSet] = ySet;
        } else {
            parent[ySet] = xSet;
            rank[xSet]++;
        }
        components--;
    }

    public int getComponents() {
        return components;
    }
}
