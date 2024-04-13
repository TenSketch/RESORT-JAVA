package com.tensketch.cottageType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CottageTypeRepository extends JpaRepository<CottageType, Long> {
}
