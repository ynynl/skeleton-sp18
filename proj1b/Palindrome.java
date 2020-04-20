/*check if a string is a palindrome*/

public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        LinkedListDeque<Character> d = new LinkedListDeque<Character>();
        for (int i = 0; i < word.length(); i++) {
            d.addLast(word.charAt(i));
        }
        return d;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> d = wordToDeque(word);
        if (!d.isEmpty()) {
            while (d.size() != 1) {
                if (d.removeFirst() != d.removeLast()) {
                    return false;
                }
                if (d.isEmpty()) {
                    break;
                }
            }
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> d = wordToDeque(word);

        if (!d.isEmpty()) {
            while (d.size() != 1) {
                if (!cc.equalChars(d.removeFirst(), d.removeLast())) {
                    return false;
                }
                if (d.isEmpty()) {
                    break;
                }
            }
        }
        return true;
    }
}

