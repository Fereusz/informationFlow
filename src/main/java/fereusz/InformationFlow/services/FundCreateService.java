package fereusz.InformationFlow.services;

import fereusz.InformationFlow.domain.entities.Fund;
import fereusz.InformationFlow.dtos.FundCreateDTO;
import fereusz.InformationFlow.dtos.FundEditDTO;

import java.util.List;

public interface FundCreateService {

    void create (FundCreateDTO fundCreateDTO);
    List<Fund> findAll();
    FundEditDTO prepareUpdate(Long id);

    void save (FundEditDTO fundEditDTO);
    void delete(Long id);

}
