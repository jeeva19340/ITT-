// Online C compiler to run C program online
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void solve() {
    int n, k;
    if (scanf("%d %d", &n, &k) != 2) return;

    // Dynamically allocate memory for the string to comfortably handle up to N = 200,000
    char *s = (char *)malloc((n + 5) * sizeof(char));
    scanf("%s", s);

    // Array to track the count of '1's for each index remainder modulo k
    // calloc initializes all elements to 0
    int *cnt = (int *)calloc(k, sizeof(int));

    for (int i = 0; i < n; i++) {
        if (s[i] == '1') {
            cnt[i % k]++;
        }
    }

    int possible = 1; // Flag assuming it is possible
    for (int i = 0; i < k; i++) {
        // If the total count of '1's in this bucket is odd, it's impossible
        if (cnt[i] % 2 != 0) {
            possible = 0;
            break;
        }
    }

    if (possible) {
        printf("YES\n");
    } else {
        printf("NO\n");
    }

    // Clean up allocated heap memory
    free(s);
    free(cnt);
}

int main() {
    // Fast I/O configuration for C standard streams
    setvbuf(stdout, NULL, _IOFBF, 16384);

    int t;
    if (scanf("%d", &t) == 1) {
        while (t--) {
            solve();
        }
    }
    return 0;
}
