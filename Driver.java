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

    interface DriverCommand {
        public void action(Scanner inputFile);
    }

    static Map<String, DriverCommand> jump_table = new HashMap<String, DriverCommand>();

    private static Set [] sets = new Set[100];
    private static int setIndex,setIndex2,setIndex3;

    private static void initialize_jump_table() {
        jump_table.put("C", new DriverCommand() {
            public void action(Scanner inputFile) {
                create_set_entry(inputFile);
            }
        });

        jump_table.put("C"), new DriverCommand() {
          public void action(Scanner inputFile) {
          }
        });
    }

    private static void create_set_entry(Scanner inputFile) {
        int setIndex = inputFile.nextInt();
        sets[setIndex] = new Set();
        System.out.println("Set " + setIndex + " has been constructed.");
    }

    public static void main(String [] args) throws Exception
    {
        int value;
        File inFile = new File(args[0]);
        File outFile = new File(args[1]);
        Scanner inputFile = new Scanner(inFile);
        FileOutputStream outputFile = new FileOutputStream(outFile);
        System.setOut(new PrintStream(outputFile));

        initialize_jump_table();

        while (inputFile.hasNext())
        {
            char command = (inputFile.next()).charAt(0);

            if (jump_table.containsKey(Character.toString(command))) {
                jump_table.get(Character.toString(command)).action(inputFile);
            } else {
                switch (command) {
                case 'C':
                    System.out.println(" Fail ");
                    break;

                case 'I':
                    setIndex = inputFile.nextInt();
                    iCase(sets,setIndex);
                    break;

                case 'S':
                    setIndex = inputFile.nextInt();
                    sCase(sets,setIndex);
                    break;

                case 'X' :
                    if (sets[setIndex] != null) {
                        setIndex = inputFile.nextInt();
                        sets[setIndex].makeEmpty();
                        System.out.println("Set " + setIndex + " was emptied.");
                    } else {
                        System.out.println("Set " + setIndex + " does not exist.");
                    }
                    break;

                case 'A' :
                    setIndex = inputFile.nextInt();
                    value = inputFile.nextInt();
                    if (sets[setIndex] == null) {
                        System.out.println("Set " + setIndex + " does not exist.");
                    } else {
                        sets[setIndex].add(value);
                        System.out.println("Set " + setIndex + " had the value " + value + " added to it");
                    }
                    break;

                case 'R' :
                    setIndex = inputFile.nextInt();
                    value = inputFile.nextInt();
                    if (sets[setIndex] == null) {
                        System.out.println("Set " + setIndex + " does not exist.");
                    } else {
                        System.out.println("Removing " + value + " from set " + setIndex);
                        sets[setIndex].remove(value);
                    }
                    break;

                case 'F' :
                    setIndex = inputFile.nextInt();
                    value = inputFile.nextInt();
                    if (sets[setIndex] == null) {
                        System.out.println("Set " + setIndex + " does not exist.");
                    } else {
                        fCase(sets,setIndex,value);
                    }

                    break;

                case 'U':
                    setIndex = inputFile.nextInt();
                    setIndex2 = inputFile.nextInt();
                    setIndex3 = inputFile.nextInt();
                    if (sets[setIndex] == null || sets[setIndex2] == null) {
                        System.out.println("Unable to create the union of null sets");
                    } else {
                        sets[setIndex3] = sets[setIndex].union(sets[setIndex2]);
                    }
                    break;

                case 'N':
                    setIndex = inputFile.nextInt();
                    setIndex2 = inputFile.nextInt();
                    setIndex3 = inputFile.nextInt();
                    if (sets[setIndex] == null || sets[setIndex2] == null) {
                        System.out.println("Unable to find the intersection of null sets");
                    } else {
                        sets[setIndex3] = sets[setIndex].intersection(sets[setIndex2]);
                    }
                    break;

                case 'D':
                    setIndex = inputFile.nextInt();
                    setIndex2 = inputFile.nextInt();
                    setIndex3 = inputFile.nextInt();
                    if (sets[setIndex] == null || sets[setIndex2] == null) {
                        System.out.println("Unable to find the difference of null sets");
                    } else {
                        sets[setIndex3] = sets[setIndex].setDifference(sets[setIndex2]);
                    }
                    break;

                case 'P':
                    setIndex = inputFile.nextInt();
                    if (sets[setIndex] == null) {
                        System.out.println("Set " + setIndex + " does not exist.");
                    } else {
                        System.out.println(sets[setIndex].toString());
                    }
                    break;

                case 'M':
                    setIndex = inputFile.nextInt();
                    sets[setIndex] = new Set();
                    while (inputFile.hasNextInt())
                    {
                        value = inputFile.nextInt();
                        sets[setIndex].add(value);
                    }
                    break;

                case '#':
                    System.out.println(inputFile.nextLine());
                }
            }
        }//main
    }
    public static void iCase(Set [] setArray, int setIndex)throws Exception
    {
        if (setArray[setIndex] == null) {
            System.out.println("Set " + setIndex + " does not exist.");
        } else {
            String output;
            if(setArray[setIndex].isEmpty())
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

    public static void sCase(Set [] setArray, int setIndex)
    {
        if (setArray[setIndex] == null) {
            System.out.println("Set " + setIndex + " does not exist.");
        } else {
            int size = setArray[setIndex].size();
            System.out.println("Set " + setIndex + " has a size of " + size);
        }
    }
    public static void fCase(Set [] setArray, int setIndex, int value)
    {
        String output;
        if (setArray[setIndex] != null)
        {
            if(setArray[setIndex].elementOf(value))
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
