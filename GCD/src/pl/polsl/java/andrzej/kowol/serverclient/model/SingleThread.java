package pl.polsl.java.andrzej.kowol.serverclient.model;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Class responsible for receive and send data to proper client.
 *
 * @author Andrzej Kowol
 * @version 1.0
 */
public class SingleThread extends Thread {

    private Socket socket = null;
    String clientString;
    String serverString;
    DataProtocol dataProtocol = new DataProtocol();
    final String connectWord = "LCMGCD"; //Client must send the same connectWord to receive answers from Server

    /**
     * Parametered constructor. Set socket.
     *
     * @param socket Socket
     */
    public SingleThread(Socket socket) {
        super();
        this.socket = socket;
    }

    /**
     * Method which is responsible for receive and send data to client.
     */
    public void run() {
        try {
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream outToClient = new DataOutputStream(socket.getOutputStream());

            clientString = inFromClient.readLine();
            if (clientString.equals(connectWord)) {
                outToClient.writeBytes(connectWord + '\n');

                clientString = inFromClient.readLine();

                if (dataProtocol.validate(clientString)) {
                    outToClient.writeBytes("Server accept data" + '\n');
                    dataProtocol.leastCommonMultipleAndGreatestDivisor();
                    outToClient.writeBytes("Server knows the least common multiple and the greatest common divisor" + '\n');
                    serverString = dataProtocol.result() + '\n';
                    outToClient.writeBytes(serverString);
                    outToClient.writeBytes("EXIT" + '\n');
                } else {
                    outToClient.writeBytes("There is an error. Did you enter correct data?" + '\n');
                    outToClient.writeBytes("EXIT" + '\n');
                }
            } else {
                outToClient.writeBytes("Connection with wrong server" + '\n');
            }
        } catch (IOException | NullPointerException e) {
        }
    }
}
