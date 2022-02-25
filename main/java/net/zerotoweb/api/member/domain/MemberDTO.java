package net.zerotoweb.api.member.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * packageName: net.zerotoweb.api.member.domain
 * fileName   : MemberDTO
 * author     : 최은아
 * date       : 2022-02-11
 * desc       :
 * ================================
 * DATE          AUTHOR        NOTE
 * ================================
 * 2022-02-11    최은아       최초 생성
 */
@Data // getter/setter 자동 코딩
@Component // 싱글톤 자동 코딩
public class MemberDTO {
    private String userId;
    private String name;
    private String address;
    private String phone;
    private double height;
    private double weight;
    private String regDate;
    private int kor;
    private int eng;
    private int math;
}
