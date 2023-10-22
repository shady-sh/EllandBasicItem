# Elland-Potion (엘란드온라인 1.20.1 기초아이템 모듈)
## Version

Java 16 버젼 이상을 사용해주세요  
Spigot/Paper Bukkit 1.20.1 버젼을 사용해주세요

## 의존성 플러그인 (아래 플러그인이 서버에 필수로 설치되어야 합니다.)

- EllandMongoDBController (메인시스템을 몽고DB와 연결해주는 플러그인)
- EllandCommon (Utility 메소드 사용 및 언어 연동을 해주는 플러그인)

## 실행 방법

해당 플러그인을 서버 디렉토리에 /plugins 에 넣은 뒤  
Paper 혹은 spigot 버킷으로 실행합니다.  

## 실행 명령어
### `java -Xms3G -Xmx3G -XX:+UseG1GC -XX:+ParallelRefProcEnabled -XX:MaxGCPauseMillis=130 -XX:+UnlockExperimentalVMOptions -XX:+UnlockDiagnosticVMOptions -XX:+DisableExplicitGC -XX:+AlwaysPreTouch -XX:G1NewSizePercent=28 -XX:G1MaxNewSizePercent=40 -XX:G1HeapRegionSize=16M -XX:G1ReservePercent=20 -XX:G1MixedGCCountTarget=3 -XX:InitiatingHeapOccupancyPercent=10 -XX:G1MixedGCLiveThresholdPercent=90 -XX:G1RSetUpdatingPauseTimePercent=0 -XX:SurvivorRatio=32 -XX:+PerfDisableSharedMem -XX:G1SATBBufferEnqueueingThresholdPercent=30 -XX:G1ConcMarkStepDurationMillis=5.0 -XX:G1ConcRSHotCardLimit=16 -XX:MaxTenuringThreshold=1 -XX:G1ConcRefinementServiceIntervalMillis=150 -XX:UseAVX=3 -XX:+UseStringDeduplication -XX:+UseFastUnorderedTimeStamps -XX:+UseAES -XX:GCTimeRatio=99 -XX:+UseAESIntrinsics -XX:UseSSE=4 -XX:+UseFMA -XX:AllocatePrefetchStyle=3 -XX:+UseLoopPredicate -XX:+RangeCheckElimination -XX:+EliminateLocks -XX:+DoEscapeAnalysis -XX:+UseCodeCacheFlushing -XX:+SegmentedCodeCache -XX:+UseFastJNIAccessors -XX:+OptimizeStringConcat -XX:+UseCompressedOops -XX:+UseThreadPriorities -XX:+OmitStackTraceInFastThrow -XX:+TrustFinalNonStaticFields -XX:ThreadPriorityPolicy=1 -XX:+UseInlineCaches -XX:+RewriteBytecodes -XX:+RewriteFrequentPairs -XX:+UseNUMA -XX:-DontCompileHugeMethods -XX:+UseFPUForSpilling -XX:+UseFastStosb -XX:+UseNewLongLShift -XX:+UseVectorCmov -XX:+UseXMMForArrayCopy -XX:+UseXmmI2D -XX:+UseXmmI2F -XX:+UseXmmLoadAndClearUpper -XX:+UseXmmRegToRegMoveAll -XX:+UseLargePages -XX:LargePageSizeInBytes=2m -Xlog:gc+init -Dfile.encoding=UTF-8 -Djava.security.egd=file:/dev/urandom -XX:NmethodSweepActivity=1 -XX:+AlwaysActAsServerClassMachine -XX:ReservedCodeCacheSize=400M -XX:NonNMethodCodeHeapSize=12M -XX:ProfiledCodeHeapSize=194M -XX:NonProfiledCodeHeapSize=194M -XX:MaxNodeLimit=240000 -XX:NodeLimitFudgeFactor=8000 -XX:+UseCriticalJavaThreadPriority --add-modules jdk.incubator.vector -jar paper-1.12.2-1620.jar`
.jar 파일로 된 Spigot/Paper Bukkit을 실행합니다.   

## 플러그인(모듈) 설명
플레이어가 처음 접속 시 지급되는 초기 아이템을 설정하는 모듈입니다.

## 플러그인 명령어

/기초템관리 open - 기초 아이템 셋팅 메뉴를 엽니다.  
/기초템관리 reload - 구성 설정을 재로드합니다.  

## MongoDB Collection 설명
- RpgBasicItem (기초 아이템을 저장하는 Collection)
  ![image](https://github.com/shady-sh/EllandBasicItem/assets/73597679/6e2c51c1-de3e-43b3-85c7-e2dd0e9a5601)
- RpgBasicItemPlayer (플레이어가 처음 접속했는지 데이터를 담아두는곳)
  ![image](https://github.com/shady-sh/EllandBasicItem/assets/73597679/758d0a88-cc50-4378-b659-3e3896f1723a)


## 인게임 실행 사진
![기초템셋팅_사진](https://github.com/shady-sh/EllandBasicItem/assets/73597679/752e9e98-7f4e-4462-b7c0-fdd89792a90e)
- 기초템을 셋팅하는 메뉴

![2023-10-22_12 33 21](https://github.com/shady-sh/EllandBasicItem/assets/73597679/a29bb1bf-f5da-4226-b394-42118d2505bc)
- 플레이어가 첫 접속 했을때 기초템이 지급되는 장면

