package data

// hardcoded data
val sessionCsvString = """
117호|Android|13:00 - 13:50|권태환|레몬트리 안드로이드 개발 / GDG Korea Android 운영진|Compose 함수를 나누는 조건은?
117호|Android|14:00 - 14:50|권혁준|GDG Incheon|Jetpack Glance를 사용한 Android 위젯 생성
117호|Android|15:00 - 15:50|강경완|배달의민족 Android 개발자 / GDG Android Korea|Compose 성능 끌어올리기
117호|Android|16:00 - 16:50|안성용|NAVER WEBTOON|Material Motion for Compose
117호|Android|17:00 - 17:50|유광무|GDG Songdo / KUG Seoul / GDSC TUK|확장 가능한 Compose API 설계
Grand Bloom|General|13:00 - 13:50|박영용|(현) JNPMEDI CTO / (전) 람다256, 두나무|나는 언제부터 CTO를 꿈꿨나
Grand Bloom|BackEnd-ML/AI|14:00 - 14:50|유저스틴|(현) Microsoft / Principal Cloud Advocate|Semantic Kernel로 나만의 맟춤형 Spotify 플리 만들어 보기
Grand Bloom|General|15:00 - 15:50|이승민|AirPremia Labs|사수 없이 성장하기
Grand Bloom|ML/AI|16:00 - 16:50|신정규|두 아이의 아빠. 노는것 읽는 것 쓰는 것을 좋아합니다|소주 만들기
Grand Bloom|Android|17:00 - 17:50|배필주|현) 네이버 Z / GDG Korea Android 운영진|Gemini in android studio
Grand Bloom|Flutter|18:00 - 18:50|이자영|(현) Google Flutter UX Researcher|What’s new in Flutter - I/O Extended Edition
114호|BackEnd|13:00 - 13:50|김성훈|(현) 에어프레미아랩스 / (전) 라인플러스, 크로스앵글, 테크타카|에어프레미아는 왜 재개발을 하는가?
114호|BackEnd|14:00 - 14:50|김우경|(현) CJ올리브영|[올리브영 전시영역의 꺾이지 않는 안정성]최대 동접 10만 트래픽을 소화하는 올리브영 온라인몰의 전시 전략을 공유합니다.
114호|BackEnd|15:00 - 15:50|이예성|쎄트렉아이 DevOps Engineer|어쩌다보니 Python 컨트리뷰터가 되었던 건에 대하여
114호|BackEnd|16:00 - 16:50|김인제|LINE+, 라인 오픈챗 서버 개발자|누구나 함께하는 오픈소스 기여, 공유 문화 만들기 - 100명의 개발자분들을 도와 100개 넘는 오픈소스 PR을 함께 만들고 세상을 바꾼 이야기
114호|BackEnd|17:00 - 17:50|강성욱|(현)NOWCOM Sr.DBOPS (전)AWS Sr.Solutions Architect, (전) NHN Global,  SRE team manager, (전) NEXON Sr.DBA|DB를 느리게 만드는 다양한 방법들! (왜 내가 만든 쿼리는 항상 느릴까?)
114호|BackEnd|18:00 - 18:50|박종훈|루센트블록 SDET|spring ai 입문하기 (with gemini)
112호|Flutter|13:00 - 13:50|이종훈|GDG Songdo|Godot Engine으로 시작하는 1인 게임 개발
112호|Flutter|14:00 - 14:50|김소연 + 김마로|GDG 송도 / NSUS LAB Korea (김마로), Flutter Seoul(김소연)|상태관리의 사실과 오해
112호|Flutter|15:00 - 15:50|조새벽|GDG SONGDO|Flutter build
112호|Flutter|16:00 - 16:50|박제창|플러터 서울/ GDG Golang Korea|Flutter gRPC
112호|Flutter|17:00 - 17:50|유병욱|아임웹|Flutter Golden Test 101
109호|General|13:00 - 13:50|최가인|CJ Oliveyoung, DevRel / GDG Golang Korea, Organizer|[Beyond the screen: Google I/O 현장 하이라이트] 구글 커뮤니티 구성원들의 I/O 현장 참가 경험과 함께 글로벌 컨퍼런스 참여 팁을 공유합니다.
109호|General|14:00 - 14:50|고지연|(현) 한빛앤 디지털 콘텐츠 디렉터 / (전) 한빛미디어/한빛아카데미 기획편집자, TmaxSoft/TmaxData 테크니컬 라이터|책과 영상 제작으로 나만의 성장 파이프라인 구축하기
109호|General|15:00 - 15:50|권대건|JNPMEDI Senior Backend Engineer|개발자 공허함 Part2 : 완성과 미완성 그리고 진행형
109호|General|16:00 - 16:50|김상현|Microsoft 2023 MVP, CTO at Some Other Place|기술 주의자 v 논리 주의자
109호|General|17:00 - 17:50|이상준|닷넷데브 커뮤니티 오거나이저|ConsoleAppFramework를 활용한 쉬운 .NET Console 앱개발
109호|General|18:00 - 18:50|송민정|(현) Spectra Software Engineer|터닝포인트 / 한국화 전공생의 개발자 생존기
118호|Web|13:00 - 13:50|임성호|(현) 요기요 / (전) 웨이버스, 화해 / GDG Incheon Organizer, 함수랑산악회|모던 웹 자바스크립트 프레임워크 함께보기
118호|Web|14:00 - 14:50|김진석|저 바다 건너편에 SmartComponent라는 게 있어|(현)Microsoft MVP / 한국블레이져개발자모임 대표 / 케이에이치시스템즈 대표
118호|Web|15:00 - 15:50|신혜연|(현) JNPMEDI / (전) 람다256, kt ds| Web Application Service에서 E2E & API 테스트 자동화 사례 공유
118호|Web|16:00 - 16:50|이정주|(주)펴나니|위치 및 지리정보의 거의 모든 것
118호|Web|17:00 - 17:50|정혜미|에스아이에이 GIS 엔지니어|GIS 엔지니어는 무슨 일을 할까요?(개발자가 공간정보를 다룬다면?)
118호|Web|18:00 - 18:50|이다니엘|Senior Software Engineer at Google, San Francisco|BLANK
115호|ML|13:00 - 13:50|박광석|모두의연구소|컴퓨터가 세상을 "보는" 방식 : 딥러닝 이전부터 멀티모달 AI까지
115호|ML|14:00 - 14:50|김형섭|BLANK|BLANK
115호|ML|15:00 - 15:50|한성민|GDG Golang Korea/GDE for AI/ML and Cloud/Riiid|BLANK
115호|ML|16:00 - 16:50|한상준|GDG Songdo/포스트매스 AI Lead Engineer|AI를 이용한 수학 문제 풀이에 도전하는 여정
115호|ML|17:00 - 17:50|박기준|OKESTRO Machine Learning Research Scientist|점점 늘어나는 클라우드 비용, FinOps로 다이어트 하기
115호|ML|18:00 - 18:50|이영빈|GDG송도 & 모두의연구소|JAX로 GPU 프로그래밍 다루기 (feat.triton, pallas)
""".trimIndent()

val sessions = sessionCsvString
    .split("\n")
    .map { it.split("|") }
    .map { Session(it[0], it[1], it[2], it[3], it[4], it[5]) }