package pl.polsl.java.andrzej.kowol.serverclient.view;

import java.io.*;
import java.net.*;

/**
 * Client class. Responsible for connect, send data to server and received
 * result from server.
 *
 * @author Andrzej Kowol
 * @version 1.0
 */
public class Client {

    int port;
    String clientString;
    String serverString;
    BufferedReader inFromUser;
    final String host = "localhost";
    final String connectWord = "LCMGCD"; //if Server have the same connectWord client is able to receive results

    /**
     * Parametered constructor. Set port.
     *
     * @param port Number of port
     */
    public Client(int port) {
        this.port = port;
    }

    /**
     * Method responsible for work of client.
     *
     * @throws IOException Exception is thrown when there is error with
     * connection.
     */
    public void clientRun() throws IOException {

        inFromUser = new BufferedReader(new InputStreamReader(System.in));

        Socket clientSocket = new Socket(host, port);
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        outToServer.writeBytes(connectWord + '\n');
        serverString = inFromServer.readLine();

        if (serverString.equals(connectWord)) {
            System.out.println("Enter two numbers");
            clientString = inFromUser.readLine();
            outToServer.writeBytes(clientString + '\n');

            serverString = inFromServer.readLine();
            while (!serverString.equals("EXIT")) {
                System.out.println(serverString);
                serverString = inFromServer.readLine();
            }
        } else {
            System.out.println("Connection with wrong server");
        }
        clientSocket.close();
    }
}
