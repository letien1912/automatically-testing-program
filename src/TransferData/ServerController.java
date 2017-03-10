package TransferData;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Admin on 3/10/2017.
 */
public class ServerController implements  ITransferData{
    public static int SERVER_PORT = 69696;
    private ServerSocket serverSocket;
    private ExecutorService executor;

    public ServerController() {
        executor = Executors.newSingleThreadExecutor();

        try {
            serverSocket = new ServerSocket(SERVER_PORT);
            startServer();
            sendData();
            recieveData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

     void startServer(){
        while (true){
            try {
                serverSocket.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void sendData() {

    }

    @Override
    public void recieveData() {

    }
}
