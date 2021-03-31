# Web_JDBC


  1. JDBC API 생성
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    try{
  2. 드라이버 로딩
    Class.forName("oracle.jdbc.OracleDriver");
    System.out.println("Oracle 로딩");

  3. 연결 객체
    conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.76:1521:xe","bituser","1004");
    System.out.println("연결 여부 (false) 연결됨 : " + conn.isClosed());

  4. 명령 객체 생성
    stmt = conn.createStatement();

  4.1 parameter 설정(옵션)
    String job = "";
    Scanner sc = new Scanner(System.in);
    System.out.println("직종 입력 : ");
    job = sc.nextLine();

  4.2 명령 구문 생성
    String sql = "select empno, ename, job from emp where job ='" + job + "'";
    where job ='CLERK';

  5. 명령실행
    DQL(select) > stmt.executeQuery(sql) > return ResultSet 타입의 객체 주소 
    DML(insert. delete, update) > 결과 집합(x) > return 반영된 행의 개수 > stmt.excuteUpdate()
    delete from emp; 실행 return 14

    rs = stmt.executeQuery(sql);


  6. 명령처리 
  
  DQL (select) : 1. 결과가 없는 경우 (where empno=1111)
           2. 결과가 1건일 경우 (PK, Unique 컬럼 조회 : where empno=7788)
           3. 결과가 여러건일 경우 ( select empno, ename from emp where deptno=20)
  
  1. 간단하고 단순한 방법
  단점은 결과집합이 없는 경우 로직처리가 안된다
    while(rs.next()){   // next = 결과 row가 있는지 확인 
    rs.getInt("empno") 출력 
    }
  2. 결과가 있는 경우와 없는 경우 처리
  단점은 1건만 조회 가능
    if(rs.next()){
      rs.getInt("empno") 출력
    }else{
      조회된 데이터가 없다
    }

 1번과 2번을 합친다
 -single row
 -multi row
 -결과가 없는 경우
  if(rs.next()){

    do{
      System.out.println(rs.getInt("empno") + "/" + rs.getString("ename") + "/" + rs.getString("job"));
    }while(rs.next());


  }else{
    System.out.println("조회된 데이터가 없습니다");
  }

  }catch(Exception e){
  System.out.println(e.getMessage());
  }finally{
  // 자원해제
  try{
    stmt.close();
    rs.close();
    conn.close();
  }catch(Exception e){

  }
  }
