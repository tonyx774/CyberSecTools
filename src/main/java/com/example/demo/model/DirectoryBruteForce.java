package com.example.demo.model;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;


public class DirectoryBruteForce {

    public DirectoryBruteForce(){

    }
    public static List<String> testDirectory(String ipAddress, int portNumber){
        List<String> wordList = new ArrayList<String>();
        List<String> validDirectoryList = new ArrayList<String>();
        wordList.add("Test");
        wordList.add("Ok");
        for(String word : wordList){
        try{
            URL myURL = new URL(ipAddress+":"+Integer.toString(portNumber)+"/"+word);
            URLConnection myURLConnection = myURL.openConnection();
            myURLConnection.connect();
            validDirectoryList.add(word);

        }
        catch(MalformedURLException e){

        }
        catch(IOException e){

        }}
        return validDirectoryList;
    }


}
