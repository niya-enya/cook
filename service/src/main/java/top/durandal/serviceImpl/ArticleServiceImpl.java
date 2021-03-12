package top.durandal.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;
import top.durandal.api.service.ArticleService;
import top.durandal.dao.ArticleDao;
import top.durandal.entity.Article;

import javax.annotation.Resource;
import java.util.List;

@Service
@Component
public class ArticleServiceImpl implements ArticleService {

    @Resource
    ArticleDao articleDao;

    public Article queryById() {
        return null;
    }

    public List<Article> queryAllByLimit(int offset, int limit) {
        return null;
    }

    public Article insert(Article article) {
        return null;
    }

    public Article update(Article article) {
        return null;
    }

    public boolean deleteById() {
        return false;
    }

    public List<Article> queryByWorksId(int worksId) {
        List<Article> articles = articleDao.queryByWorksId(worksId);
        if (articles.size() != 0) {
            return articles;
        }
        return null;
    }

    public void insertAllArticle(List<Article> article) {
        for (Article a : article) {
            articleDao.insert(a);
        }
    }

}
