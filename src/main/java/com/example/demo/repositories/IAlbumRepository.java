package com.example.demo.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Album;

@Repository
public interface IAlbumRepository extends JpaRepository<Album, UUID> {

}
