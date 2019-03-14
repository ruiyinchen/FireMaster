package com.zfzn.firemaster.domain.bo;

import com.zfzn.firemaster.domain.od.PackOriginal;

import java.util.Arrays;

/**
 * PackOriginal 包装类
 *
 * @author : Tony.fuxudong
 * Created in 2019-02-11 10:39
 */
public class PackOriginalInfo extends PackOriginal {
    private PackInfo packInfo;

    public PackOriginalInfo(PackInfo packInfo) {
        this.packInfo = packInfo;
    }

    @Override
    public String getHost() {
        return packInfo.getHost();
    }

    @Override
    public String getContent() {
        return Arrays.toString(packInfo.getMessage());
    }
}
