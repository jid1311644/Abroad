<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.actions.RecommendAction" %>
<%@ page import="model.actions.SearchCollegeAction" %>
<%-- <%@ page import="controller.state.State" %> --%>
<!DOCTYPE html>
<html lang="zh-CN">
	<head>
	    <meta charset="UTF-8">     <!--配置编码方式-->
	    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">  <!--配置视窗，设备宽度,禁止用户缩放-->
	    <meta http-equiv="X-UA-Compatible" content="ie=edge">
	    <title>用户信息维护</title>
	    <link rel="stylesheet" href="css/bootstrap.min.css"/>
	    <link rel="stylesheet" href="css/information.css"/>
	    <link rel="stylesheet" href="css/home-page.css"/>
	    <script type="text/javascript" src="js/infomation.js"></script>
	</head>
	<body>
		<nav class="navbar navbar-inverse navbar-fixed-top"><!--导航在最上面-->
	        <div class="container">
	        	<!--小屏幕导航栏和logo-->
	        	<div class="navbar-header">
	        		<button class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
		        		<span class="icon-bar"></span>
		        		<span class="icon-bar"></span>
		        		<span class="icon-bar"></span>
		        	</button>
		        	<a href="index.html" class="navbar-brand"><span class="glyphicon glyphicon-home" aria-hidden="true"></span></a> 
		        	<a href="index.html" class="navbar-brand">FindIt</a> 
	        	</div> 	
	        	<!--小屏幕导航栏和logo-->
	        	<!--导航，在单独的容器层-->
	        	<div class="navbar-collapse collapse">
			    	<ul class="nav navbar-nav navbar-right">
			    	<li><a href="Infomation.jsp">个人信息</a></li>
		    		<li><a href="school.jsp">学校</a></li>
		    		<li><a href="major.html">专业</a></li>
		    		<li><a href="guide.html">使用指南</a></li>
		    		<li><a href="contact.html">联系我们</a></li>
		    		<li><a href="signin.html" onclick="javascript:return confirm('是否要退出?');"><button type="button"  class="btn btn-danger btn-md wide">退出</button></a><li>
		    		<li><a href="regist.html"><button type="button" class="btn btn-info btn-md wide"><span class="
glyphicon glyphicon-user" aria-hidden="true"></span>注册</button></a><li>
			    	</ul>
	    		</div>
	    		<!--导航-->
	        </div>
	    </nav>
		<div class="regist">
			<p class="logo">个人信息</p>
			<hr style="border" />	
			<div class="information">
				<form action="modifyInformation.action" name="InfoForm" class="form-signin">
					<div class="col-lg-6">
						<div class="input-group input-group-lg space-line">
						  <span class="input-group-addon" id="sizing-addon1">性别</span>
						  <input type="text" name="sex" class="form-control" placeholder="请输入“男”或“女”" aria-describedby="sizing-addon1">
						</div>
						<div class="input-group input-group-lg space-line">
						  <span class="input-group-addon" id="sizing-addon1">学历</span>
						  <input type="text" name="education" class="form-control" placeholder="请输入学历" aria-describedby="sizing-addon1">
						</div>
						<div class="input-group input-group-lg space-line">
						  <span class="input-group-addon" id="sizing-addon1">当前学校</span>
						  <input type="text" name="schoolName" class="form-control" placeholder="请输入学校名" aria-describedby="sizing-addon1">
						</div>
						<div class="input-group input-group-lg space-line">
						  <span class="input-group-addon" id="sizing-addon1">地址</span>
						  <input type="text" name="address" class="form-control" placeholder="请输入您的地址" aria-describedby="sizing-addon1">
						</div>
						<div class="input-group input-group-lg space-line">
					  		<span class="input-group-addon" id="sizing-addon1">GPA</span>
					  		<input type="text" name="gpa" class="form-control" placeholder="请输入GPA" aria-describedby="sizing-addon1">
						</div>
						<div class="input-group input-group-lg space-line">
					  		<span class="input-group-addon" id="sizing-addon1">考试类型</span>
					  		<input type="text" name="testType" class="form-control" placeholder="请输入考试类型" aria-describedby="sizing-addon1">
						</div>
						<div class="input-group input-group-lg space-line">
					  		<span class="input-group-addon" id="sizing-addon1">考试成绩</span>
					  		<input type="text" name="score" class="form-control" placeholder="请输入考试成绩" aria-describedby="sizing-addon1">
						</div>
						<!--<p><a href="#" onclick="myFunction()" class="btn btn-primary" role="button">确认提交</a></p>-->
						<button class="btn btn-primary"  onclick="myFunction()" type="submit">确认提交</button>
  					</div><!-- /.col-lg-6 -->
				</form>
				<div class="note">
					
				</div>	
			</div>
		</div>
		<div class="recommend">
			<p class="h2">为你推荐</p>
					
			<%
			RecommendAction r = new RecommendAction();
			r.recommend();
			for(int i = 0; i < r.getRes().size(); i++){
			%>
			
			<div class="thumbnail">
				<a href="#">
					<img class="images" src="<%=SearchCollegeAction.random(i)%>" alt="校园">
				</a>
			    <a href="#">
			    	<div class="caption center">
				       <p><%=r.getRes().get(i) %></p> 
			       	</div>
			    </a>    
			</div>
			
			<% 
			}
			SearchCollegeAction.changeTemp();
			%>
			
			
			
