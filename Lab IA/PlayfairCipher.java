import java.util.Scanner;

public class PlayfairCipher {
    static char[][] matrix = new char[5][5];

    static void createMatrix(String key) {
        String s = (key + "ABCDEFGHIJKLMNOPQRSTUVWXYZ")
                .toUpperCase().replace('J', 'I');

        String unique = "";

        for (char ch : s.toCharArray()) {
            if (ch >= 'A' && ch <= 'Z' && unique.indexOf(ch) == -1) {
                unique += ch;
            }
        }

        int k = 0;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                matrix[i][j] = unique.charAt(k++);
            }
        }
    }

    static int[] find(char ch) {
        if (ch == 'J') ch = 'I';

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (matrix[i][j] == ch) {
                    return new int[]{i, j};
                }
            }
        }

        return null;
    }

    static String encrypt(String text) {
        text = text.toUpperCase().replaceAll("[^A-Z]", "")
                .replace('J', 'I');

        String prepared = "";
        int i = 0;

        while (i < text.length()) {
            char a = text.charAt(i);
            char b;

            if (i + 1 >= text.length()) {
                b = 'X';
                i++;
            } else if (a == text.charAt(i + 1)) {
                b = 'X';
                i++;
            } else {
                b = text.charAt(i + 1);
                i += 2;
            }

            prepared += a;
            prepared += b;
        }

        String result = "";

        for (i = 0; i < prepared.length(); i += 2) {
            int[] a = find(prepared.charAt(i));
            int[] b = find(prepared.charAt(i + 1));

            if (a[0] == b[0]) {
                result += matrix[a[0]][(a[1] + 1) % 5];
                result += matrix[b[0]][(b[1] + 1) % 5];
            } else if (a[1] == b[1]) {
                result += matrix[(a[0] + 1) % 5][a[1]];
                result += matrix[(b[0] + 1) % 5][b[1]];
            } else {
                result += matrix[a[0]][b[1]];
                result += matrix[b[0]][a[1]];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter key: ");
        String key = sc.nextLine();

        createMatrix(key);

        System.out.print("Enter plaintext: ");
        String text = sc.nextLine();

        System.out.println("Encrypted: " + encrypt(text));

        sc.close();
    }
}