package net.zerotoweb.api.member.repository;

import net.zerotoweb.api.member.domain.AlgoDTO;
import net.zerotoweb.api.member.domain.CalcDTO;
import net.zerotoweb.api.member.domain.MemberDTO;
import org.springframework.stereotype.Repository;

/**
 * packageName: net.zerotoweb.api.member.repository
 * fileName   : MemberRepositoryImpl
 * author     : 최은아
 * date       : 2022-02-11
 * desc       :
 * ================================
 * DATE          AUTHOR        NOTE
 * ================================
 * 2022-02-11    최은아       최초 생성
 */
@Repository
public class MemberRepositoryImpl implements MemberRepository{
    // DB 연결하는 코드
    @Override
    public String calc(CalcDTO calc) {
        return null;
    }

    @Override
    public String getBmi(MemberDTO member) {
        return null;
    }

    @Override
    public String getGrade() {
        return null;
    }

    @Override
    public String login(MemberDTO member) {
        return null;
    }

    @Override
    public String lotto(AlgoDTO algo) {
        return null;
    }
}
