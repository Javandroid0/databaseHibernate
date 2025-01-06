package com.javandroid.databasehibernate.Repo;

import com.javandroid.databasehibernate.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}

