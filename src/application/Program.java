package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;

public class Program {

    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("=== TESTE 1: findByID ===");
        Seller sellerById = sellerDao.findById(3);
        System.out.println(sellerById);

        System.out.println("=== TESTE 2: findByDepartment ===");
        Department department = new Department(1, "Computers");
        List<Seller> sellerByDepartment = sellerDao.findByDepartment(department);
        sellerByDepartment.forEach(System.out::println);

        System.out.println("=== TESTE 3: findByDepartment ===");
        sellerByDepartment = sellerDao.findAll();
        sellerByDepartment.forEach(System.out::println);

        System.out.println("=== TESTE 4: insert ===");
        Seller seller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.00, department);
        sellerDao.insert(seller);
        System.out.println("Inserted! New Id: " + seller.getId());

        System.out.println("=== TESTE 5: update ===");
        seller = sellerDao.findById(1);
        seller.setName("Martha Waine");
        sellerDao.update(seller);
        System.out.println("Updated completed!");

        System.out.println("=== TESTE 6: delete ===");
        sellerDao.deleteById(8);
        System.out.println("Deleted with success!");

    }
}
