package com.zfzn.firemaster.factory.up;

import com.zfzn.firemaster.domain.up.UserInfoFacilitySoftwareVersion;
import com.zfzn.firemaster.factory.ParseObject;
import com.zfzn.firemaster.util.DateUtils;
import io.netty.buffer.ByteBuf;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import static io.netty.util.CharsetUtil.UTF_8;

/**
 * 用户信息传输装置软件版本解析
 *
 * @author : Tony.fuxudong
 * Created in 14:58 2019/3/1
 */
public class UserInfoFacilitySoftwareVersionParse implements ParseObject {
    @Override
    public List<Object> analyze(ByteBuf buf, int objNum) {
        List<Object> list = new LinkedList<>();
        for (int i = 0; i < objNum; i++) {
            // 主版本号
            int majorVersionNo = Integer.parseInt(buf.readBytes(2).toString(UTF_8), 16);
            // 次版本号
            int minorVersionNo = Integer.parseInt(buf.readBytes(2).toString(UTF_8), 16);

            // 状态发生时间
            Date triggerTime = DateUtils.bufToDate(buf);

            UserInfoFacilitySoftwareVersion infoObj = new UserInfoFacilitySoftwareVersion(majorVersionNo, minorVersionNo, triggerTime);
            list.add(infoObj);
        }
        return list;
    }
}
