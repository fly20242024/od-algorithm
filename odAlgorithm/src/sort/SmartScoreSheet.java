package sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 智能成绩表
 * 第1行输入两个整数，学生人数n和科目数量m。0 < n < 100，0 < m < 10
 *
 * 第2行输入m个科目名称，彼此之间用空格隔开，科目名称只由英文字母构成，单个长度不超过10个字符。
 *
 * 科目的出现顺字和后续输入的学生成绩一一对应。不会出现重复的科目名称。
 *
 * 第3行开始的行，每行包含一个学生的姓名和该生m个科目的成绩空格隔开)，学生不会重名。 学生姓名只由英文字母构成，长度不超过10个字符。
 *
 * 成绩是0~100的整数，依次对应第2行中输入的科目。
 *
 * 第n+2行，输入用作排名的科目名称。 若科目不存在，则按总分进行排序。
 *
 * 3 2
 * yuwen shuxue
 * fangfang 95 90
 * xiaohua 88 95
 * minmin 100 82
 * shuxue
 */
public class SmartScoreSheet {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] number = s.nextLine().split(" ");
        int stuCount = Integer.parseInt(number[0]);
        int courseCount = Integer.parseInt(number[1]);
        String[] course = s.nextLine().split(" ");
        Student[] students = new Student[stuCount];
        for(int i = 0;i<stuCount;i++){
            String[] stu = s.nextLine().split(" ");
            int[] score = new int[courseCount+1];
            int all = 0;
            for(int j = 1;j<stu.length;j++){
                score[j-1] = Integer.parseInt(stu[j]);
                all += score[j-1];
            }
            score[stu.length-1] = all;
            students[i] = new Student(stu[0],score);
        }
        String target = null;
        if(s.hasNext()){
            target = s.nextLine();
        }
        int result = 0;
        for(int i = 0;i<course.length;i++){
            if(course[i].equals(target)){
                break;
            }
            result++;
        }
        int finalResult = result;
        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if(o1.score[finalResult] == o2.score[finalResult]){
                    return o1.name.compareTo(o2.name);
                }else {
                    return o2.score[finalResult] - o1.score[finalResult];
                }
            }
        });
        for(int i = 0;i<students.length;i++){
            System.out.print(students[i].name);
            if(i != students.length -1){
                System.out.print(" ");
            }
        }
    }




}
class Student{
    String name;
    int[] score;

    public Student(String name,int[] score){
        this.name = name;
        this.score = score;
    }
}
