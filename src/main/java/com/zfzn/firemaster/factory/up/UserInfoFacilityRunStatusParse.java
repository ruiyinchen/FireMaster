package com.zfzn.firemaster.factory.up;

import com.zfzn.firemaster.domain.up.UserInfoFacilityRunStatus;
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
 * 用户信息传输装置运行状态解析
 *
 * @author : Tony.fuxudong
 * Created in 11:18 2019/3/1
 */
public class UserInfoFacilityRunStatusParse implements ParseObject {
    @Override
    public List<Object> analyze(ByteBuf buf, int objNum) {
        List<Object> list=new LinkedList<>();
        for(int i=0;i<objNum;i++){
            // 系统状态
            String statusStr = buf.readBytes(2).toString(UTF_8);
            byte[] status=null;
            try {
                status= CommonUtils.hexToBin(statusStr);
            } catch (DataFormatException e) {
                e.printStackTrace();
            }
            // 状态发生时间
            Date triggerTime= DateUtils.bufToDate(buf);

            UserInfoFacilityRunStatus infoObj=new UserInfoFacilityRunStatus(status,triggerTime);
            list.add(infoObj);
        }
        return list;
    }
}
