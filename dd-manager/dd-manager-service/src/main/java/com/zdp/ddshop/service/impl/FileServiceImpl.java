package com.zdp.ddshop.service.impl;

import com.zdp.ddshop.common.util.FtpUtils;
import com.zdp.ddshop.common.util.IDUtils;
import com.zdp.ddshop.service.FileService;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@Service
public class FileServiceImpl implements FileService{
    @Override
    public Map<String, Object> uploadImages(MultipartFile upfile) {
        String address="10.31.161.44";
        int port =21;
        String username = "ftpuser";
        String password = "root";
        String basePath = "/home/ftpuser/www/images";
        String dateString = new DateTime().toString("/yyyy/MM/dd");
        //获取原来的文件名，包括扩展名
        String original = upfile.getOriginalFilename();
        //截取拓展名
        String fileType=original.substring(original.lastIndexOf("."));
        //使用自定义工具类产生新的文件名，只产生了文件名，未产生扩展名
        String imageName = IDUtils.genImageName();
        //拼接生成新的文件名
        imageName+=fileType;
        InputStream inputStream=null;
        try {
            inputStream= upfile.getInputStream();
        }catch (IOException e){
            e.printStackTrace();
        }
        //上传成功返回true，否则返回false
        boolean bool = FtpUtils.uploadFile(address, port, username, password, basePath, dateString, imageName, inputStream);
        System.out.println(bool);
        Map<String,Object> map = new HashMap<String,Object>();
        if(bool){
            map.clear();
            map.put("state","SUCCESS");
            map.put("original",original);
            map.put("size",upfile.getSize());
            map.put("title",imageName);
            map.put("type",fileType);
            map.put("url",dateString + "/" + imageName);
        }
        return map;

    }
}
