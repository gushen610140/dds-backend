package icu.sunway.ddsspring.Entity.Data;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("votes")
public class Vote {
    @TableId
    private int id;
    private String decision_id;
    private String voter;
    private String opinion;
}
