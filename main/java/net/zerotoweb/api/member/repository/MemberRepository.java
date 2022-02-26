package net.zerotoweb.api.member.repository;

import net.zerotoweb.api.member.domain.AlgoDTO;
import net.zerotoweb.api.member.domain.CalcDTO;
import net.zerotoweb.api.member.domain.MemberDTO;

/**
 * packageName: net.zerotoweb.api.member.repository
 * fileName   : MemberRepository
 * author     : 최은아
 * date       : 2022-02-11
 * desc       :
 * ================================
 * DATE          AUTHOR        NOTE
 * ================================
 * 2022-02-11    최은아       최초 생성
 */

public interface MemberRepository {
    String calc(CalcDTO calc);

    String getBmi(MemberDTO member);

    String getGrade();

    String login(MemberDTO member);

    String lotto(AlgoDTO algo);
}
