package com.zfzn.firemaster.domain.bo;

import com.zfzn.firemaster.domain.en.PackOriginal;

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
        return packInfo.getMessage();
    }
}
