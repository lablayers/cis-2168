//*********************************************************************
// FILE NAME    : Intcoll4.java
// DESCRIPTION  : This file contains the class Intcoll4.
//                For traversing thru ListNode, these vars are used
//                w = previous, x = current, x.link or y = next
//*********************************************************************

import java.util.*;

public class Intcoll4
{
   
   // Constructor for ListNode
   private class ListNode
   {
   
      private int info;
      private ListNode link;
      public ListNode()
      {
         info=0; link=null;
      }
   
      public ListNode(int i, ListNode p)
      {
         info=i; link=p;
      }
   
   }
   
   private ListNode c;
   private int howmany;
   
    /**
     * Constructor populates ListNode c with an empty pointer.
     */
   public Intcoll4()
   {
      c = new ListNode();
      howmany = 0;
   }

    /**
     * Constructor populates ListNode c with an empty pointer.
     *
     * @param i         NOT APPLICABLE FOR INTCOLL4?
     */
   public Intcoll4(int i)
   {
      c = new ListNode();
      howmany = 0;
   }

    /**
     * Makes a copy of Intcoll4 object (let's say A to B.)
     * It first checks to make sure you are not attempting to copy its own object
     * Then it copies A's howmany to match B's howmany, then tells us the length of the obj array.
     * New array will gets us storage of arrazy of same size, then copies old array into new array.
     *
     * @param obj       Intcoll4 object to copy
     */
   public void copy(Intcoll4 obj)
   {
      if (this != obj) {
         howmany = obj.howmany;

         c = new ListNode();
         ListNode w = c;
         ListNode x = obj.c;
         ListNode x_copy = null;

         while(x != null){
            x_copy = new ListNode(x.info, null);
            w.link = x_copy;
            w = x_copy;
            x = x.link;
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
      if(howmany == 0) {
         return false;
      }

      ListNode x = c;

      // while (x != null) { 
      while ((x != null) && (x.info != i)) {
         x = x.link;
      }

      if (x != null) {
         // if ((x.info == i) == true) {
         //    return true;
         // }
         // else {
         //    return false;
         // }
         return x.info == i;
      }
      else {
         return false;
      }
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
      if (i > 0 && belongs(i) == false) {
      // if (i > 0) {

         ListNode y = new ListNode(i, c);
         c = y;

         howmany++;
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
         ListNode x = c;
         ListNode w = null;

         // while (x != null) { 
         while ((x != null) && (x.info != i)) {
            w = x;
            x = x.link;
         }

         if (x != null) {
            if (x.info == i) { 
               if (w != null) {
                  w.link = x.link;
               }
               else {
                  c = x.link;
               }

               howmany--;
            }
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
      ListNode x = c;

      while (x != null) {
         if (x.info != 0) {
            System.out.println(x.info);
         }

         x = x.link;
      }
   }

    /**
     * Checks if the contents inside two Intcoll4 object are identical in content,
     * by comparing the j array for the x Intcoll4 object and another given Intcoll4 object.
     *
     * @return isequal   Boolean if two Intcoll4 objects are indentical in content
     */
   public boolean equals(Intcoll4 obj)
   {
      boolean isequal = false; // (obj.howmany == howmany); 

      ListNode x = c;
      isequal = (obj.howmany == howmany);

      while (isequal && (x != null)) {
         isequal = obj.belongs(x.info); 
         x = x.link;
      }

      x = obj.c;

      while (isequal && (x != null)) {
         isequal = obj.belongs(x.info); 
         x = x.link;
      }

      return isequal;
   }



}