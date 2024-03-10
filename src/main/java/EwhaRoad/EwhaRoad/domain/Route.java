package EwhaRoad.EwhaRoad.domain;
// member.java 참고

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;


//@Entity
public class Route {

    //@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String destination;
    private String startingpoint;
    private String route;
    private String emoji0;
    private String text1;
    private String emoji1;
    private String text2;
    private String emoji2;
    private String text3;
    private String emoji3;
    private String text4;
    private String emoji4;
    private String text5;
    private String emoji5;
    private String text6;
    private String emoji6;
    private String text7;
    private String emoji7;

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getStartingPoint() {
        return startingpoint;
    }

    public void setStartingPoint(String startingpoint) {
        this.startingpoint = startingpoint;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getEmoji0() {
        return emoji0;
    }

    public void setEmoji0(String emoji0) {
        this.emoji0 = emoji0;
    }

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public String getEmoji1() {
        return emoji1;
    }

    public void setEmoji1(String emoji1) {
        this.emoji1 = emoji1;
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }

    public String getEmoji2() {
        return emoji2;
    }

    public void setEmoji2(String emoji2) {
        this.emoji2 = emoji2;
    }

    public String getText3() {
        return text3;
    }

    public void setText3(String text3) {
        this.text3 = text3;
    }

    public String getEmoji3() {
        return emoji3;
    }

    public void setEmoji3(String emoji3) {
        this.emoji3 = emoji3;
    }

    public String getText4() {
        return text4;
    }

    public void setText4(String text4) {
        this.text4 = text4;
    }

    public String getEmoji4() {
        return emoji4;
    }

    public void setEmoji4(String emoji4) {
        this.emoji4 = emoji4;
    }

    public String getText5() {
        return text5;
    }

    public void setText5(String text5) {
        this.text5 = text5;
    }

    public String getEmoji5() {
        return emoji5;
    }

    public void setEmoji5(String emoji5) {
        this.emoji5 = emoji5;
    }

    public String getText6() {
        return text6;
    }

    public void setText6(String text6) {
        this.text6 = text6;
    }

    public String getEmoji6() {
        return emoji6;
    }

    public void setEmoji6(String emoji6) {
        this.emoji6 = emoji6;
    }

    public String getText7() {
        return text7;
    }

    public void setText7(String text7) {
        this.text7 = text7;
    }

    public String getEmoji7() {
        return emoji7;
    }

    public void setEmoji7(String emoji7) {
        this.emoji7 = emoji7;
    }
}
