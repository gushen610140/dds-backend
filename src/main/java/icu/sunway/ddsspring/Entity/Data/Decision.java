package icu.sunway.ddsspring.Entity.Data;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("decisions")
public class Decision {
    @TableId(type = IdType.ASSIGN_UUID)
    private String id;
    private String title;
    private String description;
    private int agree;
    private int waive;
    private int reject;
    private int pending;
}
