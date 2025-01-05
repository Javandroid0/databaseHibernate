package com.javandroid.databasehibernate.Repo;

import com.javandroid.databasehibernate.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}

