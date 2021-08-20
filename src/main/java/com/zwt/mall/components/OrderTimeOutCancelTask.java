package com.zwt.mall.components;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Author zhouwentao
 * @Date 2021-08-19-9:41 上午
 * @Email zhouwt@shuyilink.com
 */

@Component
@Slf4j
public class OrderTimeOutCancelTask {


   @Scheduled(cron = "0 0/10 * ? * ?")
   private void cancelTimeOutOrder(){
      //TODO
      log.info("取消订单，并根据sku编号释放锁定库存");
   }


}
