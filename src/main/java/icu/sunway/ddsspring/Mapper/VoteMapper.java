package icu.sunway.ddsspring.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import icu.sunway.ddsspring.Entity.Data.Decision;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface VoteMapper extends BaseMapper<Decision> {
}
