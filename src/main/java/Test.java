public class Test {

    public static void main(String[] args) {
        String payType = "P15X0038".substring(3, 4);
        System.out.println(payType);
        System.out.println(String.valueOf(Integer.parseInt(payType, 36)));;
    }
}
