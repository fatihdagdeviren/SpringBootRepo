package api;

import Repository.KisiRepository;
import com.haydikodlayalim.entity.Kisi;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/kisi")
public class KisiController {


    private final KisiRepository kisiRepository;

//    @PostConstruct
//    public void init(){
//        Kisi k = new Kisi();
//        k.setAd("Haydi");
//        k.setSoyad("Kodlayalim");
//        k.setAdres("test");
//        k.setDogumTarihi(Calendar.getInstance().getTime());
//        k.setId("K0001");
//        kisiRepository.save(k);
//    }

    @GetMapping("/{search}")
    public ResponseEntity<List<Kisi>> getKisi(@PathVariable String search){
        List<Kisi> kisiler = kisiRepository.getByCustomQuery(search);
        return ResponseEntity.ok(kisiler);
    }

}
