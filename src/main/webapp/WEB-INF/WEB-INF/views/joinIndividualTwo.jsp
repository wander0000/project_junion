<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>개인_회원가입</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/default.css">
<!-- import font-awesome, line-awesome -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/line-awesome/1.3.0/line-awesome/css/line-awesome.min.css">
<!-- import pretendard font -->
<link rel="stylesheet" as="style" crossorigin href="https://cdn.jsdelivr.net/gh/orioncactus/pretendard@v1.3.8/dist/web/variable/pretendardvariable.css"/>
<!-- import js -->
<script src="https://code.jquery.com/jquery-3.6.3.min.js" integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU=" crossorigin="anonymous"></script>
<style>
:root 
{
	/* 컬러 모음 */
	--main-color:#FFA500;
	--color-black: #111;
	--color-white: #fff;
	--color-gray: #787878;
	--input-gray: #e5e5ec;
	--button-gray: #f7f7f7;
	--border-color-gray: #dadada;
	--font-size32: 32px;
	--font-size24: 24px;
	--font-size16: 16px;
	--font-size14: 14px;
	--font-size12: 12px;
}

/* 회원가입_개인_2단계 section */

section
{
    padding-top: 90px;
    display: flex;
    justify-content: center;
}

.sectionInner
{
    min-width: 1200px;
    margin: 136px 0;
}

.sectionTitleJoinTwo 
{
    text-align: center;
}

.sectionTitleJoinTwo a
{
    font-size: var(--font-size32);
    color: var(--color-black);
}

.sectionInnerWrapperJoinTwo 
{
    display: flex;
    justify-content: center;
    align-items: center;
    gap: 40px;  
    margin-top: 40px; 
}

.sectionInnerWrapperJoinTwo .inputName
{
    font-size: var(--font-size16);
    color: var(--color-black);
    margin-top: 24px;
    margin-bottom: 12px;
}

.sectionInnerWrapperJoinTwo .wishJob ,.myStack
{
    font-size: var(--font-size16);
    width: 500px;
    height: 56px;
    border-radius: 6px;
    box-sizing: border-box;
    border: solid 1px var(--input-gray);
    cursor: pointer;
}

.joinTwoButton
{
    display: flex;
    justify-content: center;
}

.sectionInnerWrapperJoinTwo input
{
    padding-left: 16px;
}

.sectionInnerWrapperJoinTwo .buttonPrev
{
    width: 240px;
    height: 48px;
    background-color: var(--color-white);
    border: solid 1px var(--input-gray);
    color: var(--color-black);
    font-size: var(--font-size16);
    margin-top: 40px;
    border-radius: 6px;
    margin-right: auto;
}

.sectionInnerWrapperJoinTwo .buttonSuccess
{
    width: 240px;
    height: 48px;
    background-color: var(--main-color);
    border:0;
    color: var(--color-white);
    font-size: var(--font-size16);
    margin-top: 40px;
    border-radius: 6px;
}

.popupJoin
{
    display: none;
    position: fixed;
    top:0;
    left: 0;
    width: 100vw;
    height: 100vh;
    overflow: hidden;
    background: rgba(0,0,0,0.5);
}

.popupJoin .popupJoinCon
{
    position: absolute;
    width: 500px;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    padding: 24px;
    background: #fff;
    border-radius: 15px;
    padding-bottom: 28px;
}

.popupJoinCon h2
{
    font-size: var(--font-size24);
    text-align: center;
    margin: 3px;
    margin-bottom: 10px;
}
.popupJoin .tabCon button
{
    min-width: 120px;
	padding: 10px 20px;
    background-color: var(--color-white);
    border: solid 1px var(--input-gray);
    border-radius: 6px;   
    cursor: pointer;
    font-size: var(--font-size12);

}
.popupJoin .tabCon
{
    display: flex;
    justify-content: center;
    border-bottom: solid 1px var(--border-color-gray);
    margin: 20px 0;
    gap: 20px;
	padding-bottom: 20px;
}

.popupJoinCon
{
    display: block;
    max-width: 1200px;
}

.popupJoin .tabConTech 
{
    display: block;
    max-width: 1200px;
}

.popupJoin .tabConTech .po, .popupJoin .tabConTech .tech
{
    margin: 10px 10px 5px 0;
    border: 1px solid var(--input-gray);
    border-radius: 6px;
    padding: 12px 20px;
    width: initial;
    cursor: pointer;
    font-size: var(--font-size14);
}

.popupJoin .tabConTech .po.on, .popupJoin .tabConTech .tech.on 
{
    background-color: var(--color-black);
    color: var(--color-white);
}

.popupJoin .tabOk
{
    display: flex;
    justify-content: center;
    margin-top: 40px;
}

.popupJoin .tabOk button
{
    min-width: 120px;
	padding: 10px 20px;
    background-color: var(--color-black);
    border: solid 1px #e5e5ec;
    border-radius: 6px;
    color: var(--color-white);
    font-size: var(--font-size14);
    cursor: pointer;
}

.popupJoinCon .tabConTech.two, .tabConTech.three, .tabConTech.five, .tabConTech.six 
{
    display: none;
}

.popupJoin .tabCon button.active
{
    background-color: var(--color-black);
    color: var(--color-white);
}

.tabConTech button.tech.active
{
    background-color: var(--main-color);
    color: var(--color-white);
    border: 0;
}

.popupJoinConX
{
    display: flex;
    justify-content: center;
}

.popupJoinConX h2
{
    margin-left: auto;
}

.popupJoinConX i 
{
    margin-left: auto;
    font-size: 24px;
    cursor: pointer;
}


/* 회원가입_개인_2단계 끝 */

