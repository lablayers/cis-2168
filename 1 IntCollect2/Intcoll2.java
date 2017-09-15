//*********************************************************************
// FILE NAME    : Intcoll2.java
// DESCRIPTION  : This file contains the class Intcoll2.
//*********************************************************************

import java.util.*;

public class Intcoll2
{
   private int[] c;
   private int howmany;
   
    /**
     * Constructor populates array c with a size of 501 and stores a zero value in index zero.
     */
   public Intcoll2()
   {
   	c = new int[500+1];
   	howmany = 0;
   }

    /**
     * Constructor populates array c with a size of a given integer and stores a zero velue in index zero.
     *
     * @param i         Size of array c + 1
     */
   public Intcoll2(int i)
   {
   	c = new int[i+1];
   	howmany = 0;
   }

    /**
     * Makes a copy of Intcoll2 object (let's say A to B.)
     * It first checks to make sure you are not attempting to copy its own object
     * Then it copies A's capacity to match B's capacity, then tells us the length of the obj array.
     * New array will gets us storage of arrazy of same size, then copies old array into new array.
     *
     * @param obj       Intcoll2 object to copy
     */
   public void copy(Intcoll2 obj)
   {
   	if (this != obj)
   	{
   		c = new int[c.length];
   		int j = 0;
   		howmany = obj.howmany;
   		while (j <= howmany)
   		{
   			c[j] = obj.c[j]; j++;
   		}
   	}
   }

    /**
     * Checks if i appears at least once in the collection
     *
     * @param i       Value to check
     * @return       Boolean value if it appears in the collection
     */
   public boolean belongs(int i)
   {
   	int j = 0;
   	while ((j < howmany)&&(c[j] != i)) j++;
   	return ((i>0)&&(c[j] == i));
   }

    /**
     * Inserts item into collection 
     * If i is greater than 0 then it finds out if i is already in colection
     * If true, then then it's not there and needs to be inserted
     * Else, it is not inserted
     * 
     * @param param1    Value to insert
     */
   public void insert(int i)
   {
   	if (i > 0)
   	{
   	 	int j = 0;
   	     	while ((j <= howmany) && (c[j] != i)) j++;
   		if (c[j] == 0)
   	     	{
   			if (j == c.length - 1)
   		   	{
   		   	   // Array is full, double size of array
	   	         // Create a temporary array double the size of c plus 1
                  int size = (c.length*2) + 1;
                  int[] temp = new int[size];
                  
                  // Dplicate existing values of c into the temporary array
                  for(int k = 0; k < c.length; k++){
                    temp[k] = c[k];
                  }
                  
                  // Set c to the pointer of temporary array
                  c = temp;
   		   	}
   		   	c[j] = i; howmany++;
   		}
   	}
   }

    /**
     * If i is greater than 0, i is removed from the collection.
     * Otherwise, collection remains the same.
     *
     * @param i    Value to omit
     */
   // public void omit(int i)
   // {
   //  	if (i>0)
   //  	{
   // 		int j = 0;
   // 		while ((c[j] != 0)&&(c[j] != i)) j++;
   // 		if (c[j] == i)
   // 		{
   //    		int k = j+1;
   //    		while (c[k] != 0) k++;
   //    		c[j] = c[k-1]; c[k-1]=0; howmany--;
   // 		}
	  //  }
   // }
   public void omit(int i)
   {
    	if (i > 0)
    	{
   		int j = 0;
   		while ((j < howmany)&&(c[j] != i)) j++;
   		if (c[j] == i) {
           for(int k = j; k <= howmany; k++){
               c[k] = c[k+1];
           }
      	  howmany--;
   		}
	    }
   }

    /**
     * Counts the number of values in the collection until it reaches a 0 value.
     *
     * @return howmany  Number of values in collection until it reaches 0
     */
   public int get_howmany()
   {
   	return howmany;
   }

    /**
     * Traverses array, prints each value of c in its own line until it reaches a 0.
     */
   public void print()
   {
   	int j = 1;
   	System.out.println();
   	while (j <= howmany)
   	{
   	   System.out.println(c[j]); j++;
   	}
   }

    /**
     * Checks if the contents inside two Intcoll2 object are identical in content,
     * by comparing the j array for the current Intcoll2 object and another given Intcoll2 object.
     *
     * @return result   Boolean if two Intcoll2 objects are indentical in content
     */
   public boolean equals(Intcoll2 obj)
   {
   	int j = 0; boolean result = true;
   	while ((j < howmany)&&result)
   	{
      	result = obj.belongs(c[j]); j++;
   	}
   	j = 0;
   	while ((j <= obj.howmany)&&result)
   	{
      	result = belongs(obj.c[j]); j++;
   	}
   	return result;
   }
}

