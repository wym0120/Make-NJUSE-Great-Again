public class chapter1 {
    public static boolean isPalindromes(char[] a,int low,int high,int length){
        if(length==1 || length==0){
            return true;
        }
        if(a[low]!=a[high] || low>=high){
            return false;
        }
        return isPalindromes(a,low+1,high-1,length-2);
    }
    public static void main(String[] args){
        String a="Mada,ma dam";
        a=a.replace(" ","");
        a=a.replaceAll("\\pP","");
        a=a.toLowerCase();
        System.out.println(isPalindromes(a.toCharArray(),0,a.length()-1,a.length()));
    }
}