<!-- 			<div class="thumbnail">
				<a href="#">
					<img class="images" src="img/harword.jpg" alt="校园">
				</a>
			    <a href="#">
			    	<div class="caption center">
				       <p>哈佛大学</p> 
			       	</div>
			    </a>    
			</div>
			<div class="thumbnail">
				<a href="#">
					<img class="images" src="img/jz.jpg" alt="校园">
				</a>
			    <a href="#">
			    	<div class="caption center">
				       <p>加州理工学院</p> 
			       	</div>
			    </a>    
			</div>
			<div class="thumbnail">
				<a href="#">
					<img class="images" src="img/pl.jpg" alt="校园">
				</a>
			    <a href="#">
			    	<div class="caption center">
				       <p>普林斯顿大学</p> 
			       	</div>
			    </a>    
			</div>
			<div class="thumbnail">
				<a href="#">
					<img class="images" src="img/ms.jpg" alt="校园">
				</a>
			    <a href="#">
			    	<div class="caption center">
				       <p>麻省理工学院</p> 
			       	</div>
			    </a>    
			</div>
			<div class="thumbnail">
				<a href="#">
					<img class="images" src="img/Stanf.jpg" alt="校园">
				</a>
			    <a href="#">
			    	<div class="caption center">
				       <p>斯坦福大学</p> 
			       	</div>
			    </a>    
			</div>
			<div class="thumbnail">
				<a href="#">
					<img class="images" src="img/yl.jpg" alt="校园">
				</a>
			    <a href="#">
			    	<div class="caption center">
				       <p>耶鲁大学</p> 
			       	</div>
			    </a>    
			</div> -->
		</div>
		<div class="page-footer">
		     <div class="footer-nav">
	    		<p class="h4">快速导航</p><br />
	    		<ul>
	    			<li><a class="footer-list" href="Infomation.jsp">个人信息</a></li><br />
			    	<li><a class="footer-list" href="school.jsp">学校</a></li><br />
			    	<li><a class="footer-list" href="major.html">专业</a></li><br />
			    	<li><a class="footer-list" href="guide.html">使用指南</a></li><br />
			    	<li><a class="footer-list" href="contact.html">联系我们</a></li><br />
	    		</ul>
	    		<div class="con-icon">
	    			<button type="button" class="btn btn-default btn-md">
				    <span class="glyphicon glyphicon-earphone" aria-hidden="true"></span>
					</button>
					<button type="button" class="btn btn-default btn-md">
					    <span class="glyphicon glyphicon-envelope" aria-hidden="true"></span>
					</button>
					<button type="button" class="btn btn-default btn-md">
					    <span class="glyphicon glyphicon-phone-alt" aria-hidden="true"></span>
					</button>
					<button type="button" class="btn btn-default btn-md">
					    <span class="glyphicon glyphicon-map-marker" aria-hidden="true"></span>
					</button>
	    		</div>
	    	</div>
	    	<div class="hot-school">
	    		<div class="all">
	    			<p class="h4">知名大学一览</p>
	    		</div>
	    		<div class="country">
	    			<p class="h5">美国</p><br />
	    			<ul>
		    			<li><a class="footer-list" href="#">普林斯顿大学</a></li>
		    			<li><a class="footer-list" href="#">哈佛大学</a></li>
		    			<li><a class="footer-list" href="#">耶鲁大学</a></li>
		    			<li><a class="footer-list" href="#">哥伦比亚大学</a></li>
		    			<li><a class="footer-list" href="#">斯坦福大学</a></li>
		    			<li><a class="footer-list" href="#">芝加哥大学</a></li>
		    			<li><a class="footer-list" href="#">麻省理工学院</a></li>
		    			<li><a class="footer-list" href="#">杜克大学</a></li>
		    			<li><a class="footer-list" href="#">宾夕法尼亚大学</a></li>
		    			<li><a class="footer-list" href="#">加州理工学院</a></li>
		    		</ul>
	    		</div>
	    		<div class="country">
	    			<p class="h5">澳大利亚</p><br />
	    			<ul>
		    			<li><a class="footer-list" href="#">墨尔本大学</a></li>
		    			<li><a class="footer-list" href="#">悉尼大学</a></li>
		    			<li><a class="footer-list" href="#">澳大利亚昆士兰大学</a></li>
		    			<li><a class="footer-list" href="#">蒙纳士大学</a></li>
		    			<li><a class="footer-list" href="#">澳大利亚国立大学</a></li>
		    			<li><a class="footer-list" href="#">新南威尔士大学</a></li>
		    			<li><a class="footer-list" href="#">西澳大利亚大学</a></li>
		    			<li><a class="footer-list" href="#">阿德莱德大学</a></li>
		    			<li><a class="footer-list" href="#">科廷科技大学</a></li>
		    			<li><a class="footer-list" href="#">麦考瑞大学</a></li>
		    		</ul>
	    		</div>
	    		<div class="country">
	    			<p class="h5">英国</p><br />
	    			<ul>
		    			<li><a class="footer-list" href="#">剑桥大学</a></li>
		    			<li><a class="footer-list" href="#">牛津大学</a></li>
		    			<li><a class="footer-list" href="#">帝国理工大学</a></li>
		    			<li><a class="footer-list" href="#">伦敦大学</a></li>
		    			<li><a class="footer-list" href="#">拉夫堡大学</a></li>
		    			<li><a class="footer-list" href="#">圣安德鲁斯大学</a></li>
		    			<li><a class="footer-list" href="#">杜伦大学</a></li>
		    			<li><a class="footer-list" href="#">华威大学</a></li>
		    			<li><a class="footer-list" href="#">埃克塞特大学</a></li>
		    			<li><a class="footer-list" href="#">伦敦政治经济学院</a></li>
		    		</ul>
	    		</div>
	    		<div class="country">
	    			<p class="h5">韩国</p><br />
	    			<ul>
		    			<li><a class="footer-list" href="#">首尔大学</a></li>
		    			<li><a class="footer-list" href="#">成均馆大学</a></li>
		    			<li><a class="footer-list" href="#">汉阳大学</a></li>
		    			<li><a class="footer-list" href="#">高丽大学</a></li>
		    			<li><a class="footer-list" href="#">延世大学</a></li>
		    			<li><a class="footer-list" href="#">庆熙大学</a></li>
		    			<li><a class="footer-list" href="#">西江大学</a></li>
		    			<li><a class="footer-list" href="#">汉阳大学</a></li>
		    			<li><a class="footer-list" href="#">汉阳大学</a></li>
		    			<li><a class="footer-list" href="#">韩国外国语大学</a></li>
		    		</ul>
	    		</div>
	    		<div class="country">
	    			<p class="h5">日本</p><br />
	    			<ul>
		    			<li><a class="footer-list" href="#">东京大学</a></li>
		    			<li><a class="footer-list" href="#">京都大学</a></li>
		    			<li><a class="footer-list" href="#">大阪大学</a></li>
		    			<li><a class="footer-list" href="#">东京工业大学</a></li>
		    			<li><a class="footer-list" href="#">东北大学</a></li>
		    			<li><a class="footer-list" href="#">名古屋大学</a></li>
		    			<li><a class="footer-list" href="#">北海道大学</a></li>
		    			<li><a class="footer-list" href="#">九州大学</a></li>
		    			<li><a class="footer-list" href="#">庆应义塾大学</a></li>
		    			<li><a class="footer-list" href="#">早稻田大学</a></li>
		    		</ul>
	    		</div>
	    		<div class="country">
	    			<p class="h5">德国</p><br />
	    			<ul>
		    			<li><a class="footer-list" href="#">慕尼黑大学</a></li>
		    			<li><a class="footer-list" href="#">慕尼黑工业大学</a></li>
		    			<li><a class="footer-list" href="#">海德堡大学</a></li>
		    			<li><a class="footer-list" href="#">柏林洪堡大学</a></li>
		    			<li><a class="footer-list" href="#">亚琛工业大学</a></li>
		    			<li><a class="footer-list" href="#">弗莱堡大学</a></li>
		    			<li><a class="footer-list" href="#">柏林自由大学</a></li>
		    			<li><a class="footer-list" href="#">柏林工业大学</a></li>
		    			<li><a class="footer-list" href="#">图灵根大学</a></li>
		    			<li><a class="footer-list" href="#">波恩大学</a></li>
		    		</ul>
	    		</div>
	    		<div class="country">
	    			<p class="h5">新加坡</p><br />
	    			<ul>
		    			<li><a class="footer-list" href="#">新加坡管理学院</a></li>
		    			<li><a class="footer-list" href="#">新加坡管理发展学院</a></li>
		    			<li><a class="footer-list" href="#">新加坡PSB学院</a></li>
		    			<li><a class="footer-list" href="#">新加坡设计与科技学院</a></li>
		    			<li><a class="footer-list" href="#">新加坡商学院</a></li>
		    			<li><a class="footer-list" href="#">新加坡东亚管理学院</a></li>
		    			<li><a class="footer-list" href="#">新加坡亚太商学院</a></li>
		    			<li><a class="footer-list" href="#">新加坡英华美学院</a></li>
		    			<li><a class="footer-list" href="#">新加坡FTC培训中心</a></li>
		    			<li><a class="footer-list" href="#">新加坡TMC学院</a></li>
		    		</ul>
	    		</div>
	    	</div>
		</div>
	</body>
</html>