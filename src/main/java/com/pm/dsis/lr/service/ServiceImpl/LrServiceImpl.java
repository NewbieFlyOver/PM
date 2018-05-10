package com.pm.dsis.lr.service.ServiceImpl;

import com.pm.dsis.em.dto.HousekeeperBuildingInfo;
import com.pm.dsis.em.mapper.HousekeeperBuildingInfoMapper;
import com.pm.dsis.lr.SendMsgUtil.HttpClientUtil;
import com.pm.dsis.lr.service.LrService;
import com.pm.dsis.mm.dto.UserInfo;
import com.pm.dsis.mm.mapper.UserInfoMapper;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    static final public Logger logger = LoggerFactory.getLogger(LrServiceImpl.class);

    static String ver = "";

    /*//用于是否登录的标志 0:未登录；1：登录； 2：登录退出
    static public int adminLoginFlag = 0;
    static public int userLoginFlag = 0;*/
    static public boolean loginFlag = false;

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
           int sum = userInfoMapper.updateByUserId(user);
           if(sum == 1) {
               mv.addObject("acMsg","激活成功，请登录！");
           }else {
               mv.addObject("acMsg","激活失败！");
           }
        }

        mv.setViewName("redirect:/view/activeLogin/index.html");
    }

    /**
     * 登录
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
                Long id = userInf.getUserId();
                loginFlag = true;
                mv.addObject("id",id);
                mv.setViewName("redirect:/view/mws/index.html");
            } else {
                mv.addObject("msg","密码或用户名错误");
                mv.setViewName("redirect:/view/activeLogin/index.html");
            }

        } else {
            HousekeeperBuildingInfo hb = new HousekeeperBuildingInfo();
            hb.setHbNumber((long) Integer.parseInt(userInfo.getUserAccount()));
            hb.setHbPassword(getMD5(userInfo.getUserPassword()));

            HousekeeperBuildingInfo hbInf = housekeeperBuildingInfoMapper.selectLoginInfo(hb);
            if (null != hbInf) {
                Long id= hbInf.getHbId();
                loginFlag = true;
                mv.addObject("id",id);
                mv.setViewName("redirect:/index");
            } else {
                mv.addObject("msg","密码或用户名错误");
                mv.setViewName("redirect:/view/activeLogin/index.html");
            }
        }


    }

    /**
     * 退出登录
     * @return
     */
    /*public void logout(ModelAndView mv) throws Exception{
        if (loginFlag) {
            loginFlag = false;
            mv.setViewName("redirect:/view/activeLogin/index.html");
        }
    }*/




    /**
     * 查询账号是否存在
     * @param account
     * @return
     */
    public int selectAccount(String account){
        Pattern p = Pattern.compile("\\d+");        //得到字符串中的数字
        Matcher m = p.matcher(account);
        boolean b = m.matches();

        if(!b) {
            if (userInfoMapper.selectAccount(account) == null) {
                return 0;
            }else {
                return 1;
            }
        } else {
            if (housekeeperBuildingInfoMapper.selectAccount(account) == null) {
                return 0;
            }else {
                return 1;
            }
        }
    }

    /**
     * 验证激活信息
     * @param bfr
     * @param name
     * @param idNum
     * @return
     */
    public int validationAccount(String bfr,String name,String idNum){
        UserInfo userInfo = new UserInfo();
        userInfo.setBuildingFullRoom(bfr);
        userInfo.setUserName(name);
        userInfo.setUserIdNumber(idNum);
        UserInfo user = userInfoMapper.selectActiveUserInfo(userInfo);
        if (user == null) {
            return 1;
        }else {
            //未激活
            return 0;
        }
    }

    /**
     * 是否被激活
     * @param bfr
     * @param name
     * @param idNum
     * @return
     */
    public int active(String bfr,String name,String idNum){
        UserInfo userInfo = new UserInfo();
        userInfo.setBuildingFullRoom(bfr);
        userInfo.setUserName(name);
        userInfo.setUserIdNumber(idNum);
        UserInfo user = userInfoMapper.active(userInfo);
        if (user == null) {
            return 0;
        }else {
            return 1;
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


    /**
     * 重置密码
     * @param userId
     * @param oldPwd
     * @param newPwd
     * @return
     */
    public int resetPwd(Long userId, String oldPwd, String newPwd, String flag) throws Exception{
        oldPwd = getMD5(oldPwd);
        newPwd = getMD5(newPwd);
        int sum = 0;
        if (flag.equals("user")) {
            sum = userInfoMapper.resetPwd(userId, oldPwd, newPwd);
        }

        if (flag.equals("admin")) {
            sum = housekeeperBuildingInfoMapper.resetPwd(userId, oldPwd, newPwd);
        }
        return sum;
    }

    /**
     * 发送验证码
     * @return
     */
    public String sendVerif(String phone) throws Exception{
        ver = verif();
        logger.info("验证码是：{}",ver);
        SendMsg(phone,ver);
        return ver;
    }

    /**
     * 产生验证码
     * @return
     */
    private String verif() {
        StringBuffer v = new StringBuffer();
        for (int i=0; i<6; i++) {
            v.append((int)(Math.random()*10));
        }
        return v.toString();
    }

    /**
     * 验证码验证
     * @param loginName
     * @param phone
     * @param verif
     * @return
     */
    public int validVerif(String loginName, String phone, String verif) {
        Pattern p = Pattern.compile("\\d+");        //得到字符串中的数字
        Matcher m = p.matcher(loginName);
        boolean b = m.matches();
        int sum = 0;
        if (verif.equals(ver)) {
            if(!b) {
                UserInfo userInfo = userInfoMapper.selectAccountByPhone(phone, loginName);
                if (userInfo!=null) {
                    sum = 1;
                }
            } else {
                HousekeeperBuildingInfo hbi = housekeeperBuildingInfoMapper.selectAccountByPhone(phone, loginName);
                if ( hbi!=null ) {
                    sum = 1;
                }
            }
        } else {
                return sum;
        }
        return sum;
    }

    /**
     * 更改密码
     * @param loginName
     * @return
     */
    public int findPwd(String loginName, String pwd) throws Exception{

        Pattern p = Pattern.compile("\\d+");        //得到字符串中的数字
        Matcher m = p.matcher(loginName);
        boolean b = m.matches();

        pwd = getMD5(pwd);

        if(!b) {
            return userInfoMapper.updateByAccount(loginName,pwd);
        }else {
            return housekeeperBuildingInfoMapper.updateByAccount(loginName,pwd);
        }
    }


    private void SendMsg(String phone, String verif) throws Exception{


        HttpClientUtil client = HttpClientUtil.getInstance();
        //UTF发送
        int result = client.sendMsgUtf8("明明11", "d41d8cd98f00b204e980",
                 "物业平台忘记密码的验证码是："+verif, phone);

        if(result>0){
            System.out.println("UTF8成功发送条数=="+result);
        }else{
            System.out.println(client.getErrorMsg(result));
        }
    }


}
