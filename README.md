# 팀 프로젝트 기획

---

# 프로젝트 목적

**프로젝트 목적:** 수업 내용을 바탕으로 스프링 레거시를 활용한 개발 경험을 쌓고 웹 쇼핑몰의 흐름에 대한 학습

**수업 교재:** 코드로 배우는 스프링 웹프로젝트(게시판CRUD + 댓글,  로그인, 회원가입, 스프링시큐리티 조금)

## 목표

1. **기술 습득:** 스프링 레거시를 사용하여 웹 애플리케이션을 개발함으로써 해당 기술들에 대한 이해도를 높입니다.
2. **실전 경험:** 수업에서 배운 내용을 바탕으로 프로젝트를 수행하여 문제 해결 능력과 개발 능력을 향상시킵니다.
3. **포트폴리오 구성:** 완성된 프로젝트를 포트폴리오에 추가하여 개인의 역량을 증명하고, 취업시에 활용합니다.
4. **자기 계발:** 프로젝트를 통해 새로운 기술을 학습하고, 문제를 해결하는 과정에서 성장합니다.

# 프로젝트 소개

이 프로젝트는 팀프로젝트로 협의를 통해 **웹 쇼핑몰**을 개발하는 것으로 웹 쇼핑몰은 사용자로서 가장 익숙한 서비스이기 때문에 선택하게 되었습니다. 
이 프로젝트는 학습한 웹 관련 기술 HTML, CSS, JavaScript와 Servlet, JSP, 스프링을 활용하여 오라클 데이터베이스를  적용한 동작하는 웹 애플리케이션입니다.

## 사용한 기술 스택

- 개발 환경: 이클립스(STS3), Visual Studio Code, tomcat
- 프로그래밍 언어: Java, HTML, CSS, JavaScript
- 데이터베이스: 오라클
- 버전 관리: Git
- 라이브러리: spring-web-MVC, mybatis, ojdbc, spring-security, lombok, hikariCP, jackson, gson, aspectJ, thumbnailator, json-simple

### **참고 웹사이트([랭킹닭컴](https://www.rankingdak.com/)**

1. **디자인 및 레이아웃 분석:**  헤더, 슬라이더, 세션, 푸터로 구성된 레이아웃과 편리하고 익숙한 인터페이스 구조를 갖고 있습니다.
2. **게시판 분석**: 공지사항, 질의응답, 자주찾는 질문, 구매후기 4개의 게시판과 특정 게시판은 이미지 파일 첨부가 가능합니다.
3. **사용자 경험 분석:** 사용자들은 웹사이트를 통해 원하는 정보를 찾을 수 있으며, 특히 장바구니에 상품을 담는 경우 즉시 확인 가능한 모달 장바구니가 제공됩니다.

## 요구 사항

1. **제품 진열**: 사용자가 제품을 제품명 일부로 검색할 수 있어야 하고 사용자는 제품 이미지, 설명, 가격 등을 볼 수 있어야 합니다. 
추가 사항 1: 진열된 제품 카드에서 바로 구매가 가능해야 합니다.
추가 사항 2: 진열된 제품 카드의 수량 조정이 가능해야 합니다.
2. 제품 검색: 제품명의 일부 또는 전체를 검색하여 검색 결과를 얻을 수 있어야 합니다.
3. **회원 가입 및 로그인**: 사용자는 회원으로 가입하고 로그인하여 구매를 진행할 수도 있고 비회원으로 상품 구매를 진행할 수 있어야 합니다. 회원 가입 시에는 필수적인 정보를 입력할 수 있도록 해야 하며, 로그인 시에는 보안을 고려하여 인증 절차를 거쳐야 합니다. 
추가 사항 1: 회원 가입 시 비밀번호는 암호화되어야 합니다.
4. **장바구니**: 장바구니는 장바구니 페이지 이동 없이 즉시 확인 가능해야 합니다. 사용자는 제품을 장바구니에 담아 구매할 수 있어야 합니다. 장바구니에는 제품 수량 조정이 가능하며, 제품을 추가하거나 삭제할 수 있어야 합니다.
5. **주문 및 결제**: 사용자는 단일 품목 즉시 구매 주문이 가능해야 합니다. 장바구니에 담긴 제품을 주문하고 결제할 수 있어야 합니다.
6. **질문 및 리뷰**: 사용자는 제품을 질문과 리뷰를 작성할 수 있어야 합니다.
7. **관리자 기능**: 관리자 페이지에서는 관리자와 제품의 조회, 추가, 수정, 삭제할 수 있어야 하며 공지사항, 자주 찾는 질문, 질의 응답, 구매 후기 게시판의 게시글 조회, 등록, 수정, 삭제할 수 있어야 합니다.  또한 관리자 페이지는 관리자로 인증된 계정만 접근할 수 있도록 합니다.

