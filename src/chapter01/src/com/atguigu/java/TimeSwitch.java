package src.com.atguigu.java;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class TimeSwitch {
    public static void main(String[] args) {
        String time1 = secondToTime(2);
        String time2 = dateToTime("2017/10/25 16:42:46", "yyyy/MM/dd HH:mm:ss");
        System.out.println(time1);
        System.out.println(time2);
    }

    /**
     * 将秒数转换为日时分秒，
     * @param second
     * @return
     */
    public static String secondToTime(int second){
        long days = second / 86400;            //转换天数
        long years = days / 365;               //转换年数
        days = days % 365;                     //剩余天数
        second = second % 86400;               //剩余秒数
        long hours = second / 3600;            //转换小时
        second = second % 3600;                //剩余秒数
        long minutes = second /60;             //转换分钟
        second = second % 60;                  //剩余秒数

        /*
        * 要求：
        * 1、XX years, XX days, XX hours, XX minutes and XX seconds
        * 2、如果是复数，要加s，不是复数，不加s;
        * 3、符合英语表达规范，在适当位置加and
        * */
        ArrayList<String> strings = new ArrayList<>();
        if(years > 1){
            strings.add(years + " years, ");
        }
        if(years == 1){
            strings.add(years + " year, ");
        }
        if(days > 1){
            strings.add(days + " days, ");
        }
        if(days == 1){
            strings.add(days + " day, ");
        }
        if(hours > 1){
            strings.add(hours + " hours, ");
        }
        if(hours == 1){
            strings.add(hours + " hour, ");
        }
        if(minutes > 1){
            strings.add(minutes + " minutes, ");
        }
        if(minutes == 1){
            strings.add(minutes + " minute, ");
        }
        if(second > 1){
            strings.add(second + " seconds, ");
        }
        if(second == 1){
            strings.add(second + " second, ");
        }

        String s ="";
        for (String string : strings) {
            s = s + string;
        }

        //去掉字符串末尾的逗号
        s = s.substring(0,s.lastIndexOf(","));

        //取出最后一个逗号，替换成 and
        StringBuffer stringBuffer = new StringBuffer(s);

        if(stringBuffer.lastIndexOf(",") != -1){
            stringBuffer.replace(stringBuffer.lastIndexOf(","),stringBuffer.lastIndexOf(",")+2," and ");

        }
        String s1 = stringBuffer.toString();
        return s1;
    }

    /**
     * 将日期转换为日时分秒
     * @param date
     * @return
     */
    public static String dateToTime(String date, String dateStyle){
        SimpleDateFormat format = new SimpleDateFormat(dateStyle);
        try {
            Date oldDate = format.parse(date);
            System.out.println("oldDate" + oldDate);
            long time = oldDate.getTime();                    //输入日期转换为毫秒数
            long nowTime = System.currentTimeMillis();        //当前时间毫秒数
            long second = nowTime - time;                    //二者相差多少毫秒
            second = second / 1000;                            //毫秒转换为妙
            long days = second / 86400;
            second = second % 86400;
            long hours = second / 3600;
            second = second % 3600;
            long minutes = second /60;
            second = second % 60;
            if(days>0){
                return days + "天" + hours + "小时" + minutes + "分" + second + "秒";
            }else{
                return hours + "小时" + minutes + "分" + second + "秒";
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}