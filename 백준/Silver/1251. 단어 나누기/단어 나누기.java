import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine().trim();
        final int n = input.length();
        String a = "~";
        for (int i = 1; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                String b = (new StringBuilder(input.substring(0, i)).reverse())
                        .append(new StringBuilder(input.substring(i, j)).reverse())
                        .append(new StringBuilder(input.substring(j/*, n*/)).reverse())
                        .toString();
                if (a.compareTo(b) > 0)
                    a = b;
            }
        }

        System.out.println(a);
    }
}
