package fereusz.InformationFlow.services.impl;

import fereusz.InformationFlow.domain.entities.FundManager;
import fereusz.InformationFlow.domain.entities.User;
import fereusz.InformationFlow.domain.repositories.FundManagerRepository;
import fereusz.InformationFlow.domain.repositories.UserRepository;
import fereusz.InformationFlow.dtos.FundManagerDTO;
import fereusz.InformationFlow.services.FundManagerCreateService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
