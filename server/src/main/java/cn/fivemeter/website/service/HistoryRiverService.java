package cn.fivemeter.website.service;

import cn.fivemeter.website.dao.HistoryRiverMapper;
import cn.fivemeter.website.model.HistoryRiver;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class HistoryRiverService {
    @Resource
    HistoryRiverMapper historyRiverMapper;

    public List<HistoryRiver> getByYear(String year){
        return historyRiverMapper.selectByYear(year);
    }

    public int addMessage(HistoryRiver historyRiver){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String now = simpleDateFormat.format(new Date());
        historyRiver.setOccurTime(now);
        return historyRiverMapper.insert(historyRiver);
    }

}
