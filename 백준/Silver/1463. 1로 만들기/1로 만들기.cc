#include <iostream>
using namespace std;

int main() {
    int n;
    cin >> n;
    
    int cache[1000001];
    cache[1] = 0;
    
    for (int i = 2; i <= n; ++i) {
        if (i % 3 != 0 && i % 2 != 0) cache[i] = cache[i - 1] + 1;
        else if (i % 3 != 0) cache[i] = min(cache[i - 1] + 1, cache[i / 2] + 1);
        else if (i % 2 != 0) cache[i] = min(cache[i - 1] + 1, cache[i / 3] + 1);
        else cache[i] = min(min(cache[i - 1] + 1, cache[i / 2] + 1), cache[i / 3] + 1);
    }
    
    cout << cache[n] << endl;
}