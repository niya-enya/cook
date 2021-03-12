package top.durandal.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;
import top.durandal.api.service.LiveRecordingService;
import top.durandal.common.ResponseInfo;
import top.durandal.entity.LiveRecording;

import java.util.List;

@RestController
@RequestMapping("LiveRecording")
public class LiveRecordingController {

    @Reference
    LiveRecordingService liveRecordingService;

    @PostMapping("insertLiveRecording")
    public ResponseInfo insertLiveRecording(@RequestBody LiveRecording liveRecording){
        LiveRecording insert = liveRecordingService.insert(liveRecording);
        if (insert==null){
            return ResponseInfo.error("插入记录失败");
        }
        return ResponseInfo.success(insert);
    }

    @GetMapping("getLiveRecordingByUserId")
    public ResponseInfo getLiveRecordingByUserId(Integer userId){
        List<LiveRecording> liveRecording = liveRecordingService.getLiveRecordingByUserId(userId);
        if(liveRecording==null){
            return ResponseInfo.error("该用户没有直播间");
        }
        return ResponseInfo.success(liveRecording);
    }
}
