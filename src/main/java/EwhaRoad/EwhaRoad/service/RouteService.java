package EwhaRoad.EwhaRoad.service;

import EwhaRoad.EwhaRoad.domain.Route;
import EwhaRoad.EwhaRoad.repository.RouteRepository;
import EwhaRoad.EwhaRoad.repository.MemoryRouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RouteService {

    private final RouteRepository routeRepository;

    @Autowired
    public RouteService(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    /**
     * 경로 등록
     */
    public Long join(Route route) {
        validateDuplicateRoute(route);//중복회원검증
        routeRepository.save(route);
        return route.getId();
    }

    private void validateDuplicateRoute(Route route) {
        routeRepository.findByStartingPoint(route.getStartingPoint())
                .ifPresent(r -> {
                    throw new IllegalStateException("이미 존재하는 경로");
                });
    }

    /**
     * 전체 경로 조회
     */
    public List<Route> findRoutes() {
        return routeRepository.findAll();
    }

    public Optional<Route> findOne(Long routeId) {
        return routeRepository.findById(routeId);
    }
}
