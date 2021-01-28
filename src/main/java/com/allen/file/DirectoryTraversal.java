package com.allen.file;

import java.io.File;

public class DirectoryTraversal {

    public static void main(String[] args) {
        dirMethod("C:\\idea-utf8\\PRE\\bankpre-faceroute_PDO00004301\\.build\\script");
    }

    public static void dirMethod(String path) {
        File file = new File(path);
        if (file.exists()) {
            File[] files = file.listFiles();
            if (null != files) {
                for (File file2 : files) {
                    if (file2.isDirectory()) {
                        //System.out.println("文件夹:" + file2.getAbsolutePath());
                        dirMethod(file2.getAbsolutePath());
                    } else {
                        System.out.println("文件:" + file2.getAbsolutePath());
                    }
                }
            }
        } else {
            System.out.println("文件不存在!");
        }
    }
}
