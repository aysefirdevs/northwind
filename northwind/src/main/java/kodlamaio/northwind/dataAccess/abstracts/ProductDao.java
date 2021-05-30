package kodlamaio.northwind.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;

public interface ProductDao extends JpaRepository<Product, Integer>{
	Product getByProductName(String productName); //tablodaki ilgili kolona göre ver diyor direkt.
	
	
	Product getByProductNameAndCategory_CategoryId(String productName, int categoryId);  
	
	
	List<Product> getByProductNameOrCategory_CategoryId(String productName, int categoryId);
	
	//select*from products where category_id in(1,2,3,4)
	List<Product> getByCategoryIn(List<Integer> categories);
	
	//ürün ismine göre arama 
	List<Product> getByProductNameContains(String productName);
	
	List<Product> getByProductNameStartsWith(String productName);
	
	//from tüm alanları çeker
	@Query("From Product where productName= :productName and category.categoryId= :categoryId")  //query yazarken vt tablosunu unut :görürsen parametre demek
	List<Product> getByNameAndCategory(String productName, int categoryId);  
	
	@Query("Select new kodlamaio.northwind.entities.dtos.ProductWithCategoryDto(p.id, p.productName, c.categoryName) From Category c Inner Join c.products p") //üç alanı entityden aldım.
	List<ProductWithCategoryDto> getProductWithCategoryDetails();  
	//​select p.product_id,p.product_name, c.category_name,p.unit_price from products p inner join categories c on p.category_id =c.category_id 
	
}