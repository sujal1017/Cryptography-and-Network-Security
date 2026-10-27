import java.util.Scanner;

public class ColumnarCipher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter plaintext: ");
        String text = sc.nextLine().replace(" ", "").toUpperCase();

        System.out.print("Enter key (e.g. 3142): ");
        String key = sc.nextLine();

        int cols = key.length();
        int rows = (int) Math.ceil((double) text.length() / cols);

        char[][] matrix = new char[rows][cols];

        int k = 0;

        // Fill matrix row by row
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (k < text.length())
                    matrix[i][j] = text.charAt(k++);
                else
                    matrix[i][j] = 'X';
            }
        }

        String result = "";

        // Read columns according to key order
        for (char digit = '1'; digit <= '9'; digit++) {
            for (int j = 0; j < cols; j++) {
                if (key.charAt(j) == digit) {
                    for (int i = 0; i < rows; i++) {
                        result += matrix[i][j];
                    }
                }
            }
        }
        System.out.println("Encrypted: " + result);
        sc.close();
    }
}