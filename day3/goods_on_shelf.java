import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[] a = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            Map<Integer, Integer> first = new HashMap<>();
            Map<Integer, Integer> last = new HashMap<>();
            
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
                if (!first.containsKey(a[i])) first.put(a[i], i);
                last.put(a[i], i);
            }

   
            if (isValid(a)) {
                sb.append("YES\n");
                continue;
            }

            int L = -1;
            Set<Integer> seen = new HashSet<>();
            for (int i = 0; i < n; i++) {
                if (i > 0 && a[i] != a[i-1] && seen.contains(a[i])) {
                    L = i;
                    break;
                }
                seen.add(a[i]);
            }

            int R = -1;
            seen.clear();
            for (int i = n - 1; i >= 0; i--) {
                if (i < n - 1 && a[i] != a[i+1] && seen.contains(a[i])) {
                    R = i;
                    break;
                }
                seen.add(a[i]);
            }

      
            Set<Integer> candidates = new HashSet<>();
            int[] criticalIndices = {L, L - 1, R, R + 1};
            
            for (int idx : criticalIndices) {
                if (idx >= 0 && idx < n) {
                    candidates.add(idx);
                    candidates.add(first.get(a[idx]));
                    candidates.add(last.get(a[idx]));
                }
            }

            // 5. Test pairs
            List<Integer> candList = new ArrayList<>(candidates);
            boolean possible = false;

            for (int i = 0; i < candList.size(); i++) {
                for (int j = i + 1; j < candList.size(); j++) {
                    int idx1 = candList.get(i);
                    int idx2 = candList.get(j);

                    swap(a, idx1, idx2);
                    if (isValid(a)) {
                        possible = true;
                        break;
                    }
                    swap(a, idx1, idx2); // Revert swap
                }
                if (possible) break;
            }

            sb.append(possible ? "YES\n" : "NO\n");
        }
        System.out.print(sb);
    }

    private static boolean isValid(int[] a) {
        Set<Integer> seen = new HashSet<>();
        int prev = -1;
        for (int x : a) {
            if (x != prev) {
                if (seen.contains(x)) return false;
                seen.add(x);
                prev = x;
            }
        }
        return true;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
