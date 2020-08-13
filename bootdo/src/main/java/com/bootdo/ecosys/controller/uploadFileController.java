package com.bootdo.ecosys.controller;

import com.bootdo.common.dao.FileDao;
import com.bootdo.common.domain.FileDO;
import com.bootdo.common.utils.FileType;
import com.bootdo.common.utils.FileUtil;
import com.bootdo.common.utils.R;
import com.bootdo.tool.MessageResult;
import com.bootdo.tool.ResponseData;
import com.bootdo.tool.UploadUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.bootdo.common.config.BootdoConfig;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/ecosys/uploadFile")
public class uploadFileController {
    @Autowired
    private FileDao fileDao;

    @Autowired
    private BootdoConfig bootdoConfig;
    @PostMapping("upload")
    public ResponseData upload(MultipartFile file, String socialCreditCode){
        String fileName = file.getOriginalFilename();
        fileName = FileUtil.renameToUUID(fileName);
        FileDO fileDO = new FileDO();
        fileDO.setSocialCreditCode(socialCreditCode);
        fileDO.setUrl("/files/" + fileName);
        fileDao.save(fileDO);
//        FileDO sysFile = new FileDO(FileType.fileType(fileName), "/files/" + fileName, new Date());
        try {
            FileUtil.uploadFile(file.getBytes(), bootdoConfig.getUploadPath(), fileName);
        } catch (Exception e) {
            return MessageResult.error("500","上传失败");
        }
        return MessageResult.success("0","上传成功");
    }
    @PostMapping("reupload")
    public ResponseData reupload(MultipartFile file, String socialCreditCode){
        fileDao.delete(socialCreditCode);
        String fileName = file.getOriginalFilename();
        fileName = FileUtil.renameToUUID(fileName);
        FileDO fileDO = new FileDO();
        fileDO.setSocialCreditCode(socialCreditCode);
        fileDO.setUrl("/files/" + fileName);
        fileDao.save(fileDO);
//        FileDO sysFile = new FileDO(FileType.fileType(fileName), "/files/" + fileName, new Date());
        try {
            FileUtil.uploadFile(file.getBytes(), bootdoConfig.getUploadPath(), fileName);
        } catch (Exception e) {
            return MessageResult.error("500","上传失败");
        }
        return MessageResult.success("0","上传成功");
    }

}
