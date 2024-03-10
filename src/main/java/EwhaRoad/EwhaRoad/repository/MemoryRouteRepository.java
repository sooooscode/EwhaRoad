package EwhaRoad.EwhaRoad.repository;
//MemoryMemberRepository 참고
import EwhaRoad.EwhaRoad.domain.Route;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryRouteRepository implements RouteRepository {

    private static Map<Long, Route> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Route save(Route route) {

        route.setId(++sequence);
        store.put(route.getId(),route);
        return route;
    }

    @Override
    public Optional<Route> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Route> findByDestination(String destination) {
        return store.values().stream()
                .filter(route -> route.getDestination().equals(destination))
                .findAny();
    }

    @Override
    public Optional<Route> findByStartingPoint(String startingpoint) {
        return store.values().stream()
                .filter(route -> route.getStartingPoint().equals(startingpoint))
                .findAny();
    }

    @Override
    public List<Route> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
