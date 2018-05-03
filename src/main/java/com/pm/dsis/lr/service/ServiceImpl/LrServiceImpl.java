package com.pm.dsis.lr.service.ServiceImpl;

import com.pm.dsis.em.dto.HousekeeperBuildingInfo;
import com.pm.dsis.em.mapper.HousekeeperBuildingInfoMapper;
import com.pm.dsis.lr.service.LrService;
import com.pm.dsis.mm.dto.UserInfo;
import com.pm.dsis.mm.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by admin on 2018/4/20.
 */
@Service
public class LrServiceImpl implements LrService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private HousekeeperBuildingInfoMapper housekeeperBuildingInfoMapper;

    private static final int CAPTCHA_WIDTH = 90;
    private static final int CAPTCHA_HEIGHT = 34;
    private static final int CAPTCHA_CODE_COUNT = 4;
    private static final int CAPTCHA_CODE_X = 19;//15
    private static final int CAPTCHA_CODE_Y = 26;
    private static final int CAPTCHA_FONT_HEIGHT = 28;
    private static final int CAPTCHA_EXPIRE = 60 * 5;

    private static final int LINE_COUNT = 20;//40
    private static final int LINE_DY = 12;
    private static final int MAX_RGB = 255;

    private static final boolean DEFAULT_VALIDATE_FLAG = true;

    private boolean validateFlag = DEFAULT_VALIDATE_FLAG;

    private static final char[] CAPTCHA_CODES = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P',
            'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '2', '3', '4', '5', '6', '7', '8', '9' };


    public void generateCaptcha() throws IOException {

        // randomCode用于保存随机产生的验证码，以便用户登录后进行验证。
        StringBuilder randomCode = new StringBuilder();
        // 创建一个随机数生成器类
        Random rando = new Random();
        // 随机产生codeCount数字的验证码。
        for (int i = 0; i < CAPTCHA_CODE_COUNT; i++) {
            // 得到随机产生的验证码数字。
            String code = String.valueOf(CAPTCHA_CODES[rando.nextInt(CAPTCHA_CODES.length)]);
            // 将产生的四个随机数组合在一起。
            randomCode.append(code);
        }

       String captchaCode =  randomCode.toString();

        // 定义图像buffer
        BufferedImage buffImg = new BufferedImage(CAPTCHA_WIDTH, CAPTCHA_HEIGHT, BufferedImage.TYPE_INT_RGB);
        // Graphics2D gd = buffImg.createGraphics();
        // Graphics2D gd = (Graphics2D) buffImg.getGraphics();
        Graphics gd = buffImg.getGraphics();
        // 创建一个随机数生成器类
        Random random = new Random();
        // 将图像填充为白色
        gd.setColor(Color.WHITE);
        gd.fillRect(0, 0, CAPTCHA_WIDTH, CAPTCHA_HEIGHT);

        // 创建字体，字体的大小应该根据图片的高度来定。
        Font font = new Font("Fixedsys", Font.BOLD, CAPTCHA_FONT_HEIGHT);
        // 设置字体。
        gd.setFont(font);

        // 画边框。
        gd.setColor(Color.BLACK);
        gd.drawRect(0, 0, CAPTCHA_WIDTH - 1, CAPTCHA_HEIGHT - 1);

        // 随机产生40条干扰线，使图象中的认证码不易被其它程序探测到。
        gd.setColor(Color.BLACK);
        for (int i = 0; i < LINE_COUNT; i++) {
            int x = random.nextInt(CAPTCHA_WIDTH);
            int y = random.nextInt(CAPTCHA_HEIGHT);
            int xl = random.nextInt(LINE_DY);
            int yl = random.nextInt(LINE_DY);
            gd.drawLine(x, y, x + xl, y + yl);
        }

        // randomCode用于保存随机产生的验证码，以便用户登录后进行验证。
        // StringBuffer randomCode = new StringBuffer();
        int red = 0, green = 0, blue = 0;
        // 随机产生codeCount数字的验证码。
        int sw = Math.floorDiv(CAPTCHA_WIDTH, captchaCode.length());
        for (int i = 0; i < captchaCode.length(); i++) {
            // 得到随机产生的验证码数字。
            String code = String.valueOf(captchaCode.charAt(i));
            // 产生随机的颜色分量来构造颜色值，这样输出的每位数字的颜色值都将不同。
            red = random.nextInt(MAX_RGB);
            green = random.nextInt(MAX_RGB);
            blue = random.nextInt(MAX_RGB);

            // 用随机产生的颜色将验证码绘制到图像中。
            gd.setColor(new Color(red, green, blue));
            gd.drawString(code, i * sw, CAPTCHA_CODE_Y);
        }
        // 将图像输出到输出流中。
        File file = new File("D://verifiCode.jpeg");
        try {
            ImageIO.write(buffImg, "jpeg",file);
        }catch(IOException e){
            e.printStackTrace();
        }

    }

    /**
     * 激活新用户
     * @param request
     * @param mv
     * @param userInfo
     * @throws Exception
     */
    public void activeUser(HttpServletRequest request, ModelAndView mv, UserInfo userInfo) throws Exception{

        Pattern p = Pattern.compile("\\d+");        //得到字符串中的数字
        Matcher m = p.matcher(userInfo.getUserAccount().toString());
        boolean b = m.matches();

        if(!b) {
           UserInfo user = userInfoMapper.selectActiveUserInfo(userInfo);
           user.setUserAccount(userInfo.getUserAccount());
           //TODO:MD5加密
           user.setUserPassword(getMD5(userInfo.getUserPassword()));
           user.setAttribute1("Y");
           userInfoMapper.updateByUserId(user);
        }

        mv.setViewName("redirect:/view/mws/index.html");


       /* HttpSession session = request.getSession(false);
        if (true) {
            mv.setViewName("redirect:/view/activeLogin/index.html");
            //mv.addObject("info","户激活成功！");
            session.setAttribute("info","户激活成功！");
            //throw new Exception("新户激活成功！");
        }else {
            mv.setViewName("redirect:/view/mws/index.html");
        }*/
    }

    /**
     * 查询登录信息
     * @param userInfo
     * @return
     */
    public void selectLoginInfo(ModelAndView mv, UserInfo userInfo) throws Exception{
        Pattern p = Pattern.compile("\\d+");        //得到字符串中的数字
        Matcher m = p.matcher(userInfo.getUserAccount().toString());
        boolean b = m.matches();

        if (!b) {
            UserInfo user = new UserInfo();
            user.setUserAccount(userInfo.getUserAccount());
            user.setUserPassword(getMD5(userInfo.getUserPassword()));

            UserInfo userInf = userInfoMapper.selectLoginUserInfo(user);
            if (null != userInf) {
                mv.addObject("userInfo",userInf);
                mv.setViewName("redirect:/view/mws/index.html");
            } else {
                mv.addObject("msg","密码或用户名错误");
                mv.setViewName("redirect:/view/activeLogin/index.html");
            }

        } else {
            HousekeeperBuildingInfo hb = new HousekeeperBuildingInfo();
            hb.setHbAccount(userInfo.getUserAccount());
            hb.setHbPassword(getMD5(userInfo.getUserPassword()));

            HousekeeperBuildingInfo hbInf = housekeeperBuildingInfoMapper.selectLoginInfo(hb);
            if (null != hbInf) {
                mv.addObject("hbInfo",hbInf);
                mv.setViewName("redirect:/index");
            } else {
                mv.addObject("msg","密码或用户名错误");
                mv.setViewName("redirect:/view/activeLogin/index.html");
            }
        }


    }






    /**
     * 对字符串md5加密
     *
     * @param str
     * @return
     */
    public static String getMD5(String str) throws Exception{
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(str.getBytes());
            // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
            return new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {
            throw new Exception("MD5加密出现错误");
        }
    }


}
