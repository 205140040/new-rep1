package com.yfairy.springsession;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * 
 * The @EnableRedisHttpSession annotation creates a Spring Bean with the name of
 * springSessionRepositoryFilter that implements Filter. The filter is what is
 * in charge of replacing the HttpSession implementation to be backed by Spring
 * Session. In this instance Spring Session is backed by Redis.
 *
 */
@EnableRedisHttpSession
public class Config {

	@Bean
	public JedisConnectionFactory connectionFactory() {
		/**
		 * We create a RedisConnectionFactory that connects Spring Session to
		 * the Redis Server. We configure the connection to connect to localhost
		 * on the default port (6379) For more information on configuring Spring
		 * Data Redis, refer to the reference documentation.
		 */
		return new JedisConnectionFactory();
	}
}
