package icu.sunway.ddsspring.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import icu.sunway.ddsspring.Entity.Data.Decision;
import icu.sunway.ddsspring.Mapper.DecisionMapper;
import org.springframework.stereotype.Service;

@Service
public class DecisionService extends ServiceImpl<DecisionMapper, Decision> implements IService<Decision> {
}
