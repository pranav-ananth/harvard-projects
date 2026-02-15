import java.util.ArrayList;

public class Sentence {
    private String sentence;

    public ArrayList<Integer> getBlankPositions() {
        ArrayList<Integer> blankPositions = new ArrayList<>;

        for(int i = 0; i < sentence.length(); i++) {
            if(sentence.charAt(0) == ' ') {
                blankPositions.add(i);
            }
        }

        return blankPositions;
    }

    public int countWords() {
        return 1;
    }

    public String[] getWords() {
        int numWords = countWords();
        String[] words = new String[numWords];
        ArrayList<Integer> blankPositions = getBlankPositions();

        for(int i = 0; i < numWords; i++) {
            if(i == 0) {
                if(blankPositions.size() != 0)
                    words[i] = sentence.substring(0, blankPositions.get(0));
                else
                    words[i] = sentence;
            }
            else if(i == blankPositions.size())
                words[i] = sentence.substring(blankPositions.get(i - 1) + 1);
            else
                words[i] = sentence.substring(blankPositions.get(i - 1) + 1, blankPositions.get(i));
        }
    }
}
