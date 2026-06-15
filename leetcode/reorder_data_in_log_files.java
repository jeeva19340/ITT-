import java.util.Arrays;

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        
        // Custom sort using a stable sorting algorithm (Arrays.sort preserves original order when returning 0)
        Arrays.sort(logs, (log1, log2) -> {
            // 1. Isolate the identifier and the content by locating the first space
            int spaceIndex1 = log1.indexOf(' ');
            String id1 = log1.substring(0, spaceIndex1);
            String content1 = log1.substring(spaceIndex1 + 1);

            int spaceIndex2 = log2.indexOf(' ');
            String id2 = log2.substring(0, spaceIndex2);
            String content2 = log2.substring(spaceIndex2 + 1);

            // 2. Identify whether each log is a digit-log or a letter-log
            boolean isDigit1 = Character.isDigit(content1.charAt(0));
            boolean isDigit2 = Character.isDigit(content2.charAt(0));

            // Case A: Both are letter-logs
            if (!isDigit1 && !isDigit2) {
                int cmp = content1.compareTo(content2);
                if (cmp != 0) {
                    return cmp; // Sort alphabetically by content
                }
                return id1.compareTo(id2); // If content is identical, sort by ID
            }

            // Case B: One is a letter-log, one is a digit-log
            if (!isDigit1 && isDigit2) return -1; // Letter-log (log1) takes priority
            if (isDigit1 && !isDigit2) return 1;  // Letter-log (log2) takes priority

            // Case C: Both are digit-logs
            return 0; // Maintain their original relative ordering
        });

        return logs;
    }
}
