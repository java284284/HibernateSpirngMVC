package tw.hibernatedemo.service;

import java.util.List;

import org.hibernate.Session;

import tw.hibernatedemo.model.CompanyBean;
import tw.hibernatedemo.model.CompanyDao;

public class CompanyService implements CompanyServiceInterface {
	
	private CompanyDao comDao;
	
	public CompanyService(Session session) {
		this.comDao = new CompanyDao(session);
	}

	@Override
	public CompanyBean select(int id) {
		CompanyBean comBean =  comDao.select(id);
		return comBean;
	}

	@Override
	public List<CompanyBean> selectAll() {
		List<CompanyBean> allCompany = comDao.selectAll();
		return allCompany;
	}

	@Override
	public CompanyBean insert(CompanyBean comBean) {
		return comDao.insert(comBean);
	}

	@Override
	public CompanyBean updateOne(int comId, String newName) {
		return comDao.updateOne(comId, newName);
	}

	@Override
	public boolean delete(int comId) {
		return comDao.delete(comId);
	}

}
