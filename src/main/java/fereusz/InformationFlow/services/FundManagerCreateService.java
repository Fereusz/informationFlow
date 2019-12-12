package fereusz.InformationFlow.services;

import fereusz.InformationFlow.domain.entities.FundManager;
import fereusz.InformationFlow.dtos.FundManagerDTO;
import fereusz.InformationFlow.dtos.ManagerEditDTO;

import java.util.List;

public interface FundManagerCreateService {

    void create (FundManagerDTO fundManagerDTO);

    List<FundManager> findAll();
    ManagerEditDTO prepareUpdate (Long id);
    void save(ManagerEditDTO managerEditDTO);
    void delete(Long id);

}
