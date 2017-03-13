package hu.gtfs.repository;

import hu.gtfs.model.FeedInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Tamas on 2017.03.07..
 */
@Repository
public interface FeedInfoRepository extends JpaRepository<FeedInfo, String> {
}
