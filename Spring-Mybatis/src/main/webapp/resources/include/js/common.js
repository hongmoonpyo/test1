/*함수명 : chkSubmit(유효성 체크 대상, 메시지 내용)
출력영역 : alert으로.
예시 : if(!chkSubmit($('#keyword'),"검색어를")) return;*/
function chkSubmit(item, msg) {
	if (item.val().replace(/\s/g, "") == "") {
		alert(msg + "입력해 주세요");
		item.val("");
		item.focus();
		return false;
	} else {
		return true;
	}
}
/*
 * 함수명 : checkForm(유효성 체크 대상, 메시지 내용) 출력영역 : placeholder 속성을 이용 예시 :
 * if(!chkSubmit($('#keyword'),"검색어를")) return;
 */
function checkForm(item, msg) {
	var message = "";
	if (item.val().replace(/\s/g, "") == "") {
		message = msg + "입력해 주세요";
		item.attr("placeholder", message);
		return false;
	} else {
		return true;
	}
}
/*
 * 함수명 : formCheck(유효성 체크 대상, 출력 영역, 메시지 내용) 출력영역 : 매개변수 두번째 출력영역에 .
 * if(!formCheck($('#keyword'),$('#msg')"검색어를")) return;
 */
function formCheck(main, item, msg) {
	if (main.val().replace(/\s/g, "") == "") {
		item.css("color","#000099").html(msg+" 입력해 주세요");
		main.val("");
		return false;
	} else {
		return true;
	}
}
/*
 * 함수명 : chkData(유효성 체크 대상, 메시지 내용)
 * 예시 : if(!chkData($('#keyword'),검색어를")) return;
 */
function chkData(item, msg) {
	if ($(item).val().replace(/\s/g, "") == "") {
		alert(msg+" 입력해 주세요.");
		$(item).val("");
		$(item).focus();
		return false;
	} else {
		return true;
	}
}
/*첨부파일은 이미지 파일마 업로드 되도록 유효성 체크를 위한 함수를 생성한다.*/
function chkFile(item) {
	/*배열내의 값을 찾아서 인덱스를 반환(요소가 없을 경우 -1 반환)
	jQuery.inArray(찾을 값, 검색 대상의 배열)*/
	var ext = item.val().split('.').pop().toLowerCase();
	if(jQuery.inArray(ext,['gif','png','jpg','jpeg']) == -1){
		alert("'gif','png','jpg','jpeg' 파일만 업로드 할수 있습니다.");
		return false;
	}else{
		return true;
	}
}
