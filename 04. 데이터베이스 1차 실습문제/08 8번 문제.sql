use sakila;

/*
문제 8: 고객의 평균 대여 간격 분석
문제
고객들이 평균적으로 얼마나 자주 영화를 대여하는지 분석하여 평균 대여 시간 가장 짧은 고객 5명 조회.
해결 방법
대여 간격 계산:
동일 고객의 대여 날짜(rental_date)를 기준으로 대여 간격을 계산.
인라인 뷰 사용
*/
/*
 *  rental 테이블에서 rental_id, rental_date, customer_id를 선택
    LEAD 윈도우 함수를 사용하여 각 고객(customer_id)별로 이전 대여일을 cases_lag로 계산
    PARTITION BY customer_id로 각 고객별로 그룹화하고, ORDER BY rental_date로 대여일을 기준으로 정렬
 * */


with cte
as(
SELECT
    rental_id,
    rental_date,
    customer_id,
    lead(rental_date) OVER (
        PARTITION BY customer_id
        ORDER BY rental_date
    ) AS cases_lag
FROM
    rental r
ORDER BY
    customer_id, rental_id, rental_date
 )
 select cte.customer_id, concat(c.first_name,' ',c.last_name), avg(datediff(cte.cases_lag,cte.rental_date)) as time_diff
 from cte
 inner join customer c on c.customer_id = cte.customer_id
 group by cte.customer_id
 order by time_diff
limit 5;

commit;
