<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<div class="uploadDiv">
		<input type="file" name="uploadFile" multiple>
	</div>
	<button id="uploadBtn">upload</button>
	
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script>
		$(function() {
			$("#uploadBtn").on("click", function() {
				var formData = new FormData(); //������ �� �±� 
				var inputFile = $("input[name=uploadFile]");
				var files = inputFile[0].files;
				console.log(files);
				
				for(var i = 0; i < files.length; i++) {
					formData.append("uploadFile", files[i]);
				}
				
				$.ajax({
					url:"/sample/ajax",
					type:"post",
					processData:false, //�⺻�� true, �����͸� ������ Ÿ�Կ� �°� ��ȯ
					contentType:false, //application/json false �� multipart/form-data Ÿ������ ����
					data:formData,
					success:function(response) {
						alert(response.msg);
					}
				});
			})
		})
	</script>
</body>
</html>