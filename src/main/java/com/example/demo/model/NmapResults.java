package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.UUID;

public class NmapResults {
    private final String ipAddress;
    private int timeout;
    private static final  LinkedHashMap<String, String> results = new LinkedHashMap<String, String>();

    public NmapResults(@JsonProperty("ipAddress") String ipAddress,
                       @JsonProperty("timeout") int timeout){

        this.ipAddress = ipAddress;
        scanIpAddress(timeout);
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public int getTimeout() {
        return timeout;
    }

    public LinkedHashMap<String, String> getResults() {
        return results;
    }

    public LinkedHashMap<String, String> scanIpAddress(int timeout) {

        for (int portNumber = 0; portNumber <= 10000; portNumber++){
            if(portIsOpen(this.ipAddress, portNumber, timeout)) {
                results.put(Integer.toString(portNumber), "Open");
            }
    }
        return results;
    }


    private Boolean portIsOpen(String ip, int port, int timeout){
        try{
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress(ip, port), timeout);
            socket.close();
            return true;

        }
        catch (Exception exception){
            return false;
        }
    }

}
