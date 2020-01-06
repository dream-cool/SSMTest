package com.clt.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/file")
public class FileController {

    private  static String uploadPath ="F:"+ File.separator;


    @RequestMapping("/upload1")
    public String upload1(@RequestParam("file")MultipartFile multipartFile, Model model){
        if (multipartFile!=null&&!multipartFile.isEmpty()){
                String originalFilename=multipartFile.getOriginalFilename();
                String fileNamePrefix=originalFilename.substring(0,originalFilename.lastIndexOf("."));
                String newFileNamePrefix=fileNamePrefix+new Date().getTime();
                String newFileName=newFileNamePrefix+originalFilename.substring(originalFilename.lastIndexOf("."));
                File file=new File(uploadPath+newFileName);
                try {
                    multipartFile.transferTo(file);
                    model.addAttribute("fileName",newFileName);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        return "uploadSuc";
    }


    List<String> list=new ArrayList<>();
    @RequestMapping("/upload")
    public String upload(@RequestParam("file")MultipartFile[] multipartFiles, Model model){
        if (multipartFiles!=null&&multipartFiles.length>0){
            for (MultipartFile multipartFile:multipartFiles){
                if(!multipartFile.isEmpty()){
                    System.out.println(multipartFile);
                    String originalFilename=multipartFile.getOriginalFilename();
                    String fileNamePrefix=originalFilename.substring(0,originalFilename.lastIndexOf("."));
                    String newFileNamePrefix=fileNamePrefix+new Date().getTime();
                    String newFileName=newFileNamePrefix+originalFilename.substring(originalFilename.lastIndexOf("."));
                    File file=new File(uploadPath+newFileName);
                    try {
                        multipartFile.transferTo(file);
                        list.add(newFileName);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            model.addAttribute("fileNames",list);
        }
    return "uploadSuc";
    }
    
    private static String parentPath="D:"+File.separator;
    @RequestMapping("/down")
    public String down(HttpServletResponse response){
        response.setCharacterEncoding("UTF-8");
        String fileName="新建文本文档.txt";
        Path path=Paths.get(parentPath,fileName);

        if(Files.exists(path)){
            String fileSuffix=fileName.substring(fileName.lastIndexOf(".")+1);
            response.setContentType("application/"+fileSuffix);
            try {
                response.addHeader("Content-Disposition","attachment:filename"+new String(fileName.getBytes("UTF-8"),"ISO8859-1"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            try {
                Files.copy(path,response.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "down";
    }

}
