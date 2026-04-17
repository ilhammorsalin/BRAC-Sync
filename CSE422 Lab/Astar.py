import heapq

# S A 5
# S B 2
# A C 4
# A D 9
# B D 6
# C G1 7
# D E 1
# E G2 2
# Done

def Astar(start, goal, graph, h):
    pq = [(start, h[start])]
    in_pq = {start}
    gScore = {start:0}
    cameFrom = {start:None}

    while pq is not None:
        cur, _ = heapq.heappop(pq)
        in_pq.discard(cur)
        if cur is goal:
            g = cur
            path = []
            while cur in cameFrom:
                path.append(cur)
                cur = cameFrom[cur]
            path.append(start)
            path.reverse()
            return path, gScore[goal], g
        for n, cost in graph.get(cur, []):
            tScore = gScore[cur] + cost
            if tScore <= gScore[n]:
                cameFrom[n] = cur
                gScore[n] = tScore
                if n not in pq:
                    heapq.heappush(pq, (n, tScore+h[n]))
    return None, 0, None



graph = {}
print("Enter: ")
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

goals = ["G1", "G2"]
path, cost, goal = Astar("S", goals, graph, heuristics)

if path is not None:
    print(path)
    print(cost)
    print(goal)
else:
    print("Error")