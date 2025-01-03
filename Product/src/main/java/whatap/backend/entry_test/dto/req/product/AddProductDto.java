package whatap.backend.entry_test.dto.req.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddProductDto
{
    private String name;

    private String description;

    private BigDecimal price;

    private Integer stock_quantity;
}
