/** This class outputs all palindromes in the words file in the current directory. */
public class PalindromeFinder {
    static OffByOne offBy1 = new OffByOne();
    static OffByN offBy5 = new OffByN(5);

    public static void main(String[] args) {
        int minLength = 4;
        In in = new In("../library-sp18/data/words.txt");
        Palindrome palindrome = new Palindrome();

        while (!in.isEmpty()) {
            String word = in.readString();
            if (word.length() >= minLength && palindrome.isPalindrome(word, offBy5)) {
                System.out.println(word);
            }
        }
    }
//    Uncomment this class once you've written isPalindrome.
}
