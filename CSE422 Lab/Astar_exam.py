import sys
import heapq

def astar_search(start, goals, graph, heuristics):
    pq = [(heuristics[start], start)]
    g_score = {start: 0}
    came_from = {}
    in_pq = {start}

    while pq:
        _, current = heapq.heappop(pq)
        in_pq.discard(current)

        if current in goals:
            goal_node = current  # Store the actual goal node
            path = []
            curr = current       # Use a temporary variable to reconstruct path
            while curr in came_from:
                path.append(curr)
                curr = came_from[curr]
            path.append(start)
            path.reverse()
            return path, g_score[goal_node], goal_node

        for neighbor, cost in graph.get(current, []):
            t_score = g_score[current] + cost

            if t_score < g_score.get(neighbor, float('inf')):
                came_from[neighbor] = current
                g_score[neighbor] = t_score
                f_score = t_score + heuristics.get(neighbor, float('inf'))

                if neighbor not in in_pq:
                    heapq.heappush(pq, (f_score, neighbor))
                    in_pq.add(neighbor)

    return None, float('inf'), None

# --- Run ---
graph = {}
print("Enter input (type 'Done' to finish):")
while True:
    line = input().strip()
    if line == "Done":
        break
    if not line:
        continue
    
    parts = line.split()
    u, v, cost = parts[0], parts[1], int(parts[2])
    
    if u not in graph: 
        
        graph[u] = []
    graph[u].append((v, cost))

heuristics = {
    'A': 3, 'B': 6, 'C': 9, 'D': 12, 'E': 15, 
    'G1': 21, 'G2': 21, 'S': 57
}

print("\nExpected Output")
print("Heuristic: {'h(A)':3, 'h(B)': 6, 'h(C)': 9, 'h(D)': 12, 'h(E)': 15, 'h(G1)': 21, 'h(G2)': 21, 'h(S)': 57}")
print("-" * 70)

goals = ['G1', 'G2']
path, cost, goal_reached = astar_search("S", goals, graph, heuristics)

if path:
    print(f"Goal Reached: {goal_reached}")
    print(f"Shortest Path cost: {cost}")
    print(f"Final Path: {' => '.join(path)}")
