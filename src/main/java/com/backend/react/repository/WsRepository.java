package com.backend.react.repository;

import com.backend.react.model.WsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WsRepository extends JpaRepository<WsModel, Long> {
}
