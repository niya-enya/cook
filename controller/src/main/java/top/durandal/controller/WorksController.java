package top.durandal.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;
import top.durandal.api.service.WorksService;
import top.durandal.common.ResponseInfo;
import top.durandal.entity.Works;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("works")
@Api
public class WorksController {

    @Reference
    WorksService worksService;

    @Resource
    ArticleController articleController;
    @Resource
    MaterialController materialController;
    @Resource
    VideoController videoController;

    @GetMapping("getWorksByTime")
    public ResponseInfo getWorksByTime() {
        List worksByTime = worksService.getWorksByTime();
        if (worksByTime == null) {
            return ResponseInfo.error("没有数据");
        }
        return ResponseInfo.success(worksByTime);
    }

    @GetMapping("getWorksBySortId")
    public ResponseInfo getWorksBySortId(int sortId) {
        List<Works> worksBySortId = worksService.getWorksBySortId(sortId);
        if (worksBySortId == null) {
            return ResponseInfo.error("没有相关文章");
        }
        return ResponseInfo.success(worksBySortId);
    }

    @GetMapping("getWorksByType")
    public ResponseInfo getWorksByType(String type) {
        List<Works> allLive = worksService.getWorksByType(type);
        if (allLive == null) {
            return ResponseInfo.error("没有视频");
        }
        return ResponseInfo.success(allLive);
    }

    @GetMapping("getWorksByWorksId")
    public ResponseInfo getWorksByWorksId(int worksId) {
        Works works = worksService.queryById(worksId);
        List<Object> worksList = new ArrayList<Object>();
        worksList.add(works);
        if ("图文".equals(works.getWorksType())) {
            Object article = articleController.getArticleByWorksId(worksId).getData();
            Object material = materialController.getMaterialByWorksId(worksId).getData();
            worksList.add(article);
            worksList.add(material);
            return ResponseInfo.success(worksList);
        } else if ("视频".equals(works.getWorksType())) {
            Object video = videoController.getVideoByWorksId(worksId).getData();
            worksList.add(video);
            return ResponseInfo.success(worksList);
        }
        return ResponseInfo.error("没有查找到数据");
    }

    @PostMapping("insertWorks")
    public ResponseInfo insertWorks(@RequestBody Works works){
        worksService.insert(works);
        return ResponseInfo.success();
    }

    @GetMapping("getWorksByUserId")
    public ResponseInfo getWorksByUserId(int userId){
        System.out.println(userId);
        List<Works> allWorks = worksService.getWorksByUserId(userId);
        if (allWorks==null){
            return ResponseInfo.error("该用户没有作品");
        }
        return ResponseInfo.success(allWorks);
    }
}
