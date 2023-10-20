package com.DataAgregatorApp.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.DataAgregatorApp.entity.ComuneDose;

@Configuration
public class KafkaConsumerConfig {

	@Autowired
	private KafkaConfig systemConfig;

	@Bean
	public ConsumerFactory<String, ComuneDose> consumerFactory() {
		Map<String, Object> config = new HashMap<>();
		config.put(ProducerConfig.CLIENT_ID_CONFIG, systemConfig.producerApplicationID);
		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, systemConfig.bootstrapServers);
		config.put(ConsumerConfig.GROUP_ID_CONFIG, systemConfig.groupId);
		config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);

		return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(),
				new JsonDeserializer<>(ComuneDose.class));
	}


	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, ComuneDose> comuneDoseListener() {
		ConcurrentKafkaListenerContainerFactory<String, ComuneDose> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory());
		return factory;
	}

}