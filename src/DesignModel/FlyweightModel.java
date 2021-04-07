package DesignModel;

// 享元模式:实现对象的共享,即共享池,当系统种对象多的时候可以减少内存的开销,通常与工厂模式一起使用

// 例子: ip代理池

import java.util.HashMap;
import java.util.Map;

class IP{
    private String ipAddress;
    private String Region;

    public IP(String ipAddress, String region) {
        this.ipAddress = ipAddress;
        this.Region = region;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public String getRegion() {
        return Region;
    }

    public void use(){
        System.out.println("Now use ip: " + this.ipAddress + ", region:" + this.Region);
    }

    public void release(){
        System.out.println("Now release ip: " + this.ipAddress + ", region: " + this.Region);
    }
}

class IPPool{
    private static final Map<String, IP> ipMap = new HashMap<>();

    public static IP getIP(String ipAddress){
        IP ip = ipMap.get(ipAddress);

        if(ip == null){
            String region = String.valueOf(Math.random());
            ip = new IP(ipAddress, region);
            ipMap.put(ipAddress, ip);
            System.out.println("create IP: " + ipAddress + ", " + region);

        }

        return ip;
    }

    public static void releaseIPAll(){
        for (IP ip: ipMap.values()){
            ip.release();
        }
    }


}

public class FlyweightModel {

    public static void main(String[] args) {

        for(int i = 0; i < 23; i++){
            IP ip = IPPool.getIP(String.valueOf(i));
            ip.use();
        }

        IPPool.releaseIPAll();
    }
}
