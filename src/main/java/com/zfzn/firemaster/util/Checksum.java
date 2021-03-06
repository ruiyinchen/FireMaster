package com.zfzn.firemaster.util;

import io.netty.buffer.ByteBuf;

import static io.netty.util.CharsetUtil.UTF_8;

/**
 * 数据校验和
 *
 * @author : Tony.fuxudong
 * Created in 2019-02-15 08:11
 */
public class Checksum {
    private ByteBuf byteBuf;
    private int checksum = 0;

    public Checksum(ByteBuf byteBuf) {
        this.byteBuf = byteBuf;
    }

    /**
     * 计算校验和
     */
    private void capture() {
        int length = byteBuf.readableBytes() - 4;
        this.byteBuf = byteBuf.copy(2, length);
    }

    /**
     * 计算校验和
     *
     * @return
     */

    private int calc() {
        int sum = 0;
        while (byteBuf.readableBytes() > 1) {
            sum += byteBuf.readUnsignedByte();
        }
        this.checksum=byteBuf.readUnsignedByte();
        return sum;
    }

    /**
     * 获取计算结果
     *
     * @return
     */
    public int sum() {
        capture();
        return calc();
    }

    /**
     * 判断校验是否通过
     *
     * @return
     */
    public boolean passing() {
        // 此位置不可使用下面被注释的代码，原因在于C++中使用了无符号byte类型
        int checksum0 = sum() % 256;
        /*byte checksum0 = (byte) sum();
        if (checksum0 < 0) {
            checksum0 += 128;
        }*/
        return checksum == checksum0;
    }

}
