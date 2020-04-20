public class OffByOne implements CharacterComparator {

    @Override
    public boolean equalChars(char x, char y) {
        if (Character.isUpperCase(x)) {
            x = Character.toLowerCase(x);
        }

        if (Character.isUpperCase(y)) {
            y = Character.toLowerCase(y);
        }

        if (Math.abs(x - y) == 1) {
            return true;
        }
        return false;
    }
}
