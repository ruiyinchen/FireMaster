package com.zfzn.firemaster.web;

import com.zfzn.firemaster.dao.StatusRecordSystemDao;
import com.zfzn.firemaster.domain.ov.PageRequest;
import com.zfzn.firemaster.domain.ov.Result;
import com.zfzn.firemaster.domain.ov.ResultEnum;
import com.zfzn.firemaster.service.SystemInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 系统信息 Controller
 *
 * @author : Tony.fuxudong
 * Created in 7:52 2019/3/18
 */
@Api(tags = {"系统信息：系统信息相关接口"})
@RequestMapping(value = "/sys")
@RestController
public class SystemInfoController {
    private final SystemInfoService systemInfoService;

    @Autowired
    public SystemInfoController(SystemInfoService systemInfoService) {
        this.systemInfoService = systemInfoService;
    }

    @ApiOperation(value = "系统状态查询")
    @PostMapping(value = "/status")
    public Result queryStatus(@RequestBody PageRequest<Integer> request){
        if (request.getPageNum() < 0) {
            request.setPageNum(1);
        }
        if (request.getPageSize() < 0) {
            request.setPageSize(1);
        }
        if (request.getParameter() <= 0) {
            return Result.newInstance(ResultEnum.PARAMETER_ERROR, "无效的系统地址!");
        }
        return systemInfoService.queryStatus(request);
    }
}
