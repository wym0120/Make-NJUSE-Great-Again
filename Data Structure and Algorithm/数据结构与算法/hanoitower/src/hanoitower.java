public class hanoitower {
    public static void hanoi(int n,char a,char b,char c){
        //a是起始柱，b是中转柱，c是目标柱
        if (n==1){
            System.out.println("put the plate "+n+" from "+a+" to "+c);
        }
        else {
            hanoi(n-1, a, c, b);
            System.out.println("put the plate "+n+" from "+a+" to "+c);
            hanoi(n-1, b, a, c);
        }
    }
    public static void main(String[] args){
        hanoi(4, 'a', 'b', 'c');
    }
}
