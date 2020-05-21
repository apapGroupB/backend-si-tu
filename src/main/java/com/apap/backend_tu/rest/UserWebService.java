package com.apap.backend_tu.rest;

import com.apap.backend_tu.model.RestUserModel;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

//@RestController
//@RequestMapping("/webservice")
//@CrossOrigin(origins = "*")
//public class UserWebService {
//
//    @PostMapping(value = "perpustakaan/viewall")
//    public List<RestUserModel> perpustakaanViewAll() {
//        final String uri = "http://si-perpus-b6.herokuapp.com/perpustakaan/user/viewall";
//        RestTemplate restTemplate = new RestTemplate();
//        List<RestUserModel> result = restTemplate.getForObject(uri, List.class);
//        return result;
//    }
//}