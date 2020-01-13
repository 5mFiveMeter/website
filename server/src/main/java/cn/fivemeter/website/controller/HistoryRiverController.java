package cn.fivemeter.website.controller;

import cn.fivemeter.website.common.HttpResultContent;
import cn.fivemeter.website.model.HistoryRiver;
import cn.fivemeter.website.service.HistoryRiverService;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/historyRiver")
public class HistoryRiverController {
    @Resource
    HistoryRiverService historyRiverService;

    @GetMapping("/getByYear")
    public HttpResultContent getByYear(@Param("year")String year){
        return HttpResultContent.success().setData(historyRiverService.getByYear(year));
    }
    @PostMapping("/addMessage")
    public HttpResultContent addMessage(@RequestBody HistoryRiver hr){
        System.out.println(hr.getOccurYear());
        return HttpResultContent.success().setData(historyRiverService.addMessage(hr));
    }
}
