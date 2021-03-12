package top.durandal.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;
import top.durandal.api.service.ArticleService;
import top.durandal.common.ResponseInfo;
import top.durandal.entity.Article;

import java.util.List;

@RestController
@RequestMapping("article")
@Api
public class ArticleController {

    @Reference
    ArticleService articleService;

    @GetMapping("getArticleByWorksId")
    public ResponseInfo getArticleByWorksId(int worksId){
        List<Article> articles = articleService.queryByWorksId(worksId);
        if (articles==null){
            return ResponseInfo.error("没有文章详情");
        }
        return ResponseInfo.success(articles);
    }

    @PostMapping("insertArticle")
    public ResponseInfo insertArticle(@RequestBody List<Article> article){
        articleService.insertAllArticle(article);
        return ResponseInfo.success("插入成功");
    }
}
