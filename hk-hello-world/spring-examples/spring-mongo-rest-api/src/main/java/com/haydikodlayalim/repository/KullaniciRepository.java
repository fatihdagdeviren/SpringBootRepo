package com.haydikodlayalim.repository;

import com.haydikodlayalim.entitiy.Kullanici;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface KullaniciRepository extends MongoRepository<Kullanici, String> {

}
