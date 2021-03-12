package top.durandal.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;
import top.durandal.api.service.CommentService;
import top.durandal.dao.CommentDao;
import top.durandal.entity.Comment;
import top.durandal.util.ReformatDate;

import javax.annotation.Resource;
import java.util.List;

@Service
@Component
public class CommentServiceImpl implements CommentService {

    @Resource
    CommentDao commentDao;

    public Comment queryById(Integer commentId) {
        return null;
    }

    public List<Comment> queryAllByLimit(int offset, int limit) {
        return null;
    }

    public Comment insert(Comment comment) {
        comment.setCommentDate(ReformatDate.getDate());
        commentDao.insert(comment);
        return comment;
    }

    public Comment update(Comment comment) {
        return null;
    }

    public boolean deleteById(Integer commentId) {
        return false;
    }

    public List<Comment> getCommentByWorksId(int worksId) {
        List<Comment> commentByWorksId = commentDao.getCommentByWorksId(worksId);
        if (commentByWorksId.size()!=0){
            return commentByWorksId;
        }
        return null;
    }

    public List<Comment> getCommentByUserId(Integer userToId) {
        List<Comment> allComment = commentDao.getCommentByUserId(userToId);
        if (allComment.size()!=0){
            return allComment;
        }
        return null;
    }
}
