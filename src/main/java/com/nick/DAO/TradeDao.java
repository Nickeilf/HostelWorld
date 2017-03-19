package com.nick.DAO;

import com.nick.bean.Manager;
import com.nick.bean.Trade;

import java.util.List;

/**
 * Created by nick on 2017/3/18.
 */
public interface TradeDao {
    public void addTrade(Trade trade);

    public int getMaxTrade();

    public void managerAccount(int amount);

    public Manager getManager();

    public List<Trade> getRelatedTrade(String login);

    public List<Trade> getAllTrade();

    public List<Object[]> getTrade();

}
