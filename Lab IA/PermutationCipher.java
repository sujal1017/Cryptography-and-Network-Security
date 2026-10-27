//Logic: Rearrange characters according to a fixed permutation key.
//For the key 3 1 4 2, the third character is placed first, the first character second, and so on.

import java.util.Scanner;
public class PermutationCipher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter plaintext: ");
        String text = sc.nextLine().replace(" ", "").toUpperCase();

        System.out.print("Enter key (e.g. 3142): ");
        String key = sc.nextLine();

        int n = key.length();

        while (text.length() % n != 0) {
            text += "X";
        }
        
        String result = "";

        for (int i = 0; i < text.length(); i += n) {
            for (int j = 0; j < n; j++) {
                int pos = key.charAt(j) - '0';
                result += text.charAt(i + pos - 1);
            }
        }

        System.out.println("Encrypted: " + result);

        sc.close();
    }
}
