package whatap.backend.entry_test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import whatap.backend.entry_test.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}