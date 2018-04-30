package by.makedon.pascalmvcservice;

import by.makedon.pascalmvcservice.domain.Article;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class RestService {
    private static final String URL = "http://localhost:8080/pascal-rest-service/controller/";

    public List<String> takeTitleList() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        ResponseEntity<String[]> res = restTemplate.getForEntity(URL + "takeTitleList", String[].class);
        return Arrays.asList(res.getBody());
    }

    public Article takeArticle(String title) {
        String url = URL + "takeArticle/" + title;
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        return restTemplate.getForObject(url, Article.class);
    }

    public void addArticle(Article article) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
        restTemplate.postForObject(URL + "addArticle", article, Article.class);
    }

    public void updateArticle(Article article) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
        restTemplate.put(URL + "updateArticle", article, Article.class);
    }

    public void removeArticle(String title) {
        String url = URL + "removeArticle/" + title;
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(url);
    }
}