package org.wave.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.wave.model.Activity;

@Repository
public interface ActivityRepository extends JpaRepository<Activity,Long> {
}
