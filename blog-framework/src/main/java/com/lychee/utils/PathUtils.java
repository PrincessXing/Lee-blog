package com.lychee.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
//上传文件路径生成工具类 文件名格式：2023/10/19/uuid.jpg
public class PathUtils {
    public static String generateFilePath(String fileName) {
        //根据日期生成路径 2023/10/19
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd/");
        String dataPath = simpleDateFormat.format(new Date());
        //uuid作为文件名
        String uuid = UUID.randomUUID().toString().replace("-", "");
        //后缀和文件后缀保持一致
        int index = fileName.lastIndexOf(".");
        String fileType = fileName.substring(index);
        return dataPath + uuid + fileType;
    }
}
