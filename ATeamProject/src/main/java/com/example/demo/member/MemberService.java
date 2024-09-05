package com.example.demo.member;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberService { //회원정보를 저장
	private final MemberRepository mr;

	
	public void create(String email1, String email2, String password, String mname 
			, String tel_no, String nickname, String birth 
			, String profile_img, String category, String instructor_yn) {
		
		Member m = new Member();
		m.setMemberId(email1+'@'+email2);
		m.setPassword(password);
		m.setMname(mname);
		m.setTelNo(tel_no);
		m.setBirth(birth);
		m.setNickname(nickname);
		m.setCreateDate(LocalDateTime.now());
		m.setProfileImg(profile_img);
		m.setCategory(category);
		m.setInstructorYn(instructor_yn);
		m.setLastUpdateDate(LocalDateTime.now());
		
		this.mr.save(m);
	}
	
	//예외처리 : 존재하지 않는 유저
	public Member getUser(String member_id) throws nosignException {
		Optional<Member> member = this.mr.findByMemberId(member_id);
		if(member.isPresent()) {
			return member.get();
		}
		else {
			throw new nosignException("존재하지 않는 유저입니다");
		}
	}
	


	
	
	
}
