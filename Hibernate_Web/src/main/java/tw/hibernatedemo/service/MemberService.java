package tw.hibernatedemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.hibernatedemo.model.MemberDao;
import tw.hibernatedemo.model.MyMember;

@Service
public class MemberService {
	
	@Autowired
	private MemberDao mDao;
	
//	public MemberService() {
//		this.mDao = new MemberDao();
//	}
	
	public MyMember checkLogin(String loginUser, String loginPwd) {
		MyMember member = mDao.findByUsernameAndPassword(loginUser, loginPwd);
		
		if(member != null) {
			return member;
		}
		
		return null;
	}

}