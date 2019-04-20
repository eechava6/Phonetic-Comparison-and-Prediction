import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;


/**
 * Created by Esteban and Sebastian on 11/13/2016.
 * All rights reserved
 */

public class Initializer
{
    private readFile file;
    private SoundexRefined words;
    private TreeGenerator tree;
    private  boolean showSoundex;
    private boolean showSearched;
    private boolean showWordPredictions;

    /**
     * Creates a new Object Manager
     * and sets default values
     */
    public Initializer()
    {
        this.file = new readFile();
        this.words = new SoundexRefined();
        this.tree = new TreeGenerator();
        this.showSearched = false;
        this.showSoundex = false;
    }

    /**
     * Message printed at exit
     * operation
     */
    public void sucessfullExit()
    {
        try
        {
            System.out.println("-------------All processes are being killed ------------- ");
            Thread.sleep(2000);
            System.out.println("-------------Trying to exit with end code 0 ------------- ");
            Thread.sleep(3000);
            System.out.println("-----------------------Succesfull exit-------------------- ");
            Thread.sleep(3500);
            for (int i = 0; i < 50; i++)
            {
                System.out.println("");
            }
            System.out.println("Made by: Esteban Echavarría and Sebastian Valencia ");

        }catch (Exception e)
        {
            System.out.println("Error exiting");
        }
    }

    /**
     * Setter for SoundexRefined
     * @param showSoundex shows encoded word with SoundexRefined
     */
    public void setShowSoundex(boolean showSoundex)
    {
        this.showSoundex = showSoundex;
    }
    /**
     * Setter for ShowWordPredictions
     * @param showWordPredictions
     */
    public void setShowWordPredictions(boolean showWordPredictions)
    {
        this.showWordPredictions = showWordPredictions;
    }
    /**
     * Setter for showSeacrhed
     * @param showSearched shows a word times searched
     */
    public void setShowSearched(boolean showSearched)
    {
        this.showSearched = showSearched;
    }
    /**START of the program
     * Set of options
     * to decide what to do
     * Options send you to configure
     * Default send you to Start with a default options
     */
    public void setOptions()
    {
        System.out.println("------Press 1 to set Options------");
        System.out.println("-------Press 2 to go Default------");
        System.out.println("----------Press 0 to exit---------");

        Scanner getWord = new Scanner(System.in);
        String nextString = getWord.nextLine();
        switch (nextString)
        {
            case "1":
                Options();
                break;
            case "2":
                Start();
                break;
            case "0":
                sucessfullExit();
                return;
            default:
                System.out.println("No valid input");
        }

    }
    /**
     * Options menu
     * configures what program shows
     */
    public void Options()
    {
        System.out.println("------Press 1 to go Reading File options");
        System.out.println("------Press 2 to go Generating SoundexRefined options");
        System.out.println("------Press 3 to go Generating Tree options");
        System.out.println("------Press 4 to Enable all options(Ignores actual classes state)");
        System.out.println("------Press 5 to Start");
        System.out.println("------Press 0 to End");
        int case4 = 0;

        while (true)
        {
            Scanner getWord = new Scanner(System.in);
            String nextString = getWord.nextLine();
            switch (nextString)
            {

                case "1":
                  readFileOptions("Read File");
                    break;
                case "2":
                    SoundexOptions("Generating SoundexRefined");
                    break;
                case "3":
                    TreeGeneratorOptions("Generating Tree");
                    break;
                case "4":
                    case4++;
                    if (case4 % 2 == 0)
                    {
                        this.setShowWordPredictions(false);
                        this.setShowSoundex(false);
                        file.setShowTime(false);
                        file.setShowErr(false);
                        tree.setShowTime(false);
                        setShowSearched(false);
                        words.setShowTime(false);
                        words.setShowErr(false);
                        System.out.println("Disabled --- all Classes options");
                        break;
                    }
                    if (case4 % 2 == 1)
                    {
                        this.setShowWordPredictions(true);
                        this.setShowSoundex(true);
                        file.setShowTime(true);
                        file.setShowErr(true);
                        tree.setShowTime(true);
                        setShowSearched(true);
                        words.setShowTime(true);
                        words.setShowErr(true);

                        System.out.println("Enabled --- all Classes options");
                        break;
                    }
                    break;

                case "5":
                    Start();
                    break;
                case "0":
                    sucessfullExit();
                    return;
                default:
                    System.out.println("No valid input");
                    break;
            }

        }
    }

