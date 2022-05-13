package com.example.nursingrobotspringrest.utility;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.util.HashMap;
import java.util.Map;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;


@Component
@ComponentScan
@Service
public class OKHttpConnection {


    private static HttpURLConnection connection;

    @Autowired
    public ApiConfiguration opencv;

    @Autowired
    FileResource fileService;


    public String sendRequest(String file) {
        String uploadedFile = fileService.getDirectory() + file;
//        HttpClient client = HttpClient.newHttpClient();

//        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(opencv.getApi())).build();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        MultiValueMap<String, Object> body
                = new LinkedMultiValueMap<>();
        body.add("file", new FileSystemResource(uploadedFile));

        HttpEntity<MultiValueMap<String, Object>> requestEntity
                = new HttpEntity<>(body, headers);

        String serverUrl = opencv.getApi();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate
                .postForEntity(serverUrl, requestEntity, String.class);

        System.out.println(response);


        return "Ok";


    }

}

