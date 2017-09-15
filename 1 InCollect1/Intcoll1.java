//*********************************************************************
// FILE NAME    : Intcoll1.java
// DESCRIPTION  : This file contains the class Intcoll1.
//*********************************************************************

import java.util.*;

public class Intcoll1
{
   private int[] c;
   
    /**
     * Constructor populates array c with a size of 501 and stores a zero value in index zero.
     */
   public Intcoll1()
   {
   	c = new int[500+1];
   	c[0] = 0;
   }

    /**
     * Constructor populates array c with a size of a given integer and stores a zero velue in index zero.
     *
     * @param i         Size of array c + 1
     */
   public Intcoll1(int i)
   {
   	c = new int[i+1];
 	   c[0] = 0;
   }

    /**
     * Makes a copy of Intcoll1 object (let's say A to B.)
     * It first checks to make sure you are not attempting to copy its own object
     * Then it copies A's capacity to match B's capacity, then tells us the length of the obj array.
     * New array will gets us storage of arrazy of same size, then copies old array into new array.
     *
     * @param obj       Intcoll1 object to copy
     */
   public void copy(Intcoll1 obj)
   {
   	if (this != obj)
   	{
   		c = new int[obj.c.length];
   		int j = 0;
   		while (obj.c[j] != 0)
   		{
   			c[j] = obj.c[j]; j++;
   		}
   		c[j] = 0;
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
   	while ((c[j] != 0)&&(c[j] != i)) j++;
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
   	     	while ((c[j] != 0) && (c[j] != i)) j++;
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
   		   	c[j] = i; c[j + 1] = 0;
   		}
   	}
   }

    /**
     * If i is greater than 0, i is removed from the collection.
     * Otherwise, collection remains the same.
     *
     * @param i    Value to omit
     */
   public void omit(int i)
   {
    	if (i>0)
    	{
   		int j = 0;
   		while ((c[j] != 0)&&(c[j] != i)) j++;
   		if (c[j] == i)
   		{
      		int k = j+1;
      		while (c[k] != 0) k++;
      		c[j] = c[k-1]; c[k-1]=0;
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
   	int j=0, howmany=0;

   	while (c[j]!=0) {howmany++; j++;}
   	return howmany;
   }

    /**
     * Traverses array, prints each value of c in its own line until it reaches a 0.
     */
   public void print()
   {
   	int j = 0;
   	System.out.println();
   	while (c[j] != 0)
   	{
      	System.out.println(c[j]); j++;
   	}
   }

    /**
     * Checks if the contents inside two Intcoll1 object are identical in content,
     * by comparing the j array for the current Intcoll1 object and another given Intcoll1 object.
     *
     * @return result   Boolean if two Intcoll1 objects are indentical in content
     */
   public boolean equals(Intcoll1 obj)
   {
   	int j = 0; boolean result = true;
   	while ((c[j] != 0)&&result)
   	{
      	result = obj.belongs(c[j]); j++;
   	}
   	j = 0;
   	while ((obj.c[j] != 0)&&result)
   	{
      	result = belongs(obj.c[j]); j++;
   	}
   	return result;
   }
}

