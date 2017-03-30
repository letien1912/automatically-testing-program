package TransferData;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by Admin on 3/10/2017.
 */
public class ClientController implements ITransferData {
    public static String IP_SERVER = "localhost";
    private Socket socketClient;
    private DataInputStream dis;
    private DataOutputStream dos;
    private Thread runClientReciver;
    public ClientController(){
        try {
            socketClient = new Socket(IP_SERVER,ServerController.SERVER_PORT);
            dis = new DataInputStream(socketClient.getInputStream());
            dos = new DataOutputStream(socketClient.getOutputStream());

            /* Noi de Gui 1 cai gi do*/
            sendData();
            recieveData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sendData() {
        try {
            dos.write(2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void recieveData() {
        runClientReciver = new Thread(new ClientReciverData());
        runClientReciver.start();
    }
}
