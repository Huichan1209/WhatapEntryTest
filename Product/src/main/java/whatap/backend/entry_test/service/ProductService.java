package whatap.backend.entry_test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import whatap.backend.entry_test.domain.Product;
import whatap.backend.entry_test.dto.req.product.*;
import whatap.backend.entry_test.dto.res.product.*;
import whatap.backend.entry_test.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ProductService
{
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository)
    {
        this.productRepository = productRepository;
    }

    @Transactional(readOnly = false)
    public AddProductResponseDto addProduct(AddProductDto dto)
    {
        Product product = new Product();
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setStock_quantity(dto.getStock_quantity());

        Product savedProduct = productRepository.save(product);
        return new AddProductResponseDto(savedProduct.getId(), savedProduct.getName(), savedProduct.getDescription(), savedProduct.getPrice(), savedProduct.getStock_quantity(), savedProduct.getCreated_at(), savedProduct.getUpdated_at());
    }

    @Transactional(readOnly = false)
    public DeleteProductResponseDto deleteProduct(DeleteProductDto dto)
    {
        Product product = new Product();
        product.setId(dto.getId());

        if(productRepository.existsById(dto.getId()))
        {
            productRepository.delete(product);
            return new DeleteProductResponseDto(dto.getId());
        }
        else
        {
            throw new IllegalStateException("상품이 존재하지 않음.");
        }
    }

    public GetProductResponseDto getProduct(GetProductDto dto)
    {
        Product findProduct = productRepository.findById(dto.getId()).orElseThrow(()-> new IllegalStateException("상품이 존재하지 않음."));
        return new GetProductResponseDto(findProduct.getId(), findProduct.getName(), findProduct.getDescription(), findProduct.getPrice(), findProduct.getStock_quantity(), findProduct.getCreated_at(), findProduct.getUpdated_at());
    }

    public GetProductsByPaginationResponseDto getProductsByPagination(GetProductsByPaginationDto dto)
    {
        Pageable pageable = PageRequest.of(dto.getPage(), dto.getSize(), dto.getSort());
        Page<Product> products = productRepository.findProducts(pageable);
        return new GetProductsByPaginationResponseDto(products.getContent(), products.getNumber(), products.getSize(), products.getTotalPages());
    }

    @Transactional(readOnly = false)
    public UpdateProductResponseDto updateProduct(UpdateProductDto dto)
    {
        if(productRepository.existsById(dto.getId()))
        {
            Product product = new Product();
            product.setId(dto.getId());
            product.setName(dto.getName());
            product.setDescription(dto.getDescription());
            product.setPrice(dto.getPrice());
            product.setStock_quantity(dto.getStock_quantity());

            Product savedProduct = productRepository.save(product);
            return new UpdateProductResponseDto(savedProduct.getId(), savedProduct.getName(), savedProduct.getDescription(), savedProduct.getPrice(), savedProduct.getStock_quantity(), savedProduct.getCreated_at(), savedProduct.getUpdated_at());
        }
        else
        {
            throw new IllegalStateException("상품이 존재하지 않음.");
        }
    }
}