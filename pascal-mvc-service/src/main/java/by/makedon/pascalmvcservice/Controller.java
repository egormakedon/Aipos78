package by.makedon.pascalmvcservice;

import by.makedon.pascalmvcservice.domain.Article;
import by.makedon.pascalmvcservice.domain.Author;
import by.makedon.pascalmvcservice.domain.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@org.springframework.stereotype.Controller
@RequestMapping("/controller")
public class Controller {
    private static final String INDEX_PAGE = "index";
    private static final String ADD_PAGE = "add";
    private static final String ARTICLE_PAGE = "article";

    @Autowired
    private RestService service;

    @RequestMapping(value = "/takeTitleList", method = RequestMethod.GET)
    public ModelAndView takeArticleList() {
        List<String> titleList = service.takeTitleList();
        return new ModelAndView(INDEX_PAGE, "titleList", titleList);
    }

    @RequestMapping(value = "/takeArticle", method = RequestMethod.GET)
    public ModelAndView takeArticle(@RequestParam String title) {
        Article article = service.takeArticle(title);
        return new ModelAndView(ARTICLE_PAGE, "article", article);
    }

    @RequestMapping(value = "/addForward", method = RequestMethod.GET)
    public ModelAndView addForward() {
        return new ModelAndView(ADD_PAGE);
    }

    @RequestMapping(value = "/indexForward", method = RequestMethod.GET)
    public ModelAndView indexForward() {
        return new ModelAndView(INDEX_PAGE);
    }

    @RequestMapping(value = "/addArticle", method = RequestMethod.POST)
    public ModelAndView addArticle(@RequestParam String title, @RequestParam String body) {
        Article article = new Article();
        article.setTitle(title);
        article.setBody(body);
        article.setDate(new Date());

        Author author = new Author();
        author.setAuthorId(1);

        Resource resource = new Resource();
        resource.setResourceId(1);

        article.setAuthor(author);
        article.setResource(resource);
        service.addArticle(article);

        return new ModelAndView(INDEX_PAGE);
    }

    @RequestMapping(value = "/removeArticle", method = RequestMethod.POST)
    public ModelAndView removeArticle(@RequestParam(value = "title") String title) {
        service.removeArticle(title);
        return new ModelAndView(INDEX_PAGE);
    }

    @RequestMapping(value = "/updateArticle", method = RequestMethod.POST)
    public ModelAndView updateArticle(@RequestParam(value = "title") String title, @RequestParam(value = "body") String body) {
        Article article = new Article();
        article.setTitle(title);
        article.setBody(body);
        service.updateArticle(article);
        return takeArticle(title);
    }
}
