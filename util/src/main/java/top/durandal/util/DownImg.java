package top.durandal.util;

import org.springframework.web.multipart.MultipartFile;
import top.durandal.statictext.StaticText;

import java.io.File;
import java.io.IOException;

public class DownImg {
    public static String upload(MultipartFile file) {
        if (file.isEmpty()) {
            return "上传失败，请选择文件";
        }
        String fileName = file.getOriginalFilename();
        String filePath = StaticText.IMAGES_PATH+ "img/";
        File dest = new File(filePath + fileName);
        try {
            file.transferTo(dest);
            return fileName;
        } catch (IOException e) {
        }
        return "上传失败";
    }
}
