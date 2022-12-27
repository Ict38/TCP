import model.Answer;
import model.Student;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTCP {
    public static void main(String[] args) {
        DataInputStream dis;
        DataOutputStream dos;
        ObjectInputStream ois;
        ObjectOutputStream oos;
        try(ServerSocket serverSocket = new ServerSocket(11000)){
            System.out.println("Server is listening on port " + 11000);

            while (true) {
                Socket socket = serverSocket.accept();

                System.out.println("New client connected");
                dos = new DataOutputStream(socket.getOutputStream());
                dis = new DataInputStream(socket.getInputStream());
                oos = new ObjectOutputStream(socket.getOutputStream());
                ois = new ObjectInputStream(socket.getInputStream());

                String msv = dis.readUTF();
                Student student = new Student(msv);
                oos.writeObject(student);
                student = (Student) ois.readObject();
                dis.readUTF();
                dis.readInt();
                Answer answer = (Answer) ois.readObject();

                System.out.println(student);
            }
        } catch (Exception ex){
            System.out.println(ex);
        }
    }
}
