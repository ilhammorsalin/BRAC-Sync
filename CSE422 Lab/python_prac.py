import sys
import heapq


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

for n, c in graph.get("S", []):
    print(n, c)
