import org.jetbrains.annotations.Contract;

public class OffByN implements CharacterComparator {
    public int N;

    @Contract(pure = true)
    public OffByN(int n) {
         N = n;
    }



    @Override
    public boolean equalChars(char x, char y) {
        if (Math.abs(x - y) == N)
        {
            return true;
        }
        return false;
    }
}
