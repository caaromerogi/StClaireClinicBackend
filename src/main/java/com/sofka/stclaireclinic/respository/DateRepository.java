package com.sofka.stclaireclinic.respository;

import com.sofka.stclaireclinic.entity.Date;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DateRepository extends JpaRepository<Date, Long> {
}
