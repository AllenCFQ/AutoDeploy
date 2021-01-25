package com.allen;

import com.allen.ssh.JavaPpcSsh;

import java.io.IOException;

public class SSHToolBox {


    public static  void  rpcShell(String ip,int port,String user2,String pw,String command) throws IOException {
        JavaPpcSsh.rpcShell(ip, port, user2, pw, command);
    }

}
