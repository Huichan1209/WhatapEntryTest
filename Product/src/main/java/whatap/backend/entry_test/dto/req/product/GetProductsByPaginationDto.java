package whatap.backend.entry_test.dto.req.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Sort;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetProductsByPaginationDto
{
    private int page;

    private int size;

    private Sort sort;

    public void setSort(String sort)
    {
        switch (sort.toUpperCase())
        {
            case "DESC": this.sort = Sort.by("id").descending(); break;
            case "ASC":
            default: this.sort = Sort.by("id").ascending(); break;
        }
    }
}
