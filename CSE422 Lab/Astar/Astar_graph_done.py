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
    pq = [(h[start],start)]
    in_pq = {start}
    gScore = {start:0}
    cameFrom = {}

    while pq :
        _, cur = heapq.heappop(pq)
        in_pq.discard(cur)

        if cur in goal:
            g = cur
            path = []
            while cur in cameFrom:
                path.append(cur)
                cur = cameFrom[cur]
            path.append(start)
            path.reverse()
            return path, gScore[g], g
        
        for n, cost in graph[cur]:
            tScore = gScore[cur] + cost
            if n not in gScore or tScore <= gScore.get(n):
                cameFrom[n] = cur
                gScore[n] = tScore
                heapq.heappush(pq, (tScore+h[n], n))

    return None, 0, None



graph = {}
print("Enter: ")
while True:
    line = input().strip()
    if line == "Done":
        break
    
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