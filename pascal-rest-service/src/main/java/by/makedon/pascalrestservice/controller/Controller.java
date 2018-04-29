package by.makedon.pascalrestservice.controller;

import by.makedon.pascalrestservice.domain.Article;
import by.makedon.pascalrestservice.repository.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("controller")
public class Controller {

    @Autowired
    private Service service;

    @RequestMapping(value = "takeTitleList", method = RequestMethod.GET)
    public ResponseEntity<List<String>> takeTitleList() {
        List<String> titleList = service.takeTitleList();
        return new ResponseEntity<>(titleList, HttpStatus.OK);
    }

    @RequestMapping(value = "takeArticle/{title}", method = RequestMethod.GET)
    public ResponseEntity<Article> takeArticle(@PathVariable("title") String title) {
        Article article = service.takeArticle(title);
        return new ResponseEntity<>(article, HttpStatus.OK);
    }

    @RequestMapping(value = "addArticle", method = RequestMethod.POST)
    public ResponseEntity<Void> addArticle(@RequestBody Article article) {
        service.addArticle(article);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "updateArticle", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateArticle(@RequestBody Article article) {
        service.updateArticle(article);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "removeArticle/{title}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> removeArticle(@PathVariable("title") String title) {
        service.removeArticle(title);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}