package top.durandal.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.durandal.api.service.CategoriesService;
import top.durandal.common.ResponseInfo;
import top.durandal.entity.Categories;

import java.util.List;

@RestController
@RequestMapping("categories")
public class CategoriesController {

    @Reference
    CategoriesService categoriesService;

    @GetMapping("getCategoriesByCategoriesId")
    public ResponseInfo getCategoriesByCategoriesId(Integer categoriesId){
        Categories categories = categoriesService.queryById(categoriesId);
        if (categories==null){
            return ResponseInfo.error("没有该物品");
        }
        return ResponseInfo.success(categories);
    }

    @GetMapping("getAllCategories")
    public ResponseInfo getAllCategories(){
        List<Categories> all = categoriesService.getAll();
        if (all==null){
            return ResponseInfo.error("没有分类");
        }
        return ResponseInfo.success(all);
    }
}
