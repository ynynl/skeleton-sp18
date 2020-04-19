public class Palindrome
{
    public static Deque<Character> wordToDeque(String word)
    {
        LinkedListDeque<Character> temp = new LinkedListDeque<Character>();
        for (int i=0; i<word.length(); i++)
        {
            temp.addLast(word.charAt(i));
        }
        return temp;
    }

    public boolean isPalindrome(String word)
    {
        Deque d = Palindrome.wordToDeque(word);
        if (!d.isEmpty())
        {
            while (d.size() != 1)
            {
                if (d.removeFirst() != d.removeLast())
                {
                    return false;
                }
                if (d.isEmpty())
                {
                    break;
                }
            }
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc)
    {
        Deque<Character> d = Palindrome.wordToDeque(word);

        if (!d.isEmpty())
        {
            while (d.size() != 1)
            {
                if (!cc.equalChars(d.removeFirst(), d.removeLast()))
                {
                    return false;
                }
                if (d.isEmpty())
                {
                    break;
                }
            }
        }
        return true;
    }
}

