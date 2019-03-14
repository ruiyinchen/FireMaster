package com.zfzn.firemaster.factory;

import com.zfzn.firemaster.domain.ov.Packet;
import com.zfzn.firemaster.util.DateUtils;
import io.netty.buffer.ByteBuf;

import java.util.Date;

import static io.netty.util.CharsetUtil.UTF_8;

/**
 * 消息回答
 *
 * @author : Tony.fuxudong
 * Created in 16:03 2019/3/4
 */
public class MsgAnswer {
    private ByteBuf byteBuf;

    public MsgAnswer(ByteBuf byteBuf) {
        this.byteBuf = byteBuf.copy(0, 48);
    }

    /**
     * 确认回答
     */
    public ByteBuf define() {
        ByteBuf res = answer(byteBuf);
        res.writeBytes(new byte[]{48, 48, 48, 48, 48, 51});
        sum(res);
        cutoff(res);
        return new Packet(res).packet();
    }

    /**
     * 否认回答
     */
    public ByteBuf negative() {
        ByteBuf res = answer(byteBuf);
        res.writeBytes(new byte[]{48, 48, 48, 48, 48, 54});
        sum(res);
        cutoff(res);
        return new Packet(res).packet();
    }

    /**
     * 回答
     *
     * @param byteBuf
     * @return
     */
    private ByteBuf answer(ByteBuf byteBuf) {
        ByteBuf res = byteBuf.copy(0, 12);
        res.writeBytes(DateUtils.dateToBuf(new Date()));
        ByteBuf addr1 = byteBuf.copy(24, 12);
        ByteBuf addr2 = byteBuf.copy(36, 12);
        return res.writeBytes(addr2).writeBytes(addr1);
    }

    /**
     * 校验和
     *
     * @param byteBuf
     */
    private void sum(ByteBuf byteBuf) {
        int len = byteBuf.readableBytes();
        int sum = countSum(byteBuf.copy(4, len - 4));
        sum = sum % 256;
        String sumHex = Integer.toString(sum, 16);
        char[] arr = sumHex.toCharArray();
        for (char anArr : arr) {
            int n = (int) anArr;
            byteBuf.writeByte(n);
        }
    }

    /**
     * 计算校验和
     *
     * @param buf
     * @return
     */
    private int countSum(ByteBuf buf) {
        int sum = 0;
        while (buf.readableBytes() >= 2) {
            sum += Integer.parseInt(buf.readBytes(2).toString(UTF_8), 16);
        }
        return sum;
    }

    /**
     * 结束标记
     *
     * @param byteBuf
     */
    private void cutoff(ByteBuf byteBuf) {
        byteBuf.writeBytes(new byte[]{50, 51, 50, 51});
    }
}
