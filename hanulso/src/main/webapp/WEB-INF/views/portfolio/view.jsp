<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../header.jsp"%>
<!-- sub contents -->
	<div class="sub_title">
		<h2>포트폴리오</h2>
		<div class="container">
		  <div class="location">
			<ul>
				<li class="btn_home">
					<a href="index.html"><i class="fa fa-home btn_plus"></i></a>
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
						<a href="portfolio.html">포트폴리오</a>
					</div>
				</li>
			</ul>
		  </div>
		</div><!-- container end -->
	</div>

	<div class="container">
		<div class="board_view">
			<h2>${view.title }</h2>
			<p class="info"><span class="user">${view.writer }</span> | ${view.regdate } | <i class="fa fa-eye"></i> <%-- ${view.viewcount } --%></p>
			<div class="board_body">
				<p>${view.content }</p>
				<%-- <img src="${pageContext.request.contextPath}/upload/${view.imgurl}" alt=""> --%>
			</div>
			<div class="prev_next">
				<c:if test="${prev != null }">
					<a href="/port/view.do?bno=${prev.bno }" class="btn_prev"><i class="fa fa-angle-left"></i>
					<span class="prev_wrap">
						<strong>이전글</strong><span>${prev.title }</span>
					</span>
					</a>
				</c:if>
				<c:if test="${prev eq null }">
					<a href="/port/view.do?bno=${view.bno }" class="btn_prev"><i class="fa fa-angle-left"></i>
					<span class="prev_wrap">
						<strong>이전글</strong><span>이전 글이 없습니다.</span>
					</span>
					</a>
				</c:if>
				<div class="btn_3wrap">
					<a href="/port/list.do">목록</a> 
					<a href="/port/modify.do?bno=${view.bno}">수정</a> 
					<a href="/port/delete.do?bno=${view.bno}" onClick="return confirm('삭제하시겠어요?')">삭제</a>
				</div>
				<c:if test="${next != null }">
					<a href="/port/view.do?bno=${next.bno }" class="btn_next">
					<span class="prev_wrap">
						<strong>다음글</strong><span>${next.title }</span>
					</span>
					<i class="fa fa-angle-right"></i>
					</a>
				</c:if>
				<c:if test="${next eq null }">
					<a href="/port/view.do?bno=${view.bno }" class="btn_next">
					<span class="prev_wrap">
						<strong>다음글</strong><span>다음 글이 없습니다.</span>
					</span>
					<i class="fa fa-angle-right"></i>
					</a>
				</c:if>
			</div>
			
		</div>
	</div>
	
	   <!-- comment -->
      <div class="container">
           <div style="border-top:1px solid #ccc;">
           <p style="font-size: 22px; font-weight: bold; padding: 20px 0;">
              Comments: <%-- "${replyCount}" --%>
           </p>
           </div>
           <form name="comment" method="post" action="/port/commentSave.do" onsubmit="return cmtWrite()">
	           <div style="display: flex; justify-content: space-between;">
	           <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	           	<input type="hidden" name="board_bno" value="${view.bno }">
	           	<input type="hidden" name="username" value="${principal.username}">
	              <textarea name="content" class = "cmt_area" style="width: 88%; height: 130px; vertical-align: top; resize: none;"></textarea>
	              <button type="submit"id="btn_comment" style="width: 10%; height: 130px;">댓글등록</button>            
	           </div>
           </form>
           <div>
              <%--  <ul>
               	 <c:forEach var="list" items="${list }">
                  <li style="padding:12px 0;"><span>ㄴ</span> ${list.memberName} ${list.regdate }</li>
                  <li>${list.reply}</li>
                  </c:forEach>
               </ul> --%>
            </div>
         </div>

	<!-- end contents -->
	
	<script>
	 function cmtWrite(){ //댓글등록 
         
         var writer ="${principal.username}";
         var cmtContent =$(".cmt_area").val();
         
         if(writer == "") {
             alert("로그인 하세요");
             return false;
          }
         
         if(cmtContent == "") {
            alert ("댓글내용 입력 하세요");
            return false;
         }
         
        return true;
      } 
	 
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
<%@ include file = "../footer.jsp"%>