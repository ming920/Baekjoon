#include <iostream>
using namespace std;

int N;
int RomeNum[4] = {1, 5, 10, 50};
bool numbers[1001] = {false, };

void makeRome(int length, int start, int num) {
    if (length == N) {
        if (!numbers[num]) {
            numbers[num] = true;
        }
        return;
    }
    
    for (int i = start; i < 4; ++i) {
        makeRome(length + 1, i, num + RomeNum[i]);
    }
}

int main() {
    cin >> N;
    
    int cnt = 0;
    
    makeRome(0, 0, 0);
    
    for (int i = 0; i < 1001; ++i) {
        if (numbers[i]) cnt++;
    }
    
    cout << cnt << endl;
}