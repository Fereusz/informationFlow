package fereusz.InformationFlow.services.impl;

import fereusz.InformationFlow.domain.entities.Fund;
import fereusz.InformationFlow.domain.entities.User;
import fereusz.InformationFlow.domain.repositories.FundRepository;
import fereusz.InformationFlow.domain.repositories.UserRepository;
import fereusz.InformationFlow.dtos.FundCreateDTO;
import fereusz.InformationFlow.services.FundCreateService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DefaultFundCreateService implements FundCreateService {

    private final FundRepository fundRepository;
    private final UserRepository userRepository;

    public DefaultFundCreateService(FundRepository fundRepository, UserRepository userRepository) {
        this.fundRepository = fundRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void create(FundCreateDTO fundCreateDTO) {
        ModelMapper mapper = new ModelMapper();
        User user = userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        Fund fund = mapper.map(fundCreateDTO, Fund.class);
        fund.setUser(user);
        fundRepository.save(fund);


    }
}
