package com.example.nursingrobotspringrest.utility;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Component
@ComponentScan
@Service
public class FileWrite {

    @Autowired
    FileResource fileResource;

    public String writeToServer(MultipartFile multipartFile) throws IOException {
        byte[] bytes = multipartFile.getBytes();


        String savefile = fileResource.setFileName(multipartFile.getOriginalFilename());

        BufferedOutputStream stream = new BufferedOutputStream(
                new FileOutputStream(new File(fileResource.getDirectory() + multipartFile.getOriginalFilename())));
        stream.write(bytes);
        stream.close();

        return savefile;
    }


}
