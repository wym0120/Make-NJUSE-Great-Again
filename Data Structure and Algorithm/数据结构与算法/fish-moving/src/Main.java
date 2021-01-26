public class Main {
    public void main(String[] args){
        int[][] map1;
        herring h1=new herring(10, 6, 6, 0);
        h1.setPosition(, );
        map m1=new map(map1, 4);

        for () {//对每条鱼都刷新一遍
            if (m1.getMonth()!=7 || m1.getMonth()!=8 || m1.getMonth()!=9){
                m1.random_moving(h1);
            }
            else {
                m1.spawn(h1);
            }
        }

    }
}
