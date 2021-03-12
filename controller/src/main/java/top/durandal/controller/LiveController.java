package top.durandal.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;
import top.durandal.api.service.LiveService;
import top.durandal.common.ResponseInfo;
import top.durandal.entity.Live;

import java.util.List;

@RestController
@RequestMapping("live")
@Api
public class LiveController {

    @Reference
    LiveService liveService;

    @GetMapping("getLiveByHeat")
    public ResponseInfo getLiveByHeat() {
        List<Live> live = liveService.getLiveByHeat();
        if (live == null) {
            return ResponseInfo.error("没有正在直播的房间");
        }
        return ResponseInfo.success(live);
    }

    @GetMapping("getLive")
    public ResponseInfo getLive() {
        List<Live> live = liveService.getLive();
        if (live == null) {
            return ResponseInfo.error("没有直播间信息");
        }
        return ResponseInfo.success(live);
    }

    @GetMapping("getLiveById")
    public ResponseInfo getLiveById(String liveId) {
        Live live = liveService.queryById(liveId);
        if (live == null) {
            return ResponseInfo.error("没有找到直播间");
        }
        return ResponseInfo.success(live);
    }

    @PostMapping("insertLive")
    public ResponseInfo insertLive(@RequestBody Live live) {
        try {
            Live liveRes = liveService.insertLive(live);
            return ResponseInfo.success(liveRes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseInfo.error("插入失败");
    }
}
