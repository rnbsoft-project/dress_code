
$(document).ready(function () {
    // 회원가입 버튼을 클릭 했을 때
    $("#joinBtn").on("click", function() {
            alert("회원가입 버튼을 클릭 했습니다.");

            var userInfo = {
                  userName        : $("#userName").val()            /* 유저 이름 */
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
                        alert("회원가입완료");
                        console.log(response.data.userName + "," +
                                            response.data.userId + "," +
                                            response.data.userPassword + "," +
                                            response.data.userEmail + "," +
                                            response.data.userMovTel + "," +
                                            response.data.userAddr)
                        alert("회원가입을 성공 했습니다.");
                  }
            })
    });
});