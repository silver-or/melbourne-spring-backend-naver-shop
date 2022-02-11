package net.zerotoweb.api.member.service;

/**
 * packageName: net.zerotoweb.api.member.service
 * fileName   : MemberService
 * author     : 최은아
 * date       : 2022-02-11
 * desc       :
 * ================================
 * DATE          AUTHOR        NOTE
 * ================================
 * 2022-02-11    최은아       최초 생성
 */
public interface MemberService {
    String membershipList();
    String viewMembershipInformation();
    String viewSendList();
    String registerSendMail();
    String listOfPoints();
    String viewDetailsOfPointsAndSaveAndDelete();
}
