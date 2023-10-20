package com.DataAgregatorApp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;


@Configuration
public class KafkaConfig {

	@Value("${producerApplicationID}")
	public String producerApplicationID;

	@Value("${spring.kafka.bootstrap-servers}")
	public String bootstrapServers;

	@Value("${group-id}")
	public String groupId;
}