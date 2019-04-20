
import java.util.ArrayList;

/**
 * Created by Esteban and Sebastian on 11/6/2016.
 * All rights reserved
 */

public class Tree
{
    private int end = 0; // End = 0 means no added still--End = 1 means node added--End > 1 means times searched with Sounder,
    private char letter; //Letter content in the node
    private ArrayList<Tree> Nodes;//Sons
    /**
     * Receives a char
     * @param letter
     * letter is setted as char
     * initializes Nodes array
     */
    public Tree(char letter)
    {
        this.letter = letter;
        this.Nodes = new ArrayList<Tree>();
    }
    /**
     * Receives a char
     * @param letter is setted as
     * new node char then
     * @return an int with char node index
     */
    public int addNodo(char letter)
    {
        Tree newTree = new Tree(letter);//Makes the aux
        if (Nodes.isEmpty())//Ask if is empty
        {
            Nodes.add(newTree);
        }
        else//Otherwise
        {
            for (int i = 0; i < Nodes.size(); i++)//Travels along Nodes
            {
                if (letter < Nodes.get(i).getLetter())//If letter is smaller than Nodes of I
                {
                    Nodes.add(i,newTree);//Adds the node at current position
                    return i;//Return index of new node
                }
                if (Nodes.size()-1 == i)//At for end
                {
                    Nodes.add(newTree);//Adds at last position
                    return i+1;//Return index of new node
                }
            }
        }
        return 0;//Unreachable
    }
    /**
     * Getter of Nodes
     * @return an ArrayList<Tree> Style
     */
    public ArrayList<Tree> getNodes()//Getter de Nodos
    {
        return this.Nodes;
    }
    /**
     * Getter of char
     * @return node's char
     */
    public char getLetter()//Getter de letra
    {
        return letter;
    }
    /**
     * Increases end value
     * 0 = Without add
     * 1 = Node was added
     * >1 = Searched by SoundexRefined
     */
    public void setEnd()
    {
        this.end++;
    }
    /**
     * Getter of End
     * @return iterations quantity
     */
    public int getEnd()
    {
        return end;
    }

}
