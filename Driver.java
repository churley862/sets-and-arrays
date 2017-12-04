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

    // All of the command methods use this, might as well
    // make them easier to access, rather than pass them every time
    private static Set[] sets = new Set[100];
    private static Scanner inputFile;

    public static void main(String [] args) throws Exception
    {
        initialize(args);

        while (inputFile.hasNext())
        {
            char command = (inputFile.next()).charAt(0);

            //String output;
            switch (command) {
            case 'C':
                constructSet();
                break;

            case 'I':
                inspectSet();
                break;

            case 'S':
                countSetElements();
                break;

            case 'X' :
                emptySet();
                break;

            case 'A' :
                addElementToSet();
                break;

            case 'R' :
                removeElementFromSet();
                break;

            case 'F' :
                findElementInSet();
                break;

            case 'U':
                unionOfSets();
                break;

            case 'N':
                intersectionOfSets();
                break;

            case 'D':
                differenceOfSets();
                break;

            case 'P':
                printSet();
                break;

            case 'M':
                buildSet();
                break;

            case '#':
                System.out.println(inputFile.nextLine());
            }
        }
    }  // main

    private static void initialize(String[] args) throws FileNotFoundException {
        File inFile = new File(args[0]);
        File outFile = new File(args[1]);
        inputFile = new Scanner(inFile);
        FileOutputStream outputFile = new FileOutputStream(outFile);
        System.setOut(new PrintStream(outputFile));
    }

    private static void buildSet() {
        int setIndex = inputFile.nextInt();
        sets[setIndex] = new Set();
        while (inputFile.hasNextInt())
        {
            int value = inputFile.nextInt();
            sets[setIndex].add(value);
        }
    }

    private static void printSet() {
        int setIndex = inputFile.nextInt();
        if (sets[setIndex] == null) {
            System.out.println("The set " + setIndex + " does not exist.");
        } else {
            System.out.println(sets[setIndex].toString());
        }
    }

    private static void differenceOfSets() {
        int setIndex = inputFile.nextInt();
        int setIndex2 = inputFile.nextInt();
        int setIndex3 = inputFile.nextInt();
        sets[setIndex3] = sets[setIndex].setDifference(sets[setIndex2]);
    }

    private static void intersectionOfSets() {
        int setIndex = inputFile.nextInt();
        int setIndex2 = inputFile.nextInt();
        int setIndex3 = inputFile.nextInt();
        sets[setIndex3] = sets[setIndex].intersection(sets[setIndex2]);
    }

    private static void unionOfSets() {
        int setIndex = inputFile.nextInt();
        int setIndex2 = inputFile.nextInt();
        int setIndex3 = inputFile.nextInt();
        sets[setIndex3] = sets[setIndex].union(sets[setIndex2]);
    }

    private static void removeElementFromSet() {
        int setIndex = inputFile.nextInt();
        int value = inputFile.nextInt();
        if (sets[setIndex] == null) {
            System.out.println("Set " + setIndex + " does not exist.");
        } else {
            System.out.println("Removing " + value + " from set " + setIndex);
            sets[setIndex].remove(value);
        }
    }

    private static void addElementToSet() {
        int setIndex = inputFile.nextInt();
        int value = inputFile.nextInt();
        if (sets[setIndex] == null) {
            System.out.println("Set " + setIndex + " does not exist.");
        } else {
            sets[setIndex].add(value);
            System.out.println("Set " + setIndex + " had the value " + value + " added to it");
        }
    }

    private static void emptySet() {
        int setIndex = inputFile.nextInt();
        if (sets[setIndex] != null) {
            sets[setIndex].makeEmpty();
            System.out.println("Set " + setIndex + " was emptied.");
        } else {
            System.out.println("Set " + setIndex + " does not exist.");
        }
    }

    private static void constructSet() {
        int setIndex = inputFile.nextInt();
        sets[setIndex] = new Set();
        System.out.println("Set " + setIndex + " has been constructed.");
    }

    public static void inspectSet()
    {
        int setIndex = inputFile.nextInt();
        if (sets[setIndex] == null) {
            System.out.println("Set " + setIndex + " does not exist.");
        } else {
            String output;
            if(sets[setIndex].isEmpty())
            {
                output = "Set " + setIndex + " is empty";
            }
            else
            {
                output = "Set " + setIndex + " is not empty";
            }
            System.out.println(output);
        }

    }

    public static void countSetElements()
    {
        int setIndex = inputFile.nextInt();
        if (sets[setIndex] == null) {
            System.out.println("Set " + setIndex + " does not exist.");
        } else {
            int size = sets[setIndex].size();
            System.out.println("Set " + setIndex + " has a size of " + size);
        }
    }

    public static void findElementInSet()
    {
        int setIndex = inputFile.nextInt();
        String output;
        if (sets[setIndex] != null)
        {
            int value = inputFile.nextInt();
            if(sets[setIndex].elementOf(value))
            {
                output = "Set " + setIndex + " has value " + value;
            }
            else
            {
                output = "Set " + setIndex + " does not have value " + value;
            }
        }
        else
        {
            output = "There is no set " + setIndex + " in which to find a value.";
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
