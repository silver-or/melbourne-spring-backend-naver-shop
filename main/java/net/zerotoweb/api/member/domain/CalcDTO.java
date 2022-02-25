package net.zerotoweb.api.member.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * packageName: net.zerotoweb.api.member.domain
 * fileName   : CalcDTO
 * author     : 최은아
 * date       : 2022-02-25
 * desc       :
 * ================================
 * DATE          AUTHOR        NOTE
 * ================================
 * 2022-02-25    최은아       최초 생성
 */
@Data
@Component
public class CalcDTO {
    private int num1;
    private String opcode;
    private int num2;
}
