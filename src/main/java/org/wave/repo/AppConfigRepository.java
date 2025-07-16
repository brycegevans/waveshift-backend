package org.wave.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.wave.model.AppConfig;

@Repository
public interface AppConfigRepository extends JpaRepository<AppConfig, String> {

}
