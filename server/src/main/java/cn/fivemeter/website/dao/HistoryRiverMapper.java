package cn.fivemeter.website.dao;

import cn.fivemeter.website.model.HistoryRiver;

import java.util.List;

public interface HistoryRiverMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(HistoryRiver record);

    int insertSelective(HistoryRiver record);

    HistoryRiver selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HistoryRiver record);

    int updateByPrimaryKey(HistoryRiver record);

    List<HistoryRiver> selectByYear(String year);
}