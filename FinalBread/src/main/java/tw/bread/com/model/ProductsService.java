package tw.bread.com.model;

import java.io.FileInputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductsService {

	@Autowired
	private ProductsDao pDao;

	public List<Products> readAllProducts() {
		return pDao.getAll();
	}

	public List<Products> searchProducts(String search) {
		return pDao.searchProduct(search);
	}
	
	public Products sProduct(int id) {
		return pDao.sProduct(id);
	}

	public Products addProduct(String name, int price,byte[] photo) {
		return pDao.addProduct(name, price,photo);
	}

	public boolean deleteProduct(int id) {
		return pDao.deleteProduct(id);
	}
	
	public Products updateProduct(int id, String newName, int newPrice, byte[] newPhoto) {
		return pDao.updateProduct(id, newName, newPrice, newPhoto);
	}
	
}
