package com.bootdo.ecosys.controller;

import com.bootdo.tool.MessageResult;
import com.bootdo.tool.ResponseData;
import com.bootdo.tool.UploadUtil;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/ecosys/uploadFile")
public class uploadFileController {
    @PostMapping("upload")
    public ResponseData upload(MultipartFile file, String socialCreditCode){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            String uploadPath = "D:/abc/";
            String uploadPathOffice = "abc/";
            String url = "";
            if (file != null) {
                String path = uploadPath;
                String uploadFile = UploadUtil.uploadFile(file, path);
                url = "/" + uploadPathOffice + uploadFile;
            }
            map.put("value", url);


        } catch (Exception e) {

            e.printStackTrace();
            return MessageResult.error("500","上传失败");
        }
        return MessageResult.success("0","上传成功",map);
    }

}
