package com.web.store.controller;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.Base64;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.web.store.model.OrderItemBean;
import com.web.store.model.ProductBean;
import com.web.store.model.ShoppingCart;
import com.web.store.service.ProductService;

@Controller
@SessionAttributes({ "ShoppingCart" })
public class ShoppingCartController {

	@Autowired
	ProductService service;

	// for 跳轉pd.jsp頁面，測試用，須於pd.jsp放入product識別字串
//	@RequestMapping("/productByIdDetails")
//	public String getProductById(@RequestParam("pId") Integer pId, Model model) {
//		model.addAttribute("product", service.getProductById(pId));
//		if(service.getProductById(pId).getRankCount() != null) {
//		model.addAttribute("rankAVG", service.getProductRankAVGById(pId));
//		}
//		return "/productDetail/pd";
//	}
//	
	// 加入購物車
	@RequestMapping(value = "/productById02", method = RequestMethod.POST)
	public String getProductById(@RequestParam("pId") Integer pId, @ModelAttribute("product") ProductBean pb,
			Model model, ServletRequest request, HttpSession session) {

		Integer quantity = Integer.parseInt(request.getParameter("quantity"));
		OrderItemBean item = new OrderItemBean();
		item.setProductId(pb.getpId());
		item.setDescription(pb.getPname());
		item.setQuantity(quantity);
		item.setUnitPrice((double) pb.getPrice());
		item.setDiscount(1.0); // TBD

		ShoppingCart cart = (ShoppingCart) session.getAttribute("ShoppingCart");
		if (cart == null) {
			cart = new ShoppingCart();
		}
		cart.addToCart(pId, item);
		model.addAttribute("ShoppingCart", cart);

		return "redirect:/cartConfirm";
	}

	// TODO--購物車圖片
	@RequestMapping(value = "/getPicture/{productId}", method = RequestMethod.GET)
	public ResponseEntity<byte[]> getPicture(HttpServletResponse resp, @PathVariable Integer productId) {
		byte[] body = null;
		HttpHeaders headers = new HttpHeaders();

		ProductBean pb = service.getProductById(productId);
		System.out.println("pb==" + pb.getProductImage());
		if (pb != null) {
			Blob picture = pb.getProductImage();
			if (picture != null) {
				try {
					body = picture.getBytes(1, (int) picture.length());
					System.out.println("body=="+body);
				} catch (SQLException e) {
					System.out.println("叉燒包");
					e.printStackTrace();
				}
			}
		}
		
		headers.setCacheControl(CacheControl.noCache().getHeaderValue());
		String mimeType = "image/jpg";
		MediaType mediaType = MediaType.valueOf(mimeType);
		headers.setContentType(mediaType);
		ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(body, headers, HttpStatus.OK);
		return responseEntity;
	}

	// 購物車頁面
	@RequestMapping("/cartConfirm")
	public String redirectCartConfirm(Model model) {
		return "cartConfirm";
	}

	// 取消本次購買，刪除購物車所有商品
	@RequestMapping(value = "/cancel")
	public String cancelCart(Model model, SessionStatus status) {
		status.setComplete();
		return "redirect:/";
	}

	// 取消購買購物車特定商品
	@RequestMapping(value = "/cancelProduct")
	public String cancelProduct(@RequestParam("pId") Integer pId, Model model, HttpSession session) {
		ShoppingCart cart = (ShoppingCart) session.getAttribute("ShoppingCart");
		cart.deleteProduct(pId);
		return "redirect:/cartConfirm";
	}

	@RequestMapping(value = "/modifyQty")
	public String modifyQty(@RequestParam("pId") Integer pId, @RequestParam("newQty") Integer newQty, Model model,
			HttpSession session) {
		ShoppingCart cart = (ShoppingCart) session.getAttribute("ShoppingCart");
		if (newQty == null || newQty < 0) {
			newQty = 1;
		}
		cart.modifyQty(pId, newQty);
		return "redirect:/cartConfirm";
	}

}
