package utils;

import java.io.*;

public class Read {
    private final BufferedReader fromKey;
    private int i;
    private float f;
    private long l;
    private char c;
    private double d;
    private String line;
    
    public Read() {
        InputStreamReader input = new InputStreamReader(System.in);
        fromKey = new BufferedReader(input);
    }

    public int readInt(){
        boolean flagStatus = true;

        do{
            try {
                line = fromKey.readLine();
                i = Integer.parseInt(line);
                flagStatus = false;
            } catch (IOException | NumberFormatException e){
                System.out.println("Input error.");
            }
        } while(flagStatus);

        return i;
    }

     public float readFloat(){
        boolean flagStatus = true;

        do{
            try {
                line = fromKey.readLine();
                f = Float.parseFloat(line);
                flagStatus = false;
            } catch (IOException | NumberFormatException e){
                System.out.println("Input error.");
            }
        } while(flagStatus);

        return f;
    }
     
     public long readLong(){
        boolean flagStatus = true;

        do{
            try {
                line = fromKey.readLine();
                l = Long.parseLong(line);
                flagStatus = false;
            } catch (IOException | NumberFormatException e){
                System.out.println("Input error.");
            }
        } while(flagStatus);

        return l;
    }

      public char readChar(){
        boolean flagStatus = true;

        do{
            try {
                line = fromKey.readLine();
                c = line.charAt(0);
                flagStatus = false;
            } catch (IOException e){
                System.out.println("Input error.");
            }
        } while(flagStatus);

        return c;
    }

    public double readDouble(){
        boolean flagStatus = true;

        do{
            try {
                line = fromKey.readLine();
                d = Double.parseDouble(line);
                flagStatus = false;
            } catch (IOException | NumberFormatException e){
                System.out.println("Input error.");
            }
        } while(flagStatus);

        return d;
    }

    public String readString(){
        boolean flagStatus = true;

        do{
            try {
                line = fromKey.readLine();
                flagStatus = false;
            } catch (IOException e) {
                System.out.println("Input error.");
            }
        } while(flagStatus);

        return line;
    }
}