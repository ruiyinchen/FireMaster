package com.zfzn.firemaster.web;

import com.zfzn.firemaster.domain.bo.PackInfo;
import com.zfzn.firemaster.server.FireControlChannel;
import com.zfzn.firemaster.service.impl.MessageSender;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

import static io.netty.util.CharsetUtil.UTF_8;

/**
 * 测试服务接口
 *
 * @author : Tony.fuxudong
 * Created in 2019-02-05 16:24
 */
@Api(tags = {"测试服务接口"})
@RestController
@RequestMapping(value= "/test")
public class TestController {
    private final RedisTemplate<String, Serializable> redisTemplate;
    private final MessageSender messageSender;
    private final FireControlChannel controlChannel;

    @Autowired
    public TestController(RedisTemplate<String, Serializable> redisTemplate, MessageSender messageSender, FireControlChannel controlChannel) {
        this.redisTemplate = redisTemplate;
        this.messageSender = messageSender;
        this.controlChannel = controlChannel;
    }

    @ApiOperation(value = "简单 GET 测试方法")
    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public Object testGet(@RequestParam("param")String param){
        return "Hello "+param;
    }

    @ApiOperation(value = "Redis 存储测试方法")
    @RequestMapping(value = "/redisSimplePush",method = RequestMethod.PUT)
    public Object redisSimplePush(@RequestParam("key")String key,@RequestParam("value")String value){
        ByteBuf byteBuf= Unpooled.copiedBuffer(value,UTF_8);
        redisTemplate.opsForValue().set(key,byteBuf.toString());
        return "OK";
    }
    @ApiOperation(value = "Redis 获取测试方法")
    @RequestMapping(value = "/redisSimplePull",method = RequestMethod.GET)
    public Object redisSimplePush(@RequestParam("key")String key){
        return redisTemplate.opsForValue().get(key);
    }

    @ApiOperation(value = "redis 消息队列测试方法")
    @RequestMapping(value = "/sendChat",method = RequestMethod.PUT)
    public Object sendChat(@RequestBody PackInfo packInfo){
        messageSender.sendMessage(packInfo,null);
        return "OK";
    }

    @ApiOperation(value = "服务器消息下发")
    @RequestMapping(value = "/send",method = RequestMethod.POST)
    public Object send(@RequestParam String msg){
        controlChannel.sendTo(msg);
        return "OK";
    }
}
