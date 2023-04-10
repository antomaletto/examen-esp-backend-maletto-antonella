package com.dh.movieservice.event;

import com.dh.movieservice.config.RabbitMQConfig;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;



@Component
public class CatalogEventConsumer {
    @RabbitListener(queues = RabbitMQConfig.QUEUE_CATALOG_MOVIE)
    public void listen(CatalogEventConsumer.Data message){
        System.out.print("AVISO "+ message.aviso+":"+ message.name);
        //procesamiento
    }


    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public static class Data{
        private String genre;
        private String name;
        private String aviso;
    }
}
