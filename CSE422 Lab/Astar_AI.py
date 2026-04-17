import heapq

def astar_search(start, goal, graph, heuristics):
    pq = [(heuristics[start], start)]
    g_score = {start: 0}
    came_from = {}
    in_pq = {start}

    while pq:
        _, current = heapq.heappop(pq)
        in_pq.discard(current)

        if current == goal:
            path = []
            while current in came_from:
                path.append(current)
                current = came_from[current]
            path.append(start)
            path.reverse()
            return path, g_score[goal]

        for neighbor, cost in graph.get(current, []):
            t_score = g_score[current] + cost

            if t_score < g_score.get(neighbor, float('inf')):
                came_from[neighbor] = current
                g_score[neighbor] = t_score
                f_score = t_score + heuristics[neighbor]

                if neighbor not in in_pq:
                    heapq.heappush(pq, (f_score, neighbor))
                    in_pq.add(neighbor)

    return None, float('inf')


# --- Run ---
heuristics = {
    "A": 366, "B": 374, "C": 329, "D": 244,
    "E": 253, "F": 178, "G": 193, "H": 98, "I": 0
}

graph = {
    "A": [("B", 75), ("C", 118), ("E", 140)],
    "B": [],
    "C": [("D", 111)],
    "D": [],
    "E": [("G", 80), ("F", 99)],
    "F": [("I", 211)],
    "G": [("H", 97)],
    "H": [("I", 101)],
    "I": []
}

path, cost = astar_search("A", "I", graph, heuristics)
print(path)   # ['A', 'E', 'G', 'H', 'I']
print(cost)   # 418