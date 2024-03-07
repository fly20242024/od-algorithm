package dfs;

import java.util.Scanner;

/**
 * fly  2024/3/3
 */
public class OD3503 {
    static int[][] dir = new int[][]{{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] range = s.nextLine().split(" ");
        int x = Integer.parseInt(range[0]);
        int y = Integer.parseInt(range[1]);
        int[][] data = new int[x][y];
        boolean[][] checked = new boolean[x][y];
        for(int i = 0;i<x;i++){
            String[] tar = s.nextLine().split(" ");
            for(int j = 0;j<y;j++){
                data[i][j] = Integer.parseInt(tar[j]);
            }
        }
        int res = 0;
        for(int i = 0;i<x;i++){
            for(int j = 0;j<y;j++){
                if(data[i][j] == 1 && checked[i][j] == false){
                    checked[i][j] = true;
                    bfs(data,checked,i,j);
                    res++;
                }
            }
        }
        System.out.println(res);
    }
    public static void bfs(int[][] data,boolean[][] checked,int a ,int b){
        checked[a][b] = true;
        for(int i = 0;i<dir.length;i++){
            int x = a + dir[i][0];
            int y = b + dir[i][1];
            if(x >= 0 && x < data.length && y>=0 && y < data[x].length && checked[x][y] == false && data[x][y] == 1){
                bfs(data,checked,x,y);
            }
        }
    }
}
