package com.allen;

import com.allen.ftp.FtpUploadFileOrDir;
import com.allen.ssh.JavaPpcSsh;

public class FtpToolBox {


    /**
     * 上传文件
     * 2021-01-25 17:15:55
     * @param srcFile 源文件夹会源文件
     * @param destDir 目标路径
     * @param destIp 目标地址
     * @param port 目标端口
     * @param destUser 登录用户名
     * @param destPwd 登录密码
     * @throws Exception
     */
     public static void  uploadFileOrDid(String srcFile,String destDir,String destIp,int port,String destUser,String destPwd) throws Exception {
         System.out.println("@@@ 上传开始...");
         FtpUploadFileOrDir.uploadFileOrDid(srcFile, destDir, destIp, port, destUser, destPwd);
         System.out.println("@@@ 上传结束...");
    }
}
