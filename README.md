# **Soldier Management System WITH Community**
___
## **주제**
___
#### '병력 관리 & 지원 어플리케이션'



## **개요**
___
> - 군인들을 대상으로 전반적인 서비스를 제공하고 불필요한 행정 소요와 인력 낭비를 줄인다. 주된 기능은 다음과 같다.
>> 1. 출타 병력의 보고 / 관리 간편화
>> 2. 마이페이지 (휴가 관리 및 행정 정보 제공)
>> 3. 군 전용 커뮤니티 
> - 군인들이 사용하는 어플리케이션인 만큼 `보안성` 을 가장 중요한 요소로 설계하였으며, 특별한 방법의 인증절차를 통하여 어플리케이션 사용이 가능하다. ( 인터넷 서버와 국방망 서버를 독립적으로 운용한다. )



## **개발 배경**
___
> - **출타 장병 관리의 비효율성**
>#### 현재 출타 복귀 병사들은 복귀 제한시간까지 수차례 담당 간부에게로 부터 보고 요청을 받는다. 담당 간부에 따라 그 시간이 규칙적이지 않고 횟수도 달라서 병사들은 계속해서 연락을 기다리며 긴장하고 있어야 한다. 담당 관리자(간부) 또한 매 시간마다 출타 병사들의 상황을 확인하기위해 수차례 연락을 해야한다.
> - **병사 소통의 공간 부재**
>#### 현재까지 군인만 참여 가능한, 군인들이 함께 모여 소통할수 있는 커뮤니티는 없었다. 소통의 장이 없었기 때문에  군인들을 위한 데이터가 수집, 활용되기 힘들었고 같은 고민거리가 있는 사람들 끼리 만나서 함께 고민을 나눌 수 있는 방법이 없었따.
## **활용성**
___
> - 출타 장병들은 손쉽게 복귀 보고륵, 관리자는 장병들의 보고 리스트를 종합적으로 관리 가능하다. 여기에 이용하는 보고 및 종합 관리 기능을 활용하면 추후에 `긴급 보고`, `고속상황전파체계`, `실시간 상황 보고 및 계획하달`  등의 기능을 추가로 구현 가능하다. 
> - 커뮤니티의 경우 인근 지역 부대의 게시판을 관리하여 여러 부대가 함께 동아리와 종교와 같은 홀동에 대해 모집, 홍보를 할 수 있다.



## **개발효과**
___
> - **새로운 군 자료 전송 절차 제안**
>####  현재 국방부는 국방망과 인터넷망이 철저하게 분리되어 있다. 최고의 보안이 필요한 군대이기 때문에 현재 두 망 사이에서는 데이터를 교환기 위해서는 대부분 수작업을 통한 자료교환이 이루어졌다. 위 어플리케이션에서 사용하는 데이터 전송 방법은 기존의 문제점을 해결하고 보안성을 높이는 방법으로, 앞으로 군 자료교환 체계에 활용 가능할 것으로 기대된다.
> - **출타 관리의 간편화**
>####  간단한 조작을 통해 출타 장병들의 복귀 보고가 가능하다. 관리자(간부)는 복귀일을 기준으로 병사들의 보고를 종합하여 받을 수 있고 최소한의 연락만으로 효율적으로 출타 장병들을 관리할 수 있다. 기존에는 병사 개개인당 수차례씩 전화를 하는 불편함이 있었지만, 해당 어플을 활용하면 불필요한 노력을 최소한으로 줄일 수 있고 관리자(간부)의 생산성과 업무 집중도를 높일 수 있다.
>  - **군 전용 커뮤니티 활성화**
> #### 해당 어플리케이션은 군인만 이용가능한 군 전용 커뮤니티를 제공한다. 군인만사용하기 때문에 군인에게 도움이 되고 정말 필요한 정보들이 공유되고 수집될 것으로 기대된다.
>> -  자기 개발
>> #### 커뮤니티 기능을 활용하여 자기 개발에 필요한 여러 정보들을 공유할 수 있고, 목표가 유사한 사람들끼리 함께 모이는 기회를 제공할 수 있다.
>> -  동아리, 종교 모임
>> #### 인근 지역 부대의 게시판을 관리하여 여러 부대가 함께 동아리와 종교와 같은 홀동에 대해 모집, 홍보를 할 수 있다.
>> -  복지, 생활환경 개선
>> #### 출타했을 때 군인을 위한 커뮤니티가 없어 숙박 장소, 편의 시설, 출타 시 꿀팁 등 군인에게 꼭 필요한 정보들을 서로 공유 가능하다. 


