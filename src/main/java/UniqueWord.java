public class UniqueWord {

    private String word;
    private int count;

    public UniqueWord(String word, int count) {
        this.word = word;
        this.count = count;
    }

    public String getWord() {
        return this.word;
    }
    public int getCount() {
        return this.count;
    }

    public void incrementCount() {
        this.count += 1;
    }

    @Override
    public String toString() {
        return word + " : " + count;
    }

}
