/*
  Collin Hurley
  Driver for the set class
  CS101
  date(s) of work here
*/

import java.util.*;
import java.io.*;
public class Driver
{
    /*
    put algorithm for main here
    */

    /*
    put data table for main here
    */

    public static int setIndex,setIndex2,setIndex3;
    public static void main(String [] args) throws Exception
    {
        Set [] sets = new Set[100];
        int value;
        File inFile = new File(args[0]);
        File outFile = new File(args[1]);
        Scanner inputFile = new Scanner(inFile);
        FileOutputStream outputFile = new FileOutputStream(outFile);
        while (inputFile.hasNext())
        {
            char command = (inputFile.next()).charAt(0);

            //String output;
            switch (command) {
            case 'C':
                setIndex = inputFile.nextInt();
                sets[setIndex] = new Set();
                break;
            case 'I':
                setIndex = inputFile.nextInt();
                i(sets,setIndex);
                break;
            case 'S':
                setIndex = inputFile.nextInt();
                s(sets,setIndex);
                break;
            case 'X' :
                setIndex = inputFile.nextInt();
                sets[setIndex].makeEmpty();
                break;
            case 'A' :
                setIndex = inputFile.nextInt();
                value = inputFile.nextInt();
                if (sets[setIndex] == null) {
                    System.out.println("Set " + setIndex + " does not exist.");
                } else {
                    sets[setIndex].add(value);
                }
                break;
            case 'R' :
                setIndex = inputFile.nextInt();
                value = inputFile.nextInt();
                if (sets[setIndex] == null) {
                    System.out.println("Set " + setIndex + " does not exist.");
                } else {
                    sets[setIndex].remove(value);
                }
                break;
            case 'F' :
                setIndex = inputFile.nextInt();
                value = inputFile.nextInt();
                if (sets[setIndex] == null) {
                    System.out.println("Set " + setIndex + " does not exist.");
                } else {
                    f(sets,setIndex,value);
                }

                f(sets,setIndex,value);
                break;
            case 'U':
                setIndex = inputFile.nextInt();
                setIndex2 = inputFile.nextInt();
                setIndex3 = inputFile.nextInt();
                sets[setIndex3] = sets[setIndex].union(sets[setIndex2]);
                break;
            case 'N':
                setIndex = inputFile.nextInt();
                setIndex2 = inputFile.nextInt();
                setIndex3 = inputFile.nextInt();
                sets[setIndex3] = sets[setIndex].intersection(sets[setIndex2]);
                break;
            case 'D':
                setIndex = inputFile.nextInt();
                setIndex2 = inputFile.nextInt();
                setIndex3 = inputFile.nextInt();
                sets[setIndex3] = sets[setIndex].setDifference(sets[setIndex2]);
                break;
            case 'P':
                setIndex = inputFile.nextInt();
                System.out.println(sets[setIndex].toString());
            case 'M':
                setIndex = inputFile.nextInt();
                while (inputFile.hasNextInt())
                {
                    value = inputFile.nextInt();
                    sets[setIndex].add(value);
                }
            case '#':
                System.out.println(inputFile.nextLine());
            }
        }//main
    }
    public static void i(Set [] setArray, int setIndex)throws Exception
    {
        String output;
        if(setArray[setIndex].isEmpty())
        {
            output = "Set " + setIndex + "is empty";
        }
        else
        {
            output = "Set " + setIndex + "is not empty";
        }
        System.out.println(output);
        
    }

    public static void s(Set [] setArray, int setIndex)
    {
        int size = setArray[setIndex].size();
        System.out.println("Set " + setIndex + "has a size of " + size);
    }
    public static void f(Set [] setArray, int setIndex, int value)
    {
        String output;
        if (!setArray[setIndex].isEmpty())
        {
            if(setArray[setIndex].elementOf(value))
            {
                output = "Set " + setIndex + "has value " + value;
            }
            else
            {
                output = "Set " + setIndex + "does not have value " + value;
            }
        }
        else
        {
            output = "Set " + setIndex + "is empty";
        }
        System.out.println(output);
    }

    /*
    put algorithm for classMethod here
    */

    /*
    put data table for classMethod here
    */
    public static void classMethod(String [] args)
    {

    }//classMethod

    /*
      Note that you will most likely have multiple class methods.
      The return type does not have to be void (int and boolean are likely).
      Also note that the parameter name and types will be different from
        String [] args.
    */

}//class TemplateUpdated
