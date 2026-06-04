import java.util.*;
import java.io.*;

public class JosephusSim {
private PersonNode first;  // start of circle
private int size;          // number of people
private int eliminationCount;
private PersonNode current; // helps track position
   public JosephusSim(String fileName) {
      try {
         // load names from the file in order, generating a singly linked list of PersonNodes
         Scanner file = new Scanner(new File(fileName));
         
         // make the ring circular by attaching last node's next to front
         PersonNode prev = null;

      while (file.hasNextLine()) {
       String name = file.nextLine();
       PersonNode newNode = new PersonNode(name);

       if (first == null) {
        first = newNode;
       } else {
        prev.next = newNode;
       }

       prev = newNode;
       size++;
   }
         // generate, print, and save the random elimination count

      } catch (FileNotFoundException e) {
         System.out.println("Something went wrong with " + fileName);
      }
      prev.next = first;
      current = first;
      Random rand = new Random();
      eliminationCount = rand.nextInt(size / 2) + 1;
      System.out.println("=== Elimination count is " + eliminationCount + " ===");
   }
   
   // optional helper method for constructing the circle
   private void add(String val) {
   }
   
   public void eliminate() {
      // count to the elimination count
      
      // print who will be eliminated
      
      // eliminate the person and update "front" of the circle and size

   }
   
   public boolean isOver() {
      // check if there's only one person left in the circle
      return false;
   }
   
   public String toString() {
      // if there's only one person left, print them as the last survivor
      
      // if many, print survivors (watch out for infinite loop since list is circular)

      return "";
   }

}
