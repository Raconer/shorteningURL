package com.shorten.shortening.repository;


import com.shorten.shortening.model.shortening.Shortening;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UrlMapper {
 
    // Create
    Integer insert(Shortening shortening);
    // Read
    Shortening get(Shortening shortening);
}
