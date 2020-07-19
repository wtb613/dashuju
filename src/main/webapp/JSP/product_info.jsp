<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>详情展示</title>

		<!--css样式-->
		<style type="text/css">
			#imgId5{
				margin-left: 275px;
			}
			/*控制超链接下划线*/
			a{
				text-decoration: none;
			}
			
		</style>
	
	</head>

	<body>
		<table   width="100%">
			<!--第一行：存放logo信息   嵌套一个一行三列的表格 -->
			<tr>
				<td>
					<table   width="100%" >
						<tr>
							<td>
								<img src="${pageContext.request.contextPath}/img/logo.jpg" />
							</td>
							<td >
								<img src="${pageContext.request.contextPath}/img/img5.jpg" id="imgId5"/>&nbsp;&nbsp;
								<img src="${pageContext.request.contextPath}/img/img6.jpg" />&nbsp;&nbsp;
								<img src="${pageContext.request.contextPath}/img/img7.jpg" />&nbsp;&nbsp;
								<img src="${pageContext.request.contextPath}/img/img4.jpg" />
							</td>
							<td>
							<c:choose>
								<c:when test="${sessionScope.user!=null}">
									欢迎：${sessionScope.user.userName} &nbsp;&nbsp;
									<a href="${pageContext.request.contextPath}/ExitServlet?method=exit"><font color="#337AB7">退出</font></a>&nbsp;&nbsp;
									<a href="${pageContext.request.contextPath}/JSP/cart.jsp"><font color="#337AB7">购物车</font></a>&nbsp;&nbsp;
								</c:when>
								<c:otherwise>
									<a href="${pageContext.request.contextPath}/JSP/login.jsp"><font color="#337AB7">登录</font></a>&nbsp;&nbsp;
									<a href="${pageContext.request.contextPath}/JSP/register.jsp"><font color="#337AB7">注册</font></a>&nbsp;&nbsp;
									<a href="${pageContext.request.contextPath}/JSP/cart.jsp"><font color="#337AB7">购物车</font></a>&nbsp;&nbsp;
								</c:otherwise>
							</c:choose>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<!--第二行：存放菜单信息  背景黑色 超链接颜色为白色-->
			<tr bgcolor="#808080" height="50px">
				<td>
					<a href="${pageContext.request.contextPath}/JSP/index.jsp"><font color="white">首页</font></a>&nbsp;&nbsp;&nbsp;
					<a href=""><font color="white">精品手机</font></a>&nbsp;&nbsp;&nbsp;
					<a href=""><font color="white">数码时尚</font></a>&nbsp;&nbsp;&nbsp;
					<a href=""><font color="white">办公设备</font></a>&nbsp;&nbsp;&nbsp;
					<a href=""><font color="white">主板显卡</font></a>&nbsp;&nbsp;&nbsp;
					<a href=""><font color="white">智能设备</font></a>&nbsp;&nbsp;&nbsp;
					<a href=""><font color="white">Macbook</font></a>&nbsp;&nbsp;&nbsp;
				</td>
			</tr>
			<tr>
				<td>
					<div class="container">
						<div class="row">
							<div style="border: 1px solid #e4e4e4;width:930px;margin-bottom:10px;margin:0 auto;padding:10px;margin-bottom:10px;">
								<a href="${pageContext.request.contextPath}/JSP/index.jsp">首页&nbsp;&nbsp;&gt;</a>
								<a>商品信息</a>
							</div>
			
							<div style="margin:0 auto;width:950px;"style="float:left;">
								<div class="col-md-6">
									<img style="opacity: 1;width:400px;height:350px;" title="" class="medium" src="${pageContext.request.contextPath}/${requestScope.product.pro_min_img}">

										<div class="col-md-6" style="float: right;">
											<form action="${pageContext.request.contextPath}/CartServlet?method=addCart" method="post" >
												<input type="hidden" name="productId" value="${requestScope.product.pro_id}">
													<div><strong>${requestScope.product.pro_name}</strong></div>
													<div style="border-bottom: 1px dotted #dddddd;width:350px;margin:10px 0 10px 0;">
														<div>编号：${requestScope.product.pro_num}</div>
													</div>

													<div style="margin:10px 0 10px 0;">亿家价: <strong style="color:#ef0101;">￥：${requestScope.product.shop_price}元/份</strong> 参 考 价： <del>￥:${requestScope.product.market_price}元/份</del>
													</div>

													<div style="margin:10px 0 10px 0;">促销: <a target="_blank" title="限时抢购 (2014-07-30 ~ 2015-01-01)" style="background-color: #f07373;">限时抢购</a> </div>

													<div style="padding:10px;border:1px solid #e7dbb1;width:330px;margin:15px 0 10px 0;;background-color: #fffee6;">
														<div style="margin:5px 0 10px 0;">${requestScope.product.pro_color}</div>

														<div style="border-bottom: 1px solid #faeac7;margin-top:20px;padding-left: 10px;">购买数量:
															<input id="quantity" name="quantity" value="1" maxlength="4" size="10" type="text"> </div>

														<div style="margin:20px 0 10px 0;;text-align: center;">
																<input style="background: url('${pageContext.request.contextPath}/img/product.gif') no-repeat scroll 0 -600px rgba(0, 0, 0, 0);height:36px;width:127px;" value="加入购物车" type="submit">
															&nbsp;收藏商品
														</div>
												</div>
											</form>
										</div>


							</div>
							</div>
							<div class="clear"></div>
							<div style="width:950px;margin:0 auto;">
								
								<div style="background-color:#d3d3d3;width:930px;padding:10px 10px;margin:10px 0 10px 0;">
									<strong>商品参数</strong>
								</div>
								<div style="margin-top:10px;width:950px;">
									<table  border="1" width="100%" cellpadding="0" cellspacing="0"  >
										<tbody>
											<tr class="active">
												<th colspan="2">基本参数</th>
											</tr>
											<tr>
												<th width="10%">级别</th>
												<td width="30%">标准</td>
											</tr>
											<tr>
												<th width="10%">标重</th>
												<td>500</td>
											</tr>
											<tr>
												<th width="10%">浮动</th>
												<td>200</td>
											</tr>
										</tbody>
									</table>
								</div>
			
								<div style="background-color:#d3d3d3;width:930px;padding:10px 10px;margin:10px 0 10px 0;">
									<strong>商品介绍</strong>
								</div>
			
								<div>
									<img src="${pageContext.request.contextPath}/${requestScope.product.pro_max_img}">
								</div>
							</div>
			
						</div>
					</div>
				</td>
			</tr>
			<!--第八行：存放友情链接-->
			<tr>
				<td>
					<p align="center">
						<a href=""><font color="#337AB7">关于我们</font></a>&nbsp;&nbsp;
						<a href=""><font color="#337AB7">联系我们</font></a>&nbsp;&nbsp;
						<a href=""><font color="#337AB7">联系客服</font></a>&nbsp;&nbsp;
						<a href=""><font color="#337AB7">合作招商</font></a>&nbsp;&nbsp;
						<a href=""><font color="#337AB7">商家帮助</font></a>&nbsp;&nbsp;
						<a href=""><font color="#337AB7">营销中心</font></a>&nbsp;&nbsp;
						<a href=""><font color="#337AB7">手机帮助</font></a>&nbsp;&nbsp;
						<a href=""><font color="#337AB7">销售联盟</font></a>&nbsp;&nbsp;
					</p>
				</td>
			</tr>
			<!--第九行：存放版权信息-->
			<tr>
				<td align="center">
					© 2005-2020 东易买 版权所有，并保留所有权利
				</td>
			</tr>
		</table>
	</body>

</html>