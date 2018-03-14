package com.taotao.controller;


import com.taotao.dto.Items;
import com.taotao.service.ItemService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;


/**
 * 商品管理
 * 
 * @author lx
 *
 */
@Controller
public class ItemController {
	@Autowired
	private ItemService itemService;

	@RequestMapping("/test")
	public  String index(){
		return "test";
	}

	@RequestMapping("/")
	public  String test(){
		return "index";
	}

	@RequestMapping("/{page}")
	public  ModelAndView index(@PathVariable String page){
		ModelAndView mv = new ModelAndView();
		mv.setViewName(page);
		return mv;
	}

	//入门程序 第一   包类 + 类包 + 方法名
	//URI可以有多个，post、get请求都可以
	@RequestMapping(value = {"/item/itemlist.action","/item2/itemlist.action"},method=RequestMethod.GET)
	@ResponseBody
	public List<Items> itemList(){
		
		//运行异常
		//int i= 1/0;
		
		//自定义异常
		/*if(true){
			throw new MessageException("自定义异常！");
		}*/
		
		//从Mysql中查询
		List<Items> list = itemService.selectItems();
		ModelAndView mav = new ModelAndView();
		//数据
		//mav.addObject("itemList", list);
		//mav.setViewName("itemList");
		return list;
	}
	//去修改页面 入参 id
	@RequestMapping(value = "/itemEdit.action")
//	public ModelAndView toEdit(@RequestParam(value = "id",required = false,defaultValue = "1") Integer idaaq,
	//public ModelAndView toEdit(Integer id,
	public String toEdit(Integer id,
						 HttpServletRequest request, HttpServletResponse response
			, HttpSession session, Model model){
		//Servlet时代开发
//		String id = request.getParameter("id");
		//Items items = itemService.selectItemsById(id);
		//ModelAndView mav = new ModelAndView();
		//数据
		//mav.addObject("item", items);
		//mav.setViewName("editItem");
		//return mav;
		Items items = itemService.selectItemsById(id);
		//设置返回值
		model.addAttribute("item", items);
		//指定逻辑视图名，经过视图解析器解析为jsp物理路径：
		return "editItem";
		
		//结果内部转发到editItem.action，request可以带过去
		//return "forward: /editItem.action";
	
		// 重定向相当于执行了新的request和response，所以之前的请求参数都会丢失
		// 如果要指定请求参数，需要在重定向的url后面添加 ?itemId=1 这样的请求参数
		//return "redirect:/editItem.action?itemId=" + item.getId();
	}
	//提交修改页面 入参  为 Items对象  
	@RequestMapping(value = "/updateitem.action")
	//public ModelAndView updateitem(Items items, MultipartFile pictureFile) throws IllegalStateException, IOException{
	//public ModelAndView updateitem(QueryVo vo){
	//public @ResponseBody String updateitem(@RequestBody Items items, MultipartFile pictureFile) throws IllegalStateException, IOException{
	public String updateitem(Items items, MultipartFile pictureFile) throws IllegalStateException, IOException{
	// 图片上传
		// 设置图片名称，不能重复，可以使用uuid
		String picName = UUID.randomUUID().toString();
		// 获取文件名
		String oriName = pictureFile.getOriginalFilename();
		// 获取图片后缀
		//jpg
		String extName = FilenameUtils.getExtension(pictureFile.getOriginalFilename());
		//String extName = oriName.substring(oriName.lastIndexOf("."));
		// 开始上传
		pictureFile.transferTo(new File("D:/workspace/upload/" + picName + extName));
		// 设置图片名到商品中
		items.setPic(picName + extName);
		// ---------------------------------------------
		// 更新商品
		itemService.updateItemsById(items);
		return "forward:/itemEdit.action";
	}
		/*itemService.updateItemsById(items);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("success");
		return mav;
	}*/
	//删除
	@RequestMapping(value = "/deletes.action")
	public ModelAndView deletes(Integer[] ids){
			for(Integer it: ids){
				System.out.println(it);
			}
			ModelAndView mav = new ModelAndView();
			mav.setViewName("success");
			return mav;
		}
	
	@RequestMapping(value = "/test.action")
	public void test(Integer[] ids,HttpServletRequest request,HttpServletResponse response) throws IOException{
		// 1 使用request进行转发
		// request.getRequestDispatcher("/WEB-INF/jsp/success.jsp").forward(request,
		// response);

		// 2 使用response进行重定向到编辑页面
		// response.sendRedirect("/springmvc-web2/itemEdit.action");

		// 3 使用response直接显示
		response.getWriter().print("{\"abc\":123}");
		}
	
		//登录
		@RequestMapping(value = "/login.action")
		public String login(String username,HttpSession session){
			System.out.println("000000000000"+username);
			session.setAttribute("USER_SESSION", username);
			return "redirect:/item/itemlist.action";
		}
		
		@RequestMapping(value = "/login2.action")
		public String login2(){
			return "login";
		}
		
		
		@RequestMapping(value="/getItems.action",method={RequestMethod.GET,RequestMethod.POST})
		@ResponseBody
		public List<Items> getItemsController(){
			//从Mysql中查询
			//Items items = itemService.selectItemsById(1);
			List<Items> items = itemService.selectItems();	
			/*for(Items i : it ){
				System.out.println("00000000000"+i.getName());
			}
			ModelAndView mav = new ModelAndView();
			//数据
			mav.addObject("itemList", it);
			mav.setViewName("itemList");*/
			
		/*	
			DataOutputStream dataOut = null;
			BufferedReader in =null;

			try {

			  //API endpoint for API sandbox 
			  String url = "https://sandbox.api.sap.com/ml/docfeatureextraction/inference_sync";


			  URL urlObj = new URL(url);
			  HttpURLConnection connection = (HttpURLConnection) urlObj.openConnection();
			  //setting request method
			  connection.setRequestMethod("POST");

			  //adding headers
			  connection.setRequestProperty("Content-Type","multipart/form-data");
			  connection.setRequestProperty("Accept","application/json");
			  //API Key for API Sandbox
			  connection.setRequestProperty("APIKey","<API_KEY>");


			  connection.setDoInput(true);

			  //sending POST request
			  connection.setDoOutput(true);
			  // Optional Multipart/Form-data parameters: "files", "texts"
			  // For more details, see the API definition

			  int responseCode = connection.getResponseCode();
			  in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			  String inputLine;
			  StringBuffer response = new StringBuffer();
			  while ((inputLine = in.readLine()) != null) {
			    response.append(inputLine);
			  }

			  //printing response
			  System.out.println(response.toString());

			} catch (Exception e) {
			  //do something with exception
			  e.printStackTrace();
			} finally {
			  try {
			    if(dataOut != null) {
			      dataOut.close();
			    }
			    if(in != null) {
			      in.close();
			    }

			  } catch (IOException e) {
			    //do something with exception
			    e.printStackTrace();
			  }
			}
			*/
			
			
			return items;
			
		}
		
}
