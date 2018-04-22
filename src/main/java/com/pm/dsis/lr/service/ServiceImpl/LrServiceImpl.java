package com.pm.dsis.lr.service.ServiceImpl;

import com.pm.dsis.lr.service.LrService;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by admin on 2018/4/20.
 */
@Service
public class LrServiceImpl implements LrService {

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

    //D:\Graduation design\code\PM\propertyManagement\src\main\webapp\WEB-INF\common\image
}
