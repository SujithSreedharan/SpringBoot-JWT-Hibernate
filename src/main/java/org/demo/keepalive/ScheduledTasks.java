

package org.demo.keepalive;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Profile("!dev")
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);
    
    @Autowired
    private RestTemplate restTemplate;
    
    @Value("${health.url}")
    private String healthUrl;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000)
    public void getHealthStatus() {
        log.info("The time is now {}", dateFormat.format(new Date()));
        ResponseEntity<String> responseEntity =restTemplate.getForEntity(healthUrl, String.class);
        //HttpStatus statusCode = responseEntity.getStatusCode();
        log.info(responseEntity.getBody());
    }
}

