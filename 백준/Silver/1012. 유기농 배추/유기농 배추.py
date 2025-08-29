import sys
from collections import deque

def inRange(y, x):
    return y >= 0 and y < N and x >= 0 and x < M

def bfs(y, x):
    queue = deque()
    queue.append([y, x])
    visited[y][x] = True
    
    while queue:
        pos = queue.popleft()
        
        for dy, dx in [(1,0), (0,1), (-1,0), (0, -1)]:
            ny, nx = dy + pos[0], dx + pos[1]
            if inRange(ny, nx) and not visited[ny][nx] and board[ny][nx] == 1:
                queue.append([ny, nx])
                visited[ny][nx] = True

T = int(sys.stdin.readline())

for _ in range(T):
    M, N, K = map(int, sys.stdin.readline().split())
    board = [[0] * M for _ in range(N)]
    visited = [[False] * M for _ in range(N)]
    
    for _ in range(K):
        x, y = map(int, sys.stdin.readline().split())
        board[y][x] = 1
        
    cnt = 0
    for i in range(N):
        for j in range(M):
            if board[i][j] == 1 and not visited[i][j]:
                bfs(i, j)
                cnt += 1
                
    print(cnt)
        
        