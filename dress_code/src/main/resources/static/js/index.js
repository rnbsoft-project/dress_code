// 페이지가 로드된 후, 실행할 함수
window.onload = function() {

    alert("테스트 화면에 집입 했습니다.");

    var test = document.getElementById("test");

    function onclick() {
        alert("테스트 버튼을 클릭 했습니다.");
    }

    test.addEventListener("click", onclick);
}