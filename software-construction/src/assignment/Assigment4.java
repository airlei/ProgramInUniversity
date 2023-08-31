package assignment;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Assigment4 {
    static int NUM=50,RANGE=100;
    static Set<Quests> set = new HashSet<Quests>();
    static Set<String> st = new HashSet<String>();

    public static void main(String[] args) {
        showTitle();
        geneQuests();
        showQuests();
        showAnswer();
        saveQuests();
    }

    private static void showTitle() {
        System.out.println("----------------------------------------------------------------");
        System.out.println(String.format("----------- 程序输出%d道%d以内的加减法运算的口算题 ------------",NUM,RANGE));
        System.out.println("----------------------------------------------------------------");
    }

    private static void saveQuests() {

        try {
            File file = new File("D:\\quests.txt");
            FileWriter fileWriter = new FileWriter(file);
            int num=1;
            for(Quests quests:set){
                fileWriter.write(quests.getQuests());
                num++;
                if(num>1&&num%5==1){
                    fileWriter.write("\n");
                }else{
                    fileWriter.write(",");
                }
                fileWriter.flush();
            }
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void geneQuests() {
        Random random = new Random(System.nanoTime());
        char op[]={'+','-'};
        int num=1;
        while(num<=NUM){
            int x=random.nextInt(RANGE);
            int y= random.nextInt(RANGE);
            int idx= random.nextInt(2);
            int z=operate(x,y,op[idx]);
            if(ck(x,op[idx],y,z)){
                continue;
            }
            st.add(""+x+op[idx]+y);
            Quests quests = new Quests(x, y, op[idx],z);
            set.add(quests);
            num++;
        }
    }
    private static int operate(int x, int y, char op) {
        if(op=='+'){
            return x+y;
        }else{
            return x-y;
        }
    }

    private static boolean ck(int x,char op,int y,int z) {
        return st.contains(""+x+op+y)||z<0||z>RANGE;
    }

    private static void showQuests() {
        System.out.println("-------------------问题--------------------");
        int num=1;
        for(Quests quests:set){
            System.out.print(quests.getQuests()+"\t");
            num++;
            if(num>1&&num%5==1){
                System.out.println("");
            }
        }
    }

    private static void showAnswer() {
        System.out.println("-------------------答案------------------");
        int num=1;
        for(Quests quests:set){
            System.out.print(quests.getAnswer()+"\t");
            num++;
            if(num>1&&num%5==1){
                System.out.println("");
            }
        }
    }

    private static class Quests{
        int x,y,z;
        char op;

        public Quests(int x, int y, char op,int z) {
            this.x = x;
            this.y = y;
            this.op = op;
            this.z=z;
        }

        public String getQuests(){
            return String.format("%d"+op+"%d",x,y);
        }
        public int getAnswer(){
            return z;
        }

    }


}
