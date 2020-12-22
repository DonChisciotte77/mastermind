package utils;

import java.util.Random;

public class ReadRandom {
    private final Random value;
    
    public ReadRandom() {
        this.value=new Random();
    }
    
    public int readInt() {
        return value.nextInt();
    }
    
    public int readInt(int limit1, int limit2) {
        return value.nextInt(limit2)+(limit2-limit1);
    } 
   
    public int readInt(int limit) {
        return value.nextInt(limit);
    }
    
    public float readFloat(float limit) {
        float num=value.nextFloat();
        
        num*=limit;
        
        return num;
    }
    
    public double readDouble(float limit) {
        double num=value.nextDouble();
        
        num*=limit;
        
        return num;
    }
    
    public long readLong() {
        return value.nextLong();
    }
}
