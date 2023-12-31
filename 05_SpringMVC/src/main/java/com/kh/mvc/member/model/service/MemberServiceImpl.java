package com.kh.mvc.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.mvc.member.model.mapper.MemberMapper;
import com.kh.mvc.member.model.vo.Member;

@Service
// @Transactional
public class MemberServiceImpl implements MemberService {
//	@Autowired
//	private MemberMapper dao;
	
//	@Autowired
//	private SqlSession session;
	
	@Autowired
	private MemberMapper mapper;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public Member findMemberById(String id) {
		
		return mapper.selectMemberById(id);
	}
	
	@Override
	public Member login(String id, String password) {
		Member member = null;
		
		member = this.findMemberById(id);
		
		// 매번 랜덤한 솔트값을 가지고 암호화 하기 때문에 매번 다른 값으로 암호화 된다.
//		System.out.println(passwordEncoder.encode(password));
		
		// matches() 메소드를 사용하면 내부적으로 복화화해서 나온 결과 값에 솔트값을 땐 나머지 값과 원문을 비교한다.
//		System.out.println(passwordEncoder.matches(password, member.getPassword()));
		
		if (member != null && passwordEncoder.matches(password, member.getPassword())) {			
			return member;
		} else {
			return null;
		}
	}

	@Override
	@Transactional
	public int save(Member member) {
		int result = 0;
		
		if(member.getNo() > 0) {
			// update
			result = mapper.updateMember(member);
		} else {
			// insert
			member.setPassword(passwordEncoder.encode(member.getPassword()));
			
			result = mapper.insertMember(member);
		}
		
//		if(true) {
//			throw new RuntimeException();
//		}
		
		return result;
	}

	@Override
	public Boolean isDuplicateId(String id) {
		
		return this.findMemberById(id) != null;
	}

	@Override
	@Transactional
	public int delete(int no) {
		
		return mapper.updateMemberStatus(no, "N");
	}
}
