package likelion_backend.OnSiL.domain.map.repository;

import likelion_backend.OnSiL.domain.map.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LocationJpaRepository extends JpaRepository<Location,Long> {


}
