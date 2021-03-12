package top.durandal.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import top.durandal.entity.Article;

import java.util.List;

/**
 * (Article)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-06 16:28:29
 */
@Mapper
@Repository
public interface ArticleDao {

    /**
     * 通过ID查询单条数据
     *
     * @return 实例对象
     */
    Article queryById();

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Article> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param article 实例对象
     * @return 对象列表
     */
    List<Article> queryAll(Article article);

    /**
     * 新增数据
     *
     * @param article 实例对象
     * @return 影响行数
     */
    @Insert("insert into article (works_id,article_img,article_content) values(#{worksId},#{articleImg},#{articleContent})")
    int insert(Article article);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Article> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Article> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Article> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Article> entities);

    /**
     * 修改数据
     *
     * @param article 实例对象
     * @return 影响行数
     */
    int update(Article article);

    /**
     * 通过主键删除数据
     *
     * @return 影响行数
     */
    int deleteById();

    /**
     * 通过worksId返回该作品所有的步数
     * @param worksId
     * @return
     */
    @Select("select article_step,article_img,article_content from article where works_id = #{workId}")
    List<Article> queryByWorksId(int worksId);
}