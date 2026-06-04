import java.util.*;
import java.io.*;

public class JosephusSim {

    private PersonNode first;   // start of circle
    private int size;           // number of people
    private int eliminationCount;
    private PersonNode current; // helps track position

    public JosephusSim(String fileName) {
        try {
            Scanner file = new Scanner(new File(fileName));

            PersonNode prev = null;

            // build linked list
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

            // make circular
            if (prev != null) {
                prev.next = first;
            }

            // set current pointer
            current = first;

            // generate elimination count (1 to size/2)
            Random rand = new Random();
            eliminationCount = rand.nextInt(size / 2) + 1;

            System.out.println("=== Elimination count is " + eliminationCount + " ===");

        } catch (FileNotFoundException e) {
            System.out.println("Something went wrong with " + fileName);
        }
    }

    public void eliminate() {
        if (size <= 1) return;

        // move to node BEFORE the one to delete
        for (int i = 1; i < eliminationCount - 1; i++) {
            current = current.next;
        }

        PersonNode toDelete = current.next;

        System.out.println(toDelete.name + " eliminated!");

        // remove node
        current.next = toDelete.next;

        // update first if needed
        if (toDelete == first) {
            first = toDelete.next;
        }

        // move forward for next round
        current = current.next;

        size--;
    }

    public boolean isOver() {
        return size == 1;
    }

    public String toString() {
        if (size == 0) return "";

        // last survivor
        if (size == 1) {
            return first.name + " is the last survivor!";
        }

        String result = "Remaining survivors: ";

        PersonNode temp = first;
        int count = 1;

        do {
            result += count + "-" + temp.name;
            temp = temp.next;
            count++;

            if (temp != first) {
                result += ", ";
            }

        } while (temp != first);

        return result;
    }
}
