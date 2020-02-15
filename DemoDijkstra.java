public class DemoDijkstra {

    public static final int INF = 10000;

    public static void main(String[] args) {
        int[][] map = {
                {0,  1,  2,  INF, INF},
                {1,  0,  3,  4,   INF},
                {2,  3,  0,  5,   1},
                {INF,4,  5,  0,   6},
                {INF,INF,1,  6,   0}
        };

        int start=0;

        int[] dis=dijkstra(map,start);

        for (int i = 0; i < dis.length; i++) {
            System.out.println(start+"->"+i+":"+dis[i]);
        }
    }

    public static int[] dijkstra(int[][] map,int start){
        int N=map.length;
        int[] dis =new int[N];
        int[] Vex_isVisited =new int[N];

        dis[start]=0;
        Vex_isVisited[start]=1;

        for (int count = 1; count < N; count++) {
            int k=start;
            int dmin=INF;
            for (int i = 0; i < N; i++) {
                if(Vex_isVisited[i] == 0 && map[start][i]<dmin){
                    dmin=map[start][i];
                    k=i;
                }
            }

            dis[k]=dmin;
            Vex_isVisited[k]=1;

            for (int i = 0; i < N; i++) {
                if(Vex_isVisited[i]==0 && map[start][k]+map[k][i]<map[start][i]){
                    map[start][i]=map[start][k]+map[k][i];
                }
            }
        }
        return dis;
    }

}