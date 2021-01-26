public class map {
    //由海温数据地图导入
    private int[][] map;
    private int month;
    public map(int[][] a,int month){
        this.map=a;
        this.month=month;
    }

    public int getMonth() {
        return this.month;
    }

    public void random_moving(herring fish){
        int best=(fish.lowtemperature+fish.hightemperature)/2;
        int target_x=fish.getX();
        int target_y=fish.getY();
        //如果month不是非产卵期
        int x=fish.getX();
        int y=fish.getY();
        for (int i = y-1;i<=y+1; i++) {
            for (int j = x-1;j<=x+1; j++) {
                if (map[i][j]!=-2){
                    //说明不是大陆和结冰区
                    if (map[i][j]>=fish.lowtemperature && map[i][j]<=fish.hightemperature){
                        //说明在适宜温度区内
                        //接下来比较谁更接近最适温度
                        if(cmp(map[i][j],map[target_x][target_y],best)){
                            target_x=i;
                            target_y=j;
                        }
                    }
                }
            }
        }
    }

    public void spawn(herring fish){
        int best=(fish.spawning_lowtemperature+fish.spawning_hightemperature)/2;
        int target_x=fish.getX();
        int target_y=fish.getY();
        //如果month是产卵期
        int x=fish.getX();
        int y=fish.getY();
        for (int i = y-1;i<=y+1; i++) {
            for (int j = x-1;j<=x+1; j++) {
                if (map[i][j]!=-2){
                    //说明不是大陆和结冰区
                    if (map[i][j]>=fish.spawning_lowtemperature && map[i][j]<=fish.spawning_hightemperature){
                        //说明在适宜温度区内
                        //接下来比较谁更接近最适温度
                        if(cmp(map[i][j],map[target_x][target_y],best)){
                            target_x=i;
                            target_y=j;
                        }
                    }
                }
            }
        }

    }

    public boolean cmp(int x,int y,int best){
        //如果x更接近则返回true
        //如果y更接近则返回false
        if (x<best && y<best){
            if (best-x>best-y){
                return false;
            }
            if (best-y>=best-x){
                return true;
            }
        }
        else if (x>=best && y>=best){
            if (x-best>y-best){
                return false;
            }
            if (y-best>=x-best){
                return true;
            }
        }
        else if (x<best && y>=best){
            if (best-x>y-best){
                return false;
            }
            if (y-best>=best-x){
                return true;
            }
        }
        else if (x>=best && y<best){
            if (x-best>best-y){
                return false;
            }
            if (best-y>=x-best){
                return true;
            }
        }
        //不会发生的情况
        return true;
    }
}
