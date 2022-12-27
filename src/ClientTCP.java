import model.Answer;
import model.Student;

import java.io.*;
import java.net.Socket;

public class ClientTCP {
    Socket socket = null;
    DataInputStream dis;
    DataOutputStream dos;
    ObjectInputStream ois;
    ObjectOutputStream oos;

    String ip = "192.168.0.103";
    int port = 11000;

    public void start() {
        try{
            socket = new Socket(ip,port);
            System.out.println("HERE");
            dis = new DataInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream());
            ois = new ObjectInputStream(socket.getInputStream());
            oos = new ObjectOutputStream(socket.getOutputStream());
            System.out.println("KET NOI THANH CONG");
        } catch (IOException ex){
            System.out.println(ex);
            System.out.println("KHONG KET NOI DUOC");
        }
    }
    public void mainEvent(){
        try{
            String maSV = "B19DCCN304";
            dos.writeUTF(maSV);

            Student student = (Student) ois.readObject();
            student.setHovaten("CHU DUC HUY");
            student.setIP("192.168.0.103");
            student.setGroup(6);
            oos.writeObject(student);
            dos.writeUTF("CHU DUC HUY");
            dos.writeInt(6);
            Answer answer = new Answer(student);
            oos.writeObject(answer);
        }catch (Exception ex){
            System.out.println(ex);
        }
    }
    public static void main(String[] args) {
        ClientTCP clientTCP = new ClientTCP();
        clientTCP.start();
        clientTCP.mainEvent();
    }
}
