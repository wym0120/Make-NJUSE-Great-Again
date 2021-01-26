public class herring {
    public int hightemperature;//
    public int lowtemperature;//
    public int spawning_hightemperature;
    public int spawning_lowtemperature;
    private int x;
    private int y;

    public herring(int a,int b,int c,int d){
        this.hightemperature=a;
        this.lowtemperature=b;
        this.spawning_hightemperature=c;
        this.spawning_lowtemperature=d;
    }

    public void setPosition(int x,int y){
        this.x=x;
        this.y=y;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

}
