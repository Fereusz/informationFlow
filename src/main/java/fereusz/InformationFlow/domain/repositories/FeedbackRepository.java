package fereusz.InformationFlow.domain.repositories;

import fereusz.InformationFlow.domain.entities.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback,Long> {

}
