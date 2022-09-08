package Task2_3;

public class Main {

    public static void main(String[] args) {
        fuzzySearch("car", "ca6$$#_rtwheel"); // true
        fuzzySearch("cwhl", "cartwheel"); // true
        fuzzySearch("cwhee", "cartwheel"); // true
        fuzzySearch("cartwheel", "cartwheel"); // true
        fuzzySearch("cwheeel", "cartwheel"); // false
        fuzzySearch("lw", "cartwheel"); // false
    }

    private static void fuzzySearch (String searchWord, String sourceString) {
        if(searchWord != null && sourceString != null) {
            int index = 0;
            int numberOfMatches = 0;
            char[] charArray = searchWord.toCharArray();
            for(char ch: charArray) {
                for(int i = index ; i < sourceString.length() ; i++) {
                    if(ch == sourceString.charAt(i)) {
                        numberOfMatches++;
                        index++;
                        break;
                    }
                    index++;
                }
            }
            System.out.println(numberOfMatches == charArray.length);
        } else {
            System.out.println("Параметры метода не должны быть 'null'");
        }
    }
}
