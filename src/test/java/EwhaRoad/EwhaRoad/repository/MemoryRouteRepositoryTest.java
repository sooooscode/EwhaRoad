package EwhaRoad.EwhaRoad.repository;

import EwhaRoad.EwhaRoad.domain.Route;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

class MemoryRouteRepositoryTest {

    MemoryRouteRepository repository = new MemoryRouteRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        Route route = new Route();
        route.setDestination("우리집");

        repository.save(route);

        Route result = repository.findById(route.getId()).get();
        //Assertions.assertEquals(route, null);
        assertThat(route).isEqualTo(result);

    }

    @Test
    public void findByDestination(){

        Route route1 = new Route();
        route1.setDestination("이화여대");
        repository.save(route1);

        Route route2 = new Route();
        route2.setDestination("운정고");
        repository.save(route2);

        List<Route> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);

    }

}
