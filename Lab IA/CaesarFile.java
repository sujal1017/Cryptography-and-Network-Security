import java.io.*;
import java.util.Scanner;

public class CaesarFile {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter key: ");
        int key = sc.nextInt();
        key = ((key % 26) + 26) % 26;

        BufferedReader br = new BufferedReader(
            new FileReader("input.txt"));

        String text = br.readLine();
        br.close();

        text = text.toUpperCase();

        String result = "";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (ch >= 'A' && ch <= 'Z') {
                ch = (char) ((ch - 'A' + key) % 26 + 'A');
            }

            result += ch;
        }

        FileWriter fw = new FileWriter("output.txt");
        fw.write(result);
        fw.close();

        System.out.println("Encrypted text saved to output.txt");

        sc.close();
    }
}