package app.time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeDiff {
    public static void main(String args[]) throws ParseException {
        String reqDateStr = "201702011535";
        //현재시간 Date
        Date curDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYYMMddHHmm");
        //요청시간을 Date로 parsing 후 time가져오기
        Date reqDate = dateFormat.parse(reqDateStr);
        long reqDateTime = reqDate.getTime();
        //현재시간을 요청시간의 형태로 format 후 time 가져오기
        curDate = dateFormat.parse(dateFormat.format(curDate));
        long curDateTime = curDate.getTime();
        //분으로 표현
        long minute = (curDateTime - reqDateTime) / 60000;
        System.out.println("요청시간 : " + reqDate);
        System.out.println("현재시간 : " + curDate);
        System.out.println(minute+"분 차이");
    }
}