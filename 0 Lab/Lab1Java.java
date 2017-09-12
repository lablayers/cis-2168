import java.util.*;

public class Lab1Java {

    private int[] c;
    
    public static void main(String[] args) {
    
      Lab1Java A=new Lab1Java();
      A.show();
      A.enlarge();
      A.fill();
      A.show();
       
    }
    
    public Lab1Java()
    {
       System.out.println("Enter the array size");
       Scanner keyboard=new Scanner(System.in);
       int n=keyboard.nextInt();
       c=new int[n]; 
       int i=0;
       while (i<n)
       {
          System.out.println("Enter an integer");
          c[i]=keyboard.nextInt();
          i++;
       }
    }

    public void enlarge()
    {
      
      // Create a temporary array double the size of c (since existing array sizes can't be changed)
      int[] temp = new int[c.length*2];
      
      // Dplicate existing values of c into the temporary array
      for(int i = 0; i < c.length; i++){
        temp[i] = c[i];
      }
      
      // Set c to the pointer of temporary array
      c = temp;
      
      // Debugging
      System.out.println("Enlarged array length: " + c.length);
    }

    public void fill()
    {
       Scanner keyboard=new Scanner(System.in);
       int n=c.length;
       int i=n/2;
       while (i<n)
       {
          System.out.println("Enter an integer");
          c[i]=keyboard.nextInt();
          i++;
       }
    }

    public void show()
    {
       System.out.println("The array entries are:");
       int i=0;
       int n=c.length;
       while (i<n)
       {
          System.out.println(c[i]);
          i++;
       }
    }
}
