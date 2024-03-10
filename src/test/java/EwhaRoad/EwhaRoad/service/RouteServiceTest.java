package EwhaRoad.EwhaRoad.service;

import EwhaRoad.EwhaRoad.domain.Route;
import EwhaRoad.EwhaRoad.repository.MemoryRouteRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

//ctrl shift t:하면 testcase 껍데기를 자동으로 생성



class RouteServiceTest { // 수정

    RouteService routeService; // 수정
    MemoryRouteRepository routeRepository; // 수정

    @BeforeEach
    public void beforeEach(){
        routeRepository = new MemoryRouteRepository(); // 수정
        routeService = new RouteService(routeRepository); // 수정
    }

    @AfterEach
    public void afterEach(){
        routeRepository.clearStore(); // 수정
    }

    @Test
    void 회원가입() {
        //given

        Route route = new Route(); // 수정
        route.setDestination("spring");    //값이 spring이면 db에 값이 누적되므로 에러:이미 존재하는 회원>> clear를 하면 spring이어도 에러X

        //when
        Long saveId = routeService.join(route); // 수정

        //then
        Route findRoute = routeService.findOne(saveId).get(); // 수정
        assertThat(route.getDestination()).isEqualTo(findRoute.getDestination()); //Assertions 두번째꺼: assertj
    }

    @Test
    public void 중복_회원_예외(){
        //given
        Route route1 = new Route(); // 수정
        route1.setDestination("spring");

        Route route2 = new Route(); // 수정
        route2.setDestination("spring");

        //when
        routeService.join(route1);    //에러 x
        //assertThrows(IllegalStateException.class, () -> routeService.join(route2));   //성공
        //assertThrows(NullPointerException.class, () -> routeService.join(route2));  //테스트 실패
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> routeService.join(route2));//ctrl alt v

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원");

        //then
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}
