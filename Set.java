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
         if(input.elementOf(setArray[index]))
            add(setArray[index],tempArray);
      }
      input.setArray = tempArray;
      return input;
   }
}  

