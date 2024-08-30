package com.rnbsoft.dress_code.controller;

import com.rnbsoft.dress_code.dto.UserDTO;
import com.rnbsoft.dress_code.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
@Slf4j
public class UserController {

    // UserService Been을 찾아준다.
    @Autowired
    UserService userService;

    // 카카오 REST_API KEY
    @Value("${kakao.rest-api-key}")
    private String kakaoRestApiKey;

    // 카카오 Redirect URI
    @Value("${kakao.redirect-uri}")
    private String kakaoRedirectUri;

    // 카카오 계정 로그아웃 시, Redirect 받을 URL
    @Value("${kakao.logout.redirect.uri}")
    private String kakaoLogoutRedirectUri;



    // 유저 로그인화면 이동
    @GetMapping("/loginForm")
    public String getLogin()
    { return "loginForm"; }

    // 유저 회원가입 화면 이동
    @GetMapping("/join")
    public String getJoin()
    { return "join"; }

    // 유저 회원가입
    @PostMapping("/userSave")
    @ResponseBody
    public void userSave(@RequestBody UserDTO userDTO)
    { userService.userSave(userDTO); }

    // 회원가입 유효성 체크
    @PostMapping("/userIdChk")
    @ResponseBody
    public int userJoinStatusChk(@RequestParam String userId)
    { return userService.userIdChk(userId); }

    // 유저 로그인
    @PostMapping("/userLogin")
    @ResponseBody
    public ModelAndView userLogin(@RequestParam(value ="requestUserId", required = false) String requestUserId,
                                                            @RequestParam(value = "requestUserPassword", required = false) String requestUserPassword,
                                                            HttpSession session)
    {
        // DB에 유저 ID로 가입된 계정이 있는지 확인
        Map<UserDTO, String> userMap = new HashMap<>();

        userMap = userService.userLogin(requestUserId, requestUserPassword);
        String userId = userMap.get("USER_ID");
        String userPassword = userMap.get("USER_PASSWORD");
        String userName = userMap.get("USER_NAME");

        if(requestUserId.equals(userId) && requestUserPassword.equals(userPassword)) {
            // 로그인 성공 시, HOME 페이지로 이동
            session.setAttribute("userName", userName);
            ModelAndView model = new ModelAndView();
            model.addObject("userName", userName);
            return new ModelAndView("redirect:/");
        } else {
            // 로그인 실패 시, 로그인 페이지로 이동
            ModelAndView model = new ModelAndView("loginForm");
            model.addObject("loginError", true);
            return model;
        }
    }

    // 카카오 로그인
    @PostMapping("/kakaoLogin")
    public String kakaoLogin() {
            // 카카오 로그인 페이지로 리다이렉트하기 위한 URL을 생성합니다.
            String kakaoLoginUrl =
            "https://kauth.kakao.com/oauth/authorize?client_id=" + kakaoRestApiKey     // REST API 키를 URL에 포함합니다.
                                                                          + "&redirect_uri=" + kakaoRedirectUri     // 로그인 후, 돌아올 Redirect URI를 URL에 포함합니다.
                                                                          + "&response_type=code";                         // 인가 코드 요청을 위한 response_type 입니다.

        // 생성한 URL로 리다이렉트 합니다. ( http://localhost:8080/kakaoLoginCallBack )
        return "redirect:"+kakaoLoginUrl;
    }

