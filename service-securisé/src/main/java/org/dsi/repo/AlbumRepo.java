package org.dsi.repo;

import org.dsi.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepo extends JpaRepository<Album, Long> {

}
