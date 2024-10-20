package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		SellerDao sellerDao = DaoFactory.createSellerDao();

		System.out.println("=== Test 1: seller findById ===");
		Seller seller = sellerDao.findById(2);
		System.out.println(seller);

		System.out.println();

		System.out.println("=== Test 2: seller findByDepartment ===");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for (Seller obj : list) {
			System.out.println(obj);
		}

		System.out.println();

		System.out.println("=== Test 3: seller findAll ===");
		list = sellerDao.findAll();
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println();

		System.out.println("=== Test 4: seller insert ===");
		Seller newSeller = new Seller(null, "Aloysio", "aloysio@gmail.com", new Date(), 8000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New Id = " + newSeller.getId());
		
		System.out.println();

		System.out.println("=== Test 5: seller update ===");
		seller = sellerDao.findById(1);
		seller.setName("Marth wayne");
		sellerDao.update(seller);
		System.out.print("Update completed!");
	}

}
