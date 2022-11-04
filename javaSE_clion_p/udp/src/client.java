import java.net.*;
public class client {
    public static void main(String[] args) {
        DatagramSocket ds = null;
        try {
            ds = new DatagramSocket(10000);
            byte[] by = new byte[1024];
            DatagramPacket dp = new DatagramPacket(by, by.length);
            while (true){
                ds.receive(dp);
                String str = new String(dp.getData(), 0, dp.getLength());
                System.out.println(str + "--" + dp.getAddress());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ds != null)
                ds.close();
        }
    }
}
