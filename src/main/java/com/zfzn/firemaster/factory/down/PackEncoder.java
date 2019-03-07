package com.zfzn.firemaster.factory.down;

import com.zfzn.firemaster.cache.FireDataCache;
import com.zfzn.firemaster.cache.GlobalValue;
import com.zfzn.firemaster.util.CommonUtils;
import com.zfzn.firemaster.util.DateUtils;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

import static io.netty.util.CharsetUtil.UTF_8;

/**
 * 指令下发父类，包含公共代码
 *
 * @author : Tony.fuxudong
 * Created in 10:23 2019/3/7
 */
@Component
public class PackEncoder {
    private final FireDataCache fireDataCache;

    public PackEncoder(FireDataCache fireDataCache) {
        this.fireDataCache = fireDataCache;
    }

    /**
     * 开始包装
     *
     * @param tar
     * @return
     */
    public ByteBuf builder(String tar) {
        List<GlobalValue> globalList = fireDataCache.readTarget(tar);
        GlobalValue globalValue = globalList.get(0);
        ByteBuf byteBuf = Unpooled.copiedBuffer(new byte[]{52, 48, 52, 48});
        byteBuf.writeBytes(CommonUtils.intTo4Hex(globalValue.getMainVersionNo()).getBytes());
        byteBuf.writeBytes(CommonUtils.intTo4Hex(globalValue.getMainVersionNo()).getBytes());
        byteBuf.writeBytes(DateUtils.dateToBuf(new Date()));
        byteBuf.writeBytes(globalValue.getMonitorCenterAddr().getBytes(UTF_8));
        byteBuf.writeBytes(globalValue.getTransmissionDeviceAddr().getBytes(UTF_8));
        return byteBuf;
    }

    /**
     * 结束包装
     *
     * @param byteBuf
     * @return
     */
    public ByteBuf build(ByteBuf byteBuf) {
        countSum(byteBuf);
        return byteBuf.writeBytes(new byte[]{50, 51, 50, 51});
    }

    /**
     * 计算校验和
     *
     * @param byteBuf
     */
    private void countSum(ByteBuf byteBuf) {
        ByteBuf buf = byteBuf.copy(4, byteBuf.readableBytes() - 4);
        int sum = 0;
        while (buf.readableBytes() >= 2) {
            sum += Integer.parseInt(byteBuf.readBytes(2).toString(UTF_8), 16);
        }
        sum = sum % 256;
        String sumHex = Integer.toString(sum, 16);
        /*char[] arr = sumHex.toCharArray();
        for (char anArr : arr) {
            int n = (int) anArr;
            byteBuf.writeByte(n);
        }*/
        byteBuf.writeBytes(sumHex.getBytes());
    }
}
