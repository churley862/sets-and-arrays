/*
  Collin Hurley
  Code description here
  CS101
  date(s) of work here
*/


/*
  replace this comment with import statements
*/
public class Set
{
    private int[] setArray = {};
    public Set()
    {
        setArray = new int[0];
    }

    public Set(int[] inputArray)
    {
        this.setArray = inputArray;
    }

    public Set(Set s) {
        setArray = s.setArray.clone();
    }

    public void makeEmpty()
    {
        setArray = new int[0];
    }

    public boolean isEmpty()
    {
        if (setArray.length > 0)
            return false;
        else
            return true;
    }

    public void add(int value)
    {
        if (!elementOf(value))
        {
            int[] a = new int[setArray.length + 1];
            for (int index = 0; index < setArray.length; index++)
            {
                a[index]= setArray[index];
            }
            a[setArray.length] = value;
            setArray = a;
            
        }else
        System.out.println("There is no set to add the value to");
        
    }

    public void remove(int value)
    {
        if (elementOf(value)) {
            int[] a = new int[setArray.length - 1];
            int aindex = 0;
            for (int index = 0; index < setArray.length; index++) {
                if (setArray[index] != value) {
                    a[aindex++] = value;
                }
            }
            setArray = a;
        }
    }

    public boolean elementOf(int number)
    {
        for (int i = 0; i < setArray.length; i++)
        {
            if (setArray[i] == number)
                return true;
        }
        return false;
    }

    public int size()
    {
        return setArray.length;
    }

    public Set union(Set input)
    {
        Set result = new Set(this);
        for (int index = 0; index <= input.setArray.length; index++)
        {
            add(input.setArray[index]);
        }
        return result;
    }

    public Set intersection(Set input)
    {
        Set result = new Set();
        for (int index = 0; index <= input.setArray.length; index++)
        {
            if(input.elementOf(setArray[index]))
                result.add(setArray[index]);
        }
        return result;
    }

    public Set setDifference(Set input)
    {
        int [] tempArray = new int [] {};
        Set result = new Set();
        for (int index = 0; index <= input.setArray.length; index++)
        {
            if(!input.elementOf(setArray[index]))
                result.add(setArray[index]);
        }
        return result;
    }

    public String toString()
    {
        String output;
        output = "{ " + setArray[0];
        for (int index = 1; index <= setArray.length; index++)
        {
            output += ", " + setArray[index];
        }
        output += " }";
        return output;
    }
}

