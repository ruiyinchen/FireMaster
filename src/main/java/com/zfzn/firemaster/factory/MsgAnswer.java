package com.zfzn.firemaster.factory;

import com.zfzn.firemaster.util.DateUtils;
import io.netty.buffer.ByteBuf;

import java.util.Date;

/**
 * 消息回答
 *
 * @author : Tony.fuxudong
 * Created in 16:03 2019/3/4
 */
public class MsgAnswer {
    private ByteBuf byteBuf;

    public MsgAnswer(ByteBuf byteBuf) {
        this.byteBuf = byteBuf.copy(0, 24);
    }

    /**
     * 确认回答
     */
    public ByteBuf define() {
        ByteBuf res = answer(byteBuf);
        // 应用数据单元长度、确认命令
        res.writeBytes(new byte[]{0, 0, 3});
        sum(res);
        cutoff(res);
        return res;
    }

    /**
     * 否认回答
     */
    public ByteBuf negative() {
        ByteBuf res = answer(byteBuf);
        res.writeBytes(new byte[]{0, 0, 6});
        sum(res);
        cutoff(res);
        return res;
    }

    /**
     * 回答
     *
     * @param byteBuf
     * @return
     */
    private ByteBuf answer(ByteBuf byteBuf) {
        ByteBuf res = byteBuf.copy(0, 6);
        res.writeBytes(DateUtils.dateToBuf(new Date()));
        ByteBuf addr1 = byteBuf.copy(12, 6);
        ByteBuf addr2 = byteBuf.copy(18, 6);
        return res.writeBytes(addr2).writeBytes(addr1);
    }

    /**
     * 校验和
     *
     * @param byteBuf
     */
    private void sum(ByteBuf byteBuf) {
        int len = byteBuf.readableBytes();
        int sum = countSum(byteBuf.copy(2, len - 2));
        sum = sum % 256;
        byteBuf.writeByte(sum);
    }

    /**
     * 计算校验和
     *
     * @param buf
     * @return
     */
    private int countSum(ByteBuf buf) {
        int sum = 0;
        while (buf.readableBytes() >0) {
            sum += buf.readUnsignedByte();
        }
        return sum;
    }

    /**
     * 结束标记
     *
     * @param byteBuf
     */
    private void cutoff(ByteBuf byteBuf) {
        byteBuf.writeBytes(new byte[]{35, 35});
    }
}
