import iNod.*;

import java.util.Scanner;

public class Main {
    public static void main(String arg[])
    {
        iList ilist=new iList();
        Scanner scn=new Scanner(System.in);

        while (true)
        {
            System.out.println("\n1.Add int to list." +
                    "\n2.Remove int to list." +
                    "\n3.Print ith element." +
                    "\n4.Print all." +
                    "\n5.Get front." +
                    "\n6.Get back." +
                    "\n7.Add adjacent elements." +
                    "\n0.Exit.");
            System.out.println("\nINPUT:");
            int input=scn.nextInt();

            if(input == 1)
            {
                System.out.println("==============================");
                System.out.println("Input the number of inputs:");
                int n=scn.nextInt();
                scn.nextLine();

                System.out.println("Enter Integers followed by space(each) :");
                String[] range=scn.nextLine().split(" ");
                for (String x:range)
                    ilist.add((int)Integer.parseInt(x));

                ilist.printAll();
            }
            else if(input == 2)
            {
                System.out.println("==============================");
                System.out.println("Input the element to remove:");
                int move=scn.nextInt();
                ilist.remove(move);

                ilist.printAll();
            }
            else if(input == 3)
            {
                System.out.println("===============================");
                System.out.println("Input the index:");
                int dx=scn.nextInt();
                System.out.println("\nThe element at index "+dx+" is "+ilist.printIndx(dx));
            }
            else if(input == 4)
            {
                System.out.println("====================");
                System.out.println("\nALL ELEMENTS");
                ilist.printAll();
            }
            else if(input == 5)
            {
                System.out.println("====================");
                System.out.println("\nGet Front: "+ilist.getFront());
            }
            else if(input == 6)
            {
                System.out.println("====================");
                System.out.println("\nGet Back: "+ilist.getBack());
            }
            else if(input == 7)
            {
                System.out.println("====================");
                System.out.println("\nAdd adjacent: ");
                ilist.addAjacent();
                ilist.printAll();
            }
            else if(input == 0)
            {
                System.out.println("============ E X I T =========");
                break;
            }
        }
    }
}
