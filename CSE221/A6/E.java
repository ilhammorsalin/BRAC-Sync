import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class E {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
        }

       
        Set<Character> allChars = new HashSet<>();
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        
        for (String word : words) {
            for (char c : word.toCharArray()) {
                allChars.add(c);
                graph.putIfAbsent(c, new HashSet<>());
                indegree.putIfAbsent(c, 0);
            }
        }

    
        for (int i = 0; i < n - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];

            
            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                System.out.println(-1);
                return;
            }

          
            int minLen = Math.min(word1.length(), word2.length());
            for (int j = 0; j < minLen; j++) {
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);

                if (c1 != c2) {
                   
                    if (!graph.get(c1).contains(c2)) {
                        graph.get(c1).add(c2);
                        indegree.put(c2, indegree.get(c2) + 1);
                    }
                    break;
                }
            }
        }

        
        PriorityQueue<Character> pq = new PriorityQueue<>();
        for (char c : allChars) {
            if (indegree.get(c) == 0) {
                pq.offer(c);
            }
        }

        StringBuilder result = new StringBuilder();

        while (!pq.isEmpty()) {
            char current = pq.poll();
            result.append(current);

            for (char neighbor : graph.get(current)) {
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                if (indegree.get(neighbor) == 0) {
                    pq.offer(neighbor);
                }
            }
        }

    
        if (result.length() != allChars.size()) {
            System.out.println(-1);
        } else {
            System.out.println(result.toString());
        }
    }
}
