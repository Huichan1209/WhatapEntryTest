package whatap.backend.entry_test.dto.req.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetProductsByPaginationDto
{
    private int page;

    private int size;

    private String sort;
}
