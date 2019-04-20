
/**
 * Created by Esteban and Sebastian on 11/11/2016.
 * All rights reserved
 */

public class Prediction
{
    private int searched;//Searched times with Phonetic
    private String word;//Word...
    /**
     * Receives and String and an Int
     * @param word is generated by a smaller word
     * @param searched searched times with Phonetic
     */
    public Prediction(String word, int searched)
    {
        this.word = word;
        this.searched = searched;
    }
    /**
     * getter of Word
     * @return a String
     */
    public String getWord() {
        return word;
    }
    /**
     * getter of Searched
     * @return an Int
     */
    public int getSearched() {
        return searched;
    }
}