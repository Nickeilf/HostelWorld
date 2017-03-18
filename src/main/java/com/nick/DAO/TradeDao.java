package com.nick.DAO;

import com.nick.bean.Trade;

/**
 * Created by nick on 2017/3/18.
 */
public interface TradeDao {
    public void addTrade(Trade trade);

    public int getMaxTrade();

    public void managerAccount(int amount);
}
