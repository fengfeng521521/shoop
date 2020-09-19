package priv.jesse.mall.web.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import priv.jesse.mall.entity.Product;
import priv.jesse.mall.entity.User;
import priv.jesse.mall.entity.pojo.ResultBean;
import priv.jesse.mall.service.UserService;

import java.util.List;


@Controller
@RequestMapping("/userTest")
public class UserTestController {
    @Autowired
    private UserService userService;
    /**
     * 展示
     */
    @RequestMapping("/show")
    public String show()  {

        return "/mall/ma/maindex";
    }
    @ResponseBody
    @RequestMapping("/showUser")
    public ResultBean<List<User>> showUser()  {
        ResultBean rr=new ResultBean();
        //Pageable pageable = new PageRequest(1, 1, null);
        List<User> users = userService.findBynull();
        System.out.println(users);
        rr.setMessage("成功");
        rr.setState(200);
        rr.setData(users);
        return rr;
    }






}
