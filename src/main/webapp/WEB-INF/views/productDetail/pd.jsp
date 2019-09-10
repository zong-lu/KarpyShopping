<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="subTitle" value="查詢會員資料(Lab05_09)" />
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<!doctype html>
<html class="no-js" lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>Product</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
		
        
        <link rel="stylesheet" href="css/bootstrap.min.css">
      
        <link rel="stylesheet" href="css/animate.css">
        
        <link rel="stylesheet" href="css/jquery-ui.min.css">
      
        <link rel="stylesheet" href="css/meanmenu.min.css">
      
        <link rel="stylesheet" href="lib/css/nivo-slider.css" type="text/css" />
        <link rel="stylesheet" href="lib/css/preview.css" type="text/css" />
        
        <link rel="stylesheet" href="css/owl.carousel.css">
       
        <link rel="stylesheet" href="css/font-awesome.min.css">
        
        <link rel="stylesheet" href="style.css">
      
        <link rel="stylesheet" href="css/responsive.css">
        
        <script src="js/vendor/modernizr-2.8.3.min.js"></script> 
    <body>
  
        <div class="shop_area">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="shop_menu shop_menu_2">
                            
                        </div>
                    </div>
                </div>
            </div><div class="elavator_area">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                            <div class="elavetor">
                                <img id="zoom" src="img/elavetor/small/45.jpg" data-zoom-image="img/elavetor/large/l-8.jpg" alt="">
<%--                                 <img width='100' height='150' src="<c:url value='/getPicture/${product.bookId}'/>" /> --%>
			                                                     
                                <div class="al_zoom">
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                            <div class="elav_titel">
                                <div class="elv_heading">
<%--                                     <h3>${product.title}</h3> --%>

                                </div>
                                <h4>${product.pname}</h4>
                                <div class="price_rating">
                                    <a href="#">
                                    <i class="fa fa-star"></i>
                                    </a>
                                    <a href="#">
                                    <i class="fa fa-star"></i>
                                    </a>
                                    <a href="#">
                                    <i class="fa fa-star"></i>
                                    </a>
                                    <a href="#">
                                    <i class="fa fa-star"></i>
                                    </a>
                                    <a class="not-rated" href="#">
                                    <i class="fa fa-star-o"></i>
                                    </a>
                                    
                                    <a class="review-link" href="#">
                                    (
                                    <span class="count">2</span>
                                    customer reviews)
                                    </a>
                                </div>
        </div>
       
                            <div class="evavet_description">
                            <h4>售價:${product.price}</h4>
<!--                                 <p>	商品介紹: -->
                                    
<!--                                 </p> -->
                            </div>

                            
                            
                            <div class="elavetor_social">
                               
                                <div class="evavet_description">
                                        <p>	 類別: ${product.category } </P>
                                        <p>	 庫存: ${product.amount}  </P>  
                                    </div>
                                

                                <ul class="social-link">
                                    <li><a class="fb" data-original-title="facebook" href="#" title="" data-toggle="tooltip"><i class="fa fa-facebook"></i></a></li>
                                    <li><a class="twit" data-original-title="twitter" href="#" title="" data-toggle="tooltip"><i class="fa fa-twitter"></i></a></li>
                                    <li><a class="pinter" data-original-title="pinterest" href="#" title="" data-toggle="tooltip"><i class="fa fa-pinterest"></i></a></li>
                                    <li><a class="google+" href="#" title="Google+" data-target="#productModal" data-toggle="tooltip"><i class="fa fa-google-plus"></i></a></li>
                                    <li><a class="lindin" href="#" title="LinkedIn" data-target="#productModal" data-toggle="tooltip"><i class="fa fa-linkedin"></i></a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                        <div class="elav_info">
                            <div class="price_box price_box_acr">
                                <!-- <span class="old- price old- price-2">${product.price}打折</span> -->
<%--                                 <span class="spical-price spical-price-2">${product.price}</span  > --%>
<%--                                     <p>商品分類: ${product.category}</p> --%>
<%--                                     <p>商品編號: ${product.bookId}</p> --%>
                            </div>
 
                                <input type="number" value="1">
                                <a href="cart?pId=${product.pId}"><input type="button" class="add-tocart cart_zpf" value="加入購物車"></a>

                            <div ><a href="cartConfirm" > 前往購物車 </a></div>
                            <div class="add_defi">
                                <a href="#" data-original-title="Add to Wishlist" data-toggle="tooltip">
                                <i class="fa fa-heart another_icon"></i>
                                加到最愛
                                </a>
                            </div>
                            <div class="add_defi_2">
                                <a data-original-title="Compare" title="" data-toggle="tooltip" rel="nofollow" data-product_id="45" href=""><i class="fa fa-refresh another_icon"></i> Compare</a>
                            </div>
                           
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
            
                          
                            
       
        
                                                    
