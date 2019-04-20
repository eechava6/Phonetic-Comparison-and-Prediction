
import java.util.ArrayList;
import java.io.*;

/**
 * Created by Esteban and Sebastian on 11/12/2016.
 * All rights reserved
 */

public class readFile
{
    private boolean showErr;
    private boolean showTime;
    /**
     * Sets false as
     * default booleans
     */
    public readFile()
    {
        this.showErr = false;
        this.showTime = false;
    }
    /**
     * Setter for showErr
     * @param showErr shows error once enabled
     */
    public void setShowErr(boolean showErr)
    {
        this.showErr = showErr;
    }
    /**
     * Setter for showTime
     * @param showTime shows Time once enabled
     */
    public void setShowTime(boolean showTime)
    {
        this.showTime = showTime;
    }
    /**
     * Receives a String
     * @param path is file's ubication
     * reads an external file
     * @return an ArrayList<String> style
     * with all file's words
     */
    public ArrayList<String> read(String path)//Path parameter is file's ubication
    {
        long startTime = System.currentTimeMillis(); //Gets current time
        int index = 0;
        String aux = "";//aux var
        ArrayList<String> auxArr = new ArrayList<>();//Creates an Array to add file Strings
        ArrayList<String>   erro = new ArrayList<>();
        try
        {
            File f = new File(path); //Creates a new File that is going to be read.
            FileReader fileReader = new FileReader(f);//Opens data stream
            BufferedReader br = new BufferedReader(fileReader);//Creates a buffer to get data trough data stream
            char check = 0;
            while (true) //Stills reading
            {
                index++;
                aux = br.readLine();//Reads a text line and saves it in aux var
                if(aux == null)
                {
                    break;
                }
                if (aux != null && !aux.equals(""))//If exist
                {
                    check = aux.charAt(0);
                     if (Character.getNumericValue(check) <=  Character.getNumericValue('z') && Character.getNumericValue(check) >= Character.getNumericValue('a'))//Checks if a - z
                     {
                         auxArr.add(aux);//Adds to array
                     }
                }
                if (aux == null || aux.equals(""))
                {
                    System.out.println("Error reading the file at "+(index-1)+" no valid word->{"+aux+"}--Deleting--");
                }
            }
            br.close();//Closes buffer once finished
            fileReader.close();//Closes data stream
        }
        catch (Exception e)//In case of exception
        {
            index--;
            if (showErr)
            {
                System.out.println("Error reading the file at "+index+" no valid word->{"+aux+"}--Deleting--");
            }
        }
        long endTime = System.currentTimeMillis();//Gets current time
        long timeMil = endTime - startTime;//Final time
        if(showTime)
        {
            System.out.println("Total time reading and buffering the file was : " + timeMil+" miliseconds");
            System.out.println("Total correct");
        }
        return auxArr;//Return ArrayList<String> style
    }
}
