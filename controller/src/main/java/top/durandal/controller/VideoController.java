package top.durandal.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.durandal.api.service.VideoService;
import top.durandal.common.ResponseInfo;
import top.durandal.entity.Video;

import java.util.List;

@RestController
@RequestMapping("video")
@Api
public class VideoController {

    @Reference
    VideoService videoService;

    @GetMapping("getVideoByWorksId")
    public ResponseInfo getVideoByWorksId(int worksId){
        List<Video> videoByWorksId = videoService.getVideoByWorksId(worksId);
        if (videoByWorksId==null){
            return ResponseInfo.error("没有视频信息");
        }
        return ResponseInfo.success(videoByWorksId);
    }
    @GetMapping("getVideos")
    public ResponseInfo getVideos(){
        List<Video> all = videoService.getVideos();
        if(all == null){
            return ResponseInfo.error("没有视频信息");
        }
        return ResponseInfo.success(all);
    }
}
