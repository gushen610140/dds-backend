package icu.sunway.ddsspring.Controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.sunway.ddsspring.Entity.Data.Decision;
import icu.sunway.ddsspring.Entity.View.AddDecisionVO;
import icu.sunway.ddsspring.Entity.View.GetDecisionsVO;
import icu.sunway.ddsspring.Entity.View.Result;
import icu.sunway.ddsspring.Entity.View.UpdateDecisionVO;
import icu.sunway.ddsspring.Service.DecisionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/decision")
public class DecisionController {

    private final DecisionService decisionService;

    public DecisionController(DecisionService decisionService) {
        this.decisionService = decisionService;
    }

    @GetMapping("/list")
    public Result<GetDecisionsVO> getDecisions(@RequestParam int current, @RequestParam int size) {
        List<Decision> list;
        long count;
        try {
            list = decisionService.list(new Page<>(current, size));
            count = decisionService.count();
            return new Result<>(200, "", new GetDecisionsVO(list, count));
        } catch (Exception e) {
            return new Result<>(400, e.getMessage(), null);
        }
    }

    @PostMapping("/add")
    public Result<String> addDecision(@RequestBody AddDecisionVO addDecisionVO) {
        try {
            Decision decision = new Decision(null, addDecisionVO.getTitle(), addDecisionVO.getDescription(), 0, 0, 0, 4);
            decisionService.save(decision);
            return new Result<>(200, "", decision.getId());
        } catch (Exception e) {
            return new Result<>(400, e.getMessage(), null);
        }
    }

    @PutMapping("/update")
    public Result<String> updateDecision(@RequestBody UpdateDecisionVO updateDecisionVO) {
        try {
            QueryWrapper<Decision> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("id", updateDecisionVO.getDecision_id());
            Decision decision = decisionService.getOne(queryWrapper);
            UpdateWrapper<Decision> updateWrapper = new UpdateWrapper<>();
            updateWrapper.eq("id", updateDecisionVO.getDecision_id());
            switch (updateDecisionVO.getAction()) {
                case "agree":
                    updateWrapper.set("agree", decision.getAgree() + 1);
                    break;
                case "reject":
                    updateWrapper.set("reject", decision.getReject() + 1);
                    break;
                case "waive":
                    updateWrapper.set("waive", decision.getWaive() + 1);
                    break;
                default:
                    return new Result<>(400, "action not exist", null);
            }
            decisionService.update(updateWrapper);
            return new Result<>(200, "update success", null);
        } catch (Exception e) {
            return new Result<>(400, e.getMessage(), null);
        }
    }
}
