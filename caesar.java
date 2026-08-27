import java.util.*;
public class caesar{
        public static void main(String[] args) throws Exception {
                HashMap<Character,Integer> map = new HashMap<Character,Integer>();

                // BufferedReader br = new BufferedReader(
                //         new FileReader("hello.txt")
                // );

                for(char c='a';c<='z';c++){
                        map.put(c,c-'a');
                }
                System.out.println(map);
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter the string");
                String text = sc.next();

                System.out.println("Enter the value of K");
                int k = sc.nextInt();
                int ctNum = 0;
                ArrayList<Character> list = new ArrayList<Character>();
                for(char ch : text.toCharArray()){
                        ctNum = (map.get(ch) + k) % 26;
                        char ctChar = (char)('a'+ctNum);
                        list.add(ctChar);
                }
                System.out.println(list);
                for(char ch : list){
                        System.out.print(ch);
                }
                System.out.println();


                //Crypt Analysis


                System.out.println("Possible Plane Texts");
                System.out.println();
                for(int i=0;i<26;i++){
                        for(char c : list){
                                int ptNum = (map.get(c) + 26-i) % 26;
                                char ptChar = (char)('a' + ptNum);
                                System.out.print(ptChar);
                        }
                        System.out.println();
                }
                System.out.println();
        }
}