## **결론**
___
> - 해당 어플리케이션은 불필요한 행정 소유와 인력낭비는 줄이고, 병사들 상호간 소통과 자기개발의 기회를 넓혀줄 것으로 기대된다. 


## **기능설명**
___
> - 메인 화면
> 
>  ![image1](https://bitbucket.org/osam2018/images/raw/7265f6329d6e20d39f3e001a5aec8f5e7cb22512/%ED%99%94%EB%A9%B41.jpg)

> - 로그인 / 회원가입
>>   - 회원 가입을 하기 위해서는 개인 인증용으로 사전에 부여받은 key code 값이 필하다. key code 값을 이용하여 국방망 사용자 리스트와 인터넷 사용자 리스트를 매칭시킨다. 
> 
>  ![image2](https://bitbucket.org/osam2018/images/raw/7265f6329d6e20d39f3e001a5aec8f5e7cb22512/%ED%99%94%EB%A9%B42.JPG)
>  ![image3](https://bitbucket.org/osam2018/images/raw/7265f6329d6e20d39f3e001a5aec8f5e7cb22512/%ED%99%94%EB%A9%B43.JPG)

> - 출타 보고 / 관리
>>   - 사용자 계정 유형에 따라 출타 탭을 눌렀을때 뜨는 화면이 달라진다. 병사가 사용했을 때 좌측 화면이, 관리자가 사용할 때는 우측 화면이 나타난다. 
>>   - **병사용**(좌측) 출타 기간과 복귀 예정시간을 설정할 수 있다. 설정한 날짜와 시간은 서버로 전송된다. 현재까지 나간 출타 일수와 출타 정보, 병기본 등급, 상.벌점 등 개인의 행정적 정보를 함꼐 표시한다. 이후에 SNS에 공유할 수 있는 기능을 추가하여 모범적인 군생활을 SNS에 공유할 수 있도록 만들고, 군생활에 뿌듯함을 느끼며 군장병 서로에게 동기부여가 될 수 있도록 한다.
>>   - **관리자용**(우측) 종합된 병사들의 출타 정보를 보여준다. 복귀 예정시간별로 병사들의 정보를 확인 할 수 있어서 각 시간대별 몇명이 복귀할지 미리 확인할 수 있다. 병사들의 출타 예정사항을 주별, 월별로 미리 확인할수 있다. 
>
>  ![image4](https://bitbucket.org/osam2018/images/raw/7265f6329d6e20d39f3e001a5aec8f5e7cb22512/%ED%99%94%EB%A9%B44.JPG)
>  ![image5](https://bitbucket.org/osam2018/images/raw/7265f6329d6e20d39f3e001a5aec8f5e7cb22512/%ED%99%94%EB%A9%B45.JPG)
>

> - 커뮤니티 게시판
>>   - 원하는 분야를 선택해서 해당 영역의 게시물 확인 및 작성을 할 수 있고, 관심있는 게시물에는 댓글을 달 수 있다. 동아리 활동/모집, 취미활동 공유에도 활용될 수 있다.
> 
>  ![image8](https://bitbucket.org/osam2018/images/raw/7265f6329d6e20d39f3e001a5aec8f5e7cb22512/%ED%99%94%EB%A9%B48.JPG)
>  ![image9](https://bitbucket.org/osam2018/images/raw/7265f6329d6e20d39f3e001a5aec8f5e7cb22512/%ED%99%94%EB%A9%B49.JPG)
>  ![image10](https://bitbucket.org/osam2018/images/raw/7265f6329d6e20d39f3e001a5aec8f5e7cb22512/%ED%99%94%EB%A9%B410.JPG)
>

> - 사용자 정보 확인 / 변경
>>   - 사용자 계정 정보, 버젼 등을 확인할 수 있으며 필요한 경우 수정할 수 있다.
>
>  ![image6](https://bitbucket.org/osam2018/images/raw/7265f6329d6e20d39f3e001a5aec8f5e7cb22512/%ED%99%94%EB%A9%B46.JPG)
>  ![image7](https://bitbucket.org/osam2018/images/raw/7265f6329d6e20d39f3e001a5aec8f5e7cb22512/%ED%99%94%EB%A9%B47.JPG)




## **자세한 설명**
___
> - 인트라넷 사용자와 인터넷 사용자를 연결하기 위한 연동 페이지
> 
>  ![image11](https://bitbucket.org/osam2018/images/raw/7265f6329d6e20d39f3e001a5aec8f5e7cb22512/%ED%99%94%EB%A9%B411.JPG)

