package cn.loulanke.provider;

import cn.loulanke.entity.Message;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Slf4j
public class KafkaSender {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public void send(){
        Message message = new Message();
        message.setId(1l);
        message.setMessage("我来发消息了哦 ~ ~ ~");
        message.setSendTime(new Date());
        log.info("发送消息 ==> {}", JSON.toJSONString(message));
        kafkaTemplate.send("loulanke",JSON.toJSONString(message));
    }


}
