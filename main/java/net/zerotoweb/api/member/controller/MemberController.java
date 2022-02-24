package net.zerotoweb.api.member.controller;

import lombok.RequiredArgsConstructor;
import net.zerotoweb.api.member.domain.MemberDTO;
import net.zerotoweb.api.member.service.MemberService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * packageName: net.zerotoweb.api.member.controller
 * fileName   : MemberController
 * author     : 최은아
 * date       : 2022-02-11
 * desc       :
 * ================================
 * DATE          AUTHOR        NOTE
 * ================================
 * 2022-02-11    최은아       최초 생성
 */
@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService service; // DB에서 가져오는 값은 상수

    @GetMapping("/member/bmi/{name}/{height}/{weight}") // URL (프로토콜)
    public String getBmi(@PathVariable String name,
                         @PathVariable double height,
                         @PathVariable double weight) {
        // 가비지콜렉터에게 m을 지우라는 뜻
        // 넘어온 데이터만 담아라.
        // new MemberDTO();와 동일한 뜻 → new는 로컬 변수로만 사용 가능 (인스턴스 변수 사용 불가)
        System.out.println("리액트에서 넘어온 이름 : " + name);
        System.out.println("리액트에서 넘어온 키 : " + height);
        System.out.println("리액트에서 넘어온 몸무게 : " + weight);
        return "BMI는 정상";
    }
}
