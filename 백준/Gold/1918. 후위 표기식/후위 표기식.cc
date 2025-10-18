#define _CRT_SECURE_NO_WARNINGS
#include <cstdio>

#define MAX_STACK_SIZE 101

typedef enum {
    lparen, rparen, plus, minus, times, divide, mod, eos, operand
} precedence;

precedence stack[MAX_STACK_SIZE];
char expr[MAX_STACK_SIZE];

int top = -1;

int isp[] = {0, 19, 12, 12, 13, 13, 13, 0};
int icp[] = {20, 19, 12, 12, 13, 13, 13, 0};

precedence get_token(char *symbol, int *n) {
    *symbol = expr[(*n)++];
    
    switch (*symbol) {
        case '(': return lparen;
        case ')': return rparen;
        case '+': return plus;
        case '-': return minus;
        case '*': return times;
        case '/': return divide;
        case '%': return mod;
        case '\0': return eos;
        default: return operand;
    }
}

void push(precedence p) {
    stack[++top] = p;
}

precedence pop() {
    return stack[top--];
}

void print_token(precedence p) {
    char ch;
    
    switch (p) {
        case lparen:
            ch = '(';
            break;
            
        case rparen:
            ch = ')';
            break;
            
        case plus:
            ch = '+';
            break;
            
        case minus:
            ch = '-';
            break;
            
        case times:
            ch = '*';
            break;
        
        case divide:
            ch = '/';
            break;
            
        case mod:
            ch = '%';
            break;
            
        case eos:
            ch = '\0';
            break;
    }
    
    printf("%c", ch);
}

void postfix() {
    precedence token;
    char symbol;
    int n = 0;
    
    push(eos);
    
    for (token = get_token(&symbol, &n); token != eos; token = get_token(&symbol, &n)) {
        if (token == operand) {
            printf("%c", symbol);
        } else if (token == rparen) {
            while (stack[top] != lparen) {
                print_token(pop());
            }
            pop();
        } else {
            while (isp[stack[top]] >= icp[token]) {
                print_token(pop());
            }
            push(token);
        }
    }
    
    while ((token = pop()) != eos) {
        print_token(token);
    }
}

int main() {
    scanf("%s", expr);
    
    postfix();
}
