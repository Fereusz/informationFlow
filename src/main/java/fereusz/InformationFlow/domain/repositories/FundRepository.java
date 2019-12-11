package fereusz.InformationFlow.domain.repositories;

import fereusz.InformationFlow.domain.entities.Fund;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FundRepository extends JpaRepository<Fund,Long> {

}
