package com.example.demo.dao;


import com.example.demo.model.NmapResults;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("testRepo")
public class TestNmapResultsDataAccessService implements NmapResultsDao {

    private static List<NmapResults> DB = new ArrayList<>();


    @Override
    public int insertScanResults(String ip, int timeout) {
        DB.add(new NmapResults(ip,timeout));
        return 1;
    }

    @Override
    public List<NmapResults> selectAllScanResults() {
        return DB;
    }

    @Override
    public Optional<NmapResults> selectScanByIp(String ipAddress) {
        return DB.stream()
                .filter(nmapResults -> nmapResults.getIpAddress().equals(ipAddress))
                .findFirst();
    }
}
