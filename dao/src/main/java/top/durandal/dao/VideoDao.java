package top.durandal.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import top.durandal.entity.Video;

import java.util.List;

@Mapper
@Repository
public interface VideoDao {

    /**
     * 通过id作品返回视频详细内容
     * @param worksId
     * @return
     */
    @Select("select * from video where works_id = #{worksId}")
    List<Video> getVideoByWorksId(int worksId);

    /**
     * 得到全部作品
     */
    @Select("select * from video")
    List<Video> getVideos();
}
