package com.parkgaram.dp.templatemethod;

public abstract class AbstConnectHelper {

	//하위클래스에서 재정의해야되지만 외부에서 호출하면 안되므로 protected로 선언해야 한다.
	protected abstract String doSecurity(String info);

	protected abstract String authentication(String id, String password);

	protected abstract int authorization(String userName);

	protected abstract String connection(String info);

	public String requestConnection(String info) {

		String id, password, userName, decodedInfo, userInfo;

		// 암호화된 정보를 복호화 합니다.
		decodedInfo = doSecurity(info);

		// decodedInfo에서 id 와 password를 추출
		id = "abc";
		password = "abc";

		userInfo = authentication(id, password);

		// userInfo에서 userName을 찾아 냅니다.
		userName = "abc";

		int result = authorization(userName);

		switch (result) {

		case 0:// 무료회원
			break;
		case 1:// 유료회원
			break;
		case 2:// 게임 마스터
			break;
		case 3:// 접속 권한 없음
			break;
		default:
			break;
		}

		return connection(userInfo);
	}
}
