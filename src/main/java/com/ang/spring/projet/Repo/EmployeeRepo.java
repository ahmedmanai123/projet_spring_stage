package com.ang.spring.projet.Repo;

import com.ang.spring.projet.Dto.EmployeeDto;
import com.ang.spring.projet.Models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

    //@Query("SELECT e FROM Employee e WHERE e.nom LIKE %:nom%")
//    OR e.matricle LIKE %:matricle%
   List<Employee> findByNomOrMatricle(@Param("nom") String nom, @Param("matricle") String matricle);
    @Query("SELECT e FROM Employee e WHERE e.nom LIKE %:nom%")
    List<Employee> findBynom(@Param("nom") String nom);
}




