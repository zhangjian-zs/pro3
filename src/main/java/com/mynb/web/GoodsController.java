package com.mynb.web;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mynb.pojo.Goods;
import com.mynb.pojo.Userinfo;
import com.mynb.service.ICardService;
import com.mynb.vo.ConsumedGoods;
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
public class GoodsController {
    @Autowired
    private ICardService cardService;

    /**
     * 查询所有商品
     * @return
     */
    @RequestMapping(path="/getAllGoods",method = {RequestMethod.GET,RequestMethod.POST})
    public List<Goods> getAllGoods() {
        return cardService.listAllGoods();
    }


    /**
     * 图片文件上传
     * @param file
     * @throws IOException
     * @throws ServletException
     */
    @RequestMapping(path = "/uploadImg", method = { RequestMethod.GET, RequestMethod.POST })
    public String uploadFile(MultipartFile file) throws IOException, ServletException {
        if (file.isEmpty() || file.getSize() == 0) {
            return "文件为空";
        }
        try {
            MinioClient minioClient = new MinioClient("http://localhost:9000", "minioadmin", "minioadmin"); // 连接
            if (!minioClient.bucketExists("goods")) { // 是否存在名为“test”的bucket
                minioClient.makeBucket("goods");
            }
            String fileName = file.getOriginalFilename();
            String newName = UUID.randomUUID().toString().replaceAll("-", "")+fileName.substring(fileName.lastIndexOf("."));
            InputStream inputStream = file.getInputStream(); // 获取file的inputStream
            //image/png
            minioClient.putObject("goods", newName, inputStream,"image/png"); // 上传
            //minioClient.putObject("goods", newName, inputStream, "application/octet-stream"); // 上传
            inputStream.close();
            String url = minioClient.getObjectUrl("goods", newName); // 文件访问路径
            System.out.println(url);
            return url;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "上传失败";
    }


    /**
     * 上架商品
     * @return
     */
    @RequestMapping(path="/addGoods",method = {RequestMethod.GET,RequestMethod.POST})
    public boolean addGoods(@RequestBody Goods goods) {
        return cardService.addGoods(goods);
    }


    /**
     * 删除多个商品
     * @param
     * @return
     */
    @RequestMapping(path="/delGoods",method = {RequestMethod.GET,RequestMethod.POST})
    public boolean delGoods(Integer[] goodId) {
        return cardService.delGoods(goodId);
    }


    /**
     * 根据id查询goods
     * @param goodsId
     * @return
     */
    @RequestMapping(path="/getGoodsInfoById",method = {RequestMethod.GET,RequestMethod.POST})
    public Goods getGoodsInfoById(Integer goodsId) {
        return cardService.selectGoodsById(goodsId);
    }


    /**
     * 更新goods
     * @param goods
     * @return
     */
    @RequestMapping(path="/updateGoods",method = {RequestMethod.GET,RequestMethod.POST})
    public boolean updateGoods(@RequestBody Goods goods) {
        return cardService.updateGoods(goods);
    }




    @RequestMapping(path="/consumeGoods",method = {RequestMethod.GET,RequestMethod.POST})
    public boolean consumeGoods(@RequestBody ConsumedGoods[] cgs)  {

        return cardService.consumeGoods(cgs);
    }
}