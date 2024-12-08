package tetris;
import com.fazecast.jSerialComm.*;


public class SerialInput {
    SerialPort[] availablePorts;
    SerialPort chosenPort;
    public SerialInput(){
        availablePorts = SerialPort.getCommPorts();
        System.out.println("Available Ports : ");
        for(int i = 0; i < availablePorts.length; i++){
            System.out.println(i + ": " + availablePorts[i].getSystemPortName());
        }
        this.chosenPort = availablePorts[1];
        System.out.println("Selected Port: " + chosenPort.getSystemPortName());

        this.chosenPort.setComPortParameters(9600, 8,SerialPort.ONE_STOP_BIT, SerialPort.NO_PARITY);
        this.chosenPort.setComPortTimeouts(SerialPort.TIMEOUT_WRITE_BLOCKING, 0, 0);
        this.chosenPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 1000, 0);
        

        if(this.chosenPort.openPort()){
            System.out.println("Port opened successfully.");
        }
        else{
            System.out.println("Failed to open port");
            return;
        }
        SerialThread task = new SerialThread();
        task.start();
    }
    
    public int readSerialPort(){
        byte[] buffer = new byte[1];

        int bytesRead = chosenPort.readBytes(buffer, buffer.length);

        int right = 00;
        int left = 01;
        int up = 10;
        int down = 11;
        
        if(bytesRead  > 0){
            System.out.println(buffer[0]);
            if(buffer[0] == 'u')
                return up;
            else if(buffer[0] == 'd')
                return down;
            else if(buffer[0] == 'r')
                return right;
            else if(buffer[0] == 'l')
                return left;
        }
        return -1;
    }

    public SerialPort chosenPortGetter(){
        return chosenPort;
    }
}

class SerialThread extends Thread{
    private boolean running = true;
    public SerialPort chosenPort;
    
    public SerialThread(){
    }

    public void run(){
        System.out.println("Thread is running");
        while(running){
        }
    }
}
