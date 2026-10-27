//	Caesar Cipher	Shifts each letter by a fixed number

import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.nextLine().toUpperCase();

        System.out.print("Enter key: ");
        int key = sc.nextInt();

        String result = "";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (ch >= 'A' && ch <= 'Z') {
                ch = (char) ((ch - 'A' + key) % 26 + 'A');
            }

            result += ch;
        }

        System.out.println("Encrypted: " + result);
        sc.close();
    }
}