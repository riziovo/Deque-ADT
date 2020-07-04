# Deque-ADT
implementation details of various Deques
<b>Sentinent Deque with Duality</b>

<b>an array with Deque like interface and ArrayList like behaviour. And lightweight.</b>


<b>MODULES</b>
Alpine -- An Array-Based DEQUE Implementation With Duality

INode && ONode -- Linked List Based DEQUE Implementation


INode && ONode -- Linked List Based DEQUE Implementation


ALPINE
Alpine is a two-way expanding buffer that manages itself entirely based on its LEFT and RIGHT FILL COEFFICIENT. User can configure the EXPANSION RATE and the COEFFICIENTS.

~ To Infinity and Beyond (RAM)!

iNode//oNode
These two modules are linked list based implementations with more flexibility by giving away speed. I had a lot of fun implementing these two modules. Both differ with slight variations


The expansion is indeed linear time O(N), which to be fair, is the same with Java's ArrayList. And yet, due to its Contiguous nature in memory, for relative small numbers it flat out smashes O(Log N) structures with hefty margins. Especially with NVMe SSDs.
