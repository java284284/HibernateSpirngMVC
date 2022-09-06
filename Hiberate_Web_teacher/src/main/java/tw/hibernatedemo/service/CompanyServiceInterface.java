package tw.hibernatedemo.service;

import java.util.List;

import tw.hibernatedemo.model.CompanyBean;

public interface CompanyServiceInterface {
	public CompanyBean select(int id);
	public List<CompanyBean> selectAll();
	public CompanyBean insert(CompanyBean comBean);
    public CompanyBean updateOne(int comId, String newName);
    public boolean delete(int comId);
}
