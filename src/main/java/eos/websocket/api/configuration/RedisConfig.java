package eos.websocket.api.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

@Configuration
public class RedisConfig {
    private static final String CHANNEL_NAME = "actions";

    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        return new JedisConnectionFactory();
    }

    @Bean
    public StringRedisTemplate redisTemplate() {
        StringRedisTemplate template = new StringRedisTemplate();
        template.setConnectionFactory(redisConnectionFactory());

        return template;
    }

//    @Bean
//    public MessageListenerAdapter messageListener() {
//        return new MessageListenerAdapter(new Subscriber());
//    }

//    @Bean
//    public RedisMessageListenerContainer redisContainer() {
//        RedisMessageListenerContainer container
//                = new RedisMessageListenerContainer();
//        container.setConnectionFactory(redisConnectionFactory());
//        container.addMessageListener(messageListener(), topic());
//        return container;
//    }

    @Bean
    public ChannelTopic topic() {
        return new ChannelTopic(CHANNEL_NAME);
    }

}
