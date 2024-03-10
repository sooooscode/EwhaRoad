package EwhaRoad.EwhaRoad;

/*import EwhaRoad.EwhaRoad.repository.MemoryRouteRepository;
import EwhaRoad.EwhaRoad.service.RouteService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;*/

import EwhaRoad.EwhaRoad.repository.RouteRepository;
import EwhaRoad.EwhaRoad.repository.MemoryRouteRepository;
import EwhaRoad.EwhaRoad.service.RouteService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public RouteService routeService(){
        return new RouteService(routeRepository());
    }

    @Bean
    public RouteRepository routeRepository(){
        return new MemoryRouteRepository();
    }
}
