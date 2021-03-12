package top.durandal.api.service;


import top.durandal.entity.Article;

import java.util.List;

/**
 * (Article)表服务接口
 *
 * @author makejava
 * @since 2020-10-06 16:49:54
 */
public interface ArticleService {

    /**
     * 通过ID查询单条数据
     *
     * @return 实例对象
     */
    Article queryById();

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Article> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param article 实例对象
     * @return 实例对象
     */
    Article insert(Article article);

    /**
     * 修改数据
     *
     * @param article 实例对象
     * @return 实例对象
     */
    Article update(Article article);

    /**
     * 通过主键删除数据
     *
     * @return 是否成功
     */
    boolean deleteById();

    /**
     * 通过作品id查询文章内容
     * @param worksId
     * @return
     */
    List<Article> queryByWorksId(int worksId);

    /**
     * 将所有步骤列表插入数据库
     * @param article
     */
    void insertAllArticle(List<Article> article);
}