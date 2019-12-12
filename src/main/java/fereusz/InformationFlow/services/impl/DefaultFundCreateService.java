package fereusz.InformationFlow.services.impl;

import fereusz.InformationFlow.domain.entities.Feedback;
import fereusz.InformationFlow.domain.entities.Fund;
import fereusz.InformationFlow.domain.entities.User;
import fereusz.InformationFlow.domain.repositories.FundRepository;
import fereusz.InformationFlow.domain.repositories.UserRepository;
import fereusz.InformationFlow.dtos.FeedbackEditDTO;
import fereusz.InformationFlow.dtos.FundCreateDTO;
import fereusz.InformationFlow.dtos.FundEditDTO;
import fereusz.InformationFlow.services.FundCreateService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;

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

    @Override
    public List<Fund> findAll() {
        return fundRepository.findAll();
    }

    @Override
    public FundEditDTO prepareUpdate(Long id) {
        Optional<Fund> fund = fundRepository.findById(id);
        ModelMapper mapper = new ModelMapper();
        FundEditDTO fundToEdit = mapper.map(fund, FundEditDTO.class);
        return fundToEdit;

    }

    @Override
    public void save(FundEditDTO fundEditDTO) {
        ModelMapper mapper = new ModelMapper();
        Fund fund = mapper.map(fundEditDTO, Fund.class);
        fundRepository.save(fund);

    }

    @Override
    public void delete(Long id) {fundRepository.deleteById(id);
    }


}

