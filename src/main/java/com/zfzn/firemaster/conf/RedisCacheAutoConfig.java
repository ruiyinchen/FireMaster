package com.zfzn.firemaster.conf;

import com.zfzn.firemaster.service.impl.MessageReceiver;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.io.Serializable;

import static com.zfzn.firemaster.service.PackMessageSender.DATA_QUEUE;
import static com.zfzn.firemaster.service.PackMessageSender.PACK_QUEUE;


/**
 * redis 配置
 *
 * @author : Tony.fuxudong
 * Created in 2019-02-04 14:37
 */
@Configuration
@AutoConfigureAfter(RedisAutoConfiguration.class)
public class RedisCacheAutoConfig {
    @Bean
    public RedisTemplate<String, Serializable> redisCacheTemplate(LettuceConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Serializable> template = new RedisTemplate<>();
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }

    /**
     * redis消息监听器容器
     * 可以添加多个监听不同话题的redis监听器，只需要把消息监听器和相应的消息订阅处理器绑定，该消息监听器
     * 通过反射技术调用消息订阅处理器的相关方法进行一些业务处理
     * @param connectionFactory
     * @param listenerAdapter
     * @return
     */
    @Bean
    //相当于xml中的bean
    RedisMessageListenerContainer container(LettuceConnectionFactory connectionFactory, MessageListenerAdapter listenerAdapter,MessageListenerAdapter listenerAdapter2) {

        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        // 订阅了一个叫 pack_queue 的通道
        container.addMessageListener(listenerAdapter, new PatternTopic(PACK_QUEUE));
        container.addMessageListener(listenerAdapter2, new PatternTopic(DATA_QUEUE));
        // 这个container 可以添加多个 messageListener
        return container;
    }

    /**
     * 消息监听器适配器，绑定消息处理器，利用反射技术调用消息处理器的业务方法
     * @param receiver 消息接收器
     * @return 消息监听适配器
     */
    @Bean
    MessageListenerAdapter listenerAdapter(MessageReceiver receiver) {
        // 这个地方 是给 messageListenerAdapter 传入一个消息接受的处理器，利用反射的方法调用“receiveMessage”
        // 也有好几个重载方法，这边默认调用处理器的方法 叫 handleMessage 可以自己到源码里面看
        return new MessageListenerAdapter(receiver, "receivePackMessage");
    }
    @Bean
    MessageListenerAdapter listenerAdapter2(MessageReceiver receiver) {
        // 这个地方 是给 messageListenerAdapter 传入一个消息接受的处理器，利用反射的方法调用“receiveMessage”
        // 也有好几个重载方法，这边默认调用处理器的方法 叫 handleMessage 可以自己到源码里面看
        return new MessageListenerAdapter(receiver, "receivedDataMessage");
    }

    @Bean
    StringRedisTemplate template(LettuceConnectionFactory connectionFactory) {
        return new StringRedisTemplate(connectionFactory);
    }
}
