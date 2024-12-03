<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!doctype html>
<html lang="ko">
 <head>
  <meta charset="UTF-8">
  <meta name="Generator" content="EditPlus®">
  <meta name="Author" content="JSL">
  <meta name="Keywords" content="반응형홈페이지,  JAVA, JSP, PHP, 대전직업전문학교, 대전국비지원, 국비무료">
  <meta name="Description" content="응용SW개발자를 위한 반응형 홈페이지">
  <title>JSL인재개발원</title>
  <link href="/resources/css/font-awesome.min.css" rel="stylesheet">
  <link href="/resources/css/common.css" rel="stylesheet">
  <link href="/resources/css/layout.css" rel='stylesheet'>
  
  <!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> -->
  <script src="/resources/js/jquery-3.3.1.min.js"></script>
  

 </head>
 <body>

	<div class="top_navigation">
	
		<header class="header">
			<nav class="top_left">
			  <ul>
			  	<li class="first"><a href="/">HOME</a></li>
				<li><a href="">모집안내</a></li>
				<li><a href="">입학상담</a></li>
				<li><a href="">교육신청</a></li>
			  </ul>
			</nav>
			<nav class="top_right">
				<ul>
					<c:choose>
						<c:when test="${empty login }">
							<li class="first"><a href="/mem/login.do">로그인</a></li>
							<li><a href="/mem/terms.do">회원가입</a></li>
						</c:when>
						<c:when test="${not empty login }">
							<li class="first">${login.username} 님</li>
							<li class="first"><a href="/mem/logout.do">로그아웃</a></li>
							<li><a href="">마이페이지</a></li>
						</c:when>
					</c:choose>
				</ul>
			</nav>
			
			<div class="gnb_group">
				<h1 class="logo">JSL CO</h1>
				<nav class="gnb">
					<ul class="nav_1depth">
						<li><a href="gratings.html">기업소개</a>
							<ul class="nav_2depth">
								<li><a href="about/gratings.html">인사말</a></li>
								<li><a href="about/history.html">연혁 및 </a></li>
								<li><a href="about/gratings.html">교직원소개</a></li>
								<li><a href="gallery/photo.html">대우갤러리</a></li>
								<li><a href="about/map.html">찾아오시는길</a></li>
							</ul>
						</li>
						<!--<li><a href="allclass.html">학과및모집안내</a>
							<ul class="nav_2depth">
								<li><a href="#">전체모집과정</a></li>
								<li><a href="#">스마트웹콘텐츠개발과정</a></li>
							</ul>
						</li> -->
						<li><a href="/port/list.do">포트폴리오</a>
							<ul class="nav_2depth">
								<li><a href="/port/list.do">포트폴리오</a></li>
							</ul>
						</li>
						<!-- <li><a href="online.html">온라인접수</a>
							<ul class="nav_2depth">
								<li><a href="#">온라인접수</a></li>
								<li><a href="#">취업성공패키지</a></li>
							</ul>
						</li> -->
						<li><a href="/np/list.do">커뮤니티</a>
							<ul class="nav_2depth">
								<li><a href="/np/list.do">공지사항</a></li>
								<li><a href="qna/qa.html">질문과답변</a></li>
								<li><a href="faq/faq.html">FAQ</a></li>
								<li><a href="pds/pds.html">자료실</a></li>
								<li><a href="adm/admin.html">관리자</a></li>
							</ul>
						</li>
					</ul>
				</nav>
			</div>
		</header>

		<div class="line">
		</div>

	</div>

	<script>
		//$(document).ready(function() {
		$(function() {
			$(".gnb>.nav_1depth>li").hover(function() {
				$(".gnb>.nav_1depth>li").removeClass();
				$(this).addClass("active");

				//$(this).children(".nav_2depth").show();
				//}, function() {
				//  $(".gnb>.nav_1depth>li").removeClass();
				//  $(this).children(".nav_2depth").hide();
				//	});

				$(this).children(".nav_2depth").stop().slideDown("fast");
				}, function() {
				  $(".gnb>.nav_1depth>li").removeClass();
				  $(this).children(".nav_2depth").stop().slideUp("fast");
					});

				/* $(this).children(".nav_2depth").fadeIn();
				}, function() {
				  $(".gnb>.nav_1depth>li").removeClass();
				  $(this).children(".nav_2depth").fadeOut();
					}); */

			});
	</script>