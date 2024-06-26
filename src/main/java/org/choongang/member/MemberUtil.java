package org.choongang.member;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.choongang.global.config.annotations.Component;
import org.choongang.member.constants.UserType;
import org.choongang.member.entities.Member;

@Component
@RequiredArgsConstructor
public class MemberUtil {
    private final HttpSession session;
    public boolean isLogin(){
        return getMember() != null;
    }
    public boolean isAdmin(){
        if(isLogin()){
            Member member = getMember();
            return member.getUserType()== UserType.ADMIN;
        }
        return false;
    }

    public Member getMember(){
        Member member = (Member) session.getAttribute("member");
        return member;
    }
}
