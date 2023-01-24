package com.example.football.repository;

import com.example.football.pojos.Stadium;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StadiumRepository extends CrudRepository<Stadium, Long> {

    Stadium findStadiumById(long id);
}