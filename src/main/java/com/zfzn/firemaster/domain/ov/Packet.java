package com.zfzn.firemaster.domain.ov;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import static io.netty.util.CharsetUtil.UTF_8;

/**
 * 封包格式化
 *
 * @author : Tony.fuxudong
 * Created in 7:33 2019/3/14
 */
public class Packet {
    private ByteBuf oldBuf;

    public Packet(ByteBuf oldBuf) {
        this.oldBuf = oldBuf;
    }

    public ByteBuf packet(){
        ByteBuf buf= Unpooled.copiedBuffer("",UTF_8);
        while (oldBuf.readableBytes()>1){
            buf.writeBytes(oldBuf.readBytes(2));
            buf.writeByte(32);
        }
        return buf;
    }
}
