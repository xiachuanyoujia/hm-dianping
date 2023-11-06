package com.hmdp;

import com.hmdp.entity.Shop;
import com.hmdp.service.impl.ShopServiceImpl;
import com.hmdp.utils.CacheCilent;
import com.hmdp.utils.RedisConstants;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.concurrent.TimeUnit;

import static com.hmdp.utils.RedisConstants.CACHE_SHOP_KEY;

@SpringBootTest
class HmDianPingApplicationTests {

    @Resource
    private CacheCilent cacheCilent;
    @Resource
    private ShopServiceImpl shopService;

    @Test
    void testSaveShop() {
        Shop shop = shopService.getById(1L);
        cacheCilent.setWithLogicalExpire(CACHE_SHOP_KEY + 1L, shop, 1L, TimeUnit.SECONDS);
    }


}
