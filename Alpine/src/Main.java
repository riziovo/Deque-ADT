import Alpine.*;

import java.util.Scanner;

class Main2 {
    public static void main(String[] arg)
    {
        Scanner scn=new Scanner(System.in);
        System.out.println("Enter DEQUE type. 1=Integer, 2=String:");
        String st = scn.nextLine();
        Alpine <Object>deq = new Alpine<>();

        while (true)
        {
            System.out.println("\n1.Add int to list." +
                    "\n10.Add element at front." +
                    "\n11.Add element at back." +
                    "\n2.Remove element at index." +
                    "\n3.Get ith element." +
                    "\n4.Print all." +
                    "\n5.Get front." +
                    "\n6.Get back." +
                    "\n7.Remove first element." +
                    "\n8.Remove last element." +
                    "\n9.Deep copy new list and return." +
                    "\n0.Exit.");
            System.out.println("\nINPUT:");
            int input=scn.nextInt();

            if(input == 1)
            {
                System.out.println("==============================");
                scn.nextLine();

                System.out.println("Enter Integers followed by space(each) :");
                Object[] range=scn.nextLine().split(" ");

                if (deq.isEmpty()) {
                    deq.addFirst(range[0]);

                    for (int i = 1; i < range.length; i++) {
                        deq.addLast(range[i]);
                    }
                } else {
                    for (Object x : range)
                        deq.addLast(x);

                }
                deq.printDeque();
            }
            else if(input == 10)
            {
                System.out.println("==============================");
                System.out.println("Add element at front:");
                int move=scn.nextInt();
                deq.addFirst(move);

                deq.printDeque();
            }
            else if(input == 11)
            {
                System.out.println("==============================");
                System.out.println("Add element at back:");
                int move=scn.nextInt();
                deq.addLast(move);

                deq.printDeque();
            }
            else if(input == 2)
            {
                System.out.println("==============================");
                System.out.println("Input the index of element to remove:");
                int move=scn.nextInt();
                deq.remove(move);

                deq.printDeque();
            }
            else if(input == 3)
            {
                System.out.println("===============================");
                System.out.println("Input the index:");
                int dx=scn.nextInt();
                System.out.println("\nThe element at index "+dx+" is "+deq.get(dx));
                deq.printDeque();
            }
            else if(input == 4)
            {
                System.out.println("====================");
                System.out.println("\nALL ELEMENTS");
                deq.printDeque();
            }
            else if(input == 5)
            {
                System.out.println("====================");
                System.out.println("\nGet Front: "+deq.getFirst());
                deq.printDeque();
            }
            else if(input == 6)
            {
                System.out.println("====================");
                System.out.println("\nGet Back: "+deq.getLast());
                deq.printDeque();
            }
            else if(input == 7)
            {
                System.out.println("====================");
                System.out.println("\nRemove first. ");
                deq.removeFirst();
                deq.printDeque();
            }
            else if(input == 8)
            {
                System.out.println("====================");
                System.out.println("\nRemove last. ");
                deq.removeLast();
                deq.printDeque();
            }
            else if(input == 9)
            {
                System.out.println("====================");
                System.out.println("\n9.Deep copy new list and return. ");
                Alpine neq=new Alpine(deq);
                neq.printDeque();
            }
            else if(input == 0)
            {
                System.out.println("============ E X I T =========");
                break;
            }
        }
    }
}