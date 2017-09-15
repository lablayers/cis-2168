import java.util.*;
import java.io.*;

public class puzzle
{
   public static void main(String[] args)
   {
      Intcoll1 RED=new Intcoll1(16), YEL=new Intcoll1(16), BLU=new Intcoll1(16),
      GRE=new Intcoll1(16), GRA=new Intcoll1(16);
      int i, num;
      String name=args[0];
      try
      {
         BufferedReader ins=new BufferedReader(new FileReader(name));
         Scanner data=new Scanner(ins);

         for(i=1; i<=16; i++) {num=data.nextInt(); RED.insert(num);}
         for(i=1; i<=16; i++) {num=data.nextInt(); YEL.insert(num);}
         for (i=1; i<=16; i++) {num=data.nextInt(); BLU.insert(num);}
         for (i=1; i<=16; i++) {num=data.nextInt(); GRE.insert(num);}
         for (i=1; i<=16; i++) {num=data.nextInt(); GRA.insert(num);}

         String s; Scanner keyboard=new Scanner(System.in);
         Intcoll1[] D=new Intcoll1[5]; Intcoll1 Result=new Intcoll1(16);
         System.out.println(
         "Enter the colors for your integer using # as a sentinel!");
         s=keyboard.next(); i=0;
         while(!s.equals("#"))
         {
            if (s.equals("RED")) D[i]=RED;
            else if (s.equals("YEL")) D[i]=YEL;
            else if (s.equals("BLU")) D[i]=BLU;
            else if (s.equals("GRA")) D[i]=GRA;
            else D[i]=GRE;
            i++; s=keyboard.next();
         }
         i--;

         Result=D[i]; i--;
         while (i>=0)
         {
            Result=intersection(D[i], Result); i--;
         }
         int answer=min(Result);
         System.out.println("Your integer is "+answer);
      }
      catch (IOException ex)
      {
	ex.printStackTrace(System.err);
	System.exit(1);
      }
}
   public static Intcoll1 intersection(Intcoll1 A, Intcoll1  B)
   {
       int i=1, n=A.get_howmany(); Intcoll1 C=new Intcoll1();

       while (n>0)
       {
         if (A.belongs(i))
         {
            n--;
            if (B.belongs(i)) C.insert(i);
         }
         i++;
       }
       return C;
   }

   public static int min(Intcoll1 obj)
   {
       int i=1;

       while (!obj.belongs(i)) i++;
       return i;
   }
}