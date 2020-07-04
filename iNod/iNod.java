package iNod;

public class iList {
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
            this.next=null;
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
    public iList()
    {
        size=0;
        oneNode = new iNod(-71);
        tail = oneNode;
    }

    public void add(int value)
    {
        tail.next= new iNod(value);
        tail=tail.next;
        iList.size++;
    }

    public void insertFront(int value)
    {
        oneNode.next=new iNod(value,oneNode.next);
    }

    public int getBack()
    {
        if(iList.size > 0) return tail.i;
        return -71;
    }

    public int getFront()
    {
        if(iList.size > 0) return oneNode.next.i;
        return -71;
    }

    public boolean remove(int y)
    {
        if(iList.size < 1) return false;

        iNod head=oneNode;
        while(head.next != tail)
        {
            if(head.next.i == y)
            {
                head.next=head.next.next;
                iList.size--;
                return true;
            }
            head=head.next;
        }
       if(head.next.i == y)
        {
            tail = head;
            tail.next = oneNode.next;
            iList.size--;
            return true;
        }

        return false;
    }

    public void addAjacent()
    {
        iNod head=oneNode;
        while (head.next.next != null)
        {
            if(head.next.i == head.next.next.i)
            {
                head.next.next.i+=head.next.i;
                head.next=head.next.next;
                iList.size--;
            }
            else head=head.next;
        }
    }

    public void printAll()
    {
        if(iList.size < 1) return;

        iNod trackNode=oneNode.next;
        StringBuilder ap=new StringBuilder();
        while(trackNode != tail)
        {
            ap.append(trackNode.i).append(" ");
            trackNode=trackNode.next;
        }
        ap.append(trackNode.i);
        System.out.println(ap.toString());
    }

    public int printIndx(int dex)
    {
        if(oneNode.next == null) return 0;
        if(dex-1 > iList.size) return 0;

        iNod node= oneNode.next;
        int indx=0;
        while (indx < dex-1)
        {
            node=node.next;
            indx++;
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
}