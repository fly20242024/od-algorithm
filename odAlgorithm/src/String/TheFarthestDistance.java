package String;

import java.util.Scanner;

/**
 *
 * 描述：
 * 某探险队负责对地下洞穴进行探险。探险队成员在进行探险任务时，随身携带的记录器会不定期地记录自身的坐标，但在记录的间隙中也会记录其他数据。探索工作结束后,探险队需要获取到某成员在探险过程中相对于探险队总部的最远的足迹位置。
 *
 *                 1. 仪器记录坐标时,坐标的数据格式为(x,y)，如(1,2), (100,200)，其中0 < x < 1000， 0 < y < 1000。同时存在非法坐标，如(01,1)，(1,01)，(0,100)属于非法坐标。
 *
 *                 2. 设定探险队总部的坐标为(0,0)，某位置相对总部的距离为: x*x+y*y。
 *
 *                 3. 若两个座标的相对总部的距离相同，则第一次到达的坐标为最远的足迹。
 *
 *                 4. 若记录仪中的坐标都不合法，输出总部坐标(0,0)。
 *
 *                 备注：不需要考虑双层括号嵌套的情况，比如sfsdfsd((1,2))。
 *
 * 输入：
 * 字符串，表示记录仪中的数据。
 *
 *
 * 		如: ferga13fdsf3(100,-200)f2r3rfasf(-300,400)
 *
 * 输出：
 * 字符串，表示最远足迹到达的坐标。
 *
 *
 * 		如： (300,400)
 *
 *
 * fly  2024/2/16
 */
public class TheFarthestDistance {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        char[] dis = s.nextLine().toCharArray();
        StringBuilder sb = new StringBuilder();
        boolean begin = false;
        int maxDis = 0;
        int count = 0;
        int[] x = new int[2];
        int[] y = new int[2];
        for(int i = 0;i<dis.length;i++){
            if(begin){
                if(dis[i] == ')'){
                    if (count == 1) {
                        begin = false;
                        if(check(sb)){
                            y[1] = Integer.parseInt(sb.toString());
                            int mDis = x[1] * x[1] + y[1] * y[1];
                            if(mDis > maxDis){
                                maxDis = mDis;
                                x[0] = x[1];
                                y[0] = y[1];
                            }
                        }
                    }
                    sb.delete(0,sb.length());
                }else if(dis[i] == ','){
                    count = 1;
                    if(!check(sb)){
                        begin = false;
                    }else {
                        x[1] = Integer.parseInt(sb.toString());
                    }
                    sb.delete(0,sb.length());
                }else {
                    sb.append(dis[i]);
                }
            }else if(dis[i] == '('){
                count = 0;
                begin = true;
            }
        }
        System.out.println("(" + x[0] + "," + y[0] + ")");
    }

    public static boolean check(StringBuilder sb){
        if(sb.length() == 0){
            return false;
        }else if(!Character.isDigit(sb.charAt(0))){
            return false;
        }else if(sb.charAt(0) == '0'){
            return false;
        }else {
            return true;
        }
    }
}
