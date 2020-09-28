package com.mynb.web;

import com.mynb.pojo.Goods;
import com.mynb.pojo.Orders;
import com.mynb.service.ICardService;
import com.mynb.vo.OrdersDetail;
import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

@RestController    //@RestController=@Controller + @ResponseBody
@CrossOrigin(allowCredentials="true", allowedHeaders="*")
@RequestMapping("/card")
public class OrdersController {
    @Autowired
    private ICardService cardService;

    /**
     * 查询所有商品
     * @return
     */
    @RequestMapping(path="/addOrder",method = {RequestMethod.GET,RequestMethod.POST})
    public boolean addOrder(@RequestBody Orders orders) {
        return cardService.addOrder(orders);
    }



    @RequestMapping(path="/getAllOrders",method = {RequestMethod.GET,RequestMethod.POST})
    public List<OrdersDetail> getAllOrders() {
        return cardService.listAllOrdersDetails();
    }

    @RequestMapping(path="/delOrder",method = {RequestMethod.GET,RequestMethod.POST})
    public boolean delOrder(Integer orderId) {
        return cardService.delOrder(orderId);
    }

    @RequestMapping(path="/modOrder",method = {RequestMethod.GET,RequestMethod.POST})
    public boolean modOrder(Integer orderId,Integer goodsCount) {
        return cardService.updateOrder(orderId,goodsCount);
    }

    @RequestMapping(path="/delOrders",method = {RequestMethod.GET,RequestMethod.POST})
    public boolean delOrders(@RequestBody Integer[] ids) {
        return cardService.delOrders(ids);
    }
}