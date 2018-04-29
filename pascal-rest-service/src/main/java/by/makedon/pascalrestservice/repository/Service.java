package by.makedon.pascalrestservice.repository;

import by.makedon.pascalrestservice.domain.Article;

import java.util.List;

public interface Service {
    List<String> takeTitleList();
    Article takeArticle(String title);
    void addArticle(Article article);
    void updateArticle(Article article);
    void removeArticle(String title);
}
