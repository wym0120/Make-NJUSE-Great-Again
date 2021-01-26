public class Stack {
    private Object[] array;
    private int top;
    private int size;

    public Stack(int size){
        this.size=size;
        this.array=new Object[size];
        this.top=size;
    }

    public boolean isEmpty(){
        if (top==this.size){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean isFull(){
        if (top==-1){
            return true;
        }
        else {
            return false;
        }
    }

    public void push(Object number){
        top--;
        array[top]=number;
    }

    public Object pop(){
        top++;
        return array[top - 1];
    }

    public Object checktop(){
        return array[top];
    }

    public boolean check(Object k){
        for (int i=top;i>=0;i--){
            if (array[i].equals(k)){
                return true;
            }
        }
        return false;
    }
}
