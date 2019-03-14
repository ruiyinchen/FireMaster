package com.zfzn.firemaster.factory.up;

import com.zfzn.firemaster.domain.up.UserInfoFacilityOperationInfo;
import com.zfzn.firemaster.factory.ParseObject;
import com.zfzn.firemaster.util.CommonUtils;
import com.zfzn.firemaster.util.DateUtils;
import io.netty.buffer.ByteBuf;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.DataFormatException;

import static io.netty.util.CharsetUtil.UTF_8;

/**
 * 用户信息传输装置操作信息解析
 *
 * @author : Tony.fuxudong
 * Created in 14:40 2019/3/1
 */
public class UserInfoFacilityOperationInfoParse implements ParseObject {
    @Override
    public List<Object> analyze(ByteBuf buf, int objNum) {
        List<Object> list = new LinkedList<>();
        for (int i = 0; i < objNum; i++) {
            // 操作标志
            byte[] operationalSign = CommonUtils.intTo8BinArray(buf.readUnsignedByte());

            // 操作员编号
            int operatorNo = buf.readUnsignedByte();
            // 状态发生时间
            Date triggerTime = DateUtils.bufToDate(buf);

            UserInfoFacilityOperationInfo infoObj = new UserInfoFacilityOperationInfo(operationalSign, operatorNo, triggerTime);
            list.add(infoObj);
        }
        return list;
    }
}
