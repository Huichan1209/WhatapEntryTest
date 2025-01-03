package whatap.backend.entry_test.dto.res.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import whatap.backend.entry_test.domain.Product;
import whatap.backend.entry_test.dto.req.product.GetProductDto;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetProductsByPaginationResponseDto
{
    private List<Product> products;

    private int currentPage;

    private int pageSize;

    private int totalPages;
}
