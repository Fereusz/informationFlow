package fereusz.InformationFlow.services.impl;

import fereusz.InformationFlow.domain.entities.Fund;
import fereusz.InformationFlow.domain.entities.FundManager;
import fereusz.InformationFlow.domain.entities.User;
import fereusz.InformationFlow.domain.repositories.FundManagerRepository;
import fereusz.InformationFlow.domain.repositories.UserRepository;
import fereusz.InformationFlow.dtos.FundEditDTO;
import fereusz.InformationFlow.dtos.FundManagerDTO;
import fereusz.InformationFlow.dtos.ManagerEditDTO;
import fereusz.InformationFlow.services.FundManagerCreateService;
import org.apache.catalina.Manager;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DefaultFundManagerCreateService implements FundManagerCreateService {

    private final FundManagerRepository fundManagerRepository;
    private final UserRepository userRepository;

    public DefaultFundManagerCreateService(FundManagerRepository fundManagerRepository, UserRepository userRepository) {
        this.fundManagerRepository = fundManagerRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void create(FundManagerDTO fundManagerDTO) {
        ModelMapper mapper = new ModelMapper();
        User user = userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        FundManager fundManager = mapper.map(fundManagerDTO, FundManager.class);
        fundManager.setUser(user);
        fundManagerRepository.save(fundManager);


    }

    @Override
    public List<FundManager> findAll() {
       return fundManagerRepository.findAll();
    }

    @Override
    public ManagerEditDTO prepareUpdate(Long id) {
        Optional<FundManager> manager = fundManagerRepository.findById(id);
        ModelMapper mapper = new ModelMapper();
        ManagerEditDTO managerToEdit = mapper.map(manager, ManagerEditDTO.class);
        return managerToEdit;
    }

    @Override
    public void save(ManagerEditDTO managerEditDTO) {
        ModelMapper mapper = new ModelMapper();
        FundManager manager = mapper.map(managerEditDTO, FundManager.class);
        fundManagerRepository.save(manager);
    }



    @Override
    public void delete(Long id) {
        fundManagerRepository.deleteById(id);

    }


}
