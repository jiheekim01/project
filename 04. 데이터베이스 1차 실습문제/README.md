# 문제 1: 매장별 월별 매출 분석

### 문제
매장의 월별 매출 조회.

### 해결 방법
매장별, 월별 매출 데이터를 집계:
- `payment` 테이블에서 결제 금액을 집계하고, 결제 날짜를 기준으로 월별 데이터를 그룹화.

![image](https://github.com/user-attachments/assets/f09a2f2c-b5c3-484e-981d-0bec3b07417c)


---

# 문제 2: 특정 배우가 출연한 영화의 매출 기여도 분석

### 문제
특정 배우(예: "TIM HACKMAN")가 출연한 영화가 총 매출에 얼마나 기여했는지 조회.

### 해결 방법
1. **배우 ID 조회**: `actor` 테이블에서 해당 배우의 ID를 조회.
2. **영화 목록 조회**: `film_actor`와 `film` 테이블을 연결하여 해당 배우가 출연한 영화 목록을 확인.
3. **매출 기여도 계산**: 대여와 결제를 연결하여 총 매출 기여도를 계산.

![image](https://github.com/user-attachments/assets/22b57117-e0af-47c5-8da6-cdd7fd342a6e)


---

# 문제 3: 가장 신속한 대여 및 반환 서비스 제공 매장 분석

### 문제
어떤 매장이 가장 신속하게 대여 및 반환 처리를 하는지 조회.

### 해결 방법
1. **대여 및 반환 간의 시간 차이 계산**: `AVG(TIMESTAMPDIFF(대여일, 반환일))` 사용.
2. `rental_date`와 `return_date`를 사용해 반환까지 걸린 시간을 평균으로 계산.

![image](https://github.com/user-attachments/assets/4658e1f4-576f-49f6-9626-1d3192a162d3)


---

# 문제 4: 대여되지 않은 영화 목록 찾기

### 문제
대여되지 않은 영화 조회.

### 해결 방법
1. **대여된 영화와 대여되지 않은 영화 비교**:
   - `inventory` 테이블과 `rental` 테이블을 조인하여 대여되지 않은 영화를 찾음.

![image](https://github.com/user-attachments/assets/8a06eda4-dca0-4b38-acd7-7729ed36e9cf)

총 43건 조회 되어야함

![image](https://github.com/user-attachments/assets/b899c7c4-bb4a-45b1-86b6-e9a310251a9d)


---

# 문제 5: 고객의 활동성 분석

### 문제
고객의 대여 횟수와 평균 결제 금액을 기반으로 상위 5명의 VIP 고객을 식별 조회.

### 해결 방법
1. **고객별 대여 횟수와 평균 결제 금액 계산**:
   - `rental`과 `payment` 테이블을 조인하여 고객별 데이터를 집계.

![image](https://github.com/user-attachments/assets/02000ae7-d24b-4636-bc64-367eb982d690)


---

# 문제 6: 특정 카테고리의 대여 트렌드 분석

### 문제
특정 카테고리(예: "Action")에 대해 대여 트렌드를 분석하여 월별 대여 횟수 조회.

### 해결 방법
1. **카테고리 ID 조회**: `category` 테이블에서 해당 카테고리 ID를 조회.
2. **월별 대여 횟수 집계**: `film_category`와 `rental`을 연결하여 대여 데이터를 분석.

![image](https://github.com/user-attachments/assets/7ced6b20-34c5-4a67-bc6f-5bbebfb04d51)


---

# 문제 7: 특정 기간 동안 대여된 영화 목록

### 문제
특정 기간(예: 2005년 5월 1일부터 2005년 5월 31일) 동안 5회 대여된 영화 목록과 대여 건수 조회.

### 해결 방법
1. **기간 조건 추가**: `rental_date`를 기준으로 특정 기간에 해당하는 대여 데이터를 필터링.
2. **인라인 뷰 사용**

![image](https://github.com/user-attachments/assets/ee44b02b-ae35-45d4-83a4-ef8c98e0c101)


---

# 문제 8: 고객의 평균 대여 간격 분석

### 문제
고객들이 평균적으로 얼마나 자주 영화를 대여하는지 분석하여 평균 대여 시간 가장 짧은 고객 5명 조회.

### 해결 방법
1. **대여 간격 계산**: 동일 고객의 대여 날짜(`rental_date`)를 기준으로 대여 간격을 계산.
2. **인라인 뷰 사용**

![image](https://github.com/user-attachments/assets/dca44da3-9a24-4630-a3d0-8df3622f3096)

