package com.allen.ftp;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ftp 上传目录或文件
 * add by oyp 2021-01-18 13:53:50
 */
public class FtpUploadFileOrDir {

    public static void uploadFileOrDid (String srcFile,String destDir,String destIp,int port,String destUser,String destPwd) throws  Exception {
        FtpUploadFileOrDir t = new FtpUploadFileOrDir();
        boolean conectFlag = t.connect(destIp, port, destUser, destPwd,destDir);
        if (!conectFlag) {
            System.out.println(conectFlag);
            throw  new Exception("登录失败");
        }
        File file = new File(srcFile);
        t.upload(file);
    }

    private FTPClient ftp;
    private  boolean connect(String ip,int port,String username,String password,String destPath) throws Exception {
        boolean result = false;
        ftp = new FTPClient();
        int reply;
        ftp.connect(ip,port);
        ftp.login(username,password);
        ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
        reply = ftp.getReplyCode();
        if (!FTPReply.isPositiveCompletion(reply)) {
            ftp.disconnect();
            return result;
        }
        ftp.changeWorkingDirectory(destPath);
        //System.out.println( "remotedir:  "+ftp.printWorkingDirectory());
        result = true;
        return result;
    }
    private void upload(File file) throws Exception {
        if (file.isDirectory()) {
            System.out.println(ftp);
            System.out.println(file.getName());
            ftp.makeDirectory(file.getName());
            ftp.changeWorkingDirectory(file.getName());
            String[] files = file.list();
            for (int i = 0; i < files.length; i++) {
                File file1 = new File(file.getPath() + "\\" + files[i]);
                if (file1.isDirectory()) {
                    upload(file1);
                    ftp.changeToParentDirectory();
                } else {
                    File file2 = new File(file.getPath() + "\\" + files[i]);
                    FileInputStream input = new FileInputStream(file2);
                    ftp.storeFile(file2.getName(), input);
                    input.close();
                    System.out.println("上传成功：");
                    System.out.println("本地路径：" + file2.getAbsolutePath() + file2.getName());
                    System.out.println("远程路径：" + ftp.printWorkingDirectory());
                }
            }
        } else {
            File file2 = new File(file.getPath());
            FileInputStream input = new FileInputStream(file2);
            ftp.rename(file2.getName(), file2.getName() + ".bak" + datetime14());
            ftp.storeFile(file2.getName(), input);

            input.close();
            System.out.println("上传成功：" + ftp.printWorkingDirectory() + "/" + file2.getName());
        }
    }
    private static String datetime14() {
        return (new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date());
    }

}
