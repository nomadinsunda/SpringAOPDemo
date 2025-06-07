package com.intheeast.aspectj.combindedpointcuts.pointcuts;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointcuts {

    // 웹 레이어의 모든 메서드를 매칭하는 포인트컷
    // 포인트컷 표현식에서 web..*의 의미는 다음과 같습니다:
    //
    // web: 패키지 이름을 의미합니다.
    // ..: 현재 패키지와 그 하위 모든 패키지를 포함한다는 의미입니다. 즉, web 패키지뿐만 아니라 web 패키지의 하위 패키지들도 모두 포함됩니다.
    // *: 해당 패키지 안에 있는 모든 클래스와 메서드를 의미합니다.
    // 따라서, web..*는 web 패키지와 그 하위 모든 패키지에 있는 모든 클래스와 메서드가 포인트컷의 대상이 된다는 의미입니다.
    // 예를 들어, com.intheeast.aspectj.combindedpointcuts.web 패키지와 그 하위에 있는 모든 클래스의 메서드들이 이 포인트컷에 포함됩니다.
    @Pointcut("within(com.intheeast.aspectj.combindedpointcuts.web..*)")
    public void inWebLayer() {}

    // 서비스 레이어의 모든 메서드를 매칭하는 포인트컷
    @Pointcut("within(com.intheeast.aspectj.combindedpointcuts.service..*)")
    public void inServiceLayer() {}

    // DAO 레이어의 모든 메서드를 매칭하는 포인트컷
    @Pointcut("within(com.intheeast.aspectj.combindedpointcuts.dao..*)")
    public void inDataAccessLayer() {}

    // 서비스 레이어에 있는 비즈니스 메서드
    // execution(...): 메서드 실행 시점에 포인트컷을 적용한다는 의미입니다. 이 포인트컷은 특정 메서드가 실행될 때 동작합니다.
    //`*`: 반환 타입을 나타냅니다. 여기서 `*`는 모든 반환 타입을 의미합니다. 즉, 어떤 반환 타입의 메서드든지 포인트컷의 대상이 될 수 있습니다.
    // `com.intheeast.aspectj.combindedpointcuts.service.*`: 패키지와 클래스의 경로를 나타냅니다.
    // 여기서 `com.intheeast.aspectj.combindedpointcuts.service.*`는 `service` 패키지 내의 모든 클래스(`*`가 클래스 이름을 의미함)를 의미합니다.
    // `.*`: 클래스 내의 모든 메서드를 의미합니다. 첫 번째 `*`는 클래스 이름을 대체하고, 두 번째 `*`는 클래스 내의 모든 메서드를 대체합니다.
    // `(..)`: 메서드의 매개변수를 나타냅니다. `(..)`는 임의의 매개변수(개수 및 타입 불문)를 의미합니다.
    //따라서, 이 포인트컷 표현식의 전체 의미는:
    //`com.intheeast.aspectj.combindedpointcuts.service` 패키지 내의 모든 클래스의 모든 메서드가 어떤 반환 타입이든,
    // 어떤 매개변수든 상관없이 실행될 때 이 포인트컷이 적용된다**는 것입니다.
    @Pointcut("execution(* com.intheeast.aspectj.combindedpointcuts.service.*.*(..))")
    public void businessService() {}

    // DAO 레이어에 있는 데이터 액세스 메서드
    @Pointcut("execution(* com.intheeast.aspectj.combindedpointcuts.dao.*.*(..))")
    public void dataAccessOperation() {}
}