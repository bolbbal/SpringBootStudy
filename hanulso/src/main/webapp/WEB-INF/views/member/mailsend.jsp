<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
	<!-- sub contents -->

	<div class="sub_title">
		<h2>인증 메일 보내기</h2>
		<div class="container">
		  <div class="location">
			<ul>
				<li class="btn_home">
					<a href="index.html"><i class="fa fa-home btn_plus"></i></a>
				</li>
				<li class="dropdown">
					<a href="">커뮤니티<i class="fa fa-plus btn_plus"></i></a>
					<div class="dropdown_menu">
						<a href="gratings.html">공지사항</a>
						<a href="allclass.html">학과및모집안내</a>
						<a href="portfolio.html">포트폴리오</a>
						<a href="online.html">온라인접수</a>
						<a href="notice.html">커뮤니티</a>
					</div>
				</li>
				
				<li class="dropdown">
					<a href="">공지사항<i class="fa fa-plus btn_plus"></i></a>
					<div class="dropdown_menu">
						<a href="notice.html">공지사항</a>
						<a href="qa.html">질문과답변</a>
						<a href="faq.html">FAQ</a>
					</div>
				</li>
			</ul>
		  </div>
		</div><!-- container end -->
	</div>

	<div class="container">
			
			<div class="member_boxL">
                <h2>개인회원</h2>
                <form id="authForm" method="post" action="/mem/sign.do">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                <div class="login_form">
	                    <div class="fl_clear">
		                    <label for="email">이메일</label>
		                    <input name="email" id="email" type="text">
	                    </div>
	                    <div class="fl_clear">
		                    <label for="authtication">인증번호</label>
		                    <input name="authtication" id="authtication" type="password" disabled="disabled" style="background:#CCC;">
	                    </div>
	                    
                    <input type="button" class="btn_login btn_Blue" id="btn_mail" value="메일 전송">
                    <span id="num_check"></span>
                    <div>
                    	<button type="submit" id="btn_next">다음</button>
                    	<button type="button" onclick="location.href='/'">이전</button>
                    </div>
                </div>
                </form>
               
            </div>
		
	  
	</div>
	<!-- end contents -->
	
	<script>
	
		var code = "";
		var incode = "";
		var authCheck = false;
		
		
		$("#btn_mail").on("click", function() {
			var regEmail = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
			
			if (!regEmail.test($("#email").val())) {
				alert("이메일 주소가 유효하지 않습니다.");
				$("#email").focus();
				return false;
			}
			
			var email = $("#email").val();
			
			var csrfToken = $('meta[name="_csrf"]').attr('content');
			var csrfHeader = $('meta[name="_csrf_header"]').attr('content');
			
			$.ajax({
				type:'post',
				url:'/mem/mail.do',
				beforeSend:function(xhr) {
					xhr.setRequestHeader(csrfHeader, csrfToken);
				},
				data:{ email: email },
				success:function(data) {
					
					code = data;
					
					$("#authtication").attr("disabled", false);
					$("#authtication").css("background", "#fff");
					
				}
			})
		}) 
		
		$("#authtication").on("input", function() {
			
			incode = $("#authtication").val();
			
			if(incode == code) {
				$("#num_check").html("인증 번호 일치");
				authCheck = true;
			} else {
				$("#num_check").html("인증 번호 확인");
				authCheck = false;
			}
			
		})
		
		document.getElementById("authForm").onsubmit = function (event) {
		    if (!authCheck) {
		        alert("인증번호 확인 요망");
		        event.preventDefault(); // 폼 제출 방지
		        return false;
		    }
		    return true; // 폼 제출 허용
		};
 	 	
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
<%@ include file="../footer.jsp"%>