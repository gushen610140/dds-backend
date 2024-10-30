package icu.sunway.ddsspring.Entity.View;

import icu.sunway.ddsspring.Entity.Data.Decision;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetDecisionsVO {
    private List<Decision> list;
    private long total;
}
