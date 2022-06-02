package com.example.demo.api;


import com.example.demo.model.NmapResults;
import com.example.demo.service.NmapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("api/v1/nmap")
@RestController
public class NmapController {
    private final NmapService nmapService;

    @Autowired
    public NmapController(NmapService nmapService){
        this.nmapService = nmapService;
    }

    @PostMapping
    public int addIpAddress(@Valid @NonNull @RequestBody NmapResults nmapResults){


        return nmapService.addNmapScanResults(nmapResults.getIpAddress(),nmapResults.getTimeout());}

    @GetMapping
    public List<NmapResults> getAllResults(){ return nmapService.getAllNmapResults();}


}
