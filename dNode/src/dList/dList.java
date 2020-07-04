package dList;

public class dList {
    private dNode oneNode;
    private static int SIZE;

    private static class dNode{
        dNode previous, next;
        int val;

        dNode()
        {
            this.previous=this.next=null;
            this.val=-71;
        }
        dNode(int value)
        {
            this.val=value;
            this.previous=this.next=null;
        }
        dNode(int value, dNode nextNode, dNode prevNode)
        {
            this.val = value;
            this.next = nextNode;
            this.previous = prevNode;
        }
    }

    public dList()
    {
        this.oneNode = new dNode(-71);
        this.oneNode.previous = oneNode;
        this.oneNode.next = oneNode;
    }

    public void addFirstElement(int value)
    {
        dNode node = new dNode(value);
        node.previous = oneNode;
        node.next = oneNode.next;

        oneNode.next = node;
        oneNode.previous = node;

        dList.SIZE++;
    }

    public void addElement(int value)
    {
        dNode node = new dNode(value);
        node.previous = oneNode.previous;
        node.next = oneNode.next;

        oneNode.previous.next = node;
        oneNode.previous = node;

        dList.SIZE++;
    }

    public void insertFront(int value)
    {
        oneNode.next=new dNode(value,oneNode.next, oneNode.previous);
        dList.SIZE++;
    }

    public int getBack()
    {
        if(dList.SIZE > 0) return oneNode.previous.val;
        return -71;
    }

    public int getFront()
    {
        if(dList.SIZE > 0) return oneNode.next.val;
        return -71;
    }

    public boolean remove(int y)
    {
        if(dList.SIZE < 1) return false;

        dNode head=oneNode.next;

        int i;
        for (i = 1; i < dList.SIZE; i++)
        {
            if(head.val == y)
            {
                head.previous.next = head.next;
                head.next.previous = head.previous;
                dList.SIZE--;
                return true;
            }
            head = head.next;
        }

        if(oneNode.previous.val == y)
        {
            this.removeLast();
            return true;
        }

        return false;
    }

    public void removeLast()
    {
        oneNode.previous.previous.next = oneNode.next;
        oneNode.previous = oneNode.previous.previous;
        dList.SIZE--;
    }

    public void printAll()
    {
        if(dList.SIZE < 1) return;

        dNode trackNode = oneNode.next;
        StringBuilder ap=new StringBuilder();
        for (int i = 0; i < dList.SIZE; i++)
        {
            ap.append(trackNode.val).append(" ");
            trackNode=trackNode.next;
        }

        System.out.println(ap.toString());
    }

    public int printIndx(int dex)
    {
        if(dList.SIZE < 1) return 0;
        if(dex > dList.SIZE) return 0;

        dNode node= oneNode.next;
        int indx=0;
        while (indx < dex-1)
        {
            node=node.next;
            indx++;
        }

        return node.val;
    }

    public void addAdjacent()
    {
        dNode head=oneNode.next;
        while(head != oneNode.previous)
        {
            if(head.val == head.next.val)
            {
                head.next.val+=head.val;
                head.previous.next=head.next;
                head.next.previous=head.previous;
                dList.SIZE--;
            }
            else head = head.next;
        }
    }

    public boolean isEmpty()
    {
        return dList.SIZE < 1;
    }
}
