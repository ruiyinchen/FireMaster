package com.zfzn.firemaster.util;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.util.Calendar;
import java.util.Date;

import static io.netty.util.CharsetUtil.UTF_8;


/**
 * 时间处理工具类
 *
 * @author : Tony.fuxudong
 * Created in 2019-02-09 08:01
 */
public class DateUtils {
    /**
     * 从 ByteBuf 中提取出时间
     *
     * @param byteBuf byteBuf
     * @return
     */
    public static Date bufToDate(ByteBuf byteBuf) {
        // 此处不再使用 valueOf 方法，直接使用 parseInt 以节省包装类的开销
        int second = Integer.parseInt(byteBuf.readBytes(2).toString(UTF_8), 16);
        int minute = Integer.parseInt(byteBuf.readBytes(2).toString(UTF_8), 16);
        int hour = Integer.parseInt(byteBuf.readBytes(2).toString(UTF_8), 16);
        int day = Integer.parseInt(byteBuf.readBytes(2).toString(UTF_8), 16);
        int month = Integer.parseInt(byteBuf.readBytes(2).toString(UTF_8), 16)-1;
        int year = 2000 + Integer.parseInt(byteBuf.readBytes(2).toString(UTF_8), 16);
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, second);
        return calendar.getTime();
    }

    /**
     * 将时间转化为 ByteBuf
     *
     * @param date
     * @return
     */
    public static ByteBuf dateToBuf(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        int[] dateInt = new int[]{
                calendar.get(Calendar.SECOND),
                calendar.get(Calendar.MINUTE),
                calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.DAY_OF_MONTH),
                calendar.get(Calendar.MONTH)+1,
                calendar.get(Calendar.YEAR) - 2000
        };

        ByteBuf byteBuf= Unpooled.copiedBuffer("",UTF_8);
        for (int n:dateInt){
            if(n<16){
                byteBuf.writeByte(48);
            }
            char[] arr = Integer.toHexString(n).toCharArray();
            for (char anArr : arr) {
                int m = (int) anArr;
                byteBuf.writeByte(m);
            }
        }
        return byteBuf;
    }
}
