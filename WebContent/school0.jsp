<!DOCTYPE html>
<html lang="zh-CN">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.actions.SearchCollegeAction" %>
<%@ page import="random.Random" %>
<html>
	<head>
		<meta charset="UTF-8">     <!--配置编码方式-->
	    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">  <!--配置视窗，设备宽度,禁止用户缩放-->
	    <meta http-equiv="X-UA-Compatible" content="ie=edge">
	    <title>学校信息</title>
	    <link rel="stylesheet" href="css/bootstrap.min.css"/>
	    <link rel="stylesheet" href="css/school.css"/>
	    <link rel="stylesheet" href="css/home-page.css"/>
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
		    		<li><a href="signin.html"><button type="button" class="btn btn-danger btn-md wide">登录</button></a><li>
		    		<li><a href="regist.html"><button type="button" class="btn btn-info btn-md wide"><span class="
glyphicon glyphicon-user" aria-hidden="true"></span>注册</button></a><li>
			    	</ul>
	    		</div>
	    		<!--导航-->
	        </div>
	    </nav>
	    <!--banner开始-->
	    <div class="banner">
	    	<div class="row">
	  			<div class="col-lg-12">
	  				<div class="space">
	  					<h2 class="center">搜索学校</h2>
			        	<div class="input-group" "center">
			        		<form action="name-search" name="school-name" class="form-signin">
					     		<input type="text" name="key" class="form-control" placeholder="Search for...">
					      		<span class="input-group-btn">
					        		<button type="submit" class="btn btn-default" type="button">Search</button>
					     		</span>
				     		</form>
			   		 	</div><!-- /input-group -->
	  				</div>
	    		</div><!-- /.col-lg-6 -->
    		</div><!-- /.row -->
	    </div><!--banner结束-->
	    <!--筛选条件-->
		<div class="condition">
			<br/><h3>选择条件</h3><br/><br/>
			<!--条件表单-->
			<form action="search" name="conditionForm" class="form-signin">
				<label><p>学制</p></label><br />
			   <label class="checkbox-inline">
			      <input type="radio" name="length" id="short" 
			         value="option1" checked>4年
			   </label><br />
			   <label class="checkbox-inline">
			      <input type="radio" name="length" id="middle" 
			         value="option2"> 2-4年
			   </label><br />
			   <label class="checkbox-inline">
			      <input type="radio" name="length" id="long" 
			         value="option3"> 2年以内
			   </label><br /><br />
			   <label><p>办学类型</p></label><br />
			   <label class="checkbox-inline">
			      <input type="radio" name="type" id="public" 
			         value="option1"> 公立
			   </label><br />
			   <label class="checkbox-inline">
			      <input type="radio" name="type" id="private" 
			         value="option2"> 私立
			   </label><br /><br />
			   <label><p>学费</p></label><br />
			   <label class="checkbox-inline">
			      <input type="radio" name="price" id="lowest" 
			         value="option1"> $10000以下
			   </label><br />
			   <label class="checkbox-inline">
			      <input type="radio" name="price" id="low" 
			         value="option2"> $10000-$30000
			   </label><br />
			   <label class="checkbox-inline">
			      <input type="radio" name="price" id="high" 
			         value="option3"> $30000-$50000
			   </label><br />
			   <label class="checkbox-inline">
			      <input type="radio" name="price" id="highest" 
			         value="option4"> 不限
			   </label><br /><br />
			   
				<label><p>考试类型</p></label><br />
			    <label class="checkbox-inline">
			      <input type="radio" name="exam" id="sat" 
			         value="option1"> SAT
			   </label><br />
			    <label class="checkbox-inline">
			      <input type="radio" name="exam" id="gre" 
			         value="option2"> GRE
			   </label><br /><br />
				<label><p>考试成绩</p></label><br />
				<div class="input-group">
	  				<span class="input-group-addon" id="basic-addon1">分数</span>
	  				<input type="text" name="score" class="form-control" aria-describedby="basic-addon1">
				</div><br /><br />
				<button type="submit" class="btn btn-primary">查找</button>
			</form>
			<!--筛选条件结束-->
		</div>
		
		<div class="show">
			<div class="row1">
			<%
				if(SearchCollegeAction.isFirst()){
					SearchCollegeAction.init();
					SearchCollegeAction.setFirst(false);
				}
				System.out.println(SearchCollegeAction.getRes().toString());
				
				for(int i = 0; i < SearchCollegeAction.getRes().size(); i++){
				%>
				
				<div class="thumbnail">
					<% System.out.println(SearchCollegeAction.getRes().get(i).toString());%>
			        <img class="images" src="<%=SearchCollegeAction.random(i)%>" alt="<%=SearchCollegeAction.getRes().get(i).getName()%>">
				     <div class="caption">
				        <a href="school-info.html"><h3><%=SearchCollegeAction.getRes().get(i).getName()%></h3></a>
				        <p>地址：哈佛大学（Harvard University），坐落于美国马萨诸塞州波士顿都市区剑桥市，是一所享誉世界的私立研究型大学，是著名的常春藤盟校成员。</p>
				        <p>办学类型：<%=SearchCollegeAction.getRes().get(i).getInstitutionType()%></p>
				        <p>学费：$<%=SearchCollegeAction.getRes().get(i).getTuitionOutOfState()%>/每年</p>
				        <p>通过率：<%=SearchCollegeAction.getRes().get(i).getAcceptanceRate()%>%</p>
				        <p><a href="#" class="btn btn-primary" role="button">喜欢</a> <a href="#" class="btn btn-default" role="button">不喜欢</a></p>
			       	</div>
			  	</div>
				
				<% 
				}
			%>
		
			
				<<!-- div class="thumbnail">400*250-的图
			        <img class="images" src="img/jz.jpg" alt="加州">
				    <div class="caption">
				        <a href="school-info.html"><h3>加州理工学院</h3></a>
				        <p>地址：加州理工学院(California Institute of Technology)，位于美国加利福尼亚州洛杉矶东北郊的帕萨迪纳市(Pasadena)，是世界著名私立研究型大学。 </p>
				        <p>办学类型：私立</p>
				        <p>学费：20000$/年</p>
				        <p>通过率：</p>
				        <p><a href="#" class="btn btn-primary" role="button">喜欢</a> <a href="#" class="btn btn-default" role="button">不喜欢</a></p>
			       	</div>
			  	</div>
			  	<div class="thumbnail">400*250-的图
			        <img class="images" src="img/ms.jpg" alt="麻省理工学院">
				    <div class="caption">
				        <a href="school-info.html"><h3>麻省理工学院</h3></a>
				        <p>地址：麻省理工学院（Massachusetts Institute of Technology），坐落于美国马萨诸塞州波士顿都市区剑桥市，是世界著名私立研究型大学。</p>
				        <p>办学类型：私立</p>
				        <p>学费：20000$/年</p>
				        <p>通过率：</p>
				        <p><a href="#" class="btn btn-primary" role="button">喜欢</a> <a href="#" class="btn btn-default" role="button">不喜欢</a></p>
			       	</div>
			  	</div>
			  	<div class="thumbnail">400*250-的图
			        <img class="images" src="img/pl.jpg" alt="普林斯顿">
				    <div class="caption">
				        <a href="school-info.html"><h3>普林斯顿大学</h3></a>
				        <p>地址：普林斯顿大学（Princeton University），简称普林斯顿（Princeton），是世界著名私立研究型大学，位于美国新泽西州的普林斯顿。</p>
				        <p>办学类型：私立</p>
				        <p>学费：20000$/年</p>
				        <p>通过率：</p>
				        <p><a href="#" class="btn btn-primary" role="button">喜欢</a> <a href="#" class="btn btn-default" role="button">不喜欢</a></p>
			       	</div>
			  	</div>
			  	<div class="thumbnail">400*250-的图
			        <img class="images" src="img/Stanf.jpg" alt="斯坦福">
				    <div class="caption">
				        <a href="school-info.html"><h3>斯坦福大学</h3></a>
				        <p>地址：斯坦福大学（Stanford University），位于美国加州旧金山湾区南部的帕罗奥多市（Palo Alto）境内 ，是世界著名的私立研究型大学 。</p>
				        <p>办学类型：私立</p>
				        <p>学费：20000$/年</p>
				        <p>通过率：</p>
				        <p><a href="#" class="btn btn-primary" role="button">喜欢</a> <a href="#" class="btn btn-default" role="button">不喜欢</a></p>
			       	</div>
			  	</div>
			  	<div class="thumbnail">400*250-的图
			        <img class="images" src="img/yl.jpg" alt="耶鲁">
				    <div class="caption">
				        <a href="school-info.html"><h3>耶鲁大学</h3></a>
				        <p>地址：耶鲁大学（Yale University），简称“耶鲁（Yale）”，坐落于美国康涅狄格州纽黑文，是一所的世界著名私立研究型大学。</p>
				        <p>办学类型：私立</p>
				        <p>学费：20000$/年</p>
				        <p>通过率：</p>
				        <p><a href="#" class="btn btn-primary" role="button">喜欢</a> <a href="#" class="btn btn-default" role="button">不喜欢</a></p>
			       	</div>
			  	</div> -->
			</div>
			<!--分页导航栏-->
			<div class="pages">
				<nav aria-label="Page navigation" class="center">
				  <ul class="pagination">
				    <li>
				        <a href="#" aria-label="Previous">
				        	<span aria-hidden="true">&laquo;</span>
				        </a>
					    </li>
					    <li><a href="#">1</a></li>
					    <li><a href="#">2</a></li>
					    <li><a href="#">3</a></li>
					    <li><a href="#">4</a></li>
					    <li><a href="#">5</a></li>
					    <li>
				        <a href="#" aria-label="Next">
				        <span aria-hidden="true">&raquo;</span>
				      </a>
				    </li>
				  </ul>
				</nav>
			</div><!--分页导航栏-->
		</div>
		<!----- footer ----->
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
		<!----- footer ----->
	</body>
	
</html>
