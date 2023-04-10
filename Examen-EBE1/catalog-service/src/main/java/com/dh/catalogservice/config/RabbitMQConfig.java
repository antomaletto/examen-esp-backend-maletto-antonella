package com.dh.catalogservice.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    public static final String EXCHANGE_NAME = "backendExchange";
    public static final String TOPIC_CATALOG_MOVIE = "com.dh.backend.catalog.movie";
    public static final String QUEUE_CATALOG_MOVIE ="queueMovieCatalog";
    public static final String TOPIC_CATALOG_SERIE = "com.dh.backend.catalog.serie";
    public static final String QUEUE_CATALOG_SERIE ="queueSerieCatalog";

    @Bean
    public TopicExchange appExchange() {
        return new TopicExchange(EXCHANGE_NAME);
    }

    @Bean
    public Queue queueCatalogMovie(){
        return new Queue(QUEUE_CATALOG_MOVIE);
    }

    @Bean
    public Queue queueCatalogSerie(){
        return new Queue(QUEUE_CATALOG_SERIE);
    }
/*
    @Bean
    public Binding declareBindingSpecificMovie(){
        return BindingBuilder.bind(queueCatalogMovie()).to(appExchangeMovie()).with(TOPIC_CATALOG_MOVIE);
    }
    @Bean
     public Binding declareBindingSpecificSerie(){
         return BindingBuilder.bind(queueCatalogSerie()).to(appExchangeSerie()).with(TOPIC_CATALOG_SERIE);
     }*/

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        final var rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(producerJackson2MessageConverter());
        return rabbitTemplate;
    }

    @Bean
    public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
