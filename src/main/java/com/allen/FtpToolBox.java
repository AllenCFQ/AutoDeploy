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
         FtpUploadFileOrDir.uploadFileOrDid(srcFile, destDir, "10.10.55.88", 21, "mpsp", "mpsp4321");
         System.out.println("@@@ 上传结束...");
    }




    public static void cups_pre() throws Exception {
        String[] srcDirS = {"C:\\0000000\\cups.Front4_PDO00004301\\.build\\classes\\com\\umpay\\front3\\adapter\\AbstractAdapter.class",
                "C:\\0000000\\cups.Front4_PDO00004301\\.build\\classes\\com\\umpay\\front3\\adapter\\UM_Pay.class",
                "C:\\0000000\\cups.Front4_PDO00004301\\.build\\classes\\com\\umpay\\front3\\adapter\\UM_Cancel.class",
                "C:\\0000000\\cups.Front4_PDO00004301\\.build\\classes\\com\\umpay\\front3\\adapter\\UM_Refund.class",
                "C:\\0000000\\cups.Front4_PDO00004301\\.build\\classes\\com\\umpay\\front3\\adapter\\UM_Revoke.class"};
        String destDir = "/usr/mpsp/netbank/cups.Front4-app1/classes/com/umpay/front3/adapter";
        for (String s : srcDirS) {
        }
        JavaPpcSsh.rpcShell("  cd /usr/mpsp/netbank/cups.Front4-app1/bin; ./restart.sh");
    }


}
