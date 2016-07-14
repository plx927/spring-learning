package com.panlingxiao.spring.learning.cache.service;

import com.google.common.base.Optional;
import com.panlingxiao.spring.learning.cache.domain.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by panlingxiao on 2016/7/14.
 */
@Service
public class AccountService {

    private Logger logger = LoggerFactory.getLogger(AccountService.class);

    /**
     * 方法内部考虑缓存逻辑,只负责单纯的数据库查询操作
     * @param accountName
     * @return
     */
    @Cacheable(value="accountCache")
    public Account getAccountByName(String accountName){
        logger.info("根据{}从数据库查询", accountName);
        Optional<Account> accountOptional = getFromDB(accountName);
        //当数据不存在时，对外抛出异常
        if(!accountOptional.isPresent()){
            throw  new IllegalStateException(String.format("can not find account by account name : [%s]", accountName));
        }
        return accountOptional.get();
    }

    /**
     * 模拟从数据库进行查询
     * @param accountName
     * @return
     */
    private Optional<Account> getFromDB(String accountName) {
        return Optional.fromNullable(new Account(accountName, 1));
    }

    @CacheEvict(value="accountCache",allEntries = true)
    public void evictCache(){
        logger.info("清空缓存");
    }

}
