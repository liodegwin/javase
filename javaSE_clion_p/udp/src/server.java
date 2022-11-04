import java.net.*;
public class server {
    public static void main(String[] args) throws InterruptedException {
        Integer count = 0;
        DatagramSocket ds = null;
        byte[] by = "Hello you!\n".getBytes();

        try {
            ds = new DatagramSocket();
            DatagramPacket dp = new DatagramPacket(by, 0, by.length,
                    InetAddress.getByName("127.0.0.1"), 10000);
            while(true){
                if(count == 1000)count = 0;
                count++;
                by = count.toString().getBytes();
                Thread.sleep(1000);
                dp.setData(by,0,by.length);
                ds.send(dp);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ds != null)
                ds.close();
        }

    }
}