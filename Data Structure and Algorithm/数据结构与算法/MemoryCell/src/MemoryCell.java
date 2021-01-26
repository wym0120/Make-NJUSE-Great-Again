public class MemoryCell {
    public Object read(){
        return storedValue;
    }
    public void write(Object x){
        storedValue=x;
    }
    private Object storedValue;
}
//泛型MemoryCell类
class TestMemoryCell{
    public static void main(String[] args){
        MemoryCell m=new MemoryCell();
        m.write("37");
        String val=(String)m.read();
        System.out.println("Contents are:"+val);
    }
}