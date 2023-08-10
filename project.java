
// Base Version added.
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Pattern;

public class project {
    public static boolean isMatching(String regex, String word) {
        word = word.toLowerCase();
        regex = regex.toLowerCase();
        Boolean isMatch = Pattern.matches(regex, word);
        if (isMatch) {
            return true;
        } else {
            return false;
        }
    }

    public static String findLCS(List<String> wordList) {
        if (wordList.size() == 1) {
            return wordList.get(0);
        } else if (wordList.size() == 2) {
            int m = wordList.get(0).length();
            int n = wordList.get(1).length();
            String text1 = wordList.get(0).toLowerCase();
            String text2 = wordList.get(1).toLowerCase();

            int[][] dp = new int[m + 1][n + 1];
            for (int z = 0; z <= m; z++) {
                dp[z][0] = 0;
            }
            for (int x = 0; x <= n; x++) {
                dp[0][x] = 0;
            }

            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }

            StringBuilder lcs = new StringBuilder();
            int i = m, j = n;
            while (i > 0 && j > 0) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    lcs.insert(0, text1.charAt(i - 1));
                    i--;
                    j--;
                } else if (dp[i - 1][j] > dp[i][j - 1]) {
                    i--;
                } else {
                    j--;
                }
            }

            return lcs.toString();
        } else if (wordList.size() == 0) {
            return "No Matching words are found.";
        } else {

            int m = wordList.get(0).length();
            int n = wordList.get(1).length();
            int p = wordList.get(2).length();
            String text1 = wordList.get(0).toLowerCase();
            String text2 = wordList.get(1).toLowerCase();
            String text3 = wordList.get(2).toLowerCase();

            int[][] dp = new int[m + 1][n + 1];
            for (int z = 0; z <= m; z++) {
                dp[z][0] = 0;
            }
            for (int x = 0; x <= n; x++) {
                dp[0][x] = 0;
            }

            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }

            StringBuilder lcs = new StringBuilder();
            int i = m, j = n;
            while (i > 0 && j > 0) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    lcs.insert(0, text1.charAt(i - 1));
                    i--;
                    j--;
                } else if (dp[i - 1][j] > dp[i][j - 1]) {
                    i--;
                } else {
                    j--;
                }
            }

            String text4 = lcs.toString();
            int o = text4.length();
            int[][] dp1 = new int[p + 1][o + 1];
            for (int r = 0; r <= p; r++) {
                dp1[r][0] = 0;
            }
            for (int u = 0; u <= o; u++) {
                dp1[0][u] = 0;
            }

            for (int i1 = 1; i1 <= p; i1++) {
                for (int j1 = 1; j1 <= o; j1++) {
                    if (text3.charAt(i1 - 1) == text4.charAt(j1 - 1)) {
                        dp1[i1][j1] = dp1[i1 - 1][j1 - 1] + 1;
                    } else {
                        dp1[i1][j1] = Math.max(dp1[i1 - 1][j1], dp1[i1][j1 - 1]);
                    }
                }
            }

            StringBuilder lcs1 = new StringBuilder();
            int i2 = p, j2 = o;
            while (i2 > 0 && j2 > 0) {
                if (text3.charAt(i2 - 1) == text4.charAt(j2 - 1)) {
                    lcs1.insert(0, text3.charAt(i2 - 1));
                    i2--;
                    j2--;
                } else if (dp1[i2 - 1][j2] > dp1[i2][j2 - 1]) {
                    i2--;
                } else {
                    j2--;
                }
            }

            return lcs1.toString();
        }
    }

    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            ArrayList<String> wordsList = new ArrayList<>();
            String word;
            ArrayList<String> MatchedWord = new ArrayList<>();
            boolean isFirstLine = true;
            while ((word = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
                word = word.trim();
                wordsList.add(word);
            }
            String lastword = wordsList.get(wordsList.size() - 1);
            for (int i = 0; i < wordsList.size() - 2; i++) {
                if (isMatching(lastword, wordsList.get(i))) {
                    MatchedWord.add(wordsList.get(i));
                }
            }
            Collections.sort(MatchedWord);
            System.out.println(findLCS(MatchedWord));
        } catch (Exception io) {
            System.out.println(io);
        }
    }
}
