import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ex101 {
    public static void main(String[] args) {
    // TODO Auto-generated method stub
    String year = null;//年份
    String month = null;//月份
    String day = null;//日

    //输入年月日

    Scanner scanner1 = new Scanner(System.in);

    System.out.println("请输入年份：");
    year=scanner1.next();
    System.out.println("请输入月份：");
    month=scanner1.next();
    System.out.println("请输入日：");
    day=scanner1.next();

    //检测输入是否响应
    System.out.println( "输入的时间为：" + year + "年" + month + "月" + day + "日");

    //检测输入的内容是否为数字，或为空
    if(!isNumber(year) || !isNumber(month) || !isNumber(day) )
    {
        System.out.println("检测到您的输入不合法，请输入数字！");
    }
    else
    {
        int year_rual=Integer.parseInt(year);
        int month_rual=Integer.parseInt(month);
        int day_rual=Integer.parseInt(day);

        //判断输入的日期是否合法
        if (year_rual >=1900) {


            if (judge(year_rual, month_rual, day_rual)) {
                String weekday = weekByDate(year_rual, month_rual, day_rual);
                System.out.println(year + " 年" + month + " 月" + day + " 日是  " + weekday);
            } else {
                System.out.println("检测到您的输入不合法！！！");
            }
        }else {
            System.out.println("输入数据不合法，请输入1900之后的年份！！！！");
        }
    }
}

    /**
     * 判断输入的年月日是否为数字，或为空
     * @param number  //输入内容
     * @return boolean//返回值为true符合规则，返回值为false不符合规则
     */
    public static boolean isNumber(String number)
    {
        if (number == null || "".equals(number.trim()))
        {
            return false;
        }
        Pattern pattern = Pattern.compile("[0-9]*");

        Matcher isNum = pattern.matcher(number.trim());

        if (isNum.matches())
        {
            return true;
        }
        else
        {
            return false;
        }
    }


    /**
     * 判断输入的年月日是否符合规则
     * @param year  //年份
     * @param month // 月份
     * @param day  //天
     * @return boolean//返回值为true符合规则，返回值为false不符合规则
     */
    public static boolean judge (int year,int month,int day)
    {
    //当输入的数字小于零时，返回false
    if (year <= 0)
    {
           return false;
      }
        if (month <= 0 || month > 12){
          return false;
        }
        if (day<=0 || day > 31){

            return false;
        }
        //年份能被4整除并且不能被100整除，或者能被400整除，则为闰年 
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))
        {
            if (month == 2)
            {
                //闰年的2月  
                if (day > 29)
                {
                    return false;
                }
            }
        }else{
            //不是闰年的2月  
            if (month == 2)
            {
                if (day > 28)
                {
                    return false;
                }
            }
        }
        //1、3、5、7、8、10、12月份为31天  
        int[] m1 = {1,3,5,7,8,10,12};

        for (int i = 0; i < m1.length; i++){
            if (month == m1[i])
            {
                if (day>31)
                {
                    return false;
                }
            }
        }
        //4、6、9、12月份为30天  
        int[] m2 = {4,6,9,11};

        for (int j = 0; j < m2.length; j++)
        {
            if (month == m2[j])
            {
                if (day > 30)
                {
                    return false;
                }
            }
        }

        return true;
    }


    /**
     * 根据年月日返回星期几
     * @param year //年份
     * @param month //月份
     * @param day   //天
     * @return String //返回值直接返回星期几
     */
    public static String weekByDate (int year,int month,int day)
    {
        String str="";
        SimpleDateFormat fmt = new SimpleDateFormat("dd MM yyyy");

        Date d = null;
        try {
            d = fmt.parse(day+" "+month+" "+year);
        }catch (ParseException e){

        e.printStackTrace();
    }

        Calendar cal = Calendar.getInstance();

        cal.setTime(d);

        int weekDay = cal.get(Calendar.DAY_OF_WEEK);

        switch(weekDay) {
            case 1 : str="周日"; break;
            case 2 : str="星期一"; break;
            case 3 : str="星期二"; break;
            case 4 : str="星期三"; break;
            case 5 : str="星期四"; break;
            case 6 : str="星期五"; break;
            case 7 : str="星期六"; break;
            default: break;
        }

        return str;
    }

}