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
        return String.format("[성적표]\n이름 : %s\n국어 점수 : %d\n영어 점수 : %d\n수학 점수 : %d\n평균 : %.2f\n학점 : %s",
                            member.getName(), kor, eng, math, avg, result);
    }

    @Override
    public String login(MemberDTO member) {
        String userId = member.getUserId();
        String pw = member.getPw();
        return pw.equals(MemberDTO.PASSWORD) ? String.format("%s 님의 비번은 %s 가 맞습니다. 로그인 성공", userId, pw)
                : String.format(("%s 님의 ID는 맞고, 비번은 %s 가 아닙니다. 로그인 실패"), userId, pw);
    }

    @Override
    public String lotto(MemberDTO member) {
        int[] answer = new int[6];
        int[] userNum = member.getNumbers();
        int num = 0;
        int count = 0;
        boolean duplicate;
        String result = "";
        for (int i = 0; i < answer.length; i++) {
            duplicate = true;
            while (duplicate) {
                num = (int) (Math.random() * 45) + 1;
                duplicate = false;
                for (int j = 0; j < i; j++) {
                    if (answer[j] == num) {
                        duplicate = true;
                        break;
                    }
                }
            }
            answer[i] = num;
        }
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (answer[i] == userNum[j]) count++;
            }
        }
        result += "이번주 로또 당첨 번호 : ";
        for (int i = 0; i < 6; i++) {
            result += answer[i] + " ";
        }
        result += "\n사용자의 로또 번호 : ";
        for (int i = 0; i < 6; i++) {
            result += userNum[i] + " ";
        }
        switch (count) {
            case 6 : result += "\n축하합니다. 1등입니다."; break;
            case 5 : result += "\n2등입니다."; break;
            case 4 : result += "\n3등입니다."; break;
            default : result += "\n당첨되지 않았습니다."; break;
        }
        return result;
    }
}
