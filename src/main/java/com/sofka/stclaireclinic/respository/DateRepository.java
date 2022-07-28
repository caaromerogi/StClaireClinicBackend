package com.sofka.stclaireclinic.respository;

import com.sofka.stclaireclinic.entity.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DateRepository extends JpaRepository<Date, Long> {
}
