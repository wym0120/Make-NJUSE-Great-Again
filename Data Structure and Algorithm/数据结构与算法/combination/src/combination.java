
public class combination {
    public static void function(int a,int b,int pinpoint,int[] x){
        if (a==b){
            for(int m=0;m<pinpoint;m++) {
                System.out.print(x[m]);
            }
            for(int i=0;i<a;i++){
                System.out.print(a-i);
            }
            System.out.println();
            return;
        }
        else {
            if(b==1){
                for (int k=0;k<a;k++) {
                    for(int m=0;m<pinpoint;m++){
                        System.out.print(x[m]);
                    }
                    System.out.println(a-k);
                }
                return;
            }
            for (int i=0;a-i>=b;i++) {
                x[pinpoint]=a-i;
                function(a-i-1,b-1,pinpoint+1,x);
            }
            return;
        }
    }
    public static void main(String[] args){
        int[] result= new int[4];
        function(6,4,0,result);
    }
}