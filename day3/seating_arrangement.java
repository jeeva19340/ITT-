import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SeatingArrangement {
    static class Person implements Comparable<Person> {
        int id;       // The order they enter the hall (original 0-indexed position)
        int sight;    // Their eyesight level

        Person(int id, int sight) {
            this.id = id;
            this.sight = sight;
        }

        // Primary sort: Ascending by eyesight level
        // Secondary sort: Descending by original ID (arrival order)
        @Override
        public int compareTo(Person other) {
            if (this.sight != other.sight) {
                return Integer.compare(this.sight, other.sight);
            }
            return Integer.compare(other.id, this.id);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int t = Integer.parseInt(st.nextToken()); // Number of test cases
        StringBuilder out = new StringBuilder();

        while (t-- > 0) {
            if (!st.hasMoreTokens()) {
                String line = br.readLine();
                if (line == null) break;
                st = new StringTokenizer(line);
            }
            int n = Integer.parseInt(st.nextToken()); // Rows
            int m = Integer.parseInt(st.nextToken()); // Columns

            int totalPeople = n * m;
            Person[] people = new Person[totalPeople];

            if (!st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            for (int i = 0; i < totalPeople; i++) {
                if (!st.hasMoreTokens()) {
                    st = new StringTokenizer(br.readLine());
                }
                int sight = Integer.parseInt(st.nextToken());
                people[i] = new Person(i, sight);
            }

            // Step 1: Global Sort to assign global seating indices
            Arrays.sort(people);

            // Step 2: Fix multi-row conflicts for identical elements
            // Within the same row, higher arrival index must be on the left.
            // Across different rows, the standard sort already puts higher IDs first globally.
            // We just need to correct elements belonging to the same row chunk.
            for (int i = 0; i < totalPeople; i += m) {
                // For each row chunk, if elements with identical sights cross boundaries, 
                // we sort them by original arrival ID ascending if they are in the same row.
                // However, the cleanest way to evaluate this is by sorting individual row chunks
                // by arrival index ID to simulate the configuration.
                Arrays.sort(people, i, i + m, (p1, p2) -> Integer.compare(p1.id, p2.id));
            }

            // Step 3: Calculate the total inconvenience row by row
            long totalInconvenience = 0;
            for (int row = 0; row < n; row++) {
                for (int i = 0; i < m; i++) {
                    int currentIdx = row * m + i;
                    // Count how many people inside the same row arrived BEFORE the current person
                    for (int j = 0; j < i; j++) {
                        int previousIdx = row * m + j;
                        if (people[previousIdx].id < people[currentIdx].id) {
                            totalInconvenience++;
                        }
                    }
                }
            }
            out.append(totalInconvenience).append("\n");
        }
        System.out.print(out);
    }
}
