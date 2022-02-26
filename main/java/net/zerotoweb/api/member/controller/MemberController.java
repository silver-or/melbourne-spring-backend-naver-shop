package net.zerotoweb.api.member.controller;

import lombok.RequiredArgsConstructor;
import net.zerotoweb.api.member.domain.AlgoDTO;
import net.zerotoweb.api.member.domain.CalcDTO;
import net.zerotoweb.api.member.domain.MemberDTO;
import net.zerotoweb.api.member.service.MemberService;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/member") // 컨트롤러 (플랫폼)
public class MemberController {
    private final MemberService service; // DB에서 가져오는 값은 상수

    @PostMapping("/calc")
    public String calc(@RequestBody CalcDTO calc) {
        return service.calc(calc);
    }

    @PostMapping("/bmi")
    public String getBmi(@RequestBody MemberDTO member) {
        return service.getBmi(member);
    }

    @PostMapping("/grade")
    public String getGrade(@RequestBody MemberDTO member) {
        return service.getGrade(member);
    }

    @PostMapping("/login")
    public String login(@RequestBody MemberDTO member) {
        return service.login(member);
    }

    @PostMapping("/lotto")
    public String lotto(@RequestBody AlgoDTO algo) {
        return service.lotto(algo);
    }
}