    /**
     * Shows all available options
     * for TreeGenerator
     * @param className
     * @return a TreeGenerator with
     * a maded SetUp
     */
    public TreeGenerator TreeGeneratorOptions(String className)
    {
        System.out.println("------Press 1 to enable/disable "+className+" show time");
        System.out.println("------Press 2 to enable/disable "+className+" show word searched times ");
        System.out.println("------Press 3 to enable/disable all "+className+" options");
        System.out.println("------Press 0 to return");
        Scanner getWord = new Scanner(System.in);
        String nextString = getWord.nextLine();
        this.tree = new TreeGenerator();
        int case1 = 0;
        int case2 = 0;
        int case3 = 0;

        while (true)
        {
            switch (nextString)
            {

                case "1":
                    case1++;
                    if (case1 % 2 == 0)
                    {
                        tree.setShowTime(false);
                        System.out.println("Disabled --- "+className+" show time");
                        break;
                    }
                    if (case1 % 2 == 1)
                    {
                        tree.setShowTime(true);
                        System.out.println("Enabled --- "+className+" show time");
                        break;
                    }
                    break;

                case "2":
                    case2++;
                    if (case2 % 2 == 0)
                    {
                        setShowSearched(false);
                        System.out.println("Disabled --- "+className+" show times searched");
                        break;
                    }
                    if (case2 % 2 == 1)
                    {
                        setShowSearched(true);
                        System.out.println("Enabled --- "+className+" show times searched");
                        break;
                    }
                    break;

                case "3":
                    case3++;
                    if (case3 % 2 == 0)
                    {
                        tree.setShowTime(false);
                        setShowSearched(false);
                        System.out.println("Disabled --- all "+className+" options");
                    }
                    if (case3 % 2 == 1)
                    {
                        tree.setShowTime(true);
                        setShowSearched(true);
                        System.out.println("Enabled --- all "+className+" options");
                    }
                    break;

                case "0":
                    Options();
                    return this.tree;

                default:
                    System.out.println("No valid input");
                    break;
            }
            nextString = getWord.nextLine();
        }
    }
    /**
     * Shows all available options
     * for SoundexRefined
     * @param className
     * @return a SoundexRefined with
     * a maded SetUp
     */
    public SoundexRefined SoundexOptions(String className)
    {
        System.out.println("------Press 1 to enable/disable "+className+" show errors");
        System.out.println("------Press 2 to enable/disable "+className+" show time ");
        System.out.println("------Press 3 to enable/disable "+className+" soundex codified word");
        System.out.println("------Press 4 to enable/disable all "+className+" options");
        System.out.println("------Press 0 to return");
        Scanner getWord = new Scanner(System.in);
        String nextString = getWord.nextLine();
        this.words = new SoundexRefined();
        int case1 = 0;
        int case2 = 0;
        int case3 = 0;
        int case4 = 0;
        while (true)
        {
            switch (nextString)
            {

                case "1":
                    case1++;
                    if (case1 % 2 == 0)
                    {
                        words.setShowErr(false);
                        System.out.println("Disabled --- "+className+" show errors");
                        break;
                    }
                    if (case1 % 2 == 1)
                    {
                        words.setShowErr(true);
                        System.out.println("Enabled --- "+className+" show errors");
                        break;
                    }
                    break;

                case "2":
                    case2++;
                    if (case2 % 2 == 0)
                    {
                        words.setShowTime(false);
                        System.out.println("Disabled --- "+className+" show time");
                    }
                    if (case2 % 2 == 1)
                    {
                        words.setShowTime(true);
                        System.out.println("Enabled --- "+className+" show time");
                    }
                    break;

                case "3":
                    case3++;
                    if (case3 % 2 == 0)
                    {
                        this.setShowSoundex(false);
                        System.out.println("Disabled --- "+className+" soundex codified word");
                    }
                    if (case3 % 2 == 1)
                    {
                        this.setShowSoundex(true);
                        System.out.println("Enabled --- "+className+" soundex codified word");
                    }
                    break;
                case "4":
                    case4++;
                    if (case4 % 2 == 0)
                    {
                        this.setShowSoundex(false);
                        words.setShowTime(false);
                        words.setShowErr(false);
                        System.out.println("Disabled --- all "+className+" options");
                    }
                    if (case4 % 2 == 1)
                    {
                        this.setShowSoundex(true);
                        words.setShowTime(true);
                        words.setShowErr(true);
                        System.out.println("Enabled --- all "+className+" options");
                    }
                    break;

                case "0":
                    Options();
                    return this.words;

                default:
                    System.out.println("No valid input");
                    break;
            }
            nextString = getWord.nextLine();
        }
    }

    /**
     * Shows all available options
     * for readFile
     * @param className
     * @return a readFile with
     * a maded SetUp
     */
    public readFile readFileOptions(String className)
    {
        System.out.println("------Press 1 to enable/disable "+className+" show errors");
        System.out.println("------Press 2 to enable/disable "+className+" show time ");
        System.out.println("------Press 3 to enable/disable all "+className+" options");
        System.out.println("------Press 0 to return");
        Scanner getWord = new Scanner(System.in);
        String nextString = getWord.nextLine();
        this.file = new readFile();
        int case1 = 0;
        int case2 = 0;
        int case3 = 0;
        while (true)
        {
            switch (nextString)
            {

                case "1":
                    case1++;
                    if (case1 % 2 == 0)
                    {
                        file.setShowErr(false);
                        System.out.println("Disabled --- "+className+" show errors");
                        break;
                    }
                    if (case1 % 2 == 1)
                    {
                        file.setShowErr(true);
                        System.out.println("Enabled --- "+className+" show errors");
                        break;
                    }
                    break;

                case "2":
                    case2++;
                    if (case2 % 2 == 0)
                    {
                        file.setShowTime(false);
                        System.out.println("Disabled --- "+className+" show time");
                    }
                    if (case2 % 2 == 1)
                    {
                        file.setShowTime(true);
                        System.out.println("Enabled --- "+className+" show time");
                    }
                    break;

                case "3":
                    case3++;
                    if (case3 % 2 == 0)
                    {

                        file.setShowTime(false);
                        file.setShowErr(false);
                        System.out.println("Disabled --- all "+className+" options");
                    }
                    if (case3 % 2 == 1)
                    {
                        file.setShowTime(true);
                        file.setShowErr(true);
                        System.out.println("Enabled --- all "+className+" options");
                    }
                    break;

                case "0":
                    Options();
                    return this.file;

                default:
                    System.out.println("No valid input");
                    break;
            }
            nextString = getWord.nextLine();
        }
    }

