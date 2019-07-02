<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="model.db.major.MajorBean" %>
<%@ page import="java.util.HashMap" %>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">     <!--配置编码方式-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">  <!--配置视窗，设备宽度,禁止用户缩放-->
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>专业详情</title>
    <link rel="stylesheet" href="css/bootstrap.min.css"></link>
    <link rel="stylesheet" href="css/home-page.css"/></link>
    <link rel="stylesheet" href="css/major-infor.css"/></link>
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/stanford.js"></script>
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
    <section id="major-detail">
    	<div class="lvjing">
    		<h1>了解专业详情</h1>
    		<p>
    			明确职业选择
    		</p>
    	</div>
    </section>
	<div class="panel center">
		<div class="panel panel-default">
	    <div class="panel-body">
	   		<h1>美术</h1><br />
	   		<div class="image">
				<img src="img/art.jpg"/>
			</div><br />
			<%
				MajorBean content=new MajorBean();
				HashMap<Integer, String> res=content.getArtDetail();
			%>
	   		<p class="txt"><%=res.get(0) %></p>	
			<br /><br />
			<div id="more" class="collapse in">
				<strong><%=res.get(1) %></strong><br /><br />
				<p class="txt"><%=res.get(2) %></p>
				<strong><%=res.get(3) %></strong><br /><br />
				<p class="txt"><%=res.get(4) %></p>
				<strong><%=res.get(5) %></strong><br /><br />
				<p class="txt"><%=res.get(6) %></p>
			</div><br /><br />
			<div class="like-btn">
			    	<button type="button" id="star" class="btn btn-default btn-lg"  onclick="changecolor()" >
					    <span class="glyphicon glyphicon-star"></span> 收藏
					</button>
			</div><br />
	</div>
	    </div>
	</div>
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