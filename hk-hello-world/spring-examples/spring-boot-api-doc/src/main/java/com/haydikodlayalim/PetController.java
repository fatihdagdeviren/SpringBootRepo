package com.haydikodlayalim;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/pet")
@Api(value = "Benim Pet API dokumantasyonum")
public class PetController {

    private List<Pet> petList = new ArrayList<Pet>();

    @PostConstruct
    public void init(){
        petList.add(new Pet(1,"Test Pet",new Date()));
    }

    @PostMapping
    @ApiOperation(value = "Yeni Pet Ekleme Metodu", notes = "Bu metodu dikkatli kullan")
    public ResponseEntity<Pet> kaydet(@RequestBody @ApiParam(value = "hayvan") Pet pet){
        petList.add(pet);
        return ResponseEntity.ok(pet);
    }

    @GetMapping
    @ApiOperation(value = "Pet Listesi metotu", notes = "Bu metodu tümünü getirir")
    public ResponseEntity<List<Pet>> tumunuListele(){
        return ResponseEntity.ok(petList);
    }

}
