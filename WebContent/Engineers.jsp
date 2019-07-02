<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="model.db.major_type.MajorTypeBean" %>
<%@ page import="java.util.HashMap" %>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">     <!--配置编码方式-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">  <!--配置视窗，设备宽度,禁止用户缩放-->
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>工程类排行榜</title>
    <link rel="stylesheet" href="css/bootstrap.min.css"></link>
        <!--jQuery的引入一定要在bootstrap之前-->
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/home-page.css"/>
    <link rel="stylesheet" href="css/arts.css"/>
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
    <section id="arts">
    	<div class="lvjing">
    		<h1>工程类专业排名</h1>
    	</div>
    </section>
	<div class="list">
		<p class="table-note">工程类强校排名</p>
		<%
			MajorTypeBean table=new MajorTypeBean();
			HashMap<Integer, MajorTypeBean> res=table.getEngineering();
			//out.println(res);
		%>
		<table class="table">
			<thead>
				<tr>
					<th class="text-size">排名</th>
					<th class="text-size">学校</th>
					<th class="text-size">国家</th>
					<th class="text-size">综合</th>
					<th class="text-size">师资</th>
					<th class="text-size">科研</th>
					<th class="text-size">知名度</th>
					<th class="text-size">产业</th>
					<th class="text-size">环境</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th scope="row">1</th>
					<td><a class="text-size" href="#"><%=res.get(1).getName() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(1).getCountry() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(1).getOverall() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(1).getTeaching() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(1).getResearch() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(1).getCitations() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(1).getIndustry() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(1).getOutlook() %></a></td>
				</tr>
				<tr>
					<th scope="row">2</th>
					<td><a class="text-size" href="#"><%=res.get(2).getName() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(2).getCountry() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(2).getOverall() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(2).getTeaching() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(2).getResearch() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(2).getCitations() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(2).getIndustry() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(2).getOutlook() %></a></td>
				</tr>
				<tr>
					<th scope="row">3</th>
					<td><a class="text-size" href="#"><%=res.get(3).getName() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(3).getCountry() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(3).getOverall() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(3).getTeaching() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(3).getResearch() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(3).getCitations() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(3).getIndustry() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(3).getOutlook() %></a></td>
				</tr>
				<tr>
					<th scope="row">4</th>
					<td><a class="text-size" href="#"><%=res.get(4).getName() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(4).getCountry() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(4).getOverall() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(4).getTeaching() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(4).getResearch() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(4).getCitations() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(4).getIndustry() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(4).getOutlook() %></a></td>
				</tr>
				<tr>
					<th scope="row">5</th>
					<td><a class="text-size" href="#"><%=res.get(5).getName() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(5).getCountry() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(5).getOverall() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(5).getTeaching() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(5).getResearch() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(5).getCitations() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(5).getIndustry() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(5).getOutlook() %></a></td>
				</tr>
				<tr>
					<th scope="row">6</th>
					<td><a class="text-size" href="#"><%=res.get(6).getName() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(6).getCountry() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(6).getOverall() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(6).getTeaching() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(6).getResearch() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(6).getCitations() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(6).getIndustry() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(6).getOutlook() %></a></td>
				</tr>
				<tr>
					<th scope="row">7</th>
					<td><a class="text-size" href="#"><%=res.get(7).getName() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(7).getCountry() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(7).getOverall() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(7).getTeaching() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(7).getResearch() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(7).getCitations() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(7).getIndustry() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(7).getOutlook() %></a></td>
				</tr>
				<tr>
					<th scope="row">8</th>
					<td><a class="text-size" href="#"><%=res.get(8).getName() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(8).getCountry() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(8).getOverall() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(8).getTeaching() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(8).getResearch() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(8).getCitations() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(8).getIndustry() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(8).getOutlook() %></a></td>
				</tr>
				<tr>
					<th scope="row">9</th>
					<td><a class="text-size" href="#"><%=res.get(9).getName() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(9).getCountry() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(9).getOverall() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(9).getTeaching() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(9).getResearch() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(9).getCitations() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(9).getIndustry() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(9).getOutlook() %></a></td>
				</tr>
				<tr>
					<th scope="row">10</th>
					<td><a class="text-size" href="#"><%=res.get(10).getName() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(10).getCountry() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(10).getOverall() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(10).getTeaching() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(10).getResearch() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(10).getCitations() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(10).getIndustry() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(10).getOutlook() %></a></td>
				</tr>
				<tr>
					<th scope="row">11</th>
					<td><a class="text-size" href="#"><%=res.get(11).getName() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(11).getCountry() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(11).getOverall() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(11).getTeaching() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(11).getResearch() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(11).getCitations() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(11).getIndustry() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(11).getOutlook() %></a></td>
				</tr>
				<tr>
					<th scope="row">12</th>
					<td><a class="text-size" href="#"><%=res.get(12).getName() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(12).getCountry() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(12).getOverall() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(12).getTeaching() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(12).getResearch() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(12).getCitations() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(12).getIndustry() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(12).getOutlook() %></a></td>
				</tr>
				<tr>
					<th scope="row">13</th>
					<td><a class="text-size" href="#"><%=res.get(13).getName() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(13).getCountry() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(13).getOverall() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(13).getTeaching() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(13).getResearch() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(13).getCitations() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(13).getIndustry() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(13).getOutlook() %></a></td>
				</tr>
				<tr>
					<th scope="row">14</th>
					<td><a class="text-size" href="#"><%=res.get(14).getName() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(14).getCountry() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(14).getOverall() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(14).getTeaching() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(14).getResearch() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(14).getCitations() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(14).getIndustry() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(14).getOutlook() %></a></td>
				</tr>
				<tr>
					<th scope="row">15</th>
					<td><a class="text-size" href="#"><%=res.get(15).getName() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(15).getCountry() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(15).getOverall() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(15).getTeaching() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(15).getResearch() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(15).getCitations() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(15).getIndustry() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(15).getOutlook() %></a></td>
				</tr>
				<tr>
					<th scope="row">16</th>
					<td><a class="text-size" href="#"><%=res.get(16).getName() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(16).getCountry() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(16).getOverall() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(16).getTeaching() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(16).getResearch() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(16).getCitations() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(16).getIndustry() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(16).getOutlook() %></a></td>
				</tr>
				<tr>
					<th scope="row">17</th>
					<td><a class="text-size" href="#"><%=res.get(17).getName() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(17).getCountry() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(17).getOverall() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(17).getTeaching() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(17).getResearch() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(17).getCitations() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(17).getIndustry() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(17).getOutlook() %></a></td>
				</tr>
				<tr>
					<th scope="row">18</th>
					<td><a class="text-size" href="#"><%=res.get(18).getName() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(18).getCountry() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(18).getOverall() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(18).getTeaching() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(18).getResearch() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(18).getCitations() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(18).getIndustry() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(18).getOutlook() %></a></td>
				</tr>
				<tr>
					<th scope="row">19</th>
					<td><a class="text-size" href="#"><%=res.get(19).getName() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(19).getCountry() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(19).getOverall() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(19).getTeaching() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(19).getResearch() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(19).getCitations() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(19).getIndustry() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(19).getOutlook() %></a></td>
				</tr>
				<tr>
					<th scope="row">20</th>
					<td><a class="text-size" href="#"><%=res.get(20).getName() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(20).getCountry() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(20).getOverall() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(20).getTeaching() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(20).getResearch() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(20).getCitations() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(20).getIndustry() %></a></td>
					<td><a class="text-size" href="#"><%=res.get(20).getOutlook() %></a></td>
				</tr>
			</tbody>
		</table>
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