package com.zfzn.firemaster.util;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.buffer.UnpooledByteBufAllocator;

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
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.set(Calendar.SECOND, byteBuf.readUnsignedByte());
        calendar.set(Calendar.MINUTE, byteBuf.readUnsignedByte());
        calendar.set(Calendar.HOUR_OF_DAY, byteBuf.readUnsignedByte());
        calendar.set(Calendar.DAY_OF_MONTH, byteBuf.readUnsignedByte());
        calendar.set(Calendar.MONTH, byteBuf.readUnsignedByte() - 1);
        calendar.set(Calendar.YEAR, 2000+byteBuf.readUnsignedByte());
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

        ByteBuf byteBuf= UnpooledByteBufAllocator.DEFAULT.buffer() ;
        for (int n:dateInt){
            byteBuf.writeByte(n);
        }
        return byteBuf;
    }
}
