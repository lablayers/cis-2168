//*********************************************************************
// FILE NAME    : Intcoll3.java
// DESCRIPTION  : This file contains the class Intcoll3.
//*********************************************************************

import java.util.*;

public class Intcoll3
{
   private boolean[] c;
   private int howmany;
   
    /**
     * Constructor populates array c with a size of 501 and stores a zero value in index zero.
     */
   public Intcoll3()
   {
   	c = new boolean[500+1];
   	howmany = 0;
   }

    /**
     * Constructor populates array c with a size of a given integer and stores a zero velue in index zero.
     *
     * @param i         Size of array c + 1
     */
   public Intcoll3(int i)
   {
   	c = new boolean[i+1];
   	howmany = 0;
   }

    /**
     * Makes a copy of Intcoll3 object (let's say A to B.)
     * It first checks to make sure you are not attempting to copy its own object
     * Then it copies A's capacity to match B's capacity, then tells us the length of the obj array.
     * New array will gets us storage of arrazy of same size, then copies old array into new array.
     *
     * @param obj       Intcoll3 object to copy
     */
   public void copy(Intcoll3 obj)
   {
   	if (this != obj)
   	{
   		c = new boolean[c.length];
   		int j = 0;
   		howmany = obj.howmany;
   		while (j < c.length)
   		{
   			c[j] = obj.c[j];
   			j++;
   		}
   	}
   }

    /**
     * Checks if i appears in the collection
     *
     * @param i      Value to check
     * @return       Boolean value if it appears in the collection
     */
   public boolean belongs(int i)
   {
      return c[i];
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
      if (i > 0) {
         while (i > c.length) {
	   	   // Array is full, double size of until it can fit item
            // Create a temporary array double the size of c plus 1
            int size = (c.length*2) + 1;
            boolean[] temp = new boolean[size];
            // Dplicate existing values of c into the temporary array
            for(int k = 0; k < c.length; k++){
               temp[k] = c[k];
            }
         }
         if (c[i] != true) {
            // Add i to array if not alreay there
            c[i] = true;
            howmany++;
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
    	if (i > 0) {
    	   if (i > c.length) {
    	      // i is larger than largest number that can be be omitted, do nothing
    	   }
         if (c[i] != false) {
            // Add i to array if not alreay there
            c[i] = false;
            howmany++;
            // why not decrementing here? you're omitting not inserting
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
   	int j = 0;
   	System.out.println();
   	while (j < c.length)
   	{
   	   if (c[j] == true) System.out.println(j);
         j++;
   	}
   }

    /**
     * Checks if the contents inside two Intcoll3 object are identical in content,
     * by comparing the j array for the current Intcoll3 object and another given Intcoll3 object.
     *
     * @return result   Boolean if two Intcoll3 objects are indentical in content
     */
   public boolean equals(Intcoll3 obj)
   {
   	int j = 0; boolean result = true;
   	while ((j < c.length) && result)
   	{
      	result = (c[j] == obj.belongs(j)); j++;
   	}
   	j = 0;
   	while ((j < c.length) && result)
   	{
      	result =  (c[j] == obj.belongs(j)); j++;
   	}
   	return result;
   }
}

