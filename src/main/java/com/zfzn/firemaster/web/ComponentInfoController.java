package com.zfzn.firemaster.web;

import com.zfzn.firemaster.domain.ov.PageRequest;
import com.zfzn.firemaster.domain.ov.Result;
import com.zfzn.firemaster.domain.ov.ResultEnum;
import com.zfzn.firemaster.service.ComponentInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 部件信息 控制器
 *
 * @author : Tony.fuxudong
 * Created in 7:21 2019/3/18
 */
@Api(tags = {"部件信息：设备状态及模拟量值"})
@RequestMapping(value = "/component")
@RestController
public class ComponentInfoController {
    private final ComponentInfoService componentInfoService;

    @Autowired
    public ComponentInfoController(ComponentInfoService componentInfoService) {
        this.componentInfoService = componentInfoService;
    }

    @ApiOperation(value = "查询部件(设备)状态")
    @PostMapping(value = "/status")
    public Result queryStatus(@RequestBody PageRequest<Integer> request) {
        if (request.getPageNum() < 0) {
            request.setPageNum(1);
        }
        if (request.getPageSize() < 0) {
            request.setPageSize(1);
        }
        if (request.getParameter() <= 0) {
            return Result.newInstance(ResultEnum.PARAMETER_ERROR, "无效的设备地址码!");
        }
        return componentInfoService.queryStatus(request);
    }

    @ApiOperation(value = "查询部件(设备)模拟量值")
    @GetMapping(value = "/value")
    public Result queryValue(@RequestParam("addrCode") Integer addrCode) {
        if (addrCode <= 0) {
            return Result.newInstance(ResultEnum.PARAMETER_ERROR, "无效的设备地址码!");
        }
        return componentInfoService.queryValue(addrCode);
    }
}
