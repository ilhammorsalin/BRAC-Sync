import heapq

n, m = map(int, input().split())
start_r, start_c = map(int, input().split())
end_r, end_c = map(int, input().split())


maze = []
for _ in range(n):
    maze.append(input().strip())

# 3. Heuristic Function
def h(r, c):
    return abs(r - end_r) + abs(c - end_c)

# 4. A* Algorithm
def solve_maze():
    pq = [(h(start_r, start_c), 0, start_r, start_c, "")] # f, g, r, c, path
    visited = set()
    directions = [(-1, 0, 'U'), (1, 0, 'D'), (0, -1, 'L'), (0, 1, 'R')]

    while pq:
        f, g, r, c, path = heapq.heappop(pq)

        if (r, c) in visited:
            continue
        visited.add((r, c))

        if r == end_r and c == end_c:
            return g, path

        for dr, dc, move in directions:
            nr, nc = r + dr, c + dc
            if 0 <= nr < n and 0 <= nc < m and maze[nr][nc] == '0':
                if (nr, nc) not in visited:
                    new_g = g + 1
                    heapq.heappush(pq, (new_g + h(nr, nc), new_g, nr, nc, path + move))
                    
    return -1, ""

# 5. Run and Print
cost, path = solve_maze()

if cost != -1:
    print(cost)
    print(path)
else:
    print("-1")