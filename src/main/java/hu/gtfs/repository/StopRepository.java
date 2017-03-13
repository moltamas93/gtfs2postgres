package hu.gtfs.repository;

import hu.gtfs.model.Stop;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Tamas on 2017.03.07..
 */
public interface StopRepository extends JpaRepository<Stop, String> {
}
