package EwhaRoad.EwhaRoad.repository;
//MemberRepository(interface) 참고
import EwhaRoad.EwhaRoad.domain.Route;

import java.util.List;
import java.util.Optional;

public interface RouteRepository {
    Route save(Route route);
    Optional<Route> findById(Long id);
    List<Route> findAll();

    // 특정 명칭으로 루트 찾기
    Optional<Route> findByDestination(String destination);
    Optional<Route> findByStartingPoint(String startingpoint);
}
