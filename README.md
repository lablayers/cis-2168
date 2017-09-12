# Notes

## IntCollect Client

Using only public methods of the class

```java
void print (Intcoll P) {
  int n = P.gethowmany();
  int i = 1; // 1 is the smallest possible thing in there, not 0
  while(n > 0) {
    if(P.belongs(i)){
      System.out.println(i);
      n--;
    }
    i++;
  }
} 
```

## Magic Squares

You can ask someone to pick a # 1-31 and tell you which squares it appears in. From there you know which number was guessed. (Google 1-31 magic trick)

<table><tr><td><center><table border=1 cellpadding=2><tr><th bgcolor=red colspan=4><font color=white><center>Card No. 1 (RED)</center></font><tr><td><center><b>1</b></center><td><center><b>3</b></center><td><center><b>5</b></center><td><center><b>7</b></center><tr><td><center><b>9</b></center><td><center><b>11</b></center><td><center><b>13</b></center><td><center><b>15</b></center><tr><td><center><b>17</b></center><td><center><b>19</b></center><td><center><b>21</b></center><td><center><b>23</b></center><tr><td><center><b>25</b></center><td><center><b>27</b></center><td><center><b>29</b></center><td><center><b>31</b></center></table></center><td><table border=1 cellpadding=2><tr><th bgcolor=orange colspan=4><font color=white><center>Card No. 2 (YEL)</center></font><tr><td><center><b>2</b></center><td><center><b>3</b></center><td><center><b>6</b></center><td><center><b>7</b></center><tr><td><center><b>10</b></center><td><center><b>11</b></center><td><center><b>14</b></center><td><center><b>15</b></center><tr><td><center><b>18</b></center><td><center><b>19</b></center><td><center><b>22</b></center><td><center><b>23</b></center><tr><td><center><b>26</b></center><td><center><b>27</b></center><td><center><b>30</b></center><td><center><b>31</b></center></table><td><table border=1 cellpadding=2><tr><th bgcolor=blue colspan=4><font color=white><center>Card No. 3 (BLU)</center></font><tr><td><center><b>4</b></center><td><center><b>5</b></center><td><center><b>6</b></center><td><center><b>7</b></center><tr><td><center><b>12</b></center><td><center><b>13</b></center><td><center><b>14</b></center><td><center><b>15</b></center><tr><td><center><b>20</b></center><td><center><b>21</b></center><td><center><b>22</b></center><td><center><b>23</b></center><tr><td><center><b>28</b></center><td><center><b>29</b></center><td><center><b>30</b></center><td><center><b>31</b></center></table><td><center><table border=1 cellpadding=2><tr><th bgcolor=green colspan=4><font color=white><center>Card No. 4 (GRE)</center></font><tr><td><center><b>8</b></center><td><center><b>9</b></center><td><center><b>10</b></center><td><center><b>11</b></center><tr><td><center><b>12</b></center><td><center><b>13</b></center><td><center><b>14</b></center><td><center><b>15</b></center><tr><td><center><b>24</b></center><td><center><b>25</b></center><td><center><b>26</b></center><td><center><b>27</b></center><tr><td><center><b>28</b></center><td><center><b>29</b></center><td><center><b>30</b></center><td><center><b>31</b></center></table></center><td><center><table border=1 cellpadding=2><tr><th bgcolor=gray colspan=4><font color=white><center>Card No. 5 (GRA)</center></font><tr><td><center><b>16</b></center><td><center><b>17</b></center><td><center><b>18</b></center><td><center><b>19</b></center><tr><td><center><b>20</b></center><td><center><b>21</b></center><td><center><b>22</b></center><td><center><b>23</b></center><tr><td><center><b>24</b></center><td><center><b>25</b></center><td><center><b>26</b></center><td><center><b>27</b></center><tr><td><center><b>28</b></center><td><center><b>29</b></center><td><center><b>30</b></center><td><center><b>31</b></center></table></center></table>

Intcoll can be modified to perform this trick with intersections - by finding the lowest # that appears in the color squares specified (see 4 Puzzle/puzzle.java)

It's important to understand the difference between client and public method of the class.

## Linked Lists

It's type of data structure. It has list items, and each item can store a value of a specified type. Let's say A[] is an interger linked list that like this:

| 8 | 10 | 3 | -40 |
|--|--|--|--|

Each item in the linked list stores **information** and a **pointer**. The pointer tells you where the next list item is stored (➡️ ) or a **null value** where it terminates (❌ ). So A[] looks more like this:

| A[] ➡️ | 8 ➡️ | 10 ➡️ | 3 ➡️ | -40 ❌ |
|--|--|--|--|--|

It's a sequential type of storage, so traversing for a specific index takes time!

But how can we use it? Let's make a class with constructors...

```java
private class ListItem {
  private into info;
  private ListItem link;
  public ListItem () {
    info = 0;
    link = null;
  }
  public ListItem (int i, ListItem p) {
    info = i;
    link = p;
  }
}
```

Adding a list item entails this code snippet:

```java
ListItem A = new ListItem(8,null);
```

To traverse a linked list, your code would look something like this:

```java
ListItem p = A;
while (p != null) {
  //// code that process list item p points to goes here
  p = p.link
}
```

## Other Types of Linked Lists

**Doubly linked list** stores pointers in both directions... in case you want to travese backwards for some reason. 

| A[] ➡️ |️ 8 ➡️ | ⬅️ 10 ➡️ | ⬅️ 3 ➡️ | ⬅️ -40 ❌ |
|--|--|--|--|--|

**Circular list** does not store a null (terminating) pointer at its last value, instead the last value points back to the first value.

| A[] ➡️ | 8 ➡️ | 10 ➡️ | 3 ➡️ | -40➡️ (back to 8) |
|--|--|--|--|--|

**Doubly linked circular list** combines both of above! 😼

| A[] ➡️ |️ 8 ➡️ | ⬅️ 10 ➡️ | ⬅️ 3 ➡️ | ⬅️ -40 ➡️ (back to 8) |
|--|--|--|--|--|

## 