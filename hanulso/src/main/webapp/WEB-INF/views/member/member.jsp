<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../header.jsp"%>

	<!-- sub contents -->
	<div class="sub_title">
		<h2>회원가입</h2>
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
		<div class="con_title">
            <h1>내정보(개인회원)</h1>
         <p>HOME / 마이페이지 / 내정보(개인회원)</p>
        </div>
		<div class="join_write col_989">
                <div class="list_con">
                    <ul class="icon_type1">
                        <li>회원정보는 개인정보 취급방침에 따라 안전하게 보호되며 회원님의 명백한 동의 없이 공개 또는 제3자에게 제공되지 않습니다.</li>
                    </ul>
                </div>
          <form action="">
            <table class="table_write02" summary="회원가입을 위한 이름, 아이디, 비밀번호, 비밀번호확인, 소속, 유선전화번호, 휴대전화번호, 이메일, 주소, 본인확인질문, 본인확인답, 주활용사이트, 알림여부 정보 입력">
                <caption>회원가입을 위한 정보입력표</caption>
                <colgroup>
                    <col width="160px">
                    <col width="auto">
                </colgroup>
                <tbody id="joinDataBody">
                    <tr>
                        <th><label for="username">아이디</label></th>
                        <td>
                            <input type="text" name="username" id="username" class="w300">
                            <p id="namemsg"></p>
                        </td>
                    </tr>
                    <tr>
                        <th><label for="password">비밀번호<!-- <span class="must"><b>필수입력</b></span> --></label></th>
                        <td>
                            <input type="password" name="password" id="password" class="w300">
                            <p id="pw1msg"></p>
                            <p class="guideTxt"><span class="tc_point">영문(대문자 구분), 숫자, 특수문자의 조합</span>으로 9~13자로 작성해 주십시오.</p>
                        </td>
                    </tr>
                    <tr>
                        <th><label for="passwordCheck">비밀번호확인<!-- <span class="must"><b>필수입력</b></span> --></label></th>
                        <td>
                            <input type="password" name="passwordCheck" id="passwordCheck" class="w300">
                            <p id="pw2msg"></p>
                            <p class="guideTxt"></p>
                        </td>
                    </tr>
                    <tr>
                        <th><label for="email">이메일<span class="must"><b>필수입력</b></span></label></th>
                        <td>
                            <input type="email" name="email" id="email" class="w300" placeholder="이메일 입력">
                            <p id="emailmsg"></p>
                        </td>
                    </tr>
               	</tbody>
            </table>
           </form>
				<div class="btnArea Acenter pt60 pb100">
			        <button class="btn_round btn_large btn_BlueGray w180" id="btn_reset"><b>취소</b></button>
			        <button class="btn_round btn_large btn_pointColor w180" id="btn_submit"><b>확인</b></button>
			    </div>

        </div>
	</div>
	<!-- end contents -->
	
	
	
	<script>
		
		$(function() {
			
			var csrfToken = $('meta[name="_csrf"]').attr('content');
			var csrfHeader = $('meta[name="_csrf_header"]').attr('content');
			
			$(".location  .dropdown > a").on("click",function(e) {
				e.preventDefault();
				if($(this).next().is(":visible")) {
					$(".location  .dropdown > a").next().hide();
				} else {
					$(".location  .dropdown > a").next().hide();
					$(this).next().show();
				}
			});
			
			$("#username").blur(function() {
				if(!$("#username").val()) {
					$("#namemsg").html("<span style='color:#f00;'>이름입력</span>");
				} else {
					$("#namemsg").html("");
				}
				$.ajax({
					type:'post',
					url:'/mem/idcheck.do',
					beforeSend:function(xhr) {
						xhr.setRequestHeader(csrfHeader, csrfToken);
					},
					data:{username:$("#username").val()},
					success:function(result) {
						//사용 가능한 id : -1, 사용 불가능 : 1
						if(result <= 0) {
							if($("#username").val() != "") {
								$("#namemsg").html("<span style='color:#0f0;'>사용 가능</span>");
							}
						} else {
							if($("#username").val() != "") {
								$("#namemsg").html("<span style='color:#f00;'>사용 불가</span>");
								$("#username").focus();
							}
						}
					}, error: function() {
					    alert("통신에러 발생");
					}

				})
			})

			$("#password").blur(function() {
				if(!$("#password").val()) {
					$("#pw1msg").html("<span style='color:#f00;'>비밀번호입력</span>");
				} else {
					$("#pw1msg").html("");
				}
			})
			
			$("#passwordCheck").blur(function() {
				var pw1 = $("#password").val();
				var pw2 = $("#passwordCheck").val();
				if(!$("#passwordCheck").val()) {
					$("#pw2msg").html("<span style='color:#f00;'>비밀번호입력</span>");
				} else {
					$("#pw2msg").html("");
				}
				if(pw1 != pw2) {
					$("#pw2msg").html("<span style='color:#f00;'>비밀번호가 같지 않습니다.</span>")
					$("#password").focus();
				} else if(pw1 == pw2) {
					$("#pw2msg").html("")
				}
				
			})
			
			
			$("#btn_submit").on("click", function() {
				var name = $("#username").val();
			    var id = $("#id").val();
			    var password = $("#password").val();
			    var email = $("#email").val();
			    var isValid = true;
			    var pwRegex = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,15}$/;
	               // ^ : 문자열의 시작
	               //(?=.[a-zA-Z]) : 문자열에 영문자가 적어도 1개 이상 포함되어야 함
	               //(?=.[\W_]) : 문자열에 특수문자가 적어도 1개 이상 포함되어야 함
	               //[a-zA-Z0-9\W_]{8,15} : 영문, 숫자, 특수문자 조합으로 이루어진 8~15자의 문자열
	               //$ : 문자열의 끝
	               //[!@#$%^+=-] 이 부분이 특수문자까지 허용
				
					if($("#username").val().trim() === '') {
						$("#namemsg").html("<span style='color:#f00;'>아이디 입력</span>");
						isValid = false;
					}
					if($("#password").val().trim() === '') {
						$("#pw1msg").html("<span style='color:#f00;'>비밀번호 입력</span>");
						isValid = false;
					}
					if($("#email").val().trim() === '') {
						$("#emailmsg").html("<span style='color:#f00;'>이메일 입력</span>");
						isValid = false;
					}
					if(!pwRegex.test(password)) {
						$("#password").next(".guideTxt").html("<span style='color:#f00;'>비밀번호는 영문 대문자, 소문자, 숫자, 특수문자를 포함한 9~13자로 작성해 주십시오.</span>");
						isValid = false;
					}
					
					
					
					if(isValid) {
						$.ajax({
							type:"post",
							beforeSend:function(xhr) {
								xhr.setRequestHeader(csrfHeader, csrfToken);
							},
							data:{"username" : name,
								"password" : password,
								"email" : email
								},
							url:"/mem/access.do",
							success:function(data) {
								alert(data);
								location.href="/";
							}, error:function() {
								alert("통신 에러");
							}
						})
					}
				
				
				
			})
		});
		
	</script>

<%@ include file = "../footer.jsp"%>