<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/header.jsp"%>
<!-- sub contents -->
	<div class="sub_title">
		<h2>포트폴리오</h2>
		<div class="container">
		  <div class="location">
			<ul>
				<li class="btn_home">
					<a href="/"><i class="fa fa-home btn_plus"></i></a>
				</li>
				<li class="dropdown">
					<a href="">포트폴리오<i class="fa fa-plus btn_plus"></i></a>
					<div class="dropdown_menu">
						<a href="../about/gratings.html">기업소개</a>
						<a href="../portfolio/portfolio.html">포트폴리오</a>
						<a href="../notice/notice.html">커뮤니티</a>
					</div>
				</li>
				<li class="dropdown">
					<a href="">포트폴리오<i class="fa fa-plus btn_plus"></i></a>
					<div class="dropdown_menu">
						<a href="/port/list.do">포트폴리오</a>
					</div>
				</li>
			</ul>
		  </div>
		</div><!-- container end -->
	</div>

	<div class="container">
	  <div class="write_wrap">
	  <h2 class="sr-only">포트폴리오 글쓰기</h2>
	  <form name="portfolio" method="post" enctype = "multipart/form-data" action="/port/modifypro.do?idx=${modify.idx}" onsubmit="return check()">
	  <!-- action을 처리하기전에 check()사용자 함수를 실행하고 되돌아 와라-->
	  	<input type="hidden" name = "imgurl" value="${modify.imgurl }">
			<table class="bord_table">
				<caption class="sr-only">포트폴리오 입력 표</caption>
				<colgroup>
					<col width="20%">
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
						<th>작성자</th>
						<td colspan="2"><input type="text" name="writer" readonly="readonly" value="${modify.writer}"></td>
					</tr>
					<tr>
						<th>제목</th>
						<td colspan="2"><input type="text" name="title" value="${modify.title}"></td>
					</tr>
					<tr>
						<th>내용</th>
						<td colspan="2"><textarea name="content">${modify.content}</textarea></td>
					</tr>
					<tr>
						<th>첨부</th>
						<td><input type="file" name="image">
						<img src="/upload/${modify.imgurl}" style = "width:100px;"></td>
					</tr>
				</tbody>
			</table>
			<div class="btn_wrap">
				<input type="submit" value="저장" class="btn_ok">&nbsp;&nbsp;
				<input type="reset" value="다시쓰기" class="btn_reset">&nbsp;&nbsp;
				<input type="button" value="목록" class="btn_list" onClick="location.href='/port/list.do';">
			</div>
		</form>
	  </div>
	  
	</div>
	<!-- end contents -->
	<script>
		function check() {
			
			if(portfolio.title.value=="") {
				alert("제목을 입력");
				portfolio.title.focus();
				return false;
			}
			if(portfolio.content.value=="") {
				alert("내용을 입력");
				portfolio.content.focus();
				return false;
			}
			return true;
		}
	</script>
	<script>
		$(function() {
			$(".location  .dropdown > a").on("click",function(e) {
				e.preventDefault();
				if($(this).next().is(":visible")) {
					$(".location  .dropdown > a").next().hide();
				} else {
					$(".location  .dropdown > a").next().hide();
					$(this).next().show();
				}
			});
		});
	</script>
<%@ include file = "/footer.jsp"%>