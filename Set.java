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
   private int [] setArray = {};
   public Set()
   {
     int [] setArray = new int[] {};//this works but is explicitly against
                                    //his rules and makes me sad
   }
   public Set(int [] inputArray)
   {
      this.setArray = inputArray;
   }
	public void makeEmpty()
   {
      setArray = new int[]{};
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
    
         int [] a = new int [setArray.length + 1];
         for (int index = 0; index < setArray.length; index++)
         {
            a[index]= setArray[index];
         }
         setArray = a;
      }
   }
   public int[] add(int value, int[] input)
   {
      if (!elementOf(value))
      {
    
         int [] a = new int [input.length + 1];
         for (int index = 0; index < input.length; index++)
         {
            a[index]= input[index];
         }
          return a;
      }
      else
         return input;
   }

   public void remove(int value)
   {
      
   }
   public boolean elementOf(int number)
   {
      
      for (int i =0; i <= setArray.length; i++)
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
      int [] tempArray = new int []{};
      for (int index = 0; index <= input.setArray.length; index++)
      {
         add(setArray[index],tempArray);
         add(input.setArray[index],tempArray);
      }
      Set output = new Set(tempArray);
      return output;
   }
   public Set intersection(Set input)
   {
      int [] tempArray = new int []{};
      for (int index = 0; index <= input.setArray.length; index++)
      {
         if(input.elementOf(setArray[index]))
            add(setArray[index],tempArray);
      }
      Set output = new Set(tempArray);
      return output;
   }
   public Set setDifference(Set input)
   {
      int [] tempArray = new int []{};
      for (int index = 0; index <= input.setArray.length; index++)
      {
         boolean notSame = true;
         for (int counter = 0; counter <= setArray.length; counter++)
         {
            if (input.setArray[index] == setArray[counter])
            {
               notSame = false;
            }
            
         }
         if(notSame)
         {
             add(input.setArray[index],tempArray);
         }
      }
      for (int index = 0; index <= input.setArray.length; index++)
      {
         boolean notSame = true;
         for (int counter = 0; counter <= setArray.length; counter++)
         {
            if (setArray[index] == input.setArray[counter])
            {
               notSame = false;
            }
            
         }
         if(notSame)
         {
             add(setArray[index],tempArray);
         }
      }
      Set output = new Set(tempArray);
      return output;
   }
}  

