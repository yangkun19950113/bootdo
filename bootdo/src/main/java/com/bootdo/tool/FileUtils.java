package com.bootdo.tool;


import java.io.*;

public class FileUtils {
    /**
     * 读取相对路径下的的文本文件
     * @param filePath
     * @return 存在返回内容,不存在返回null
     * @throws IOException
     */
    public static String readRelativeFile(String filePath) throws IOException {
        // 只允许读取相对目录文件
        String relativeFilePath = "."+ File.separator+filePath;
        File file = new File(relativeFilePath);
        // 不存在或者不是文件返回null
        if(!file.exists() || !file.isFile()){
            return null;
        }
        try(InputStreamReader reader = new InputStreamReader(new FileInputStream(file))) {
            try (BufferedReader br = new BufferedReader(reader)) {
                StringBuilder content = new StringBuilder();
                String data = null;
                while ((data = br.readLine()) != null) {
                    content.append(data);
                }
                return content.toString();
            }
        }
    }
}