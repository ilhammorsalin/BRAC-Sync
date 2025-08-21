import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class G {
    static int R, H;
    static char[][] grid;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        R = Integer.parseInt(line[0]);
        H = Integer.parseInt(line[1]);
        
        grid = new char[R][H];
        visited = new boolean[R][H];
        
        for (int i = 0; i < R; i++) {
            String row = br.readLine();
            for (int j = 0; j < H; j++) {
                grid[i][j] = row.charAt(j);
            }
        }
        
        int maxDiamonds = 0;
        
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < H; j++) {
                if (!visited[i][j] && grid[i][j] != '#') {
                    int diamonds = bfs(i, j);
                    maxDiamonds = Math.max(maxDiamonds, diamonds);
                }
            }
        }
        
        System.out.println(maxDiamonds);
    }
    
    static int bfs(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        visited[startX][startY] = true;
        
        int diamondCount = 0;
        if (grid[startX][startY] == 'D') {
            diamondCount++;
        }
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                
                if (isValid(newX, newY) && !visited[newX][newY] && grid[newX][newY] != '#') {
                    visited[newX][newY] = true;
                    queue.add(new int[]{newX, newY});
                    
                    if (grid[newX][newY] == 'D') {
                        diamondCount++;
                    }
                }
            }
        }
        
        return diamondCount;
    }
    
    static boolean isValid(int x, int y) {
        return x >= 0 && x < R && y >= 0 && y < H;
    }
}