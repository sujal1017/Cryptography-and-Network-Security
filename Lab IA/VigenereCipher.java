// C = (P + K) \ mod 26
//Logic: Each plaintext letter is shifted using the corresponding letter of a repeating keyword.

import java.util.Scanner;

public class VigenereCipher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter plaintext: ");
        String text = sc.nextLine().toUpperCase();

        System.out.print("Enter key: ");
        String key = sc.nextLine().toUpperCase();

        String result = "";

        for (int i = 0; i < text.length(); i++) {
            int P = text.charAt(i) - 'A';
            int K = key.charAt(i % key.length()) - 'A';

            int C = (P + K) % 26;

            result += (char) (C + 'A');
        }

        System.out.println("Encrypted text: " + result);

        sc.close();
    }
}