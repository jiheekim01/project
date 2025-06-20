use sakila;

/*
문제 3: 가장 신속한 대여 및 반환 서비스 제공 매장 분석
문제
어떤 매장이 가장 신속하게 대여 및 반환 처리를 하는지 조회
해결 방법
대여 및 반환 간의 시간 차이 계산: AVG(TIMESTAMPDIFF(대여일, 반환일)) 사용
rental_date와 return_date를 사용해 반환까지 걸린 시간을 평균으로 계산.
*/
/*
 * 어떤 매장이 기준이어서 store_id가 필요합니다.
 * 이 때 대여기간의 rental_date하고 return_date가 필요하여 rental 테이블이 필요합니다.
 * 그래서 store 테이블과 customer 테이블과 rental 테이블을 연결해야 합니다.
 * 
 * */
select 
	s.store_id,
	AVG(TIMESTAMPDIFF(HOUR , rental_date, return_date)) AS avg_rental_time
from
	rental r
	inner join customer c on c.customer_id = r.customer_id
	inner join store s on s.store_id = c.store_id
group by
	s.store_id
order by
	s.store_id DESC;

commit;
