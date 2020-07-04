package Alpine;

public class Alpine <trait>{
    private final static int RESIZE_FACTOR=2;
    trait[] packet;
    int SIZE, firstP;
    private final static int L_COEFFICIENT = 1, R_COEFFICIENT = 2, BALANCE = 0, NO_NEED_TO_BALANCE = -1;
    private final static float BALANCE_LIMIT_HALV = (float) 0.25, BALANCE_LIMIT_CHECK = (float) 0.46,
            LEFT_OCCUPIED_TOO_MUCH = (float) 0.2, RIGHT_OCCUPIED_TOO_MUCH = (float) 0.8;

    public Alpine()
    {
        packet = (trait[])new Object[8];
        this.SIZE = 0;
        firstP = 4;
    }

    private Alpine(int buffer, int SIZE, int firstP)
    {
        this.packet = (trait[])new Object[buffer];
        this.SIZE = SIZE;
        this.firstP = firstP;
    }

    public Alpine(Alpine A)
    {
        Alpine B = new Alpine(A.packet.length, A.SIZE, A.firstP);

        System.arraycopy(A.packet, A.firstP, B.packet, B.firstP, A.SIZE);
        this.SIZE = B.SIZE;
        this.packet =(trait[]) B.packet;
        this.firstP = B.firstP;
    }

    public void addLast(trait t)
    {
        boolean right = true;
        this.runBalanceVisor(right);

        this.packet[firstP+SIZE] = t;
        this.SIZE++;
    }

    public void addFirst(trait t)
    {
        boolean right = false;
        this.runBalanceVisor(right);

        this.firstP-=1;
        this.packet[firstP] = t;
        this.SIZE++;
    }

    private void resize(int COEFFICIENT)
    {
        if(COEFFICIENT == NO_NEED_TO_BALANCE) return;

        int cap = this.packet.length+ (this.packet.length/2);
        int startP = firstP;
        if(COEFFICIENT == BALANCE)
        {
            cap = this.packet.length*2;
            startP = (cap - this.SIZE)/2;
        }
        else if(COEFFICIENT == L_COEFFICIENT)
            startP = startP + (this.packet.length/2);

        trait[] tx =(trait[]) new Object[cap];
        System.arraycopy(this.packet, firstP, tx, startP, this.SIZE);

        this.firstP = startP;
        this.packet = tx;
        System.out.println("Length:"+this.packet.length+" firstP:"+firstP+" lastP:"+(firstP+this.SIZE));
    }

    private void runBalanceVisor(boolean right)
    {
        int COEFFICIENT = this.checkBalance(right);
        this.resize(COEFFICIENT);
    }

    private int checkBalance(boolean right)
    {
        float usageQuotient = checkUsageRatio();

        if(usageQuotient >= BALANCE_LIMIT_CHECK)
        {
            if(right)
            {
                float eQuotient = this.eSpaceQuotient();
                if(eQuotient > RIGHT_OCCUPIED_TOO_MUCH) return R_COEFFICIENT;
            }else {
                float iQuotient = iSpaceQuotient();
                if(iQuotient < LEFT_OCCUPIED_TOO_MUCH) return L_COEFFICIENT;
            }

            if(this.SIZE > 55 && usageQuotient < BALANCE_LIMIT_HALV) this.halv();
        }
        return NO_NEED_TO_BALANCE;
    }

    private float checkUsageRatio()
    {
        return (float)this.SIZE/(float)this.packet.length;
    }

    private float iSpaceQuotient()
    {
        return (float)this.firstP/((float)this.packet.length/2);
    }

    private float eSpaceQuotient()
    {
        return ((float)this.firstP+(float)this.SIZE)/((float)this.packet.length);
    }

    private void halv()
    {
        int cap =this.packet.length/2;
        int startP = (cap - this.SIZE)/2;
        trait[] tx =(trait[]) new Object[cap];
        System.arraycopy(this.packet, firstP, tx, startP, this.SIZE);

        this.firstP = startP;
        this.packet = tx;
        System.out.println("HALV\nLength:"+this.packet.length+" firstP:"+firstP+" lastP:"+(firstP+this.SIZE));
    }

    public void remove(int index)
    {
        if(this.isEmpty()) return;
        if(index > this.SIZE || index < 0) return;
        if(index == this.SIZE)
        {
            this.removeLast();
            return;
        }
        else if(index == 1)
        {
            this.removeFirst();
            return;
        }

        this.packet[firstP+index-1] = this.packet[this.firstP+this.SIZE-1];
        this.packet[this.firstP+this.SIZE-1] = null;
        this.SIZE--;
    }

    public void removeFirst()
    {
        if(this.isEmpty()) return;

        this.packet[firstP] = null;
        firstP++;
        this.SIZE--;
    }

    public void removeLast()
    {
        if(this.isEmpty()) return;

        this.packet[firstP+this.SIZE-1] = null;
        this.SIZE--;
    }

    public boolean isEmpty()
    {
        return this.SIZE < 1;
    }

    public trait get(int index)
    {
        if(this.isEmpty()) return null;
        if(index > this.SIZE || index < 0) return null;

        return this.packet[firstP+index-1];
    }

    public trait getFirst()
    {
        if(this.isEmpty()) return null;
        return this.packet[firstP];
    }

    public trait getLast()
    {
        if(this.isEmpty()) return null;
        return this.packet[firstP+this.SIZE-1];
    }

    public void printDeque()
    {
        for (int i = firstP; i < firstP+this.SIZE; i++)
            System.out.print(this.packet[i].toString()+" ");

        System.out.println();
    }

}
