public class DijkstraAdjacencyMatrix {

    public static final int M = 10000;

    public static void main(String[] args) {
        int[][] map = {
                {0, 1, 2, M, M},
                {1, 0, 3, 4, M},
                {2, 3, 0, 5, 1},
                {M, 4, 5, 0, 6},
                {M, M, 1, 6, 0}
        };

        int start = 0;

        dijkstra(map, start);
    }

    public static void dijkstra(int[][] map, int start) {
        int N = map.length;
        int[] dis = new int[N];
        int[] Vex_isVisited = new int[N];
        String[] path = new String[N];
        for (int i = 0; i < N; i++) {
            path[i] = start + "-->" + i;
        }

        dis[start] = 0;
        Vex_isVisited[start] = 1;

        for (int count = 1; count < N; count++) {
            int k = start;
            int dmin = M;
            for (int i = 0; i < N; i++) {
                if (Vex_isVisited[i] == 0 && map[start][i] < dmin) {
                    dmin = map[start][i];
                    k = i;
                }
            }

            dis[k] = dmin;
            Vex_isVisited[k] = 1;

            for (int i = 0; i < N; i++) {
                if (Vex_isVisited[i] == 0 && map[start][k] + map[k][i] < map[start][i]) {
                    map[start][i] = map[start][k] + map[k][i];
                    path[i] = path[k] + "->" + i;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.println("从" + start + "->" + i + ":最短长度为" + dis[i] + "，路径：" + path[i]);
        }
    }

}
