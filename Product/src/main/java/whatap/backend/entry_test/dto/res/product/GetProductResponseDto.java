package whatap.backend.entry_test.dto.res.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetProductResponseDto
{
    private Long id;

    private String name;

    private String description;

    private BigDecimal price;

    private Integer stock_quantity;

    private LocalDateTime created_at;

    private LocalDateTime updated_at;
}
