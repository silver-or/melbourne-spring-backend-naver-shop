package net.zerotoweb.api.member.service;

import lombok.RequiredArgsConstructor;
import net.zerotoweb.api.member.domain.CalcDTO;
import net.zerotoweb.api.member.domain.MemberDTO;
import net.zerotoweb.api.member.repository.MemberRepository;
import org.springframework.stereotype.Service;

/**
 * packageName: net.zerotoweb.api.member.service
 * fileName   : MemberServiceImpl
 * author     : 최은아
 * date       : 2022-02-11
 * desc       :
 * ================================
 * DATE          AUTHOR        NOTE
 * ================================
 * 2022-02-11    최은아       최초 생성
 */
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{
    private final MemberRepository repository;

    @Override
    public String calc(CalcDTO calc) {
        int num1 = calc.getNum1();
        String opcode = calc.getOpcode();
        int num2 = calc.getNum2();
        int result = 0;
        switch (opcode) {
            case "+" : result = num1 + num2; break;
            case "-" : result = num1 - num2; break;
            case "*" : result = num1 * num2; break;
            case "/" : result = num1 / num2; break;
            case "%" : result = num1 % num2; break;
        }
        return String.format("%d %s %d = %d", num1, opcode, num2, result);
    }

    @Override
    public String getBmi(MemberDTO member) {
        double height = member.getHeight();
        double weight = member.getWeight();
        double bmi = weight / (height*height) * 10000;
        String result = "";
        if (bmi <= 18.5) { result = "저체중"; }
        else if (bmi < 23.0) { result = "정상"; }
        else if (bmi < 25.0) { result = "과체중"; }
        else { result = "비만"; }
        return String.format("%s 님의 bmi 지수는 %.2f, %s 입니다.", member.getName(), bmi, result);
    }

    @Override
    public String getGrade(MemberDTO member) {
        int kor = member.getKor();
        int eng = member.getEng();
        int math = member.getMath();
        double avg = (kor + eng + math) / 3.0;
        String result = "";
        if (avg >= 90.0) { result = "A"; }
        else if (avg >= 80.0) { result = "B"; }
        else if (avg >= 70.0) { result = "C"; }
        else if (avg >= 60.0) { result = "D"; }
        else { result = "F"; }
        return String.format("[성적표] 이름 : %s, 국어 점수 : %d, 영어 점수 : %d, 수학 점수 : %d, 평균 : %.2f, 학점 : %s",
                            member.getName(), kor, eng, math, avg, result);
    }
}
