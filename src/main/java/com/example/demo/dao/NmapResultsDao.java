package com.example.demo.dao;

import com.example.demo.model.NmapResults;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface NmapResultsDao {

    int insertScanResults(String ip, int timeout);



    List<NmapResults> selectAllScanResults();

    Optional<NmapResults> selectScanByIp(String ipAddress);

}
