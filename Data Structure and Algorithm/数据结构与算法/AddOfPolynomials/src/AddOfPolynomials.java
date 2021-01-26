public class AddOfPolynomials {
    public static linkedlist AddOfPolynomials(linkedlist a,linkedlist b){
        listnode anode=a.head;
        listnode bnode=b.head;
        linkedlist result=new linkedlist(0);
        while (anode!=null) {
            if (anode.exponent == bnode.exponent) {
                result.tail.exponent = anode.exponent;
                result.tail.data = anode.data + bnode.data;
                anode=anode.next;
                bnode=bnode.next;
                result.add(-10000);
            }
            else if (anode.exponent>bnode.exponent){
                anode=anode.next;
            }
            else if (anode.exponent<bnode.exponent){
                bnode=bnode.next;
            }
        }
        result.remove(-10000);
        return result;
    }
    public static void main(String[] args){
        linkedlist a=new linkedlist(-3);
        a.head.exponent=2;
        a.add(2);
        a.tail.exponent=1;
        a.add(1);
        a.tail.exponent=0;
        linkedlist b=new linkedlist(4);
        b.head.exponent=2;
        b.add(1);
        b.tail.exponent=1;
        b.add(0);
        b.tail.exponent=0;
        AddOfPolynomials(a, b).printlinkedlist();
    }
}
