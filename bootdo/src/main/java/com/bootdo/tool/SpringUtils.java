package com.bootdo.tool;


import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.*;

/**
 * @author hank
 */
public class SpringUtils {
    private SpringUtils(){}

    /**
     * 读取jar包中resources路径下的文本文件
     * @param path
     * @return
     * @throws IOException
     */
    public static String readResource(String path) throws IOException {
        Resource resource = new ClassPathResource(path);
        try(InputStream is = resource.getInputStream()) {
            try(InputStreamReader isr = new InputStreamReader(is)) {
                try(BufferedReader br = new BufferedReader(isr)) {
                    String data = null;
                    StringBuilder content = new StringBuilder();
                    while ((data = br.readLine()) != null) {
                        content.append(data);
                    }
                    return content.toString();
                }
            }
        }
    }

    /**
     * 读取文本文件,1.优先在系统相对路径查找如果没有2.再查找jar包中的resources目录下
     * @param path
     * @return
     * @throws IOException
     */
    public static String readResourcePrioritySys(String path) throws IOException {
        String readRelativeFileStr = FileUtils.readRelativeFile(path);
        if(readRelativeFileStr == null){
            return readResource(path);
        }
        return readRelativeFileStr;
    }

}