    @GetMapping("/kakaoLoginCallBack")
    public String kakaoLoginCallBack(@RequestParam("code") String code, Model model, HttpSession session) {
        // RestTemplate 객체를 생성합니다. HTTP 요청을 보내기 위해 필요합니다.
        RestTemplate restTemplate = new RestTemplate();

        // 카카오로부터 액세스 토큰을 요청할 URL을 설정합니다.
        String tokenUrl = "https://kauth.kakao.com/oauth/token";

        // 액세스 토큰 요청에 필요한 파라미터를 담을 MultiValueMap을 생성합니다.
        MultiValueMap<String, String> tokenParams = new LinkedMultiValueMap<>();
        tokenParams.add("grant_type", "authorization_code"); // OAuth 2.0 인증 방식으로 authorization_code를 사용합니다.
        tokenParams.add("client_id", kakaoRestApiKey); // 카카오 REST API 키를 전달합니다.
        tokenParams.add("redirect_uri", kakaoRedirectUri); // 리다이렉트 URI를 설정합니다.
        tokenParams.add("code", code); // 카카오에서 반환한 인가 코드를 전달합니다.

        // 요청 헤더를 설정합니다. Content-Type을 application/x-www-form-urlencoded로 설정합니다.
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        // 요청 본문을 설정합니다. 본문에 파라미터를 포함시킵니다.
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(tokenParams, headers);

        try {
            // POST 요청을 보내서 액세스 토큰을 받습니다.
            ResponseEntity<Map> tokenResponse = restTemplate.postForEntity(tokenUrl, request, Map.class);

            // 응답에서 액세스 토큰을 추출합니다.
            String accessToken = (String) tokenResponse.getBody().get("access_token");

            // 액세스 토큰을 사용하여 사용자 정보를 요청할 URL을 설정합니다.
            String userInfoUrl = "https://kapi.kakao.com/v2/user/me";

            // 사용자 정보 요청 시 헤더에 Authorization을 추가합니다. Bearer 인증 방식으로 액세스 토큰을 헤더에 추가합니다.
            HttpHeaders userHeaders = new HttpHeaders();
            userHeaders.set("Authorization", "Bearer " + accessToken);
            HttpEntity<String> userRequest = new HttpEntity<>(userHeaders);

            // GET 요청을 보내서 사용자 정보를 받습니다.
            ResponseEntity<Map> userResponse = restTemplate.exchange(userInfoUrl, HttpMethod.GET, userRequest, Map.class);

            // 응답에서 사용자 정보를 추출합니다.
            Map<String, Object> kakaoAccount = (Map<String, Object>) userResponse.getBody().get("kakao_account");

            // 사용자 정보를 추출하여 UserDTO 객체를 생성합니다.
            String userName = ((Map<String, String>) kakaoAccount.get("profile")).get("nickname");
            String userId = userResponse.getBody().get("id").toString();
            // String userEmail = kakaoAccount.get("email").toString();

            UserDTO userDTO = new UserDTO();
            userDTO.setUserName(userName);  // 사용자 이름 설정    ( 동의항목 )
            userDTO.setUserId(userId);              // 사용자 ID 설정    ( 동의항목 )

            // UserDTO 객체를 데이터베이스에 저장합니다.
            userService.kakaoSave(userDTO);

            // 사용자 정보를 모델에 추가하여 JSP 페이지에서 사용할 수 있도록 합니다.
            session.setAttribute("userName", userName);
            session.setAttribute("userId", userId);
            model.addAttribute("userName", userDTO.getUserName());

            // 홈 페이지로 리다이렉트합니다. 로그인 후 사용자 정보를 보여줄 페이지로 이동합니다.
            return "redirect:"+"/";
        } catch (HttpClientErrorException e) {
            // HTTP 오류가 발생한 경우, 오류 코드와 응답 본문을 출력합니다.
            System.out.println("HTTP Error: " + e.getStatusCode());
            System.out.println("Response Body: " + e.getResponseBodyAsString());

            // 에러가 발생한 경우, 에러 페이지로 리다이렉트합니다.
            return "error";
        }
    }

    // 유저 로그아웃
    @PostMapping("/logout")
    public String userLogout(HttpSession session) {

        // 카카오 로그아웃
        String userId = (String)session.getAttribute("userId");
        if(userId == null) {
            // 세션에 담긴 정보 정리
            session.invalidate();
            return "redirect:" + "/loginForm";
        }else {
            // 카카오 로그아웃 API 호출
            String kakaoLogoutUrl = "https://kauth.kakao.com/oauth/logout"
                    + "?client_id=" + kakaoRestApiKey
                    + "&logout_redirect_uri=" + kakaoLogoutRedirectUri;

            return "redirect:" + kakaoLogoutUrl;
        }

    }

    @GetMapping("/kakaoLogout")
    public String kakaoLogOutSeccess() {
            System.out.println("카카오 계정 로그아웃 성공!");
            return "redirect:" + "/loginForm";
    }
}