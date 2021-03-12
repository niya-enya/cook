package top.durandal.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;
import top.durandal.api.service.CommentService;
import top.durandal.common.ResponseInfo;
import top.durandal.entity.Comment;

import java.util.List;

@RequestMapping("comment")
@RestController
@Api
public class CommentController {

    @Reference
    CommentService commentService;

    @GetMapping("getCommentByWorksId")
    public ResponseInfo getCommentByWorksId(int worksId){
        List<Comment> commentByWorksId = commentService.getCommentByWorksId(worksId);
        if (commentByWorksId==null){
            return ResponseInfo.error("没有评论");
        }
        return ResponseInfo.success(commentByWorksId);
    }

    //@Param("worksId") Integer worksId, @Param("commentContent") String commentContent, @Param("userFromId") Integer userFromId, @Param("userToId") Integer userToId
    @PostMapping("insertComment")
    public ResponseInfo insertComment(@RequestBody Comment comment){
        Comment commentRes = commentService.insert(comment);
        return ResponseInfo.success(commentRes);
    }

    @GetMapping("getCommentByUserId")
    public ResponseInfo getCommentByUserId(Integer userToId){
        List<Comment> allComment= commentService.getCommentByUserId(userToId);
        if (allComment==null){
            return ResponseInfo.error("没有收到评论");
        }
        return ResponseInfo.success(allComment);
    }


}
