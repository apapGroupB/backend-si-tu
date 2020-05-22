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
    public ArrayList<RestUserModel> perpustakaanViewAll() {
        ArrayList<RestUserModel> ListUser = new ArrayList<RestUserModel>();
        final String uri = "http://si-perpus-b6.herokuapp.com/perpustakaan/api/employees";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        List<Integer> id_role = Arrays.asList(1, 2, 5, 6, 7);

        for(int i = 0; i < id_role.size(); i++) {
            String role = id_role.get(i).toString();
            int total = 0;
            for(int j = 0; j < result.length(); j++) {
                if(role.charAt(0) == result.charAt(j) ) {
                    total++;
                }
            }
            RestUserModel res = new RestUserModel(Integer.parseInt(role), total);
            ListUser.add(res);
        }

        return ListUser;
    }
}