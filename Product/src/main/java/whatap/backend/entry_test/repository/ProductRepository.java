package whatap.backend.entry_test.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import whatap.backend.entry_test.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long>
{
    Page<Product> findProducts(Pageable pageable);
}