</style>
</head>
<body>
	<div class="container">
		<%@ include file="header.jsp" %>
		<section>
	        <div class="sectionInner">            
	            <h3 class="sectionTitleJoinTwo">
	                <a href="#">2단계 희망 직무 및 기술 설정</a>
	            </h3>
	            <div class="sectionInnerWrapperJoinTwo">
	                <form method="post" action="joinIndividualTwo">
						<input type="hidden" name="user_email" value="${user_email}">						
	                    <div>
	                        <div class="inputName">희망직무</div>
	                        <input type="text" class="wishJob" id="pInput2" name="user_position" placeholder="희망직무를 선택해 주세요" onclick="openChild2()" readonly>
							<input type="hidden" class="user_stack_value">
							<input type="hidden" class="user_position_value">
	                        <div class="inputName">주요기술</div>
	                        <input type="text" class="myStack" id="pInput" name="user_stack" placeholder="주요기술을 선택해 주세요" onclick="openChild()" readonly>
	                    </div>
	                    <div class="joinTwoButton">
	                        <button class="buttonPrev" type="button" onclick="location.href='joinIndividual'">이전</button>
	                        <button class="buttonSuccess" type="submit">가입완료</button>
	                    </div>
	                </form>
	            </div> <!-- 회원가입_개인2 sectionInnerWrapperJoinTwo 끝 -->
	        </div> <!-- 회원가입_개인2 sectionInner 끝 -->
	    </section>
		<%@ include file="footer.jsp" %>	   
	</div>
</body>
</html>
<script>	
const value = openWin.document.getElementById("cInput").value;
let openWin;
function openChild() 
{
	// window.name = "부모창 이름"; 
	window.name = "parentForm";
	
	// window.open("open할 window", "자식창 이름", "팝업창 옵션");
	openWin = window.open("joinPop", "childForm", "width=548, height=620, resizable = no, scrollbars = no");    
}

function openChild2() 
{
	// window.name = "부모창 이름"; 
	window.name = "parentForm";
	
	// window.open("open할 window", "자식창 이름", "팝업창 옵션");
	openWin = window.open("joinPop2", "childForm", "width=548, height=620, resizable = no, scrollbars = no");    
}


// (function () {
//     $.get("/joinPop", function(data) {
//         // 요청이 성공적으로 처리되었을 때 실행되는 콜백 함수
//         console.log("Received data:", data);
//         // 여기서 데이터를 원하는 방식으로 처리할 수 있습니다.
//     });
// })(); 
// 	function Pop() 
// 	{
// 		const data = "${stack_name.stack_name}";
// 		$.ajax
// 		({
// 			type: "post",
// 			data: data,
// 			// 컨트롤러단 호출
// 			url: "/joinPop",			
// 			async: false, 
// 			success : function(result) { 
// 			},
// 			error : function() {
// 					alert("오류발생");
// 			}
// 		}); // ajax 끝
// 		$(".popupJoin.B").show()
// 	}

	$(document).ready(function()
	{
		// 2단계 희망직무 탭 선택시 발동
		var buttons = $('.tabConTech .po');
		var wishJob = $('#wishJob');
		var submit = $('button.poOk');		

		// 버튼 클릭 시 'on' 클래스 토글
		buttons.on('click', function() {
			$(this).toggleClass('on');
		});
	
		$('.tabCon').click(function(){
			buttons.filter('.on').each(function() {
				$(this).removeClass('on');
			});
		});

		// 제출 버튼 클릭 시
		submit.on('click', function() {
			// 'on' 클래스가 있는 버튼들의 값을 배열에 저장
			// 여기에 텍스트 벨류 -> 넘버 벨류로 교체			
			// $(".tabConTech input.po:nth-child(1)").val("101");	
			var buttonValues = [];
            console.log("클릭");
			buttons.filter('.on').each(function() {                
				buttonValues.push($(this).val());
			});

			// AJAX 요청을 통해 서버로 데이터 전송
			$.ajax({
				url: "/joinIndividualTwo", // 실제 서버 엔드포인트 URL
				type: "POST",                  
                async: false,                        
				data: JSON.stringify({user_position: buttonValues}),
				success: function(response) {
					// 선택된 값을 wishJob 입력 필드에 쉼표로 구분된 문자열로 표시					
					wishJob.val(buttonValues.join(', '));
                    console.log(response);
				},
				error: function(response) {
					// 요청 중 오류 발생 시 처리
					console.error(response);
				}
			});
            
			// buttons.filter('.on').each(function() {
			// 	$(this).removeClass('on');
			// });			
		});

		// 2단계 주요기술 탭 선택시 발동
		var buttons2 = $('.tabConTech .tech');
		var myStack = $('#myStack');
		var submit2 = $('button.techOk');

		// 버튼 클릭 시 'on' 클래스 토글
		buttons2.on('click', function() {
			$(this).toggleClass('on');
		});

		// 제출 버튼 클릭 시
		submit2.on('click', function() {
			// 'on' 클래스가 있는 버튼들의 값을 배열에 저장
			var buttonValues2 = [];
			buttons2.filter('.on').each(function() {
				buttonValues2.push($(this).val());
			});

			// AJAX 요청을 통해 서버로 데이터 전송
			$.ajax({
				url: "/joinIndividualTwo", // 실제 서버 엔드포인트 URL
				type: "POST",  
                async: false,          
				data: JSON.stringify({user_stacks: buttonValues2}),
				success: function(response) {
					// 선택된 값을 wishJob 입력 필드에 쉼표로 구분된 문자열로 표시
					myStack.val(buttonValues2.join(', '));
				},
				error: function(response) {
					// 요청 중 오류 발생 시 처리
					console.error(response);
				}
			});

			// buttons2.filter('.on').each(function() {
			// 	$(this).removeClass('on');
			// });			
		});
		
    }); //document.ready 끝
    
	




</script>