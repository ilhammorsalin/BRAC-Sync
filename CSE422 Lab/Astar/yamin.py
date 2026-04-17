import math
import heapq

rows, cols = 6, 6

start, end = (4,1), (1,5)

grid = [["." for _ in range(cols)] for _ in range(rows)]

grid[4][1] = "S"
grid[1][5] = "e"

for row in grid:
    print(" ".join(row))

def h(a,b):
    return math.dist(a,b)

def astar(start, end, rows, cols):
    directions = [
        (-1,0,'U',1),
        (1,0,'D',1),
        (0,-1,'L',1),
        (0,1,'R',1),
        (-1,-1,'TL',math.sqrt(2)),
        (-1,1,'TR',math.sqrt(2)),
        (1,-1,'BL',math.sqrt(2)),
        (1,1,'BR',math.sqrt(2)),
    ]
    
    pq = [ (h(start, end), 0, start, []) ]
    visited = set()
    
    while pq:
        f, g, cur, path = heapq.heappop(pq)
    
        if cur in visited: continue
        if cur == end: return path, g

        r, c = cur

        for dr, dc, move, cost in directions:
            newR, newC = r + dr, c + dc
            
            if 0 <= newR < rows and 0 <= newC < cols:
                t = g + cost

                if (newR, newC) not in visited: 
                    f = t + h((newR, newC), end)
                    heapq.heappush(pq, (f, t, (newR, newC), path + [move]))
    return None, 0

path, total_cost = astar(start, end, rows, cols)

print("--- A* Output ---")
print(f"Shortest Route Sequence: {' > '.join(path)}")
print(f"Total Unit Cost: {total_cost:.2f}")
