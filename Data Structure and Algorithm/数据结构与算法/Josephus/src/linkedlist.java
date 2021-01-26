public class linkedlist {
    private listnode tail;//尾部标记
    public listnode head;//开头标记

    public linkedlist(int firstdata){
        listnode node =new listnode(firstdata);
        head=node;
        tail=node;
    }
    //在末尾添加一个新的节点
    public void add(int content){
        listnode another=new listnode(content);
        tail.next=another;
        tail=another;
        return;
    }
    //删除某个节点
    public void remove(int content){
        listnode itr=head;
        if (itr.data==content){
            head=itr.next;
            return;
        }
        while (itr.next!=null) {
            if (itr.next.data == content) {
                itr.next=itr.next.next;
                break;
            } else {
                itr = itr.next;
            }
        }
        return;
    }

    public void printlinkedlist(){
        listnode itr=head;
        while (itr.next!=null){
            System.out.print(itr.data+" ");
            itr=itr.next;
        }
        System.out.println(itr.data);
        return;
    }



}
