package com.haydikodlayalim.service.impl;

import com.haydikodlayalim.dto.KisiDto;
import com.haydikodlayalim.entity.Adres;
import com.haydikodlayalim.entity.Kisi;
import com.haydikodlayalim.repo.AdresRepository;
import com.haydikodlayalim.repo.KisiRepository;
import com.haydikodlayalim.service.KisiService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor // Deger atanmadıysa constructordan atanması gerektigini anlıyor, kisirepo, adresrepo final oldugu icin constructordan atanması gerektigini anliyor
public class KisiServiceImpl implements KisiService {

    
    private final KisiRepository kisiRepository;
    private final AdresRepository adresRepository;

    @Override
    @Transactional //tek transactionda yapilir yada geri alinir
    public KisiDto save(KisiDto kisiDto) {
        //Assert.isNull(kisiDto.getAdi(), "Ad alani bos olamaz");
        //kisidto save yerinde kaldin video
        Kisi kisi = new Kisi();
        kisi.setAdi(kisiDto.getAdi());
        kisi.setSoyadi(kisiDto.getSoyadi());
        final Kisi kisiDb = kisiRepository.save(kisi);
        List<Adres> liste = new ArrayList<Adres>();
        kisiDto.getAdresler().forEach((item -> {
            Adres adres = new Adres();
            adres.setAdres(item);
            adres.setAdresTip(Adres.AdresTip.DIGER);
            adres.setAktif(true);
            adres.setKisi(kisiDb);
            liste.add(adres);
        }));
        adresRepository.saveAll(liste);
        kisiDto.setId(kisiDb.getId());
        return kisiDto;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<KisiDto> getAll() {
        List<Kisi> kisiler = kisiRepository.findAll();
        List<KisiDto> kisiDtos = new ArrayList<KisiDto>();
        kisiler.forEach(it -> {
            KisiDto kisiDto = new KisiDto();
            kisiDto.setId(it.getId());
            kisiDto.setAdi(it.getAdi());
            kisiDto.setSoyadi(it.getSoyadi());
            kisiDto.setAdresler(it.getAdresleri().stream().map(Adres::getAdres)
                    .collect(Collectors.toList()));
            kisiDtos.add(kisiDto);
        });
        return kisiDtos;
    }

    @Override
    public Page<Kisi> getAll(Pageable pageable) {
        return null;
    }
}