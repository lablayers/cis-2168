//*********************************************************************
// FILE NAME    : Intcoll5.java
// DESCRIPTION  : This file contains the class Intcoll5.
//                For traversing thru ListNode, these vars are used
//                w = previous, x = current, x.link or y = next
//*********************************************************************

import java.util.*;

public class Intcoll5
{
	private LinkedList<Integer> c = new LinkedList<Integer>();
	private int howmany;

	public Intcoll5()
	{
		c = new LinkedList<Integer>();
	}

	/**
	* Constructor populates ListNode c with an empty pointer.
	*
	* @param i         Not applicable
	*/
	public Intcoll5(int i)
	{
		c = new LinkedList<Integer>();
	}


	 /**
	  * Makes a copy of Intcoll5 object (let's say A to B.)
	  * Duplicates LinkedList, then copies the duplicated LinkedList into the other object
	  *
	  * @param obj       Intcoll5 object to copy
	  */
	public void copy(Intcoll5 obj)
	{
		if (this != obj) {
			howmany = obj.howmany;
			// c = new LinkedList<Integer>();

			LinkedList<Integer> temp = new LinkedList<Integer>();
			ListIterator<Integer> iterator = obj.c.listIterator();

			while (iterator.hasNext()) {
				temp.add(iterator.next());
			}
		
			// Set this list to temp.
			this.c = temp;
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
		return (c.contains(new Integer(i)));
	}

	 /**
	  * Inserts integer i into the front of the collection
	  *
	  * @param param1    Value to insert
	  */
	public void insert(int i)
	{
		Integer I = new Integer(i);
		if ((i>0)&&(!c.contains(i)))
		{
			c.addFirst(I);
		}
	}

	 /**
	  * Removes integer i from collection
	  *
	  * @param i    Value to omit
	  */
	public void omit(int i)
	{
		c.remove(new Integer(i));
		howmany--;
	}

	 /**
	  * Returns the number of values in the collection
	  *
	  * @return howmany  Number of values in collection
	  */
	public int get_howmany()
	{
		return howmany;
	}

	 /**
	  * Traverses array, prints each value of c in its own line until it reaches an empty value
	  */
	public void print()
	{
		ListIterator<Integer> iterator = c.listIterator();
		while (iterator.hasNext()) {
			Integer n = iterator.next();
			System.out.println(n.intValue());
		}
	}

	 /**
	  * Checks if the contents inside two Intcoll5 object are identical in content,
	  * by comparing sizes, then content for exact match.
	  *
	  * @return isequal   Boolean if two Intcoll5 objects are indentical in content
	  */
	public boolean equals(Intcoll5 obj)
	{	
		// make sure howmany is equal in both objects
		boolean isequal = (howmany == obj.howmany);

		ListIterator<Integer> iterator = c.listIterator();
		// loops thru each value, if content is identical then it remains true
		while (iterator.hasNext() && isequal) {
			isequal = obj.c.contains(iterator.next().intValue());
		}

		return isequal;
	}

}