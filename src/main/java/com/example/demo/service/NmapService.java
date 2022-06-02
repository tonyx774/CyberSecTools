package com.example.demo.service;

import com.example.demo.dao.NmapResultsDao;
import com.example.demo.model.NmapResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NmapService {
    private final NmapResultsDao nmapResultsDao;


    @Autowired
    public NmapService(@Qualifier("testRepo") NmapResultsDao nmapResultsDao){ this.nmapResultsDao = nmapResultsDao;}

    public int addNmapScanResults(String ipAddress, int timeout){
        return nmapResultsDao.insertScanResults(ipAddress, timeout);
    }

    public List<NmapResults> getAllNmapResults() { return nmapResultsDao.selectAllScanResults();}

    public Optional<NmapResults> getNmapResultsByIp(String ip){
        return nmapResultsDao.selectScanByIp(ip);
    }

}
