import java.util.Scanner;
import java.util.ArrayList;

class Solution {
    static int[] parent;
    static ArrayList<Integer>[] children;
    static int[] depth;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int t = 1; t <= T; t++) {
            int V = sc.nextInt();
            int E = sc.nextInt();
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();
            
            parent = new int[V + 1];
            children = new ArrayList[V + 1];
            depth = new int[V + 1];
            
            for (int i = 0; i <= V; i++) {
                children[i] = new ArrayList<>();
            }
            
            for (int i = 0; i < E; i++) {
                int p = sc.nextInt();
                int c = sc.nextInt();
                parent[c] = p;
                children[p].add(c);
            }
            
            // Calculate depths
            calcDepth(1, 0);
            
            // Find LCA
            int lca = findLCA(node1, node2);
            
            // Count subtree size
            int size = countSubtree(lca);
            
            System.out.println("#" + t + " " + lca + " " + size);
        }
    }
    
    static void calcDepth(int node, int d) {
        depth[node] = d;
        for (int child : children[node]) {
            calcDepth(child, d + 1);
        }
    }
    
    static int findLCA(int a, int b) {
        // Bring both nodes to same depth
        while (depth[a] > depth[b]) a = parent[a];
        while (depth[b] > depth[a]) b = parent[b];
        
        // Move both up until they meet
        while (a != b) {
            a = parent[a];
            b = parent[b];
        }
        return a;
    }
    
    static int countSubtree(int node) {
        int count = 1;
        for (int child : children[node]) {
            count += countSubtree(child);
        }
        return count;
    }
}