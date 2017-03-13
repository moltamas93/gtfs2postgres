package hu.gtfs.repository;

import hu.gtfs.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Tamas on 2017.03.05..
 */
public interface TripRepository extends JpaRepository<Trip, String> {
}
