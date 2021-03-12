package top.durandal.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.durandal.api.service.SortService;
import top.durandal.common.ResponseInfo;
import top.durandal.entity.Sort;
import top.durandal.statictext.StaticText;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("sort")
@Api(tags = "菜谱")
public class SortController {

    @Reference
    SortService sortService;

    @GetMapping("getSort")
    @ApiOperation(value = "获得所有菜谱",notes = StaticText.APITEXT+"获得全部菜谱分类")
    public ResponseInfo getSort(){
        List<Sort> sorts = sortService.queryAll();
        if (sorts!=null){
        return ResponseInfo.success(sorts);
        }
        return ResponseInfo.error("没有找到任何分类");
    }


}
