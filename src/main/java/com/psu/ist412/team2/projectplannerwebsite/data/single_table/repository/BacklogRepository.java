package com.psu.ist412.team2.projectplannerwebsite.data.single_table.repository;

import com.psu.ist412.team2.projectplannerwebsite.data.single_table.entity.Backlog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BacklogRepository extends JpaRepository<Backlog, Short> {
}
