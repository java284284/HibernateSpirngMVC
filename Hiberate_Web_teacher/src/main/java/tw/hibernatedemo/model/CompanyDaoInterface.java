package tw.hibernatedemo.model;

import java.util.List;

public interface CompanyDaoInterface {
	CompanyBean insert(CompanyBean comBean);
	CompanyBean select(int id);
	List<CompanyBean> selectAll();
	CompanyBean updateOne(int comId, String newName);
	boolean delete(int comId);
}