## **프로젝트 진행 과정**

1. **환경 설정 및 프로젝트 초기 설정:**
    - 이클립스 또는 Visual Studio Code를 설정하고, 프로젝트를 생성합니다.
    - Servlet 및 JSP를 사용할 수 있는 웹 어플리케이션 프로젝트를 설정합니다.
    - Java JDBC를 사용하여 데이터베이스와의 연동을 구현합니다.
    - MySQL 데이터베이스를 설치하고 연동합니다.
2. **기본적인 웹 페이지 개발:**
    - HTML, CSS, JavaScript를 사용하여 기본적인 웹 페이지 레이아웃을 구성합니다.
    - JSP를 사용하여 간단한 웹 페이지를 구현합니다.
    - 서블릿, 액션 구조의 컨트롤러를 구현합니다. 이 컨트롤러는 클라이언트의 요청을 command파라미터 값에 담아 cmmand 값에 따라 다양한 액션을 실행하여 서비스를 제공합니다.
3. **데이터베이스 모델링 및 연동:**
    - 웹 쇼핑몰에 필요한 데이터베이스 테이블을 설계합니다. (제품, 회원, 주문, 리뷰 등)
    - 테이블의 컬럼에 맞게 VO를 구현합니다.
4. **회원 가입 및 로그인 기능 구현:**
    - 회원 가입 페이지를 구현하고, 회원 정보 데이터베이스에 저장 시 비밀번호를 암호화여 저장합니다.
        - 비밀번호 암호화
            <details>
            <summary>구현</summary>
                
                public String hashPassword(String password) {
                // 입력된 비밀번호를 해싱하여 반환하는 메서드
                
                    try {
                        MessageDigest md = MessageDigest.getInstance("SHA-256");
                        // SHA-256 해시 알고리즘을 사용하는 MessageDigest 객체 생성
                        // 256비트 16진수 64자리
                        
                        byte[] hash = md.digest(password.getBytes());
                        // 입력된 비밀번호를 바이트 배열로 변환하여 해시 알고리즘으로 처리
                        
                        StringBuilder hexString = new StringBuilder();
                        // 해싱된 비밀번호를 16진수 문자열로 변환하여 담기 위해
                        // 문자열을 동적으로 추가하는 StringBuilder객체를 생성
                        
                       
                        for (byte b : hash) {
                            String hex = Integer.toHexString(0xff & b);
                	          // 해시된 바이트 배열을 16진수 문자열로 변환
                            
                            if (hex.length() == 1) {
                                hexString.append('0');
                            }
                            // 한 자리 16진수인 경우 가독성을 위해 0을 추가 
                            
                            hexString.append(hex);
                            // 16진수 문자열을 하나의 문자열로 생성
                            
                        return hexString.toString();
                        // 해시된 비밀번호를 16진수 문자열로 반환
                        
                    } catch (NoSuchAlgorithmException e) {
                        // NoSuchAlgorithmException 예외 발생 시 null 반환
                        return null;
                    }
                }
          
            </details>


    - 관리자 로그인을  구현하고, 입력된 정보와 데이터베이스의 정보를 확인하여 JWT 토큰을 발행합니다.
        - JWT 토큰 발행
            <details>
            <summary>구현</summary>
                
                ```java
                public class TokenGenerator {
                
                    public static String generateJwtToken(String userId) {
                        // 토큰에 포함할 클레임 생성
                        Claims claims = Jwts.claims();
                        claims.put("userId", userId);
                        
                        // 토큰의 유효 기간 설정
                        Date now = new Date();
                        Date expiration = new Date(now.getTime() + 3600 * 1000); // 1시간
                        
                        // JWT 토큰 생성
                        String token = Jwts.builder()
                                .setClaims(claims)
                                .setIssuedAt(now)
                                .setExpiration(expiration)
                                .signWith(SignatureAlgorithm.HS256, "GgolDdooGi")
                                .compact();
                        
                        return token;
                    }
                    
                    
                    public static String generateBase64Token() {
                		// 무작위 바이트 배열 생성
                		byte[] randomBytes = new byte[32];
                		new SecureRandom().nextBytes(randomBytes);
                
                		// 바이트 배열을 Base64 인코딩하여 문자열로 변환하여 반환
                		return Base64.getEncoder().encodeToString(randomBytes);
                	}
                }
                ```
          </details>
                
    - 회원 로그인을 구현하고, 입력된 정보와 데이터베이스의 정보를 확인하여 랜덤 바이너리 문자열을 Base64 인코딩하여 토큰으로 발행합니다.
        - Base64 토큰 발행
          <details>
            <summary>구현</summary>

                ```
                  public static String generateBase64Token() {
                    // 무작위 바이트 배열 생성
                    byte[] randomBytes = new byte[32];
                    new SecureRandom().nextBytes(randomBytes);
            
                    // 바이트 배열을 Base64 인코딩하여 문자열로 변환하여 반환
                    return Base64.getEncoder().encodeToString(randomBytes);
                }
              ```

          </details>
    - 카카오 api를 활용하여 로그인 기능을 구현합니다.
        - 
    - 관리자 로그인을 구현하고 관리지 페이지에 접근을 인증*인가하는 필터를 구현한다.
        - 접근 제한 필터
          <details>
            <summary>구현</summary>
  
                  ```
                          @Override
                          public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
                          HttpServletRequest request = (HttpServletRequest) servletRequest;
                          HttpServletResponse response = (HttpServletResponse) servletResponse;
                        
                          HttpSession session = request.getSession(false); // 세션이 없으면 null 반환
                
                          // JWT 토큰 가져오기
                          String jwtToken = (String)session.getAttribute("adminToken");
                
                          // JWT 토큰 유효성 검사 및 관리자 권한 확인
                          if (jwtToken != null && isValidJwtToken(jwtToken) && isAdmin(jwtToken)) {
                                // 권한이 확인되면 다음 필터 또는 요청 핸들러로 요청을 전달
                                filterChain.doFilter(request, response);
                              } else {
                                // 권한이 없는 경우 401 Unauthorized 에러 반환
                                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                              }
                          }
  


                            <filter>
                                <filter-name>AdminAuthorizationFilter</filter-name>
                                <filter-class>com.blacksmith.banchan.util.AdminAuthorizationFilter</filter-class>
                        	</filter>
                        
                        	<filter-mapping>
                        		<filter-name>AdminAuthorizationFilter</filter-name>
                        		<url-pattern>/admin/*</url-pattern>
                        	</filter-mapping>
                        	

    
                  ```
          
          </details>
5. **제품 관리 기능 구현:**
    - 관리자 제품 관리 페이지에서 제품을 조회, 등록, 수정, 삭제할 수 있는 기능을 구현합니다.
6. **장바구니 및 주문 기능 구현:**
    - 사용자가 제품을 장바구니에 담고 즉시 확인과 주문할 수 있는 기능을 모달로 구현합니다.
    - 제품을 모아서 나중에 주문 할 수 있는 장바구니 페이지를 구현합니다.
    - 주문 정보를 데이터베이스에 저장하고, 결제 프로세스를 구현합니다.
7. **4 in 1 게시판 기능 구현:** 
    - 이 프로젝트에서는 JSON과 AJAX 그리고 JavaScript를 사용하여 전체 페이지를 다시 로드하지 않고 게시판의 일부 데이터를 동적으로 변경하는 방식의 게시판을 구현합니다.
    - 실제 구현 방식
      <details>
            <summary>구현</summary>
  
                  ```
                    function fetchBoardList(boardType, page) {

                        	document.getElementById('boardTitle').innerText = boardType.toUpperCase();
                        
                        	var xhr = new XMLHttpRequest();
                        
                        	xhr.open("GET", "banchan?command=" + boardType + "&page=" + page, true);
                        	xhr.onreadystatechange = function() {
                        		if (xhr.readyState === 4) {
                        			if (xhr.status === 200) {
                        				// 성공적으로 응답을 받았을 때 처리할 내용
                        				document.getElementById('navTitle').value = boardType;
                        				displayCreateBtn(boardType)
                        				var response = JSON.parse(xhr.responseText);
                        				fetchPosts(response.boardList);
                        				displayPagination(response.pageHandler, boardType);
                        			} else {
                        				// 오류가 발생했을 때 처리할 내용
                        				console.error("AJAX 요청 오류:", xhr.status, xhr.statusText);
                        				// 오류 발생 시 사용자에게 메시지 표시 또는 다른 처리를 추가할 수 있습니다.
                        			}
                        		}
                        	};
                        	xhr.send();
                        }
  



                        public class NoticeBoardAction implements Action {
                        
                        	@Override
                        	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                        	    Map<String, Integer> map = new HashMap<String, Integer>();
                        	    
                        	    Integer page = getParameterOrDefault(request.getParameter("page"), 1);
                        	    Integer pageSize = getParameterOrDefault(request.getParameter("pageSize"), 5);
                        	    
                        	    map.put("offset", (page-1)*pageSize);
                        	    map.put("pageSize", pageSize);
                        	    NoticeBoardDAO bDao = NoticeBoardDAO.getInstance();
                        	    List<NoticeBoardVO> boardList = bDao.selectPage(map);
                        	    
                        	    int totalCnt = bDao.getCount();
                        	    PageHandler pageHandler = new PageHandler(totalCnt, page, pageSize);
                        	    
                        	    // 응답 데이터를 JSON 형식으로 변환
                        	    Gson gson = new Gson();
                        	    JsonObject jsonResponse = new JsonObject();
                        	    jsonResponse.add("boardList", gson.toJsonTree(boardList)); // 게시글 목록
                        	    jsonResponse.add("pageHandler", gson.toJsonTree(pageHandler)); // 페이지 핸들러 정보
                        	    
                        	    // 클라이언트에게 JSON 응답을 반환
                        	    response.setContentType("application/json");
                        	    response.setCharacterEncoding("UTF-8");
                        	    response.getWriter().write(jsonResponse.toString());
                        	}
                        
                        	private Integer getParameterOrDefault(String paramValue, Integer defaultValue) {
                        	    if (paramValue == null || paramValue.isEmpty()) {
                        	        return defaultValue;
                        	    }
                        	    for (char c : paramValue.toCharArray()) {
                        	        if (!Character.isDigit(c)) {
                        	            return defaultValue;
                        	        }
                        	    }
                        	    return Integer.parseInt(paramValue);
                        	}
                        
                        
                        }

                  ```
          
      </details>
8. **질문 및 리뷰 기능 구현:**
    - 사용자가 제품 리뷰를 작성할 수 있는 구매 후기 게시판 기능을 구현합니다.
    - 사용자가 질문할 수 있는 질의 응답 게시판을 구현합니다.
9. **관리자 기능 구현:**
    - 관리자를 등록, 수정, 삭제할 수 있는 기능을 구현합니다.
    - 관리자 페이지에서 회원 및 제품을 관리할 수 있는 기능을 구현합니다.
    - 관리자가 사용자 질문과 후기를 관리할 수 있는 페이지를 구현합니다.
    - 공지사항, 자주 찾는 질문을 조회, 등록, 수정, 삭제할 수 있는 기능을 구현합니다.
10. **포트폴리오 문서 작성:**
    - 프로젝트 목적, 소개, 참고 웹사이트, 구현, 회고 순으로 구성하여 포트폴리오를 작성합니다.
