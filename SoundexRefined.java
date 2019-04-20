
import java.util.ArrayList;

/**
 * Created by Esteban and Sebastian on 11/12/2016.
 * All rights reserved
 */

public class SoundexRefined
{
    private ArrayList<String> coded;//Here remain words once encoded with SoundexRefined Style
    private ArrayList<String> uncoded;//Here remain words without encoded
    private boolean showErr;//Defines if show errors
    private boolean showTime;//Defines if show time
    /**
     *Initializes all variables
     * as default
     */
    public SoundexRefined()
    {
        this.uncoded = new ArrayList<>();
        this.coded = new ArrayList<>();
        this.showErr = false;
    }
    /**
     * Setter fow ShowErr
     * @param showErr defines if show errors
     */
    public void setShowErr(boolean showErr)
    {
        this.showErr = showErr;
    }
    /**
     * Setter for Showtime
     * @param showTime defines if show execution time
     */
    public void setShowTime(boolean showTime)
    {
        this.showTime = showTime;
    }
    /**
     * Receives an ArrayList<String> Style
     * @param uncoded
     * puts uncoded as default uncoded ArrayList
     * then codifies each uncoded word and sets to
     * coded ArrayList<String> Style
     */
    public void setUncoded(ArrayList<String> uncoded)
    {
        this.uncoded = uncoded;
    }
    public void setCoded(ArrayList<String> coded)
    {
        this.coded = coded;
    }
    /**
     * Receives a String
     * @param string
     * codifies string into SoundexRefined Style, then
     * @return the String received codified in SoundexRefined
     * returned String ignores it's firts letter
     */
    public String encode(String string)
    {
            char[] x = string.toUpperCase().toCharArray();

            // Convert letters into numeric code
            for (int i = 1; i < x.length; i++) {
                switch (x[i]) {

                    case 'B':
                    case 'F':
                    case 'P':
                    case 'V':
                        x[i] = '1';
                        break;

                    case 'C':
                    case 'G':
                    case 'J':
                    case 'K':
                    case 'Q':
                    case 'S':
                    case 'X':
                    case 'Z':
                        x[i] = '2';
                        break;

                    case 'D':
                    case 'T':
                        x[i] = '3';
                        break;

                    case 'L':
                        x[i] = '4';
                        break;

                    case 'M':
                    case 'N':
                        x[i] = '5';
                        break;

                    case 'R':
                        x[i] = '6';
                        break;

                    default:
                        x[i] = '0';
                        break;
                }
            }
            String output = ""+x[0];
            for (int i = 1; i < x.length; i++) //Contatenates the output
            {
                    output += x[i];
            }
            return output.substring(0); //Ignores firts letter
    }
    /**
     * Receives an ArrayList<String> Style
     * @param uncoded receives an Array with
     * uncoded words, then calls method 'encode'
     * to each word in Array
     * @return an ArrayList full of encoded words
     */
    public ArrayList<String> bigEncode(ArrayList<String> uncoded)
    {
        long startTime = System.currentTimeMillis(); //Gets current time
        ArrayList<String> auxArr = new ArrayList<>();
            for (int i = 0; i < uncoded.size(); i++)//Travels along uncoded.
            {
                try
                {
                    String aux = encode(uncoded.get(i));//Encodes a String
                    auxArr.add(aux);//Adds the String to an Aux array
                }
                catch (Exception e)//In case of exceptions throws an error message
                {
                    uncoded.remove(i);
                    i--;
                    if (showErr)
                    {
                        System.out.println("At index "+(i+1)+" there's a no valid input - deleting -");
                    }
                }
            }
        long endTime = System.currentTimeMillis();//Gets current time
        long timeMil = endTime - startTime;//Final time
        if(showTime)
        {
            System.out.println("Total time encoding and buffering the words was : " + timeMil+" miliseconds");
        }
        return auxArr;//Return an array full of coded words with SoundexRefined Style
    }
    /**
     * Getter of Coded words
     * @return an ArrayList<String> Style
     */
    public ArrayList<String> getCoded()
    {
        return coded;
    }
    /**
     * Getter of Uncoded words
     * @return an ArrayList<String> Style
     */
    public ArrayList<String> getUncoded()
    {
        return uncoded;
    }
}
