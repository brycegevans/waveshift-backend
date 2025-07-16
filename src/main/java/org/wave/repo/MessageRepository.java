package org.wave.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.wave.model.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
}
