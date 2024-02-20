package com.example.jpatest.repository;

import com.example.jpatest.entity.ItemImg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemImgRepo extends JpaRepository<ItemImg,Long> {

}
