package com.example.nursingrobotspringrest.dto;

import java.util.HashMap;
import java.util.Map;

public class CustomResponse {
    public Map<String, String> returnMessage (String message, String id){
        HashMap<String, String> map = new HashMap<>();
        try{

            map.put("message", message);

            if(null!= id && id.length() > 1){
                map.put("id", id);
            }



        }catch (NullPointerException ex){

        }
        return map;
    }
}
