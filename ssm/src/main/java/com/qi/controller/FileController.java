package com.qi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("file")
public class FileController {

    @RequestMapping("/fileUp")
    public String fileUp(@RequestParam("files")MultipartFile files) throws IOException {
        System.out.println("asdadasdad");
        String path = "E:/upLoad/";  //存储文件的路径
        if(files != null){
            String path2 = path+files.getOriginalFilename();
            files.transferTo(new File(path2));
        }else{
            return "error";
        }
        return "success";
    }

    @RequestMapping("/fileUps")
    public String fileUps(@RequestParam("files") MultipartFile files[]) throws IOException {
        System.out.println("多文件上传");
        String path = "E:/upLoad/";
        if(files != null){
            for(int i=0;i<files.length;i++){
                String path2 = path+files[i].getOriginalFilename();
                files[i].transferTo(new File(path2));
            }
        }else{
            System.out.println("文件上传失败");
            return "error.jsp";
        }
        return "success";
    }
}
