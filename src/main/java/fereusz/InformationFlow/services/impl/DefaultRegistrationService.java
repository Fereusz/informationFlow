package fereusz.InformationFlow.services.impl;

import fereusz.InformationFlow.domain.entities.Role;
import fereusz.InformationFlow.domain.entities.User;
import fereusz.InformationFlow.domain.repositories.RoleRepository;
import fereusz.InformationFlow.domain.repositories.UserRepository;
import fereusz.InformationFlow.dtos.RegistrationDataDTO;
import fereusz.InformationFlow.services.RegistrationService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service // dzieki temu bedzie wstrzykiwalny
@Transactional
public class DefaultRegistrationService implements RegistrationService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public DefaultRegistrationService(PasswordEncoder passwordEncoder, UserRepository userRepository, RoleRepository roleRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void register(RegistrationDataDTO registrationData) {
        ModelMapper mapper = new ModelMapper();
        User user = mapper.map(registrationData, User.class);
        user.setActive(Boolean.TRUE);
        String encoded = passwordEncoder.encode(registrationData.getPassword());
        user.setPassword(encoded);
        Role roleUser = roleRepository.getByName("ROLE_USER");
        user.getRoles().add(roleUser);
        userRepository.save(user);


    }
}
