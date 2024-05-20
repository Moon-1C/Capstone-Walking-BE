# 신호등 주기 계산하기
***
## Example Data
***
**스케줄러의 주기를 60s**로 가정하였을 때 **연속된 두 번의 요청**에 대해 발생하는 상황에 대해 이야기합니다.
### 신호 데이터

| 신호 | red 유지시간 | green 유지시간 |
|:--:|:--------:|:----------:|
| A  |   70s    |    40s     |
| B  |   50s    |    30s     |
| C  |   40s    |    20s     |

### Before
| 신호 |  상태   | 잔여시간 |
|:----:|:-----:|:----:|
| A  |  red  | 50s  |
| B  | green | 30s  |
| C  | green | 10s  |

### After
* before 에서 60s가 지난 후 받아온 데이터

| 신호 | 상태    | 잔여시간 |
|:----:|:-----:|:----:|
| A  | green | 30s  |
| B  | stop  | 20s  |
| C  | green | 10s  |

## 알 수 있는 사실
***
### Before와 After의 신호가 달라진 경우(예시 데이터의 A와 B)
* after의 신호 상태에 대한 유지시간을 알 수 있다.
  * `after 신호 상태 잔여시간 + (스케줄러 주기 - before 신호 상태의 잔여시간)`
  * ex) 신호 A에 대하여
    * `30s + (60s - 50s) = 40s`
    * 따라서 A의 After 상태인 green은 40s 간 지속된다.

### Before와 After의 신호가 똑같은 경우
* 얻을 수 있는 정보가 없음

## 정리
***
* 한 신호등에 대하여 초록불과 빨간불의 주기를 모두 알기 위해서는
연속된 두 번의 요청에서 각각 (빨간불 -> 초록불), (초록불 -> 빨간불)이 발생하는 지점을 찾으면 된다.