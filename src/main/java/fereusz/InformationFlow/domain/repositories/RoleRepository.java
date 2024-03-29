package fereusz.InformationFlow.domain.repositories;

import fereusz.InformationFlow.domain.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role getByName(String name);
}
