
$(document).ready(function () {

    // 유저 유효성 체크하기
    userJoinStatusChk();

    // 유저 회원가입 하기
    saveUser();
});

// 유저 회원가입 메소드
function saveUser() {
    $("#joinBtn").on("click", function() {
        alert("회원가입 버튼을 클릭 했습니다.");

        var userInfo = {
            userName        : $("#userName").val()               /* 유저 이름 */
            , userId              : $("#userId").val()                   /* 유저 아이디*/
            , userPassword : $("#userPassword").val()      /* 유저 비밀번호 */
            , userEmail        : $("#userEmail").val()              /* 유저 이메일 */
            , userMovTel    : $("#userMovTel").val()           /* 유저 전화번호 */
            , userAddr         : $("#userAddr").val()              /* 유저 주소 */
        };

        $.ajax({
              type: "POST"
            , url: '/userSave'
            , contentType : "application/json"
            , data : JSON.stringify(userInfo)
            , success : function (response) {
                window.location.href="login";
            }
        })
    });
}

// 유저 회원가입 유효성 체크 함수
function userJoinStatusChk() {

    // 유저 중복 아이디 체크 시작
    userDuplicateId();
}

// 유저 중복 아이디 체크 함수
function userDuplicateId() {
    $("#userId").on("blur", function() {
        var userId = $("#userId").val().trim();
        if( userId === "" ||  userId === null ) {
            $("#userIdChk").text("아이디를 입력해주세요").css("color", "#D3D3D3");
            $("#joinBtn").prop("disabled", true);
        }else {
            $.ajax({
                url : "/userIdChk"
                , type: "POST"
                , data : { userId : userId }
                , success: function (response) {
                    switch (response) {
                        case 0 :
                            $("#userIdChk").text("사용 가능한 아이디 입니다.").css("color", "blue");
                            $("#joinBtn").prop("disabled", false);
                            break;
                        case 1 :
                            $("#userIdChk").text("중복된 아이디 입니다.").css("color", "red");
                            $("#joinBtn").prop("disabled", true);
                            break;
                    }
                }
            })
        }
    });
}

