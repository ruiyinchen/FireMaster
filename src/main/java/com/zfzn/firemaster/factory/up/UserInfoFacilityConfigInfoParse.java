package com.zfzn.firemaster.factory.up;

import com.zfzn.firemaster.domain.up.UserInfoFacilityConfigInfo;
import com.zfzn.firemaster.factory.ParseObject;
import com.zfzn.firemaster.util.DateUtils;
import io.netty.buffer.ByteBuf;

import java.nio.charset.Charset;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import static io.netty.util.CharsetUtil.UTF_8;

/**
 * 用户信息传输装置配置信息解析
 *
 * @author : Tony.fuxudong
 * Created in 15:03 2019/3/1
 */
public class UserInfoFacilityConfigInfoParse implements ParseObject {
    @Override
    public List<Object> analyze(ByteBuf buf, int objNum) {
        List<Object> list = new LinkedList<>();
        for (int i = 0; i < objNum; i++) {
            // 系统说明长度
            int legendLength = Integer.parseInt(buf.readBytes(2).toString(UTF_8), 16);
            // 系统说明
            String legend = buf.readBytes(2 * legendLength).toString(Charset.forName("GB18030"));

            // 状态发生时间
            Date triggerTime = DateUtils.bufToDate(buf);

            UserInfoFacilityConfigInfo infoObj = new UserInfoFacilityConfigInfo(legendLength, legend, triggerTime);
            list.add(infoObj);
        }
        return list;
    }
}
