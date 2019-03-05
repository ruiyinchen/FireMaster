package com.zfzn.firemaster.handler;

import com.zfzn.firemaster.domain.AppDataUnit;
import com.zfzn.firemaster.domain.TcpDataPack;
import com.zfzn.firemaster.factory.InfoBodyAnalysis;
import com.zfzn.firemaster.factory.ParseObject;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static io.netty.util.CharsetUtil.UTF_8;

/**
 * 消防数据数据解析
 *
 * @author : Tony.fuxudong
 * Created in 11:15 2019/2/28
 */
@ChannelHandler.Sharable
public class DataAnalysisHandler extends ChannelInboundHandlerAdapter {
    private final Logger _logger = LoggerFactory.getLogger(DataAnalysisHandler.class);

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        TcpDataPack dataPack = (TcpDataPack) msg;
        ByteBuf dataSegment = dataPack.getData();

        AppDataUnit dataUnit = new AppDataUnit();

        // 应用单元数据类型
        int dataType = Integer.parseInt(dataSegment.readBytes(2).toString(UTF_8), 16);
        dataUnit.setDataType(dataType);

        // 信息对象数目
        int objNum = Integer.parseInt(dataSegment.readBytes(2).toString(UTF_8), 16);
        dataUnit.setCount(objNum);

        // 应用数据单元处理
        ParseObject parseObj = InfoBodyAnalysis.createAnalysisBody(dataType);
        List<Object> list = parseObj.analyze(dataSegment, dataUnit.getCount());
        dataUnit.setList(list);

        ReferenceCountUtil.release(msg);
        // TODO 执行存储或发送命令
    }
}
