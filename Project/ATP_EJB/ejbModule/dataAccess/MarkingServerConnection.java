package dataAccess;

import java.net.HttpURLConnection;
import java.net.URL;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.core.MediaType;

import exceptionHandl.ATP_ExceptionHandler;

/**
 * Session Bean implementation class MarkingServerConnection
 */
@Stateless
@LocalBean
public class MarkingServerConnection implements I_MarkingServerConnectionRemote {

    /**
     * Default constructor. 
     */
    public MarkingServerConnection() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public HttpURLConnection GetConnection(String serverUrl) throws ATP_ExceptionHandler {
		// TODO Auto-generated method stub
		try {
			URL url = new URL(serverUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setRequestProperty("Content-Type", MediaType.APPLICATION_JSON);
			connection.setRequestMethod("GET");
			return connection;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ATP_ExceptionHandler(e.getMessage(), 30, "MarkingServerConnection", "Create Connection Fail");
		}
	}

	@Override
	public void CloseConnection(HttpURLConnection connection) throws ATP_ExceptionHandler {
		// TODO Auto-generated method stub
		try {
			connection.disconnect();
		} catch (Exception e) {
			// TODO: handle exception
			throw new ATP_ExceptionHandler(e.getMessage(), 48, "MarkingServerConnection", "Disconnect Fail"); 
		}
	
	}

}
