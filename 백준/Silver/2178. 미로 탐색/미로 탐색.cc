#define _CRT_NO_SECURE_WARNINGS
#include <cstdio>
#include <cstdbool>
#include <cstdlib>
#define MAX_QUEUE_SIZE 10001

typedef struct {
    int row;
    int col;
    int cnt;
} element;

element queue[MAX_QUEUE_SIZE];
int dirY[4] = {0, 1, 0, -1};
int dirX[4] = {1, 0, -1, 0};
int front = -1, rear = -1, row, col;

int **board, **result;
bool **visited;

void push(int row, int col, int cnt) {
    rear = (rear + 1) % MAX_QUEUE_SIZE;
    
    queue[rear].row = row;
    queue[rear].col = col;
    queue[rear].cnt = cnt;
}

element pop() {
    front = (front + 1) % MAX_QUEUE_SIZE;
    
    return queue[front];
}

bool isEmpty() {
    return front == rear;
}

bool isRange(int y, int x) {
    return y >= 0 && y < row && x >= 0 && x < col;
}

void bfs(int startY, int startX) {
    push(startY, startX, 1);
    visited[startY][startX] = true;
    result[startY][startX] = 1;
    
    while(!isEmpty()) {
        element now = pop();
        
        for (int d = 0; d < 4; ++d) {
            int nexty = now.row + dirY[d];
            int nextx = now.col + dirX[d];
            int nextCnt = now.cnt + 1;
            
            if (isRange(nexty, nextx) && !visited[nexty][nextx] && board[nexty][nextx] == 1) {
                visited[nexty][nextx] = true;
                push(nexty, nextx, nextCnt);
                result[nexty][nextx] = nextCnt;
            }
        }
    }
}


int main() {
    scanf("%d %d", &row, &col);
    
    board = (int**)malloc(sizeof(int*) * row);
    result = (int**)malloc(sizeof(int*) * row);
    visited = (bool**)malloc(sizeof(bool*) * row);
    
    for (int i = 0; i < row; ++i) {
        board[i] = (int*)malloc(sizeof(int) * col); 
        result[i] = (int*)malloc(sizeof(int) * col);
        visited[i] = (bool*)malloc(sizeof(bool) * col);
    }
    
    char line[101];
    
    for (int i = 0; i < row; ++i) {
        scanf("%s", line);
        for (int j = 0; j < col; ++j) {
            board[i][j] = line[j] - '0';
            visited[i][j] = false;
            result[i][j] = 0;
        }
    }
    
    bfs(0, 0);
    
    printf("%d", result[row - 1][col - 1]);
    
    for (int i = 0; i < row; ++i) {
        free(board[i]);
        free(result[i]);
        free(visited[i]);
    }
    
    free(board);
    free(result);
    free(visited);
}