    /**
     * Here you decide what to do
     * if get predictions from a word
     * or compare phonetically a word
     */
    public void Start()
    {
        ArrayList<String> aux =file.read("C:\\Esteban\\U\\Fundamentos\\Proyectos\\src\\Estructuras\\words[93].txt");
        words.setUncoded(aux);
        words.setCoded(words.bigEncode(aux));
        tree.makeTree(words.getUncoded());
        while (true)
        {
            System.out.println("-------What do you want to do?-----------");
            System.out.println("-Press 1 to get predictions from a Word");
            System.out.println("-Press 2 to make a phonetic comparison");
            System.out.println("-Press 0 to exit");
            Scanner getWord = new Scanner(System.in);
            String nextWord = getWord.nextLine();
            switch (nextWord)
            {
                case "1":
                    Predict(tree);
                    break;
                case "2":
                    Phonetic(words);
                    break;
                case "0":
                    sucessfullExit();
                    return;
            }
        }
    }

    /**
     * receives a Tree object
     * and gets all predictions
     * above a word
     * @param tree
     */
    public void Predict(TreeGenerator tree)
    {
        while(true)
        {
            System.out.println("-------Insert a word-----------");
            System.out.println("-Press 0 to return");
            Scanner getWord = new Scanner(System.in);
            String word = getWord.nextLine();
            long startTime = System.currentTimeMillis(); //Gets current time
            if (word.equals("0"))
            {
                break;
            }
            else
            {

                ArrayList<Prediction> predictions = tree.getPrediction(word, tree.getArrayRoot());

                if (predictions != null)
                {
                    OutputStream out = new BufferedOutputStream(System.out);
                    for (int i = 0; i < predictions.size(); i++)
                    {
                        try
                        {
                            if (this.showSearched)//Writes in buffer
                            {
                                out.write((predictions.get(i).getWord() + " {" + predictions.get(i).getSearched()+"} Times searched"+"\n").getBytes());
                            }
                            else
                            {
                                out.write((predictions.get(i).getWord()+"\n").getBytes());
                            }
                            out.flush(); //Prints buffer
                        }
                        catch (Exception e)
                        {
                            System.out.println("Error printing buffer");
                        }
                    }
                    predictions.clear();
                }
                System.out.println("");

            }
            long endTime = System.currentTimeMillis();
            long finalTime = endTime-startTime;
            if (showWordPredictions)
            {
                System.out.println("Total time getting word "+word+" predictions was "+finalTime+" miliseconds");
            }
        }
    }
    /**
     * receives a SoundexRefined object
     * Compares via SoundexRefined a word
     * and shows it's equivalents
     * @param words
     */
    public void Phonetic(SoundexRefined words)
    {
        Scanner getWord = new Scanner(System.in);
        while(true)
        {
            System.out.println("-------Insert a word-----------");
            System.out.println("-Press 0 to return");
            String phonetic=getWord.nextLine();
            String aux=phonetic;
            this.tree.setIncrease(phonetic,tree.getArrayRoot());
            long startTime = System.currentTimeMillis(); //Gets current time
            if (phonetic.equals("0"))
            {
                break;
            }
            else
            {
                phonetic = words.encode(phonetic);
                OutputStream out = new BufferedOutputStream(System.out);
                try
                {
                    String comp1;
                    String comp2 = phonetic.substring(1);
                for (int i = 0; i < words.getCoded().size() ; i++)
                {
                    comp1 = words.getCoded().get(i).substring(1);
                        if (comp1.equals(comp2))
                        {
                            if (showSoundex)//Writes in buffer
                            {
                                out.write((words.getUncoded().get(i)+" <- Word | RefinedSoundex code -> {"+words.getCoded().get(i)+"}\n").getBytes());
                            }
                            else
                            {
                                out.write((words.getUncoded().get(i)+"\n").getBytes());
                            }
                            out.flush(); //Prints buffer
                        }
                    }
                }catch (Exception e)
                {
                    System.out.println("Error printing buffer");
                }
            }
            System.out.println("");
            long endTime = System.currentTimeMillis();
            long finalTime = endTime-startTime;
            if (showWordPredictions)
            {
                System.out.println("Total time getting word "+aux+" predictions was "+finalTime+" miliseconds");
            }
        }
    }
}
