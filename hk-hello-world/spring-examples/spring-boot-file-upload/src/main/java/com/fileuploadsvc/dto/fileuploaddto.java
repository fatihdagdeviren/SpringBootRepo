package com.fileuploadsvc.dto;

import lombok.Data;

import java.util.Base64;

@Data
public class fileuploaddto {

    private String fileName;
    private String fileExtension;
    private String directoryPath;
    private String fileContent;

}
