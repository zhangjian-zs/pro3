package com.mynb.web;


import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.mynb.config.AlipayConfig;
import com.mynb.service.ICardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@RestController    //@RestController=@Controller + @ResponseBody
@CrossOrigin(allowCredentials="true", allowedHeaders="*")
@RequestMapping("/card")
public class DingdanController {
    @Autowired
    private ICardService cardService;

    private String dingdanNo;
    @RequestMapping(value = "/goAlipay", produces = "text/html; charset=UTF-8")
    public String goAlipay(Integer count, HttpServletRequest request, HttpServletRequest response) throws Exception {



        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);

        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);

        //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = UUID.randomUUID().toString();
        dingdanNo = out_trade_no;
        //付款金额，必填
        String total_amount = String.valueOf(count);
        //订单名称，必填
        String subject = "no";
        //商品描述，可空
        String body = "no too";

        alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                + "\"total_amount\":\""+ total_amount +"\","
                + "\"subject\":\""+ subject +"\","
                + "\"body\":\""+ body +"\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        //请求
        String result = alipayClient.pageExecute(alipayRequest).getBody();

        return result;
    }



    @RequestMapping(path="/newDingdan",method = {RequestMethod.GET,RequestMethod.POST})
    public boolean newDingdan(Integer buyCounts) {
        return cardService.addDingdan(buyCounts,dingdanNo);
    }


}