package com.apap.backend_tu.rest;

import com.apap.backend_tu.model.LowonganModel;
import com.apap.backend_tu.model.RestUserModel;
import com.apap.backend_tu.service.LowonganService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/webservice")
@CrossOrigin(origins = "*")
public class PerpustakaanWebService {

    @GetMapping(value = "perpustakaan/viewall")
    public RestUserModel getTotalUserPustakawan() {

        final String uri = "http://si-perpus-b6.herokuapp.com/perpustakaan/api/employees";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);

        String role = "5";
        int total = 0;
        for (int j = 0; j < result.length(); j++) {
            if (role.charAt(0) == result.charAt(j)) {
                total++;
            }
        }
        RestUserModel totalPustakawan = new RestUserModel(Integer.parseInt(role), total);

        return totalPustakawan;
    }
}