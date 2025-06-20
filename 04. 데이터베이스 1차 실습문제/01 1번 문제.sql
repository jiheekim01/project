use sakila;

/*
문제 1: 매장별 월별 매출 분석
문제
매장의 월별 매출 조회.
해결 방법
매장별, 월별 매출 데이터를 집계:
payment 테이블에서 결제 금액을 집계하고, 결제 날짜를 기준으로 월별 데이터를 그룹화.
*/
/*
date_format(컬럼,'%Y-%m-%d') => 2002-01-02
date_format(컬럼,'%Y-%m') => 2002-01
date_format(컬럼,'%Y') => 2002
date_format(컬럼,'%m') => 01
date_format(컬럼,'%d') => 02


**/
SELECT
    store_id,
    DATE_FORMAT(payment_date, '%Y-%m') AS month,
    SUM(p.amount) AS total_revenue
FROM
    payment p
    inner join rental r on p.rental_id = r.rental_id 
    inner join staff s on s.staff_id = r.staff_id 
GROUP BY
    store_id,
    month
ORDER BY
    store_id, month;


commit;