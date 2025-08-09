import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class adjMatrix {

    public static void main(String[] args) {
        adjMatrix m1 = new adjMatrix(new int[][] {
            {0, 5, 0, 0, 0, 0, 0}, 
            {5, 0, 0, 0, 0, 0, 0},
            {0, 3, 0, 0, 0, 0, 0}, 
            {0, 6, 4, 0, 0, 0, 0}, 
            {7, 0, 0, 2, 7, 0, 0},
            {11, 0, 0, 9, 10, 0, 0}, 
            {0, 0, 8, 0, 11, 0, 0}
            }
        );

        adjMatrix m2 = new adjMatrix(new int[][] 
            {
                {0, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0}, 
                {0, 1, 0, 0, 0, 0, 0}, 
                {0, 1, 1, 0, 0, 1, 0},  
                {1, 0, 0, 1, 1, 0, 0}, 
                {1, 0, 0, 0, 1, 0, 0}, 
                {0, 0, 1, 0, 1, 0, 0},
            }
        
        );


        m1.BFS(6);

        m2.DFS(6);
    }

    int[][] arr;

    adjMatrix(int size) {
        arr = new int[size][size];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = 0;
            }
        }
    }

    adjMatrix(int[][] arr) {
        this.arr = arr;
    }

    void insert(int src, int dst){
        arr[src][dst] = 1;
        arr[dst][src] = 1;
    }

    void display() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(i + ": ");
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] == 1) {
                    System.out.print(j + ", ");
                }
            }
            System.out.println();
        }
    }

    void BFS(int start) {

        int size = arr.length;
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[size];
        q.add(start);

        while (!q.isEmpty()) {

            int n = q.poll();
            if (visited[n]) {
                continue;
            }
            visited[n] = true;
            System.out.print(n + " > ");

            for (int i = 0; i < size; i++) {
                if (arr[n][i] != 0 && !visited[i]) {
                    q.add(i);
                }
            }
        }
        System.out.println();

    }

    void DFS(int start) {

        int size = arr.length;
        Stack<Integer> q = new Stack<Integer>();
        boolean[] visited = new boolean[size];
        q.add(start);

        while (!q.isEmpty()) {

            int n = q.pop();
            if (visited[n]) {
                continue;
            }
            visited[n] = true;
            System.out.print(n + " > ");

            for (int i = 0; i < size; i++) {
                if (arr[n][i] != 0 && !visited[i]) {
                    q.add(i);
                }
            }
        }
        System.out.println();

    }

}
