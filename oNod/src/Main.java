import oNod.*;

import java.util.Scanner;

public class Main {
    public static void main(String arg[])
    {
        oList olist=new oList();
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
                if(olist.isEmpty())
                {
                    olist.addFirstElement((int)Integer.parseInt(range[0]));

                    for (int i = 1; i < range.length; i++) {
                        olist.add((int)Integer.parseInt(range[i]));
                    }
                }
                else
                {
                    for (String x:range)
                        olist.add((int)Integer.parseInt(x));

                }
                olist.printAll();
            }
            else if(input == 2)
            {
                System.out.println("==============================");
                System.out.println("Input the element to remove:");
                int move=scn.nextInt();
                olist.remove(move);

                olist.printAll();
            }
            else if(input == 3)
            {
                System.out.println("===============================");
                System.out.println("Input the index:");
                int dx=scn.nextInt();
                System.out.println("\nThe element at index "+dx+" is "+olist.printIndx(dx));
            }
            else if(input == 4)
            {
                System.out.println("====================");
                System.out.println("\nALL ELEMENTS");
                olist.printAll();
            }
            else if(input == 5)
            {
                System.out.println("====================");
                System.out.println("\nGet Front: "+olist.getFront());
            }
            else if(input == 6)
            {
                System.out.println("====================");
                System.out.println("\nGet Back: "+olist.getBack());
            }
            else if(input == 7)
            {
                System.out.println("====================");
                System.out.println("\nAdd adjacent: ");
                olist.addAdjacent();
                olist.printAll();
            }
            else if(input == 0)
            {
                System.out.println("============ E X I T =========");
                break;
            }
        }
    }
}
