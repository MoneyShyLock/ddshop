package com.zdp.ddshop.web;

import com.zdp.ddshop.service.FileService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Map;

@Controller
public class FileAction {
    @Autowired
private FileService fileService;

    @ResponseBody
    @RequestMapping(value = "/file/upload",method = RequestMethod.GET)
    public void config(HttpServletRequest request, HttpServletResponse response)throws Exception{
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");

        String action = request.getParameter("action");
        if("config".equals(action)){
            PrintWriter out = response.getWriter();
            InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("config.json");
            IOUtils.copy(inputStream,out,"UTF-8");
        }
    }
    @ResponseBody
    @RequestMapping(value = "/file/upload",method = RequestMethod.POST)
    public Map<String,Object> upload(MultipartFile upfile){

        return fileService.uploadImages(upfile);
    }
}
