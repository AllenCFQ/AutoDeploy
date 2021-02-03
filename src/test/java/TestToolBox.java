import com.allen.FtpToolBox;
import com.allen.SSHToolBox;

public class TestToolBox {

    public static void main(String[] args) throws Exception {
        boolean pbgFlag = false;
        boolean routpaygate = false;
        boolean bankpre_Faceroute_flag = false;
        boolean cups_flag = false;

        boolean pre38_flag = true;

        if (pre38_flag) {
            upload38Pre();
        }

        if (pbgFlag) {
            uploadPbg();
        }
        if (routpaygate) {
            uploadRoutpaygate();
        }
        if (bankpre_Faceroute_flag) {
            faceroute_pre();
        }
        if (cups_flag) {
            cups_pre();
        }

    }

    public static void faceroute_pre() throws Exception {
        String srcDir = "C:\\idea-utf8\\PRE\\bankpre-faceroute_PDO00004301\\.build\\classes";
        String destDir = "/usr/mpsp/netbank/bankpre-faceroute/";
        FtpToolBox.uploadFileOrDid(srcDir, destDir, "10.10.55.88", 21, "mpsp", "mpsp4321");
        SSHToolBox.rpcShell("10.10.55.88",22,"mpsp","mpsp4321", "cd /usr/mpsp/netbank/bankpre-faceroute/script; ./restart.sh");
    }

    public static void cups_pre() throws Exception {
        String[] srcDirS = {"C:\\0000000\\cups.Front4_PDO00004301\\.build\\classes\\com\\umpay\\front3\\adapter\\AbstractAdapter.class",
                "C:\\0000000\\cups.Front4_PDO00004301\\.build\\classes\\com\\umpay\\front3\\adapter\\UM_Pay.class",
                "C:\\0000000\\cups.Front4_PDO00004301\\.build\\classes\\com\\umpay\\front3\\adapter\\UM_Cancel.class",
                "C:\\0000000\\cups.Front4_PDO00004301\\.build\\classes\\com\\umpay\\front3\\adapter\\UM_Refund.class",
                "C:\\0000000\\cups.Front4_PDO00004301\\.build\\classes\\com\\umpay\\front3\\adapter\\UM_Revoke.class"};


        String destDir = "/usr/mpsp/netbank/cups.Front4-app1/classes/com/umpay/front3/adapter";
        for (String s : srcDirS) {
            FtpToolBox.uploadFileOrDid(s, destDir, "10.10.55.88", 21, "mpsp", "mpsp4321");
        }
        SSHToolBox.rpcShell("10.10.55.88",22,"mpsp","mpsp4321","  cd /usr/mpsp/netbank/cups.Front4-app1/bin; ./restart.sh");
    }

    public static void uploadPbg() throws Exception {
        String ip = "10.10.55.36";
        int ftpport = 21;
        int sshport = 22;
        String user2 = "mpsp";
        String pwd = "mpsp)(*76";

        String[] srcDirS = {"C:\\idea-utf8\\WG\\plat2-pbg_RCO00004208\\.build\\v2\\app\\bin\\com\\umpay\\pbg\\busi\\crm\\RecvChkCardBinResPart.class"};
        String destDir = "/usr/mpsp/plat2-pbg/v2/app/bin/com/umpay/pbg/busi/crm";
        for (String s : srcDirS) {
            FtpToolBox.uploadFileOrDid(s, destDir, ip, ftpport, user2, pwd);
        }
        SSHToolBox.rpcShell(ip, sshport, user2, pwd, " cd /usr/mpsp/plat2-pbg/v2/app/script; ./reserv.sh");

    }

    public static void uploadRoutpaygate() throws Exception {
        String ip = "10.10.55.36";
        int ftpport = 21;
        int sshport = 22;
        String user2 = "mpsp";
        String pwd = "mpsp)(*76";


        String[] srcDirS = {"C:\\idea-utf8\\WG\\routePaygate\\.build\\v2\\app\\bin\\com\\umpay\\paygate2\\bank\\implement\\CupsPosPreAuthBank.class"};
        String destDir = "/usr/mpsp/routePaygate/v2/app/bin/com/umpay/paygate2/bank/implement";

        //String[] srcDirS = {"C:\\idea-utf8\\WG\\routePaygate\\.build\\v2\\app\\bin\\com\\umpay\\paygate2\\bank\\implement\\CupsBank.class"};
//        String[] srcDirS = {"C:\\idea-utf8\\WG\\routePaygate\\.build\\v2\\app\\bin\\com\\umpay\\paygate2\\bank\\implement\\CupsPosPreAuthBank.class"};
//        String destDir = "/usr/mpsp/routePaygate/v2/app/bin/com/umpay/paygate2/bank/implement";

//        String[] srcDirS = {"C:\\idea-utf8\\WG\\routePaygate\\.build\\v2\\app\\bin\\com\\umpay\\paygate2\\application\\preAuth\\ReturnPreAuthResultPart.class"};
//        String destDir = "/usr/mpsp/routePaygate/v2/app/bin/com/umpay/paygate2/application/preAuth";

        for (String s : srcDirS) {
            FtpToolBox.uploadFileOrDid(s, destDir, ip, ftpport, user2, pwd);
        }
        SSHToolBox.rpcShell(ip, sshport, user2, pwd, " cd /usr/mpsp/routePaygate/v2/app/script; ./reserv.sh");
    }

    public static void upload38Pre() throws Exception {
        String ip = "10.10.55.38";
        int ftpport = 21;
        int sshport = 22;
        String user2 = "mpsp";
        String pwd = "mpsp)(*76";

        String[] srcDirS = {"C:\\idea-utf8\\PRE\\bankpreOnline2-zl-UnionPayWeChatAliPay\\.build\\classes\\com\\umpay\\front3\\bank\\impl\\UnionPayWeChatAliPay.class"};
        String destDir = "/usr/mpsp/netbank/bankpreOnline2-zl-UnionPayWeChatAliPay/classes/com/umpay/front3/bank/impl";
        for (String s : srcDirS) {
            FtpToolBox.uploadFileOrDid(s, destDir, ip, ftpport, user2, pwd);
        }
        SSHToolBox.rpcShell(ip, sshport, user2, pwd, " cd /usr/mpsp/netbank/bankpreOnline2-zl-UnionPayWeChatAliPay/bin; ./run.sh");

    }
}
