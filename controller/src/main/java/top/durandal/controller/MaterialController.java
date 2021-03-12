package top.durandal.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.durandal.api.service.MaterialService;
import top.durandal.common.ResponseInfo;
import top.durandal.entity.Material;

import java.util.List;


@RestController
@RequestMapping("material")
@Api
public class MaterialController {

    @Reference
    MaterialService materialService;

    @GetMapping("getMaterialByWorksId")
    public ResponseInfo getMaterialByWorksId(int worksId){
        List<Material> material = materialService.getMaterialByWorksId(worksId);
        if (material==null){
            return ResponseInfo.error("没有食材");
        }
        return ResponseInfo.success(material);
    }
}
