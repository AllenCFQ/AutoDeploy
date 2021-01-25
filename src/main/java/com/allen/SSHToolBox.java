package com.allen;

import com.allen.ssh.JavaPpcSsh;

import java.io.IOException;

public class SSHToolBox {


    public static  void  rpcShell(String ip,int port,String user2,String pw,String command) throws IOException {
        System.out.println("@@@ 调用脚本开始...");
        JavaPpcSsh.rpcShell(ip, port, user2, pw, command);
        System.out.println("@@@ 调用脚本结束...");
    }

}
