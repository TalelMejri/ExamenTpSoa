package org.dsi.repo;

import org.dsi.entity.PhotoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface photoRepo extends JpaRepository<PhotoEntity, Long> {

}
