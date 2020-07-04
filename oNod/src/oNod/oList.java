package oNod;

public class oList {
    static int size=0;
    iNod oneNode;
    iNod tail;

    private static class iNod{
        int i;
        iNod next;

        iNod()
        {
            this.i=0;
            this.next=null;
        }
        iNod(int i)
        {
            this.i=i;
        }
        iNod(int i, iNod node)
        {
            this.i=i;
            this.next=node;
        }
        void setNextNode(iNod nxt)
        {
            this.next=nxt;
        }
    }
    public oList()
    {
        size=0;
        oneNode = new iNod(-71);
        tail = oneNode;
    }

    public void addFirstElement(int value)
    {
        tail.next = new iNod(value);
        tail = tail.next;
        tail.next = oneNode.next;
        oList.size++;
    }

    public void add(int value)
    {
        tail.next = new iNod(value);
        tail = tail.next;
        tail.next = oneNode.next;
        oList.size++;
    }

    public void insertFront(int value)
    {
        oneNode.next=new iNod(value,oneNode.next);
        oList.size++;
    }

    public void insertAt(int indx, int value)
    {
        if(indx > oList.size) return;

        iNod head = oneNode.next;
        while(indx > 1)
        {
            head = head.next;
            indx--;
        }
        head.next = new iNod(value,head.next.next);
        oList.size++;
    }

    public int getBack()
    {
        if(oList.size > 0) return tail.i;
        return -71;
    }

    public int getFront()
    {
        if(oList.size > 0) return oneNode.next.i;
        return -71;
    }

    public boolean remove(int y)
    {
        if (oList.size < 1) return false;
        if (oList.size == 1)
        {
            oneNode.next = oneNode;
            tail = oneNode;
            oList.size= 0;
            return true;
        }

        iNod head = oneNode;
        while(head != tail)
        {
            if(head.next.i == y)
            {
                head.next = head.next.next;
                oList.size--;
                return true;
            }
            head = head.next;
        }
        return false;
    }

    public void addAdjacent()
    {
        if(oList.size < 2) return;

        iNod head = oneNode;
        while(head != tail)
        {
            if(head.next.i == head.next.next.i)
            {
                head.next.next.i+= head.next.next.i;
                head.next = head.next.next;
                oList.size--;
            }
            else head = head.next;
        }
    }

    public void printAll()
    {
        if(oList.size < 1) return;

        iNod trackNode=oneNode.next;
        StringBuilder ap=new StringBuilder();
        for (int i = 0; i < oList.size; i++)
        {
            ap.append(trackNode.i).append(" ");
            trackNode=trackNode.next;
        }
        System.out.println(ap.toString());
    }

    public int printIndx(int dex)
    {
        if(dex-1 > oList.size) return 0;

        iNod node= oneNode.next;
        while (dex >= 0)
        {
            node=node.next;
            dex--;
        }

        return node.i;
    }

    public int Size()
    {
        if( oneNode.next == null) return 0;

        int incr=1;
        iNod node=oneNode.next;
        while(node.next!=null) incr++;

        return incr;
    }

    public boolean isEmpty()
    {
        return oList.size < 1;
    }
}