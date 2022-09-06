package tw.hibernatedemo.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class CompanyDao implements CompanyDaoInterface{
	
	private Session session;
	
	public CompanyDao(Session session) {
		this.session = session;
	}

	@Override
	public CompanyBean insert(CompanyBean comBean) {
		CompanyBean companyBean = session.get(CompanyBean.class, comBean.getCompanyId());
		
		if(companyBean == null) {
			session.save(comBean);
			return comBean;
		}
		
		return null;
	}

	@Override
	public CompanyBean select(int id) {
		return session.get(CompanyBean.class, id);
	}

	@Override
	public List<CompanyBean> selectAll() {
		Query<CompanyBean> query = session.createQuery("from CompanyBean", CompanyBean.class);
		return query.list();
	}

	@Override
	public CompanyBean updateOne(int comId, String newName) {
		CompanyBean comBean = session.get(CompanyBean.class, comId);
		
		if(comBean != null) {
			comBean.setCompanyName(newName);
		}
		
		return comBean;
	}

	@Override
	public boolean delete(int comId) {
		CompanyBean comBean = session.get(CompanyBean.class, comId);
		
		if(comBean != null) {
			session.delete(comBean);
			return true;
		}
		
		return false;
	}

	

}
