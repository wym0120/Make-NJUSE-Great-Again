import java.util.LinkedList;

public class Josephus {
    public static int solutionByArray(int n,int m){
        int array[]=new int[n];
        //把人编号
        for(int i=1;i<=n;i++){
            array[i-1]=i;
        }
        int left=n;
        int index=0;
        int result=-1;
        int lossnumber=m;
        //用-1代表被淘汰
        while(left>1) {
            if (array[index] != -1) {
                if (lossnumber == 1) {
                    array[index] = -1;
                    left--;
                    lossnumber = m;
                    index++;
                } else {
                    lossnumber--;
                    index++;
                }
            }
            else if (array[index]==-1){
                index++;
            }
            if (index==n){
                index=0;
            }
        }
        for (int i=0;i<n-1;i++){
            if(array[i]!=-1){
                result=array[i];
            }
        }
        return result;
    }

    public static int solutionByLinkedlist(int n,int m){
        linkedlist human=new linkedlist(1);
        for (int i=2;i<=n;i++){
            human.add(i);
        }
        int result=-1;
        int lossnumber=m;
        int left=n;
        listnode itr=human.head;
        while (left>1){
            if (lossnumber==1){
                human.remove(itr.data);
                itr=itr.next;
                lossnumber=m;
                left--;
            }
            else {
                lossnumber--;
                itr=itr.next;
            }
            if (itr==null){
                itr=human.head;
            }
        }
        result=human.head.data;
        return result;
    }
    public static void main(String[] args){
        System.out.println(solutionByArray(8, 3));
        System.out.println(solutionByLinkedlist(8, 3));

    }
}
