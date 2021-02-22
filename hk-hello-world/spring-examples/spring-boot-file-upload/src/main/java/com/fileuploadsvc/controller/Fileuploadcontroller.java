package com.fileuploadsvc.controller;

import com.fileuploadsvc.dto.fileuploaddto;
import jdk.jfr.TransitionFrom;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.web.bind.annotation.*;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/fileupload")
public class Fileuploadcontroller {

    private final String serviceBasePath = "E:\\Fatih_GitHub\\SpringBootRepo\\hk-hello-world\\spring-examples\\spring-boot-file-upload";

    @GetMapping
    public String sayHello() {
        return "fileupload Hello World";
    }

    @PostMapping
    public String UploadFile(@RequestBody fileuploaddto myFile)  {
        String directory = serviceBasePath + "\\" + myFile.getDirectoryPath();
        File myDirectory = new File(directory);
        if(!myDirectory.exists()){
            myDirectory.mkdir();
        }

        String filePath = directory + "\\" + myFile.getFileName() + "." + myFile.getFileExtension();
        try {
            byte[] data = Base64.decodeBase64(myFile.getFileContent());
            try (OutputStream stream = new FileOutputStream(filePath)) {
                stream.write(data);
            }
        }
        catch (IOException e) {
            return "fileupload failed";
        }
        return "fileupload sucess";
    }

}
