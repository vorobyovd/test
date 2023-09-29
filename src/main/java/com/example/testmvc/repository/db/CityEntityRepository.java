package com.example.testmvc.repository.db;

import com.example.testmvc.model.db.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface CityEntityRepository extends JpaRepository<CityEntity, Integer> {
    @Query("select c from CityEntity c where c.id =?1")
    CityEntity findById(int id);

    @Transactional
    @Modifying
    @Query("delete from CityEntity c where c.id = :id")
    void deleteById(@Param("id") int id);
}
