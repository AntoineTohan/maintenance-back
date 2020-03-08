package com.opendata.back.opendataback.repository;

import com.opendata.back.opendataback.entity.Data;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataRepository extends JpaRepository<Data, Long> {

}
