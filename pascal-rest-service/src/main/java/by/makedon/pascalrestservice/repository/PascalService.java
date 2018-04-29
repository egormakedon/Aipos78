package by.makedon.pascalrestservice.repository;

import by.makedon.pascalrestservice.domain.Article;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class PascalService implements Service {
    private static final String SQL_SELECT_TITLE_LIST = "SELECT article.title FROM by.makedon.pascalrestservice.domain.Article as article";
    private static final String SQL_SELECT_ARTICLE_BY_TITLE = "FROM by.makedon.pascalrestservice.domain.Article article WHERE article.title = :title";

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<String> takeTitleList() {
        Query query = em.createQuery(SQL_SELECT_TITLE_LIST);
        return (List<String>) query.getResultList();
    }

    @Override
    public Article takeArticle(String title) {
        Query query = em.createQuery(SQL_SELECT_ARTICLE_BY_TITLE);
        query.setParameter("title", title);
        return (Article) query.getSingleResult();
    }

    @Override
    public void addArticle(Article article) {
        em.persist(article);
    }

    @Override
    public void updateArticle(Article article) {
        Article a = takeArticle(article.getTitle());
        a.setBody(article.getBody());
        em.flush();
    }

    @Override
    public void removeArticle(String title) {
        em.remove(takeArticle(title));
    }
}
