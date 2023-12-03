package platform.codingnomads.co.springweb.resttemplate.GET.getForObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import platform.codingnomads.co.springweb.resttemplate.GET.models.QuoteTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@SpringBootApplication
public class GetForObjectDemo {

    @Autowired
    RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(GetForObjectDemo.class, args);
    }

    @Bean
    public CommandLineRunner run() throws Exception {
        return args -> {

            QuoteTemplate[] randomQuote;
            randomQuote = restTemplate.getForObject("https://zenquotes.io/api/random/", QuoteTemplate[].class);
            System.out.println(Arrays.toString(randomQuote));

            // submit more requests here
            Excuse[] excuses;
            excuses = restTemplate.getForObject("https://excuser-three.vercel.app/v1/excuse", Excuse[].class);
            Arrays.stream(excuses).forEach(System.out::println);

            Map<String, String> map = new HashMap<>();
            map.put("minprice","0");
            map.put("maxprice","0.1");
            ResponseEntity<Bored> boredResponse = restTemplate.getForEntity("http://www.boredapi.com/api/activity", Bored.class, map);
            if (boredResponse.getStatusCode().is2xxSuccessful()) {
                System.out.println(Objects.requireNonNull(boredResponse.getBody()).activity);
            }


            
//            CodingNomadsTasksApiResponse response =
//                    restTemplate.getForObject("http://demo.codingnomads.co:8080/tasks_api/users/5",
//                            CodingNomadsTasksApiResponse.class);
//
//            System.out.println(response.toString());

        };
    }
}
