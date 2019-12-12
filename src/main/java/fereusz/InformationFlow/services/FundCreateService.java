package fereusz.InformationFlow.services;

import fereusz.InformationFlow.domain.entities.Fund;
import fereusz.InformationFlow.dtos.FundCreateDTO;

import java.util.List;

public interface FundCreateService {

    void create (FundCreateDTO fundCreateDTO);
    List<Fund> findAll();
}
