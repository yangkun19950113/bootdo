package com.bootdo.tool;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import com.bootdo.common.utils.UploadUtils;
import org.springframework.web.multipart.MultipartFile;


/**
 * 
 * @ClassName: UploadUtil 
 * @Description: 上传测试工具类
 * @author mengxin
 * @date 2017年11月14日 上午10:17:47
 */
public class UploadUtil extends UploadUtils {
	
	public static String uploadFile(MultipartFile file,String path) throws IOException{
		//上传文件真实名称
		String name = file.getOriginalFilename();
		//后缀名
		String suffixName = name.substring(name.lastIndexOf("."));
		//自定义随机数（字母+数字）作为文件名
		String hash = Integer.toHexString(new Random().nextInt());
		//生成上传后文件名
		String fileName = hash + suffixName;

		File tempFile = new File(path,fileName);
		//父目录是否存在
		if(!tempFile.getParentFile().exists()){
			tempFile.getParentFile().mkdirs();
		}
		//生成文件是否存在
		if(tempFile.exists()){
			tempFile.delete();
		}
		//创建文件
		tempFile.createNewFile();
		file.transferTo(tempFile);
		return tempFile.getName();
	}

}
