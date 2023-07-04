package com.main.sbp.redis.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.sbp.redis.dto.Product;

@RestController
@RequestMapping("/api")
public class Publisher {

	@Autowired
	private RedisTemplate<String, Object> template;

	@Autowired
	private ChannelTopic topic;

	@PostMapping("/publish")
	public String publish(@RequestBody Product product) {
		template.convertAndSend(topic.getTopic(), product);
		return "Event Published !!";
	}
}
