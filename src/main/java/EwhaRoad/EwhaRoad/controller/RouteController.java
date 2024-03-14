package EwhaRoad.EwhaRoad.controller;

import EwhaRoad.EwhaRoad.domain.Route;
import EwhaRoad.EwhaRoad.service.RouteService;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class RouteController {

    private final RouteService routeService;

    @Autowired
    public RouteController(RouteService routeService){
        this.routeService = routeService;

    }

    /*SECTION5-1*/
    //get은 주로 조회할 때 사용
    @GetMapping("/routes/new")
    public String createForm(){
        return "routes/createRouteForm";
    }

    /*Section5-2*/
    //post는 데이터를 form에 넣어서 전달할 때 사용
    //html에서 method:post 이므로 여기로 이동
    @PostMapping("/routes/new")/*게시할 때 사용*/
    public String create(RouteForm form){
        Route route = new Route();
        route.setDestination(form.getDestination());

        //System.out.println("route : " + route.getDestination());//form에서 getName으로 출력

        routeService.join(route);

        return "redirect:/";    //home 화면으로 돌아가도록
    }

    /*Section 5-3*/
    @GetMapping("/routes")
    public String List(Model model){
        List<Route> routes = routeService.findRoutes();
        model.addAttribute("routes", routes);
        return "routes/routeList";

    }

}
