package com.panlingxiao.spring.learning.cache.service;

import com.panlingxiao.spring.learning.cache.domain.Account;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by panlingxiao on 2016/7/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:app-context-cache.xml")
public class AccountServiceTest {

    @Autowired
    private AccountService accountService;

    @Test
    public void testGetAccountByName() throws Exception {
        Account hello1 = accountService.getAccountByName("hello");
        Account hello2 = accountService.getAccountByName("hello");
        Assert.assertEquals(hello1,hello2);

        //清空缓存
        accountService.evictCache();

        //再次查询时会获取新的数据
        Account hello3 = accountService.getAccountByName("hello");
        Assert.assertNotEquals(hello1,hello3);


    }
}